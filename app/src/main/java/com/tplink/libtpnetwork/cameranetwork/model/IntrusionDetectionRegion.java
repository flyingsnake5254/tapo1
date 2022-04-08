package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class IntrusionDetectionRegion {
    public static final Companion Companion = new Companion(null);
    @c("pt3_x")
    private final String leftBottomX;
    @c("pt3_y")
    private final String leftBottomY;
    @c("pt1_x")
    private final String leftTopX;
    @c("pt1_y")
    private final String leftTopY;
    private final String percentage;
    @c("pt4_x")
    private final String rightBottomX;
    @c("pt4_y")
    private final String rightBottomY;
    @c("pt2_x")
    private final String rightTopX;
    @c("pt2_y")
    private final String rightTopY;
    private final String sensitivity;
    private final String threshold;

    /* compiled from: Model.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements UnwrapFromResponse<List<? extends Map<String, ? extends IntrusionDetectionRegion>>> {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        @Override // com.tplink.libtpnetwork.cameranetwork.model.UnwrapFromResponse
        /* renamed from: fromResponse  reason: avoid collision after fix types in other method */
        public List<? extends Map<String, ? extends IntrusionDetectionRegion>> fromResponse2(Response<Wrappers> response) {
            j.e(response, "response");
            if (j.a(response.getMethod(), Method.GET_INTRUSION_DETECTION_REGION.getValue())) {
                return (List) Model.typeCast(response.getResult(), Module.INTRUSION_DETECTION, Section.REGION_INFO);
            }
            return null;
        }
    }

    public IntrusionDetectionRegion(String leftTopX, String leftTopY, String rightTopX, String rightTopY, String leftBottomX, String leftBottomY, String rightBottomX, String rightBottomY, String str, String str2, String str3) {
        j.e(leftTopX, "leftTopX");
        j.e(leftTopY, "leftTopY");
        j.e(rightTopX, "rightTopX");
        j.e(rightTopY, "rightTopY");
        j.e(leftBottomX, "leftBottomX");
        j.e(leftBottomY, "leftBottomY");
        j.e(rightBottomX, "rightBottomX");
        j.e(rightBottomY, "rightBottomY");
        this.leftTopX = leftTopX;
        this.leftTopY = leftTopY;
        this.rightTopX = rightTopX;
        this.rightTopY = rightTopY;
        this.leftBottomX = leftBottomX;
        this.leftBottomY = leftBottomY;
        this.rightBottomX = rightBottomX;
        this.rightBottomY = rightBottomY;
        this.sensitivity = str;
        this.threshold = str2;
        this.percentage = str3;
    }

    public final String component1() {
        return this.leftTopX;
    }

    public final String component10() {
        return this.threshold;
    }

    public final String component11() {
        return this.percentage;
    }

    public final String component2() {
        return this.leftTopY;
    }

    public final String component3() {
        return this.rightTopX;
    }

    public final String component4() {
        return this.rightTopY;
    }

    public final String component5() {
        return this.leftBottomX;
    }

    public final String component6() {
        return this.leftBottomY;
    }

    public final String component7() {
        return this.rightBottomX;
    }

    public final String component8() {
        return this.rightBottomY;
    }

    public final String component9() {
        return this.sensitivity;
    }

    public final IntrusionDetectionRegion copy(String leftTopX, String leftTopY, String rightTopX, String rightTopY, String leftBottomX, String leftBottomY, String rightBottomX, String rightBottomY, String str, String str2, String str3) {
        j.e(leftTopX, "leftTopX");
        j.e(leftTopY, "leftTopY");
        j.e(rightTopX, "rightTopX");
        j.e(rightTopY, "rightTopY");
        j.e(leftBottomX, "leftBottomX");
        j.e(leftBottomY, "leftBottomY");
        j.e(rightBottomX, "rightBottomX");
        j.e(rightBottomY, "rightBottomY");
        return new IntrusionDetectionRegion(leftTopX, leftTopY, rightTopX, rightTopY, leftBottomX, leftBottomY, rightBottomX, rightBottomY, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntrusionDetectionRegion)) {
            return false;
        }
        IntrusionDetectionRegion intrusionDetectionRegion = (IntrusionDetectionRegion) obj;
        return j.a(this.leftTopX, intrusionDetectionRegion.leftTopX) && j.a(this.leftTopY, intrusionDetectionRegion.leftTopY) && j.a(this.rightTopX, intrusionDetectionRegion.rightTopX) && j.a(this.rightTopY, intrusionDetectionRegion.rightTopY) && j.a(this.leftBottomX, intrusionDetectionRegion.leftBottomX) && j.a(this.leftBottomY, intrusionDetectionRegion.leftBottomY) && j.a(this.rightBottomX, intrusionDetectionRegion.rightBottomX) && j.a(this.rightBottomY, intrusionDetectionRegion.rightBottomY) && j.a(this.sensitivity, intrusionDetectionRegion.sensitivity) && j.a(this.threshold, intrusionDetectionRegion.threshold) && j.a(this.percentage, intrusionDetectionRegion.percentage);
    }

    public final String getLeftBottomX() {
        return this.leftBottomX;
    }

    public final String getLeftBottomY() {
        return this.leftBottomY;
    }

    public final String getLeftTopX() {
        return this.leftTopX;
    }

    public final String getLeftTopY() {
        return this.leftTopY;
    }

    public final String getPercentage() {
        return this.percentage;
    }

    public final String getRightBottomX() {
        return this.rightBottomX;
    }

    public final String getRightBottomY() {
        return this.rightBottomY;
    }

    public final String getRightTopX() {
        return this.rightTopX;
    }

    public final String getRightTopY() {
        return this.rightTopY;
    }

    public final String getSensitivity() {
        return this.sensitivity;
    }

    public final String getThreshold() {
        return this.threshold;
    }

    public int hashCode() {
        String str = this.leftTopX;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.leftTopY;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.rightTopX;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.rightTopY;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.leftBottomX;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.leftBottomY;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.rightBottomX;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.rightBottomY;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.sensitivity;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.threshold;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.percentage;
        if (str11 != null) {
            i = str11.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        return "IntrusionDetectionRegion(leftTopX=" + this.leftTopX + ", leftTopY=" + this.leftTopY + ", rightTopX=" + this.rightTopX + ", rightTopY=" + this.rightTopY + ", leftBottomX=" + this.leftBottomX + ", leftBottomY=" + this.leftBottomY + ", rightBottomX=" + this.rightBottomX + ", rightBottomY=" + this.rightBottomY + ", sensitivity=" + this.sensitivity + ", threshold=" + this.threshold + ", percentage=" + this.percentage + ")";
    }
}
