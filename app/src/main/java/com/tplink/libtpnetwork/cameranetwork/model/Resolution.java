package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class Resolution {
    private final String resolution;
    private final String secname;

    public Resolution(String secname, String resolution) {
        j.e(secname, "secname");
        j.e(resolution, "resolution");
        this.secname = secname;
        this.resolution = resolution;
    }

    public static /* synthetic */ Resolution copy$default(Resolution resolution, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resolution.secname;
        }
        if ((i & 2) != 0) {
            str2 = resolution.resolution;
        }
        return resolution.copy(str, str2);
    }

    public final String component1() {
        return this.secname;
    }

    public final String component2() {
        return this.resolution;
    }

    public final Resolution copy(String secname, String resolution) {
        j.e(secname, "secname");
        j.e(resolution, "resolution");
        return new Resolution(secname, resolution);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Resolution)) {
            return false;
        }
        Resolution resolution = (Resolution) obj;
        return j.a(this.secname, resolution.secname) && j.a(this.resolution, resolution.resolution);
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final String getSecname() {
        return this.secname;
    }

    public int hashCode() {
        String str = this.secname;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.resolution;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Resolution(secname=" + this.secname + ", resolution=" + this.resolution + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Resolution(ResolutionType resolutionType) {
        this("main", resolutionType.toString());
        j.e(resolutionType, "resolutionType");
    }
}
