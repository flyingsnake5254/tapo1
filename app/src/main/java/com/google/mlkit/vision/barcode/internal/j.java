package com.google.mlkit.vision.barcode.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes2.dex */
public final class j implements h {
    private final Barcode a;

    public j(Barcode barcode) {
        this.a = barcode;
    }

    @Override // com.google.mlkit.vision.barcode.internal.h
    @Nullable
    public final String zzc() {
        return this.a.rawValue;
    }

    @Override // com.google.mlkit.vision.barcode.internal.h
    public final int zzf() {
        return this.a.format;
    }

    @Override // com.google.mlkit.vision.barcode.internal.h
    public final int zzg() {
        return this.a.valueFormat;
    }
}
