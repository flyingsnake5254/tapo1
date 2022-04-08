package org.eclipse.paho.client.mqttv3.internal;

/* loaded from: classes4.dex */
public class SystemHighResolutionTimer implements HighResolutionTimer {
    @Override // org.eclipse.paho.client.mqttv3.internal.HighResolutionTimer
    public long nanoTime() {
        return System.nanoTime();
    }
}
