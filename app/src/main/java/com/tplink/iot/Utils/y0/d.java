package com.tplink.iot.Utils.y0;

import android.content.Context;
import android.os.Looper;
import com.bumptech.glide.c;

/* compiled from: GlideClearUtils.java */
/* loaded from: classes2.dex */
public class d {
    public static void a(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c.c(context).b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
