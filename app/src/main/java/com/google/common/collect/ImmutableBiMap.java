package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements t<K, V> {

    /* loaded from: classes2.dex */
    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public a() {
        }

        /* renamed from: h */
        public ImmutableBiMap<K, V> a() {
            if (this.f4205c == 0) {
                return ImmutableBiMap.of();
            }
            g();
            this.f4206d = true;
            return new h2(this.f4204b, this.f4205c);
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
        /* renamed from: k */
        public a<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.e(iterable);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: l */
        public a<K, V> f(Map<? extends K, ? extends V> map) {
            super.f(map);
            return this;
        }

        a(int i) {
            super(i);
        }
    }

    /* loaded from: classes2.dex */
    private static class b extends ImmutableMap.e {
        b(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> a<K, V> builderWithExpectedSize(int i) {
        v.b(i, "expectedSize");
        return new a<>(i);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return h2.f4471c;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new b(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v) {
        v.a(k, v);
        return new h2(new Object[]{k, v}, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2) {
        v.a(k, v);
        v.a(k2, v2);
        return new h2(new Object[]{k, v, k2, v2}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4).e(iterable).a();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        v.a(k, v);
        v.a(k2, v2);
        v.a(k3, v3);
        return new h2(new Object[]{k, v, k2, v2, k3, v3}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        v.a(k, v);
        v.a(k2, v2);
        v.a(k3, v3);
        v.a(k4, v4);
        return new h2(new Object[]{k, v, k2, v2, k3, v3, k4, v4}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        v.a(k, v);
        v.a(k2, v2);
        v.a(k3, v3);
        v.a(k4, v4);
        v.a(k5, v5);
        return new h2(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5}, 5);
    }
}
