package kotlin.collections;

import kotlin.jvm.internal.j;

/* compiled from: IndexedValue.kt */
/* loaded from: classes4.dex */
public final class y<T> {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final T f16323b;

    public y(int i, T t) {
        this.a = i;
        this.f16323b = t;
    }

    public final int a() {
        return this.a;
    }

    public final T b() {
        return this.f16323b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.a == yVar.a && j.a(this.f16323b, yVar.f16323b);
    }

    public int hashCode() {
        int i = this.a * 31;
        T t = this.f16323b;
        return i + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + this.f16323b + ")";
    }
}
