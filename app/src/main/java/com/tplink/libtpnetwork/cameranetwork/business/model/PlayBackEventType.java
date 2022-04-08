package com.tplink.libtpnetwork.cameranetwork.business.model;

import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes3.dex */
public enum PlayBackEventType {
    TYPE_TIMING(1, "1"),
    TYPE_MOTION(2, ExifInterface.GPS_MEASUREMENT_2D),
    TYPE_MASK(3, ExifInterface.GPS_MEASUREMENT_3D);
    
    private String name;
    private int value;

    PlayBackEventType(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
