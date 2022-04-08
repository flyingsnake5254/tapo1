package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComparatorOrdering.java */
/* loaded from: classes2.dex */
public final class b0<T> extends a2<T> implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    final Comparator<T> f4370c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(Comparator<T> comparator) {
        this.f4370c = (Comparator) n.o(comparator);
    }

    @Override // com.google.common.collect.a2, java.util.Comparator
    public int compare(T t, T t2) {
        return this.f4370c.compare(t, t2);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0) {
            return this.f4370c.equals(((b0) obj).f4370c);
        }
        return false;
    }

    public int hashCode() {
        return this.f4370c.hashCode();
    }

    public String toString() {
        return this.f4370c.toString();
    }
}
