package com.tplink.libtpnetwork.enumerate;

/* loaded from: classes3.dex */
public enum EnumFeatureType {
    ON_OFF_GRADUALLY("onOffGradually"),
    LED_MODE("ledMode"),
    TRIGGER_CONFIG("triggerConfig"),
    ON_OFF_DELAY("onOffDelay"),
    DOUBLE_CLICK_CONFIG("doubleClickConfig"),
    AUTO_UPDATE_MODE("autoUpdateMode"),
    SEGMENT_CONFIG("segmentConfig"),
    FROST_PROTECTION_CONFIG("frostProtectionConfig"),
    CHILD_PROTECTION_MODE("childProtectionMode"),
    TEMPERATURE_RANGE("temperatureRange"),
    WINDOW_OPEN_DETECTION("windowOpenDetection"),
    AUTO_REMOVE_SCALE("autoRemoveScale"),
    SHUTDOWN_MODE("shutDownMode"),
    EARLY_START("earlyStart"),
    BATTERY_DETECTION("batteryDetection"),
    MUSIC_RHYTHM_GLOBAL_CONFIG("musicRhythmGlobalConfig"),
    MUSIC_RHYTHM_CRYPTO("musicRhythmCrypto");
    
    private String name;

    EnumFeatureType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.name;
    }
}
