package org.eclipse.paho.client.mqttv3.internal.wire;

/* loaded from: classes4.dex */
public abstract class MqttAck extends MqttWireMessage {
    public MqttAck(byte b2) {
        super(b2);
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    protected byte getMessageInfo() {
        return (byte) 0;
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    public String toString() {
        return String.valueOf(super.toString()) + " msgId " + this.msgId;
    }
}