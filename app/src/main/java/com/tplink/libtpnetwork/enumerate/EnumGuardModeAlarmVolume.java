package com.tplink.libtpnetwork.enumerate;

/* compiled from: EnumGuardMode.kt */
/* loaded from: classes3.dex */
public enum EnumGuardModeAlarmVolume {
    MUTE("mute"),
    LOW("low"),
    NORMAL("normal"),
    HIGH("high");
    
    private final String value;

    EnumGuardModeAlarmVolume(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
