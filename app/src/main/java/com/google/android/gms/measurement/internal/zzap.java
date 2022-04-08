package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
final class zzap implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzaq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzap(zzaq zzaqVar) {
        Bundle bundle;
        this.zzb = zzaqVar;
        bundle = zzaqVar.zza;
        this.zza = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    /* renamed from: zza */
    public final String next() {
        return this.zza.next();
    }
}