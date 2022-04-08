package com.google.common.base;

import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Present.java */
/* loaded from: classes2.dex */
public final class q<T> extends Optional<T> {

    /* renamed from: c  reason: collision with root package name */
    private final T f4146c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(T t) {
        this.f4146c = t;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.f4146c);
    }

    @Override // com.google.common.base.Optional
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof q) {
            return this.f4146c.equals(((q) obj).f4146c);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        return this.f4146c;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return this.f4146c.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.common.base.Optional
    public T or(T t) {
        n.p(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.f4146c;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return this.f4146c;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.of(" + this.f4146c + ")";
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(h<? super T, V> hVar) {
        return new q(n.p(hVar.apply((T) this.f4146c), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        n.o(optional);
        return this;
    }

    @Override // com.google.common.base.Optional
    public T or(t<? extends T> tVar) {
        n.o(tVar);
        return this.f4146c;
    }
}
