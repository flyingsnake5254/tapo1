package com.google.common.collect;

import java.lang.Comparable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractRangeSet.java */
/* loaded from: classes2.dex */
abstract class k<C extends Comparable> implements f2<C> {
    public abstract void add(Range<C> range);

    public void addAll(f2<C> f2Var) {
        addAll(f2Var.asRanges());
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean contains(C c2) {
        return rangeContaining(c2) != null;
    }

    @Override // com.google.common.collect.f2
    public abstract boolean encloses(Range<C> range);

    public boolean enclosesAll(f2<C> f2Var) {
        return enclosesAll(f2Var.asRanges());
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f2) {
            return asRanges().equals(((f2) obj).asRanges());
        }
        return false;
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public abstract boolean intersects(Range<C> range);

    @Override // com.google.common.collect.f2
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public abstract Range<C> rangeContaining(C c2);

    public abstract void remove(Range<C> range);

    @Override // com.google.common.collect.f2
    public void removeAll(f2<C> f2Var) {
        removeAll(f2Var.asRanges());
    }

    public final String toString() {
        return asRanges().toString();
    }

    public void addAll(Iterable<Range<C>> iterable) {
        for (Range<C> range : iterable) {
            add(range);
        }
    }

    public boolean enclosesAll(Iterable<Range<C>> iterable) {
        for (Range<C> range : iterable) {
            if (!encloses(range)) {
                return false;
            }
        }
        return true;
    }

    public void removeAll(Iterable<Range<C>> iterable) {
        for (Range<C> range : iterable) {
            remove(range);
        }
    }
}
