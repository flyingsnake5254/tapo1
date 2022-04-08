package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.w0;

/* compiled from: StandaloneMediaClock.java */
/* loaded from: classes.dex */
public final class h0 implements w {

    /* renamed from: c  reason: collision with root package name */
    private final h f3914c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3915d;

    /* renamed from: f  reason: collision with root package name */
    private long f3916f;
    private long q;
    private t1 x = t1.a;

    public h0(h hVar) {
        this.f3914c = hVar;
    }

    public void a(long j) {
        this.f3916f = j;
        if (this.f3915d) {
            this.q = this.f3914c.elapsedRealtime();
        }
    }

    public void b() {
        if (!this.f3915d) {
            this.q = this.f3914c.elapsedRealtime();
            this.f3915d = true;
        }
    }

    @Override // com.google.android.exoplayer2.util.w
    public t1 c() {
        return this.x;
    }

    public void d() {
        if (this.f3915d) {
            a(p());
            this.f3915d = false;
        }
    }

    @Override // com.google.android.exoplayer2.util.w
    public void e(t1 t1Var) {
        if (this.f3915d) {
            a(p());
        }
        this.x = t1Var;
    }

    @Override // com.google.android.exoplayer2.util.w
    public long p() {
        long j;
        long j2 = this.f3916f;
        if (!this.f3915d) {
            return j2;
        }
        long elapsedRealtime = this.f3914c.elapsedRealtime() - this.q;
        t1 t1Var = this.x;
        if (t1Var.f3437c == 1.0f) {
            j = w0.d(elapsedRealtime);
        } else {
            j = t1Var.a(elapsedRealtime);
        }
        return j2 + j;
    }
}
