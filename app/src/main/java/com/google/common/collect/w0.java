package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeneralRange.java */
/* loaded from: classes2.dex */
public final class w0<T> implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    private final Comparator<? super T> f4633c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4634d;
    @NullableDecl

    /* renamed from: f  reason: collision with root package name */
    private final T f4635f;
    private final BoundType q;
    private final boolean x;
    @NullableDecl
    private final T y;
    private final BoundType z;

    /* JADX WARN: Multi-variable type inference failed */
    private w0(Comparator<? super T> comparator, boolean z, @NullableDecl T t, BoundType boundType, boolean z2, @NullableDecl T t2, BoundType boundType2) {
        this.f4633c = (Comparator) n.o(comparator);
        this.f4634d = z;
        this.x = z2;
        this.f4635f = t;
        this.q = (BoundType) n.o(boundType);
        this.y = t2;
        this.z = (BoundType) n.o(boundType2);
        if (z) {
            comparator.compare(t, t);
        }
        if (z2) {
            comparator.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator.compare(t, t2);
            boolean z3 = true;
            n.k(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                n.d((boundType != boundType3) | (boundType2 == boundType3 ? false : z3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> w0<T> a(Comparator<? super T> comparator) {
        BoundType boundType = BoundType.OPEN;
        return new w0<>(comparator, false, null, boundType, false, null, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> w0<T> f(Comparator<? super T> comparator, @NullableDecl T t, BoundType boundType) {
        return new w0<>(comparator, true, t, boundType, false, null, BoundType.OPEN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> w0<T> p(Comparator<? super T> comparator, @NullableDecl T t, BoundType boundType) {
        return new w0<>(comparator, false, null, BoundType.OPEN, true, t, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Comparator<? super T> b() {
        return this.f4633c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(@NullableDecl T t) {
        return !o(t) && !n(t);
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return this.f4633c.equals(w0Var.f4633c) && this.f4634d == w0Var.f4634d && this.x == w0Var.x && g().equals(w0Var.g()) && i().equals(w0Var.i()) && k.a(h(), w0Var.h()) && k.a(j(), w0Var.j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundType g() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T h() {
        return this.f4635f;
    }

    public int hashCode() {
        return k.b(this.f4633c, h(), g(), j(), i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundType i() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T j() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f4634d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0<T> m(w0<T> w0Var) {
        BoundType boundType;
        BoundType boundType2;
        T t;
        int compare;
        BoundType boundType3;
        int compare2;
        int compare3;
        n.o(w0Var);
        n.d(this.f4633c.equals(w0Var.f4633c));
        boolean z = this.f4634d;
        T h = h();
        BoundType g = g();
        if (!k()) {
            z = w0Var.f4634d;
            h = w0Var.h();
            g = w0Var.g();
        } else if (w0Var.k() && ((compare3 = this.f4633c.compare(h(), w0Var.h())) < 0 || (compare3 == 0 && w0Var.g() == BoundType.OPEN))) {
            h = w0Var.h();
            g = w0Var.g();
        }
        boolean z2 = this.x;
        T j = j();
        BoundType i = i();
        if (!l()) {
            z2 = w0Var.x;
            j = w0Var.j();
            i = w0Var.i();
        } else if (w0Var.l() && ((compare2 = this.f4633c.compare(j(), w0Var.j())) > 0 || (compare2 == 0 && w0Var.i() == BoundType.OPEN))) {
            j = w0Var.j();
            i = w0Var.i();
        }
        if (!z || !z2 || ((compare = this.f4633c.compare(h, j)) <= 0 && !(compare == 0 && g == (boundType3 = BoundType.OPEN) && i == boundType3))) {
            t = h;
            boundType2 = g;
            boundType = i;
        } else {
            boundType2 = BoundType.OPEN;
            boundType = BoundType.CLOSED;
            t = j;
        }
        return new w0<>(this.f4633c, z, t, boundType2, z2, j, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(@NullableDecl T t) {
        boolean z = false;
        if (!l()) {
            return false;
        }
        int compare = this.f4633c.compare(t, j());
        boolean z2 = compare > 0;
        boolean z3 = compare == 0;
        if (i() == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(@NullableDecl T t) {
        boolean z = false;
        if (!k()) {
            return false;
        }
        int compare = this.f4633c.compare(t, h());
        boolean z2 = compare < 0;
        boolean z3 = compare == 0;
        if (g() == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4633c);
        sb.append(SSLClient.COLON);
        BoundType boundType = this.q;
        BoundType boundType2 = BoundType.CLOSED;
        sb.append(boundType == boundType2 ? '[' : '(');
        sb.append(this.f4634d ? this.f4635f : "-∞");
        sb.append(StringUtil.COMMA);
        sb.append(this.x ? this.y : "∞");
        sb.append(this.z == boundType2 ? ']' : ')');
        return sb.toString();
    }
}
