package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.w.a0;

/* loaded from: classes4.dex */
public class f extends e {
    private int[] o = null;
    private int[] p = null;
    private int[] q = null;
    private boolean r;

    @Override // org.bouncycastle.crypto.c
    public void a(boolean z, e eVar) {
        if (eVar instanceof a0) {
            byte[] a = ((a0) eVar).a();
            if (a.length == 24 || a.length == 16) {
                this.r = z;
                byte[] bArr = new byte[8];
                System.arraycopy(a, 0, bArr, 0, 8);
                this.o = e(z, bArr);
                byte[] bArr2 = new byte[8];
                System.arraycopy(a, 8, bArr2, 0, 8);
                this.p = e(!z, bArr2);
                if (a.length == 24) {
                    byte[] bArr3 = new byte[8];
                    System.arraycopy(a, 16, bArr3, 0, 8);
                    this.q = e(z, bArr3);
                    return;
                }
                this.q = this.o;
                return;
            }
            throw new IllegalArgumentException("key size must be 16 or 24 bytes.");
        }
        throw new IllegalArgumentException("invalid parameter passed to DESede init - " + eVar.getClass().getName());
    }

    @Override // org.bouncycastle.crypto.c
    public String b() {
        return "DESede";
    }

    @Override // org.bouncycastle.crypto.c
    public int d(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = this.o;
        if (iArr == null) {
            throw new IllegalStateException("DESede engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            byte[] bArr3 = new byte[8];
            if (this.r) {
                c(iArr, bArr, i, bArr3, 0);
                c(this.p, bArr3, 0, bArr3, 0);
                c(this.q, bArr3, 0, bArr2, i2);
            } else {
                c(this.q, bArr, i, bArr3, 0);
                c(this.p, bArr3, 0, bArr3, 0);
                c(this.o, bArr3, 0, bArr2, i2);
            }
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.bouncycastle.crypto.c
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.c
    public void reset() {
    }
}
