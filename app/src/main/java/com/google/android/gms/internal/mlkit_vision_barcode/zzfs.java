package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_barcode.zzfu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzfs<T extends zzfu<T>> {
    private static final zzfs zzd = new zzfs(true);
    final zzic<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzfs() {
        this.zza = zzic.zza(16);
    }

    public static <T extends zzfu<T>> zzfs<T> zza() {
        return zzd;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfs zzfsVar = new zzfs();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb = this.zza.zzb(i);
            zzfsVar.zzb((zzfs) zzb.getKey(), zzb.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            zzfsVar.zzb((zzfs) entry.getKey(), entry.getValue());
        }
        zzfsVar.zzc = this.zzc;
        return zzfsVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfs)) {
            return false;
        }
        return this.zza.equals(((zzfs) obj).zza);
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
            return new zzgq(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzgq(this.zza.zze().iterator());
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
        if (!(obj instanceof zzgp)) {
            return obj;
        }
        zzgp zzgpVar = (zzgp) obj;
        return zzgp.zza();
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() != zzjk.MESSAGE || key.zzd() || key.zze()) {
            return zza((zzfu<?>) key, value);
        }
        if (value instanceof zzgp) {
            return zzfn.zzb(entry.getKey().zza(), (zzgp) value);
        }
        return zzfn.zzb(entry.getKey().zza(), (zzhk) value);
    }

    private zzfs(boolean z) {
        this(zzic.zza(0));
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
        if (obj instanceof zzgp) {
            this.zzc = true;
        }
        this.zza.zza((zzic<T, Object>) t, (T) obj);
    }

    private zzfs(zzic<T, Object> zzicVar) {
        this.zza = zzicVar;
        zzb();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzgf) == false) goto L_0x0014;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzgp) == false) goto L_0x0014;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(com.google.android.gms.internal.mlkit_vision_barcode.zzjh r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.mlkit_vision_barcode.zzgc.zza(r3)
            int[] r0 = com.google.android.gms.internal.mlkit_vision_barcode.zzfv.zza
            com.google.android.gms.internal.mlkit_vision_barcode.zzjk r2 = r2.zza()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzhk
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzgp
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzew
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzfs.zza(com.google.android.gms.internal.mlkit_vision_barcode.zzjh, java.lang.Object):void");
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzhk zzhkVar;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzgp) {
            zzgp zzgpVar = (zzgp) value;
            value = zzgp.zza();
        }
        if (key.zzd()) {
            Object zza = zza((zzfs<T>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zza(obj));
            }
            this.zza.zza((zzic<T, Object>) key, (T) zza);
        } else if (key.zzc() == zzjk.MESSAGE) {
            Object zza2 = zza((zzfs<T>) key);
            if (zza2 == null) {
                this.zza.zza((zzic<T, Object>) key, (T) zza(value));
                return;
            }
            if (zza2 instanceof zzhq) {
                zzhkVar = key.zza((zzhq) zza2, (zzhq) value);
            } else {
                zzhkVar = key.zza(((zzhk) zza2).zzn(), (zzhk) value).zzg();
            }
            this.zza.zza((zzic<T, Object>) key, (T) zzhkVar);
        } else {
            this.zza.zza((zzic<T, Object>) key, (T) zza(value));
        }
    }

    private static <T extends zzfu<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzjk.MESSAGE) {
            if (key.zzd()) {
                for (zzhk zzhkVar : (List) entry.getValue()) {
                    if (!zzhkVar.zzi()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzhk) {
                    if (!((zzhk) value).zzi()) {
                        return false;
                    }
                } else if (value instanceof zzgp) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzfs<T> zzfsVar) {
        for (int i = 0; i < zzfsVar.zza.zzc(); i++) {
            zzb(zzfsVar.zza.zzb(i));
        }
        for (Map.Entry<T, Object> entry : zzfsVar.zza.zzd()) {
            zzb(entry);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzhq) {
            return ((zzhq) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int zzb(zzjh zzjhVar, Object obj) {
        switch (zzfv.zzb[zzjhVar.ordinal()]) {
            case 1:
                return zzfn.zzb(((Double) obj).doubleValue());
            case 2:
                return zzfn.zzb(((Float) obj).floatValue());
            case 3:
                return zzfn.zzd(((Long) obj).longValue());
            case 4:
                return zzfn.zze(((Long) obj).longValue());
            case 5:
                return zzfn.zzf(((Integer) obj).intValue());
            case 6:
                return zzfn.zzg(((Long) obj).longValue());
            case 7:
                return zzfn.zzi(((Integer) obj).intValue());
            case 8:
                return zzfn.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzfn.zzc((zzhk) obj);
            case 10:
                if (obj instanceof zzgp) {
                    return zzfn.zza((zzgp) obj);
                }
                return zzfn.zzb((zzhk) obj);
            case 11:
                if (obj instanceof zzew) {
                    return zzfn.zzb((zzew) obj);
                }
                return zzfn.zzb((String) obj);
            case 12:
                if (obj instanceof zzew) {
                    return zzfn.zzb((zzew) obj);
                }
                return zzfn.zzb((byte[]) obj);
            case 13:
                return zzfn.zzg(((Integer) obj).intValue());
            case 14:
                return zzfn.zzj(((Integer) obj).intValue());
            case 15:
                return zzfn.zzh(((Long) obj).longValue());
            case 16:
                return zzfn.zzh(((Integer) obj).intValue());
            case 17:
                return zzfn.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzgf) {
                    return zzfn.zzk(((zzgf) obj).zza());
                }
                return zzfn.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzfn zzfnVar, zzjh zzjhVar, int i, Object obj) throws IOException {
        if (zzjhVar == zzjh.GROUP) {
            zzhk zzhkVar = (zzhk) obj;
            zzgc.zza(zzhkVar);
            zzfnVar.zza(i, 3);
            zzhkVar.zza(zzfnVar);
            zzfnVar.zza(i, 4);
            return;
        }
        zzfnVar.zza(i, zzjhVar.zzb());
        switch (zzfv.zzb[zzjhVar.ordinal()]) {
            case 1:
                zzfnVar.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzfnVar.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzfnVar.zza(((Long) obj).longValue());
                return;
            case 4:
                zzfnVar.zza(((Long) obj).longValue());
                return;
            case 5:
                zzfnVar.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzfnVar.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzfnVar.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzfnVar.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzhk) obj).zza(zzfnVar);
                return;
            case 10:
                zzfnVar.zza((zzhk) obj);
                return;
            case 11:
                if (obj instanceof zzew) {
                    zzfnVar.zza((zzew) obj);
                    return;
                } else {
                    zzfnVar.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzew) {
                    zzfnVar.zza((zzew) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzfnVar.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzfnVar.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzfnVar.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzfnVar.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzfnVar.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzfnVar.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzgf) {
                    zzfnVar.zza(((zzgf) obj).zza());
                    return;
                } else {
                    zzfnVar.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzjh zzjhVar, int i, Object obj) {
        int zze = zzfn.zze(i);
        if (zzjhVar == zzjh.GROUP) {
            zzgc.zza((zzhk) obj);
            zze <<= 1;
        }
        return zze + zzb(zzjhVar, obj);
    }

    public static int zza(zzfu<?> zzfuVar, Object obj) {
        zzjh zzb = zzfuVar.zzb();
        int zza = zzfuVar.zza();
        if (!zzfuVar.zzd()) {
            return zza(zzb, zza, obj);
        }
        int i = 0;
        if (zzfuVar.zze()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzb, obj2);
            }
            return zzfn.zze(zza) + i + zzfn.zzl(i);
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzb, zza, obj3);
        }
        return i;
    }
}
