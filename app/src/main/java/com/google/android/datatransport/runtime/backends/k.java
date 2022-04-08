package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.h.u.a.b;
import d.a.a;

/* compiled from: MetadataBackendRegistry_Factory.java */
/* loaded from: classes.dex */
public final class k implements b<j> {
    private final a<Context> a;

    /* renamed from: b  reason: collision with root package name */
    private final a<h> f1958b;

    public k(a<Context> aVar, a<h> aVar2) {
        this.a = aVar;
        this.f1958b = aVar2;
    }

    public static k a(a<Context> aVar, a<h> aVar2) {
        return new k(aVar, aVar2);
    }

    public static j c(Context context, Object obj) {
        return new j(context, (h) obj);
    }

    /* renamed from: b */
    public j get() {
        return c(this.a.get(), this.f1958b.get());
    }
}
