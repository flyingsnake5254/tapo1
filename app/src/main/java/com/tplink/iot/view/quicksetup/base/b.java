package com.tplink.iot.view.quicksetup.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import b.d.w.c.a;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.z0.q;
import com.tplink.iot.view.ipcamera.onboardingv2.CameraOnBoardingV2Activity;
import com.tplink.iot.view.pse.PSEOnBoardingTipsActivity;
import com.tplink.iot.view.quicksetup.ble.BleAddPlugActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbGuideFirstActivity;
import com.tplink.iot.view.quicksetup.common.SelectCategoryNewActivity;
import com.tplink.iot.view.quicksetup.lightstrip.LightStripConnectPartsGuideActivity;
import com.tplink.iot.view.quicksetup.plug.SoftApPlugGuideActivity;
import com.tplink.iot.view.quicksetup.softap.common.SoftApCommonGuideActivity;
import com.tplink.iot.view.quicksetup.sub.SubGOnBoardingActivity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: QuickSetupCategoryUtils.java */
/* loaded from: classes2.dex */
public class b {
    private static final List<String> a;

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f9512b;

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f9513c;

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f9514d;

    /* renamed from: e  reason: collision with root package name */
    private static final List<String> f9515e;

    /* renamed from: f  reason: collision with root package name */
    private static final List<String> f9516f;
    private static final List<String> g;
    private static final List<String> h;
    private static final List<String> i;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        f9512b = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        f9513c = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        f9514d = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        f9515e = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        f9516f = arrayList6;
        ArrayList arrayList7 = new ArrayList();
        g = arrayList7;
        ArrayList arrayList8 = new ArrayList();
        h = arrayList8;
        ArrayList arrayList9 = new ArrayList();
        i = arrayList9;
        arrayList9.add("C110");
        arrayList9.add("C210");
        arrayList9.add("C310");
        arrayList9.add("C320WS");
        arrayList9.add("P100");
        arrayList9.add("P105");
        arrayList9.add("L530");
        arrayList9.add("L900");
        arrayList9.add("L920");
        arrayList9.add("L930");
        arrayList9.add("L930");
        arrayList9.add("T100");
        arrayList9.add("T110");
        arrayList9.add("H100");
        arrayList.add("C100");
        arrayList.add("C110");
        arrayList.add("C200");
        arrayList.add("C210");
        arrayList.add("C310");
        arrayList.add("C320WS");
        arrayList.add("TC60");
        arrayList.add("TC65");
        arrayList.add("TC70");
        arrayList2.add("P100");
        arrayList2.add("P105");
        arrayList2.add("P110");
        arrayList2.add("P115");
        arrayList3.add("L510");
        arrayList3.add("L520");
        arrayList3.add("L530");
        arrayList4.add("L900");
        arrayList4.add("L920");
        arrayList5.add("H100");
        arrayList6.add("T100");
        arrayList6.add("T110");
        arrayList7.add("S200B");
        arrayList7.add("S210");
        arrayList7.add("S220");
        arrayList8.add("E100");
    }

    public static List<String> a() {
        return f9513c;
    }

    public static List<String> b() {
        return a;
    }

    public static List<String> c() {
        return f9515e;
    }

    public static List<String> d() {
        return f9514d;
    }

    public static List<String> e() {
        return f9512b;
    }

    private static void f(Activity activity, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("device", str);
        Intent intent = new Intent(activity, CameraOnBoardingV2Activity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void g(Activity activity, String str) {
        if (j(str)) {
            f(activity, str);
        } else if (m(str)) {
            if ("P105".equals(str) && w.b()) {
                PSEOnBoardingTipsActivity.h1(activity, str);
            } else if (q.j(str)) {
                SoftApPlugGuideActivity.G1(activity, str);
            } else {
                BleAddPlugActivity.C1(activity, str);
            }
        } else if (i(str)) {
            SoftAPBulbGuideFirstActivity.g1(activity, str);
        } else if (l(str)) {
            LightStripConnectPartsGuideActivity.g1(activity, str);
        } else if (k(str)) {
            SoftApCommonGuideActivity.D1(activity, str);
        } else if (n(str) || o(str) || p(str)) {
            SubGOnBoardingActivity.F1(activity, str);
        }
    }

    public static void h(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            activity.startActivity(new Intent(activity, SelectCategoryNewActivity.class));
            return;
        }
        a.d("original deviceModel=" + str);
        for (String str2 : a) {
            if (str.startsWith(str2)) {
                a.d("camera deviceModel=" + str2);
                f(activity, str2);
                return;
            }
        }
        for (String str3 : f9512b) {
            if (str.startsWith(str3)) {
                a.d("plug deviceModel=" + str3);
                BleAddPlugActivity.C1(activity, str3);
                return;
            }
        }
        for (String str4 : f9513c) {
            if (str.startsWith(str4)) {
                a.d("bulb deviceModel=" + str4);
                SoftAPBulbGuideFirstActivity.g1(activity, str4);
                return;
            }
        }
        for (String str5 : f9514d) {
            if (str.startsWith(str5)) {
                a.d("bulb deviceModel=" + str5);
                LightStripConnectPartsGuideActivity.g1(activity, str5);
                return;
            }
        }
        if (k(str)) {
            SoftApCommonGuideActivity.D1(activity, str);
        } else if (n(str) || o(str) || p(str)) {
            SubGOnBoardingActivity.F1(activity, str);
        } else {
            activity.startActivity(new Intent(activity, SelectCategoryNewActivity.class));
        }
    }

    private static boolean i(String str) {
        return f9513c.contains(str);
    }

    private static boolean j(String str) {
        return a.contains(str);
    }

    private static boolean k(String str) {
        return f9515e.contains(str);
    }

    private static boolean l(String str) {
        return f9514d.contains(str);
    }

    private static boolean m(String str) {
        return f9512b.contains(str);
    }

    private static boolean n(String str) {
        return f9516f.contains(str);
    }

    private static boolean o(String str) {
        return g.contains(str);
    }

    private static boolean p(String str) {
        return h.contains(str);
    }
}
