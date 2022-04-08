package com.google.common.collect;

import com.google.common.collect.j2;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableBiMap.java */
/* loaded from: classes2.dex */
public final class h2<K, V> extends ImmutableBiMap<K, V> {

    /* renamed from: c  reason: collision with root package name */
    static final h2<Object, Object> f4471c = new h2<>();

    /* renamed from: d  reason: collision with root package name */
    private final transient int[] f4472d;

    /* renamed from: f  reason: collision with root package name */
    final transient Object[] f4473f;
    private final transient int q;
    private final transient int x;
    private final transient h2<V, K> y;

    /* JADX WARN: Multi-variable type inference failed */
    private h2() {
        this.f4472d = null;
        this.f4473f = new Object[0];
        this.q = 0;
        this.x = 0;
        this.y = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new j2.a(this, this.f4473f, this.q, this.x);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new j2.b(this, new j2.c(this.f4473f, this.q, this.x));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        return (V) j2.d(this.f4472d, this.f4473f, this.x, this.q, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.x;
    }

    @Override // com.google.common.collect.ImmutableBiMap
    public ImmutableBiMap<V, K> inverse() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h2(Object[] objArr, int i) {
        this.f4473f = objArr;
        this.x = i;
        this.q = 0;
        int chooseTableSize = i >= 2 ? ImmutableSet.chooseTableSize(i) : 0;
        this.f4472d = j2.b(objArr, i, chooseTableSize, 0);
        this.y = new h2<>(j2.b(objArr, i, chooseTableSize, 1), objArr, i, this);
    }

    private h2(int[] iArr, Object[] objArr, int i, h2<V, K> h2Var) {
        this.f4472d = iArr;
        this.f4473f = objArr;
        this.q = 1;
        this.x = i;
        this.y = h2Var;
    }
}
