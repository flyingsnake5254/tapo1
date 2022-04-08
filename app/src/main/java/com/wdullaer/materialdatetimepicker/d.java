package com.wdullaer.materialdatetimepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* compiled from: Utils.java */
/* loaded from: classes3.dex */
public class d {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 16;
    }

    @SuppressLint({"NewApi"})
    public static void b(View view, CharSequence charSequence) {
        if (a() && view != null && charSequence != null) {
            view.announceForAccessibility(charSequence);
        }
    }
}
