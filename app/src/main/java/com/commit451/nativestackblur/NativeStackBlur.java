package com.commit451.nativestackblur;

import android.graphics.Bitmap;
import com.enrique.stackblur.NativeBlurProcess;

/* loaded from: classes.dex */
public class NativeStackBlur {
    public static Bitmap process(Bitmap bitmap, int i) {
        return new NativeBlurProcess().blur(bitmap, i);
    }
}
