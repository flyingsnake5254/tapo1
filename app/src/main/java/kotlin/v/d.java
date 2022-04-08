package kotlin.v;

import kotlin.jvm.internal.f;

/* compiled from: Ranges.kt */
/* loaded from: classes4.dex */
public final class d extends b implements a<Integer> {
    public static final a y = new a(null);
    private static final d x = new d(1, 0);

    /* compiled from: Ranges.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public final d a() {
            return d.x;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public d(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // kotlin.v.b
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (!(a() == dVar.a() && b() == dVar.b())) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i) {
        return a() <= i && i <= b();
    }

    /* renamed from: g */
    public Integer getEndInclusive() {
        return Integer.valueOf(b());
    }

    /* renamed from: h */
    public Integer getStart() {
        return Integer.valueOf(a());
    }

    @Override // kotlin.v.b
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // kotlin.v.b
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // kotlin.v.b
    public String toString() {
        return a() + ".." + b();
    }
}
