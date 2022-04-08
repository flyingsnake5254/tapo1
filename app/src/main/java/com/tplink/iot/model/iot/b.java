package com.tplink.iot.model.iot;

import androidx.annotation.DrawableRes;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: FeaturedActionDeviceSelectBean.kt */
/* loaded from: classes2.dex */
public final class b {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8162b;

    /* renamed from: c  reason: collision with root package name */
    private final EnumIoTCategory f8163c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8164d;

    public b(@DrawableRes int i, String name, EnumIoTCategory category, String url) {
        j.e(name, "name");
        j.e(category, "category");
        j.e(url, "url");
        this.a = i;
        this.f8162b = name;
        this.f8163c = category;
        this.f8164d = url;
    }

    public final EnumIoTCategory a() {
        return this.f8163c;
    }

    public final int b() {
        return this.a;
    }

    public final String c() {
        return this.f8162b;
    }

    public final String d() {
        return this.f8164d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && j.a(this.f8162b, bVar.f8162b) && j.a(this.f8163c, bVar.f8163c) && j.a(this.f8164d, bVar.f8164d);
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.f8162b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        EnumIoTCategory enumIoTCategory = this.f8163c;
        int hashCode2 = (hashCode + (enumIoTCategory != null ? enumIoTCategory.hashCode() : 0)) * 31;
        String str2 = this.f8164d;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "DevicePlaceholder(iconRes=" + this.a + ", name=" + this.f8162b + ", category=" + this.f8163c + ", url=" + this.f8164d + ")";
    }

    public /* synthetic */ b(int i, String str, EnumIoTCategory enumIoTCategory, String str2, int i2, f fVar) {
        this(i, str, enumIoTCategory, (i2 & 8) != 0 ? "https://www.tapo.com/en/" : str2);
    }
}
