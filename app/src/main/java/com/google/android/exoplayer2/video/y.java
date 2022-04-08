package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.video.y;

/* compiled from: VideoRendererEventListener.java */
/* loaded from: classes.dex */
public interface y {

    /* compiled from: VideoRendererEventListener.java */
    /* loaded from: classes.dex */
    public static final class a {
        @Nullable
        private final Handler a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final y f4075b;

        public a(@Nullable Handler handler, @Nullable y yVar) {
            this.a = yVar != null ? (Handler) g.e(handler) : null;
            this.f4075b = yVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g */
        public /* synthetic */ void h(String str, long j, long j2) {
            ((y) o0.i(this.f4075b)).k(str, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: i */
        public /* synthetic */ void j(String str) {
            ((y) o0.i(this.f4075b)).h(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: k */
        public /* synthetic */ void l(d dVar) {
            dVar.c();
            ((y) o0.i(this.f4075b)).H(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: m */
        public /* synthetic */ void n(int i, long j) {
            ((y) o0.i(this.f4075b)).T(i, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void p(d dVar) {
            ((y) o0.i(this.f4075b)).Z(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: q */
        public /* synthetic */ void r(Format format, e eVar) {
            ((y) o0.i(this.f4075b)).C(format);
            ((y) o0.i(this.f4075b)).D(format, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: s */
        public /* synthetic */ void t(Object obj, long j) {
            ((y) o0.i(this.f4075b)).X(obj, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: u */
        public /* synthetic */ void v(long j, int i) {
            ((y) o0.i(this.f4075b)).j0(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: w */
        public /* synthetic */ void x(Exception exc) {
            ((y) o0.i(this.f4075b)).F(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: y */
        public /* synthetic */ void z(z zVar) {
            ((y) o0.i(this.f4075b)).c(zVar);
        }

        public void A(final Object obj) {
            if (this.a != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                this.a.post(new Runnable() { // from class: com.google.android.exoplayer2.video.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a.this.t(obj, elapsedRealtime);
                    }
                });
            }
        }

        public void B(final long j, final int i) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a.this.v(j, i);
                    }
                });
            }
        }

        public void C(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a.this.x(exc);
                    }
                });
            }
        }

        public void D(final z zVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a.this.z(zVar);
                    }
                });
            }
        }

        public void a(final String str, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a.this.h(str, j, j2);
                    }
                });
            }
        }

        public void b(final String str) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a.this.j(str);
                    }
                });
            }
        }

        public void c(final d dVar) {
            dVar.c();
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a.this.l(dVar);
                    }
                });
            }
        }

        public void d(final int i, final long j) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a.this.n(i, j);
                    }
                });
            }
        }

        public void e(final d dVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a.this.p(dVar);
                    }
                });
            }
        }

        public void f(final Format format, @Nullable final e eVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a.this.r(format, eVar);
                    }
                });
            }
        }
    }

    @Deprecated
    void C(Format format);

    void D(Format format, @Nullable e eVar);

    void F(Exception exc);

    void H(d dVar);

    void T(int i, long j);

    void X(Object obj, long j);

    void Z(d dVar);

    void c(z zVar);

    void h(String str);

    void j0(long j, int i);

    void k(String str, long j, long j2);
}
