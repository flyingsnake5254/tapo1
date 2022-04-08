package org.eclipse.paho.client.mqttv3.internal.wire;

import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/* loaded from: classes4.dex */
public class MqttConnect extends MqttWireMessage {
    public static final String KEY = "Con";
    private boolean cleanSession;
    private String clientId;
    private int keepAliveInterval;
    private int mqttVersion;
    private char[] password;
    private String userName;
    private String willDestination;
    private MqttMessage willMessage;

    public MqttConnect(byte b2, byte[] bArr) throws IOException, MqttException {
        super((byte) 1);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        MqttWireMessage.decodeUTF8(dataInputStream);
        dataInputStream.readByte();
        dataInputStream.readByte();
        this.keepAliveInterval = dataInputStream.readUnsignedShort();
        this.clientId = MqttWireMessage.decodeUTF8(dataInputStream);
        dataInputStream.close();
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    public String getKey() {
        return "Con";
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    protected byte getMessageInfo() {
        return (byte) 0;
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    public byte[] getPayload() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            MqttWireMessage.encodeUTF8(dataOutputStream, this.clientId);
            if (this.willMessage != null) {
                MqttWireMessage.encodeUTF8(dataOutputStream, this.willDestination);
                dataOutputStream.writeShort(this.willMessage.getPayload().length);
                dataOutputStream.write(this.willMessage.getPayload());
            }
            String str = this.userName;
            if (str != null) {
                MqttWireMessage.encodeUTF8(dataOutputStream, str);
                if (this.password != null) {
                    MqttWireMessage.encodeUTF8(dataOutputStream, new String(this.password));
                }
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    protected byte[] getVariableHeader() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int i = this.mqttVersion;
            if (i == 3) {
                MqttWireMessage.encodeUTF8(dataOutputStream, "MQIsdp");
            } else if (i == 4) {
                MqttWireMessage.encodeUTF8(dataOutputStream, "MQTT");
            }
            dataOutputStream.write(this.mqttVersion);
            byte b2 = 0;
            if (this.cleanSession) {
                b2 = (byte) 2;
            }
            MqttMessage mqttMessage = this.willMessage;
            if (mqttMessage != null) {
                b2 = (byte) (((byte) (b2 | 4)) | (mqttMessage.getQos() << 3));
                if (this.willMessage.isRetained()) {
                    b2 = (byte) (b2 | 32);
                }
            }
            if (this.userName != null) {
                b2 = (byte) (b2 | DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE);
                if (this.password != null) {
                    b2 = (byte) (b2 | 64);
                }
            }
            dataOutputStream.write(b2);
            dataOutputStream.writeShort(this.keepAliveInterval);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    public boolean isCleanSession() {
        return this.cleanSession;
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    public boolean isMessageIdRequired() {
        return false;
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    public String toString() {
        return String.valueOf(super.toString()) + " clientId " + this.clientId + " keepAliveInterval " + this.keepAliveInterval;
    }

    public MqttConnect(String str, int i, boolean z, int i2, String str2, char[] cArr, MqttMessage mqttMessage, String str3) {
        super((byte) 1);
        this.clientId = str;
        this.cleanSession = z;
        this.keepAliveInterval = i2;
        this.userName = str2;
        if (cArr != null) {
            this.password = (char[]) cArr.clone();
        }
        this.willMessage = mqttMessage;
        this.willDestination = str3;
        this.mqttVersion = i;
    }
}
