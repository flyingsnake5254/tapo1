package com.google.android.exoplayer2.o2.k0;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.d0;
import com.google.android.exoplayer2.o2.k0.i;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: VorbisReader.java */
/* loaded from: classes.dex */
final class j extends i {
    @Nullable
    private a n;
    private int o;
    private boolean p;
    @Nullable
    private d0.d q;
    @Nullable
    private d0.b r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VorbisReader.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final d0.d a;

        /* renamed from: b  reason: collision with root package name */
        public final d0.b f2866b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f2867c;

        /* renamed from: d  reason: collision with root package name */
        public final d0.c[] f2868d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2869e;

        public a(d0.d dVar, d0.b bVar, byte[] bArr, d0.c[] cVarArr, int i) {
            this.a = dVar;
            this.f2866b = bVar;
            this.f2867c = bArr;
            this.f2868d = cVarArr;
            this.f2869e = i;
        }
    }

    @VisibleForTesting
    static void n(com.google.android.exoplayer2.util.d0 d0Var, long j) {
        if (d0Var.b() < d0Var.f() + 4) {
            d0Var.M(Arrays.copyOf(d0Var.d(), d0Var.f() + 4));
        } else {
            d0Var.O(d0Var.f() + 4);
        }
        byte[] d2 = d0Var.d();
        d2[d0Var.f() - 4] = (byte) (j & 255);
        d2[d0Var.f() - 3] = (byte) ((j >>> 8) & 255);
        d2[d0Var.f() - 2] = (byte) ((j >>> 16) & 255);
        d2[d0Var.f() - 1] = (byte) ((j >>> 24) & 255);
    }

    private static int o(byte b2, a aVar) {
        if (!aVar.f2868d[p(b2, aVar.f2869e, 1)].a) {
            return aVar.a.g;
        }
        return aVar.a.h;
    }

    @VisibleForTesting
    static int p(byte b2, int i, int i2) {
        return (b2 >> i2) & (255 >>> (8 - i));
    }

    public static boolean r(com.google.android.exoplayer2.util.d0 d0Var) {
        try {
            return d0.l(1, d0Var, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.o2.k0.i
    public void e(long j) {
        super.e(j);
        int i = 0;
        this.p = j != 0;
        d0.d dVar = this.q;
        if (dVar != null) {
            i = dVar.g;
        }
        this.o = i;
    }

    @Override // com.google.android.exoplayer2.o2.k0.i
    protected long f(com.google.android.exoplayer2.util.d0 d0Var) {
        int i = 0;
        if ((d0Var.d()[0] & 1) == 1) {
            return -1L;
        }
        int o = o(d0Var.d()[0], (a) g.i(this.n));
        if (this.p) {
            i = (this.o + o) / 4;
        }
        long j = i;
        n(d0Var, j);
        this.p = true;
        this.o = o;
        return j;
    }

    @Override // com.google.android.exoplayer2.o2.k0.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected boolean i(com.google.android.exoplayer2.util.d0 d0Var, long j, i.b bVar) throws IOException {
        if (this.n != null) {
            g.e(bVar.a);
            return false;
        }
        a q = q(d0Var);
        this.n = q;
        if (q == null) {
            return true;
        }
        d0.d dVar = q.a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.j);
        arrayList.add(q.f2867c);
        bVar.a = new Format.b().e0("audio/vorbis").G(dVar.f2665e).Z(dVar.f2664d).H(dVar.f2662b).f0(dVar.f2663c).T(arrayList).E();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.o2.k0.i
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    @Nullable
    @VisibleForTesting
    a q(com.google.android.exoplayer2.util.d0 d0Var) throws IOException {
        d0.d dVar = this.q;
        if (dVar == null) {
            this.q = d0.j(d0Var);
            return null;
        }
        d0.b bVar = this.r;
        if (bVar == null) {
            this.r = d0.h(d0Var);
            return null;
        }
        byte[] bArr = new byte[d0Var.f()];
        System.arraycopy(d0Var.d(), 0, bArr, 0, d0Var.f());
        d0.c[] k = d0.k(d0Var, dVar.f2662b);
        return new a(dVar, bVar, bArr, k, d0.a(k.length - 1));
    }
}
