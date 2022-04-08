package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public abstract class zzke extends zzkd {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzke(zzkn zzknVar) {
        super(zzknVar);
        this.zzf.zzL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzY() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzZ() {
        if (!zzY()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    protected abstract boolean zzaA();

    public final void zzaa() {
        if (!this.zza) {
            zzaA();
            this.zzf.zzM();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
