package uk.co.senab.photoview;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import androidx.core.view.MotionEventCompat;

/* compiled from: Compat.java */
/* loaded from: classes4.dex */
public class a {
    public static int a(int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            return c(i);
        }
        return b(i);
    }

    @TargetApi(5)
    private static int b(int i) {
        return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    @TargetApi(11)
    private static int c(int i) {
        return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static void d(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            e(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    @TargetApi(16)
    private static void e(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
