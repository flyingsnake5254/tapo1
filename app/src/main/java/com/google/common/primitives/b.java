package com.google.common.primitives;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* compiled from: Doubles.java */
/* loaded from: classes2.dex */
public final class b {
    static final Pattern a = c();

    /* compiled from: Doubles.java */
    /* loaded from: classes2.dex */
    private static class a extends AbstractList<Double> implements RandomAccess, Serializable {

        /* renamed from: c  reason: collision with root package name */
        final double[] f4719c;

        /* renamed from: d  reason: collision with root package name */
        final int f4720d;

        /* renamed from: f  reason: collision with root package name */
        final int f4721f;

        a(double[] dArr, int i, int i2) {
            this.f4719c = dArr;
            this.f4720d = i;
            this.f4721f = i2;
        }

        /* renamed from: a */
        public Double get(int i) {
            n.m(i, size());
            return Double.valueOf(this.f4719c[this.f4720d + i]);
        }

        /* renamed from: b */
        public Double set(int i, Double d2) {
            n.m(i, size());
            double[] dArr = this.f4719c;
            int i2 = this.f4720d;
            double d3 = dArr[i2 + i];
            dArr[i2 + i] = ((Double) n.o(d2)).doubleValue();
            return Double.valueOf(d3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Double) && b.e(this.f4719c, ((Double) obj).doubleValue(), this.f4720d, this.f4721f) != -1;
        }

        double[] d() {
            return Arrays.copyOfRange(this.f4719c, this.f4720d, this.f4721f);
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
                if (this.f4719c[this.f4720d + i] != aVar.f4719c[aVar.f4720d + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i2 = this.f4720d; i2 < this.f4721f; i2++) {
                i = (i * 31) + b.d(this.f4719c[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int e2;
            if (!(obj instanceof Double) || (e2 = b.e(this.f4719c, ((Double) obj).doubleValue(), this.f4720d, this.f4721f)) < 0) {
                return -1;
            }
            return e2 - this.f4720d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int g;
            if (!(obj instanceof Double) || (g = b.g(this.f4719c, ((Double) obj).doubleValue(), this.f4720d, this.f4721f)) < 0) {
                return -1;
            }
            return g - this.f4720d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4721f - this.f4720d;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i, int i2) {
            n.t(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            double[] dArr = this.f4719c;
            int i3 = this.f4720d;
            return new a(dArr, i + i3, i3 + i2);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
            sb.append('[');
            sb.append(this.f4719c[this.f4720d]);
            int i = this.f4720d;
            while (true) {
                i++;
                if (i < this.f4721f) {
                    sb.append(", ");
                    sb.append(this.f4719c[i]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }
    }

    private static Pattern c() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + ")").replace(MqttTopic.MULTI_LEVEL_WILDCARD, MqttTopic.SINGLE_LEVEL_WILDCARD));
    }

    public static int d(double d2) {
        return Double.valueOf(d2).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(double[] dArr, double d2, int i, int i2) {
        while (i < i2) {
            if (dArr[i] == d2) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean f(double d2) {
        return Double.NEGATIVE_INFINITY < d2 && d2 < Double.POSITIVE_INFINITY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(double[] dArr, double d2, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (dArr[i3] == d2) {
                return i3;
            }
        }
        return -1;
    }

    public static double[] h(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = ((Number) n.o(array[i])).doubleValue();
        }
        return dArr;
    }
}
