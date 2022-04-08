package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.h.u.a.b;
import d.a.a;

/* compiled from: CreationContextFactory_Factory.java */
/* loaded from: classes.dex */
public final class i implements b<h> {
    private final a<Context> a;

    /* renamed from: b  reason: collision with root package name */
    private final a<com.google.android.datatransport.h.y.a> f1953b;

    /* renamed from: c  reason: collision with root package name */
    private final a<com.google.android.datatransport.h.y.a> f1954c;

    public i(a<Context> aVar, a<com.google.android.datatransport.h.y.a> aVar2, a<com.google.android.datatransport.h.y.a> aVar3) {
        this.a = aVar;
        this.f1953b = aVar2;
        this.f1954c = aVar3;
    }

    public static i a(a<Context> aVar, a<com.google.android.datatransport.h.y.a> aVar2, a<com.google.android.datatransport.h.y.a> aVar3) {
        return new i(aVar, aVar2, aVar3);
    }

    public static h c(Context context, com.google.android.datatransport.h.y.a aVar, com.google.android.datatransport.h.y.a aVar2) {
        return new h(context, aVar, aVar2);
    }

    /* renamed from: b */
    public h get() {
        return c(this.a.get(), this.f1953b.get(), this.f1954c.get());
    }
}
