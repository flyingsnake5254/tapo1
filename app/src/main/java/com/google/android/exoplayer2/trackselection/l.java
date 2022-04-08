package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.x;

/* compiled from: TrackSelectionUtil.java */
/* loaded from: classes.dex */
public final class l {
    public static x.a a(g gVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = gVar.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (gVar.f(i2, elapsedRealtime)) {
                i++;
            }
        }
        return new x.a(1, 0, length, i);
    }
}
