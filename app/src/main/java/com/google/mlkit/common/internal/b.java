package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.j;
import com.google.mlkit.common.sdkinternal.model.a;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class b implements ComponentFactory {
    static final ComponentFactory a = new b();

    private b() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new a((j) componentContainer.get(j.class));
    }
}
