package com.google.firebase.installations;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements ComponentFactory {
    public static final /* synthetic */ e a = new e();

    private /* synthetic */ e() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
    }
}
