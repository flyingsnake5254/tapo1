package com.google.mlkit.vision.barcode;

import androidx.annotation.Nullable;
import com.google.android.libraries.barhopper.Barcode;
import com.google.mlkit.vision.barcode.internal.h;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes2.dex */
final class f implements h {
    private final Barcode a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Barcode barcode) {
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
