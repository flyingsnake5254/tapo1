package com.tplink.iot.musicphonerhythm.enumerate;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.messaging.ServiceStarter;
import java.util.Arrays;

/* loaded from: classes2.dex */
public enum SpeedGap {
    VERY_SLOW(new int[]{125, ServiceStarter.ERROR_UNKNOWN}),
    SLOW(new int[]{187, 750}),
    NORMAL_SPEED(new int[]{ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 1000}),
    FAST(new int[]{375, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED}),
    VERY_FAST(new int[]{ServiceStarter.ERROR_UNKNOWN, PlaybackException.ERROR_CODE_IO_UNSPECIFIED});
    
    private int[] value;

    SpeedGap(int[] iArr) {
        this.value = iArr;
    }

    @Nullable
    public static Sensitivity fromValue(int[] iArr) {
        Sensitivity[] values;
        for (Sensitivity sensitivity : Sensitivity.values()) {
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
