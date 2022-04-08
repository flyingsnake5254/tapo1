package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.c;
import com.bumptech.glide.f;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.a0.i;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.z.j;
import com.bumptech.glide.manager.p;
import com.bumptech.glide.request.f;
import com.bumptech.glide.request.g;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    private k f1286c;

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.load.engine.z.e f1287d;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.load.engine.z.b f1288e;

    /* renamed from: f  reason: collision with root package name */
    private h f1289f;
    private com.bumptech.glide.load.engine.b0.a g;
    private com.bumptech.glide.load.engine.b0.a h;
    private a.AbstractC0046a i;
    private i j;
    private com.bumptech.glide.manager.d k;
    @Nullable
    private p.b n;
    private com.bumptech.glide.load.engine.b0.a o;
    private boolean p;
    @Nullable
    private List<f<Object>> q;
    private final Map<Class<?>, j<?, ?>> a = new ArrayMap();

    /* renamed from: b  reason: collision with root package name */
    private final f.a f1285b = new f.a();
    private int l = 4;
    private c.a m = new a();

    /* compiled from: GlideBuilder.java */
    /* loaded from: classes.dex */
    class a implements c.a {
        a() {
        }

        @Override // com.bumptech.glide.c.a
        @NonNull
        public g build() {
            return new g();
        }
    }

    /* compiled from: GlideBuilder.java */
    /* loaded from: classes.dex */
    class b implements c.a {
        final /* synthetic */ g a;

        b(g gVar) {
            this.a = gVar;
        }

        @Override // com.bumptech.glide.c.a
        @NonNull
        public g build() {
            g gVar = this.a;
            return gVar != null ? gVar : new g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GlideBuilder.java */
    /* loaded from: classes.dex */
    public static final class c {
        c() {
        }
    }

    /* compiled from: GlideBuilder.java */
    /* renamed from: com.bumptech.glide.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0040d {
    }

    /* compiled from: GlideBuilder.java */
    /* loaded from: classes.dex */
    public static final class e {
        private e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public c a(@NonNull Context context) {
        if (this.g == null) {
            this.g = com.bumptech.glide.load.engine.b0.a.g();
        }
        if (this.h == null) {
            this.h = com.bumptech.glide.load.engine.b0.a.e();
        }
        if (this.o == null) {
            this.o = com.bumptech.glide.load.engine.b0.a.c();
        }
        if (this.j == null) {
            this.j = new i.a(context).a();
        }
        if (this.k == null) {
            this.k = new com.bumptech.glide.manager.f();
        }
        if (this.f1287d == null) {
            int b2 = this.j.b();
            if (b2 > 0) {
                this.f1287d = new com.bumptech.glide.load.engine.z.k(b2);
            } else {
                this.f1287d = new com.bumptech.glide.load.engine.z.f();
            }
        }
        if (this.f1288e == null) {
            this.f1288e = new j(this.j.a());
        }
        if (this.f1289f == null) {
            this.f1289f = new com.bumptech.glide.load.engine.a0.g(this.j.d());
        }
        if (this.i == null) {
            this.i = new com.bumptech.glide.load.engine.a0.f(context);
        }
        if (this.f1286c == null) {
            this.f1286c = new k(this.f1289f, this.i, this.h, this.g, com.bumptech.glide.load.engine.b0.a.h(), this.o, this.p);
        }
        List<com.bumptech.glide.request.f<Object>> list = this.q;
        if (list == null) {
            this.q = Collections.emptyList();
        } else {
            this.q = Collections.unmodifiableList(list);
        }
        f b3 = this.f1285b.b();
        return new c(context, this.f1286c, this.f1289f, this.f1287d, this.f1288e, new p(this.n, b3), this.k, this.l, this.m, this.a, this.q, b3);
    }

    @NonNull
    public d b(@NonNull c.a aVar) {
        this.m = (c.a) com.bumptech.glide.util.i.d(aVar);
        return this;
    }

    @NonNull
    public d c(@Nullable g gVar) {
        return b(new b(gVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(@Nullable p.b bVar) {
        this.n = bVar;
    }
}
