package io.reactivex.internal.util;

/* compiled from: OpenHashSet.java */
/* loaded from: classes4.dex */
public final class h<T> {
    final float a;

    /* renamed from: b  reason: collision with root package name */
    int f16240b;

    /* renamed from: c  reason: collision with root package name */
    int f16241c;

    /* renamed from: d  reason: collision with root package name */
    int f16242d;

    /* renamed from: e  reason: collision with root package name */
    T[] f16243e;

    public h() {
        this(16, 0.75f);
    }

    static int c(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.f16243e;
        int i = this.f16240b;
        int c2 = c(t.hashCode()) & i;
        T t3 = tArr[c2];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                c2 = (c2 + 1) & i;
                t2 = tArr[c2];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[c2] = t;
        int i2 = this.f16241c + 1;
        this.f16241c = i2;
        if (i2 >= this.f16242d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f16243e;
    }

    void d() {
        T[] tArr = this.f16243e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.f16241c;
        while (true) {
            i3--;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int c2 = c(tArr[length].hashCode()) & i2;
                if (tArr2[c2] != null) {
                    do {
                        c2 = (c2 + 1) & i2;
                    } while (tArr2[c2] != null);
                }
                tArr2[c2] = tArr[length];
            } else {
                this.f16240b = i2;
                this.f16242d = (int) (i * this.a);
                this.f16243e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t) {
        T t2;
        T[] tArr = this.f16243e;
        int i = this.f16240b;
        int c2 = c(t.hashCode()) & i;
        T t3 = tArr[c2];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return f(c2, tArr, i);
        }
        do {
            c2 = (c2 + 1) & i;
            t2 = tArr[c2];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return f(c2, tArr, i);
    }

    boolean f(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f16241c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int c2 = c(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= c2 && c2 > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < c2 && c2 <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public int g() {
        return this.f16241c;
    }

    public h(int i, float f2) {
        this.a = f2;
        int a = i.a(i);
        this.f16240b = a - 1;
        this.f16242d = (int) (f2 * a);
        this.f16243e = (T[]) new Object[a];
    }
}
