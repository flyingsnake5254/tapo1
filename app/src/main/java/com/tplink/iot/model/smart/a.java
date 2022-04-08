package com.tplink.iot.model.smart;

import kotlin.jvm.internal.j;

/* compiled from: DeviceTriggerSingleChoiceBean.kt */
/* loaded from: classes2.dex */
public final class a {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f8191b;

    /* renamed from: c  reason: collision with root package name */
    private Object f8192c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8193d;

    /* renamed from: e  reason: collision with root package name */
    private String f8194e;

    public a(String triggerId, String triggerText, Object obj, boolean z, String str) {
        j.e(triggerId, "triggerId");
        j.e(triggerText, "triggerText");
        this.a = triggerId;
        this.f8191b = triggerText;
        this.f8192c = obj;
        this.f8193d = z;
        this.f8194e = str;
    }

    public final Object a() {
        return this.f8192c;
    }

    public final boolean b() {
        return this.f8193d;
    }

    public final String c() {
        return this.f8194e;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.f8191b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.a(this.a, aVar.a) && j.a(this.f8191b, aVar.f8191b) && j.a(this.f8192c, aVar.f8192c) && this.f8193d == aVar.f8193d && j.a(this.f8194e, aVar.f8194e);
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8191b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj = this.f8192c;
        int hashCode3 = (hashCode2 + (obj != null ? obj.hashCode() : 0)) * 31;
        boolean z = this.f8193d;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode3 + i2) * 31;
        String str3 = this.f8194e;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return i5 + i;
    }

    public String toString() {
        return "DeviceTriggerSingleChoiceBean(triggerId=" + this.a + ", triggerText=" + this.f8191b + ", data=" + this.f8192c + ", enabled=" + this.f8193d + ", subTitle=" + this.f8194e + ")";
    }
}
