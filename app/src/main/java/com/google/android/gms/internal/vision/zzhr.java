package com.google.android.gms.internal.vision;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public abstract class zzhr {
    private static final zzhr zzyt = new zzht();
    private static final zzhr zzyu = new zzhs();

    private zzhr() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhr zzha() {
        return zzyt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhr zzhb() {
        return zzyu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);
}
