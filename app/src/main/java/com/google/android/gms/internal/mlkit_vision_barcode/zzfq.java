package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzfq extends zzfr<zzga.zzf> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfr
    public final boolean zza(zzhk zzhkVar) {
        return zzhkVar instanceof zzga.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfr
    public final zzfs<zzga.zzf> zzb(Object obj) {
        zzga.zzc zzcVar = (zzga.zzc) obj;
        if (zzcVar.zzc.zzc()) {
            zzcVar.zzc = (zzfs) zzcVar.zzc.clone();
        }
        return zzcVar.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfr
    public final void zzc(Object obj) {
        zza(obj).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfr
    public final zzfs<zzga.zzf> zza(Object obj) {
        return ((zzga.zzc) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfr
    public final int zza(Map.Entry<?, ?> entry) {
        zzga.zzf zzfVar = (zzga.zzf) entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfr
    public final void zza(zzjn zzjnVar, Map.Entry<?, ?> entry) throws IOException {
        zzga.zzf zzfVar = (zzga.zzf) entry.getKey();
        throw new NoSuchMethodError();
    }
}
