package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.l;
import kotlin.collections.o;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class HardDiskInfo {
    public static final Companion Companion = new Companion(null);
    @c("detect_status")
    private String detectStatus;
    @c("msg_push_free_space")
    private final String freeMessageSpace;
    @c("picture_free_space")
    private final String freePictureSpace;
    @c("free_space")
    private final String freeSpace;
    @c("video_free_space")
    private String freeVideoSpace;
    private final Float percent;
    @c("record_duration")
    private final String recordDuration;
    @c("record_free_duration")
    private final String recordFreeDuration;
    @c("record_start_time")
    private final String recordStartTime;
    private String status;
    @c("msg_push_total_space")
    private final String totalMessageSpace;
    @c("picture_total_space")
    private final String totalPictureSpace;
    @c("total_space")
    private final String totalSpace;
    @c("video_total_space")
    private final String totalVideoSpace;
    private final String type;

    /* compiled from: Model.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements UnwrapFromResponse<HardDiskInfo> {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tplink.libtpnetwork.cameranetwork.model.UnwrapFromResponse
        public HardDiskInfo fromResponse(Response<Wrappers> response) {
            List<Map> list;
            int l;
            j.e(response, "response");
            if (!j.a(response.getMethod(), Method.GET_LED_STATUS.getValue()) || (list = (List) Model.typeCast(response.getResult(), Module.HARD_DISK_MANAGE, Section.HARD_DISK_INFO)) == null) {
                return null;
            }
            l = o.l(list, 10);
            ArrayList arrayList = new ArrayList(l);
            for (Map map : list) {
                arrayList.add((HardDiskInfo) l.w(map.values()));
            }
            return (HardDiskInfo) l.x(arrayList);
        }
    }

    public HardDiskInfo(String status, String str, String str2, String totalSpace, String str3, String totalVideoSpace, String freeVideoSpace, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Float f2) {
        j.e(status, "status");
        j.e(totalSpace, "totalSpace");
        j.e(totalVideoSpace, "totalVideoSpace");
        j.e(freeVideoSpace, "freeVideoSpace");
        this.status = status;
        this.detectStatus = str;
        this.type = str2;
        this.totalSpace = totalSpace;
        this.freeSpace = str3;
        this.totalVideoSpace = totalVideoSpace;
        this.freeVideoSpace = freeVideoSpace;
        this.totalPictureSpace = str4;
        this.freePictureSpace = str5;
        this.totalMessageSpace = str6;
        this.freeMessageSpace = str7;
        this.recordDuration = str8;
        this.recordFreeDuration = str9;
        this.recordStartTime = str10;
        this.percent = f2;
    }

    public final String component1() {
        return this.status;
    }

    public final String component10() {
        return this.totalMessageSpace;
    }

    public final String component11() {
        return this.freeMessageSpace;
    }

    public final String component12() {
        return this.recordDuration;
    }

    public final String component13() {
        return this.recordFreeDuration;
    }

    public final String component14() {
        return this.recordStartTime;
    }

    public final Float component15() {
        return this.percent;
    }

    public final String component2() {
        return this.detectStatus;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.totalSpace;
    }

    public final String component5() {
        return this.freeSpace;
    }

    public final String component6() {
        return this.totalVideoSpace;
    }

    public final String component7() {
        return this.freeVideoSpace;
    }

    public final String component8() {
        return this.totalPictureSpace;
    }

    public final String component9() {
        return this.freePictureSpace;
    }

    public final HardDiskInfo copy(String status, String str, String str2, String totalSpace, String str3, String totalVideoSpace, String freeVideoSpace, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Float f2) {
        j.e(status, "status");
        j.e(totalSpace, "totalSpace");
        j.e(totalVideoSpace, "totalVideoSpace");
        j.e(freeVideoSpace, "freeVideoSpace");
        return new HardDiskInfo(status, str, str2, totalSpace, str3, totalVideoSpace, freeVideoSpace, str4, str5, str6, str7, str8, str9, str10, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HardDiskInfo)) {
            return false;
        }
        HardDiskInfo hardDiskInfo = (HardDiskInfo) obj;
        return j.a(this.status, hardDiskInfo.status) && j.a(this.detectStatus, hardDiskInfo.detectStatus) && j.a(this.type, hardDiskInfo.type) && j.a(this.totalSpace, hardDiskInfo.totalSpace) && j.a(this.freeSpace, hardDiskInfo.freeSpace) && j.a(this.totalVideoSpace, hardDiskInfo.totalVideoSpace) && j.a(this.freeVideoSpace, hardDiskInfo.freeVideoSpace) && j.a(this.totalPictureSpace, hardDiskInfo.totalPictureSpace) && j.a(this.freePictureSpace, hardDiskInfo.freePictureSpace) && j.a(this.totalMessageSpace, hardDiskInfo.totalMessageSpace) && j.a(this.freeMessageSpace, hardDiskInfo.freeMessageSpace) && j.a(this.recordDuration, hardDiskInfo.recordDuration) && j.a(this.recordFreeDuration, hardDiskInfo.recordFreeDuration) && j.a(this.recordStartTime, hardDiskInfo.recordStartTime) && j.a(this.percent, hardDiskInfo.percent);
    }

    public final String getDetectStatus() {
        return this.detectStatus;
    }

    public final String getFreeMessageSpace() {
        return this.freeMessageSpace;
    }

    public final String getFreePictureSpace() {
        return this.freePictureSpace;
    }

    public final String getFreeSpace() {
        return this.freeSpace;
    }

    public final String getFreeVideoSpace() {
        return this.freeVideoSpace;
    }

    public final Float getPercent() {
        return this.percent;
    }

    public final String getRecordDuration() {
        return this.recordDuration;
    }

    public final String getRecordFreeDuration() {
        return this.recordFreeDuration;
    }

    public final String getRecordStartTime() {
        return this.recordStartTime;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTotalMessageSpace() {
        return this.totalMessageSpace;
    }

    public final String getTotalPictureSpace() {
        return this.totalPictureSpace;
    }

    public final String getTotalSpace() {
        return this.totalSpace;
    }

    public final String getTotalVideoSpace() {
        return this.totalVideoSpace;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.status;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.detectStatus;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.totalSpace;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.freeSpace;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.totalVideoSpace;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.freeVideoSpace;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.totalPictureSpace;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.freePictureSpace;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.totalMessageSpace;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.freeMessageSpace;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.recordDuration;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.recordFreeDuration;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.recordStartTime;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        Float f2 = this.percent;
        if (f2 != null) {
            i = f2.hashCode();
        }
        return hashCode14 + i;
    }

    public final void setDetectStatus(String str) {
        this.detectStatus = str;
    }

    public final void setFreeVideoSpace(String str) {
        j.e(str, "<set-?>");
        this.freeVideoSpace = str;
    }

    public final void setStatus(String str) {
        j.e(str, "<set-?>");
        this.status = str;
    }

    public String toString() {
        return "HardDiskInfo(status=" + this.status + ", detectStatus=" + this.detectStatus + ", type=" + this.type + ", totalSpace=" + this.totalSpace + ", freeSpace=" + this.freeSpace + ", totalVideoSpace=" + this.totalVideoSpace + ", freeVideoSpace=" + this.freeVideoSpace + ", totalPictureSpace=" + this.totalPictureSpace + ", freePictureSpace=" + this.freePictureSpace + ", totalMessageSpace=" + this.totalMessageSpace + ", freeMessageSpace=" + this.freeMessageSpace + ", recordDuration=" + this.recordDuration + ", recordFreeDuration=" + this.recordFreeDuration + ", recordStartTime=" + this.recordStartTime + ", percent=" + this.percent + ")";
    }
}
