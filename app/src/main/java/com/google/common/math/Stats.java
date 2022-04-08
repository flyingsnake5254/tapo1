package com.google.common.math;

import com.github.mikephil.charting.utils.Utils;
import com.google.common.base.j;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.primitives.b;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Stats(long j, double d2, double d3, double d4, double d5) {
        this.count = j;
        this.mean = d2;
        this.sumOfSquaresOfDeltas = d3;
        this.min = d4;
        this.max = d5;
    }

    public static Stats fromByteArray(byte[] bArr) {
        n.o(bArr);
        n.g(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        g gVar = new g();
        gVar.b(iterable);
        return gVar.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Stats readFrom(ByteBuffer byteBuffer) {
        n.o(byteBuffer);
        n.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
    }

    public int hashCode() {
        return k.b(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    public double max() {
        n.u(this.count != 0);
        return this.max;
    }

    public double mean() {
        n.u(this.count != 0);
        return this.mean;
    }

    public double min() {
        n.u(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        n.u(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return this.count == 1 ? Utils.DOUBLE_EPSILON : b.a(this.sumOfSquaresOfDeltas) / count();
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        n.u(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return b.a(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(order);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            return j.b(this).c("count", this.count).a("mean", this.mean).a("populationStandardDeviation", populationStandardDeviation()).a("min", this.min).a("max", this.max).toString();
        }
        return j.b(this).c("count", this.count).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTo(ByteBuffer byteBuffer) {
        n.o(byteBuffer);
        n.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static double meanOf(Iterator<? extends Number> it) {
        n.d(it.hasNext());
        double doubleValue = ((Number) it.next()).doubleValue();
        long j = 1;
        while (it.hasNext()) {
            double doubleValue2 = ((Number) it.next()).doubleValue();
            j++;
            doubleValue = (!b.f(doubleValue2) || !b.f(doubleValue)) ? g.g(doubleValue, doubleValue2) : doubleValue + ((doubleValue2 - doubleValue) / j);
        }
        return doubleValue;
    }

    public static Stats of(Iterator<? extends Number> it) {
        g gVar = new g();
        gVar.c(it);
        return gVar.h();
    }

    public static Stats of(double... dArr) {
        g gVar = new g();
        gVar.d(dArr);
        return gVar.h();
    }

    public static double meanOf(double... dArr) {
        n.d(dArr.length > 0);
        double d2 = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            double d3 = dArr[i];
            d2 = (!b.f(d3) || !b.f(d2)) ? g.g(d2, d3) : d2 + ((d3 - d2) / (i + 1));
        }
        return d2;
    }

    public static Stats of(int... iArr) {
        g gVar = new g();
        gVar.e(iArr);
        return gVar.h();
    }

    public static Stats of(long... jArr) {
        g gVar = new g();
        gVar.f(jArr);
        return gVar.h();
    }

    public static double meanOf(int... iArr) {
        n.d(iArr.length > 0);
        double d2 = iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            double d3 = iArr[i];
            d2 = (!b.f(d3) || !b.f(d2)) ? g.g(d2, d3) : d2 + ((d3 - d2) / (i + 1));
        }
        return d2;
    }

    public static double meanOf(long... jArr) {
        n.d(jArr.length > 0);
        double d2 = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            double d3 = jArr[i];
            d2 = (!b.f(d3) || !b.f(d2)) ? g.g(d2, d3) : d2 + ((d3 - d2) / (i + 1));
        }
        return d2;
    }
}
