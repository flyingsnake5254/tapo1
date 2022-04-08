package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final class zzhh implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzhf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhh(zzhf zzhfVar) {
        zzfc zzfcVar;
        this.zzb = zzhfVar;
        zzfcVar = zzhfVar.zza;
        this.zza = zzfcVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
