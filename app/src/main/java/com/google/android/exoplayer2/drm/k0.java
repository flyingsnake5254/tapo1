package com.google.android.exoplayer2.drm;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: WidevineUtil.java */
/* loaded from: classes.dex */
public final class k0 {
    private static long a(Map<String, String> map, String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            String str2 = map.get(str);
            if (str2 != null) {
                return Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }

    @Nullable
    public static Pair<Long, Long> b(DrmSession drmSession) {
        Map<String, String> g = drmSession.g();
        if (g == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(a(g, "LicenseDurationRemaining")), Long.valueOf(a(g, "PlaybackDurationRemaining")));
    }
}
