package com.tplink.libtpcommonstream.stream.control.notification;

/* loaded from: classes3.dex */
public enum MotorStatus {
    IDLE("idle"),
    MOVING(com.tplink.libtpcommonstream.stream.control.common.MotorStatus.MOVING);
    
    private String value;

    MotorStatus(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
