package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.k;
import com.google.common.base.n;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByFunctionOrdering.java */
/* loaded from: classes2.dex */
public final class u<F, T> extends a2<F> implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    final h<F, ? extends T> f4618c;

    /* renamed from: d  reason: collision with root package name */
    final a2<T> f4619d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(h<F, ? extends T> hVar, a2<T> a2Var) {
        this.f4618c = (h) n.o(hVar);
        this.f4619d = (a2) n.o(a2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a2, java.util.Comparator
    public int compare(F f2, F f3) {
        return this.f4619d.compare(this.f4618c.apply(f2), this.f4618c.apply(f3));
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f4618c.equals(uVar.f4618c) && this.f4619d.equals(uVar.f4619d);
    }

    public int hashCode() {
        return k.b(this.f4618c, this.f4619d);
    }

    public String toString() {
        return this.f4619d + ".onResultOf(" + this.f4618c + ")";
    }
}
