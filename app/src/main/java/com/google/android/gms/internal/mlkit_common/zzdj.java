package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzaa;
import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzdj {
    public static zzaa.zzal.zza zza(ModelType modelType) {
        int i = zzdl.zza[modelType.ordinal()];
        if (i == 1) {
            return zzaa.zzal.zza.BASE_TRANSLATE;
        }
        if (i != 2) {
            return zzaa.zzal.zza.TYPE_UNKNOWN;
        }
        return zzaa.zzal.zza.AUTOML_IMAGE_LABELING;
    }
}
