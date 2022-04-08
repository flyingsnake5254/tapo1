package com.tplink.libtpnetwork.cameranetwork.model;

import com.tplink.libtpnetwork.Utils.i;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class UpnpMultiInfo {
    public static final Companion Companion = new Companion(null);
    private PubIp pubIp;
    private UpnpCommStatus upnpCommStatus;
    private UpnpInfo upnpInfo;
    private UpnpPsk upnpPsk;
    private UpnpStatus upnpStatus;

    /* compiled from: Model.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements UnwrapFromMultipleResponse<UpnpMultiInfo> {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tplink.libtpnetwork.cameranetwork.model.UnwrapFromMultipleResponse
        public UpnpMultiInfo fromMultipleResponse(MultipleResponse response) {
            j.e(response, "response");
            UpnpMultiInfo upnpMultiInfo = new UpnpMultiInfo(null, null, null, null, null);
            List<Response<Wrappers>> responses = response.getResponses();
            if (responses != null) {
                for (Response<Wrappers> response2 : responses) {
                    Wrappers result = response2.getResult();
                    String method = response2.getMethod();
                    if (j.a(method, Method.GET_UPNP_INFO.getValue())) {
                        upnpMultiInfo.setUpnpInfo((UpnpInfo) Model.typeCast(result, Module.UPNPC, Section.UPNPC_INFO));
                    } else if (j.a(method, Method.GET_UPNP_STATUS.getValue())) {
                        upnpMultiInfo.setUpnpStatus(new UpnpStatus(result));
                    } else if (j.a(method, Method.GET_UPNP_COMM_STATUS.getValue())) {
                        upnpMultiInfo.setUpnpCommStatus((UpnpCommStatus) Model.typeCast(result, Module.UPNPC, Section.COMMUNICATE));
                    } else if (j.a(method, Method.GET_PUB_IP.getValue())) {
                        upnpMultiInfo.setPubIp((PubIp) Model.typeCast(result, Module.UPNPC, Section.PUB_IP));
                    } else if (j.a(method, Method.GET_UPNP_PSK.getValue()) && result.getWrapperList() != null && (!result.getWrapperList().isEmpty()) && result.getWrapperList().get(0).getData() != null) {
                        upnpMultiInfo.setUpnpPsk((UpnpPsk) i.b(String.valueOf(result.getWrapperList().get(0).getData()), UpnpPsk.class));
                    }
                }
            }
            return upnpMultiInfo;
        }
    }

    public UpnpMultiInfo(UpnpInfo upnpInfo, UpnpStatus upnpStatus, UpnpCommStatus upnpCommStatus, PubIp pubIp, UpnpPsk upnpPsk) {
        this.upnpInfo = upnpInfo;
        this.upnpStatus = upnpStatus;
        this.upnpCommStatus = upnpCommStatus;
        this.pubIp = pubIp;
        this.upnpPsk = upnpPsk;
    }

    public static /* synthetic */ UpnpMultiInfo copy$default(UpnpMultiInfo upnpMultiInfo, UpnpInfo upnpInfo, UpnpStatus upnpStatus, UpnpCommStatus upnpCommStatus, PubIp pubIp, UpnpPsk upnpPsk, int i, Object obj) {
        if ((i & 1) != 0) {
            upnpInfo = upnpMultiInfo.upnpInfo;
        }
        if ((i & 2) != 0) {
            upnpStatus = upnpMultiInfo.upnpStatus;
        }
        if ((i & 4) != 0) {
            upnpCommStatus = upnpMultiInfo.upnpCommStatus;
        }
        if ((i & 8) != 0) {
            pubIp = upnpMultiInfo.pubIp;
        }
        if ((i & 16) != 0) {
            upnpPsk = upnpMultiInfo.upnpPsk;
        }
        return upnpMultiInfo.copy(upnpInfo, upnpStatus, upnpCommStatus, pubIp, upnpPsk);
    }

    public final UpnpInfo component1() {
        return this.upnpInfo;
    }

    public final UpnpStatus component2() {
        return this.upnpStatus;
    }

    public final UpnpCommStatus component3() {
        return this.upnpCommStatus;
    }

    public final PubIp component4() {
        return this.pubIp;
    }

    public final UpnpPsk component5() {
        return this.upnpPsk;
    }

    public final UpnpMultiInfo copy(UpnpInfo upnpInfo, UpnpStatus upnpStatus, UpnpCommStatus upnpCommStatus, PubIp pubIp, UpnpPsk upnpPsk) {
        return new UpnpMultiInfo(upnpInfo, upnpStatus, upnpCommStatus, pubIp, upnpPsk);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpnpMultiInfo)) {
            return false;
        }
        UpnpMultiInfo upnpMultiInfo = (UpnpMultiInfo) obj;
        return j.a(this.upnpInfo, upnpMultiInfo.upnpInfo) && j.a(this.upnpStatus, upnpMultiInfo.upnpStatus) && j.a(this.upnpCommStatus, upnpMultiInfo.upnpCommStatus) && j.a(this.pubIp, upnpMultiInfo.pubIp) && j.a(this.upnpPsk, upnpMultiInfo.upnpPsk);
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
        UpnpInfo upnpInfo = this.upnpInfo;
        int i = 0;
        int hashCode = (upnpInfo != null ? upnpInfo.hashCode() : 0) * 31;
        UpnpStatus upnpStatus = this.upnpStatus;
        int hashCode2 = (hashCode + (upnpStatus != null ? upnpStatus.hashCode() : 0)) * 31;
        UpnpCommStatus upnpCommStatus = this.upnpCommStatus;
        int hashCode3 = (hashCode2 + (upnpCommStatus != null ? upnpCommStatus.hashCode() : 0)) * 31;
        PubIp pubIp = this.pubIp;
        int hashCode4 = (hashCode3 + (pubIp != null ? pubIp.hashCode() : 0)) * 31;
        UpnpPsk upnpPsk = this.upnpPsk;
        if (upnpPsk != null) {
            i = upnpPsk.hashCode();
        }
        return hashCode4 + i;
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
        return "UpnpMultiInfo(upnpInfo=" + this.upnpInfo + ", upnpStatus=" + this.upnpStatus + ", upnpCommStatus=" + this.upnpCommStatus + ", pubIp=" + this.pubIp + ", upnpPsk=" + this.upnpPsk + ")";
    }
}
