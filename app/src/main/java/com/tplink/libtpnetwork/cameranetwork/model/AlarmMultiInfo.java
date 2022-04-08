package com.tplink.libtpnetwork.cameranetwork.model;

import com.tplink.libtpnetwork.Utils.i;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class AlarmMultiInfo {
    public static final Companion Companion = new Companion(null);
    private BasicInfo deviceInfo;
    private LastAlarmInfo lastAlarmInfo;
    private PubIp pubIp;
    private UpnpCommStatus upnpCommStatus;
    private UpnpInfo upnpInfo;
    private UpnpPsk upnpPsk;
    private UpnpStatus upnpStatus;

    /* compiled from: ModelAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements UnwrapFromMultipleResponse<AlarmMultiInfo> {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tplink.libtpnetwork.cameranetwork.model.UnwrapFromMultipleResponse
        public AlarmMultiInfo fromMultipleResponse(MultipleResponse response) {
            j.e(response, "response");
            AlarmMultiInfo alarmMultiInfo = new AlarmMultiInfo(null, null, null, null, null, null, null);
            List<Response<Wrappers>> responses = response.getResponses();
            if (responses != null) {
                for (Response<Wrappers> response2 : responses) {
                    Wrappers result = response2.getResult();
                    String method = response2.getMethod();
                    if (j.a(method, Method.GET_DEVICE_INFO.getValue())) {
                        alarmMultiInfo.setDeviceInfo((BasicInfo) Model.typeCast(result, Module.DEVICE_INFO, Section.BASIC_INFO));
                    } else if (j.a(method, Method.GET_LAST_ALARM_INFO.getValue())) {
                        alarmMultiInfo.setLastAlarmInfo((LastAlarmInfo) Model.typeCast(result, Module.SYSTEM, Section.LAST_ALARM_INFO));
                    } else if (j.a(method, Method.GET_UPNP_INFO.getValue())) {
                        alarmMultiInfo.setUpnpInfo((UpnpInfo) Model.typeCast(result, Module.UPNPC, Section.UPNPC_INFO));
                    } else if (j.a(method, Method.GET_UPNP_STATUS.getValue())) {
                        alarmMultiInfo.setUpnpStatus(new UpnpStatus(result));
                    } else if (j.a(method, Method.GET_UPNP_COMM_STATUS.getValue())) {
                        alarmMultiInfo.setUpnpCommStatus((UpnpCommStatus) Model.typeCast(result, Module.UPNPC, Section.COMMUNICATE));
                    } else if (j.a(method, Method.GET_PUB_IP.getValue())) {
                        alarmMultiInfo.setPubIp((PubIp) Model.typeCast(result, Module.UPNPC, Section.PUB_IP));
                    } else if (j.a(method, Method.GET_UPNP_PSK.getValue()) && result.getWrapperList() != null && (!result.getWrapperList().isEmpty()) && result.getWrapperList().get(0).getData() != null) {
                        alarmMultiInfo.setUpnpPsk((UpnpPsk) i.b(String.valueOf(result.getWrapperList().get(0).getData()), UpnpPsk.class));
                    }
                }
            }
            return alarmMultiInfo;
        }
    }

    public AlarmMultiInfo(BasicInfo basicInfo, LastAlarmInfo lastAlarmInfo, UpnpInfo upnpInfo, UpnpStatus upnpStatus, UpnpCommStatus upnpCommStatus, PubIp pubIp, UpnpPsk upnpPsk) {
        this.deviceInfo = basicInfo;
        this.lastAlarmInfo = lastAlarmInfo;
        this.upnpInfo = upnpInfo;
        this.upnpStatus = upnpStatus;
        this.upnpCommStatus = upnpCommStatus;
        this.pubIp = pubIp;
        this.upnpPsk = upnpPsk;
    }

    public static /* synthetic */ AlarmMultiInfo copy$default(AlarmMultiInfo alarmMultiInfo, BasicInfo basicInfo, LastAlarmInfo lastAlarmInfo, UpnpInfo upnpInfo, UpnpStatus upnpStatus, UpnpCommStatus upnpCommStatus, PubIp pubIp, UpnpPsk upnpPsk, int i, Object obj) {
        if ((i & 1) != 0) {
            basicInfo = alarmMultiInfo.deviceInfo;
        }
        if ((i & 2) != 0) {
            lastAlarmInfo = alarmMultiInfo.lastAlarmInfo;
        }
        if ((i & 4) != 0) {
            upnpInfo = alarmMultiInfo.upnpInfo;
        }
        if ((i & 8) != 0) {
            upnpStatus = alarmMultiInfo.upnpStatus;
        }
        if ((i & 16) != 0) {
            upnpCommStatus = alarmMultiInfo.upnpCommStatus;
        }
        if ((i & 32) != 0) {
            pubIp = alarmMultiInfo.pubIp;
        }
        if ((i & 64) != 0) {
            upnpPsk = alarmMultiInfo.upnpPsk;
        }
        return alarmMultiInfo.copy(basicInfo, lastAlarmInfo, upnpInfo, upnpStatus, upnpCommStatus, pubIp, upnpPsk);
    }

    public final BasicInfo component1() {
        return this.deviceInfo;
    }

    public final LastAlarmInfo component2() {
        return this.lastAlarmInfo;
    }

    public final UpnpInfo component3() {
        return this.upnpInfo;
    }

    public final UpnpStatus component4() {
        return this.upnpStatus;
    }

    public final UpnpCommStatus component5() {
        return this.upnpCommStatus;
    }

    public final PubIp component6() {
        return this.pubIp;
    }

    public final UpnpPsk component7() {
        return this.upnpPsk;
    }

    public final AlarmMultiInfo copy(BasicInfo basicInfo, LastAlarmInfo lastAlarmInfo, UpnpInfo upnpInfo, UpnpStatus upnpStatus, UpnpCommStatus upnpCommStatus, PubIp pubIp, UpnpPsk upnpPsk) {
        return new AlarmMultiInfo(basicInfo, lastAlarmInfo, upnpInfo, upnpStatus, upnpCommStatus, pubIp, upnpPsk);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlarmMultiInfo)) {
            return false;
        }
        AlarmMultiInfo alarmMultiInfo = (AlarmMultiInfo) obj;
        return j.a(this.deviceInfo, alarmMultiInfo.deviceInfo) && j.a(this.lastAlarmInfo, alarmMultiInfo.lastAlarmInfo) && j.a(this.upnpInfo, alarmMultiInfo.upnpInfo) && j.a(this.upnpStatus, alarmMultiInfo.upnpStatus) && j.a(this.upnpCommStatus, alarmMultiInfo.upnpCommStatus) && j.a(this.pubIp, alarmMultiInfo.pubIp) && j.a(this.upnpPsk, alarmMultiInfo.upnpPsk);
    }

    public final BasicInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final LastAlarmInfo getLastAlarmInfo() {
        return this.lastAlarmInfo;
    }

    public final PubIp getPubIp() {
        return this.pubIp;
    }

    public final UpnpCommStatus getUpnpCommStatus() {
        return this.upnpCommStatus;
    }

    public final UpnpInfo getUpnpInfo() {
        return this.upnpInfo;
    }

    public final UpnpPsk getUpnpPsk() {
        return this.upnpPsk;
    }

    public final UpnpStatus getUpnpStatus() {
        return this.upnpStatus;
    }

    public int hashCode() {
        BasicInfo basicInfo = this.deviceInfo;
        int i = 0;
        int hashCode = (basicInfo != null ? basicInfo.hashCode() : 0) * 31;
        LastAlarmInfo lastAlarmInfo = this.lastAlarmInfo;
        int hashCode2 = (hashCode + (lastAlarmInfo != null ? lastAlarmInfo.hashCode() : 0)) * 31;
        UpnpInfo upnpInfo = this.upnpInfo;
        int hashCode3 = (hashCode2 + (upnpInfo != null ? upnpInfo.hashCode() : 0)) * 31;
        UpnpStatus upnpStatus = this.upnpStatus;
        int hashCode4 = (hashCode3 + (upnpStatus != null ? upnpStatus.hashCode() : 0)) * 31;
        UpnpCommStatus upnpCommStatus = this.upnpCommStatus;
        int hashCode5 = (hashCode4 + (upnpCommStatus != null ? upnpCommStatus.hashCode() : 0)) * 31;
        PubIp pubIp = this.pubIp;
        int hashCode6 = (hashCode5 + (pubIp != null ? pubIp.hashCode() : 0)) * 31;
        UpnpPsk upnpPsk = this.upnpPsk;
        if (upnpPsk != null) {
            i = upnpPsk.hashCode();
        }
        return hashCode6 + i;
    }

    public final void setDeviceInfo(BasicInfo basicInfo) {
        this.deviceInfo = basicInfo;
    }

    public final void setLastAlarmInfo(LastAlarmInfo lastAlarmInfo) {
        this.lastAlarmInfo = lastAlarmInfo;
    }

    public final void setPubIp(PubIp pubIp) {
        this.pubIp = pubIp;
    }

    public final void setUpnpCommStatus(UpnpCommStatus upnpCommStatus) {
        this.upnpCommStatus = upnpCommStatus;
    }

    public final void setUpnpInfo(UpnpInfo upnpInfo) {
        this.upnpInfo = upnpInfo;
    }

    public final void setUpnpPsk(UpnpPsk upnpPsk) {
        this.upnpPsk = upnpPsk;
    }

    public final void setUpnpStatus(UpnpStatus upnpStatus) {
        this.upnpStatus = upnpStatus;
    }

    public String toString() {
        return "AlarmMultiInfo(deviceInfo=" + this.deviceInfo + ", lastAlarmInfo=" + this.lastAlarmInfo + ", upnpInfo=" + this.upnpInfo + ", upnpStatus=" + this.upnpStatus + ", upnpCommStatus=" + this.upnpCommStatus + ", pubIp=" + this.pubIp + ", upnpPsk=" + this.upnpPsk + ")";
    }
}
