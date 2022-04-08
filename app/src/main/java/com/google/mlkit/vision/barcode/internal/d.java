package com.google.mlkit.vision.barcode.internal;

import com.google.mlkit.common.sdkinternal.e;
import com.google.mlkit.common.sdkinternal.j;
import com.google.mlkit.vision.barcode.b;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes2.dex */
public class d extends e<b, g> {
    private final j a;

    public d(j jVar) {
        this.a = jVar;
    }

    @Override // com.google.mlkit.common.sdkinternal.e
    protected /* synthetic */ g create(b bVar) {
        return new g(this.a, bVar);
    }
}
