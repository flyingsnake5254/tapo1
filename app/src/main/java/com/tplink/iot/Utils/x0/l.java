package com.tplink.iot.Utils.x0;

import kotlin.jvm.internal.j;

/* compiled from: CommonFireBaseUtils.kt */
/* loaded from: classes2.dex */
public final class l {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f5382b;

    public l(String str, Object obj) {
        this.a = str;
        this.f5382b = obj;
    }

    public final String a() {
        return this.a;
    }

    public final Object b() {
        return this.f5382b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return j.a(this.a, lVar.a) && j.a(this.f5382b, lVar.f5382b);
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.f5382b;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "EventValuePair(key=" + this.a + ", value=" + this.f5382b + ")";
    }
}
