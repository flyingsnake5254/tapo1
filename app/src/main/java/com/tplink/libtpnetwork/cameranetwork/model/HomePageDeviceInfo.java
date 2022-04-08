package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class HomePageDeviceInfo {
    public static final Companion Companion = new Companion(null);
    private CameraComponent componentInfo;
    private BasicInfo deviceInfo;
    private LastAlarmInfo lastAlarmInfo;

    /* compiled from: ModelAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements UnwrapFromMultipleResponse<HomePageDeviceInfo> {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tplink.libtpnetwork.cameranetwork.model.UnwrapFromMultipleResponse
        public HomePageDeviceInfo fromMultipleResponse(MultipleResponse response) {
            j.e(response, "response");
            HomePageDeviceInfo homePageDeviceInfo = new HomePageDeviceInfo(null, null, null);
            List<Response<Wrappers>> responses = response.getResponses();
            if (responses != null) {
                for (Response<Wrappers> response2 : responses) {
                    Wrappers result = response2.getResult();
                    String method = response2.getMethod();
                    if (j.a(method, Method.GET_DEVICE_INFO.getValue())) {
                        homePageDeviceInfo.setDeviceInfo((BasicInfo) Model.typeCast(result, Module.DEVICE_INFO, Section.BASIC_INFO));
                    } else if (j.a(method, Method.GET_LAST_ALARM_INFO.getValue())) {
                        homePageDeviceInfo.setLastAlarmInfo((LastAlarmInfo) Model.typeCast(result, Module.SYSTEM, Section.LAST_ALARM_INFO));
                    } else if (j.a(method, Method.GET_APP_COMPONENT_LIST.getValue())) {
                        homePageDeviceInfo.setComponentInfo((CameraComponent) Model.typeCast(result, Module.APP_COMPONENT, Section.APP_COMPONENT_LIST));
                    }
                }
            }
            return homePageDeviceInfo;
        }
    }

    public HomePageDeviceInfo(BasicInfo basicInfo, LastAlarmInfo lastAlarmInfo, CameraComponent cameraComponent) {
        this.deviceInfo = basicInfo;
        this.lastAlarmInfo = lastAlarmInfo;
        this.componentInfo = cameraComponent;
    }

    public static /* synthetic */ HomePageDeviceInfo copy$default(HomePageDeviceInfo homePageDeviceInfo, BasicInfo basicInfo, LastAlarmInfo lastAlarmInfo, CameraComponent cameraComponent, int i, Object obj) {
        if ((i & 1) != 0) {
            basicInfo = homePageDeviceInfo.deviceInfo;
        }
        if ((i & 2) != 0) {
            lastAlarmInfo = homePageDeviceInfo.lastAlarmInfo;
        }
        if ((i & 4) != 0) {
            cameraComponent = homePageDeviceInfo.componentInfo;
        }
        return homePageDeviceInfo.copy(basicInfo, lastAlarmInfo, cameraComponent);
    }

    public final BasicInfo component1() {
        return this.deviceInfo;
    }

    public final LastAlarmInfo component2() {
        return this.lastAlarmInfo;
    }

    public final CameraComponent component3() {
        return this.componentInfo;
    }

    public final HomePageDeviceInfo copy(BasicInfo basicInfo, LastAlarmInfo lastAlarmInfo, CameraComponent cameraComponent) {
        return new HomePageDeviceInfo(basicInfo, lastAlarmInfo, cameraComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomePageDeviceInfo)) {
            return false;
        }
        HomePageDeviceInfo homePageDeviceInfo = (HomePageDeviceInfo) obj;
        return j.a(this.deviceInfo, homePageDeviceInfo.deviceInfo) && j.a(this.lastAlarmInfo, homePageDeviceInfo.lastAlarmInfo) && j.a(this.componentInfo, homePageDeviceInfo.componentInfo);
    }

    public final CameraComponent getComponentInfo() {
        return this.componentInfo;
    }

    public final BasicInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final LastAlarmInfo getLastAlarmInfo() {
        return this.lastAlarmInfo;
    }

    public int hashCode() {
        BasicInfo basicInfo = this.deviceInfo;
        int i = 0;
        int hashCode = (basicInfo != null ? basicInfo.hashCode() : 0) * 31;
        LastAlarmInfo lastAlarmInfo = this.lastAlarmInfo;
        int hashCode2 = (hashCode + (lastAlarmInfo != null ? lastAlarmInfo.hashCode() : 0)) * 31;
        CameraComponent cameraComponent = this.componentInfo;
        if (cameraComponent != null) {
            i = cameraComponent.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setComponentInfo(CameraComponent cameraComponent) {
        this.componentInfo = cameraComponent;
    }

    public final void setDeviceInfo(BasicInfo basicInfo) {
        this.deviceInfo = basicInfo;
    }

    public final void setLastAlarmInfo(LastAlarmInfo lastAlarmInfo) {
        this.lastAlarmInfo = lastAlarmInfo;
    }

    public String toString() {
        return "HomePageDeviceInfo(deviceInfo=" + this.deviceInfo + ", lastAlarmInfo=" + this.lastAlarmInfo + ", componentInfo=" + this.componentInfo + ")";
    }
}
