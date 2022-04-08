package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class a extends q {

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f16678c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f16679d;

    /* renamed from: f  reason: collision with root package name */
    protected final byte[] f16680f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(boolean z, int i, byte[] bArr) {
        this.f16678c = z;
        this.f16679d = i;
        this.f16680f = org.bouncycastle.util.a.g(bArr);
    }

    public static a o(Object obj) {
        if (obj == null || (obj instanceof a)) {
            return (a) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return o(q.i((byte[]) obj));
            } catch (IOException e2) {
                throw new IllegalArgumentException("Failed to construct object from byte[]: " + e2.getMessage());
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    private byte[] q(int i, byte[] bArr) throws IOException {
        int i2;
        if ((bArr[0] & 31) == 31) {
            i2 = 2;
            int i3 = bArr[1] & 255;
            if ((i3 & 127) != 0) {
                while (i3 >= 0 && (i3 & 128) != 0) {
                    i2++;
                    i3 = bArr[i2] & 255;
                }
            } else {
                throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            }
        } else {
            i2 = 1;
        }
        int length = (bArr.length - i2) + 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i2, bArr2, 1, length - 1);
        bArr2[0] = (byte) i;
        return bArr2;
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (!(qVar instanceof a)) {
            return false;
        }
        a aVar = (a) qVar;
        return this.f16678c == aVar.f16678c && this.f16679d == aVar.f16679d && org.bouncycastle.util.a.c(this.f16680f, aVar.f16680f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.f(this.f16678c ? 96 : 64, this.f16679d, this.f16680f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() throws IOException {
        return y1.b(this.f16679d) + y1.a(this.f16680f.length) + this.f16680f.length;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        boolean z = this.f16678c;
        return ((z ? 1 : 0) ^ this.f16679d) ^ org.bouncycastle.util.a.w(this.f16680f);
    }

    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return this.f16678c;
    }

    public int m() {
        return this.f16679d;
    }

    public byte[] n() {
        return org.bouncycastle.util.a.g(this.f16680f);
    }

    public q p(int i) throws IOException {
        if (i < 31) {
            byte[] d2 = d();
            byte[] q = q(i, d2);
            if ((d2[0] & 32) != 0) {
                q[0] = (byte) (q[0] | 32);
            }
            return q.i(q);
        }
        throw new IOException("unsupported tag number");
    }
}
