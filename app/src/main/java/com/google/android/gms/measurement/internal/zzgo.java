package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public abstract class zzgo extends zzgn {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgo(zzfu zzfuVar) {
        super(zzfuVar);
        this.zzs.zzJ();
    }

    protected abstract boolean zza();

    protected void zzaz() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzu() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzv() {
        if (!zzu()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zza()) {
            this.zzs.zzK();
            this.zza = true;
        }
    }

    public final void zzy() {
        if (!this.zza) {
            zzaz();
            this.zzs.zzK();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
