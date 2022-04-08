package io.netty.handler.codec.mqtt;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class MqttConnectPayload {
    private final String clientIdentifier;
    private final byte[] password;
    private final String userName;
    private final byte[] willMessage;
    private final String willTopic;

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MqttConnectPayload(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r7 = this;
            java.nio.charset.Charset r0 = io.netty.util.CharsetUtil.UTF_8
            byte[] r4 = r10.getBytes(r0)
            byte[] r6 = r12.getBytes(r0)
            r1 = r7
            r2 = r8
            r3 = r9
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.mqtt.MqttConnectPayload.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public String clientIdentifier() {
        return this.clientIdentifier;
    }

    @Deprecated
    public String password() {
        if (this.password == null) {
            return null;
        }
        return new String(this.password, CharsetUtil.UTF_8);
    }

    public byte[] passwordInBytes() {
        return this.password;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[clientIdentifier=" + this.clientIdentifier + ", willTopic=" + this.willTopic + ", willMessage=" + Arrays.toString(this.willMessage) + ", userName=" + this.userName + ", password=" + Arrays.toString(this.password) + ']';
    }

    public String userName() {
        return this.userName;
    }

    @Deprecated
    public String willMessage() {
        if (this.willMessage == null) {
            return null;
        }
        return new String(this.willMessage, CharsetUtil.UTF_8);
    }

    public byte[] willMessageInBytes() {
        return this.willMessage;
    }

    public String willTopic() {
        return this.willTopic;
    }

    public MqttConnectPayload(String str, String str2, byte[] bArr, String str3, byte[] bArr2) {
        this.clientIdentifier = str;
        this.willTopic = str2;
        this.willMessage = bArr;
        this.userName = str3;
        this.password = bArr2;
    }
}
