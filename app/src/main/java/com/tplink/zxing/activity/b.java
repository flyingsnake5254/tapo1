package com.tplink.zxing.activity;

import android.content.Context;
import android.util.DisplayMetrics;
import b.d.e0.a;

/* compiled from: ZXingLibrary.java */
/* loaded from: classes3.dex */
public class b {
    public static void a(Context context) {
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            a.f394c = displayMetrics.density;
            a.f395d = displayMetrics.densityDpi;
            int i = displayMetrics.widthPixels;
            a.a = i;
            a.f393b = displayMetrics.heightPixels;
            a.f396e = a.a(context, i);
            a.f397f = a.a(context, displayMetrics.heightPixels);
        }
    }
}
