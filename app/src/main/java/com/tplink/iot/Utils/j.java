package com.tplink.iot.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import b.d.w.c.a;
import com.tplink.libtpnetwork.cameranetwork.bean.listing.ColumnFilter;

/* compiled from: DPUtils.java */
/* loaded from: classes2.dex */
public class j {
    public static int a(Context context, float f2) {
        if (context == null) {
            return 0;
        }
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context) {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i != 0) {
            return i;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return i;
        }
    }

    private static boolean c(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean d(Context context) {
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean e(FragmentActivity fragmentActivity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28 && fragmentActivity != null) {
            return (fragmentActivity.getWindow() == null || fragmentActivity.getWindow().getDecorView().getRootWindowInsets() == null || fragmentActivity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout() == null) ? false : true;
        }
        if (i > 26) {
            String str = Build.MANUFACTURER;
            a.a("isPhoneHasDisplayCutout manufacturer: " + str);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.equalsIgnoreCase("huawei")) {
                return c(fragmentActivity);
            }
            if (str.equalsIgnoreCase("xiaomi")) {
                return h();
            }
            if (str.equalsIgnoreCase("samsung")) {
                return f(fragmentActivity);
            }
            if (str.equalsIgnoreCase("oppo")) {
                return d(fragmentActivity);
            }
            if (str.equalsIgnoreCase("vivo")) {
                return g();
            }
        }
        return false;
    }

    private static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", ColumnFilter.TYPE_STRING, "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string != null) {
                return !TextUtils.isEmpty(string);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean g() {
        try {
            Class<?> cls = Class.forName("android.util.FtFeature");
            return ((Boolean) cls.getMethod("isFeatureSupport", Integer.TYPE).invoke(cls, 32)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean h() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Integer) cls.getMethod("getInt", String.class, Integer.TYPE).invoke(cls, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception unused) {
            return false;
        }
    }
}
