package com.tplink.libtpanalytics.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: TPSharePrefence.java */
@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes3.dex */
public class k {
    private SharedPreferences a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f12011b;

    public k(Context context, String str) {
        this.a = null;
        this.f12011b = null;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.a = sharedPreferences;
        this.f12011b = sharedPreferences.edit();
    }

    public long a(String str, long j) {
        return this.a.getLong(str, j);
    }

    public String b(String str, String str2) {
        return this.a.getString(str, str2);
    }

    public void c(String str, long j) {
        this.f12011b.putLong(str, j);
        this.f12011b.commit();
    }

    public void d(String str, String str2) {
        this.f12011b.putString(str, str2);
        this.f12011b.commit();
    }
}
