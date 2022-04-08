package com.tplink.libtpnetwork.cameranetwork.business.repo.firmware;

import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes3.dex */
public enum FirmwareUpdateLevel {
    LEVEL1("1"),
    LEVEL2(ExifInterface.GPS_MEASUREMENT_2D),
    LEVEL3(ExifInterface.GPS_MEASUREMENT_3D),
    LEVEL4("4");
    
    private String level;

    FirmwareUpdateLevel(String str) {
        this.level = str;
    }

    public static FirmwareUpdateLevel makeFirmwareUpdateLevel(int i) {
        if (i == 1) {
            return LEVEL1;
        }
        if (i == 2) {
            return LEVEL2;
        }
        if (i == 3) {
            return LEVEL3;
        }
        if (i != 4) {
            return null;
        }
        return LEVEL4;
    }
}
