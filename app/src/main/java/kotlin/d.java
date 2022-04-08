package kotlin;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: KotlinVersion.kt */
/* loaded from: classes4.dex */
public final class d implements Comparable<d> {

    /* renamed from: f  reason: collision with root package name */
    private final int f16339f;
    private final int q;
    private final int x;
    private final int y;

    /* renamed from: d  reason: collision with root package name */
    public static final a f16338d = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static final d f16337c = e.a();

    /* compiled from: KotlinVersion.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public d(int i, int i2, int i3) {
        this.q = i;
        this.x = i2;
        this.y = i3;
        this.f16339f = b(i, i2, i3);
    }

    private final int b(int i, int i2, int i3) {
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    /* renamed from: a */
    public int compareTo(d other) {
        j.e(other, "other");
        return this.f16339f - other.f16339f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            obj = null;
        }
        d dVar = (d) obj;
        return dVar != null && this.f16339f == dVar.f16339f;
    }

    public int hashCode() {
        return this.f16339f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.q);
        sb.append('.');
        sb.append(this.x);
        sb.append('.');
        sb.append(this.y);
        return sb.toString();
    }
}
