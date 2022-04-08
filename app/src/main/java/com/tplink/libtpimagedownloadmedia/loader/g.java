package com.tplink.libtpimagedownloadmedia.loader;

import androidx.annotation.NonNull;

/* compiled from: ImageInfo.java */
/* loaded from: classes3.dex */
public class g {
    @NonNull
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f12524b;

    /* renamed from: c  reason: collision with root package name */
    private int f12525c;

    /* renamed from: e  reason: collision with root package name */
    private int f12527e = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f12526d = 2;

    public g(String str, int i, String str2) {
        this.a = str;
        this.f12525c = i;
        this.f12524b = str2;
    }

    public int a() {
        return this.f12525c;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.f12524b;
    }

    public int d() {
        return this.f12526d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return b().equals(gVar.b()) && c().equals(gVar.c()) && d() == gVar.d();
    }

    public int hashCode() {
        return (c().hashCode() * 31) + b().hashCode();
    }
}
