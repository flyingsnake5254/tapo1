package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@KeepForSdk
/* loaded from: classes.dex */
public class WorkSourceUtil {
    private static final int zzhj = Process.myUid();
    private static final Method zzhk = zzx();
    private static final Method zzhl = zzy();
    private static final Method zzhm = zzz();
    private static final Method zzhn = zzaa();
    private static final Method zzho = zzab();
    private static final Method zzhp = zzac();
    private static final Method zzhq = zzad();

    private WorkSourceUtil() {
    }

    @Nullable
    @KeepForSdk
    public static WorkSource fromPackage(Context context, @Nullable String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo != null) {
                    return zza(applicationInfo.uid, str);
                }
                Log.e("WorkSourceUtil", str.length() != 0 ? "Could not get applicationInfo from package: ".concat(str) : new String("Could not get applicationInfo from package: "));
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", str.length() != 0 ? "Could not find package: ".concat(str) : new String("Could not find package: "));
            }
        }
        return null;
    }

    @KeepForSdk
    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String str, String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int zzd = zzd(context, str);
        if (zzd < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzhp;
        if (method2 == null || (method = zzhq) == null) {
            zza(workSource, zzd, str);
        } else {
            try {
                Object invoke = method2.invoke(workSource, new Object[0]);
                int i = zzhj;
                if (zzd != i) {
                    method.invoke(invoke, Integer.valueOf(zzd), str);
                }
                method.invoke(invoke, Integer.valueOf(i), str2);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e2);
            }
        }
        return workSource;
    }

    @KeepForSdk
    public static List<String> getNames(@Nullable WorkSource workSource) {
        int zza = workSource == null ? 0 : zza(workSource);
        if (zza == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < zza; i++) {
            String zza2 = zza(workSource, i);
            if (!Strings.isEmptyOrWhitespace(zza2)) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }

    @KeepForSdk
    public static boolean hasWorkSourcePermission(Context context) {
        return (context == null || context.getPackageManager() == null || Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    private static WorkSource zza(int i, String str) {
        WorkSource workSource = new WorkSource();
        zza(workSource, i, str);
        return workSource;
    }

    private static Method zzaa() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzab() {
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                return WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static final Method zzac() {
        if (PlatformVersion.isAtLeastP()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e2);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static final Method zzad() {
        if (PlatformVersion.isAtLeastP()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e2);
            }
        }
        return null;
    }

    private static int zzd(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.uid;
            }
            String valueOf = String.valueOf(str);
            Log.e("WorkSourceUtil", valueOf.length() != 0 ? "Could not get applicationInfo from package: ".concat(valueOf) : new String("Could not get applicationInfo from package: "));
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf2 = String.valueOf(str);
            Log.e("WorkSourceUtil", valueOf2.length() != 0 ? "Could not find package: ".concat(valueOf2) : new String("Could not find package: "));
            return -1;
        }
    }

    private static Method zzx() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzy() {
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static Method zzz() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void zza(WorkSource workSource, int i, @Nullable String str) {
        Method method = zzhl;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i), str);
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        } else {
            Method method2 = zzhk;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, Integer.valueOf(i));
                } catch (Exception e3) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                }
            }
        }
    }

    private static int zza(WorkSource workSource) {
        Method method = zzhm;
        if (method != null) {
            try {
                return ((Integer) method.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    @Nullable
    private static String zza(WorkSource workSource, int i) {
        Method method = zzho;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i));
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }
}
