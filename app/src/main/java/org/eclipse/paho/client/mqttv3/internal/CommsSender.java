package org.eclipse.paho.client.mqttv3.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttDisconnect;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttOutputStream;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

/* loaded from: classes4.dex */
public class CommsSender implements Runnable {
    private static final String CLASS_NAME = CommsSender.class.getName();
    private ClientComms clientComms;
    private ClientState clientState;
    private State current_state;
    private MqttOutputStream out;
    private Future<?> senderFuture;
    private State target_state;
    private String threadName;
    private CommsTokenStore tokenStore;
    private Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private final Object lifecycle = new Object();
    private Thread sendThread = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum State {
        STOPPED,
        RUNNING,
        STARTING
    }

    public CommsSender(ClientComms clientComms, ClientState clientState, CommsTokenStore commsTokenStore, OutputStream outputStream) {
        State state = State.STOPPED;
        this.current_state = state;
        this.target_state = state;
        this.clientState = null;
        this.clientComms = null;
        this.tokenStore = null;
        this.out = new MqttOutputStream(clientState, outputStream);
        this.clientComms = clientComms;
        this.clientState = clientState;
        this.tokenStore = commsTokenStore;
        this.log.setResourceName(clientComms.getClient().getClientId());
    }

    private void handleRunException(MqttWireMessage mqttWireMessage, Exception exc) {
        MqttException mqttException;
        this.log.fine(CLASS_NAME, "handleRunException", "804", null, exc);
        if (!(exc instanceof MqttException)) {
            mqttException = new MqttException(32109, exc);
        } else {
            mqttException = (MqttException) exc;
        }
        synchronized (this.lifecycle) {
            this.target_state = State.STOPPED;
        }
        this.clientComms.shutdownConnection(null, mqttException);
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.lifecycle) {
            State state = this.current_state;
            State state2 = State.RUNNING;
            z = state == state2 && this.target_state == state2;
        }
        return z;
    }

    @Override // java.lang.Runnable
    public void run() {
        State state;
        State state2;
        Thread currentThread = Thread.currentThread();
        this.sendThread = currentThread;
        currentThread.setName(this.threadName);
        synchronized (this.lifecycle) {
            this.current_state = State.RUNNING;
        }
        try {
            synchronized (this.lifecycle) {
                state = this.target_state;
            }
            MqttWireMessage mqttWireMessage = null;
            while (state == State.RUNNING && this.out != null) {
                try {
                    mqttWireMessage = this.clientState.get();
                    if (mqttWireMessage != null) {
                        this.log.fine(CLASS_NAME, "run", "802", new Object[]{mqttWireMessage.getKey(), mqttWireMessage});
                        if (mqttWireMessage instanceof MqttAck) {
                            this.out.write(mqttWireMessage);
                            this.out.flush();
                        } else {
                            MqttToken token = mqttWireMessage.getToken();
                            if (token == null) {
                                token = this.tokenStore.getToken(mqttWireMessage);
                            }
                            if (token != null) {
                                synchronized (token) {
                                    this.out.write(mqttWireMessage);
                                    try {
                                        this.out.flush();
                                    } catch (IOException e2) {
                                        if (!(mqttWireMessage instanceof MqttDisconnect)) {
                                            throw e2;
                                        }
                                    }
                                    this.clientState.notifySent(mqttWireMessage);
                                }
                            }
                        }
                    } else {
                        this.log.fine(CLASS_NAME, "run", "803");
                        synchronized (this.lifecycle) {
                            this.target_state = State.STOPPED;
                        }
                    }
                } catch (MqttException e3) {
                    handleRunException(mqttWireMessage, e3);
                } catch (Exception e4) {
                    handleRunException(mqttWireMessage, e4);
                }
                synchronized (this.lifecycle) {
                    state2 = this.target_state;
                }
                state = state2;
            }
            synchronized (this.lifecycle) {
                this.current_state = State.STOPPED;
                this.sendThread = null;
            }
            this.log.fine(CLASS_NAME, "run", "805");
        } catch (Throwable th) {
            synchronized (this.lifecycle) {
                this.current_state = State.STOPPED;
                this.sendThread = null;
                throw th;
            }
        }
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        synchronized (this.lifecycle) {
            State state = this.current_state;
            State state2 = State.STOPPED;
            if (state == state2 && this.target_state == state2) {
                this.target_state = State.RUNNING;
                if (executorService == null) {
                    new Thread(this).start();
                } else {
                    this.senderFuture = executorService.submit(this);
                }
            }
        }
        while (!isRunning()) {
            try {
                Thread.sleep(100L);
            } catch (Exception unused) {
            }
        }
    }

    public void stop() {
        if (isRunning()) {
            synchronized (this.lifecycle) {
                Future<?> future = this.senderFuture;
                if (future != null) {
                    future.cancel(true);
                }
                this.log.fine(CLASS_NAME, "stop", "800");
                if (isRunning()) {
                    this.target_state = State.STOPPED;
                    this.clientState.notifyQueueLock();
                }
            }
            while (isRunning()) {
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
                this.clientState.notifyQueueLock();
            }
            this.log.fine(CLASS_NAME, "stop", "801");
        }
    }
}
