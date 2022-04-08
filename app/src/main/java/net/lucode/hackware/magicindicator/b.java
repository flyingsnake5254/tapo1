package net.lucode.hackware.magicindicator;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* compiled from: NavigatorHelper.java */
/* loaded from: classes4.dex */
public class b {
    private SparseBooleanArray a = new SparseBooleanArray();

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<Float> f16575b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private int f16576c;

    /* renamed from: d  reason: collision with root package name */
    private int f16577d;

    /* renamed from: e  reason: collision with root package name */
    private int f16578e;

    /* renamed from: f  reason: collision with root package name */
    private float f16579f;
    private int g;
    private boolean h;
    private a i;

    /* compiled from: NavigatorHelper.java */
    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, int i2);

        void b(int i, int i2, float f2, boolean z);

        void c(int i, int i2);

        void d(int i, int i2, float f2, boolean z);
    }

    private void a(int i) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(i, this.f16576c);
        }
        this.a.put(i, true);
    }

    private void b(int i, float f2, boolean z, boolean z2) {
        if (this.h || i == this.f16577d || this.g == 1 || z2) {
            a aVar = this.i;
            if (aVar != null) {
                aVar.b(i, this.f16576c, f2, z);
            }
            this.f16575b.put(i, Float.valueOf(1.0f - f2));
        }
    }

    private void c(int i, float f2, boolean z, boolean z2) {
        if (!(this.h || i == this.f16578e || this.g == 1)) {
            int i2 = this.f16577d;
            if ((!(i == i2 - 1 || i == i2 + 1) || this.f16575b.get(i, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z2) {
                return;
            }
        }
        a aVar = this.i;
        if (aVar != null) {
            aVar.d(i, this.f16576c, f2, z);
        }
        this.f16575b.put(i, Float.valueOf(f2));
    }

    private void d(int i) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.c(i, this.f16576c);
        }
        this.a.put(i, false);
    }

    public int e() {
        return this.f16577d;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.f16576c;
    }

    public void h(int i) {
        this.g = i;
    }

    public void i(int i, float f2, int i2) {
        boolean z;
        float f3 = i + f2;
        float f4 = this.f16579f;
        boolean z2 = f4 <= f3;
        if (this.g == 0) {
            for (int i3 = 0; i3 < this.f16576c; i3++) {
                if (i3 != this.f16577d) {
                    if (!this.a.get(i3)) {
                        a(i3);
                    }
                    if (this.f16575b.get(i3, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        c(i3, 1.0f, false, true);
                    }
                }
            }
            b(this.f16577d, 1.0f, false, true);
            d(this.f16577d);
        } else if (f3 != f4) {
            int i4 = i + 1;
            if (f2 != 0.0f || !z2) {
                z = true;
            } else {
                i4 = i - 1;
                z = false;
            }
            for (int i5 = 0; i5 < this.f16576c; i5++) {
                if (!(i5 == i || i5 == i4 || this.f16575b.get(i5, Float.valueOf(0.0f)).floatValue() == 1.0f)) {
                    c(i5, 1.0f, z2, true);
                }
            }
            if (!z) {
                float f5 = 1.0f - f2;
                c(i4, f5, true, false);
                b(i, f5, true, false);
            } else if (z2) {
                c(i, f2, true, false);
                b(i4, f2, true, false);
            } else {
                float f6 = 1.0f - f2;
                c(i4, f6, false, false);
                b(i, f6, false, false);
            }
        } else {
            return;
        }
        this.f16579f = f3;
    }

    public void j(int i) {
        this.f16578e = this.f16577d;
        this.f16577d = i;
        d(i);
        for (int i2 = 0; i2 < this.f16576c; i2++) {
            if (i2 != this.f16577d && !this.a.get(i2)) {
                a(i2);
            }
        }
    }

    public void k(a aVar) {
        this.i = aVar;
    }

    public void l(boolean z) {
        this.h = z;
    }

    public void m(int i) {
        this.f16576c = i;
        this.a.clear();
        this.f16575b.clear();
    }
}
