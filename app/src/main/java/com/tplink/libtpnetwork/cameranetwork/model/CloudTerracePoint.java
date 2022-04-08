package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class CloudTerracePoint {
    private final String name;
    @c("save_ptz")
    private final String xyz;

    public CloudTerracePoint(String name, String xyz) {
        j.e(name, "name");
        j.e(xyz, "xyz");
        this.name = name;
        this.xyz = xyz;
    }

    public static /* synthetic */ CloudTerracePoint copy$default(CloudTerracePoint cloudTerracePoint, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cloudTerracePoint.name;
        }
        if ((i & 2) != 0) {
            str2 = cloudTerracePoint.xyz;
        }
        return cloudTerracePoint.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.xyz;
    }

    public final CloudTerracePoint copy(String name, String xyz) {
        j.e(name, "name");
        j.e(xyz, "xyz");
        return new CloudTerracePoint(name, xyz);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudTerracePoint)) {
            return false;
        }
        CloudTerracePoint cloudTerracePoint = (CloudTerracePoint) obj;
        return j.a(this.name, cloudTerracePoint.name) && j.a(this.xyz, cloudTerracePoint.xyz);
    }

    public final String getName() {
        return this.name;
    }

    public final String getXyz() {
        return this.xyz;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.xyz;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CloudTerracePoint(name=" + this.name + ", xyz=" + this.xyz + ")";
    }
}
