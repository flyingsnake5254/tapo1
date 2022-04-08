package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.z2;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements e2<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;
    private final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends ImmutableList<Range<K>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f4235c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f4236d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Range f4237f;

        a(int i, int i2, Range range) {
            this.f4235c = i;
            this.f4236d = i2;
            this.f4237f = range;
        }

        /* renamed from: a */
        public Range<K> get(int i) {
            n.m(i, this.f4235c);
            return (i == 0 || i == this.f4235c + (-1)) ? ((Range) ImmutableRangeMap.this.ranges.get(i + this.f4236d)).intersection(this.f4237f) : (Range) ImmutableRangeMap.this.ranges.get(i + this.f4236d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4235c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends ImmutableRangeMap<K, V> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Range f4238c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ImmutableRangeMap f4239d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ImmutableList immutableList, ImmutableList immutableList2, Range range, ImmutableRangeMap immutableRangeMap) {
            super(immutableList, immutableList2);
            this.f4238c = range;
            this.f4239d = immutableRangeMap;
        }

        @Override // com.google.common.collect.ImmutableRangeMap
        public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
            return ImmutableRangeMap.super.asDescendingMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.e2
        public /* bridge */ /* synthetic */ Map asMapOfRanges() {
            return ImmutableRangeMap.super.asMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap
        public ImmutableRangeMap<K, V> subRangeMap(Range<K> range) {
            if (this.f4238c.isConnected(range)) {
                return this.f4239d.subRangeMap((Range) range.intersection(this.f4238c));
            }
            return ImmutableRangeMap.of();
        }
    }

    /* loaded from: classes2.dex */
    public static final class c<K extends Comparable<?>, V> {
        private final List<Map.Entry<Range<K>, V>> a = n1.h();
    }

    /* loaded from: classes2.dex */
    private static class d<K extends Comparable<?>, V> implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableMap<Range<K>, V> f4241c;

        d(ImmutableMap<Range<K>, V> immutableMap) {
            this.f4241c = immutableMap;
        }
    }

    ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends Comparable<?>, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(e2<K, ? extends V> e2Var) {
        if (e2Var instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) e2Var;
        }
        Map<Range<K>, ? extends V> asMapOfRanges = e2Var.asMapOfRanges();
        ImmutableList.a aVar = new ImmutableList.a(asMapOfRanges.size());
        ImmutableList.a aVar2 = new ImmutableList.a(asMapOfRanges.size());
        for (Map.Entry<Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
            aVar.a(entry.getKey());
            aVar2.a(entry.getValue());
        }
        return new ImmutableRangeMap<>(aVar.j(), aVar2.j());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof e2) {
            return asMapOfRanges().equals(((e2) obj).asMapOfRanges());
        }
        return false;
    }

    @NullableDecl
    public V get(K k) {
        int a2 = z2.a(this.ranges, Range.lowerBoundFn(), d0.f(k), z2.c.f4670c, z2.b.f4667c);
        if (a2 != -1 && this.ranges.get(a2).contains(k)) {
            return this.values.get(a2);
        }
        return null;
    }

    @NullableDecl
    public Map.Entry<Range<K>, V> getEntry(K k) {
        int a2 = z2.a(this.ranges, Range.lowerBoundFn(), d0.f(k), z2.c.f4670c, z2.b.f4667c);
        if (a2 == -1) {
            return null;
        }
        Range<K> range = this.ranges.get(a2);
        if (range.contains(k)) {
            return q1.i(range, this.values.get(a2));
        }
        return null;
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Deprecated
    public void put(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putAll(e2<K, V> e2Var) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putCoalescing(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public Range<K> span() {
        if (!this.ranges.isEmpty()) {
            ImmutableList<Range<K>> immutableList = this.ranges;
            return Range.create(this.ranges.get(0).lowerBound, immutableList.get(immutableList.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    Object writeReplace() {
        return new d(asMapOfRanges());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v));
    }

    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new n2(this.ranges.reverse(), Range.rangeLexOrdering().j()), this.values.reverse());
    }

    @Override // com.google.common.collect.e2
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new n2(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    public ImmutableRangeMap<K, V> subRangeMap(Range<K> range) {
        if (((Range) n.o(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        ImmutableList<Range<K>> immutableList = this.ranges;
        h upperBoundFn = Range.upperBoundFn();
        d0<K> d0Var = range.lowerBound;
        z2.c cVar = z2.c.q;
        z2.b bVar = z2.b.f4668d;
        int a2 = z2.a(immutableList, upperBoundFn, d0Var, cVar, bVar);
        int a3 = z2.a(this.ranges, Range.lowerBoundFn(), range.upperBound, z2.c.f4670c, bVar);
        if (a2 >= a3) {
            return of();
        }
        return new b(new a(a3 - a2, a2, range), this.values.subList(a2, a3), range, this);
    }
}
