package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzir {
    private static final zzip zzaaa = zzho();
    private static final zzip zzaab = new zzio();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzip zzhm() {
        return zzaaa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzip zzhn() {
        return zzaab;
    }

    private static zzip zzho() {
        try {
            return (zzip) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
