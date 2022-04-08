package org.eclipse.paho.client.mqttv3;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

/* loaded from: classes4.dex */
public class ScheduledExecutorPingSender implements MqttPingSender {
    private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.ScheduledExecutorPingSender";
    private String clientid;
    private ClientComms comms;
    private ScheduledExecutorService executorService;
    private final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ScheduledFuture scheduledFuture;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class PingRunnable implements Runnable {
        private static final String methodName = "PingTask.run";

        private PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String name = Thread.currentThread().getName();
            Thread currentThread = Thread.currentThread();
            currentThread.setName("MQTT Ping: " + ScheduledExecutorPingSender.this.clientid);
            ScheduledExecutorPingSender.this.log.fine(ScheduledExecutorPingSender.CLASS_NAME, methodName, "660", new Object[]{Long.valueOf(System.nanoTime())});
            ScheduledExecutorPingSender.this.comms.checkForActivity();
            Thread.currentThread().setName(name);
        }

        /* synthetic */ PingRunnable(ScheduledExecutorPingSender scheduledExecutorPingSender, PingRunnable pingRunnable) {
            this();
        }
    }

    public ScheduledExecutorPingSender(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService != null) {
            this.executorService = scheduledExecutorService;
            return;
        }
        throw new IllegalArgumentException("ExecutorService cannot be null.");
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public void init(ClientComms clientComms) {
        if (clientComms != null) {
            this.comms = clientComms;
            this.clientid = clientComms.getClient().getClientId();
            return;
        }
        throw new IllegalArgumentException("ClientComms cannot be null.");
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public void schedule(long j) {
        this.scheduledFuture = this.executorService.schedule(new PingRunnable(this, null), j, TimeUnit.MILLISECONDS);
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public void start() {
        this.log.fine(CLASS_NAME, "start", "659", new Object[]{this.clientid});
        schedule(this.comms.getKeepAlive());
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public void stop() {
        this.log.fine(CLASS_NAME, "stop", "661", null);
        ScheduledFuture scheduledFuture = this.scheduledFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }
}
