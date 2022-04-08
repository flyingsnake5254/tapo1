package com.google.android.exoplayer2.o2.k0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.f0;
import com.google.android.exoplayer2.o2.k0.i;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: OpusReader.java */
/* loaded from: classes.dex */
final class h extends i {
    private static final byte[] n = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean o;

    private long n(byte[] bArr) {
        int i = bArr[0] & 255;
        int i2 = i & 3;
        int i3 = 2;
        if (i2 == 0) {
            i3 = 1;
        } else if (!(i2 == 1 || i2 == 2)) {
            i3 = bArr[1] & 63;
        }
        int i4 = i >> 3;
        int i5 = i4 & 3;
        return i3 * (i4 >= 16 ? 2500 << i5 : i4 >= 12 ? 10000 << (i5 & 1) : i5 == 3 ? 60000 : 10000 << i5);
    }

    public static boolean o(d0 d0Var) {
        int a = d0Var.a();
        byte[] bArr = n;
        if (a < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        d0Var.j(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.exoplayer2.o2.k0.i
    protected long f(d0 d0Var) {
        return c(n(d0Var.d()));
    }

    @Override // com.google.android.exoplayer2.o2.k0.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected boolean i(d0 d0Var, long j, i.b bVar) {
        boolean z = true;
        if (!this.o) {
            byte[] copyOf = Arrays.copyOf(d0Var.d(), d0Var.f());
            int c2 = f0.c(copyOf);
            bVar.a = new Format.b().e0("audio/opus").H(c2).f0(48000).T(f0.a(copyOf)).E();
            this.o = true;
            return true;
        }
        g.e(bVar.a);
        if (d0Var.n() != 1332770163) {
            z = false;
        }
        d0Var.P(0);
        return z;
    }

    @Override // com.google.android.exoplayer2.o2.k0.i
    protected void l(boolean z) {
        super.l(z);
        if (z) {
            this.o = false;
        }
    }
}
