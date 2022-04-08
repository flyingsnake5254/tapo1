package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.source.o0;
import com.google.android.exoplayer2.trackselection.g;
import java.io.IOException;

/* compiled from: MediaPeriod.java */
/* loaded from: classes.dex */
public interface b0 extends o0 {

    /* compiled from: MediaPeriod.java */
    /* loaded from: classes.dex */
    public interface a extends o0.a<b0> {
        void p(b0 b0Var);
    }

    @Override // com.google.android.exoplayer2.source.o0
    long a();

    @Override // com.google.android.exoplayer2.source.o0
    boolean c();

    @Override // com.google.android.exoplayer2.source.o0
    boolean d(long j);

    @Override // com.google.android.exoplayer2.source.o0
    long e();

    @Override // com.google.android.exoplayer2.source.o0
    void f(long j);

    long i(long j);

    long j(long j, g2 g2Var);

    long k();

    void l(a aVar, long j);

    long m(g[] gVarArr, boolean[] zArr, n0[] n0VarArr, boolean[] zArr2, long j);

    void q() throws IOException;

    TrackGroupArray s();

    void u(long j, boolean z);
}
