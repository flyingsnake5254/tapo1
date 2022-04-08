package com.tplink.libtpnetwork.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* compiled from: PreferenceHelper.java */
/* loaded from: classes3.dex */
public class k {
    private static k a;

    /* renamed from: b  reason: collision with root package name */
    private String f14073b = "PreferenceHelper";

    /* renamed from: c  reason: collision with root package name */
    private Context f14074c;

    /* renamed from: d  reason: collision with root package name */
    private String f14075d;

    /* renamed from: e  reason: collision with root package name */
    private SharedPreferences f14076e;

    /* renamed from: f  reason: collision with root package name */
    private b f14077f;

    private k() {
    }

    public static k a() {
        if (a == null) {
            synchronized (k.class) {
                if (a == null) {
                    a = new k();
                }
            }
        }
        return a;
    }

    private String b(String str, String str2) {
        return this.f14076e.getString(str, str2);
    }

    private void d(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = this.f14076e.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public void c(Context context, String str) {
        this.f14074c = context;
        this.f14075d = str;
        this.f14076e = context.getSharedPreferences("DecoSmartPrefsFile", 0);
        this.f14077f = new b(this.f14075d);
    }

    public boolean e(String str, boolean z) {
        return this.f14076e.getBoolean(str, z);
    }

    public String f(String str, String str2) {
        if (this.f14077f == null) {
            return b(str, str2);
        }
        try {
            return this.f14077f.c(b(str, str2), this.f14074c);
        } catch (Exception unused) {
            return str2;
        }
    }

    public void g(String str) {
        SharedPreferences.Editor edit = this.f14076e.edit();
        edit.remove(str);
        edit.commit();
    }

    public void h(String str, boolean z) {
        SharedPreferences.Editor edit = this.f14076e.edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    public void i(String str, String str2) {
        String f2;
        b bVar = this.f14077f;
        if (bVar != null) {
            if (str2 == null) {
                f2 = null;
            } else {
                try {
                    f2 = bVar.f(str2, this.f14074c);
                } catch (Exception unused) {
                    return;
                }
            }
            d(str, f2);
            return;
        }
        d(str, str2);
    }
}
