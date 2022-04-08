package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class LineCrossingDetectionInfo {
    private final ArmScheduleInfo armScheduleInfo;
    private final DetectionInfo detectionInfo;

    public LineCrossingDetectionInfo(DetectionInfo detectionInfo, ArmScheduleInfo armScheduleInfo) {
        this.detectionInfo = detectionInfo;
        this.armScheduleInfo = armScheduleInfo;
    }

    public static /* synthetic */ LineCrossingDetectionInfo copy$default(LineCrossingDetectionInfo lineCrossingDetectionInfo, DetectionInfo detectionInfo, ArmScheduleInfo armScheduleInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            detectionInfo = lineCrossingDetectionInfo.detectionInfo;
        }
        if ((i & 2) != 0) {
            armScheduleInfo = lineCrossingDetectionInfo.armScheduleInfo;
        }
        return lineCrossingDetectionInfo.copy(detectionInfo, armScheduleInfo);
    }

    public final DetectionInfo component1() {
        return this.detectionInfo;
    }

    public final ArmScheduleInfo component2() {
        return this.armScheduleInfo;
    }

    public final LineCrossingDetectionInfo copy(DetectionInfo detectionInfo, ArmScheduleInfo armScheduleInfo) {
        return new LineCrossingDetectionInfo(detectionInfo, armScheduleInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineCrossingDetectionInfo)) {
            return false;
        }
        LineCrossingDetectionInfo lineCrossingDetectionInfo = (LineCrossingDetectionInfo) obj;
        return j.a(this.detectionInfo, lineCrossingDetectionInfo.detectionInfo) && j.a(this.armScheduleInfo, lineCrossingDetectionInfo.armScheduleInfo);
    }

    public final ArmScheduleInfo getArmScheduleInfo() {
        return this.armScheduleInfo;
    }

    public final DetectionInfo getDetectionInfo() {
        return this.detectionInfo;
    }

    public int hashCode() {
        DetectionInfo detectionInfo = this.detectionInfo;
        int i = 0;
        int hashCode = (detectionInfo != null ? detectionInfo.hashCode() : 0) * 31;
        ArmScheduleInfo armScheduleInfo = this.armScheduleInfo;
        if (armScheduleInfo != null) {
            i = armScheduleInfo.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "LineCrossingDetectionInfo(detectionInfo=" + this.detectionInfo + ", armScheduleInfo=" + this.armScheduleInfo + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LineCrossingDetectionInfo(com.tplink.libtpnetwork.cameranetwork.model.Wrappers r4) {
        /*
            r3 = this;
            java.lang.String r0 = "wrappers"
            kotlin.jvm.internal.j.e(r4, r0)
            com.tplink.libtpnetwork.cameranetwork.model.Module r0 = com.tplink.libtpnetwork.cameranetwork.model.Module.LINE_CROSSING_DETECTION
            com.tplink.libtpnetwork.cameranetwork.model.Section r1 = com.tplink.libtpnetwork.cameranetwork.model.Section.DETECTION
            java.lang.Object r1 = com.tplink.libtpnetwork.cameranetwork.model.Model.typeCast(r4, r0, r1)
            com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo r1 = (com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo) r1
            com.tplink.libtpnetwork.cameranetwork.model.Section r2 = com.tplink.libtpnetwork.cameranetwork.model.Section.ARMING_SCHEDULE
            java.lang.Object r4 = com.tplink.libtpnetwork.cameranetwork.model.Model.typeCast(r4, r0, r2)
            com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo r4 = (com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo) r4
            r3.<init>(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionInfo.<init>(com.tplink.libtpnetwork.cameranetwork.model.Wrappers):void");
    }
}
