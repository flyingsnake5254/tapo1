package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.f3;
import java.util.Map;

/* compiled from: SingletonImmutableTable.java */
/* loaded from: classes2.dex */
class w2<R, C, V> extends ImmutableTable<R, C, V> {

    /* renamed from: c  reason: collision with root package name */
    final R f4637c;

    /* renamed from: d  reason: collision with root package name */
    final C f4638d;

    /* renamed from: f  reason: collision with root package name */
    final V f4639f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w2(R r, C c2, V v) {
        this.f4637c = (R) n.o(r);
        this.f4638d = (C) n.o(c2);
        this.f4639f = (V) n.o(v);
    }

    @Override // com.google.common.collect.ImmutableTable
    ImmutableTable.b createSerializedForm() {
        return ImmutableTable.b.a(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.f3
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableMap<R, V> column(C c2) {
        n.o(c2);
        if (containsColumn(c2)) {
            return ImmutableMap.of(this.f4637c, (Object) this.f4639f);
        }
        return ImmutableMap.of();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.f3
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.f4638d, ImmutableMap.of(this.f4637c, (Object) this.f4639f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.q
    public ImmutableSet<f3.a<R, C, V>> createCellSet() {
        return ImmutableSet.of(ImmutableTable.cellOf(this.f4637c, this.f4638d, this.f4639f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.q
    public ImmutableCollection<V> createValues() {
        return ImmutableSet.of(this.f4639f);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.f3
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.f4637c, ImmutableMap.of(this.f4638d, (Object) this.f4639f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w2(f3.a<R, C, V> aVar) {
        this(aVar.a(), aVar.b(), aVar.getValue());
    }
}
