package com.tplink.libtpnetwork.cameranetwork.model;

import androidx.core.os.EnvironmentCompat;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public enum ComponentType {
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN, null),
    SD_CARD("sdCard", Collections.singletonList(1)),
    TIME_ZONE("timezone", Collections.singletonList(1)),
    SYSTEM("system", Arrays.asList(1, 2, 3, 4)),
    LED("led", Collections.singletonList(1)),
    PLAYBACK("playback", Arrays.asList(1, 2, 3)),
    DETECTION("detection", Arrays.asList(1, 2)),
    ALERT("alert", Collections.singletonList(1)),
    FIRMWARE("firmware", Arrays.asList(1, 2)),
    ACCOUNT("account", Collections.singletonList(1)),
    QUICK_SETUP("quickSetup", Collections.singletonList(1)),
    PTZ("ptz", Collections.singletonList(1)),
    VIDEO("video", Arrays.asList(1, 2)),
    LEN_MASK(ThingModelDefine.Property.PROPERTY_CAMERA_LENS_MASK, Arrays.asList(1, 2)),
    LIGHT_FREQUENCY("lightFrequency", Collections.singletonList(1)),
    DAY_NIGHT_MODE(ThingModelDefine.Property.PROPERTY_CAMERA_DAY_NIGHT_MODE, Collections.singletonList(1)),
    OSD("osd", Arrays.asList(1, 2)),
    RECORD("record", Collections.singletonList(1)),
    VIDEO_ROTATION("videoRotation", Collections.singletonList(1)),
    AUDIO("audio", Arrays.asList(1, 2)),
    DIAGNOSE("diagnose", Collections.singletonList(1)),
    LDC("ldc", Collections.singletonList(1)),
    MSG_PUSH("msgPush", Collections.singletonList(2)),
    DEVICE_SHARE("deviceShare", Collections.singletonList(1)),
    TAMPER_DETECTION("tamperDetection", Collections.singletonList(1)),
    INTRUSION_DETECTION("intrusionDetection", Collections.singletonList(2)),
    LINE_CROSSING_DETECTION("linecrossingDetection", Collections.singletonList(2)),
    PERSON_DETECTION("personDetection", Collections.singletonList(1)),
    TAPO_CARE("tapoCare", Collections.singletonList(1)),
    BABY_CRYING_DETECTION("babyCryDetection", Collections.singletonList(1)),
    BLOCK_ZONE("blockZone", Collections.singletonList(1)),
    TARGET_TRACK("targetTrack", Collections.singletonList(1)),
    AI_DETECTION("aiDetection", Collections.singletonList(1)),
    NIGHT_VISION_MODE("nightVisionMode", Arrays.asList(1, 2)),
    IOT_CLOUD("iotCloud", Collections.singletonList(1)),
    UPNPC("upnpc", Collections.singletonList(2)),
    NEED_SUBSCRIPTION_SERVICE_LIST("needSubscriptionServiceList", Collections.singletonList(1));
    
    private List<Integer> appSupportVersions;
    private String componentName;

    ComponentType(String str, List list) {
        this.componentName = str;
        this.appSupportVersions = list;
    }

    public static ComponentType fromComponentName(String str) {
        ComponentType[] values;
        for (ComponentType componentType : values()) {
            if (componentType.getComponentName().equals(str)) {
                return componentType;
            }
        }
        return UNKNOWN;
    }

    public String getComponentName() {
        return this.componentName;
    }

    public boolean isTargetComponentVersionAPPSupport(int i) {
        List<Integer> list = this.appSupportVersions;
        return list != null && list.contains(Integer.valueOf(i));
    }
}
