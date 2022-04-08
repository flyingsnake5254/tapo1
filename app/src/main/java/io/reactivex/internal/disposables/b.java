package io.reactivex.internal.disposables;

import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.internal.util.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ListCompositeDisposable.java */
/* loaded from: classes4.dex */
public final class b implements c, a {

    /* renamed from: c  reason: collision with root package name */
    List<c> f15747c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f15748d;

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
        io.reactivex.h0.a.b.e(cVar, "d is null");
        if (!this.f15748d) {
            synchronized (this) {
                if (!this.f15748d) {
                    List list = this.f15747c;
                    if (list == null) {
                        list = new LinkedList();
                        this.f15747c = list;
                    }
                    list.add(cVar);
                    return true;
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean c(c cVar) {
        io.reactivex.h0.a.b.e(cVar, "Disposable item is null");
        if (this.f15748d) {
            return false;
        }
        synchronized (this) {
            if (this.f15748d) {
                return false;
            }
            List<c> list = this.f15747c;
            if (list != null && list.remove(cVar)) {
                return true;
            }
            return false;
        }
    }

    void d(List<c> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (c cVar : list) {
                try {
                    cVar.dispose();
                } catch (Throwable th) {
                    a.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
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

    @Override // io.reactivex.e0.c
    public void dispose() {
        if (!this.f15748d) {
            synchronized (this) {
                if (!this.f15748d) {
                    this.f15748d = true;
                    List<c> list = this.f15747c;
                    this.f15747c = null;
                    d(list);
                }
            }
        }
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return this.f15748d;
    }
}
