package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.l;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.p;

/* compiled from: Repeater.java */
/* loaded from: classes.dex */
public class g implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final b f998b;

    /* renamed from: c  reason: collision with root package name */
    private final b f999c;

    /* renamed from: d  reason: collision with root package name */
    private final l f1000d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1001e;

    public g(String str, b bVar, b bVar2, l lVar, boolean z) {
        this.a = str;
        this.f998b = bVar;
        this.f999c = bVar2;
        this.f1000d = lVar;
        this.f1001e = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public c a(f fVar, a aVar) {
        return new p(fVar, aVar, this);
    }

    public b b() {
        return this.f998b;
    }

    public String c() {
        return this.a;
    }

    public b d() {
        return this.f999c;
    }

    public l e() {
        return this.f1000d;
    }

    public boolean f() {
        return this.f1001e;
    }
}
