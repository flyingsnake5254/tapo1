package com.airbnb.lottie.s.b;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.s.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public class s implements c, a.b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1105b;

    /* renamed from: c  reason: collision with root package name */
    private final List<a.b> f1106c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final ShapeTrimPath.Type f1107d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, Float> f1108e;

    /* renamed from: f  reason: collision with root package name */
    private final a<?, Float> f1109f;
    private final a<?, Float> g;

    public s(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.a = shapeTrimPath.c();
        this.f1105b = shapeTrimPath.g();
        this.f1107d = shapeTrimPath.f();
        a<Float, Float> a = shapeTrimPath.e().a();
        this.f1108e = a;
        a<Float, Float> a2 = shapeTrimPath.b().a();
        this.f1109f = a2;
        a<Float, Float> a3 = shapeTrimPath.d().a();
        this.g = a3;
        aVar.i(a);
        aVar.i(a2);
        aVar.i(a3);
        a.a(this);
        a2.a(this);
        a3.a(this);
    }

    @Override // com.airbnb.lottie.s.c.a.b
    public void a() {
        for (int i = 0; i < this.f1106c.size(); i++) {
            this.f1106c.get(i).a();
        }
    }

    @Override // com.airbnb.lottie.s.b.c
    public void b(List<c> list, List<c> list2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(a.b bVar) {
        this.f1106c.add(bVar);
    }

    public a<?, Float> d() {
        return this.f1109f;
    }

    public a<?, Float> f() {
        return this.g;
    }

    public a<?, Float> h() {
        return this.f1108e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type i() {
        return this.f1107d;
    }

    public boolean j() {
        return this.f1105b;
    }
}
