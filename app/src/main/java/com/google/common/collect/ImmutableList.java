package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final k3<Object> EMPTY_ITR = new b(i2.f4481c, 0);

    /* loaded from: classes2.dex */
    public static final class a<E> extends ImmutableCollection.a<E> {
        public a() {
            this(4);
        }

        @CanIgnoreReturnValue
        /* renamed from: h */
        public a<E> a(E e2) {
            super.f(e2);
            return this;
        }

        @CanIgnoreReturnValue
        public a<E> i(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        public ImmutableList<E> j() {
            this.f4195c = true;
            return ImmutableList.asImmutableList(this.a, this.f4194b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i) {
            super(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b<E> extends b<E> {

        /* renamed from: f  reason: collision with root package name */
        private final ImmutableList<E> f4196f;

        b(ImmutableList<E> immutableList, int i) {
            super(immutableList.size(), i);
            this.f4196f = immutableList;
        }

        @Override // com.google.common.collect.b
        protected E a(int i) {
            return this.f4196f.get(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c<E> extends ImmutableList<E> {

        /* renamed from: c  reason: collision with root package name */
        private final transient ImmutableList<E> f4197c;

        c(ImmutableList<E> immutableList) {
            this.f4197c = immutableList;
        }

        private int a(int i) {
            return (size() - 1) - i;
        }

        private int b(int i) {
            return size() - i;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return this.f4197c.contains(obj);
        }

        @Override // java.util.List
        public E get(int i) {
            n.m(i, size());
            return this.f4197c.get(a(i));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@NullableDecl Object obj) {
            int lastIndexOf = this.f4197c.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return a(lastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return this.f4197c.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ImmutableList.super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@NullableDecl Object obj) {
            int indexOf = this.f4197c.indexOf(obj);
            if (indexOf >= 0) {
                return a(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return ImmutableList.super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.f4197c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4197c.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return ImmutableList.super.listIterator(i);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i, int i2) {
            n.t(i, i2, size());
            return this.f4197c.subList(b(i2), b(i)).reverse();
        }
    }

    /* loaded from: classes2.dex */
    static class d implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        final Object[] f4198c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(Object[] objArr) {
            this.f4198c = objArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends ImmutableList<E> {

        /* renamed from: c  reason: collision with root package name */
        final transient int f4199c;

        /* renamed from: d  reason: collision with root package name */
        final transient int f4200d;

        e(int i, int i2) {
            this.f4199c = i;
            this.f4200d = i2;
        }

        @Override // java.util.List
        public E get(int i) {
            n.m(i, this.f4200d);
            return ImmutableList.this.get(i + this.f4199c);
        }

        @Override // com.google.common.collect.ImmutableCollection
        Object[] internalArray() {
            return ImmutableList.this.internalArray();
        }

        @Override // com.google.common.collect.ImmutableCollection
        int internalArrayEnd() {
            return ImmutableList.this.internalArrayStart() + this.f4199c + this.f4200d;
        }

        @Override // com.google.common.collect.ImmutableCollection
        int internalArrayStart() {
            return ImmutableList.this.internalArrayStart() + this.f4199c;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ImmutableList.super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return ImmutableList.super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4200d;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return ImmutableList.super.listIterator(i);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i, int i2) {
            n.t(i, i2, this.f4200d);
            ImmutableList immutableList = ImmutableList.this;
            int i3 = this.f4199c;
            return immutableList.subList(i + i3, i2 + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    public static <E> a<E> builderWithExpectedSize(int i) {
        v.b(i, "expectedSize");
        return new a<>(i);
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(x1.b(objArr));
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        n.o(iterable);
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) i2.f4481c;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) j1.m(iterable, new Comparable[0]);
        x1.b(comparableArr);
        Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        return n1.c(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return n1.d(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return n1.f(this, obj);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        return size() <= 1 ? this : new c(this);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    ImmutableList<E> subListUnchecked(int i, int i2) {
        return new e(i, i2 - i);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new d(toArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i) {
        if (i == 0) {
            return of();
        }
        return new i2(objArr, i);
    }

    public static <E> ImmutableList<E> of(E e2) {
        return construct(e2);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public j3<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i, int i2) {
        n.t(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return of();
        }
        return subListUnchecked(i, i2);
    }

    public static <E> ImmutableList<E> of(E e2, E e3) {
        return construct(e2, e3);
    }

    @Override // java.util.List
    public k3<E> listIterator() {
        return listIterator(0);
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4) {
        return construct(e2, e3, e4);
    }

    @Override // java.util.List
    public k3<E> listIterator(int i) {
        n.r(i, size());
        if (isEmpty()) {
            return (k3<E>) EMPTY_ITR;
        }
        return new b(this, i);
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return construct(collection.toArray());
        }
        ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
        return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5) {
        return construct(e2, e3, e4, e5);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        n.o(comparator);
        Object[] l = j1.l(iterable);
        x1.b(l);
        Arrays.sort(l, comparator);
        return asImmutableList(l);
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6) {
        return construct(e2, e3, e4, e5, e6);
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7) {
        return construct(e2, e3, e4, e5, e6, e7);
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return construct(e2, e3, e4, e5, e6, e7, e8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return of(next);
        }
        return new a().a(next).i(it).j();
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return construct(e2, e3, e4, e5, e6, e7, e8, e9);
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return construct(e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        return construct(e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
    }

    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12) {
        return construct(e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E... eArr) {
        n.e(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        objArr[6] = e8;
        objArr[7] = e9;
        objArr[8] = e10;
        objArr[9] = e11;
        objArr[10] = e12;
        objArr[11] = e13;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return construct(objArr);
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        if (eArr.length == 0) {
            return of();
        }
        return construct((Object[]) eArr.clone());
    }
}
