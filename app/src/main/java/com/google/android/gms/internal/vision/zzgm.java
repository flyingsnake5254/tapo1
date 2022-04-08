package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzgm extends zzgk<zzgx.zzd> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final <UT, UB> UB zza(zzix zzixVar, Object obj, zzgi zzgiVar, zzgn<zzgx.zzd> zzgnVar, UB ub, zzjo<UT, UB> zzjoVar) throws IOException {
        Object zza;
        ArrayList arrayList;
        zzgx.zzg zzgVar = (zzgx.zzg) obj;
        zzgx.zzd zzdVar = zzgVar.zzxq;
        int i = zzdVar.number;
        if (!zzdVar.zzwx || !zzdVar.zzwy) {
            Object obj2 = null;
            zzkf zzkfVar = zzdVar.zzww;
            if (zzkfVar != zzkf.ENUM) {
                switch (zzgl.zzsg[zzkfVar.ordinal()]) {
                    case 1:
                        obj2 = Double.valueOf(zzixVar.readDouble());
                        break;
                    case 2:
                        obj2 = Float.valueOf(zzixVar.readFloat());
                        break;
                    case 3:
                        obj2 = Long.valueOf(zzixVar.zzdy());
                        break;
                    case 4:
                        obj2 = Long.valueOf(zzixVar.zzdx());
                        break;
                    case 5:
                        obj2 = Integer.valueOf(zzixVar.zzdz());
                        break;
                    case 6:
                        obj2 = Long.valueOf(zzixVar.zzea());
                        break;
                    case 7:
                        obj2 = Integer.valueOf(zzixVar.zzeb());
                        break;
                    case 8:
                        obj2 = Boolean.valueOf(zzixVar.zzec());
                        break;
                    case 9:
                        obj2 = Integer.valueOf(zzixVar.zzef());
                        break;
                    case 10:
                        obj2 = Integer.valueOf(zzixVar.zzeh());
                        break;
                    case 11:
                        obj2 = Long.valueOf(zzixVar.zzei());
                        break;
                    case 12:
                        obj2 = Integer.valueOf(zzixVar.zzej());
                        break;
                    case 13:
                        obj2 = Long.valueOf(zzixVar.zzek());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj2 = zzixVar.zzee();
                        break;
                    case 16:
                        obj2 = zzixVar.readString();
                        break;
                    case 17:
                        obj2 = zzixVar.zzb(zzgVar.zzxp.getClass(), zzgiVar);
                        break;
                    case 18:
                        obj2 = zzixVar.zza(zzgVar.zzxp.getClass(), zzgiVar);
                        break;
                }
            } else {
                int zzdz = zzixVar.zzdz();
                if (zzgVar.zzxq.zzwv.zzh(zzdz) == null) {
                    return (UB) zziy.zza(i, zzdz, ub, zzjoVar);
                }
                obj2 = Integer.valueOf(zzdz);
            }
            zzgx.zzd zzdVar2 = zzgVar.zzxq;
            if (zzdVar2.zzwx) {
                zzgnVar.zzb((zzgn<zzgx.zzd>) zzdVar2, obj2);
            } else {
                int i2 = zzgl.zzsg[zzdVar2.zzww.ordinal()];
                if ((i2 == 17 || i2 == 18) && (zza = zzgnVar.zza((zzgn<zzgx.zzd>) zzgVar.zzxq)) != null) {
                    obj2 = zzgy.zzb(zza, obj2);
                }
                zzgnVar.zza((zzgn<zzgx.zzd>) zzgVar.zzxq, obj2);
            }
        } else {
            switch (zzgl.zzsg[zzdVar.zzww.ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    zzixVar.zza(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    zzixVar.zzb(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    zzixVar.zzd(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    zzixVar.zzc(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    zzixVar.zze(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    zzixVar.zzf(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    zzixVar.zzg(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    zzixVar.zzh(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    zzixVar.zzk(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    zzixVar.zzm(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    zzixVar.zzn(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    zzixVar.zzo(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    zzixVar.zzp(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    zzixVar.zzl(arrayList);
                    ub = (UB) zziy.zza(i, arrayList, zzgVar.zzxq.zzwv, ub, zzjoVar);
                    break;
                default:
                    String valueOf = String.valueOf(zzgVar.zzxq.zzww);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 23);
                    sb.append("Type cannot be packed: ");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
            }
            zzgnVar.zza((zzgn<zzgx.zzd>) zzgVar.zzxq, arrayList);
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final boolean zze(zzih zzihVar) {
        return zzihVar instanceof zzgx.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final zzgn<zzgx.zzd> zzf(Object obj) {
        return ((zzgx.zze) obj).zzwz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final zzgn<zzgx.zzd> zzg(Object obj) {
        return ((zzgx.zze) obj).zzgl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final void zzh(Object obj) {
        zzf(obj).zzdq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final int zza(Map.Entry<?, ?> entry) {
        return ((zzgx.zzd) entry.getKey()).number;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final void zza(zzkl zzklVar, Map.Entry<?, ?> entry) throws IOException {
        zzgx.zzd zzdVar = (zzgx.zzd) entry.getKey();
        if (zzdVar.zzwx) {
            switch (zzgl.zzsg[zzdVar.zzww.ordinal()]) {
                case 1:
                    zziy.zza(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 2:
                    zziy.zzb(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 3:
                    zziy.zzc(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 4:
                    zziy.zzd(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 5:
                    zziy.zzh(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 6:
                    zziy.zzf(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 7:
                    zziy.zzk(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 8:
                    zziy.zzn(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 9:
                    zziy.zzi(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 10:
                    zziy.zzl(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 11:
                    zziy.zzg(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 12:
                    zziy.zzj(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 13:
                    zziy.zze(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 14:
                    zziy.zzh(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    return;
                case 15:
                    zziy.zzb(zzdVar.number, (List) entry.getValue(), zzklVar);
                    return;
                case 16:
                    zziy.zza(zzdVar.number, (List) entry.getValue(), zzklVar);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zziy.zzb(zzdVar.number, (List) entry.getValue(), zzklVar, zzis.zzhp().zzf(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zziy.zza(zzdVar.number, (List) entry.getValue(), zzklVar, zzis.zzhp().zzf(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (zzgl.zzsg[zzdVar.zzww.ordinal()]) {
                case 1:
                    zzklVar.zza(zzdVar.number, ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    zzklVar.zza(zzdVar.number, ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    zzklVar.zzi(zzdVar.number, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    zzklVar.zza(zzdVar.number, ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    zzklVar.zzh(zzdVar.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    zzklVar.zzc(zzdVar.number, ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    zzklVar.zzk(zzdVar.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    zzklVar.zza(zzdVar.number, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    zzklVar.zzi(zzdVar.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    zzklVar.zzr(zzdVar.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    zzklVar.zzj(zzdVar.number, ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    zzklVar.zzj(zzdVar.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    zzklVar.zzb(zzdVar.number, ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    zzklVar.zzh(zzdVar.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    zzklVar.zza(zzdVar.number, (zzfm) entry.getValue());
                    return;
                case 16:
                    zzklVar.zza(zzdVar.number, (String) entry.getValue());
                    return;
                case 17:
                    zzklVar.zzb(zzdVar.number, entry.getValue(), zzis.zzhp().zzf(entry.getValue().getClass()));
                    return;
                case 18:
                    zzklVar.zza(zzdVar.number, entry.getValue(), zzis.zzhp().zzf(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final Object zza(zzgi zzgiVar, zzih zzihVar, int i) {
        return zzgiVar.zza(zzihVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final void zza(zzix zzixVar, Object obj, zzgi zzgiVar, zzgn<zzgx.zzd> zzgnVar) throws IOException {
        zzgx.zzg zzgVar = (zzgx.zzg) obj;
        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVar.zzxq, zzixVar.zza(zzgVar.zzxp.getClass(), zzgiVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzgk
    public final void zza(zzfm zzfmVar, Object obj, zzgi zzgiVar, zzgn<zzgx.zzd> zzgnVar) throws IOException {
        byte[] bArr;
        zzgx.zzg zzgVar = (zzgx.zzg) obj;
        zzih zzgc = zzgVar.zzxp.zzgk().zzgc();
        int size = zzfmVar.size();
        if (size == 0) {
            bArr = zzgy.zzxr;
        } else {
            byte[] bArr2 = new byte[size];
            zzfmVar.zza(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            zzfl zzflVar = new zzfl(wrap, true);
            zzis.zzhp().zzv(zzgc).zza(zzgc, zzflVar, zzgiVar);
            zzgnVar.zza((zzgn<zzgx.zzd>) zzgVar.zzxq, zzgc);
            if (zzflVar.zzdv() != Integer.MAX_VALUE) {
                throw zzhh.zzgr();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
