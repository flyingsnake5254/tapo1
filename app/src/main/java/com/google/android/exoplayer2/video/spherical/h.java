package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.g;

/* compiled from: Projection.java */
/* loaded from: classes.dex */
final class h {
    public final a a;

    /* renamed from: b  reason: collision with root package name */
    public final a f4046b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4047c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4048d;

    /* compiled from: Projection.java */
    /* loaded from: classes.dex */
    public static final class a {
        private final b[] a;

        public a(b... bVarArr) {
            this.a = bVarArr;
        }

        public b a(int i) {
            return this.a[i];
        }

        public int b() {
            return this.a.length;
        }
    }

    /* compiled from: Projection.java */
    /* loaded from: classes.dex */
    public static final class b {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4049b;

        /* renamed from: c  reason: collision with root package name */
        public final float[] f4050c;

        /* renamed from: d  reason: collision with root package name */
        public final float[] f4051d;

        public b(int i, float[] fArr, float[] fArr2, int i2) {
            this.a = i;
            g.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f4050c = fArr;
            this.f4051d = fArr2;
            this.f4049b = i2;
        }

        public int a() {
            return this.f4050c.length / 3;
        }
    }

    public h(a aVar, int i) {
        this(aVar, aVar, i);
    }

    public static h a(float f2, int i, int i2, float f3, float f4, int i3) {
        float f5;
        int i4;
        int i5 = i;
        int i6 = i2;
        g.a(f2 > 0.0f);
        g.a(i5 >= 1);
        g.a(i6 >= 1);
        g.a(f3 > 0.0f && f3 <= 180.0f);
        g.a(f4 > 0.0f && f4 <= 360.0f);
        float radians = (float) Math.toRadians(f3);
        float radians2 = (float) Math.toRadians(f4);
        float f6 = radians / i5;
        float f7 = radians2 / i6;
        int i7 = i6 + 1;
        int i8 = ((i7 * 2) + 2) * i5;
        float[] fArr = new float[i8 * 3];
        float[] fArr2 = new float[i8 * 2];
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < i5) {
            float f8 = radians / 2.0f;
            float f9 = (i9 * f6) - f8;
            int i12 = i9 + 1;
            float f10 = (i12 * f6) - f8;
            int i13 = 0;
            while (i13 < i7) {
                int i14 = 0;
                while (i14 < 2) {
                    if (i14 == 0) {
                        f5 = f9;
                        i7 = i7;
                    } else {
                        i7 = i7;
                        f5 = f10;
                    }
                    float f11 = i13 * f7;
                    int i15 = i10 + 1;
                    double d2 = f2;
                    double d3 = (f11 + 3.1415927f) - (radians2 / 2.0f);
                    double d4 = f5;
                    fArr[i10] = -((float) (Math.sin(d3) * d2 * Math.cos(d4)));
                    int i16 = i15 + 1;
                    fArr[i15] = (float) (d2 * Math.sin(d4));
                    i10 = i16 + 1;
                    fArr[i16] = (float) (d2 * Math.cos(d3) * Math.cos(d4));
                    int i17 = i11 + 1;
                    fArr2[i11] = f11 / radians2;
                    i11 = i17 + 1;
                    fArr2[i17] = ((i9 + i14) * f6) / radians;
                    if (i13 == 0 && i14 == 0) {
                        i6 = i2;
                        i13 = i13;
                        i4 = i14;
                    } else {
                        i6 = i2;
                        i13 = i13;
                        i4 = i14;
                        if (!(i13 == i6 && i4 == 1)) {
                            fArr2 = fArr2;
                            i14 = i4 + 1;
                            i9 = i9;
                            f7 = f7;
                            f6 = f6;
                            f10 = f10;
                        }
                    }
                    System.arraycopy(fArr, i10 - 3, fArr, i10, 3);
                    i10 += 3;
                    fArr2 = fArr2;
                    System.arraycopy(fArr2, i11 - 2, fArr2, i11, 2);
                    i11 += 2;
                    i14 = i4 + 1;
                    i9 = i9;
                    f7 = f7;
                    f6 = f6;
                    f10 = f10;
                }
                i13++;
                f9 = f9;
                i12 = i12;
                i7 = i7;
                f7 = f7;
                f6 = f6;
                f10 = f10;
            }
            i5 = i;
            i9 = i12;
        }
        return new h(new a(new b(0, fArr, fArr2, 1)), i3);
    }

    public static h b(int i) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public h(a aVar, a aVar2, int i) {
        this.a = aVar;
        this.f4046b = aVar2;
        this.f4047c = i;
        this.f4048d = aVar == aVar2;
    }
}
