package io.netty.handler.ssl;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.security.PrivateKey;

/* loaded from: classes3.dex */
public final class PemPrivateKey extends AbstractReferenceCounted implements PrivateKey, PemEncoded {
    private static final byte[] BEGIN_PRIVATE_KEY;
    private static final byte[] END_PRIVATE_KEY;
    private static final String PKCS8_FORMAT = "PKCS#8";
    private static final long serialVersionUID = 7978017465645018936L;
    private final ByteBuf content;

    static {
        Charset charset = CharsetUtil.US_ASCII;
        BEGIN_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n".getBytes(charset);
        END_PRIVATE_KEY = "\n-----END PRIVATE KEY-----\n".getBytes(charset);
    }

    private PemPrivateKey(ByteBuf byteBuf) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, FirebaseAnalytics.Param.CONTENT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PemEncoded toPEM(ByteBufAllocator byteBufAllocator, boolean z, PrivateKey privateKey) {
        if (privateKey instanceof PemEncoded) {
            return ((PemEncoded) privateKey).retain();
        }
        byte[] encoded = privateKey.getEncoded();
        if (encoded != null) {
            return toPEM(byteBufAllocator, z, encoded);
        }
        throw new IllegalArgumentException(privateKey.getClass().getName() + " does not support encoding");
    }

    public static PemPrivateKey valueOf(byte[] bArr) {
        return valueOf(Unpooled.wrappedBuffer(bArr));
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        int refCnt = refCnt();
        if (refCnt > 0) {
            return this.content;
        }
        throw new IllegalReferenceCountException(refCnt);
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        SslUtils.zerooutAndRelease(this.content);
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        release(refCnt());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.Key
    public String getFormat() {
        return PKCS8_FORMAT;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return refCnt() == 0;
    }

    @Override // io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return true;
    }

    public static PemPrivateKey valueOf(ByteBuf byteBuf) {
        return new PemPrivateKey(byteBuf);
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemPrivateKey copy() {
        return replace(this.content.copy());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemPrivateKey duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemPrivateKey replace(ByteBuf byteBuf) {
        return new PemPrivateKey(byteBuf);
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemPrivateKey retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    static PemEncoded toPEM(ByteBufAllocator byteBufAllocator, boolean z, byte[] bArr) {
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(bArr);
        try {
            ByteBuf base64 = SslUtils.toBase64(byteBufAllocator, wrappedBuffer);
            byte[] bArr2 = BEGIN_PRIVATE_KEY;
            int length = bArr2.length + base64.readableBytes();
            byte[] bArr3 = END_PRIVATE_KEY;
            int length2 = length + bArr3.length;
            ByteBuf directBuffer = z ? byteBufAllocator.directBuffer(length2) : byteBufAllocator.buffer(length2);
            directBuffer.writeBytes(bArr2);
            directBuffer.writeBytes(base64);
            directBuffer.writeBytes(bArr3);
            PemValue pemValue = new PemValue(directBuffer, true);
            SslUtils.zerooutAndRelease(base64);
            return pemValue;
        } finally {
            SslUtils.zerooutAndRelease(wrappedBuffer);
        }
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemPrivateKey retain() {
        return (PemPrivateKey) super.retain();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemPrivateKey touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemPrivateKey retain(int i) {
        return (PemPrivateKey) super.retain(i);
    }

    @Override // io.netty.util.ReferenceCounted
    public PemPrivateKey touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
