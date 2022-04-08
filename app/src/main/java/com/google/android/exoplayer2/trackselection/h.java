package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.u0.d;
import com.google.android.exoplayer2.source.u0.e;
import java.util.List;

/* compiled from: FixedTrackSelection.java */
/* loaded from: classes.dex */
public final class h extends e {
    private final int h;
    @Nullable
    private final Object i;

    public h(TrackGroup trackGroup, int i, int i2) {
        this(trackGroup, i, i2, 0, null);
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public int d() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    @Nullable
    public Object j() {
        return this.i;
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public void q(long j, long j2, long j3, List<? extends d> list, e[] eVarArr) {
    }

    @Override // com.google.android.exoplayer2.trackselection.g
    public int t() {
        return this.h;
    }

    public h(TrackGroup trackGroup, int i, int i2, int i3, @Nullable Object obj) {
        super(trackGroup, new int[]{i}, i2);
        this.h = i3;
        this.i = obj;
    }
}
