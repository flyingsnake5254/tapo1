package com.tplink.iot.Utils.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import b.d.q.b.i;
import com.tplink.iot.Utils.u;
import com.tplink.iot.Utils.y0.d;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.model.about.c;
import com.tplink.iot.view.login.LoginActivity;
import com.tplink.libtpnetwork.Utils.o;
import java.util.Locale;

/* compiled from: LoginUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static String a(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            str = telephonyManager.getSimCountryIso();
            if (TextUtils.isEmpty(str)) {
                str = telephonyManager.getNetworkCountryIso();
            }
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getResources().getConfiguration().locale.getCountry();
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(c(context, str))) {
            return null;
        }
        return str;
    }

    public static String b(Context context) {
        String a = a(context);
        return a == null ? "" : a;
    }

    public static String c(Context context, String str) {
        try {
            int fromSymbol = CloudRegionCode.fromSymbol(str);
            if (-1 != fromSymbol) {
                return context.getString(fromSymbol);
            }
            return "";
        } catch (Exception unused) {
            b.d.w.c.a.e("LoginUtils", "getRegionStr error");
            return "";
        }
    }

    private static void d(Activity activity) {
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            Intent intent = new Intent(activity, LoginActivity.class);
            String b2 = i.b();
            if (!TextUtils.isEmpty(b2) && o.h0().u()) {
                intent.putExtra("SignUpEmail", b2);
            }
            intent.putExtra("SignUpE_pwd_error", true);
            activity.startActivity(intent);
        }
    }

    public static boolean e(Context context) {
        return Locale.US.getLanguage().equalsIgnoreCase(context.getResources().getConfiguration().locale.getLanguage());
    }

    public static boolean f(String str) {
        if (str == null) {
            return false;
        }
        return CloudRegionCode.isSymbolEuRegion(str);
    }

    public static void g(Activity activity) {
        u.a(activity);
        c.c();
        d.a(AppContext.f6185c);
        d(activity);
    }
}
