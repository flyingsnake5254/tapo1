package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzih extends zzin {
    private final /* synthetic */ zzic zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzih(zzic zzicVar) {
        super(zzicVar, null);
        this.zza = zzicVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzin, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzie(this.zza, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzih(zzic zzicVar, zzif zzifVar) {
        this(zzicVar);
    }
}
