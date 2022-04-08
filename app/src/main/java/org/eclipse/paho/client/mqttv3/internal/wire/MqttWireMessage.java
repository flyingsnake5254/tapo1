package org.eclipse.paho.client.mqttv3.internal.wire;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistable;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.ExceptionHelper;

/* loaded from: classes4.dex */
public abstract class MqttWireMessage {
    private static final long FOUR_BYTE_INT_MAX = 4294967295L;
    public static final byte MESSAGE_TYPE_CONNACK = 2;
    public static final byte MESSAGE_TYPE_CONNECT = 1;
    public static final byte MESSAGE_TYPE_DISCONNECT = 14;
    public static final byte MESSAGE_TYPE_PINGREQ = 12;
    public static final byte MESSAGE_TYPE_PINGRESP = 13;
    public static final byte MESSAGE_TYPE_PUBACK = 4;
    public static final byte MESSAGE_TYPE_PUBCOMP = 7;
    public static final byte MESSAGE_TYPE_PUBLISH = 3;
    public static final byte MESSAGE_TYPE_PUBREC = 5;
    public static final byte MESSAGE_TYPE_PUBREL = 6;
    public static final byte MESSAGE_TYPE_SUBACK = 9;
    public static final byte MESSAGE_TYPE_SUBSCRIBE = 8;
    public static final byte MESSAGE_TYPE_UNSUBACK = 11;
    public static final byte MESSAGE_TYPE_UNSUBSCRIBE = 10;
    private static final int VARIABLE_BYTE_INT_MAX = 268435455;
    protected boolean duplicate = false;
    protected int msgId = 0;
    private MqttToken token;
    private byte type;
    protected static final Charset STRING_ENCODING = StandardCharsets.UTF_8;
    private static final String[] PACKET_NAMES = {"reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT"};

    public MqttWireMessage(byte b2) {
        this.type = b2;
    }

    public static MqttWireMessage createWireMessage(MqttPersistable mqttPersistable) throws MqttException {
        byte[] payloadBytes = mqttPersistable.getPayloadBytes();
        if (payloadBytes == null) {
            payloadBytes = new byte[0];
        }
        return createWireMessage(new MultiByteArrayInputStream(mqttPersistable.getHeaderBytes(), mqttPersistable.getHeaderOffset(), mqttPersistable.getHeaderLength(), payloadBytes, mqttPersistable.getPayloadOffset(), mqttPersistable.getPayloadLength()));
    }

