package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes4.dex */
public class MqttPubRec extends MqttAck {
    public MqttPubRec(byte b2, byte[] bArr) throws IOException {
        super((byte) 5);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    protected byte[] getVariableHeader() throws MqttException {
        return encodeMessageId();
    }

    public MqttPubRec(MqttPublish mqttPublish) {
        super((byte) 5);
        this.msgId = mqttPublish.getMessageId();
    }
}
