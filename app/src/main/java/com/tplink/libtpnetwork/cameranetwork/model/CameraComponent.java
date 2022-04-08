package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class CameraComponent {
    @c("app_component_list")
    private final ArrayList<ComponentBean> componentList;

    public CameraComponent(ArrayList<ComponentBean> componentList) {
        j.e(componentList, "componentList");
        this.componentList = componentList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CameraComponent copy$default(CameraComponent cameraComponent, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = cameraComponent.componentList;
        }
        return cameraComponent.copy(arrayList);
    }

    public final ArrayList<ComponentBean> component1() {
        return this.componentList;
    }

    public final CameraComponent copy(ArrayList<ComponentBean> componentList) {
        j.e(componentList, "componentList");
        return new CameraComponent(componentList);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CameraComponent) && j.a(this.componentList, ((CameraComponent) obj).componentList);
        }
        return true;
    }

    public final int getComponent(ComponentType type) {
        j.e(type, "type");
        Iterator<ComponentBean> it = this.componentList.iterator();
        while (it.hasNext()) {
            ComponentBean next = it.next();
            if (type == ComponentType.fromComponentName(next.getName())) {
                return next.getVersion();
            }
        }
        return -1;
    }

    public final ArrayList<ComponentBean> getComponentList() {
        return this.componentList;
    }

    public final boolean hasComponent(ComponentType type) {
        j.e(type, "type");
        return type.isTargetComponentVersionAPPSupport(getComponent(type));
    }

    public int hashCode() {
        ArrayList<ComponentBean> arrayList = this.componentList;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public final boolean isSupportBabyCry() {
        return hasComponent(ComponentType.BABY_CRYING_DETECTION);
    }

    public final boolean isSupportFirmware() {
        return hasComponent(ComponentType.FIRMWARE);
    }

    public final boolean isSupportFwAutoUpdate() {
        return getComponent(ComponentType.FIRMWARE) >= 2;
    }

    public final boolean isSupportIntrusionDetection() {
        return hasComponent(ComponentType.INTRUSION_DETECTION);
    }

    public final boolean isSupportIoTCloud() {
        return hasComponent(ComponentType.IOT_CLOUD);
    }

    public final boolean isSupportLineCrossingDetection() {
        return hasComponent(ComponentType.LINE_CROSSING_DETECTION);
    }

    public final boolean isSupportMsgPush() {
        return getComponent(ComponentType.MSG_PUSH) >= 2;
    }

    public final boolean isSupportNightVision() {
        return hasComponent(ComponentType.NIGHT_VISION_MODE);
    }

    public final boolean isSupportOsdLogo() {
        return getComponent(ComponentType.OSD) >= 2;
    }

    public final boolean isSupportPersonDetection() {
        return hasComponent(ComponentType.PERSON_DETECTION);
    }

    public final boolean isSupportPersonEnhanced() {
        return getComponent(ComponentType.DETECTION) >= 2;
    }

    public final boolean isSupportSnapshot() {
        return getComponent(ComponentType.PLAYBACK) >= 3;
    }

    public final boolean isSupportSubscriptionService() {
        return hasComponent(ComponentType.NEED_SUBSCRIPTION_SERVICE_LIST);
    }

    public final boolean isSupportTamperDetection() {
        return hasComponent(ComponentType.TAMPER_DETECTION);
    }

    public final boolean isSupportUpnp() {
        return hasComponent(ComponentType.UPNPC);
    }

    public final boolean isSupportUtcDst() {
        return getComponent(ComponentType.PLAYBACK) >= 2;
    }

    public final boolean isSupportVideoQuality() {
        return getComponent(ComponentType.VIDEO) >= 2;
    }

    public final boolean isSupportVideoQualityChange() {
        return getComponent(ComponentType.VIDEO) == 1;
    }

    public final boolean isSupportWhiteLampConfig() {
        return getComponent(ComponentType.NIGHT_VISION_MODE) >= 2;
    }

    public String toString() {
        return "CameraComponent(componentList=" + this.componentList + ")";
    }
}
