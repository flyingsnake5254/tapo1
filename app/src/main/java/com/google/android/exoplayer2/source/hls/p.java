package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;

/* compiled from: HlsSampleStream.java */
/* loaded from: classes.dex */
final class p implements n0 {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final q f3272b;

    /* renamed from: c  reason: collision with root package name */
    private int f3273c = -1;

    public p(q qVar, int i) {
        this.f3272b = qVar;
        this.a = i;
    }

    private boolean e() {
        int i = this.f3273c;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    @Override // com.google.android.exoplayer2.source.n0
    public void a() throws IOException {
        int i = this.f3273c;
        if (i == -2) {
            throw new SampleQueueMappingException(this.f3272b.s().a(this.a).a(0).H3);
        } else if (i == -1) {
            this.f3272b.T();
        } else if (i != -3) {
            this.f3272b.U(i);
        }
    }

    @Override // com.google.android.exoplayer2.source.n0
    public int b(i1 i1Var, DecoderInputBuffer decoderInputBuffer, int i) {
        if (this.f3273c == -3) {
            decoderInputBuffer.e(4);
            return -4;
        } else if (e()) {
            return this.f3272b.d0(this.f3273c, i1Var, decoderInputBuffer, i);
        } else {
            return -3;
        }
    }

    @Override // com.google.android.exoplayer2.source.n0
    public int c(long j) {
        if (e()) {
            return this.f3272b.n0(this.f3273c, j);
        }
        return 0;
    }

    public void d() {
        g.a(this.f3273c == -1);
        this.f3273c = this.f3272b.w(this.a);
    }

    public void f() {
        if (this.f3273c != -1) {
            this.f3272b.o0(this.a);
            this.f3273c = -1;
        }
    }

    @Override // com.google.android.exoplayer2.source.n0
    public boolean g() {
        return this.f3273c == -3 || (e() && this.f3272b.O(this.f3273c));
    }
}
