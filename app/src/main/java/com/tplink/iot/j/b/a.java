package com.tplink.iot.j.b;

import java.text.Normalizer;

/* compiled from: Region.java */
/* loaded from: classes2.dex */
public class a {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f7999b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8000c;

    public a(String str, String str2, boolean z) {
        this.a = "";
        this.f7999b = "";
        this.f8000c = false;
        this.a = str;
        this.f7999b = str2;
        this.f8000c = z;
    }

    public static String e(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.f7999b;
    }

    public boolean c() {
        return this.f8000c;
    }

    public void d(boolean z) {
        this.f8000c = z;
    }
}
