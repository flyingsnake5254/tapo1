package com.google.common.cache;

import com.google.common.base.n;
import java.util.AbstractMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    private RemovalNotification(@NullableDecl K k, @NullableDecl V v, RemovalCause removalCause) {
        super(k, v);
        this.cause = (RemovalCause) n.o(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> create(@NullableDecl K k, @NullableDecl V v, RemovalCause removalCause) {
        return new RemovalNotification<>(k, v, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
