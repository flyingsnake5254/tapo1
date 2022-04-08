package org.eclipse.paho.client.mqttv3.internal;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttInputStream;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

/* loaded from: classes4.dex */
public class CommsReceiver implements Runnable {
    private static final String CLASS_NAME = CommsReceiver.class.getName();
    private ClientComms clientComms;
    private ClientState clientState;
    private State current_state;
    private MqttInputStream in;
    private Future<?> receiverFuture;
    private State target_state;
    private String threadName;
    private CommsTokenStore tokenStore;
    private Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private final Object lifecycle = new Object();
    private Thread recThread = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum State {
        STOPPED,
        RUNNING,
        STARTING,
        RECEIVING
    }

    public CommsReceiver(ClientComms clientComms, ClientState clientState, CommsTokenStore commsTokenStore, InputStream inputStream) {
        State state = State.STOPPED;
        this.current_state = state;
        this.target_state = state;
        this.clientState = null;
        this.clientComms = null;
        this.tokenStore = null;
        this.in = new MqttInputStream(clientState, inputStream);
        this.clientComms = clientComms;
        this.clientState = clientState;
        this.tokenStore = commsTokenStore;
        this.log.setResourceName(clientComms.getClient().getClientId());
    }

    public boolean isReceiving() {
        boolean z;
        synchronized (this.lifecycle) {
            z = this.current_state == State.RECEIVING;
        }
        return z;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.lifecycle) {
            State state = this.current_state;
            State state2 = State.RUNNING;
            z = (state == state2 || state == State.RECEIVING) && this.target_state == state2;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0134, code lost:
        r1 = r9.lifecycle;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0136, code lost:
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0137, code lost:
        r9.current_state = org.eclipse.paho.client.mqttv3.internal.CommsReceiver.State.STOPPED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x013b, code lost:
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x013c, code lost:
        r9.recThread = null;
        r9.log.fine(org.eclipse.paho.client.mqttv3.internal.CommsReceiver.CLASS_NAME, "run", "854");
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0149, code lost:
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.paho.client.mqttv3.internal.CommsReceiver.run():void");
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        this.log.fine(CLASS_NAME, "start", "855");
        synchronized (this.lifecycle) {
            State state = this.current_state;
            State state2 = State.STOPPED;
            if (state == state2 && this.target_state == state2) {
                this.target_state = State.RUNNING;
                if (executorService == null) {
                    new Thread(this).start();
                } else {
                    this.receiverFuture = executorService.submit(this);
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
        synchronized (this.lifecycle) {
            Future<?> future = this.receiverFuture;
            if (future != null) {
                future.cancel(true);
            }
            this.log.fine(CLASS_NAME, "stop", "850");
            if (isRunning()) {
                this.target_state = State.STOPPED;
            }
        }
        while (isRunning()) {
            try {
                Thread.sleep(100L);
            } catch (Exception unused) {
            }
        }
        this.log.fine(CLASS_NAME, "stop", "851");
    }
}
