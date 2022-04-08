package com.tplink.iot.Utils.v0;

import com.tplink.iot.core.n;
import com.tplink.libtpnetwork.Utils.a0;
import com.tplink.libtpnetwork.Utils.x;

/* compiled from: TapoCareUtils.java */
/* loaded from: classes2.dex */
public class e {
    private static final String a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f5366b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f5367c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f5368d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f5369e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f5370f;
    private static final String g;

    static {
        String h = a0.h();
        a = h;
        f5366b = h + "/tapo_app/#/";
        f5367c = h + "/tapo_app/#/tapolist";
        f5368d = h + "/tapo_app/#/intro/subscribe/";
        f5369e = h + "/tapo_app/#/intro/trial/";
        f5370f = h + "/tapo_app/#/reselect-devices";
        g = h + "/tapo_app/#/trialCancel";
    }

    private static String a() {
        return "termID=" + n.a + "&ospf=" + n.f6222b + "&appName=" + n.f6224d + "&netType=wifi&platform=android&lang=" + x.c() + "&environment=" + b() + "&usertoken=";
    }

    private static String b() {
        return "prd";
    }

    public static String c(String str) {
        return f5368d + e() + c.a() + "&deviceId=" + str;
    }

    public static String d(String str) {
        return f5369e + e() + c.a() + "&deviceId=" + str;
    }

    private static String e() {
        return "AIDetection?" + a();
    }

    public static String f() {
        return f5366b + p() + c.a();
    }

    public static String g(String str) {
        return f5366b + p() + c.a() + "&deviceId=" + str;
    }

    private static String h() {
        return "CloudVideo?" + a();
    }

    public static String i(String str) {
        return f5368d + h() + c.a() + "&deviceId=" + str;
    }

    public static String j() {
        return f5369e + h() + c.a() + "&status=ok";
    }

    public static String k(String str) {
        return f5369e + h() + c.a() + "&deviceId=" + str;
    }

    public static String l(String str, String str2) {
        return g + p() + c.a() + "&deviceId=" + str + "&deviceType=" + str2;
    }

    private static String m() {
        return "MotionTracking?" + a();
    }

    public static String n(String str) {
        return f5368d + m() + c.a() + "&deviceId=" + str;
    }

    public static String o(String str) {
        return f5369e + m() + c.a() + "&deviceId=" + str;
    }

    private static String p() {
        return "?" + a();
    }

    private static String q() {
        return "PrivacyMask?" + a();
    }

    public static String r(String str) {
        return f5368d + q() + c.a() + "&deviceId=" + str;
    }

    public static String s(String str) {
        return f5369e + q() + c.a() + "&deviceId=" + str;
    }

    private static String t() {
        return "RichNotification?" + a();
    }

    public static String u(String str) {
        return f5368d + t() + c.a() + "&deviceId=" + str;
    }

    public static String v(String str) {
        return f5369e + t() + c.a() + "&deviceId=" + str;
    }

    public static String w(String str, int i) {
        return f5370f + p() + c.a() + "&orderId=" + str + "&newDeviceNum=" + i;
    }

    public static String x() {
        return f5367c + p() + c.a();
    }
}
