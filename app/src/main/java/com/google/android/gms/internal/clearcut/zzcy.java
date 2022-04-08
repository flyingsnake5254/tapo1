package com.google.android.gms.internal.clearcut;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzcy {
    private static final zzcy zzlt = new zzda();
    private static final zzcy zzlu = new zzdb();

    private zzcy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcy zzbv() {
        return zzlt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcy zzbw() {
        return zzlu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);
}
