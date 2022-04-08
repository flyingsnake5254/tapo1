package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.w;
import java.io.IOException;

/* compiled from: BaseRenderer.java */
/* loaded from: classes.dex */
public abstract class u0 implements b2, d2 {
    private boolean H3;

    /* renamed from: c  reason: collision with root package name */
    private final int f3655c;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private e2 f3657f;
    private long p0;
    private long p1;
    private boolean p3;
    private int q;
    private int x;
    @Nullable
    private n0 y;
    @Nullable
    private Format[] z;

    /* renamed from: d  reason: collision with root package name */
    private final i1 f3656d = new i1();
    private long p2 = Long.MIN_VALUE;

    public u0(int i) {
        this.f3655c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final i1 A() {
        this.f3656d.a();
        return this.f3656d;
    }

    protected final int B() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Format[] C() {
        return (Format[]) g.e(this.z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean D() {
        return i() ? this.p3 : ((n0) g.e(this.y)).g();
    }

    protected abstract void E();

    protected void F(boolean z, boolean z2) throws ExoPlaybackException {
    }

    protected abstract void G(long j, boolean z) throws ExoPlaybackException;

    protected void H() {
    }

    protected void I() throws ExoPlaybackException {
    }

    protected void J() {
    }

    protected void K(Format[] formatArr, long j, long j2) throws ExoPlaybackException {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int L(i1 i1Var, DecoderInputBuffer decoderInputBuffer, int i) {
        int b2 = ((n0) g.e(this.y)).b(i1Var, decoderInputBuffer, i);
        if (b2 == -4) {
            if (decoderInputBuffer.k()) {
                this.p2 = Long.MIN_VALUE;
                return this.p3 ? -4 : -3;
            }
            long j = decoderInputBuffer.x + this.p0;
            decoderInputBuffer.x = j;
            this.p2 = Math.max(this.p2, j);
        } else if (b2 == -5) {
            Format format = (Format) g.e(i1Var.f2321b);
            if (format.L3 != Long.MAX_VALUE) {
                i1Var.f2321b = format.a().i0(format.L3 + this.p0).E();
            }
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M(long j) {
        return ((n0) g.e(this.y)).c(j - this.p0);
    }

    @Override // com.google.android.exoplayer2.b2
    public final void b() {
        boolean z = true;
        if (this.x != 1) {
            z = false;
        }
        g.g(z);
        this.f3656d.a();
        this.x = 0;
        this.y = null;
        this.z = null;
        this.p3 = false;
        E();
    }

    @Override // com.google.android.exoplayer2.b2, com.google.android.exoplayer2.d2
    public final int f() {
        return this.f3655c;
    }

    @Override // com.google.android.exoplayer2.b2
    public final int getState() {
        return this.x;
    }

    @Override // com.google.android.exoplayer2.b2
    @Nullable
    public final n0 getStream() {
        return this.y;
    }

    @Override // com.google.android.exoplayer2.b2
    public final void h(int i) {
        this.q = i;
    }

    @Override // com.google.android.exoplayer2.b2
    public final boolean i() {
        return this.p2 == Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.b2
    public final void j() {
        this.p3 = true;
    }

    @Override // com.google.android.exoplayer2.x1.b
    public void k(int i, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.b2
    public final void l() throws IOException {
        ((n0) g.e(this.y)).a();
    }

    @Override // com.google.android.exoplayer2.b2
    public final boolean m() {
        return this.p3;
    }

    @Override // com.google.android.exoplayer2.b2
    public final void n(Format[] formatArr, n0 n0Var, long j, long j2) throws ExoPlaybackException {
        g.g(!this.p3);
        this.y = n0Var;
        if (this.p2 == Long.MIN_VALUE) {
            this.p2 = j;
        }
        this.z = formatArr;
        this.p0 = j2;
        K(formatArr, j, j2);
    }

    @Override // com.google.android.exoplayer2.b2
    public final d2 o() {
        return this;
    }

    @Override // com.google.android.exoplayer2.b2
    public /* synthetic */ void q(float f2, float f3) {
        a2.a(this, f2, f3);
    }

    @Override // com.google.android.exoplayer2.b2
    public final void r(e2 e2Var, Format[] formatArr, n0 n0Var, long j, boolean z, boolean z2, long j2, long j3) throws ExoPlaybackException {
        g.g(this.x == 0);
        this.f3657f = e2Var;
        this.x = 1;
        this.p1 = j;
        F(z, z2);
        n(formatArr, n0Var, j2, j3);
        G(j, z);
    }

    @Override // com.google.android.exoplayer2.b2
    public final void reset() {
        g.g(this.x == 0);
        this.f3656d.a();
        H();
    }

    public int s() throws ExoPlaybackException {
        return 0;
    }

    @Override // com.google.android.exoplayer2.b2
    public final void start() throws ExoPlaybackException {
        boolean z = true;
        if (this.x != 1) {
            z = false;
        }
        g.g(z);
        this.x = 2;
        I();
    }

    @Override // com.google.android.exoplayer2.b2
    public final void stop() {
        g.g(this.x == 2);
        this.x = 1;
        J();
    }

    @Override // com.google.android.exoplayer2.b2
    public final long u() {
        return this.p2;
    }

    @Override // com.google.android.exoplayer2.b2
    public final void v(long j) throws ExoPlaybackException {
        this.p3 = false;
        this.p1 = j;
        this.p2 = j;
        G(j, false);
    }

    @Override // com.google.android.exoplayer2.b2
    @Nullable
    public w w() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ExoPlaybackException x(Throwable th, @Nullable Format format, int i) {
        return y(th, format, false, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ExoPlaybackException y(Throwable th, @Nullable Format format, boolean z, int i) {
        int i2;
        if (format != null && !this.H3) {
            this.H3 = true;
            try {
                i2 = c2.d(a(format));
            } catch (ExoPlaybackException unused) {
            } finally {
                this.H3 = false;
            }
            return ExoPlaybackException.createForRenderer(th, getName(), B(), format, i2, z, i);
        }
        i2 = 4;
        return ExoPlaybackException.createForRenderer(th, getName(), B(), format, i2, z, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final e2 z() {
        return (e2) g.e(this.f3657f);
    }
}
