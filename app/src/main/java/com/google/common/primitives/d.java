package com.google.common.primitives;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Ints.java */
/* loaded from: classes2.dex */
public final class d {

    /* compiled from: Ints.java */
    /* loaded from: classes2.dex */
    private static class a extends AbstractList<Integer> implements RandomAccess, Serializable {

        /* renamed from: c  reason: collision with root package name */
        final int[] f4722c;

        /* renamed from: d  reason: collision with root package name */
        final int f4723d;

        /* renamed from: f  reason: collision with root package name */
        final int f4724f;

        a(int[] iArr, int i, int i2) {
            this.f4722c = iArr;
            this.f4723d = i;
            this.f4724f = i2;
        }

        /* renamed from: a */
        public Integer get(int i) {
            n.m(i, size());
            return Integer.valueOf(this.f4722c[this.f4723d + i]);
        }

        /* renamed from: b */
        public Integer set(int i, Integer num) {
            n.m(i, size());
            int[] iArr = this.f4722c;
            int i2 = this.f4723d;
            int i3 = iArr[i2 + i];
            iArr[i2 + i] = ((Integer) n.o(num)).intValue();
            return Integer.valueOf(i3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && d.g(this.f4722c, ((Integer) obj).intValue(), this.f4723d, this.f4724f) != -1;
        }

        int[] d() {
            return Arrays.copyOfRange(this.f4722c, this.f4723d, this.f4724f);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.f4722c[this.f4723d + i] != aVar.f4722c[aVar.f4723d + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i2 = this.f4723d; i2 < this.f4724f; i2++) {
                i = (i * 31) + d.e(this.f4722c[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int g;
            if (!(obj instanceof Integer) || (g = d.g(this.f4722c, ((Integer) obj).intValue(), this.f4723d, this.f4724f)) < 0) {
                return -1;
            }
            return g - this.f4723d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int h;
            if (!(obj instanceof Integer) || (h = d.h(this.f4722c, ((Integer) obj).intValue(), this.f4723d, this.f4724f)) < 0) {
                return -1;
            }
            return h - this.f4723d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4724f - this.f4723d;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i, int i2) {
            n.t(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            int[] iArr = this.f4722c;
            int i3 = this.f4723d;
            return new a(iArr, i + i3, i3 + i2);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.f4722c[this.f4723d]);
            int i = this.f4723d;
            while (true) {
                i++;
                if (i < this.f4724f) {
                    sb.append(", ");
                    sb.append(this.f4722c[i]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }
    }

    public static int c(long j) {
        int i = (int) j;
        n.h(((long) i) == j, "Out of range: %s", j);
        return i;
    }

    public static int d(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int e(int i) {
        return i;
    }

    public static int f(int[] iArr, int i) {
        return g(iArr, i, 0, iArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    public static int i(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static int[] j(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) n.o(array[i])).intValue();
        }
        return iArr;
    }
}
