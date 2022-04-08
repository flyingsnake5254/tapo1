package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.a.b;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class d implements ComponentFactory {
    static final ComponentFactory a = new d();

    private d() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new b(componentContainer.setOf(b.a.class));
    }
}
