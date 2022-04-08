package com.tplink.iot.model.about;

import android.text.TextUtils;
import b.d.s.a.a;

/* compiled from: AboutConstants.java */
/* loaded from: classes2.dex */
public class b {
    private static String a() {
        String cloudUserName = a.f().c().getCloudUserName();
        return !TextUtils.isEmpty(cloudUserName) ? b.d.w.h.a.g(cloudUserName) : "";
    }

    public static String b() {
        return "user_improvement_version_code_" + a();
    }

    public static String c() {
        return "upload_user_experience_improvement_enable_" + a();
    }
}
