package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.primitives.d;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.Comparable;

/* compiled from: DiscreteDomain.java */
/* loaded from: classes2.dex */
public abstract class i0<C extends Comparable> {

    /* renamed from: c  reason: collision with root package name */
    final boolean f4477c;

    /* compiled from: DiscreteDomain.java */
    /* loaded from: classes2.dex */
    private static final class b extends i0<Integer> implements Serializable {

        /* renamed from: d  reason: collision with root package name */
        private static final b f4478d = new b();

        b() {
            super(true);
        }

        /* renamed from: l */
        public long a(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }

        /* renamed from: m */
        public Integer f() {
            return Integer.MAX_VALUE;
        }

        /* renamed from: n */
        public Integer g() {
            return Integer.MIN_VALUE;
        }

        /* renamed from: o */
        public Integer h(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: p */
        public Integer i(Integer num, long j) {
            v.c(j, "distance");
            return Integer.valueOf(d.c(num.longValue() + j));
        }

        /* renamed from: q */
        public Integer j(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    /* compiled from: DiscreteDomain.java */
    /* loaded from: classes2.dex */
    private static final class c extends i0<Long> implements Serializable {

        /* renamed from: d  reason: collision with root package name */
        private static final c f4479d = new c();

        c() {
            super(true);
        }

        /* renamed from: l */
        public long a(Long l, Long l2) {
            long longValue = l2.longValue() - l.longValue();
            if (l2.longValue() > l.longValue() && longValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l2.longValue() >= l.longValue() || longValue <= 0) {
                return longValue;
            }
            return Long.MIN_VALUE;
        }

        /* renamed from: m */
        public Long f() {
            return Long.MAX_VALUE;
        }

        /* renamed from: n */
        public Long g() {
            return Long.MIN_VALUE;
        }

        /* renamed from: o */
        public Long h(Long l) {
            long longValue = l.longValue();
            if (longValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(longValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: p */
        public Long i(Long l, long j) {
            v.c(j, "distance");
            long longValue = l.longValue() + j;
            if (longValue < 0) {
                n.e(l.longValue() < 0, "overflow");
            }
            return Long.valueOf(longValue);
        }

        /* renamed from: q */
        public Long j(Long l) {
            long longValue = l.longValue();
            if (longValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(longValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    public static i0<Integer> b() {
        return b.f4478d;
    }

    public static i0<Long> d() {
        return c.f4479d;
    }

    public abstract long a(C c2, C c3);

    @CanIgnoreReturnValue
    public abstract C f();

    @CanIgnoreReturnValue
    public abstract C g();

    public abstract C h(C c2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract C i(C c2, long j);

    public abstract C j(C c2);

    protected i0() {
        this(false);
    }

    private i0(boolean z) {
        this.f4477c = z;
    }
}
