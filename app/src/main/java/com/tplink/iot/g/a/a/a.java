package com.tplink.iot.g.a.a;

import kotlin.jvm.internal.j;

/* compiled from: FeaturedActionChooseItem.kt */
/* loaded from: classes2.dex */
public final class a {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7940b;

    public a(String id, String title) {
        j.e(id, "id");
        j.e(title, "title");
        this.a = id;
        this.f7940b = title;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.f7940b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.a(this.a, aVar.a) && j.a(this.f7940b, aVar.f7940b);
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f7940b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "FeaturedActionChooseItem(id=" + this.a + ", title=" + this.f7940b + ")";
    }
}
