package org.bouncycastle.crypto.r;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.f;
import org.bouncycastle.crypto.w.c0;

/* loaded from: classes4.dex */
public class a implements org.bouncycastle.crypto.a {
    private SecureRandom a;

    /* renamed from: b  reason: collision with root package name */
    private org.bouncycastle.crypto.a f17167b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17168c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17169d;
    private byte[] h;

    /* renamed from: f  reason: collision with root package name */
    private int f17171f = -1;
    private byte[] g = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17170e = j();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.bouncycastle.crypto.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0337a implements PrivilegedAction {
        C0337a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return System.getProperty("org.bouncycastle.pkcs1.strict");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements PrivilegedAction {
        b() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return System.getProperty("org.bouncycastle.pkcs1.not_strict");
        }
    }

    public a(org.bouncycastle.crypto.a aVar) {
        this.f17167b = aVar;
    }

    private static int e(byte[] bArr, int i) {
        int i2 = 0 | (bArr[0] ^ 2);
        int i3 = i + 1;
        int length = bArr.length - i3;
        for (int i4 = 1; i4 < length; i4++) {
            byte b2 = bArr[i4];
            int i5 = b2 | (b2 >> 1);
            int i6 = i5 | (i5 >> 2);
            i2 |= ((i6 | (i6 >> 4)) & 1) - 1;
        }
        int i7 = bArr[bArr.length - i3] | i2;
        int i8 = i7 | (i7 >> 1);
        int i9 = i8 | (i8 >> 2);
        return ~(((i9 | (i9 >> 4)) & 1) - 1);
    }

    private byte[] f(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.f17171f != -1) {
            return g(bArr, i, i2);
        }
        byte[] d2 = this.f17167b.d(bArr, i, i2);
        boolean z = true;
        boolean z2 = this.f17170e & (d2.length != this.f17167b.b());
        if (d2.length < b()) {
            d2 = this.h;
        }
        byte b2 = d2[0];
        boolean z3 = !this.f17169d ? b2 != 1 : b2 != 2;
        int i3 = i(b2, d2) + 1;
        if (i3 >= 10) {
            z = false;
        }
        if (z3 || z) {
            org.bouncycastle.util.a.u(d2, (byte) 0);
            throw new InvalidCipherTextException("block incorrect");
        } else if (!z2) {
            int length = d2.length - i3;
            byte[] bArr2 = new byte[length];
            System.arraycopy(d2, i3, bArr2, 0, length);
            return bArr2;
        } else {
            org.bouncycastle.util.a.u(d2, (byte) 0);
            throw new InvalidCipherTextException("block incorrect size");
        }
    }

    private byte[] g(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.f17169d) {
            byte[] d2 = this.f17167b.d(bArr, i, i2);
            byte[] bArr2 = this.g;
            if (bArr2 == null) {
                bArr2 = new byte[this.f17171f];
                this.a.nextBytes(bArr2);
            }
            if (this.f17170e && (d2.length != this.f17167b.b())) {
                d2 = this.h;
            }
            int e2 = e(d2, this.f17171f);
            byte[] bArr3 = new byte[this.f17171f];
            int i3 = 0;
            while (true) {
                int i4 = this.f17171f;
                if (i3 < i4) {
                    bArr3[i3] = (byte) ((d2[(d2.length - i4) + i3] & (~e2)) | (bArr2[i3] & e2));
                    i3++;
                } else {
                    org.bouncycastle.util.a.u(d2, (byte) 0);
                    return bArr3;
                }
            }
        } else {
            throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
        }
    }

    private byte[] h(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (i2 <= c()) {
            int c2 = this.f17167b.c();
            byte[] bArr2 = new byte[c2];
            if (this.f17169d) {
                bArr2[0] = 1;
                for (int i3 = 1; i3 != (c2 - i2) - 1; i3++) {
                    bArr2[i3] = -1;
                }
            } else {
                this.a.nextBytes(bArr2);
                bArr2[0] = 2;
                for (int i4 = 1; i4 != (c2 - i2) - 1; i4++) {
                    while (bArr2[i4] == 0) {
                        bArr2[i4] = (byte) this.a.nextInt();
                    }
                }
            }
            int i5 = c2 - i2;
            bArr2[i5 - 1] = 0;
            System.arraycopy(bArr, i, bArr2, i5, i2);
            return this.f17167b.d(bArr2, 0, c2);
        }
        throw new IllegalArgumentException("input data too large");
    }

    private int i(byte b2, byte[] bArr) throws InvalidCipherTextException {
        boolean z = false;
        int i = -1;
        for (int i2 = 1; i2 != bArr.length; i2++) {
            byte b3 = bArr[i2];
            if ((b3 == 0) && (i < 0)) {
                i = i2;
            }
            z |= (b3 != -1) & (b2 == 1) & (i < 0);
        }
        if (z) {
            return -1;
        }
        return i;
    }

    private boolean j() {
        String str = (String) AccessController.doPrivileged(new C0337a());
        String str2 = (String) AccessController.doPrivileged(new b());
        return str2 != null ? !str2.equals("true") : str == null || str.equals("true");
    }

    @Override // org.bouncycastle.crypto.a
    public void a(boolean z, e eVar) {
        org.bouncycastle.crypto.w.b bVar;
        if (eVar instanceof c0) {
            c0 c0Var = (c0) eVar;
            this.a = c0Var.b();
            bVar = (org.bouncycastle.crypto.w.b) c0Var.a();
        } else {
            bVar = (org.bouncycastle.crypto.w.b) eVar;
            if (!bVar.a() && z) {
                this.a = f.b();
            }
        }
        this.f17167b.a(z, eVar);
        this.f17169d = bVar.a();
        this.f17168c = z;
        this.h = new byte[this.f17167b.b()];
        if (this.f17171f > 0 && this.g == null && this.a == null) {
            throw new IllegalArgumentException("encoder requires random");
        }
    }

    @Override // org.bouncycastle.crypto.a
    public int b() {
        int b2 = this.f17167b.b();
        return this.f17168c ? b2 : b2 - 10;
    }

    @Override // org.bouncycastle.crypto.a
    public int c() {
        int c2 = this.f17167b.c();
        return this.f17168c ? c2 - 10 : c2;
    }

    @Override // org.bouncycastle.crypto.a
    public byte[] d(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        return this.f17168c ? h(bArr, i, i2) : f(bArr, i, i2);
    }
}
