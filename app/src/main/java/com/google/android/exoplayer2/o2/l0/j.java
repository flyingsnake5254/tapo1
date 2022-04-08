package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.f;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: AdtsExtractor.java */
/* loaded from: classes.dex */
public final class j implements com.google.android.exoplayer2.o2.j {
    public static final o a = c.f2887b;

    /* renamed from: b  reason: collision with root package name */
    private final int f2939b;

    /* renamed from: c  reason: collision with root package name */
    private final k f2940c;

    /* renamed from: d  reason: collision with root package name */
    private final d0 f2941d;

    /* renamed from: e  reason: collision with root package name */
    private final d0 f2942e;

    /* renamed from: f  reason: collision with root package name */
    private final c0 f2943f;
    private l g;
    private long h;
    private long i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;

    public j() {
        this(0);
    }

    private void a(k kVar) throws IOException {
        int h;
        if (!this.k) {
            this.j = -1;
            kVar.e();
            long j = 0;
            if (kVar.getPosition() == 0) {
                j(kVar);
            }
            int i = 0;
            i = 0;
            do {
                try {
                    if (!kVar.c(this.f2942e.d(), 0, 2, true)) {
                        break;
                    }
                    this.f2942e.P(0);
                    if (!k.m(this.f2942e.J())) {
                        break;
                    } else if (!kVar.c(this.f2942e.d(), 0, 4, true)) {
                        break;
                    } else {
                        this.f2943f.p(14);
                        h = this.f2943f.h(13);
                        if (h > 6) {
                            j += h;
                            i++;
                            if (i == 1000) {
                                break;
                            }
                        } else {
                            this.k = true;
                            throw ParserException.createForMalformedContainer("Malformed ADTS stream", null);
                        }
                    }
                } catch (EOFException unused) {
                }
            } while (kVar.m(h - 6, true));
            kVar.e();
            if (i > 0) {
                this.j = (int) (j / i);
            } else {
                this.j = -1;
            }
            this.k = true;
        }
    }

    private static int f(int i, long j) {
        return (int) (((i * 8) * 1000000) / j);
    }

    private y g(long j) {
        return new f(j, this.i, f(this.j, this.f2940c.k()), this.j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.android.exoplayer2.o2.j[] h() {
        return new com.google.android.exoplayer2.o2.j[]{new j()};
    }

    @RequiresNonNull({"extractorOutput"})
    private void i(long j, boolean z, boolean z2) {
        if (!this.m) {
            boolean z3 = z && this.j > 0;
            if (!z3 || this.f2940c.k() != -9223372036854775807L || z2) {
                if (!z3 || this.f2940c.k() == -9223372036854775807L) {
                    this.g.o(new y.b(-9223372036854775807L));
                } else {
                    this.g.o(g(j));
                }
                this.m = true;
            }
        }
    }

    private int j(k kVar) throws IOException {
        int i = 0;
        while (true) {
            kVar.n(this.f2942e.d(), 0, 10);
            this.f2942e.P(0);
            if (this.f2942e.G() != 4801587) {
                break;
            }
            this.f2942e.Q(3);
            int C = this.f2942e.C();
            i += C + 10;
            kVar.h(C);
        }
        kVar.e();
        kVar.h(i);
        if (this.i == -1) {
            this.i = i;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void b(l lVar) {
        this.g = lVar;
        this.f2940c.d(lVar, new i0.d(0, 1));
        lVar.r();
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void c(long j, long j2) {
        this.l = false;
        this.f2940c.c();
        this.h = j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
        r9.e();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
        if ((r3 - r0) < 8192) goto L_0x002f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
        return false;
     */
    @Override // com.google.android.exoplayer2.o2.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(com.google.android.exoplayer2.o2.k r9) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.j(r9)
            r1 = 0
            r3 = r0
        L_0x0006:
            r2 = 0
            r4 = 0
        L_0x0008:
            com.google.android.exoplayer2.util.d0 r5 = r8.f2942e
            byte[] r5 = r5.d()
            r6 = 2
            r9.n(r5, r1, r6)
            com.google.android.exoplayer2.util.d0 r5 = r8.f2942e
            r5.P(r1)
            com.google.android.exoplayer2.util.d0 r5 = r8.f2942e
            int r5 = r5.J()
            boolean r5 = com.google.android.exoplayer2.o2.l0.k.m(r5)
            if (r5 != 0) goto L_0x0033
            r9.e()
            int r3 = r3 + 1
            int r2 = r3 - r0
            r4 = 8192(0x2000, float:1.14794E-41)
            if (r2 < r4) goto L_0x002f
            return r1
        L_0x002f:
            r9.h(r3)
            goto L_0x0006
        L_0x0033:
            r5 = 1
            int r2 = r2 + r5
            r6 = 4
            if (r2 < r6) goto L_0x003d
            r7 = 188(0xbc, float:2.63E-43)
            if (r4 <= r7) goto L_0x003d
            return r5
        L_0x003d:
            com.google.android.exoplayer2.util.d0 r5 = r8.f2942e
            byte[] r5 = r5.d()
            r9.n(r5, r1, r6)
            com.google.android.exoplayer2.util.c0 r5 = r8.f2943f
            r6 = 14
            r5.p(r6)
            com.google.android.exoplayer2.util.c0 r5 = r8.f2943f
            r6 = 13
            int r5 = r5.h(r6)
            r6 = 6
            if (r5 > r6) goto L_0x0059
            return r1
        L_0x0059:
            int r6 = r5 + (-6)
            r9.h(r6)
            int r4 = r4 + r5
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.o2.l0.j.d(com.google.android.exoplayer2.o2.k):boolean");
    }

    @Override // com.google.android.exoplayer2.o2.j
    public int e(k kVar, x xVar) throws IOException {
        g.i(this.g);
        long a2 = kVar.a();
        boolean z = ((this.f2939b & 1) == 0 || a2 == -1) ? false : true;
        if (z) {
            a(kVar);
        }
        int read = kVar.read(this.f2941d.d(), 0, 2048);
        boolean z2 = read == -1;
        i(a2, z, z2);
        if (z2) {
            return -1;
        }
        this.f2941d.P(0);
        this.f2941d.O(read);
        if (!this.l) {
            this.f2940c.f(this.h, 4);
            this.l = true;
        }
        this.f2940c.b(this.f2941d);
        return 0;
    }

    @Override // com.google.android.exoplayer2.o2.j
    public void release() {
    }

    public j(int i) {
        this.f2939b = i;
        this.f2940c = new k(true);
        this.f2941d = new d0(2048);
        this.j = -1;
        this.i = -1L;
        d0 d0Var = new d0(10);
        this.f2942e = d0Var;
        this.f2943f = new c0(d0Var.d());
    }
}
