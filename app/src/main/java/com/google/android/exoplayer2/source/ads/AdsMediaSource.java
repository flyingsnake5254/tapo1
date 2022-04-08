package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.g;
import com.google.android.exoplayer2.source.ads.h;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.source.g0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class AdsMediaSource extends p<e0.a> {
    private static final e0.a j = new e0.a(new Object());
    private final e0 k;
    private final g0 l;
    private final h m;
    private final com.google.android.exoplayer2.ui.e0 n;
    private final n o;
    private final Object p;
    @Nullable
    private c s;
    @Nullable
    private j2 t;
    @Nullable
    private g u;
    private final Handler q = new Handler(Looper.getMainLooper());
    private final j2.b r = new j2.b();
    private a[][] v = new a[0];

    /* loaded from: classes.dex */
    public static final class AdLoadException extends IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        private AdLoadException(int i, Exception exc) {
            super(exc);
            this.type = i;
        }

        public static AdLoadException createForAd(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException createForAdGroup(Exception exc, int i) {
            StringBuilder sb = new StringBuilder(35);
            sb.append("Failed to load ad group ");
            sb.append(i);
            return new AdLoadException(1, new IOException(sb.toString(), exc));
        }

        public static AdLoadException createForAllAds(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        public RuntimeException getRuntimeExceptionForUnexpected() {
            g.g(this.type == 3);
            return (RuntimeException) g.e(getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a {
        private final e0.a a;

        /* renamed from: b  reason: collision with root package name */
        private final List<y> f3169b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private Uri f3170c;

        /* renamed from: d  reason: collision with root package name */
        private e0 f3171d;

        /* renamed from: e  reason: collision with root package name */
        private j2 f3172e;

        public a(e0.a aVar) {
            this.a = aVar;
        }

        public b0 a(e0.a aVar, e eVar, long j) {
            y yVar = new y(aVar, eVar, j);
            this.f3169b.add(yVar);
            e0 e0Var = this.f3171d;
            if (e0Var != null) {
                yVar.y(e0Var);
                yVar.z(new b((Uri) g.e(this.f3170c)));
            }
            j2 j2Var = this.f3172e;
            if (j2Var != null) {
                yVar.g(new e0.a(j2Var.m(0), aVar.f3205d));
            }
            return yVar;
        }

        public long b() {
            j2 j2Var = this.f3172e;
            if (j2Var == null) {
                return -9223372036854775807L;
            }
            return j2Var.f(0, AdsMediaSource.this.r).i();
        }

        public void c(j2 j2Var) {
            boolean z = true;
            if (j2Var.i() != 1) {
                z = false;
            }
            g.a(z);
            if (this.f3172e == null) {
                Object m = j2Var.m(0);
                for (int i = 0; i < this.f3169b.size(); i++) {
                    y yVar = this.f3169b.get(i);
                    yVar.g(new e0.a(m, yVar.f3429c.f3205d));
                }
            }
            this.f3172e = j2Var;
        }

        public boolean d() {
            return this.f3171d != null;
        }

        public void e(e0 e0Var, Uri uri) {
            this.f3171d = e0Var;
            this.f3170c = uri;
            for (int i = 0; i < this.f3169b.size(); i++) {
                y yVar = this.f3169b.get(i);
                yVar.y(e0Var);
                yVar.z(new b(uri));
            }
            AdsMediaSource.this.G(this.a, e0Var);
        }

        public boolean f() {
            return this.f3169b.isEmpty();
        }

        public void g() {
            if (d()) {
                AdsMediaSource.this.H(this.a);
            }
        }

        public void h(y yVar) {
            this.f3169b.remove(yVar);
            yVar.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements y.a {
        private final Uri a;

        public b(Uri uri) {
            this.a = uri;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d(e0.a aVar) {
            AdsMediaSource.this.m.a(AdsMediaSource.this, aVar.f3203b, aVar.f3204c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f(e0.a aVar, IOException iOException) {
            AdsMediaSource.this.m.c(AdsMediaSource.this, aVar.f3203b, aVar.f3204c, iOException);
        }

        @Override // com.google.android.exoplayer2.source.y.a
        public void a(final e0.a aVar) {
            AdsMediaSource.this.q.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.e
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource.b.this.d(aVar);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.y.a
        public void b(final e0.a aVar, final IOException iOException) {
            AdsMediaSource.this.t(aVar).x(new x(x.a(), new n(this.a), SystemClock.elapsedRealtime()), 6, AdLoadException.createForAd(iOException), true);
            AdsMediaSource.this.q.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.d
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource.b.this.f(aVar, iOException);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements h.a {
        private final Handler a = o0.v();

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f3175b;

        public c() {
        }

        public void a() {
            this.f3175b = true;
            this.a.removeCallbacksAndMessages(null);
        }
    }

    public AdsMediaSource(e0 e0Var, n nVar, Object obj, g0 g0Var, h hVar, com.google.android.exoplayer2.ui.e0 e0Var2) {
        this.k = e0Var;
        this.l = g0Var;
        this.m = hVar;
        this.n = e0Var2;
        this.o = nVar;
        this.p = obj;
        hVar.e(g0Var.b());
    }

    private long[][] O() {
        long[][] jArr = new long[this.v.length];
        int i = 0;
        while (true) {
            a[][] aVarArr = this.v;
            if (i >= aVarArr.length) {
                return jArr;
            }
            jArr[i] = new long[aVarArr[i].length];
            int i2 = 0;
            while (true) {
                a[][] aVarArr2 = this.v;
                if (i2 < aVarArr2[i].length) {
                    a aVar = aVarArr2[i][i2];
                    jArr[i][i2] = aVar == null ? -9223372036854775807L : aVar.b();
                    i2++;
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public /* synthetic */ void R(c cVar) {
        this.m.b(this, this.o, this.p, this.n, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public /* synthetic */ void T(c cVar) {
        this.m.d(this, cVar);
    }

    private void U() {
        Uri uri;
        l1.e eVar;
        g gVar = this.u;
        if (gVar != null) {
            for (int i = 0; i < this.v.length; i++) {
                int i2 = 0;
                while (true) {
                    a[][] aVarArr = this.v;
                    if (i2 < aVarArr[i].length) {
                        a aVar = aVarArr[i][i2];
                        g.a a2 = gVar.a(i);
                        if (aVar != null && !aVar.d()) {
                            Uri[] uriArr = a2.f3193d;
                            if (i2 < uriArr.length && (uri = uriArr[i2]) != null) {
                                l1.c u = new l1.c().u(uri);
                                l1.g gVar2 = this.k.f().f2346d;
                                if (!(gVar2 == null || (eVar = gVar2.f2371c) == null)) {
                                    u.j(eVar.a);
                                    u.d(eVar.a());
                                    u.f(eVar.f2360b);
                                    u.c(eVar.f2364f);
                                    u.e(eVar.f2361c);
                                    u.g(eVar.f2362d);
                                    u.h(eVar.f2363e);
                                    u.i(eVar.g);
                                }
                                aVar.e(this.l.a(u.a()), uri);
                            }
                        }
                        i2++;
                    }
                }
            }
        }
    }

    private void V() {
        j2 j2Var = this.t;
        g gVar = this.u;
        if (gVar != null && j2Var != null) {
            if (gVar.f3189e == 0) {
                y(j2Var);
                return;
            }
            this.u = gVar.e(O());
            y(new i(j2Var, this.u));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: P */
    public e0.a A(e0.a aVar, e0.a aVar2) {
        return aVar.b() ? aVar : aVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: W */
    public void F(e0.a aVar, e0 e0Var, j2 j2Var) {
        if (aVar.b()) {
            int i = aVar.f3203b;
            ((a) com.google.android.exoplayer2.util.g.e(this.v[i][aVar.f3204c])).c(j2Var);
        } else {
            boolean z = true;
            if (j2Var.i() != 1) {
                z = false;
            }
            com.google.android.exoplayer2.util.g.a(z);
            this.t = j2Var;
        }
        V();
    }

    @Override // com.google.android.exoplayer2.source.e0
    public b0 a(e0.a aVar, e eVar, long j2) {
        if (((g) com.google.android.exoplayer2.util.g.e(this.u)).f3189e <= 0 || !aVar.b()) {
            y yVar = new y(aVar, eVar, j2);
            yVar.y(this.k);
            yVar.g(aVar);
            return yVar;
        }
        int i = aVar.f3203b;
        int i2 = aVar.f3204c;
        a[][] aVarArr = this.v;
        if (aVarArr[i].length <= i2) {
            aVarArr[i] = (a[]) Arrays.copyOf(aVarArr[i], i2 + 1);
        }
        a aVar2 = this.v[i][i2];
        if (aVar2 == null) {
            aVar2 = new a(aVar);
            this.v[i][i2] = aVar2;
            U();
        }
        return aVar2.a(aVar, eVar, j2);
    }

    @Override // com.google.android.exoplayer2.source.e0
    public l1 f() {
        return this.k.f();
    }

    @Override // com.google.android.exoplayer2.source.e0
    public void g(b0 b0Var) {
        y yVar = (y) b0Var;
        e0.a aVar = yVar.f3429c;
        if (aVar.b()) {
            a aVar2 = (a) com.google.android.exoplayer2.util.g.e(this.v[aVar.f3203b][aVar.f3204c]);
            aVar2.h(yVar);
            if (aVar2.f()) {
                aVar2.g();
                this.v[aVar.f3203b][aVar.f3204c] = null;
                return;
            }
            return;
        }
        yVar.x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m
    public void x(@Nullable a0 a0Var) {
        super.x(a0Var);
        final c cVar = new c();
        this.s = cVar;
        G(j, this.k);
        this.q.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.c
            @Override // java.lang.Runnable
            public final void run() {
                AdsMediaSource.this.R(cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m
    public void z() {
        super.z();
        final c cVar = (c) com.google.android.exoplayer2.util.g.e(this.s);
        this.s = null;
        cVar.a();
        this.t = null;
        this.u = null;
        this.v = new a[0];
        this.q.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.f
            @Override // java.lang.Runnable
            public final void run() {
                AdsMediaSource.this.T(cVar);
            }
        });
    }
}
