package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MediaSourceEventListener.java */
/* loaded from: classes.dex */
public interface f0 {

    /* compiled from: MediaSourceEventListener.java */
    /* loaded from: classes.dex */
    public static class a {
        public final int a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final e0.a f3216b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList<C0083a> f3217c;

        /* renamed from: d  reason: collision with root package name */
        private final long f3218d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MediaSourceEventListener.java */
        /* renamed from: com.google.android.exoplayer2.source.f0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0083a {
            public Handler a;

            /* renamed from: b  reason: collision with root package name */
            public f0 f3219b;

            public C0083a(Handler handler, f0 f0Var) {
                this.a = handler;
                this.f3219b = f0Var;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private long b(long j) {
            long e2 = w0.e(j);
            if (e2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f3218d + e2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f(f0 f0Var, a0 a0Var) {
            f0Var.l(this.a, this.f3216b, a0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g */
        public /* synthetic */ void h(f0 f0Var, x xVar, a0 a0Var) {
            f0Var.m(this.a, this.f3216b, xVar, a0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: i */
        public /* synthetic */ void j(f0 f0Var, x xVar, a0 a0Var) {
            f0Var.e0(this.a, this.f3216b, xVar, a0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: k */
        public /* synthetic */ void l(f0 f0Var, x xVar, a0 a0Var, IOException iOException, boolean z) {
            f0Var.i0(this.a, this.f3216b, xVar, a0Var, iOException, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: m */
        public /* synthetic */ void n(f0 f0Var, x xVar, a0 a0Var) {
            f0Var.p(this.a, this.f3216b, xVar, a0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void p(f0 f0Var, e0.a aVar, a0 a0Var) {
            f0Var.N(this.a, aVar, a0Var);
        }

        public void A(x xVar, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2) {
            B(xVar, new a0(i, i2, format, i3, obj, b(j), b(j2)));
        }

        public void B(final x xVar, final a0 a0Var) {
            Iterator<C0083a> it = this.f3217c.iterator();
            while (it.hasNext()) {
                C0083a next = it.next();
                final f0 f0Var = next.f3219b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.source.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        f0.a.this.n(f0Var, xVar, a0Var);
                    }
                });
            }
        }

        public void C(f0 f0Var) {
            Iterator<C0083a> it = this.f3217c.iterator();
            while (it.hasNext()) {
                C0083a next = it.next();
                if (next.f3219b == f0Var) {
                    this.f3217c.remove(next);
                }
            }
        }

        public void D(int i, long j, long j2) {
            E(new a0(1, i, null, 3, null, b(j), b(j2)));
        }

        public void E(final a0 a0Var) {
            final e0.a aVar = (e0.a) g.e(this.f3216b);
            Iterator<C0083a> it = this.f3217c.iterator();
            while (it.hasNext()) {
                C0083a next = it.next();
                final f0 f0Var = next.f3219b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.source.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        f0.a.this.p(f0Var, aVar, a0Var);
                    }
                });
            }
        }

        @CheckResult
        public a F(int i, @Nullable e0.a aVar, long j) {
            return new a(this.f3217c, i, aVar, j);
        }

        public void a(Handler handler, f0 f0Var) {
            g.e(handler);
            g.e(f0Var);
            this.f3217c.add(new C0083a(handler, f0Var));
        }

        public void c(int i, @Nullable Format format, int i2, @Nullable Object obj, long j) {
            d(new a0(1, i, format, i2, obj, b(j), -9223372036854775807L));
        }

        public void d(final a0 a0Var) {
            Iterator<C0083a> it = this.f3217c.iterator();
            while (it.hasNext()) {
                C0083a next = it.next();
                final f0 f0Var = next.f3219b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.source.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f0.a.this.f(f0Var, a0Var);
                    }
                });
            }
        }

        public void q(x xVar, int i) {
            r(xVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void r(x xVar, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2) {
            s(xVar, new a0(i, i2, format, i3, obj, b(j), b(j2)));
        }

        public void s(final x xVar, final a0 a0Var) {
            Iterator<C0083a> it = this.f3217c.iterator();
            while (it.hasNext()) {
                C0083a next = it.next();
                final f0 f0Var = next.f3219b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.source.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        f0.a.this.h(f0Var, xVar, a0Var);
                    }
                });
            }
        }

        public void t(x xVar, int i) {
            u(xVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void u(x xVar, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2) {
            v(xVar, new a0(i, i2, format, i3, obj, b(j), b(j2)));
        }

        public void v(final x xVar, final a0 a0Var) {
            Iterator<C0083a> it = this.f3217c.iterator();
            while (it.hasNext()) {
                C0083a next = it.next();
                final f0 f0Var = next.f3219b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.source.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        f0.a.this.j(f0Var, xVar, a0Var);
                    }
                });
            }
        }

        public void w(x xVar, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2, IOException iOException, boolean z) {
            y(xVar, new a0(i, i2, format, i3, obj, b(j), b(j2)), iOException, z);
        }

        public void x(x xVar, int i, IOException iOException, boolean z) {
            w(xVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z);
        }

        public void y(final x xVar, final a0 a0Var, final IOException iOException, final boolean z) {
            Iterator<C0083a> it = this.f3217c.iterator();
            while (it.hasNext()) {
                C0083a next = it.next();
                final f0 f0Var = next.f3219b;
                o0.z0(next.a, new Runnable() { // from class: com.google.android.exoplayer2.source.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        f0.a.this.l(f0Var, xVar, a0Var, iOException, z);
                    }
                });
            }
        }

        public void z(x xVar, int i) {
            A(xVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        private a(CopyOnWriteArrayList<C0083a> copyOnWriteArrayList, int i, @Nullable e0.a aVar, long j) {
            this.f3217c = copyOnWriteArrayList;
            this.a = i;
            this.f3216b = aVar;
            this.f3218d = j;
        }
    }

    void N(int i, e0.a aVar, a0 a0Var);

    void e0(int i, @Nullable e0.a aVar, x xVar, a0 a0Var);

    void i0(int i, @Nullable e0.a aVar, x xVar, a0 a0Var, IOException iOException, boolean z);

    void l(int i, @Nullable e0.a aVar, a0 a0Var);

    void m(int i, @Nullable e0.a aVar, x xVar, a0 a0Var);

    void p(int i, @Nullable e0.a aVar, x xVar, a0 a0Var);
}
