package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.f;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable(containerOf = {"B"})
/* loaded from: classes2.dex */
public final class ImmutableClassToInstanceMap<B> extends p0<Class<? extends B>, B> implements Serializable, Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.of());
    private final ImmutableMap<Class<? extends B>, B> delegate;

    /* loaded from: classes2.dex */
    public static final class b<B> {
        private final ImmutableMap.b<Class<? extends B>, B> a = ImmutableMap.builder();

        private static <B, T extends B> T b(Class<T> cls, B b2) {
            return (T) f.d(cls).cast(b2);
        }

        public ImmutableClassToInstanceMap<B> a() {
            ImmutableMap<Class<? extends B>, B> a = this.a.a();
            if (a.isEmpty()) {
                return ImmutableClassToInstanceMap.of();
            }
            return new ImmutableClassToInstanceMap<>(a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public <T extends B> b<B> c(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class cls = (Class) entry.getKey();
                this.a.c(cls, b(cls, entry.getValue()));
            }
            return this;
        }
    }

    public static <B> b<B> builder() {
        return new b<>();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        if (map instanceof ImmutableClassToInstanceMap) {
            return (ImmutableClassToInstanceMap) map;
        }
        return new b().c(map).a();
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T extends B, java.lang.Object] */
    @NullableDecl
    public <T extends B> T getInstance(Class<T> cls) {
        return this.delegate.get(n.o(cls));
    }

    @CanIgnoreReturnValue
    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    Object readResolve() {
        return isEmpty() ? of() : this;
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> cls, T t) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.of(cls, t));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.p0, com.google.common.collect.s0
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }
}
