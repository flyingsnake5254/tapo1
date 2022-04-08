package com.google.android.exoplayer2.source.u0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.g;

/* compiled from: MediaChunk.java */
/* loaded from: classes.dex */
public abstract class d extends b {
    public final long j;

    public d(l lVar, n nVar, Format format, int i, @Nullable Object obj, long j, long j2, long j3) {
        super(lVar, nVar, 1, format, i, obj, j, j2);
        g.e(format);
        this.j = j3;
    }

    public long g() {
        long j = this.j;
        if (j != -1) {
            return 1 + j;
        }
        return -1L;
    }
}
