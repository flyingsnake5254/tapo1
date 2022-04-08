package io.reactivex.h0.c.a;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: CompletableError.java */
/* loaded from: classes4.dex */
public final class e extends a {

    /* renamed from: c  reason: collision with root package name */
    final Throwable f15662c;

    public e(Throwable th) {
        this.f15662c = th;
    }

    @Override // io.reactivex.a
    protected void B(c cVar) {
        EmptyDisposable.error(this.f15662c, cVar);
    }
}
