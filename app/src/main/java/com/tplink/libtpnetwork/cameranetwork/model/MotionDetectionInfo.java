package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class MotionDetectionInfo {
    private final MotionDetectConfig config;
    private final List<MotionDetectRegion> regions;

    public MotionDetectionInfo(MotionDetectConfig motionDetectConfig, List<MotionDetectRegion> list) {
        this.config = motionDetectConfig;
        this.regions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MotionDetectionInfo copy$default(MotionDetectionInfo motionDetectionInfo, MotionDetectConfig motionDetectConfig, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            motionDetectConfig = motionDetectionInfo.config;
        }
        if ((i & 2) != 0) {
            list = motionDetectionInfo.regions;
        }
        return motionDetectionInfo.copy(motionDetectConfig, list);
    }

    public final MotionDetectConfig component1() {
        return this.config;
    }

    public final List<MotionDetectRegion> component2() {
        return this.regions;
    }

    public final MotionDetectionInfo copy(MotionDetectConfig motionDetectConfig, List<MotionDetectRegion> list) {
        return new MotionDetectionInfo(motionDetectConfig, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionDetectionInfo)) {
            return false;
        }
        MotionDetectionInfo motionDetectionInfo = (MotionDetectionInfo) obj;
        return j.a(this.config, motionDetectionInfo.config) && j.a(this.regions, motionDetectionInfo.regions);
    }

    public final MotionDetectConfig getConfig() {
        return this.config;
    }

    public final List<MotionDetectRegion> getRegions() {
        return this.regions;
    }

    public int hashCode() {
        MotionDetectConfig motionDetectConfig = this.config;
        int i = 0;
        int hashCode = (motionDetectConfig != null ? motionDetectConfig.hashCode() : 0) * 31;
        List<MotionDetectRegion> list = this.regions;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MotionDetectionInfo(config=" + this.config + ", regions=" + this.regions + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MotionDetectionInfo(com.tplink.libtpnetwork.cameranetwork.model.Wrappers r4) {
        /*
            r3 = this;
            java.lang.String r0 = "wrappers"
            kotlin.jvm.internal.j.e(r4, r0)
            java.lang.Class<com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig> r0 = com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig.class
            java.lang.Object r0 = com.tplink.libtpnetwork.cameranetwork.model.Model.typeCast(r4, r0)
            com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig r0 = (com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig) r0
            com.tplink.libtpnetwork.cameranetwork.model.Module r1 = com.tplink.libtpnetwork.cameranetwork.model.Module.MOTION_DETECTION
            com.tplink.libtpnetwork.cameranetwork.model.Section r2 = com.tplink.libtpnetwork.cameranetwork.model.Section.REGION_INFO
            java.lang.Object r4 = com.tplink.libtpnetwork.cameranetwork.model.Model.typeCast(r4, r1, r2)
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L_0x0042
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.l.l(r4, r2)
            r1.<init>(r2)
            java.util.Iterator r4 = r4.iterator()
        L_0x0028:
            boolean r2 = r4.hasNext()
            if (r2 == 0) goto L_0x0043
            java.lang.Object r2 = r4.next()
            java.util.Map r2 = (java.util.Map) r2
            java.util.Collection r2 = r2.values()
            java.lang.Object r2 = kotlin.collections.l.w(r2)
            com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion r2 = (com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion) r2
            r1.add(r2)
            goto L_0x0028
        L_0x0042:
            r1 = 0
        L_0x0043:
            r3.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.cameranetwork.model.MotionDetectionInfo.<init>(com.tplink.libtpnetwork.cameranetwork.model.Wrappers):void");
    }
}
