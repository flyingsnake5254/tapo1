package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzer<T extends zzet<T>> {
    private static final zzer zzd = new zzer(true);
    final zzgz<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzer() {
        this.zza = zzgz.zza(16);
    }

    public static <T extends zzet<T>> zzer<T> zza() {
        return zzd;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzer zzerVar = new zzer();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb = this.zza.zzb(i);
            zzerVar.zzb((zzer) zzb.getKey(), zzb.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            zzerVar.zzb((zzer) entry.getKey(), entry.getValue());
        }
        zzerVar.zzc = this.zzc;
        return zzerVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzer)) {
            return false;
        }
        return this.zza.equals(((zzer) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzfn(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzfn(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            if (!zza((Map.Entry) entry)) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            i += zzc(entry);
        }
        return i;
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzfm)) {
            return obj;
        }
        zzfm zzfmVar = (zzfm) obj;
        return zzfm.zza();
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() != zzih.MESSAGE || key.zzd() || key.zze()) {
            return zza((zzet<?>) key, value);
        }
        if (value instanceof zzfm) {
            return zzem.zzb(entry.getKey().zza(), (zzfm) value);
        }
        return zzem.zzb(entry.getKey().zza(), (zzgh) value);
    }

    private zzer(boolean z) {
        this(zzgz.zza(0));
        zzb();
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfm) {
            this.zzc = true;
        }
        this.zza.zza((zzgz<T, Object>) t, (T) obj);
    }

    private zzer(zzgz<T, Object> zzgzVar) {
        this.zza = zzgzVar;
        zzb();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.mlkit_common.zzfb) == false) goto L_0x0014;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.mlkit_common.zzfm) == false) goto L_0x0014;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(com.google.android.gms.internal.mlkit_common.zzie r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.mlkit_common.zzfc.zza(r3)
            int[] r0 = com.google.android.gms.internal.mlkit_common.zzeu.zza
            com.google.android.gms.internal.mlkit_common.zzih r2 = r2.zza()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001f;
                case 9: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r0 = 0
            goto L_0x0042
        L_0x0016:
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_common.zzgh
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_common.zzfm
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_common.zzfb
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_common.zzdv
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            return
        L_0x0045:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzer.zza(com.google.android.gms.internal.mlkit_common.zzie, java.lang.Object):void");
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzgh zzghVar;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfm) {
            zzfm zzfmVar = (zzfm) value;
            value = zzfm.zza();
        }
        if (key.zzd()) {
            Object zza = zza((zzer<T>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zza(obj));
            }
            this.zza.zza((zzgz<T, Object>) key, (T) zza);
        } else if (key.zzc() == zzih.MESSAGE) {
            Object zza2 = zza((zzer<T>) key);
            if (zza2 == null) {
                this.zza.zza((zzgz<T, Object>) key, (T) zza(value));
                return;
            }
            if (zza2 instanceof zzgn) {
                zzghVar = key.zza((zzgn) zza2, (zzgn) value);
            } else {
                zzghVar = key.zza(((zzgh) zza2).zzm(), (zzgh) value).zzh();
            }
            this.zza.zza((zzgz<T, Object>) key, (T) zzghVar);
        } else {
            this.zza.zza((zzgz<T, Object>) key, (T) zza(value));
        }
    }

    private static <T extends zzet<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzih.MESSAGE) {
            if (key.zzd()) {
                for (zzgh zzghVar : (List) entry.getValue()) {
                    if (!zzghVar.a_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgh) {
                    if (!((zzgh) value).a_()) {
                        return false;
                    }
                } else if (value instanceof zzfm) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzer<T> zzerVar) {
        for (int i = 0; i < zzerVar.zza.zzc(); i++) {
            zzb(zzerVar.zza.zzb(i));
        }
        for (Map.Entry<T, Object> entry : zzerVar.zza.zzd()) {
            zzb(entry);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzgn) {
            return ((zzgn) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int zzb(zzie zzieVar, Object obj) {
        switch (zzeu.zzb[zzieVar.ordinal()]) {
            case 1:
                return zzem.zzb(((Double) obj).doubleValue());
            case 2:
                return zzem.zzb(((Float) obj).floatValue());
            case 3:
                return zzem.zzd(((Long) obj).longValue());
            case 4:
                return zzem.zze(((Long) obj).longValue());
            case 5:
                return zzem.zzf(((Integer) obj).intValue());
            case 6:
                return zzem.zzg(((Long) obj).longValue());
            case 7:
                return zzem.zzi(((Integer) obj).intValue());
            case 8:
                return zzem.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzem.zzc((zzgh) obj);
            case 10:
                if (obj instanceof zzfm) {
                    return zzem.zza((zzfm) obj);
                }
                return zzem.zzb((zzgh) obj);
            case 11:
                if (obj instanceof zzdv) {
                    return zzem.zzb((zzdv) obj);
                }
                return zzem.zzb((String) obj);
            case 12:
                if (obj instanceof zzdv) {
                    return zzem.zzb((zzdv) obj);
                }
                return zzem.zzb((byte[]) obj);
            case 13:
                return zzem.zzg(((Integer) obj).intValue());
            case 14:
                return zzem.zzj(((Integer) obj).intValue());
            case 15:
                return zzem.zzh(((Long) obj).longValue());
            case 16:
                return zzem.zzh(((Integer) obj).intValue());
            case 17:
                return zzem.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfb) {
                    return zzem.zzk(((zzfb) obj).zza());
                }
                return zzem.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzem zzemVar, zzie zzieVar, int i, Object obj) throws IOException {
        if (zzieVar == zzie.GROUP) {
            zzgh zzghVar = (zzgh) obj;
            zzfc.zza(zzghVar);
            zzemVar.zza(i, 3);
            zzghVar.zza(zzemVar);
            zzemVar.zza(i, 4);
            return;
        }
        zzemVar.zza(i, zzieVar.zzb());
        switch (zzeu.zzb[zzieVar.ordinal()]) {
            case 1:
                zzemVar.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzemVar.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzemVar.zza(((Long) obj).longValue());
                return;
            case 4:
                zzemVar.zza(((Long) obj).longValue());
                return;
            case 5:
                zzemVar.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzemVar.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzemVar.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzemVar.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzgh) obj).zza(zzemVar);
                return;
            case 10:
                zzemVar.zza((zzgh) obj);
                return;
            case 11:
                if (obj instanceof zzdv) {
                    zzemVar.zza((zzdv) obj);
                    return;
                } else {
                    zzemVar.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdv) {
                    zzemVar.zza((zzdv) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzemVar.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzemVar.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzemVar.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzemVar.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzemVar.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzemVar.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfb) {
                    zzemVar.zza(((zzfb) obj).zza());
                    return;
                } else {
                    zzemVar.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzie zzieVar, int i, Object obj) {
        int zze = zzem.zze(i);
        if (zzieVar == zzie.GROUP) {
            zzfc.zza((zzgh) obj);
            zze <<= 1;
        }
        return zze + zzb(zzieVar, obj);
    }

    public static int zza(zzet<?> zzetVar, Object obj) {
        zzie zzb = zzetVar.zzb();
        int zza = zzetVar.zza();
        if (!zzetVar.zzd()) {
            return zza(zzb, zza, obj);
        }
        int i = 0;
        if (zzetVar.zze()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzb, obj2);
            }
            return zzem.zze(zza) + i + zzem.zzl(i);
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzb, zza, obj3);
        }
        return i;
    }
}