    public static String decodeUTF8(DataInputStream dataInputStream) throws MqttException {
        try {
            byte[] bArr = new byte[dataInputStream.readUnsignedShort()];
            dataInputStream.readFully(bArr);
            String str = new String(bArr, STRING_ENCODING);
            validateUTF8String(str);
            return str;
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    public static byte[] encodeMBI(long j) {
        validateVariableByteInt((int) j);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        do {
            byte b2 = (byte) (j % 128);
            j /= 128;
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 > 0) {
                b2 = (byte) (b2 | DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE);
            }
            byteArrayOutputStream.write(b2);
            i++;
            if (i2 <= 0) {
                break;
            }
        } while (i < 4);
        return byteArrayOutputStream.toByteArray();
    }

    public static void encodeUTF8(DataOutputStream dataOutputStream, String str) throws MqttException {
        validateUTF8String(str);
        try {
            byte[] bytes = str.getBytes(STRING_ENCODING);
            dataOutputStream.write((byte) ((bytes.length >>> 8) & 255));
            dataOutputStream.write((byte) ((bytes.length >>> 0) & 255));
            dataOutputStream.write(bytes);
        } catch (UnsupportedEncodingException e2) {
            throw new MqttException(e2);
        } catch (IOException e3) {
            throw new MqttException(e3);
        }
    }

    public static MultiByteInteger readMBI(DataInputStream dataInputStream) throws IOException {
        byte readByte;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        do {
            readByte = dataInputStream.readByte();
            i++;
            i2 += (readByte & Byte.MAX_VALUE) * i3;
            i3 *= 128;
        } while ((readByte & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) != 0);
        if (i2 >= 0 && i2 <= VARIABLE_BYTE_INT_MAX) {
            return new MultiByteInteger(i2, i);
        }
        throw new IOException("This property must be a number between 0 and 268435455. Read value was: " + i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (r3 == 65534) goto L_0x0059;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r2 > 64991) goto L_0x0057;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void validateUTF8String(java.lang.String r7) throws java.lang.IllegalArgumentException {
        /*
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r7.length()
            if (r1 < r2) goto L_0x0009
            return
        L_0x0009:
            char r2 = r7.charAt(r1)
            boolean r3 = java.lang.Character.isHighSurrogate(r2)
            r4 = 65534(0xfffe, float:9.1833E-41)
            r5 = 1
            if (r3 == 0) goto L_0x003b
            int r1 = r1 + 1
            int r3 = r7.length()
            if (r1 != r3) goto L_0x0020
            goto L_0x0059
        L_0x0020:
            char r3 = r7.charAt(r1)
            boolean r6 = java.lang.Character.isLowSurrogate(r3)
            if (r6 == 0) goto L_0x002b
            goto L_0x0059
        L_0x002b:
            r6 = r2 & 1023(0x3ff, float:1.434E-42)
            int r6 = r6 << 10
            r3 = r3 & 1023(0x3ff, float:1.434E-42)
            r3 = r3 | r6
            r6 = 65535(0xffff, float:9.1834E-41)
            r3 = r3 & r6
            if (r3 == r6) goto L_0x0059
            if (r3 != r4) goto L_0x0057
            goto L_0x0059
        L_0x003b:
            boolean r3 = java.lang.Character.isISOControl(r2)
            if (r3 != 0) goto L_0x0059
            boolean r3 = java.lang.Character.isLowSurrogate(r2)
            if (r3 == 0) goto L_0x0048
            goto L_0x0059
        L_0x0048:
            r3 = 64976(0xfdd0, float:9.1051E-41)
            if (r2 < r3) goto L_0x0057
            if (r2 == r4) goto L_0x0059
            if (r2 >= r3) goto L_0x0059
            r3 = 64991(0xfddf, float:9.1072E-41)
            if (r2 > r3) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r3 = 0
            goto L_0x005a
        L_0x0059:
            r3 = 1
        L_0x005a:
            if (r3 != 0) goto L_0x005e
            int r1 = r1 + r5
            goto L_0x0002
        L_0x005e:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1[r0] = r2
            java.lang.String r0 = "Invalid UTF-8 char: [%x]"
            java.lang.String r0 = java.lang.String.format(r0, r1)
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage.validateUTF8String(java.lang.String):void");
    }

    public static void validateVariableByteInt(int i) throws IllegalArgumentException {
        if (i < 0 || i > VARIABLE_BYTE_INT_MAX) {
            throw new IllegalArgumentException("This property must be a number between 0 and 268435455");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] encodeMessageId() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(this.msgId);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    public byte[] getHeader() throws MqttException {
        try {
            int type = ((getType() & BinaryMemcacheOpcodes.PREPEND) << 4) ^ (getMessageInfo() & BinaryMemcacheOpcodes.PREPEND);
            byte[] variableHeader = getVariableHeader();
            int length = variableHeader.length + getPayload().length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(type);
            dataOutputStream.write(encodeMBI(length));
            dataOutputStream.write(variableHeader);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    public String getKey() {
        return Integer.toString(getMessageId());
    }

    public int getMessageId() {
        return this.msgId;
    }

    protected abstract byte getMessageInfo();

    public byte[] getPayload() throws MqttException {
        return new byte[0];
    }

    public MqttToken getToken() {
        return this.token;
    }

    public byte getType() {
        return this.type;
    }

    protected abstract byte[] getVariableHeader() throws MqttException;

    public boolean isMessageIdRequired() {
        return true;
    }

    public boolean isRetryable() {
        return false;
    }

    public void setDuplicate(boolean z) {
        this.duplicate = z;
    }

    public void setMessageId(int i) {
        this.msgId = i;
    }

    public void setToken(MqttToken mqttToken) {
        this.token = mqttToken;
    }

    public String toString() {
        return PACKET_NAMES[this.type];
    }

    public static MqttWireMessage createWireMessage(byte[] bArr) throws MqttException {
        return createWireMessage(new ByteArrayInputStream(bArr));
    }

    private static MqttWireMessage createWireMessage(InputStream inputStream) throws MqttException {
        try {
            CountingInputStream countingInputStream = new CountingInputStream(inputStream);
            DataInputStream dataInputStream = new DataInputStream(countingInputStream);
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            byte b2 = (byte) (readUnsignedByte >> 4);
            byte b3 = (byte) (readUnsignedByte & 15);
            long counter = (countingInputStream.getCounter() + readMBI(dataInputStream).getValue()) - countingInputStream.getCounter();
            byte[] bArr = new byte[0];
            if (counter > 0) {
                int i = (int) counter;
                byte[] bArr2 = new byte[i];
                dataInputStream.readFully(bArr2, 0, i);
                bArr = bArr2;
            }
            if (b2 == 1) {
                return new MqttConnect(b3, bArr);
            }
            if (b2 == 3) {
                return new MqttPublish(b3, bArr);
            }
            if (b2 == 4) {
                return new MqttPubAck(b3, bArr);
            }
            if (b2 == 7) {
                return new MqttPubComp(b3, bArr);
            }
            if (b2 == 2) {
                return new MqttConnack(b3, bArr);
            }
            if (b2 == 12) {
                return new MqttPingReq(b3, bArr);
            }
            if (b2 == 13) {
                return new MqttPingResp(b3, bArr);
            }
            if (b2 == 8) {
                return new MqttSubscribe(b3, bArr);
            }
            if (b2 == 9) {
                return new MqttSuback(b3, bArr);
            }
            if (b2 == 10) {
                return new MqttUnsubscribe(b3, bArr);
            }
            if (b2 == 11) {
                return new MqttUnsubAck(b3, bArr);
            }
            if (b2 == 6) {
                return new MqttPubRel(b3, bArr);
            }
            if (b2 == 5) {
                return new MqttPubRec(b3, bArr);
            }
            if (b2 == 14) {
                return new MqttDisconnect(b3, bArr);
            }
            throw ExceptionHelper.createMqttException(6);
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }
}
