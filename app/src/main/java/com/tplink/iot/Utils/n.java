package com.tplink.iot.Utils;

import android.content.Context;
import android.util.Base64;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.libtputility.security.PlainEncryptKeyDelegate;
import com.tplink.libtputility.security.c;

/* compiled from: FirebaseAnalyticsUtils.java */
/* loaded from: classes2.dex */
public class n {
    private static n a;

    /* renamed from: b  reason: collision with root package name */
    private static String f5353b;

    /* renamed from: c  reason: collision with root package name */
    private static String f5354c;

    /* renamed from: d  reason: collision with root package name */
    private static String f5355d;

    /* renamed from: e  reason: collision with root package name */
    private static String f5356e;

    /* renamed from: f  reason: collision with root package name */
    private FirebaseAnalytics f5357f;
    private c g;
    private Context h;
    private final int i = 100;

    private n() {
    }

    public static n b() {
        if (a == null) {
            a = new n();
        }
        return a;
    }

    private String c(String str) {
        try {
            return new String(Base64.encode(this.g.d(str), 2), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void a(boolean z) {
        FirebaseAnalytics firebaseAnalytics = this.f5357f;
        if (firebaseAnalytics != null) {
            firebaseAnalytics.setAnalyticsCollectionEnabled(z);
        }
    }

    public void d(Context context) {
        this.h = context;
        this.f5357f = FirebaseAnalytics.getInstance(context);
        this.g = new c.b().b(PlainEncryptKeyDelegate.e()).a();
    }

    public void e(String str, String str2) {
        f(str, str2, "");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:6|(3:8|(2:28|10)|12)(1:13)|14|(1:16)(5:17|(2:18|(2:(2:21|33)(2:22|32)|23)(0))|24|26|27)|30|24|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a8, code lost:
        b.d.w.c.a.a("FirebaseAnalytics logEvent exception");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r8 = this;
            com.tplink.iot.Utils.n r0 = com.tplink.iot.Utils.n.a
            if (r0 == 0) goto L_0x00b9
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L_0x000c
            goto L_0x00b9
        L_0x000c:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x0038
            java.lang.String r0 = b.d.s.a.a.d()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0033
            java.lang.Class<com.google.gson.k> r1 = com.google.gson.k.class
            java.lang.Object r1 = com.tplink.libtpnetwork.Utils.i.b(r11, r1)     // Catch: Exception -> 0x002e
            com.google.gson.k r1 = (com.google.gson.k) r1     // Catch: Exception -> 0x002e
            java.lang.String r2 = "account_id"
            r1.m(r2, r0)     // Catch: Exception -> 0x002e
            java.lang.String r11 = com.tplink.libtpnetwork.Utils.i.f(r1)     // Catch: Exception -> 0x002e
            goto L_0x0033
        L_0x002e:
            java.lang.String r0 = "FirebaseAnalytics gson exception"
            b.d.w.c.a.a(r0)
        L_0x0033:
            java.lang.String r0 = r8.c(r11)
            goto L_0x003a
        L_0x0038:
            java.lang.String r0 = ""
        L_0x003a:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "event_action"
            r1.putString(r2, r10)
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r3.putString(r2, r10)
            java.lang.String r2 = "event_label"
            r3.putString(r2, r11)
            b.d.c.c.a r11 = b.d.c.a.e.l()
            r11.f(r9, r3)
            int r11 = r0.length()
            java.lang.String r2 = "event_value"
            r3 = 100
            if (r11 > r3) goto L_0x0066
            r1.putString(r2, r0)
            goto L_0x00a2
        L_0x0066:
            r4 = 0
            r5 = 0
        L_0x0068:
            int r6 = r11 - r4
            if (r6 <= 0) goto L_0x00a2
            if (r6 <= r3) goto L_0x0087
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            int r7 = r4 + 100
            java.lang.String r7 = r0.substring(r4, r7)
            r1.putString(r6, r7)
            goto L_0x009d
        L_0x0087:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = r0.substring(r4, r11)
            r1.putString(r6, r7)
        L_0x009d:
            int r5 = r5 + 1
            int r4 = r4 + 100
            goto L_0x0068
        L_0x00a2:
            com.google.firebase.analytics.FirebaseAnalytics r11 = r8.f5357f     // Catch: Exception -> 0x00a8
            r11.logEvent(r9, r1)     // Catch: Exception -> 0x00a8
            goto L_0x00ad
        L_0x00a8:
            java.lang.String r11 = "FirebaseAnalytics logEvent exception"
            b.d.w.c.a.a(r11)
        L_0x00ad:
            java.lang.String r11 = com.tplink.iot.Utils.n.f5353b
            com.tplink.iot.Utils.n.f5354c = r11
            com.tplink.iot.Utils.n.f5353b = r9
            java.lang.String r9 = com.tplink.iot.Utils.n.f5355d
            com.tplink.iot.Utils.n.f5356e = r9
            com.tplink.iot.Utils.n.f5355d = r10
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.Utils.n.f(java.lang.String, java.lang.String, java.lang.String):void");
    }
}
