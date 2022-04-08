package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.util.e;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SourceGenerator.java */
/* loaded from: classes.dex */
public class y implements f, f.a {

    /* renamed from: c  reason: collision with root package name */
    private final g<?> f1511c;

    /* renamed from: d  reason: collision with root package name */
    private final f.a f1512d;

    /* renamed from: f  reason: collision with root package name */
    private int f1513f;
    private c q;
    private Object x;
    private volatile n.a<?> y;
    private d z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SourceGenerator.java */
    /* loaded from: classes.dex */
    public class a implements d.a<Object> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n.a f1514c;

        a(n.a aVar) {
            this.f1514c = aVar;
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(@NonNull Exception exc) {
            if (y.this.g(this.f1514c)) {
                y.this.i(this.f1514c, exc);
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void f(@Nullable Object obj) {
            if (y.this.g(this.f1514c)) {
                y.this.h(this.f1514c, obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(g<?> gVar, f.a aVar) {
        this.f1511c = gVar;
        this.f1512d = aVar;
    }

    /* JADX WARN: Finally extract failed */
    private void d(Object obj) {
        long b2 = e.b();
        try {
            com.bumptech.glide.load.a<X> p = this.f1511c.p(obj);
            e eVar = new e(p, obj, this.f1511c.k());
            this.z = new d(this.y.a, this.f1511c.o());
            this.f1511c.d().a(this.z, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.z + ", data: " + obj + ", encoder: " + p + ", duration: " + e.a(b2));
            }
            this.y.f1575c.b();
            this.q = new c(Collections.singletonList(this.y.a), this.f1511c, this);
        } catch (Throwable th) {
            this.y.f1575c.b();
            throw th;
        }
    }

    private boolean f() {
        return this.f1513f < this.f1511c.g().size();
    }

    private void j(n.a<?> aVar) {
        this.y.f1575c.e(this.f1511c.l(), new a(aVar));
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(c cVar, Exception exc, d<?> dVar, DataSource dataSource) {
        this.f1512d.a(cVar, exc, dVar, this.y.f1575c.d());
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        Object obj = this.x;
        if (obj != null) {
            this.x = null;
            d(obj);
        }
        c cVar = this.q;
        if (cVar != null && cVar.b()) {
            return true;
        }
        this.q = null;
        this.y = null;
        boolean z = false;
        while (!z && f()) {
            List<n.a<?>> g = this.f1511c.g();
            int i = this.f1513f;
            this.f1513f = i + 1;
            this.y = g.get(i);
            if (this.y != null && (this.f1511c.e().c(this.y.f1575c.d()) || this.f1511c.t(this.y.f1575c.a()))) {
                j(this.y);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.y;
        if (aVar != null) {
            aVar.f1575c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void e(c cVar, Object obj, d<?> dVar, DataSource dataSource, c cVar2) {
        this.f1512d.e(cVar, obj, dVar, this.y.f1575c.d(), cVar);
    }

    boolean g(n.a<?> aVar) {
        n.a<?> aVar2 = this.y;
        return aVar2 != null && aVar2 == aVar;
    }

    void h(n.a<?> aVar, Object obj) {
        j e2 = this.f1511c.e();
        if (obj == null || !e2.c(aVar.f1575c.d())) {
            f.a aVar2 = this.f1512d;
            c cVar = aVar.a;
            d<?> dVar = aVar.f1575c;
            aVar2.e(cVar, obj, dVar, dVar.d(), this.z);
            return;
        }
        this.x = obj;
        this.f1512d.c();
    }

    void i(n.a<?> aVar, @NonNull Exception exc) {
        f.a aVar2 = this.f1512d;
        d dVar = this.z;
        d<?> dVar2 = aVar.f1575c;
        aVar2.a(dVar, exc, dVar2, dVar2.d());
    }
}
