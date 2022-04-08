package com.tplink.iot.Utils;

import java.util.HashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: CameraLiveConfigManager.kt */
/* loaded from: classes2.dex */
final class g {
    private final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f5312b;

    public g() {
        this(false, null, 3, null);
    }

    public g(boolean z, HashMap<String, Integer> mapping) {
        j.e(mapping, "mapping");
        this.a = z;
        this.f5312b = mapping;
    }

    public final HashMap<String, Integer> a() {
        return this.f5312b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a == gVar.a && j.a(this.f5312b, gVar.f5312b);
    }

    public int hashCode() {
        boolean z = this.a;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        HashMap<String, Integer> hashMap = this.f5312b;
        return i4 + (hashMap != null ? hashMap.hashCode() : 0);
    }

    public String toString() {
        return "CameraLiveConfig(singleScreen=" + this.a + ", mapping=" + this.f5312b + ")";
    }

    public /* synthetic */ g(boolean z, HashMap hashMap, int i, f fVar) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? new HashMap() : hashMap);
    }
}
