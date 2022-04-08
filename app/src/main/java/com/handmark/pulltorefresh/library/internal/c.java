package com.handmark.pulltorefresh.library.internal;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* compiled from: ViewCompat.java */
/* loaded from: classes2.dex */
public class c {

    /* compiled from: ViewCompat.java */
    @TargetApi(16)
    /* loaded from: classes2.dex */
    static class a {
        public static void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public static void b(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            a.a(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    public static void b(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            a.b(view, drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
