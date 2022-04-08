package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;
    @RetainedWith
    @NullableDecl
    @LazyInit
    private transient ImmutableList<E> asList;

    /* loaded from: classes2.dex */
    public static class a<E> extends ImmutableCollection.a<E> {
        @NullableDecl

        /* renamed from: d  reason: collision with root package name */
        Object[] f4256d;

        /* renamed from: e  reason: collision with root package name */
        private int f4257e;

        public a() {
            super(4);
        }

        private void j(E e2) {
            int length = this.f4256d.length - 1;
            int hashCode = e2.hashCode();
            int c2 = y0.c(hashCode);
            while (true) {
                int i = c2 & length;
                Object[] objArr = this.f4256d;
                Object obj = objArr[i];
                if (obj == null) {
                    objArr[i] = e2;
                    this.f4257e += hashCode;
                    super.f(e2);
                    return;
                } else if (!obj.equals(e2)) {
                    c2 = i + 1;
                } else {
                    return;
                }
            }
        }

        @CanIgnoreReturnValue
        /* renamed from: h */
        public a<E> a(E e2) {
            n.o(e2);
            if (this.f4256d == null || ImmutableSet.chooseTableSize(this.f4194b) > this.f4256d.length) {
                this.f4256d = null;
                super.f(e2);
                return this;
            }
            j(e2);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public a<E> i(Iterator<? extends E> it) {
            n.o(it);
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public ImmutableSet<E> k() {
            ImmutableSet<E> immutableSet;
            int i = this.f4194b;
            if (i == 0) {
                return ImmutableSet.of();
            }
            if (i == 1) {
                return ImmutableSet.of(this.a[0]);
            }
            if (this.f4256d == null || ImmutableSet.chooseTableSize(i) != this.f4256d.length) {
                immutableSet = ImmutableSet.construct(this.f4194b, this.a);
                this.f4194b = immutableSet.size();
            } else {
                Object[] copyOf = ImmutableSet.shouldTrim(this.f4194b, this.a.length) ? Arrays.copyOf(this.a, this.f4194b) : this.a;
                int i2 = this.f4257e;
                Object[] objArr = this.f4256d;
                immutableSet = new l2<>(copyOf, i2, objArr, objArr.length - 1, this.f4194b);
            }
            this.f4195c = true;
            this.f4256d = null;
            return immutableSet;
        }

        a(int i) {
            super(i);
            this.f4256d = new Object[ImmutableSet.chooseTableSize(i)];
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        final Object[] f4258c;

        b(Object[] objArr) {
            this.f4258c = objArr;
        }
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    public static <E> a<E> builderWithExpectedSize(int i) {
        v.b(i, "expectedSize");
        return new a<>(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int chooseTableSize(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < CUTOFF) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * DESIRED_LOAD_FACTOR < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        n.e(z, "collection too large");
        return 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i, Object... objArr) {
        if (i == 0) {
            return of();
        }
        if (i == 1) {
            return of(objArr[0]);
        }
        int chooseTableSize = chooseTableSize(i);
        Object[] objArr2 = new Object[chooseTableSize];
        int i2 = chooseTableSize - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object a2 = x1.a(objArr[i5], i5);
            int hashCode = a2.hashCode();
            int c2 = y0.c(hashCode);
            while (true) {
                int i6 = c2 & i2;
                Object obj = objArr2[i6];
                if (obj == null) {
                    i4++;
                    objArr[i4] = a2;
                    objArr2[i6] = a2;
                    i3 += hashCode;
                    break;
                } else if (obj.equals(a2)) {
                    break;
                } else {
                    c2++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new v2(objArr[0], i3);
        }
        if (chooseTableSize(i4) < chooseTableSize / 2) {
            return construct(i4, objArr);
        }
        if (shouldTrim(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new l2(objArr, i3, objArr2, i2, i4);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return l2.f4532c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableSet) || !isHashCodeFast() || !((ImmutableSet) obj).isHashCodeFast() || hashCode() == obj.hashCode()) {
            return u2.a(this, obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return u2.b(this);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract j3<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new b(toArray());
    }

    public static <E> ImmutableSet<E> of(E e2) {
        return new v2(e2);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3) {
        return construct(2, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4) {
        return construct(3, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5) {
        return construct(4, e2, e3, e4, e5);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5, E e6) {
        return construct(5, e2, e3, e4, e5, e6);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        n.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return of(next);
        }
        return new a().a(next).i(it).k();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return construct(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
