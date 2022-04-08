package e.a.b.c;

/* loaded from: classes4.dex */
public abstract class k {
    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        g.y(iArr, iArr2, iArr3);
        g.x(iArr, 8, iArr2, 8, iArr3, 16);
        int e2 = g.e(iArr3, 8, iArr3, 16);
        int c2 = e2 + g.c(iArr3, 24, iArr3, 16, g.c(iArr3, 0, iArr3, 8, 0) + e2);
        int[] h = g.h();
        int[] h2 = g.h();
        boolean z = g.l(iArr, 8, iArr, 0, h, 0) != g.l(iArr2, 8, iArr2, 0, h2, 0);
        int[] j = g.j();
        g.y(h, h2, j);
        m.f(32, c2 + (z ? m.d(16, j, 0, iArr3, 8) : m.M(16, j, 0, iArr3, 8)), iArr3, 24);
    }

    public static void b(int[] iArr, int[] iArr2) {
        g.F(iArr, iArr2);
        g.E(iArr, 8, iArr2, 16);
        int e2 = g.e(iArr2, 8, iArr2, 16);
        int c2 = e2 + g.c(iArr2, 24, iArr2, 16, g.c(iArr2, 0, iArr2, 8, 0) + e2);
        int[] h = g.h();
        g.l(iArr, 8, iArr, 0, h, 0);
        int[] j = g.j();
        g.F(h, j);
        m.f(32, c2 + m.M(16, j, 0, iArr2, 8), iArr2, 24);
    }
}
