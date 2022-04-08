package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzfi extends LruCache<String, zzc> {
    final /* synthetic */ zzfl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfi(zzfl zzflVar, int i) {
        super(20);
        this.zza = zzflVar;
    }

    @Override // androidx.collection.LruCache
    protected final /* bridge */ /* synthetic */ zzc create(String str) {
        String str2 = str;
        Preconditions.checkNotEmpty(str2);
        return zzfl.zzo(this.zza, str2);
    }
}
