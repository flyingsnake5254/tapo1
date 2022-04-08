package com.google.mlkit.vision.barcode.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzap;
import com.google.android.gms.internal.mlkit_vision_barcode.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode.zzee;
import com.google.android.gms.internal.mlkit_vision_barcode.zzeg;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.d;
import com.google.mlkit.common.sdkinternal.j;
import com.google.mlkit.vision.barcode.internal.BarcodeScannerImpl;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class BarcodeRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return zzap.zza(zzee.zza, zzed.zza, zzeg.zza, Component.builder(d.class).add(Dependency.required(j.class)).factory(b.a).build(), Component.builder(BarcodeScannerImpl.a.class).add(Dependency.required(zzeg.class)).add(Dependency.required(d.class)).add(Dependency.required(d.class)).factory(c.a).build());
    }
}
