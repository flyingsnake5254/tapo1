package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.load.engine.a0.a;
import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class d implements a.AbstractC0046a {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1393b;

    /* compiled from: DiskLruCacheFactory.java */
    /* loaded from: classes.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        this.a = j;
        this.f1393b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.a0.a.AbstractC0046a
    public a build() {
        File a2 = this.f1393b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.isDirectory() || a2.mkdirs()) {
            return e.c(a2, this.a);
        }
        return null;
    }
}
