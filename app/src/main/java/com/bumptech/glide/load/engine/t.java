package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.k.a;
import com.bumptech.glide.util.k.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LockedResource.java */
/* loaded from: classes.dex */
public final class t<Z> implements u<Z>, a.f {

    /* renamed from: c  reason: collision with root package name */
    private static final Pools.Pool<t<?>> f1499c = com.bumptech.glide.util.k.a.d(20, new a());

    /* renamed from: d  reason: collision with root package name */
    private final c f1500d = c.a();

    /* renamed from: f  reason: collision with root package name */
    private u<Z> f1501f;
    private boolean q;
    private boolean x;

    /* compiled from: LockedResource.java */
    /* loaded from: classes.dex */
    class a implements a.d<t<?>> {
        a() {
        }

        /* renamed from: a */
        public t<?> c() {
            return new t<>();
        }
    }

    t() {
    }

    private void b(u<Z> uVar) {
        this.x = false;
        this.q = true;
        this.f1501f = uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <Z> t<Z> f(u<Z> uVar) {
        t<Z> tVar = (t) i.d(f1499c.acquire());
        tVar.b(uVar);
        return tVar;
    }

    private void g() {
        this.f1501f = null;
        f1499c.release(this);
    }

    @Override // com.bumptech.glide.load.engine.u
    public int a() {
        return this.f1501f.a();
    }

    @Override // com.bumptech.glide.load.engine.u
    public synchronized void c() {
        this.f1500d.c();
        this.x = true;
        if (!this.q) {
            this.f1501f.c();
            g();
        }
    }

    @Override // com.bumptech.glide.util.k.a.f
    @NonNull
    public c d() {
        return this.f1500d;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<Z> e() {
        return this.f1501f.e();
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Z get() {
        return this.f1501f.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void h() {
        this.f1500d.c();
        if (this.q) {
            this.q = false;
            if (this.x) {
                c();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }
}
