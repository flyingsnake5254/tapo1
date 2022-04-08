package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.j;

/* compiled from: Tuples.kt */
/* loaded from: classes4.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a, B b2) {
        this.first = a;
        this.second = b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair copy$default(Pair pair, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = pair.first;
        }
        if ((i & 2) != 0) {
            obj2 = pair.second;
        }
        return pair.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final Pair<A, B> copy(A a, B b2) {
        return new Pair<>(a, b2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return j.a(this.first, pair.first) && j.a(this.second, pair.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a = this.first;
        int i = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.second;
        if (b2 != null) {
            i = b2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
