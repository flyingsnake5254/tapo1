package com.tplink.iot.Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;

/* compiled from: ImageTransitionUtils.java */
/* loaded from: classes2.dex */
public class q {
    public static void a(Context context, View view, int i, int i2, int i3) {
        if (context != null && view != null) {
            try {
                TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{context.getResources().getDrawable(i), context.getResources().getDrawable(i2)});
                view.setBackground(transitionDrawable);
                transitionDrawable.startTransition(i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
