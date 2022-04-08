package b.d.e0.h;

/* compiled from: FrameMetadata.java */
/* loaded from: classes3.dex */
public class e {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f412b;

    /* renamed from: c  reason: collision with root package name */
    private final int f413c;

    /* compiled from: FrameMetadata.java */
    /* loaded from: classes3.dex */
    public static class b {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f414b;

        /* renamed from: c  reason: collision with root package name */
        private int f415c;

        public e a() {
            return new e(this.a, this.f414b, this.f415c);
        }

        public b b(int i) {
            this.f414b = i;
            return this;
        }

        public b c(int i) {
            this.f415c = i;
            return this;
        }

        public b d(int i) {
            this.a = i;
            return this;
        }
    }

    public int a() {
        return this.f412b;
    }

    public int b() {
        return this.f413c;
    }

    public int c() {
        return this.a;
    }

    private e(int i, int i2, int i3) {
        this.a = i;
        this.f412b = i2;
        this.f413c = i3;
    }
}
