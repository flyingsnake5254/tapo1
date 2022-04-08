package com.google.android.exoplayer2.o2.e0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.f;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: AmrExtractor.java */
/* loaded from: classes.dex */
public final class b implements j {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2674c;

    /* renamed from: f  reason: collision with root package name */
    private static final int f2677f;
    private final byte[] g;
    private final int h;
    private boolean i;
    private long j;
    private int k;
    private int l;
    private boolean m;
    private long n;
    private int o;
    private int p;
    private long q;
    private l r;
    private b0 s;
    private y t;
    private boolean u;
    public static final o a = a.f2672b;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2673b = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f2675d = o0.e0("#!AMR\n");

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f2676e = o0.e0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f2674c = iArr;
        f2677f = iArr[8];
    }

    public b() {
        this(0);
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void a() {
        g.i(this.s);
        o0.i(this.r);
    }

    private static int f(int i, long j) {
        return (int) (((i * 8) * 1000000) / j);
    }

    private y g(long j) {
        return new f(j, this.n, f(this.o, 20000L), this.o);
    }

    private int h(int i) throws ParserException {
        if (j(i)) {
            return this.i ? f2674c[i] : f2673b[i];
        }
        String str = this.i ? "WB" : "NB";
        StringBuilder sb = new StringBuilder(str.length() + 35);
        sb.append("Illegal AMR ");
        sb.append(str);
        sb.append(" frame type ");
        sb.append(i);
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }

    private boolean i(int i) {
        return !this.i && (i < 12 || i > 14);
    }

    private boolean j(int i) {
        return i >= 0 && i <= 15 && (k(i) || i(i));
    }

    private boolean k(int i) {
        return this.i && (i < 10 || i > 13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ j[] l() {
        return new j[]{new b()};
    }

    @RequiresNonNull({"trackOutput"})
    private void m() {
        if (!this.u) {
            this.u = true;
            boolean z = this.i;
            this.s.d(new Format.b().e0(z ? "audio/amr-wb" : "audio/3gpp").W(f2677f).H(1).f0(z ? 16000 : 8000).E());
        }
    }

    @RequiresNonNull({"extractorOutput"})
    private void n(long j, int i) {
        int i2;
        if (!this.m) {
            if ((this.h & 1) == 0 || j == -1 || !((i2 = this.o) == -1 || i2 == this.k)) {
                y.b bVar = new y.b(-9223372036854775807L);
                this.t = bVar;
                this.r.o(bVar);
                this.m = true;
            } else if (this.p >= 20 || i == -1) {
                y g = g(j);
                this.t = g;
                this.r.o(g);
                this.m = true;
            }
        }
    }

    private static boolean o(k kVar, byte[] bArr) throws IOException {
        kVar.e();
        byte[] bArr2 = new byte[bArr.length];
        kVar.n(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int p(k kVar) throws IOException {
        kVar.e();
        kVar.n(this.g, 0, 1);
        byte b2 = this.g[0];
        if ((b2 & 131) <= 0) {
            return h((b2 >> 3) & 15);
        }
        StringBuilder sb = new StringBuilder(42);
        sb.append("Invalid padding bits for frame header ");
        sb.append((int) b2);
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }

    private boolean q(k kVar) throws IOException {
        byte[] bArr = f2675d;
        if (o(kVar, bArr)) {
            this.i = false;
            kVar.l(bArr.length);
            return true;
        }
        byte[] bArr2 = f2676e;
        if (!o(kVar, bArr2)) {
            return false;
        }
        this.i = true;
        kVar.l(bArr2.length);
        return true;
    }

    @RequiresNonNull({"trackOutput"})
    private int r(k kVar) throws IOException {
        if (this.l == 0) {
            try {
                int p = p(kVar);
                this.k = p;
                this.l = p;
                if (this.o == -1) {
                    this.n = kVar.getPosition();
                    this.o = this.k;
                }
                if (this.o == this.k) {
                    this.p++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int b2 = this.s.b(kVar, this.l, true);
        if (b2 == -1) {
            return -1;
        }
        int i = this.l - b2;
        this.l = i;
        if (i > 0) {
            return 0;
        }
        this.s.e(this.q + this.j, 1, this.k, 0, null);
        this.j += 20000;
        return 0;
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void b(l lVar) {
        this.r = lVar;
        this.s = lVar.t(0, 1);
        lVar.r();
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void c(long j, long j2) {
        this.j = 0L;
        this.k = 0;
        this.l = 0;
        if (j != 0) {
            y yVar = this.t;
            if (yVar instanceof f) {
                this.q = ((f) yVar).c(j);
                return;
            }
        }
        this.q = 0L;
    }

    @Override // com.google.android.exoplayer2.o2.j
    public boolean d(k kVar) throws IOException {
        return q(kVar);
    }

    @Override // com.google.android.exoplayer2.o2.j
    public int e(k kVar, x xVar) throws IOException {
        a();
        if (kVar.getPosition() != 0 || q(kVar)) {
            m();
            int r = r(kVar);
            n(kVar.a(), r);
            return r;
        }
        throw ParserException.createForMalformedContainer("Could not find AMR header.", null);
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void release() {
    }

    public b(int i) {
        this.h = i;
        this.g = new byte[1];
        this.o = -1;
    }
}
