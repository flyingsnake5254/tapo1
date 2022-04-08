package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.m;
import org.bouncycastle.crypto.w.a0;

/* loaded from: classes4.dex */
public class g implements m {
    private byte[] a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f17082b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f17083c = 0;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f17084d = null;

    private void b(byte[] bArr) {
        this.f17084d = bArr;
        this.f17082b = 0;
        this.f17083c = 0;
        if (this.a == null) {
            this.a = new byte[256];
        }
        for (int i = 0; i < 256; i++) {
            this.a[i] = (byte) i;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            byte[] bArr2 = this.a;
            i3 = ((bArr[i2] & 255) + bArr2[i4] + i3) & 255;
            byte b2 = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b2;
            i2 = (i2 + 1) % bArr.length;
        }
    }

    @Override // org.bouncycastle.crypto.m
    public void a(boolean z, e eVar) {
        if (eVar instanceof a0) {
            byte[] a = ((a0) eVar).a();
            this.f17084d = a;
            b(a);
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to RC4 init - " + eVar.getClass().getName());
    }

    @Override // org.bouncycastle.crypto.m
    public int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = (this.f17082b + 1) & 255;
                this.f17082b = i5;
                byte[] bArr3 = this.a;
                int i6 = (bArr3[i5] + this.f17083c) & 255;
                this.f17083c = i6;
                byte b2 = bArr3[i5];
                bArr3[i5] = bArr3[i6];
                bArr3[i6] = b2;
                bArr2[i4 + i3] = (byte) (bArr3[(bArr3[i5] + bArr3[i6]) & 255] ^ bArr[i4 + i]);
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }
}
