package com.tplink.libtpnetwork.cameranetwork.business.model;

/* compiled from: CameraErrorCode.kt */
/* loaded from: classes3.dex */
public enum CameraErrorCode {
    SESSION_EXPIRED(-40401),
    DEVICE_BLOCKED(-40404),
    DEVICE_FACTORY(-40405),
    OUT_OF_LIMIT(-40406),
    OTHER_ERROR(-40407),
    SYSTEM_BLOCKED(-40408),
    NONCE_EXPIRED(-40409),
    FFS_NONE_PWD(-90000);
    
    private final int rawCode;

    CameraErrorCode(int i) {
        this.rawCode = i;
    }

    public final int getRawCode() {
        return this.rawCode;
    }

    public final boolean isEqual(int i) {
        return this.rawCode == i;
    }
}
