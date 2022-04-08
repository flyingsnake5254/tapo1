package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class CameraInfo {
    public static final Companion Companion = new Companion(null);
    private final BasicInfo basicInfo;
    private final SystemInfo systemInfo;

    /* compiled from: ModelAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements UnwrapFromResponse<CameraInfo> {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tplink.libtpnetwork.cameranetwork.model.UnwrapFromResponse
        public CameraInfo fromResponse(Response<Wrappers> response) {
            j.e(response, "response");
            if (j.a(response.getMethod(), Method.GET_DEVICE_INFO.getValue())) {
                return new CameraInfo(response.getResult());
            }
            return null;
        }
    }

    public CameraInfo(BasicInfo basicInfo, SystemInfo systemInfo) {
        this.basicInfo = basicInfo;
        this.systemInfo = systemInfo;
    }

    public static /* synthetic */ CameraInfo copy$default(CameraInfo cameraInfo, BasicInfo basicInfo, SystemInfo systemInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            basicInfo = cameraInfo.basicInfo;
        }
        if ((i & 2) != 0) {
            systemInfo = cameraInfo.systemInfo;
        }
        return cameraInfo.copy(basicInfo, systemInfo);
    }

    public final BasicInfo component1() {
        return this.basicInfo;
    }

    public final SystemInfo component2() {
        return this.systemInfo;
    }

    public final CameraInfo copy(BasicInfo basicInfo, SystemInfo systemInfo) {
        return new CameraInfo(basicInfo, systemInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraInfo)) {
            return false;
        }
        CameraInfo cameraInfo = (CameraInfo) obj;
        return j.a(this.basicInfo, cameraInfo.basicInfo) && j.a(this.systemInfo, cameraInfo.systemInfo);
    }

    public final BasicInfo getBasicInfo() {
        return this.basicInfo;
    }

    public final SystemInfo getSystemInfo() {
        return this.systemInfo;
    }

    public int hashCode() {
        BasicInfo basicInfo = this.basicInfo;
        int i = 0;
        int hashCode = (basicInfo != null ? basicInfo.hashCode() : 0) * 31;
        SystemInfo systemInfo = this.systemInfo;
        if (systemInfo != null) {
            i = systemInfo.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CameraInfo(basicInfo=" + this.basicInfo + ", systemInfo=" + this.systemInfo + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CameraInfo(Wrappers wrappers) {
        this((BasicInfo) Model.typeCast(wrappers, BasicInfo.class), (SystemInfo) Model.typeCast(wrappers, SystemInfo.class));
        j.e(wrappers, "wrappers");
    }
}
