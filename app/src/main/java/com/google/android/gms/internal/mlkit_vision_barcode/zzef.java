package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzef implements ComponentFactory {
    static final ComponentFactory zza = new zzef();

    private zzef() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new zzed((Context) componentContainer.get(Context.class));
    }
}
