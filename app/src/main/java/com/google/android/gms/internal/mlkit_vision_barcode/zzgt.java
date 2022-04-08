package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public class zzgt {
    private static final zzfo zza = zzfo.zza();
    private zzew zzb;
    private volatile zzhk zzc;
    private volatile zzew zzd;

    private final zzhk zzb(zzhk zzhkVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzhkVar;
                        this.zzd = zzew.zza;
                    } catch (zzgk unused) {
                        this.zzc = zzhkVar;
                        this.zzd = zzew.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgt)) {
            return false;
        }
        zzgt zzgtVar = (zzgt) obj;
        zzhk zzhkVar = this.zzc;
        zzhk zzhkVar2 = zzgtVar.zzc;
        if (zzhkVar == null && zzhkVar2 == null) {
            return zzc().equals(zzgtVar.zzc());
        }
        if (zzhkVar != null && zzhkVar2 != null) {
            return zzhkVar.equals(zzhkVar2);
        }
        if (zzhkVar != null) {
            return zzhkVar.equals(zzgtVar.zzb(zzhkVar.zzo()));
        }
        return zzb(zzhkVar2.zzo()).equals(zzhkVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzhk zza(zzhk zzhkVar) {
        zzhk zzhkVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzhkVar;
        return zzhkVar2;
    }

    public final zzew zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzew.zza;
            } else {
                this.zzd = this.zzc.zze();
            }
            return this.zzd;
        }
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzj();
        }
        return 0;
    }
}
