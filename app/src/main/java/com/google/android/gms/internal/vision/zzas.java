package com.google.android.gms.internal.vision;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public class zzas {
    @GuardedBy("DirectBootUtils.class")
    private static UserManager zzfn;
    private static volatile boolean zzfo = !zzt();
    @GuardedBy("DirectBootUtils.class")
    private static boolean zzfp = false;

    private zzas() {
    }

    public static boolean isUserUnlocked(Context context) {
        return !zzt() || zzd(context);
    }

    @RequiresApi(24)
    @TargetApi(24)
    @GuardedBy("DirectBootUtils.class")
    private static boolean zzc(Context context) {
        boolean z = true;
        int i = 1;
        while (true) {
            z = false;
            if (i > 2) {
                break;
            }
            if (zzfn == null) {
                zzfn = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = zzfn;
            if (userManager == null) {
                return true;
            }
            try {
                if (userManager.isUserUnlocked()) {
                    break;
                } else if (userManager.isUserRunning(Process.myUserHandle())) {
                    z = false;
                }
            } catch (NullPointerException e2) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e2);
                zzfn = null;
                i++;
            }
        }
        if (z) {
            zzfn = null;
        }
        return z;
    }

    @RequiresApi(24)
    @TargetApi(24)
    private static boolean zzd(Context context) {
        if (zzfo) {
            return true;
        }
        synchronized (zzas.class) {
            if (zzfo) {
                return true;
            }
            boolean zzc = zzc(context);
            if (zzc) {
                zzfo = zzc;
            }
            return zzc;
        }
    }

    public static boolean zzt() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
