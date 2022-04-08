package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.haproxy.HAProxyTLV;
import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class HAProxySSLTLV extends HAProxyTLV {
    private final byte clientBitField;
    private final List<HAProxyTLV> tlvs;
    private final int verify;

    public HAProxySSLTLV(int i, byte b2, List<HAProxyTLV> list) {
        this(i, b2, list, Unpooled.EMPTY_BUFFER);
    }

    public byte client() {
        return this.clientBitField;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.handler.codec.haproxy.HAProxyTLV
    public int contentNumBytes() {
        int i = 0;
        for (int i2 = 0; i2 < this.tlvs.size(); i2++) {
            i += this.tlvs.get(i2).totalNumBytes();
        }
        return i + 5;
    }

    public List<HAProxyTLV> encapsulatedTLVs() {
        return this.tlvs;
    }

    public boolean isPP2ClientCertConn() {
        return (this.clientBitField & 2) != 0;
    }

    public boolean isPP2ClientCertSess() {
        return (this.clientBitField & 4) != 0;
    }

    public boolean isPP2ClientSSL() {
        return (this.clientBitField & 1) != 0;
    }

    @Override // io.netty.handler.codec.haproxy.HAProxyTLV, io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return StringUtil.simpleClassName(this) + "(type: " + type() + ", typeByteValue: " + ((int) typeByteValue()) + ", client: " + ((int) client()) + ", verify: " + verify() + ", numEncapsulatedTlvs: " + this.tlvs.size() + ')';
    }

    public int verify() {
        return this.verify;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HAProxySSLTLV(int i, byte b2, List<HAProxyTLV> list, ByteBuf byteBuf) {
        super(HAProxyTLV.Type.PP2_TYPE_SSL, (byte) 32, byteBuf);
        this.verify = i;
        this.tlvs = Collections.unmodifiableList(list);
        this.clientBitField = b2;
    }
}
