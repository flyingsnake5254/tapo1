package com.google.android.gms.internal.measurement;

import com.github.mikephil.charting.utils.Utils;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzan implements zzap {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof zzan;
    }

    public final int hashCode() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzbK(String str, zzg zzgVar, List<zzap> list) {
        throw new IllegalStateException(String.format("null has no function %s", str));
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzc() {
        return "null";
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzd() {
        return Double.valueOf((double) Utils.DOUBLE_EPSILON);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zze() {
        return Boolean.FALSE;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator<zzap> zzf() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzt() {
        return zzap.zzg;
    }
}
