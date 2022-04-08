package com.tplink.iot.Utils;

import android.content.Context;

/* compiled from: DensityUtils.java */
/* loaded from: classes2.dex */
public class k {
    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
