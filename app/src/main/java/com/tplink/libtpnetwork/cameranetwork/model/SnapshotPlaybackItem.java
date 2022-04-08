package com.tplink.libtpnetwork.cameranetwork.model;

import androidx.core.provider.FontsContractCompat;
import com.google.gson.q.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class SnapshotPlaybackItem {
    @c("end_time")
    private final long endTime;
    @c(FontsContractCompat.Columns.FILE_ID)
    private final String fileId;
    @c("start_time")
    private final long startTime;
    @c("alarm_type")
    private final int type;

    public SnapshotPlaybackItem(long j, long j2, int i, String fileId) {
        j.e(fileId, "fileId");
        this.startTime = j;
        this.endTime = j2;
        this.type = i;
        this.fileId = fileId;
    }

    public static /* synthetic */ SnapshotPlaybackItem copy$default(SnapshotPlaybackItem snapshotPlaybackItem, long j, long j2, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = snapshotPlaybackItem.startTime;
        }
        if ((i2 & 2) != 0) {
            j2 = snapshotPlaybackItem.endTime;
        }
        if ((i2 & 4) != 0) {
            i = snapshotPlaybackItem.type;
        }
        if ((i2 & 8) != 0) {
            str = snapshotPlaybackItem.fileId;
        }
        return snapshotPlaybackItem.copy(j, j2, i, str);
    }

    public final long component1() {
        return this.startTime;
    }

    public final long component2() {
        return this.endTime;
    }

    public final int component3() {
        return this.type;
    }

    public final String component4() {
        return this.fileId;
    }

    public final SnapshotPlaybackItem copy(long j, long j2, int i, String fileId) {
        j.e(fileId, "fileId");
        return new SnapshotPlaybackItem(j, j2, i, fileId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SnapshotPlaybackItem)) {
            return false;
        }
        SnapshotPlaybackItem snapshotPlaybackItem = (SnapshotPlaybackItem) obj;
        return this.startTime == snapshotPlaybackItem.startTime && this.endTime == snapshotPlaybackItem.endTime && this.type == snapshotPlaybackItem.type && j.a(this.fileId, snapshotPlaybackItem.fileId);
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        long j = this.startTime;
        long j2 = this.endTime;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.type) * 31;
        String str = this.fileId;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotPlaybackItem(startTime=" + this.startTime + ", endTime=" + this.endTime + ", type=" + this.type + ", fileId=" + this.fileId + ")";
    }

    public /* synthetic */ SnapshotPlaybackItem(long j, long j2, int i, String str, int i2, f fVar) {
        this(j, j2, i, (i2 & 8) != 0 ? "" : str);
    }

    public SnapshotPlaybackItem(long j, long j2, int i) {
        this(j, j2, i, String.valueOf(j));
    }
}
