package org.bouncycastle.asn1;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.bouncycastle.util.a;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes4.dex */
public abstract class b extends q implements w {

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f16689c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: d  reason: collision with root package name */
    protected final byte[] f16690d;

    /* renamed from: f  reason: collision with root package name */
    protected final int f16691f;

    public b(byte[] bArr, int i) {
        Objects.requireNonNull(bArr, "data cannot be null");
        if (bArr.length == 0 && i != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        } else if (i > 7 || i < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        } else {
            this.f16690d = a.g(bArr);
            this.f16691f = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] m(byte[] bArr, int i) {
        byte[] g = a.g(bArr);
        if (i > 0) {
            int length = bArr.length - 1;
            g[length] = (byte) ((255 << i) & g[length]);
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b n(int i, InputStream inputStream) throws IOException {
        if (i >= 1) {
            int read = inputStream.read();
            int i2 = i - 1;
            byte[] bArr = new byte[i2];
            if (i2 != 0) {
                if (org.bouncycastle.util.io.b.c(inputStream, bArr) != i2) {
                    throw new EOFException("EOF encountered in middle of BIT STRING");
                } else if (read > 0 && read < 8) {
                    int i3 = i2 - 1;
                    if (bArr[i3] != ((byte) (bArr[i3] & (255 << read)))) {
                        return new m1(bArr, read);
                    }
                }
            }
            return new n0(bArr, read);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    @Override // org.bouncycastle.asn1.q
    protected boolean f(q qVar) {
        if (!(qVar instanceof b)) {
            return false;
        }
        b bVar = (b) qVar;
        return this.f16691f == bVar.f16691f && a.c(o(), bVar.o());
    }

    @Override // org.bouncycastle.asn1.w
    public String getString() {
        StringBuffer stringBuffer = new StringBuffer(MqttTopic.MULTI_LEVEL_WILDCARD);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new p(byteArrayOutputStream).j(this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i = 0; i != byteArray.length; i++) {
                char[] cArr = f16689c;
                stringBuffer.append(cArr[(byteArray[i] >>> 4) & 15]);
                stringBuffer.append(cArr[byteArray[i] & BinaryMemcacheOpcodes.PREPEND]);
            }
            return stringBuffer.toString();
        } catch (IOException e2) {
            throw new ASN1ParsingException("Internal error encoding BitString: " + e2.getMessage(), e2);
        }
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        return this.f16691f ^ a.w(o());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public q k() {
        return new n0(this.f16690d, this.f16691f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public q l() {
        return new m1(this.f16690d, this.f16691f);
    }

    public byte[] o() {
        return m(this.f16690d, this.f16691f);
    }

    public byte[] p() {
        if (this.f16691f == 0) {
            return a.g(this.f16690d);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public int q() {
        return this.f16691f;
    }

    public String toString() {
        return getString();
    }
}
