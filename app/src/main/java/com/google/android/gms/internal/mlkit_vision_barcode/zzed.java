package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzeg;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public class zzed implements zzeg.zzc {
    private final ClearcutLogger zzc;
    private static final GmsLogger zzb = new GmsLogger("ClearcutTransport", "");
    public static final Component<?> zza = Component.builder(zzed.class).add(Dependency.required(Context.class)).factory(zzef.zza).build();

    public zzed(Context context) {
        this.zzc = ClearcutLogger.anonymousLogger(context, "FIREBASE_ML_SDK");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeg.zzc
    public final void zza(zzbl.zzad zzadVar) {
        GmsLogger gmsLogger = zzb;
        String valueOf = String.valueOf(zzadVar);
        StringBuilder sb = new StringBuilder(valueOf.length() + 30);
        sb.append("Logging FirebaseMlSdkLogEvent ");
        sb.append(valueOf);
        gmsLogger.d("ClearcutTransport", sb.toString());
        try {
            this.zzc.newEvent(zzadVar.zzf()).log();
        } catch (SecurityException e2) {
            zzb.e("ClearcutTransport", "Exception thrown from the logging side", e2);
        }
    }
}
