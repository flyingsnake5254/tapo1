package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class CoverConfigRegion {
    private final String height;
    private final String width;
    @c("x_coor")
    private final String x;
    @c("y_coor")
    private final String y;

    public CoverConfigRegion(String height, String width, String x, String y) {
        j.e(height, "height");
        j.e(width, "width");
        j.e(x, "x");
        j.e(y, "y");
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public static /* synthetic */ CoverConfigRegion copy$default(CoverConfigRegion coverConfigRegion, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = coverConfigRegion.height;
        }
        if ((i & 2) != 0) {
            str2 = coverConfigRegion.width;
        }
        if ((i & 4) != 0) {
            str3 = coverConfigRegion.x;
        }
        if ((i & 8) != 0) {
            str4 = coverConfigRegion.y;
        }
        return coverConfigRegion.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.height;
    }

    public final String component2() {
        return this.width;
    }

    public final String component3() {
        return this.x;
    }

    public final String component4() {
        return this.y;
    }

    public final CoverConfigRegion copy(String height, String width, String x, String y) {
        j.e(height, "height");
        j.e(width, "width");
        j.e(x, "x");
        j.e(y, "y");
        return new CoverConfigRegion(height, width, x, y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoverConfigRegion)) {
            return false;
        }
        CoverConfigRegion coverConfigRegion = (CoverConfigRegion) obj;
        return j.a(this.height, coverConfigRegion.height) && j.a(this.width, coverConfigRegion.width) && j.a(this.x, coverConfigRegion.x) && j.a(this.y, coverConfigRegion.y);
    }

    public final String getHeight() {
        return this.height;
    }

    public final String getWidth() {
        return this.width;
    }

    public final String getX() {
        return this.x;
    }

    public final String getY() {
        return this.y;
    }

    public int hashCode() {
        String str = this.height;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.width;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.x;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.y;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "CoverConfigRegion(height=" + this.height + ", width=" + this.width + ", x=" + this.x + ", y=" + this.y + ")";
    }

    public CoverConfigRegion(int i, int i2, int i3, int i4) {
        this(String.valueOf(i4), String.valueOf(i3), String.valueOf(i), String.valueOf(i2));
    }
}
