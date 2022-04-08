package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Multiset.java */
/* loaded from: classes2.dex */
public interface u1<E> extends Collection<E> {

    /* compiled from: Multiset.java */
    /* loaded from: classes2.dex */
    public interface a<E> {
        E a();

        int getCount();

        String toString();
    }

    @CanIgnoreReturnValue
    int add(@NullableDecl E e2, int i);

    @Override // java.util.Collection, com.google.common.collect.u1
    boolean contains(@NullableDecl Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(@NullableDecl @CompatibleWith("E") Object obj);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    @Override // com.google.common.collect.u1
    boolean equals(@NullableDecl Object obj);

    @Override // com.google.common.collect.u1
    int hashCode();

    @CanIgnoreReturnValue
    int remove(@NullableDecl @CompatibleWith("E") Object obj, int i);

    @Override // java.util.Collection, com.google.common.collect.u1
    @CanIgnoreReturnValue
    boolean remove(@NullableDecl Object obj);

    @CanIgnoreReturnValue
    int setCount(E e2, int i);

    @CanIgnoreReturnValue
    boolean setCount(E e2, int i, int i2);

    @Override // java.util.Collection, com.google.common.collect.u1
    int size();
}
