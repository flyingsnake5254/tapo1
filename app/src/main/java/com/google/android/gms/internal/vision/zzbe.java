package com.google.android.gms.internal.vision;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.tplink.libtpmediastatistics.SSLClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public final class zzbe {
    private static zzbf zza(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            HashMap hashMap = new HashMap();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.split(SSLClient.WHITE_SPACE, 3);
                    if (split.length != 3) {
                        Log.e("HermeticFileOverrides", readLine.length() != 0 ? "Invalid: ".concat(readLine) : new String("Invalid: "));
                    } else {
                        String str = split[0];
                        String decode = Uri.decode(split[1]);
                        String decode2 = Uri.decode(split[2]);
                        if (!hashMap.containsKey(str)) {
                            hashMap.put(str, new HashMap());
                        }
                        ((Map) hashMap.get(str)).put(decode, decode2);
                    }
                } else {
                    String valueOf = String.valueOf(file);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 7);
                    sb.append("Parsed ");
                    sb.append(valueOf);
                    Log.i("HermeticFileOverrides", sb.toString());
                    zzbf zzbfVar = new zzbf(hashMap);
                    bufferedReader.close();
                    return zzbfVar;
                }
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static zzcs<zzbf> zzf(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        boolean z = false;
        if ((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
            z = true;
        }
        if (!z) {
            return zzcs.zzby();
        }
        if (zzas.zzt() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        zzcs<File> zzg = zzg(context);
        if (zzg.isPresent()) {
            return zzcs.zzc(zza(zzg.get()));
        }
        return zzcs.zzby();
    }

    private static zzcs<File> zzg(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? zzcs.zzc(file) : zzcs.zzby();
        } catch (RuntimeException e2) {
            Log.e("HermeticFileOverrides", "no data dir", e2);
            return zzcs.zzby();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
