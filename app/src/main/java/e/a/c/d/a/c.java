package e.a.c.d.a;

import java.lang.reflect.Array;

/* loaded from: classes4.dex */
public final class c {
    public static a a(b bVar, i iVar) {
        int d2 = bVar.d();
        int i = 1 << d2;
        int g = iVar.g();
        int[][] iArr = (int[][]) Array.newInstance(int.class, g, i);
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, g, i);
        for (int i2 = 0; i2 < i; i2++) {
            iArr2[0][i2] = bVar.f(iVar.e(i2));
        }
        for (int i3 = 1; i3 < g; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                iArr2[i3][i4] = bVar.h(iArr2[i3 - 1][i4], i4);
            }
        }
        for (int i5 = 0; i5 < g; i5++) {
            for (int i6 = 0; i6 < i; i6++) {
                for (int i7 = 0; i7 <= i5; i7++) {
                    iArr[i5][i6] = bVar.a(iArr[i5][i6], bVar.h(iArr2[i7][i6], iVar.f((g + i7) - i5)));
                }
            }
        }
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, g * d2, (i + 31) >>> 5);
        for (int i8 = 0; i8 < i; i8++) {
            int i9 = i8 >>> 5;
            int i10 = 1 << (i8 & 31);
            for (int i11 = 0; i11 < g; i11++) {
                int i12 = iArr[i11][i8];
                for (int i13 = 0; i13 < d2; i13++) {
                    if (((i12 >>> i13) & 1) != 0) {
                        int[] iArr4 = iArr3[(((i11 + 1) * d2) - i13) - 1];
                        iArr4[i9] = iArr4[i9] ^ i10;
                    }
                }
            }
        }
        return new a(i, iArr3);
    }
}
