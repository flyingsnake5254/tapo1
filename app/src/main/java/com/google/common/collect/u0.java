package com.google.common.collect;

import com.google.common.base.n;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ForwardingSet.java */
/* loaded from: classes2.dex */
public abstract class u0<E> extends n0<E> implements Set<E> {
    @Override // com.google.common.collect.n0, com.google.common.collect.s0
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.n0, com.google.common.collect.s0
    protected abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // com.google.common.collect.n0, com.google.common.collect.s0
    protected abstract Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    protected boolean standardEquals(@NullableDecl Object obj) {
        return u2.a(this, obj);
    }

    protected int standardHashCode() {
        return u2.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.n0
    public boolean standardRemoveAll(Collection<?> collection) {
        return u2.g(this, (Collection) n.o(collection));
    }
}
