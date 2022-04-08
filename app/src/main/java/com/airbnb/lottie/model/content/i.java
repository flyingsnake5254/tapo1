package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.i.a;
import com.airbnb.lottie.model.i.d;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.g;

/* compiled from: ShapeFill.java */
/* loaded from: classes.dex */
public class i implements b {
    private final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f1004b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1005c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final a f1006d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final d f1007e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1008f;

    public i(String str, boolean z, Path.FillType fillType, @Nullable a aVar, @Nullable d dVar, boolean z2) {
        this.f1005c = str;
        this.a = z;
        this.f1004b = fillType;
        this.f1006d = aVar;
        this.f1007e = dVar;
        this.f1008f = z2;
    }

    @Override // com.airbnb.lottie.model.content.b
    public c a(f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new g(fVar, aVar, this);
    }

    @Nullable
    public a b() {
        return this.f1006d;
    }

    public Path.FillType c() {
        return this.f1004b;
    }

    public String d() {
        return this.f1005c;
    }

    @Nullable
    public d e() {
        return this.f1007e;
    }

    public boolean f() {
        return this.f1008f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }
}
