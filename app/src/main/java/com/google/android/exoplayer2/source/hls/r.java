package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.l0;

/* compiled from: TimestampAdjusterProvider.java */
/* loaded from: classes.dex */
public final class r {
    private final SparseArray<l0> a = new SparseArray<>();

    public l0 a(int i) {
        l0 l0Var = this.a.get(i);
        if (l0Var != null) {
            return l0Var;
        }
        l0 l0Var2 = new l0(9223372036854775806L);
        this.a.put(i, l0Var2);
        return l0Var2;
    }

    public void b() {
        this.a.clear();
    }
}
