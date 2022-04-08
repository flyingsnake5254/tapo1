package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.util.w;
import com.google.android.exoplayer2.x1;
import java.io.IOException;

/* compiled from: Renderer.java */
/* loaded from: classes.dex */
public interface b2 extends x1.b {

    /* compiled from: Renderer.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b(long j);
    }

    void b();

    boolean d();

    int f();

    boolean g();

    String getName();

    int getState();

    @Nullable
    n0 getStream();

    void h(int i);

    boolean i();

    void j();

    void l() throws IOException;

    boolean m();

    void n(Format[] formatArr, n0 n0Var, long j, long j2) throws ExoPlaybackException;

    d2 o();

    void q(float f2, float f3) throws ExoPlaybackException;

    void r(e2 e2Var, Format[] formatArr, n0 n0Var, long j, boolean z, boolean z2, long j2, long j3) throws ExoPlaybackException;

    void reset();

    void start() throws ExoPlaybackException;

    void stop();

    void t(long j, long j2) throws ExoPlaybackException;

    long u();

    void v(long j) throws ExoPlaybackException;

    @Nullable
    w w();
}
