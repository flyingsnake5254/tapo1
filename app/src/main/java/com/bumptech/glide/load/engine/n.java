package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey.java */
/* loaded from: classes.dex */
class n implements c {

    /* renamed from: b  reason: collision with root package name */
    private final Object f1487b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1488c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1489d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f1490e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f1491f;
    private final c g;
    private final Map<Class<?>, i<?>> h;
    private final f i;
    private int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Object obj, c cVar, int i, int i2, Map<Class<?>, i<?>> map, Class<?> cls, Class<?> cls2, f fVar) {
        this.f1487b = com.bumptech.glide.util.i.d(obj);
        this.g = (c) com.bumptech.glide.util.i.e(cVar, "Signature must not be null");
        this.f1488c = i;
        this.f1489d = i2;
        this.h = (Map) com.bumptech.glide.util.i.d(map);
        this.f1490e = (Class) com.bumptech.glide.util.i.e(cls, "Resource class must not be null");
        this.f1491f = (Class) com.bumptech.glide.util.i.e(cls2, "Transcode class must not be null");
        this.i = (f) com.bumptech.glide.util.i.d(fVar);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f1487b.equals(nVar.f1487b) && this.g.equals(nVar.g) && this.f1489d == nVar.f1489d && this.f1488c == nVar.f1488c && this.h.equals(nVar.h) && this.f1490e.equals(nVar.f1490e) && this.f1491f.equals(nVar.f1491f) && this.i.equals(nVar.i);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.f1487b.hashCode();
            this.j = hashCode;
            int hashCode2 = (hashCode * 31) + this.g.hashCode();
            this.j = hashCode2;
            int i = (hashCode2 * 31) + this.f1488c;
            this.j = i;
            int i2 = (i * 31) + this.f1489d;
            this.j = i2;
            int hashCode3 = (i2 * 31) + this.h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f1490e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f1491f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f1487b + ", width=" + this.f1488c + ", height=" + this.f1489d + ", resourceClass=" + this.f1490e + ", transcodeClass=" + this.f1491f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }
}
