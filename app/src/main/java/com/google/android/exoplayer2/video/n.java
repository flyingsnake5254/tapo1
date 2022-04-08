package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.d0;

/* compiled from: DolbyVisionConfig.java */
/* loaded from: classes.dex */
public final class n {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4010b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4011c;

    private n(int i, int i2, String str) {
        this.a = i;
        this.f4010b = i2;
        this.f4011c = str;
    }

    @Nullable
    public static n a(d0 d0Var) {
        String str;
        d0Var.Q(2);
        int D = d0Var.D();
        int i = D >> 1;
        int D2 = ((d0Var.D() >> 3) & 31) | ((D & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else if (i != 9) {
            return null;
        } else {
            str = "avc3";
        }
        String str2 = D2 < 10 ? ".0" : ".";
        StringBuilder sb = new StringBuilder(str.length() + 24 + str2.length());
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(str2);
        sb.append(D2);
        return new n(i, D2, sb.toString());
    }
}
