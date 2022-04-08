package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class j implements RequestCoordinator, d {
    @Nullable
    private final RequestCoordinator a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f1733b;

    /* renamed from: c  reason: collision with root package name */
    private volatile d f1734c;

    /* renamed from: d  reason: collision with root package name */
    private volatile d f1735d;
    @GuardedBy("requestLock")

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f1736e;
    @GuardedBy("requestLock")

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f1737f;
    @GuardedBy("requestLock")
    private boolean g;

    public j(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f1736e = requestState;
        this.f1737f = requestState;
        this.f1733b = obj;
        this.a = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean i() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.h(this);
    }

    @GuardedBy("requestLock")
    private boolean j() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    @GuardedBy("requestLock")
    private boolean k() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.d
    public boolean a() {
        boolean z;
        synchronized (this.f1733b) {
            if (!this.f1735d.a() && !this.f1734c.a()) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(d dVar) {
        boolean z;
        synchronized (this.f1733b) {
            z = j() && dVar.equals(this.f1734c) && !a();
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public void begin() {
        synchronized (this.f1733b) {
            this.g = true;
            if (this.f1736e != RequestCoordinator.RequestState.SUCCESS) {
                RequestCoordinator.RequestState requestState = this.f1737f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f1737f = requestState2;
                    this.f1735d.begin();
                }
            }
            if (this.g) {
                RequestCoordinator.RequestState requestState3 = this.f1736e;
                RequestCoordinator.RequestState requestState4 = RequestCoordinator.RequestState.RUNNING;
                if (requestState3 != requestState4) {
                    this.f1736e = requestState4;
                    this.f1734c.begin();
                }
            }
            this.g = false;
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(d dVar) {
        boolean z;
        synchronized (this.f1733b) {
            z = k() && (dVar.equals(this.f1734c) || this.f1736e != RequestCoordinator.RequestState.SUCCESS);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public void clear() {
        synchronized (this.f1733b) {
            this.g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f1736e = requestState;
            this.f1737f = requestState;
            this.f1735d.clear();
            this.f1734c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void d(d dVar) {
        synchronized (this.f1733b) {
            if (!dVar.equals(this.f1734c)) {
                this.f1737f = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.f1736e = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.a;
            if (requestCoordinator != null) {
                requestCoordinator.d(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean e() {
        boolean z;
        synchronized (this.f1733b) {
            z = this.f1736e == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void f(d dVar) {
        synchronized (this.f1733b) {
            if (dVar.equals(this.f1735d)) {
                this.f1737f = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.f1736e = RequestCoordinator.RequestState.SUCCESS;
            RequestCoordinator requestCoordinator = this.a;
            if (requestCoordinator != null) {
                requestCoordinator.f(this);
            }
            if (!this.f1737f.isComplete()) {
                this.f1735d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean g(d dVar) {
        if (!(dVar instanceof j)) {
            return false;
        }
        j jVar = (j) dVar;
        if (this.f1734c == null) {
            if (jVar.f1734c != null) {
                return false;
            }
        } else if (!this.f1734c.g(jVar.f1734c)) {
            return false;
        }
        if (this.f1735d == null) {
            if (jVar.f1735d != null) {
                return false;
            }
        } else if (!this.f1735d.g(jVar.f1735d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f1733b) {
            RequestCoordinator requestCoordinator = this.a;
            root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean h(d dVar) {
        boolean z;
        synchronized (this.f1733b) {
            z = i() && dVar.equals(this.f1734c) && this.f1736e != RequestCoordinator.RequestState.PAUSED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public boolean isComplete() {
        boolean z;
        synchronized (this.f1733b) {
            z = this.f1736e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f1733b) {
            z = this.f1736e == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    public void l(d dVar, d dVar2) {
        this.f1734c = dVar;
        this.f1735d = dVar2;
    }

    @Override // com.bumptech.glide.request.d
    public void pause() {
        synchronized (this.f1733b) {
            if (!this.f1737f.isComplete()) {
                this.f1737f = RequestCoordinator.RequestState.PAUSED;
                this.f1735d.pause();
            }
            if (!this.f1736e.isComplete()) {
                this.f1736e = RequestCoordinator.RequestState.PAUSED;
                this.f1734c.pause();
            }
        }
    }
}
