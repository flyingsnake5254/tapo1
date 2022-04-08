package com.tplink.iot.Utils;

import android.content.Context;

/* compiled from: ResUtils.java */
/* loaded from: classes2.dex */
public class b0 {
    private static Context a;

    public static String a(int i) {
        return a.getString(i);
    }

    public static final void b(Context context) {
        a = context;
    }
}
