package com.google.firebase.datatransport;

import android.content.Context;
import com.google.android.datatransport.h.r;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements ComponentFactory {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return r.f((Context) componentContainer.get(Context.class));
    }
}
