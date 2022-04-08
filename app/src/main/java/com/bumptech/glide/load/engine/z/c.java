package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.j;

/* compiled from: AttributeStrategy.java */
/* loaded from: classes.dex */
class c implements l {
    private final b a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Bitmap> f1516b = new h<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a implements m {
        private final b a;

        /* renamed from: b  reason: collision with root package name */
        private int f1517b;

        /* renamed from: c  reason: collision with root package name */
        private int f1518c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f1519d;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.a.c(this);
        }

        public void b(int i, int i2, Bitmap.Config config) {
            this.f1517b = i;
            this.f1518c = i2;
            this.f1519d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1517b == aVar.f1517b && this.f1518c == aVar.f1518c && this.f1519d == aVar.f1519d;
        }

        public int hashCode() {
            int i = ((this.f1517b * 31) + this.f1518c) * 31;
            Bitmap.Config config = this.f1519d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.f(this.f1517b, this.f1518c, this.f1519d);
        }
    }

    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    static class b extends d<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        a e(int i, int i2, Bitmap.Config config) {
            a b2 = b();
            b2.b(i, i2, config);
            return b2;
        }
    }

    static String f(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    private static String g(Bitmap bitmap) {
        return f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String a(Bitmap bitmap) {
        return g(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String b(int i, int i2, Bitmap.Config config) {
        return f(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public void c(Bitmap bitmap) {
        this.f1516b.d(this.a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return this.f1516b.a(this.a.e(i, i2, config));
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public int e(Bitmap bitmap) {
        return j.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap removeLast() {
        return this.f1516b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f1516b;
    }
}
