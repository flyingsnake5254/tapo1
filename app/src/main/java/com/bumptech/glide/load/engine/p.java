package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.util.i;

/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
class p<Z> implements u<Z> {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1492c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1493d;

    /* renamed from: f  reason: collision with root package name */
    private final u<Z> f1494f;
    private final a q;
    private final c x;
    private int y;
    private boolean z;

    /* compiled from: EngineResource.java */
    /* loaded from: classes.dex */
    interface a {
        void d(c cVar, p<?> pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(u<Z> uVar, boolean z, boolean z2, c cVar, a aVar) {
        this.f1494f = (u) i.d(uVar);
        this.f1492c = z;
        this.f1493d = z2;
        this.x = cVar;
        this.q = (a) i.d(aVar);
    }

    @Override // com.bumptech.glide.load.engine.u
    public int a() {
        return this.f1494f.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        if (!this.z) {
            this.y++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public synchronized void c() {
        if (this.y > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.z) {
            this.z = true;
            if (this.f1493d) {
                this.f1494f.c();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u<Z> d() {
        return this.f1494f;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<Z> e() {
        return this.f1494f.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f1492c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        boolean z;
        synchronized (this) {
            int i = this.y;
            if (i > 0) {
                z = true;
                int i2 = i - 1;
                this.y = i2;
                if (i2 != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.q.d(this.x, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Z get() {
        return this.f1494f.get();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f1492c + ", listener=" + this.q + ", key=" + this.x + ", acquired=" + this.y + ", isRecycled=" + this.z + ", resource=" + this.f1494f + '}';
    }
}
