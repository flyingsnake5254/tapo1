package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbh extends zzaw {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbh() {
        this.zza.add(zzbl.FOR_IN);
        this.zza.add(zzbl.FOR_IN_CONST);
        this.zza.add(zzbl.FOR_IN_LET);
        this.zza.add(zzbl.FOR_LET);
        this.zza.add(zzbl.FOR_OF);
        this.zza.add(zzbl.FOR_OF_CONST);
        this.zza.add(zzbl.FOR_OF_LET);
        this.zza.add(zzbl.WHILE);
    }

    private static zzap zzc(zzbf zzbfVar, zzap zzapVar, zzap zzapVar2) {
        return zze(zzbfVar, zzapVar.zzf(), zzapVar2);
    }

    private static zzap zzd(zzbf zzbfVar, zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof Iterable) {
            return zze(zzbfVar, ((Iterable) zzapVar).iterator(), zzapVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    private static zzap zze(zzbf zzbfVar, Iterator<zzap> it, zzap zzapVar) {
        if (it != null) {
            while (it.hasNext()) {
                zzap zzb = zzbfVar.zza(it.next()).zzb((zzae) zzapVar);
                if (zzb instanceof zzag) {
                    zzag zzagVar = (zzag) zzb;
                    if ("break".equals(zzagVar.zzg())) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzagVar.zzg())) {
                        return zzagVar;
                    }
                }
            }
        }
        return zzap.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List<zzap> list) {
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 65) {
            switch (ordinal) {
                case 26:
                    zzh.zza(zzbl.FOR_IN.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        String zzc = list.get(0).zzc();
                        return zzc(new zzbg(zzgVar, zzc), zzgVar.zza(list.get(1)), zzgVar.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                case 27:
                    zzh.zza(zzbl.FOR_IN_CONST.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        String zzc2 = list.get(0).zzc();
                        return zzc(new zzbd(zzgVar, zzc2), zzgVar.zza(list.get(1)), zzgVar.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                case 28:
                    zzh.zza(zzbl.FOR_IN_LET.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        String zzc3 = list.get(0).zzc();
                        return zzc(new zzbe(zzgVar, zzc3), zzgVar.zza(list.get(1)), zzgVar.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                case 29:
                    zzh.zza(zzbl.FOR_LET.name(), 4, list);
                    zzap zza = zzgVar.zza(list.get(0));
                    if (zza instanceof zzae) {
                        zzae zzaeVar = (zzae) zza;
                        zzap zzapVar = list.get(1);
                        zzap zzapVar2 = list.get(2);
                        zzap zza2 = zzgVar.zza(list.get(3));
                        zzg zzc4 = zzgVar.zzc();
                        for (int i = 0; i < zzaeVar.zzh(); i++) {
                            String zzc5 = zzaeVar.zzl(i).zzc();
                            zzc4.zze(zzc5, zzgVar.zzh(zzc5));
                        }
                        while (zzgVar.zza(zzapVar).zze().booleanValue()) {
                            zzap zzb = zzgVar.zzb((zzae) zza2);
                            if (zzb instanceof zzag) {
                                zzag zzagVar = (zzag) zzb;
                                if ("break".equals(zzagVar.zzg())) {
                                    return zzap.zzf;
                                }
                                if ("return".equals(zzagVar.zzg())) {
                                    return zzagVar;
                                }
                            }
                            zzg zzc6 = zzgVar.zzc();
                            for (int i2 = 0; i2 < zzaeVar.zzh(); i2++) {
                                String zzc7 = zzaeVar.zzl(i2).zzc();
                                zzc6.zze(zzc7, zzc4.zzh(zzc7));
                            }
                            zzc6.zza(zzapVar2);
                            zzc4 = zzc6;
                        }
                        return zzap.zzf;
                    }
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                case 30:
                    zzh.zza(zzbl.FOR_OF.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        String zzc8 = list.get(0).zzc();
                        return zzd(new zzbg(zzgVar, zzc8), zzgVar.zza(list.get(1)), zzgVar.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                case 31:
                    zzh.zza(zzbl.FOR_OF_CONST.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        String zzc9 = list.get(0).zzc();
                        return zzd(new zzbd(zzgVar, zzc9), zzgVar.zza(list.get(1)), zzgVar.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                case 32:
                    zzh.zza(zzbl.FOR_OF_LET.name(), 3, list);
                    if (list.get(0) instanceof zzat) {
                        String zzc10 = list.get(0).zzc();
                        return zzd(new zzbe(zzgVar, zzc10), zzgVar.zza(list.get(1)), zzgVar.zza(list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                default:
                    return super.zzb(str);
            }
        } else {
            zzh.zza(zzbl.WHILE.name(), 4, list);
            zzap zzapVar3 = list.get(0);
            zzap zzapVar4 = list.get(1);
            zzap zza3 = zzgVar.zza(list.get(3));
            if (zzgVar.zza(list.get(2)).zze().booleanValue()) {
                zzap zzb2 = zzgVar.zzb((zzae) zza3);
                if (zzb2 instanceof zzag) {
                    zzag zzagVar2 = (zzag) zzb2;
                    if ("break".equals(zzagVar2.zzg())) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzagVar2.zzg())) {
                        return zzagVar2;
                    }
                }
            }
            while (zzgVar.zza(zzapVar3).zze().booleanValue()) {
                zzap zzb3 = zzgVar.zzb((zzae) zza3);
                if (zzb3 instanceof zzag) {
                    zzag zzagVar3 = (zzag) zzb3;
                    if ("break".equals(zzagVar3.zzg())) {
                        return zzap.zzf;
                    }
                    if ("return".equals(zzagVar3.zzg())) {
                        return zzagVar3;
                    }
                }
                zzgVar.zza(zzapVar4);
            }
            return zzap.zzf;
        }
    }
}
