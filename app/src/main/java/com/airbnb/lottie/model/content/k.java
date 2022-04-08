package com.airbnb.lottie.model.content;

import com.airbnb.lottie.f;
import com.airbnb.lottie.model.i.h;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.q;

/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class k implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1011b;

    /* renamed from: c  reason: collision with root package name */
    private final h f1012c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1013d;

    public k(String str, int i, h hVar, boolean z) {
        this.a = str;
        this.f1011b = i;
        this.f1012c = hVar;
        this.f1013d = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public c a(f fVar, a aVar) {
        return new q(fVar, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public h c() {
        return this.f1012c;
    }

    public boolean d() {
        return this.f1013d;
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.f1011b + '}';
    }
}
