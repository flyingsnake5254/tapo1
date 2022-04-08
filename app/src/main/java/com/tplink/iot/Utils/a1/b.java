package com.tplink.iot.Utils.a1;

import android.os.Build;
import android.os.Environment;

/* compiled from: FileStorageCompatUtils.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final String[] a() {
        if (c()) {
            return new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    public static final boolean b() {
        return Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy();
    }

    public static final boolean c() {
        return !b();
    }
}
