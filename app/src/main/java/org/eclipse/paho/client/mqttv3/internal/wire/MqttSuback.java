package org.eclipse.paho.client.mqttv3.internal.wire;

import com.tplink.libtpmediastatistics.SSLClient;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes4.dex */
public class MqttSuback extends MqttAck {
    private int[] grantedQos;

    public MqttSuback(byte b2, byte[] bArr) throws IOException {
        super((byte) 9);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        this.grantedQos = new int[bArr.length - 2];
        int i = 0;
        for (int read = dataInputStream.read(); read != -1; read = dataInputStream.read()) {
            this.grantedQos[i] = read;
            i++;
        }
        dataInputStream.close();
    }

    public int[] getGrantedQos() {
        return this.grantedQos;
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    protected byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttAck, org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    public String toString() {
        int[] iArr;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" granted Qos");
        for (int i : this.grantedQos) {
            stringBuffer.append(SSLClient.WHITE_SPACE);
            stringBuffer.append(i);
        }
        return stringBuffer.toString();
    }
}
