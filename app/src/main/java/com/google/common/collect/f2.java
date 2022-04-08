package com.google.common.collect;

import java.lang.Comparable;
import java.util.Set;

/* compiled from: RangeSet.java */
/* loaded from: classes2.dex */
public interface f2<C extends Comparable> {
    Set<Range<C>> asRanges();

    f2<C> complement();

    boolean encloses(Range<C> range);

    boolean isEmpty();

    void removeAll(f2<C> f2Var);
}
