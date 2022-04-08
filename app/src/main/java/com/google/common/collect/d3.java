package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.base.t;
import com.google.common.collect.q1;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: StandardRowSortedTable.java */
/* loaded from: classes2.dex */
class d3<R, C, V> extends e3<R, C, V> implements f3 {
    private static final long serialVersionUID = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardRowSortedTable.java */
    /* loaded from: classes2.dex */
    public class b extends e3<R, C, V>.h implements SortedMap<R, Map<C, V>> {
        private b() {
            super();
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return d3.this.sortedBackingMap().comparator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: f */
        public SortedSet<R> b() {
            return new q1.o(this);
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) d3.this.sortedBackingMap().firstKey();
        }

        /* renamed from: g */
        public SortedSet<R> keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r) {
            n.o(r);
            return new d3(d3.this.sortedBackingMap().headMap(r), d3.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) d3.this.sortedBackingMap().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r, R r2) {
            n.o(r);
            n.o(r2);
            return new d3(d3.this.sortedBackingMap().subMap(r, r2), d3.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r) {
            n.o(r);
            return new d3(d3.this.sortedBackingMap().tailMap(r), d3.this.factory).rowMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d3(SortedMap<R, Map<C, V>> sortedMap, t<? extends Map<C, V>> tVar) {
        super(sortedMap, tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SortedMap<R, Map<C, V>> sortedBackingMap() {
        return (SortedMap) this.backingMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.e3
    public SortedMap<R, Map<C, V>> createRowMap() {
        return new b();
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.q, com.google.common.collect.f3
    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.f3
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }
}
