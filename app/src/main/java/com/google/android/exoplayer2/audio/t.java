package com.google.android.exoplayer2.audio;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.t;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

/* compiled from: AudioRendererEventListener.java */
/* loaded from: classes.dex */
public interface t {

    /* compiled from: AudioRendererEventListener.java */
    /* loaded from: classes.dex */
    public static final class a {
        @Nullable
        private final Handler a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final t f2119b;

        public a(@Nullable Handler handler, @Nullable t tVar) {
            this.a = tVar != null ? (Handler) g.e(handler) : null;
            this.f2119b = tVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h */
        public /* synthetic */ void i(Exception exc) {
            ((t) o0.i(this.f2119b)).b0(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j */
        public /* synthetic */ void k(Exception exc) {
            ((t) o0.i(this.f2119b)).b(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: l */
        public /* synthetic */ void m(String str, long j, long j2) {
            ((t) o0.i(this.f2119b)).u(str, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public /* synthetic */ void o(String str) {
            ((t) o0.i(this.f2119b)).t(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ void q(d dVar) {
            dVar.c();
            ((t) o0.i(this.f2119b)).L(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: r */
        public /* synthetic */ void s(d dVar) {
            ((t) o0.i(this.f2119b)).i(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: t */
        public /* synthetic */ void u(Format format, e eVar) {
            ((t) o0.i(this.f2119b)).c0(format);
            ((t) o0.i(this.f2119b)).V(format, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: v */
        public /* synthetic */ void w(long j) {
            ((t) o0.i(this.f2119b)).E(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: x */
        public /* synthetic */ void y(boolean z) {
            ((t) o0.i(this.f2119b)).a(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: z */
        public /* synthetic */ void A(int i, long j, long j2) {
            ((t) o0.i(this.f2119b)).h0(i, j, j2);
        }

        public void B(final long j) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.w(j);
                    }
                });
            }
        }

        public void C(final boolean z) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.y(z);
                    }
                });
            }
        }

        public void D(final int i, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.A(i, j, j2);
                    }
                });
            }
        }

        public void a(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.i(exc);
                    }
                });
            }
        }

        public void b(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.k(exc);
                    }
                });
            }
        }

        public void c(final String str, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.m(str, j, j2);
                    }
                });
            }
        }

        public void d(final String str) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.o(str);
                    }
                });
            }
        }

        public void e(final d dVar) {
            dVar.c();
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.q(dVar);
                    }
                });
            }
        }

        public void f(final d dVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.s(dVar);
                    }
                });
            }
        }

        public void g(final Format format, @Nullable final e eVar) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.this.u(format, eVar);
                    }
                });
            }
        }
    }

    void E(long j);

    void L(d dVar);

    void V(Format format, @Nullable e eVar);

    void a(boolean z);

    void b(Exception exc);

    void b0(Exception exc);

    @Deprecated
    void c0(Format format);

    void h0(int i, long j, long j2);

    void i(d dVar);

    void t(String str);

    void u(String str, long j, long j2);
}
