package com.google.android.exoplayer2.text;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.f;
import com.google.android.exoplayer2.util.g;
import java.util.List;

/* compiled from: SubtitleOutputBuffer.java */
/* loaded from: classes.dex */
public abstract class j extends f implements f {
    @Nullable
    private f q;
    private long x;

    @Override // com.google.android.exoplayer2.text.f
    public int a(long j) {
        return ((f) g.e(this.q)).a(j - this.x);
    }

    @Override // com.google.android.exoplayer2.text.f
    public List<c> b(long j) {
        return ((f) g.e(this.q)).b(j - this.x);
    }

    @Override // com.google.android.exoplayer2.text.f
    public long c(int i) {
        return ((f) g.e(this.q)).c(i) + this.x;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int d() {
        return ((f) g.e(this.q)).d();
    }

    @Override // com.google.android.exoplayer2.decoder.a
    public void f() {
        super.f();
        this.q = null;
    }

    public void o(long j, f fVar, long j2) {
        this.f2170d = j;
        this.q = fVar;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.x = j;
    }
}
