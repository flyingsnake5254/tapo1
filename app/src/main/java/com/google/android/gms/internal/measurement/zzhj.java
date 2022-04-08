package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzhj {
    static volatile zzhz<Boolean> zza = zzhz.zzc();
    private static final Object zzb = new Object();

    /* JADX WARN: Can't wrap try/catch for region: R(11:17|(6:20|(2:22|(1:24))|30|31|32|33)(1:19)|25|38|26|27|(1:29)|30|31|32|33) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zza(android.content.Context r3, android.net.Uri r4) {
        /*
            java.lang.String r4 = r4.getAuthority()
            java.lang.String r0 = "com.google.android.gms.phenotype"
            boolean r0 = r0.equals(r4)
            r1 = 0
            if (r0 != 0) goto L_0x002e
            java.lang.String r3 = java.lang.String.valueOf(r4)
            int r3 = r3.length()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r3 = r3 + 91
            r0.<init>(r3)
            r0.append(r4)
            java.lang.String r3 = " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."
            r0.append(r3)
            java.lang.String r3 = "PhenotypeClientHelper"
            java.lang.String r4 = r0.toString()
            android.util.Log.e(r3, r4)
            return r1
        L_0x002e:
            com.google.android.gms.internal.measurement.zzhz<java.lang.Boolean> r4 = com.google.android.gms.internal.measurement.zzhj.zza
            boolean r4 = r4.zza()
            if (r4 == 0) goto L_0x0043
            com.google.android.gms.internal.measurement.zzhz<java.lang.Boolean> r3 = com.google.android.gms.internal.measurement.zzhj.zza
            java.lang.Object r3 = r3.zzb()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            return r3
        L_0x0043:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhj.zzb
            monitor-enter(r4)
            com.google.android.gms.internal.measurement.zzhz<java.lang.Boolean> r0 = com.google.android.gms.internal.measurement.zzhj.zza     // Catch: all -> 0x00a9
            boolean r0 = r0.zza()     // Catch: all -> 0x00a9
            if (r0 == 0) goto L_0x005c
            com.google.android.gms.internal.measurement.zzhz<java.lang.Boolean> r3 = com.google.android.gms.internal.measurement.zzhj.zza     // Catch: all -> 0x00a9
            java.lang.Object r3 = r3.zzb()     // Catch: all -> 0x00a9
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: all -> 0x00a9
            boolean r3 = r3.booleanValue()     // Catch: all -> 0x00a9
            monitor-exit(r4)     // Catch: all -> 0x00a9
            return r3
        L_0x005c:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = r3.getPackageName()     // Catch: all -> 0x00a9
            boolean r0 = r0.equals(r2)     // Catch: all -> 0x00a9
            if (r0 == 0) goto L_0x0069
            goto L_0x0080
        L_0x0069:
            android.content.pm.PackageManager r0 = r3.getPackageManager()     // Catch: all -> 0x00a9
            java.lang.String r2 = "com.google.android.gms.phenotype"
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r2, r1)     // Catch: all -> 0x00a9
            if (r0 == 0) goto L_0x0091
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r0 = r0.packageName     // Catch: all -> 0x00a9
            boolean r0 = r2.equals(r0)     // Catch: all -> 0x00a9
            if (r0 != 0) goto L_0x0080
            goto L_0x0091
        L_0x0080:
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: all -> 0x00a9
            java.lang.String r0 = "com.google.android.gms"
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo(r0, r1)     // Catch: NameNotFoundException -> 0x0091, all -> 0x00a9
            int r3 = r3.flags     // Catch: all -> 0x00a9
            r3 = r3 & 129(0x81, float:1.81E-43)
            if (r3 == 0) goto L_0x0091
            r1 = 1
        L_0x0091:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)     // Catch: all -> 0x00a9
            com.google.android.gms.internal.measurement.zzhz r3 = com.google.android.gms.internal.measurement.zzhz.zzd(r3)     // Catch: all -> 0x00a9
            com.google.android.gms.internal.measurement.zzhj.zza = r3     // Catch: all -> 0x00a9
            monitor-exit(r4)     // Catch: all -> 0x00a9
            com.google.android.gms.internal.measurement.zzhz<java.lang.Boolean> r3 = com.google.android.gms.internal.measurement.zzhj.zza
            java.lang.Object r3 = r3.zzb()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            return r3
        L_0x00a9:
            r3 = move-exception
            monitor-exit(r4)     // Catch: all -> 0x00a9
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhj.zza(android.content.Context, android.net.Uri):boolean");
    }
}
