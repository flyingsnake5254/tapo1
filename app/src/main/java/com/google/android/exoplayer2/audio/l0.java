package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.o0;

/* compiled from: WavUtil.java */
/* loaded from: classes.dex */
public final class l0 {
    public static int a(int i, int i2) {
        if (i != 1) {
            if (i == 3) {
                return i2 == 32 ? 4 : 0;
            }
            if (i != 65534) {
                return 0;
            }
        }
        return o0.U(i2);
    }
}
