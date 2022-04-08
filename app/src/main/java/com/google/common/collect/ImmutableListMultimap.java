package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements m1<K, V> {
    private static final long serialVersionUID = 0;
    @RetainedWith
    @LazyInit
    private transient ImmutableListMultimap<V, K> inverse;

    /* loaded from: classes2.dex */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        public ImmutableListMultimap<K, V> h() {
            return (ImmutableListMultimap) super.a();
        }

        @CanIgnoreReturnValue
        /* renamed from: i */
        public a<K, V> c(K k, V v) {
            super.c(k, v);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: j */
        public a<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            super.d(entry);
            return this;
        }

        @CanIgnoreReturnValue
        public a<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.e(iterable);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: l */
        public a<K, V> f(K k, Iterable<? extends V> iterable) {
            super.f(k, iterable);
            return this;
        }

        @CanIgnoreReturnValue
        public a<K, V> m(K k, V... vArr) {
            super.g(k, vArr);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i) {
        super(immutableMap, i);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(r1<? extends K, ? extends V> r1Var) {
        if (r1Var.isEmpty()) {
            return of();
        }
        if (r1Var instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) r1Var;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        return fromMapEntries(r1Var.asMap().entrySet(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @NullableDecl Comparator<? super V> comparator) {
        ImmutableList immutableList;
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i = 0;
        Iterator<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Collection collection2 = (Collection) entry.getValue();
            if (comparator == null) {
                immutableList = ImmutableList.copyOf(collection2);
            } else {
                immutableList = ImmutableList.sortedCopyOf(comparator, collection2);
            }
            if (!immutableList.isEmpty()) {
                bVar.c(key, immutableList);
                i += immutableList.size();
            }
        }
        return new ImmutableListMultimap<>(bVar.a(), i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        a builder = builder();
        j3 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.c(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> h = builder.h();
        h.inverse = this;
        return h;
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return k0.f4506c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.b builder = ImmutableMap.builder();
            int i = 0;
            for (int i2 = 0; i2 < readInt; i2++) {
                Object readObject = objectInputStream.readObject();
                int readInt2 = objectInputStream.readInt();
                if (readInt2 > 0) {
                    ImmutableList.a builder2 = ImmutableList.builder();
                    for (int i3 = 0; i3 < readInt2; i3++) {
                        builder2.a(objectInputStream.readObject());
                    }
                    builder.c(readObject, builder2.j());
                    i += readInt2;
                } else {
                    throw new InvalidObjectException("Invalid value count " + readInt2);
                }
            }
            try {
                ImmutableMultimap.e.a.b(this, builder.a());
                ImmutableMultimap.e.f4224b.a(this, i);
            } catch (IllegalArgumentException e2) {
                throw ((InvalidObjectException) new InvalidObjectException(e2.getMessage()).initCause(e2));
            }
        } else {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        r2.j(this, objectOutputStream);
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v) {
        a builder = builder();
        builder.c(k, v);
        return builder.h();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.inverse;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        ImmutableListMultimap<V, K> invert = invert();
        this.inverse = invert;
        return invert;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.r1
    public ImmutableList<V> get(@NullableDecl K k) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.r1
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableList<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.h
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableList<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2) {
        a builder = builder();
        builder.c(k, v);
        builder.c(k2, v2);
        return builder.h();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().k(iterable).h();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        a builder = builder();
        builder.c(k, v);
        builder.c(k2, v2);
        builder.c(k3, v3);
        return builder.h();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        a builder = builder();
        builder.c(k, v);
        builder.c(k2, v2);
        builder.c(k3, v3);
        builder.c(k4, v4);
        return builder.h();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        a builder = builder();
        builder.c(k, v);
        builder.c(k2, v2);
        builder.c(k3, v3);
        builder.c(k4, v4);
        builder.c(k5, v5);
        return builder.h();
    }
}
