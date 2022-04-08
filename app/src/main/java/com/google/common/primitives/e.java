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

/* compiled from: Longs.java */
/* loaded from: classes2.dex */
public final class e {

    /* compiled from: Longs.java */
    /* loaded from: classes2.dex */
    private static class a extends AbstractList<Long> implements RandomAccess, Serializable {

        /* renamed from: c  reason: collision with root package name */
        final long[] f4725c;

        /* renamed from: d  reason: collision with root package name */
        final int f4726d;

        /* renamed from: f  reason: collision with root package name */
        final int f4727f;

        a(long[] jArr, int i, int i2) {
            this.f4725c = jArr;
            this.f4726d = i;
            this.f4727f = i2;
        }

        /* renamed from: a */
        public Long get(int i) {
            n.m(i, size());
            return Long.valueOf(this.f4725c[this.f4726d + i]);
        }

        /* renamed from: b */
        public Long set(int i, Long l) {
            n.m(i, size());
            long[] jArr = this.f4725c;
            int i2 = this.f4726d;
            long j = jArr[i2 + i];
            jArr[i2 + i] = ((Long) n.o(l)).longValue();
            return Long.valueOf(j);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Long) && e.f(this.f4725c, ((Long) obj).longValue(), this.f4726d, this.f4727f) != -1;
        }

        long[] d() {
            return Arrays.copyOfRange(this.f4725c, this.f4726d, this.f4727f);
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
                if (this.f4725c[this.f4726d + i] != aVar.f4725c[aVar.f4726d + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i2 = this.f4726d; i2 < this.f4727f; i2++) {
                i = (i * 31) + e.e(this.f4725c[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int f2;
            if (!(obj instanceof Long) || (f2 = e.f(this.f4725c, ((Long) obj).longValue(), this.f4726d, this.f4727f)) < 0) {
                return -1;
            }
            return f2 - this.f4726d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int g;
            if (!(obj instanceof Long) || (g = e.g(this.f4725c, ((Long) obj).longValue(), this.f4726d, this.f4727f)) < 0) {
                return -1;
            }
            return g - this.f4726d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4727f - this.f4726d;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i, int i2) {
            n.t(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            long[] jArr = this.f4725c;
            int i3 = this.f4726d;
            return new a(jArr, i + i3, i3 + i2);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
            sb.append('[');
            sb.append(this.f4725c[this.f4726d]);
            int i = this.f4726d;
            while (true) {
                i++;
                if (i < this.f4727f) {
                    sb.append(", ");
                    sb.append(this.f4725c[i]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }
    }

    public static int c(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static long d(byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9) {
        return ((b3 & 255) << 48) | ((b2 & 255) << 56) | ((b4 & 255) << 40) | ((b5 & 255) << 32) | ((b6 & 255) << 24) | ((b7 & 255) << 16) | ((b8 & 255) << 8) | (b9 & 255);
    }

    public static int e(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(long[] jArr, long j, int i, int i2) {
        while (i < i2) {
            if (jArr[i] == j) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(long[] jArr, long j, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (jArr[i3] == j) {
                return i3;
            }
        }
        return -1;
    }

    public static long h(long... jArr) {
        n.d(jArr.length > 0);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] > j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static long[] i(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = ((Number) n.o(array[i])).longValue();
        }
        return jArr;
    }
}
