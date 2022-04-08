package com.google.android.exoplayer2;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.m2.h1;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.source.p0;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaSourceList.java */
/* loaded from: classes.dex */
public final class r1 {

    /* renamed from: d  reason: collision with root package name */
    private final d f3118d;

    /* renamed from: e  reason: collision with root package name */
    private final f0.a f3119e;

    /* renamed from: f  reason: collision with root package name */
    private final v.a f3120f;
    private boolean j;
    @Nullable
    private a0 k;
    private p0 i = new p0.a(0);

    /* renamed from: b  reason: collision with root package name */
    private final IdentityHashMap<b0, c> f3116b = new IdentityHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Object, c> f3117c = new HashMap();
    private final List<c> a = new ArrayList();
    private final HashMap<c, b> g = new HashMap<>();
    private final Set<c> h = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaSourceList.java */
    /* loaded from: classes.dex */
    public final class a implements f0, v {

        /* renamed from: c  reason: collision with root package name */
        private final c f3121c;

        /* renamed from: d  reason: collision with root package name */
        private f0.a f3122d;

        /* renamed from: f  reason: collision with root package name */
        private v.a f3123f;

        public a(c cVar) {
            this.f3122d = r1.this.f3119e;
            this.f3123f = r1.this.f3120f;
            this.f3121c = cVar;
        }

        private boolean a(int i, @Nullable e0.a aVar) {
            e0.a aVar2;
            if (aVar != null) {
                aVar2 = r1.m(this.f3121c, aVar);
                if (aVar2 == null) {
                    return false;
                }
            } else {
                aVar2 = null;
            }
            int q = r1.q(this.f3121c, i);
            f0.a aVar3 = this.f3122d;
            if (aVar3.a != q || !o0.b(aVar3.f3216b, aVar2)) {
                this.f3122d = r1.this.f3119e.F(q, aVar2, 0L);
            }
            v.a aVar4 = this.f3123f;
            if (aVar4.a == q && o0.b(aVar4.f2244b, aVar2)) {
                return true;
            }
            this.f3123f = r1.this.f3120f.u(q, aVar2);
            return true;
        }

