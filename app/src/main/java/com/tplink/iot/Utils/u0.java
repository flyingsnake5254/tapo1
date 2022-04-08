package com.tplink.iot.Utils;

import android.content.Context;
import android.os.Vibrator;
import com.tplink.libtpnetwork.Utils.o;

/* compiled from: VibrateUtils.java */
/* loaded from: classes2.dex */
public class u0 {
    public static void a(Context context, long j) {
        if (b()) {
            ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
        }
    }

    public static boolean b() {
        return o.h0().f0();
    }

    public static void c(boolean z) {
        o.h0().j1(z);
    }
}
