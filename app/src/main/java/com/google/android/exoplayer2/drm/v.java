package com.google.android.exoplayer2.drm;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DrmSessionEventListener.java */
/* loaded from: classes.dex */
public interface v {

    /* compiled from: DrmSessionEventListener.java */
    /* loaded from: classes.dex */
    public static class a {
        public final int a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final e0.a f2244b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList<C0075a> f2245c;

        /* compiled from: DrmSessionEventListener.java */
        /* renamed from: com.google.android.exoplayer2.drm.v$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static final class C0075a {
            public Handler a;

            /* renamed from: b  reason: collision with root package name */
            public v f2246b;

            public C0075a(Handler handler, v vVar) {
                this.a = handler;
                this.f2246b = vVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h */
        public /* synthetic */ void i(v vVar) {
            vVar.a0(this.a, this.f2244b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j */
        public /* synthetic */ void k(v vVar) {
            vVar.y(this.a, this.f2244b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: l */
        public /* synthetic */ void m(v vVar) {
            vVar.l0(this.a, this.f2244b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public /* synthetic */ void o(v vVar, int i) {
            vVar.A(this.a, this.f2244b);
            vVar.f0(this.a, this.f2244b, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ void q(v vVar, Exception exc) {
            vVar.Q(this.a, this.f2244b, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: r */
        public /* synthetic */ void s(v vVar) {
            vVar.g0(this.a, this.f2244b);
        }

        public void a(Handler handler, v vVar) {
            g.e(handler);
            g.e(vVar);
            this.f2245c.add(new C0075a(handler, vVar));
        }

        public void b() {
            Iterator<C0075a> it = this.f2245c.iterator();
            while (it.hasNext()) {
                C0075a next = it.next();
                final v vVar = next.f2246b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.drm.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.i(vVar);
                    }
                });
            }
        }

        public void c() {
            Iterator<C0075a> it = this.f2245c.iterator();
            while (it.hasNext()) {
                C0075a next = it.next();
                final v vVar = next.f2246b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.drm.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.k(vVar);
                    }
                });
            }
        }

        public void d() {
            Iterator<C0075a> it = this.f2245c.iterator();
            while (it.hasNext()) {
                C0075a next = it.next();
                final v vVar = next.f2246b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.drm.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.m(vVar);
                    }
                });
            }
        }

        public void e(final int i) {
            Iterator<C0075a> it = this.f2245c.iterator();
            while (it.hasNext()) {
                C0075a next = it.next();
                final v vVar = next.f2246b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.drm.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.o(vVar, i);
                    }
                });
            }
        }

        public void f(final Exception exc) {
            Iterator<C0075a> it = this.f2245c.iterator();
            while (it.hasNext()) {
                C0075a next = it.next();
                final v vVar = next.f2246b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.drm.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.q(vVar, exc);
                    }
                });
            }
        }

        public void g() {
            Iterator<C0075a> it = this.f2245c.iterator();
            while (it.hasNext()) {
                C0075a next = it.next();
                final v vVar = next.f2246b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.drm.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.s(vVar);
                    }
                });
            }
        }

        public void t(v vVar) {
            Iterator<C0075a> it = this.f2245c.iterator();
            while (it.hasNext()) {
                C0075a next = it.next();
                if (next.f2246b == vVar) {
                    this.f2245c.remove(next);
                }
            }
        }

        @CheckResult
        public a u(int i, @Nullable e0.a aVar) {
            return new a(this.f2245c, i, aVar);
        }

        private a(CopyOnWriteArrayList<C0075a> copyOnWriteArrayList, int i, @Nullable e0.a aVar) {
            this.f2245c = copyOnWriteArrayList;
            this.a = i;
            this.f2244b = aVar;
        }
    }

    @Deprecated
    void A(int i, @Nullable e0.a aVar);

    void Q(int i, @Nullable e0.a aVar, Exception exc);

    void a0(int i, @Nullable e0.a aVar);

    void f0(int i, @Nullable e0.a aVar, int i2);

    void g0(int i, @Nullable e0.a aVar);

    void l0(int i, @Nullable e0.a aVar);

    void y(int i, @Nullable e0.a aVar);
}
