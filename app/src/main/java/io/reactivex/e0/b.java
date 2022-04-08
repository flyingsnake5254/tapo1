package io.reactivex.e0;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.a;
import io.reactivex.internal.util.e;
import io.reactivex.internal.util.h;
import java.util.ArrayList;

/* compiled from: CompositeDisposable.java */
/* loaded from: classes4.dex */
public final class b implements c, a {

    /* renamed from: c  reason: collision with root package name */
    h<c> f15630c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f15631d;

    @Override // io.reactivex.internal.disposables.a
    public boolean a(c cVar) {
        if (!c(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean b(c cVar) {
        io.reactivex.h0.a.b.e(cVar, "disposable is null");
        if (!this.f15631d) {
            synchronized (this) {
                if (!this.f15631d) {
                    h<c> hVar = this.f15630c;
                    if (hVar == null) {
                        hVar = new h<>();
                        this.f15630c = hVar;
                    }
                    hVar.a(cVar);
                    return true;
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean c(c cVar) {
        io.reactivex.h0.a.b.e(cVar, "disposables is null");
        if (this.f15631d) {
            return false;
        }
        synchronized (this) {
            if (this.f15631d) {
                return false;
            }
            h<c> hVar = this.f15630c;
            if (hVar != null && hVar.e(cVar)) {
                return true;
            }
            return false;
        }
    }

    public void d() {
        if (!this.f15631d) {
            synchronized (this) {
                if (!this.f15631d) {
                    h<c> hVar = this.f15630c;
                    this.f15630c = null;
                    e(hVar);
                }
            }
        }
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        if (!this.f15631d) {
            synchronized (this) {
                if (!this.f15631d) {
                    this.f15631d = true;
                    h<c> hVar = this.f15630c;
                    this.f15630c = null;
                    e(hVar);
                }
            }
        }
    }

    void e(h<c> hVar) {
        Object[] b2;
        if (hVar != null) {
            ArrayList arrayList = null;
            for (Object obj : hVar.b()) {
                if (obj instanceof c) {
                    try {
                        ((c) obj).dispose();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw e.e((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }

    public int f() {
        int i = 0;
        if (this.f15631d) {
            return 0;
        }
        synchronized (this) {
            if (this.f15631d) {
                return 0;
            }
            h<c> hVar = this.f15630c;
            if (hVar != null) {
                i = hVar.g();
            }
            return i;
        }
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return this.f15631d;
    }
}
