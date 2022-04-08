package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class DetectionList {
    @c("search_detection_list")
    private final List<SnapshotPlaybackItem> detectionList;
    @c("snapshot_enable")
    private final Boolean snapshotEnable;

    public DetectionList(Boolean bool, List<SnapshotPlaybackItem> list) {
        this.snapshotEnable = bool;
        this.detectionList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DetectionList copy$default(DetectionList detectionList, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = detectionList.snapshotEnable;
        }
        if ((i & 2) != 0) {
            list = detectionList.detectionList;
        }
        return detectionList.copy(bool, list);
    }

    public final Boolean component1() {
        return this.snapshotEnable;
    }

    public final List<SnapshotPlaybackItem> component2() {
        return this.detectionList;
    }

    public final DetectionList copy(Boolean bool, List<SnapshotPlaybackItem> list) {
        return new DetectionList(bool, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DetectionList)) {
            return false;
        }
        DetectionList detectionList = (DetectionList) obj;
        return j.a(this.snapshotEnable, detectionList.snapshotEnable) && j.a(this.detectionList, detectionList.detectionList);
    }

    public final List<SnapshotPlaybackItem> getDetectionList() {
        return this.detectionList;
    }

    public final Boolean getSnapshotEnable() {
        return this.snapshotEnable;
    }

    public int hashCode() {
        Boolean bool = this.snapshotEnable;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        List<SnapshotPlaybackItem> list = this.detectionList;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "DetectionList(snapshotEnable=" + this.snapshotEnable + ", detectionList=" + this.detectionList + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DetectionList(com.tplink.libtpnetwork.cameranetwork.model.Wrappers r4) {
        /*
            r3 = this;
            java.lang.String r0 = "wrappers"
            kotlin.jvm.internal.j.e(r4, r0)
            com.tplink.libtpnetwork.cameranetwork.model.Module r0 = com.tplink.libtpnetwork.cameranetwork.model.Module.PLAYBACK
            com.tplink.libtpnetwork.cameranetwork.model.Section r1 = com.tplink.libtpnetwork.cameranetwork.model.Section.PLAYBACK_SNAPSHOT_ENABLE
            java.lang.Object r1 = com.tplink.libtpnetwork.cameranetwork.model.Model.typeCast(r4, r0, r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            com.tplink.libtpnetwork.cameranetwork.model.Section r2 = com.tplink.libtpnetwork.cameranetwork.model.Section.PLAYBACK_SNAPSHOT_LIST
            java.lang.Object r4 = com.tplink.libtpnetwork.cameranetwork.model.Model.typeCast(r4, r0, r2)
            java.util.List r4 = (java.util.List) r4
            r3.<init>(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.cameranetwork.model.DetectionList.<init>(com.tplink.libtpnetwork.cameranetwork.model.Wrappers):void");
    }
}
