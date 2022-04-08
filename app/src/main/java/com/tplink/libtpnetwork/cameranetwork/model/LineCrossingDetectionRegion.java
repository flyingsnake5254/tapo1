package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class LineCrossingDetectionRegion {
    public static final Companion Companion = new Companion(null);
    private final String direction;
    @c("pt1_x")
    private final String point1X;
    @c("pt1_y")
    private final String point1Y;
    @c("pt2_x")
    private final String point2X;
    @c("pt2_y")
    private final String point2Y;
    private final String sensitivity;

    /* compiled from: Model.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements UnwrapFromResponse<List<? extends Map<String, ? extends LineCrossingDetectionRegion>>> {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        @Override // com.tplink.libtpnetwork.cameranetwork.model.UnwrapFromResponse
        /* renamed from: fromResponse  reason: avoid collision after fix types in other method */
        public List<? extends Map<String, ? extends LineCrossingDetectionRegion>> fromResponse2(Response<Wrappers> response) {
            j.e(response, "response");
            if (j.a(response.getMethod(), Method.GET_LINE_CROSSING_DETECTION_REGION.getValue())) {
                return (List) Model.typeCast(response.getResult(), Module.LINE_CROSSING_DETECTION, Section.REGION_INFO);
            }
            return null;
        }
    }

    public LineCrossingDetectionRegion(String point1X, String point1Y, String point2X, String point2Y, String str, String direction) {
        j.e(point1X, "point1X");
        j.e(point1Y, "point1Y");
        j.e(point2X, "point2X");
        j.e(point2Y, "point2Y");
        j.e(direction, "direction");
        this.point1X = point1X;
        this.point1Y = point1Y;
        this.point2X = point2X;
        this.point2Y = point2Y;
        this.sensitivity = str;
        this.direction = direction;
    }

    public static /* synthetic */ LineCrossingDetectionRegion copy$default(LineCrossingDetectionRegion lineCrossingDetectionRegion, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lineCrossingDetectionRegion.point1X;
        }
        if ((i & 2) != 0) {
            str2 = lineCrossingDetectionRegion.point1Y;
        }
        if ((i & 4) != 0) {
            str3 = lineCrossingDetectionRegion.point2X;
        }
        if ((i & 8) != 0) {
            str4 = lineCrossingDetectionRegion.point2Y;
        }
        if ((i & 16) != 0) {
            str5 = lineCrossingDetectionRegion.sensitivity;
        }
        if ((i & 32) != 0) {
            str6 = lineCrossingDetectionRegion.direction;
        }
        return lineCrossingDetectionRegion.copy(str, str2, str3, str4, str5, str6);
    }

    public final String component1() {
        return this.point1X;
    }

    public final String component2() {
        return this.point1Y;
    }

    public final String component3() {
        return this.point2X;
    }

    public final String component4() {
        return this.point2Y;
    }

    public final String component5() {
        return this.sensitivity;
    }

    public final String component6() {
        return this.direction;
    }

    public final LineCrossingDetectionRegion copy(String point1X, String point1Y, String point2X, String point2Y, String str, String direction) {
        j.e(point1X, "point1X");
        j.e(point1Y, "point1Y");
        j.e(point2X, "point2X");
        j.e(point2Y, "point2Y");
        j.e(direction, "direction");
        return new LineCrossingDetectionRegion(point1X, point1Y, point2X, point2Y, str, direction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineCrossingDetectionRegion)) {
            return false;
        }
        LineCrossingDetectionRegion lineCrossingDetectionRegion = (LineCrossingDetectionRegion) obj;
        return j.a(this.point1X, lineCrossingDetectionRegion.point1X) && j.a(this.point1Y, lineCrossingDetectionRegion.point1Y) && j.a(this.point2X, lineCrossingDetectionRegion.point2X) && j.a(this.point2Y, lineCrossingDetectionRegion.point2Y) && j.a(this.sensitivity, lineCrossingDetectionRegion.sensitivity) && j.a(this.direction, lineCrossingDetectionRegion.direction);
    }

    public final String getDirection() {
        return this.direction;
    }

    public final String getPoint1X() {
        return this.point1X;
    }

    public final String getPoint1Y() {
        return this.point1Y;
    }

    public final String getPoint2X() {
        return this.point2X;
    }

    public final String getPoint2Y() {
        return this.point2Y;
    }

    public final String getSensitivity() {
        return this.sensitivity;
    }

    public int hashCode() {
        String str = this.point1X;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.point1Y;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.point2X;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.point2Y;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.sensitivity;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.direction;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "LineCrossingDetectionRegion(point1X=" + this.point1X + ", point1Y=" + this.point1Y + ", point2X=" + this.point2X + ", point2Y=" + this.point2Y + ", sensitivity=" + this.sensitivity + ", direction=" + this.direction + ")";
    }
}
