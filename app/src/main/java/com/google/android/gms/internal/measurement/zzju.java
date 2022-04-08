package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
final class zzju<T extends zzjt<T>> {
    private static final zzju zzd = new zzju(true);
    final zzmd<T, Object> zza = new zzlw(16);
    private boolean zzb;
    private boolean zzc;

    private zzju() {
    }

    public static <T extends zzjt<T>> zzju<T> zza() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzd(T r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.measurement.zzmx r0 = r4.zzb()
            com.google.android.gms.internal.measurement.zzkl.zza(r5)
            com.google.android.gms.internal.measurement.zzmx r1 = com.google.android.gms.internal.measurement.zzmx.DOUBLE
            com.google.android.gms.internal.measurement.zzmy r1 = com.google.android.gms.internal.measurement.zzmy.INT
            com.google.android.gms.internal.measurement.zzmy r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L_0x0041;
                case 1: goto L_0x003e;
                case 2: goto L_0x003b;
                case 3: goto L_0x0038;
                case 4: goto L_0x0035;
                case 5: goto L_0x0032;
                case 6: goto L_0x0029;
                case 7: goto L_0x0020;
                case 8: goto L_0x0017;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x0046
        L_0x0017:
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzli
            if (r0 != 0) goto L_0x0045
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzkp
            if (r0 == 0) goto L_0x0046
            goto L_0x0045
        L_0x0020:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x0045
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzkf
            if (r0 == 0) goto L_0x0046
            goto L_0x0045
        L_0x0029:
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzjd
            if (r0 != 0) goto L_0x0045
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L_0x0046
            goto L_0x0045
        L_0x0032:
            boolean r0 = r5 instanceof java.lang.String
            goto L_0x0043
        L_0x0035:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L_0x0043
        L_0x0038:
            boolean r0 = r5 instanceof java.lang.Double
            goto L_0x0043
        L_0x003b:
            boolean r0 = r5 instanceof java.lang.Float
            goto L_0x0043
        L_0x003e:
            boolean r0 = r5 instanceof java.lang.Long
            goto L_0x0043
        L_0x0041:
            boolean r0 = r5 instanceof java.lang.Integer
        L_0x0043:
            if (r0 == 0) goto L_0x0046
        L_0x0045:
            return
        L_0x0046:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r4.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            r2 = 1
            com.google.android.gms.internal.measurement.zzmx r4 = r4.zzb()
            com.google.android.gms.internal.measurement.zzmy r4 = r4.zza()
            r1[r2] = r4
            r4 = 2
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r1[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzju.zzd(com.google.android.gms.internal.measurement.zzjt, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzju zzjuVar = new zzju();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzd2 = this.zza.zzd(i);
            zzjuVar.zzc(zzd2.getKey(), zzd2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zze()) {
            zzjuVar.zzc(entry.getKey(), entry.getValue());
        }
        zzjuVar.zzc = this.zzc;
        return zzjuVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzju)) {
            return false;
        }
        return this.zza.equals(((zzju) obj).zza);
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

    public final void zzc(T t, Object obj) {
        if (!t.zzc()) {
            zzd(t, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(t, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzkp) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    private zzju(boolean z) {
        zzb();
        zzb();
    }
}
