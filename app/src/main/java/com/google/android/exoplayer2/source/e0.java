package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import java.io.IOException;

/* compiled from: MediaSource.java */
/* loaded from: classes.dex */
public interface e0 {

    /* compiled from: MediaSource.java */
    /* loaded from: classes.dex */
    public static final class a extends c0 {
        public a(Object obj) {
            super(obj);
        }

        public a c(Object obj) {
            return new a(super.a(obj));
        }

        public a(Object obj, long j) {
            super(obj, j);
        }

        public a(Object obj, long j, int i) {
            super(obj, j, i);
        }

        public a(Object obj, int i, int i2, long j) {
            super(obj, i, i2, j);
        }

        public a(c0 c0Var) {
            super(c0Var);
        }
    }

    /* compiled from: MediaSource.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(e0 e0Var, j2 j2Var);
    }

    b0 a(a aVar, e eVar, long j);

    void b(b bVar);

    void d(Handler handler, f0 f0Var);

    void e(f0 f0Var);

    l1 f();

    void g(b0 b0Var);

    void h(b bVar, @Nullable a0 a0Var);

    void i(b bVar);

    void j(b bVar);

    void l(Handler handler, v vVar);

    void m(v vVar);

    void n() throws IOException;

    boolean o();

    @Nullable
    j2 p();
}
