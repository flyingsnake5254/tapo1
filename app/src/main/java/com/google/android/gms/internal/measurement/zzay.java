package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzay extends zzaw {
    public zzay() {
        this.zza.add(zzbl.EQUALS);
        this.zza.add(zzbl.GREATER_THAN);
        this.zza.add(zzbl.GREATER_THAN_EQUALS);
        this.zza.add(zzbl.IDENTITY_EQUALS);
        this.zza.add(zzbl.IDENTITY_NOT_EQUALS);
        this.zza.add(zzbl.LESS_THAN);
        this.zza.add(zzbl.LESS_THAN_EQUALS);
        this.zza.add(zzbl.NOT_EQUALS);
    }

    private static boolean zzc(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof zzal) {
            zzapVar = new zzat(zzapVar.zzc());
        }
        if (zzapVar2 instanceof zzal) {
            zzapVar2 = new zzat(zzapVar2.zzc());
        }
        if ((zzapVar instanceof zzat) && (zzapVar2 instanceof zzat)) {
            return zzapVar.zzc().compareTo(zzapVar2.zzc()) < 0;
        }
        double doubleValue = zzapVar.zzd().doubleValue();
        double doubleValue2 = zzapVar2.zzd().doubleValue();
        return !Double.isNaN(doubleValue) && !Double.isNaN(doubleValue2) && Double.compare(doubleValue, doubleValue2) < 0;
    }

    private static boolean zzd(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar.getClass().equals(zzapVar2.getClass())) {
            if ((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) {
                return true;
            }
            if (zzapVar instanceof zzah) {
                if (Double.isNaN(zzapVar.zzd().doubleValue()) || Double.isNaN(zzapVar2.zzd().doubleValue())) {
                    return false;
                }
                return zzapVar.zzd().equals(zzapVar2.zzd());
            } else if (zzapVar instanceof zzat) {
                return zzapVar.zzc().equals(zzapVar2.zzc());
            } else {
                if (zzapVar instanceof zzaf) {
                    return zzapVar.zze().equals(zzapVar2.zze());
                }
                return zzapVar == zzapVar2;
            }
        } else if (((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) && ((zzapVar2 instanceof zzau) || (zzapVar2 instanceof zzan))) {
            return true;
        } else {
            boolean z = zzapVar instanceof zzah;
            if (z && (zzapVar2 instanceof zzat)) {
                return zzd(zzapVar, new zzah(zzapVar2.zzd()));
            }
            boolean z2 = zzapVar instanceof zzat;
            if (z2 && (zzapVar2 instanceof zzah)) {
                return zzd(new zzah(zzapVar.zzd()), zzapVar2);
            }
            if (zzapVar instanceof zzaf) {
                return zzd(new zzah(zzapVar.zzd()), zzapVar2);
            }
            if (zzapVar2 instanceof zzaf) {
                return zzd(zzapVar, new zzah(zzapVar2.zzd()));
            }
            if ((z2 || z) && (zzapVar2 instanceof zzal)) {
                return zzd(zzapVar, new zzat(zzapVar2.zzc()));
            }
            if (!(zzapVar instanceof zzal) || (!(zzapVar2 instanceof zzat) && !(zzapVar2 instanceof zzah))) {
                return false;
            }
            return zzd(new zzat(zzapVar.zzc()), zzapVar2);
        }
    }

    private static boolean zze(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof zzal) {
            zzapVar = new zzat(zzapVar.zzc());
        }
        if (zzapVar2 instanceof zzal) {
            zzapVar2 = new zzat(zzapVar2.zzc());
        }
        return (((zzapVar instanceof zzat) && (zzapVar2 instanceof zzat)) || (!Double.isNaN(zzapVar.zzd().doubleValue()) && !Double.isNaN(zzapVar2.zzd().doubleValue()))) && !zzc(zzapVar2, zzapVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List<zzap> list) {
        boolean z;
        boolean zzd;
        zzh.zza(zzh.zze(str).name(), 2, list);
        zzap zza = zzgVar.zza(list.get(0));
        zzap zza2 = zzgVar.zza(list.get(1));
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 23) {
            if (ordinal == 48) {
                zzd = zzd(zza, zza2);
            } else if (ordinal == 42) {
                z = zzc(zza, zza2);
            } else if (ordinal != 43) {
                switch (ordinal) {
                    case 37:
                        z = zzc(zza2, zza);
                        break;
                    case 38:
                        z = zze(zza2, zza);
                        break;
                    case 39:
                        z = zzh.zzf(zza, zza2);
                        break;
                    case 40:
                        zzd = zzh.zzf(zza, zza2);
                        break;
                    default:
                        return super.zzb(str);
                }
            } else {
                z = zze(zza, zza2);
            }
            z = !zzd;
        } else {
            z = zzd(zza, zza2);
        }
        return z ? zzap.zzk : zzap.zzl;
    }
}
