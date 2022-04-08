package com.google.common.collect;

import com.google.common.base.n;
import com.tplink.libtpmediastatistics.SSLClient;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Cut.java */
/* loaded from: classes2.dex */
public abstract class d0<C extends Comparable> implements Comparable<d0<C>>, Serializable {
    @NullableDecl

    /* renamed from: c  reason: collision with root package name */
    final C f4386c;

    /* compiled from: Cut.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BoundType.values().length];
            a = iArr;
            try {
                iArr[BoundType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BoundType.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cut.java */
    /* loaded from: classes2.dex */
    public static final class b extends d0<Comparable<?>> {

        /* renamed from: d  reason: collision with root package name */
        private static final b f4387d = new b();

        private b() {
            super(null);
        }

        @Override // com.google.common.collect.d0
        /* renamed from: h */
        public int compareTo(d0<Comparable<?>> d0Var) {
            return d0Var == this ? 0 : 1;
        }

        @Override // com.google.common.collect.d0
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.d0
        void i(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.d0
        void j(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // com.google.common.collect.d0
        Comparable<?> k() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.d0
        Comparable<?> l(i0<Comparable<?>> i0Var) {
            return i0Var.f();
        }

        @Override // com.google.common.collect.d0
        boolean m(Comparable<?> comparable) {
            return false;
        }

        @Override // com.google.common.collect.d0
        Comparable<?> n(i0<Comparable<?>> i0Var) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.d0
        BoundType o() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.d0
        BoundType p() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.d0
        d0<Comparable<?>> q(BoundType boundType, i0<Comparable<?>> i0Var) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.d0
        d0<Comparable<?>> r(BoundType boundType, i0<Comparable<?>> i0Var) {
            throw new IllegalStateException();
        }

        public String toString() {
            return "+∞";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cut.java */
    /* loaded from: classes2.dex */
    public static final class c<C extends Comparable> extends d0<C> {
        c(C c2) {
            super((Comparable) n.o(c2));
        }

        @Override // com.google.common.collect.d0, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return d0.super.compareTo((d0) obj);
        }

        @Override // com.google.common.collect.d0
        d0<C> g(i0<C> i0Var) {
            C n = n(i0Var);
            return n != null ? d0.f(n) : d0.a();
        }

        @Override // com.google.common.collect.d0
        public int hashCode() {
            return ~this.f4386c.hashCode();
        }

        @Override // com.google.common.collect.d0
        void i(StringBuilder sb) {
            sb.append('(');
            sb.append(this.f4386c);
        }

        @Override // com.google.common.collect.d0
        void j(StringBuilder sb) {
            sb.append(this.f4386c);
            sb.append(']');
        }

        @Override // com.google.common.collect.d0
        C l(i0<C> i0Var) {
            return this.f4386c;
        }

        @Override // com.google.common.collect.d0
        boolean m(C c2) {
            return Range.compareOrThrow(this.f4386c, c2) < 0;
        }

        @Override // com.google.common.collect.d0
        C n(i0<C> i0Var) {
            return i0Var.h(this.f4386c);
        }

        @Override // com.google.common.collect.d0
        BoundType o() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.d0
        BoundType p() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.d0
        d0<C> q(BoundType boundType, i0<C> i0Var) {
            int i = a.a[boundType.ordinal()];
            if (i == 1) {
                C h = i0Var.h(this.f4386c);
                return h == null ? d0.d() : d0.f(h);
            } else if (i == 2) {
                return this;
            } else {
                throw new AssertionError();
            }
        }

        @Override // com.google.common.collect.d0
        d0<C> r(BoundType boundType, i0<C> i0Var) {
            int i = a.a[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i == 2) {
                C h = i0Var.h(this.f4386c);
                return h == null ? d0.a() : d0.f(h);
            }
            throw new AssertionError();
        }

        public String toString() {
            return MqttTopic.TOPIC_LEVEL_SEPARATOR + this.f4386c + SSLClient.ESCAPE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cut.java */
    /* loaded from: classes2.dex */
    public static final class d extends d0<Comparable<?>> {

        /* renamed from: d  reason: collision with root package name */
        private static final d f4388d = new d();

        private d() {
            super(null);
        }

        @Override // com.google.common.collect.d0
        d0<Comparable<?>> g(i0<Comparable<?>> i0Var) {
            try {
                return d0.f(i0Var.g());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        @Override // com.google.common.collect.d0
        /* renamed from: h */
        public int compareTo(d0<Comparable<?>> d0Var) {
            return d0Var == this ? 0 : -1;
        }

        @Override // com.google.common.collect.d0
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.d0
        void i(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // com.google.common.collect.d0
        void j(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.d0
        Comparable<?> k() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.d0
        Comparable<?> l(i0<Comparable<?>> i0Var) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.d0
        boolean m(Comparable<?> comparable) {
            return true;
        }

        @Override // com.google.common.collect.d0
        Comparable<?> n(i0<Comparable<?>> i0Var) {
            return i0Var.g();
        }

        @Override // com.google.common.collect.d0
        BoundType o() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.d0
        BoundType p() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.d0
        d0<Comparable<?>> q(BoundType boundType, i0<Comparable<?>> i0Var) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.d0
        d0<Comparable<?>> r(BoundType boundType, i0<Comparable<?>> i0Var) {
            throw new AssertionError("this statement should be unreachable");
        }

        public String toString() {
            return "-∞";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cut.java */
    /* loaded from: classes2.dex */
    public static final class e<C extends Comparable> extends d0<C> {
        e(C c2) {
            super((Comparable) n.o(c2));
        }

        @Override // com.google.common.collect.d0, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return d0.super.compareTo((d0) obj);
        }

        @Override // com.google.common.collect.d0
        public int hashCode() {
            return this.f4386c.hashCode();
        }

        @Override // com.google.common.collect.d0
        void i(StringBuilder sb) {
            sb.append('[');
            sb.append(this.f4386c);
        }

        @Override // com.google.common.collect.d0
        void j(StringBuilder sb) {
            sb.append(this.f4386c);
            sb.append(')');
        }

        @Override // com.google.common.collect.d0
        C l(i0<C> i0Var) {
            return i0Var.j(this.f4386c);
        }

        @Override // com.google.common.collect.d0
        boolean m(C c2) {
            return Range.compareOrThrow(this.f4386c, c2) <= 0;
        }

        @Override // com.google.common.collect.d0
        C n(i0<C> i0Var) {
            return this.f4386c;
        }

        @Override // com.google.common.collect.d0
        BoundType o() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.d0
        BoundType p() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.d0
        d0<C> q(BoundType boundType, i0<C> i0Var) {
            int i = a.a[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i == 2) {
                C j = i0Var.j(this.f4386c);
                return j == null ? d0.d() : new c(j);
            }
            throw new AssertionError();
        }

        @Override // com.google.common.collect.d0
        d0<C> r(BoundType boundType, i0<C> i0Var) {
            int i = a.a[boundType.ordinal()];
            if (i == 1) {
                C j = i0Var.j(this.f4386c);
                return j == null ? d0.a() : new c(j);
            } else if (i == 2) {
                return this;
            } else {
                throw new AssertionError();
            }
        }

        public String toString() {
            return SSLClient.ESCAPE + this.f4386c + MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
    }

    d0(@NullableDecl C c2) {
        this.f4386c = c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> d0<C> a() {
        return b.f4387d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> d0<C> b(C c2) {
        return new c(c2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> d0<C> d() {
        return d.f4388d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> d0<C> f(C c2) {
        return new e(c2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        try {
            return compareTo((d0) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0<C> g(i0<C> i0Var) {
        return this;
    }

    /* renamed from: h */
    public int compareTo(d0<C> d0Var) {
        if (d0Var == d()) {
            return 1;
        }
        if (d0Var == a()) {
            return -1;
        }
        int compareOrThrow = Range.compareOrThrow(this.f4386c, d0Var.f4386c);
        return compareOrThrow != 0 ? compareOrThrow : com.google.common.primitives.a.a(this instanceof c, d0Var instanceof c);
    }

    public abstract int hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void i(StringBuilder sb);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void j(StringBuilder sb);

    /* JADX INFO: Access modifiers changed from: package-private */
    public C k() {
        return this.f4386c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract C l(i0<C> i0Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean m(C c2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract C n(i0<C> i0Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType o();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType p();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract d0<C> q(BoundType boundType, i0<C> i0Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract d0<C> r(BoundType boundType, i0<C> i0Var);
}
