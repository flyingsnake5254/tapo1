package com.tplink.libtpnetwork.enumerate;

import androidx.core.os.EnvironmentCompat;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public enum EnumIoTComponent {
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN, null),
    ACCOUNT("account", Collections.singletonList(1)),
    ANTITHEFT("antitheft", Collections.singletonList(1)),
    COMPONENT("component", Arrays.asList(0, 1)),
    COUNTDOWN("countdown", Arrays.asList(1, 2)),
    DEVICE("device", Arrays.asList(1, 2)),
    FIRMWARE("firmware", Arrays.asList(1, 2)),
    QUICK_SETUP("quick_setup", Arrays.asList(1, 2, 3)),
    SCHEDULE("schedule", Arrays.asList(1, 2)),
    SYNCHRONIZE("synchronize", Collections.singletonList(1)),
    TIME(RtspHeaders.Values.TIME, Collections.singletonList(1)),
    WIRELESS("wireless", Collections.singletonList(1)),
    SUNRISE_SUNSET("sunrise_sunset", Collections.singletonList(1)),
    LED("led", Collections.singletonList(1)),
    CLOUD_CONNECT("cloud_connect", Collections.singletonList(1)),
    BRIGHTNESS("brightness", Collections.singletonList(1)),
    DEFAULT_STATES("default_states", Collections.singletonList(1)),
    PRESET("preset", Arrays.asList(1, 2, 3)),
    IOT_CLOUD("iot_cloud", Collections.singletonList(1)),
    INHERIT("inherit", Arrays.asList(0, 1)),
    COLOR("color", Collections.singletonList(1)),
    COLOR_TEMPERATURE("color_temperature", Collections.singletonList(1)),
    ON_OFF_GRADUALLY("on_off_gradually", Arrays.asList(0, 1)),
    AUTO_LIGHT("auto_light", Collections.singletonList(1)),
    LIGHT_EFFECT("light_effect", Collections.singletonList(1)),
    CHILD_DEVICE("child_device", Collections.singletonList(1)),
    CONTROL_CHILD("control_child", Collections.singletonList(1)),
    CHILD_QUICK_SETUP("child_quick_setup", Collections.singletonList(1)),
    GUARD_MODE("guard_mode", Collections.singletonList(1)),
    TRIGGER_LOG("trigger_log", Collections.singletonList(1)),
    SENSITIVITY("sensitivity", Collections.singletonList(1)),
    ALARM_LOGS("alarm_logs", Collections.singletonList(1)),
    DEVICE_LOAD("device_load", Collections.singletonList(1)),
    ENERGY_MONITORING("energy_monitoring", Collections.singletonList(1)),
    DEVICE_LOCAL_TIME("device_local_time", Collections.singletonList(1)),
    DELAY_ACTION("delay_action", Collections.singletonList(1)),
    BATTERY_DETECT("battery_detect", Collections.singletonList(1)),
    DOUBLE_CLICK("double_click", Collections.singletonList(1)),
    LIGHT_STRIP("light_strip", Collections.singletonList(1)),
    LIGHT_STRIP_LIGHTING_EFFECT("light_strip_lighting_effect", Arrays.asList(1, 2)),
    SEGMENT("segment", Collections.singletonList(1)),
    FROST_PROTECTION(EnumTRVState.TRV_FROST_PROTECTION, Collections.singletonList(1)),
    CHILD_PROTECTION("child_protection", Collections.singletonList(1)),
    TEMPERATURE("temperature", Collections.singletonList(1)),
    TEMP_CONTROL("temp_control", Collections.singletonList(1)),
    WINDOW_OPEN_DETECT("window_open_detect", Collections.singletonList(1)),
    REMOVE_SCALE("remove_scale", Collections.singletonList(1)),
    SHUTDOWN_MODE("shutdown_mode", Collections.singletonList(1)),
    PROGRESS_CALIBRATION(EnumTRVState.TRV_PROGRESS_CALIBRATION, Collections.singletonList(1)),
    EARLY_START("early_start", Collections.singletonList(1)),
    TEMP_RECORD("temp_record", Collections.singletonList(1)),
    MUSIC_RHYTHM("music_rhythm", Arrays.asList(1, 2));
    
    private List<Integer> appSupportVersions;
    private String componentName;

    EnumIoTComponent(String str, List list) {
        this.componentName = str;
        this.appSupportVersions = list;
    }

    public static EnumIoTComponent fromComponentName(String str) {
        EnumIoTComponent[] values;
        for (EnumIoTComponent enumIoTComponent : values()) {
            if (enumIoTComponent.getComponentName().equals(str)) {
                return enumIoTComponent;
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
