package com.tplink.iot.musicphonerhythm.enumerate;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public enum Sensitivity {
    VERY_SENSITIVE(new int[]{20, -12}),
    SENSITIVE(new int[]{35, -21}),
    NORMAL_SENSITIVE(new int[]{50, -30}),
    LITTLE_SENSITIVE(new int[]{65, -39}),
    LESS_SENSITIVE(new int[]{80, -48});
    
    private int[] value;

    Sensitivity(int[] iArr) {
        this.value = iArr;
    }

    @Nullable
    public static Sensitivity fromValue(int[] iArr) {
        Sensitivity[] values;
        for (Sensitivity sensitivity : values()) {
            if (Arrays.equals(sensitivity.getValue(), iArr)) {
                return sensitivity;
            }
        }
        return null;
    }

    public int[] getValue() {
        return this.value;
    }

    public void setValue(int[] iArr) {
        this.value = iArr;
    }
}
