package kotlin.v;

import kotlin.collections.z;
import kotlin.internal.c;
import kotlin.jvm.internal.f;

/* compiled from: Progressions.kt */
/* loaded from: classes4.dex */
public class b implements Iterable<Integer>, kotlin.jvm.internal.r.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f16410c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private final int f16411d;

    /* renamed from: f  reason: collision with root package name */
    private final int f16412f;
    private final int q;

    /* compiled from: Progressions.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public final b a(int i, int i2, int i3) {
            return new b(i, i2, i3);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public b(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.f16411d = i;
            this.f16412f = c.b(i, i2, i3);
            this.q = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int a() {
        return this.f16411d;
    }

    public final int b() {
        return this.f16412f;
    }

    public final int c() {
        return this.q;
    }

    /* renamed from: d */
    public z iterator() {
        return new c(this.f16411d, this.f16412f, this.q);
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (!(this.f16411d == bVar.f16411d && this.f16412f == bVar.f16412f && this.q == bVar.q)) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f16411d * 31) + this.f16412f) * 31) + this.q;
    }

    public boolean isEmpty() {
        if (this.q > 0) {
            if (this.f16411d > this.f16412f) {
                return true;
            }
        } else if (this.f16411d < this.f16412f) {
            return true;
        }
        return false;
    }

    public String toString() {
        int i;
        StringBuilder sb;
        if (this.q > 0) {
            sb = new StringBuilder();
            sb.append(this.f16411d);
            sb.append("..");
            sb.append(this.f16412f);
            sb.append(" step ");
            i = this.q;
        } else {
            sb = new StringBuilder();
            sb.append(this.f16411d);
            sb.append(" downTo ");
            sb.append(this.f16412f);
            sb.append(" step ");
            i = -this.q;
        }
        sb.append(i);
        return sb.toString();
    }
}