        @Override // com.google.android.exoplayer2.drm.v
        public /* synthetic */ void A(int i, e0.a aVar) {
            u.a(this, i, aVar);
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void N(int i, @Nullable e0.a aVar, com.google.android.exoplayer2.source.a0 a0Var) {
            if (a(i, aVar)) {
                this.f3122d.E(a0Var);
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void Q(int i, @Nullable e0.a aVar, Exception exc) {
            if (a(i, aVar)) {
                this.f3123f.f(exc);
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void a0(int i, @Nullable e0.a aVar) {
            if (a(i, aVar)) {
                this.f3123f.b();
            }
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void e0(int i, @Nullable e0.a aVar, x xVar, com.google.android.exoplayer2.source.a0 a0Var) {
            if (a(i, aVar)) {
                this.f3122d.v(xVar, a0Var);
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void f0(int i, @Nullable e0.a aVar, int i2) {
            if (a(i, aVar)) {
                this.f3123f.e(i2);
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void g0(int i, @Nullable e0.a aVar) {
            if (a(i, aVar)) {
                this.f3123f.g();
            }
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void i0(int i, @Nullable e0.a aVar, x xVar, com.google.android.exoplayer2.source.a0 a0Var, IOException iOException, boolean z) {
            if (a(i, aVar)) {
                this.f3122d.y(xVar, a0Var, iOException, z);
            }
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void l(int i, @Nullable e0.a aVar, com.google.android.exoplayer2.source.a0 a0Var) {
            if (a(i, aVar)) {
                this.f3122d.d(a0Var);
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void l0(int i, @Nullable e0.a aVar) {
            if (a(i, aVar)) {
                this.f3123f.d();
            }
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void m(int i, @Nullable e0.a aVar, x xVar, com.google.android.exoplayer2.source.a0 a0Var) {
            if (a(i, aVar)) {
                this.f3122d.s(xVar, a0Var);
            }
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void p(int i, @Nullable e0.a aVar, x xVar, com.google.android.exoplayer2.source.a0 a0Var) {
            if (a(i, aVar)) {
                this.f3122d.B(xVar, a0Var);
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void y(int i, @Nullable e0.a aVar) {
            if (a(i, aVar)) {
                this.f3123f.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaSourceList.java */
    /* loaded from: classes.dex */
    public static final class b {
        public final e0 a;

        /* renamed from: b  reason: collision with root package name */
        public final e0.b f3124b;

        /* renamed from: c  reason: collision with root package name */
        public final a f3125c;

        public b(e0 e0Var, e0.b bVar, a aVar) {
            this.a = e0Var;
            this.f3124b = bVar;
            this.f3125c = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MediaSourceList.java */
    /* loaded from: classes.dex */
    public static final class c implements q1 {
        public final z a;

        /* renamed from: d  reason: collision with root package name */
        public int f3128d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3129e;

        /* renamed from: c  reason: collision with root package name */
        public final List<e0.a> f3127c = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final Object f3126b = new Object();

        public c(e0 e0Var, boolean z) {
            this.a = new z(e0Var, z);
        }

        @Override // com.google.android.exoplayer2.q1
        public j2 a() {
            return this.a.M();
        }

        public void b(int i) {
            this.f3128d = i;
            this.f3129e = false;
            this.f3127c.clear();
        }

        @Override // com.google.android.exoplayer2.q1
        public Object getUid() {
            return this.f3126b;
        }
    }

    /* compiled from: MediaSourceList.java */
    /* loaded from: classes.dex */
    public interface d {
        void c();
    }

    public r1(d dVar, @Nullable h1 h1Var, Handler handler) {
        this.f3118d = dVar;
        f0.a aVar = new f0.a();
        this.f3119e = aVar;
        v.a aVar2 = new v.a();
        this.f3120f = aVar2;
        if (h1Var != null) {
            aVar.a(handler, h1Var);
            aVar2.a(handler, h1Var);
        }
    }

    private void B(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c remove = this.a.remove(i3);
            this.f3117c.remove(remove.f3126b);
            f(i3, -remove.a.M().p());
            remove.f3129e = true;
            if (this.j) {
                u(remove);
            }
        }
    }

    private void f(int i, int i2) {
        while (i < this.a.size()) {
            this.a.get(i).f3128d += i2;
            i++;
        }
    }

    private void i(c cVar) {
        b bVar = this.g.get(cVar);
        if (bVar != null) {
            bVar.a.j(bVar.f3124b);
        }
    }

    private void j() {
        Iterator<c> it = this.h.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f3127c.isEmpty()) {
                i(next);
                it.remove();
            }
        }
    }

    private void k(c cVar) {
        this.h.add(cVar);
        b bVar = this.g.get(cVar);
        if (bVar != null) {
            bVar.a.i(bVar.f3124b);
        }
    }

    private static Object l(Object obj) {
        return q0.v(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static e0.a m(c cVar, e0.a aVar) {
        for (int i = 0; i < cVar.f3127c.size(); i++) {
            if (cVar.f3127c.get(i).f3205d == aVar.f3205d) {
                return aVar.c(o(cVar, aVar.a));
            }
        }
        return null;
    }

    private static Object n(Object obj) {
        return q0.w(obj);
    }

    private static Object o(c cVar, Object obj) {
        return q0.y(cVar.f3126b, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(c cVar, int i) {
        return i + cVar.f3128d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t(e0 e0Var, j2 j2Var) {
        this.f3118d.c();
    }

    private void u(c cVar) {
        if (cVar.f3129e && cVar.f3127c.isEmpty()) {
            b bVar = (b) g.e(this.g.remove(cVar));
            bVar.a.b(bVar.f3124b);
            bVar.a.e(bVar.f3125c);
            bVar.a.m(bVar.f3125c);
            this.h.remove(cVar);
        }
    }

    private void x(c cVar) {
        z zVar = cVar.a;
        e0.b h0Var = new e0.b() { // from class: com.google.android.exoplayer2.h0
            @Override // com.google.android.exoplayer2.source.e0.b
            public final void a(e0 e0Var, j2 j2Var) {
                r1.this.t(e0Var, j2Var);
            }
        };
        a aVar = new a(cVar);
        this.g.put(cVar, new b(zVar, h0Var, aVar));
        zVar.d(o0.x(), aVar);
        zVar.l(o0.x(), aVar);
        zVar.h(h0Var, this.k);
    }

    public j2 A(int i, int i2, p0 p0Var) {
        g.a(i >= 0 && i <= i2 && i2 <= p());
        this.i = p0Var;
        B(i, i2);
        return h();
    }

    public j2 C(List<c> list, p0 p0Var) {
        B(0, this.a.size());
        return e(this.a.size(), list, p0Var);
    }

    public j2 D(p0 p0Var) {
        int p = p();
        if (p0Var.a() != p) {
            p0Var = p0Var.f().h(0, p);
        }
        this.i = p0Var;
        return h();
    }

    public j2 e(int i, List<c> list, p0 p0Var) {
        if (!list.isEmpty()) {
            this.i = p0Var;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = this.a.get(i2 - 1);
                    cVar.b(cVar2.f3128d + cVar2.a.M().p());
                } else {
                    cVar.b(0);
                }
                f(i2, cVar.a.M().p());
                this.a.add(i2, cVar);
                this.f3117c.put(cVar.f3126b, cVar);
                if (this.j) {
                    x(cVar);
                    if (this.f3116b.isEmpty()) {
                        this.h.add(cVar);
                    } else {
                        i(cVar);
                    }
                }
            }
        }
        return h();
    }

    public b0 g(e0.a aVar, e eVar, long j) {
        Object n = n(aVar.a);
        e0.a c2 = aVar.c(l(aVar.a));
        c cVar = (c) g.e(this.f3117c.get(n));
        k(cVar);
        cVar.f3127c.add(c2);
        y I = cVar.a.a(c2, eVar, j);
        this.f3116b.put(I, cVar);
        j();
        return I;
    }

    public j2 h() {
        if (this.a.isEmpty()) {
            return j2.a;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            c cVar = this.a.get(i2);
            cVar.f3128d = i;
            i += cVar.a.M().p();
        }
        return new y1(this.a, this.i);
    }

    public int p() {
        return this.a.size();
    }

    public boolean r() {
        return this.j;
    }

    public j2 v(int i, int i2, int i3, p0 p0Var) {
        g.a(i >= 0 && i <= i2 && i2 <= p() && i3 >= 0);
        this.i = p0Var;
        if (i == i2 || i == i3) {
            return h();
        }
        int min = Math.min(i, i3);
        int max = Math.max(((i2 - i) + i3) - 1, i2 - 1);
        int i4 = this.a.get(min).f3128d;
        o0.r0(this.a, i, i2, i3);
        while (min <= max) {
            c cVar = this.a.get(min);
            cVar.f3128d = i4;
            i4 += cVar.a.M().p();
            min++;
        }
        return h();
    }

    public void w(@Nullable a0 a0Var) {
        g.g(!this.j);
        this.k = a0Var;
        for (int i = 0; i < this.a.size(); i++) {
            c cVar = this.a.get(i);
            x(cVar);
            this.h.add(cVar);
        }
        this.j = true;
    }

    public void y() {
        for (b bVar : this.g.values()) {
            try {
                bVar.a.b(bVar.f3124b);
            } catch (RuntimeException e2) {
                com.google.android.exoplayer2.util.u.d("MediaSourceList", "Failed to release child source.", e2);
            }
            bVar.a.e(bVar.f3125c);
            bVar.a.m(bVar.f3125c);
        }
        this.g.clear();
        this.h.clear();
        this.j = false;
    }

    public void z(b0 b0Var) {
        c cVar = (c) g.e(this.f3116b.remove(b0Var));
        cVar.a.g(b0Var);
        cVar.f3127c.remove(((y) b0Var).f3429c);
        if (!this.f3116b.isEmpty()) {
            j();
        }
        u(cVar);
    }
}
