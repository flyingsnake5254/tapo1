package com.airbnb.lottie.model.content;

import com.airbnb.lottie.f;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.s;

/* loaded from: classes.dex */
public class ShapeTrimPath implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f974b;

    /* renamed from: c  reason: collision with root package name */
    private final b f975c;

    /* renamed from: d  reason: collision with root package name */
    private final b f976d;

    /* renamed from: e  reason: collision with root package name */
    private final b f977e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f978f;

    /* loaded from: classes.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public ShapeTrimPath(String str, Type type, b bVar, b bVar2, b bVar3, boolean z) {
        this.a = str;
        this.f974b = type;
        this.f975c = bVar;
        this.f976d = bVar2;
        this.f977e = bVar3;
        this.f978f = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public c a(f fVar, a aVar) {
        return new s(aVar, this);
    }

    public b b() {
        return this.f976d;
    }

    public String c() {
        return this.a;
    }

    public b d() {
        return this.f977e;
    }

    public b e() {
        return this.f975c;
    }

    public Type f() {
        return this.f974b;
    }

    public boolean g() {
        return this.f978f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f975c + ", end: " + this.f976d + ", offset: " + this.f977e + "}";
    }
}
