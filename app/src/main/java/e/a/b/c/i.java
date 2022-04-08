package e.a.b.c;

/* loaded from: classes4.dex */
public abstract class i {
    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        e.x(iArr, iArr2, iArr3);
        e.w(iArr, 6, iArr2, 6, iArr3, 12);
        int d2 = e.d(iArr3, 6, iArr3, 12);
        int c2 = d2 + e.c(iArr3, 18, iArr3, 12, e.c(iArr3, 0, iArr3, 6, 0) + d2);
        int[] g = e.g();
        int[] g2 = e.g();
        boolean z = e.k(iArr, 6, iArr, 0, g, 0) != e.k(iArr2, 6, iArr2, 0, g2, 0);
        int[] i = e.i();
        e.x(g, g2, i);
        m.f(24, c2 + (z ? m.d(12, i, 0, iArr3, 6) : m.M(12, i, 0, iArr3, 6)), iArr3, 18);
    }

    public static void b(int[] iArr, int[] iArr2) {
        e.D(iArr, iArr2);
        e.C(iArr, 6, iArr2, 12);
        int d2 = e.d(iArr2, 6, iArr2, 12);
        int c2 = d2 + e.c(iArr2, 18, iArr2, 12, e.c(iArr2, 0, iArr2, 6, 0) + d2);
        int[] g = e.g();
        e.k(iArr, 6, iArr, 0, g, 0);
        int[] i = e.i();
        e.D(g, i);
        m.f(24, c2 + m.M(12, i, 0, iArr2, 6), iArr2, 18);
    }
}
