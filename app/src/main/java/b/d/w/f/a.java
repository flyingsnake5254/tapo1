package b.d.w.f;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/* compiled from: DisplayUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean b(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = false;
        boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
            if (!"1".equals(str)) {
                z = "0".equals(str) ? true : z2;
            }
            return z;
        } catch (Exception e2) {
            b.d.w.c.a.d(e2.toString());
            return z2;
        }
    }

    public static int c(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return 0;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    public static int d(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return 0;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    public static int e(Activity activity) {
        if (activity == null) {
            return 0;
        }
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return (activity.getWindow().getDecorView().getHeight() - (rect.bottom - rect.top)) - f(activity);
    }

    public static int f(Context context) {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i != 0) {
            return i;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            Object obj = cls.getField("status_bar_height").get(cls.newInstance());
            return obj != null ? context.getResources().getDimensionPixelSize(Integer.parseInt(obj.toString())) : i;
        } catch (Exception e2) {
            b.d.w.c.a.d(e2.toString());
            return i;
        }
    }

    public static void g(Activity activity) {
        h(activity, 0);
    }

    public static void h(Activity activity, int i) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), i);
        }
    }

    public static void i(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.putExtra("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            b.d.w.c.a.d(e2.toString());
        }
    }

    public static void j(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null && activity.getCurrentFocus() != null) {
            inputMethodManager.showSoftInput(activity.getCurrentFocus(), 2);
        }
    }

    public static int k(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
