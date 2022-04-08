package com.google.common.math;

import com.github.mikephil.charting.utils.Utils;
import com.google.common.base.j;
import com.google.common.base.k;
import com.google.common.base.n;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public final class PairedStats implements Serializable {
    private static final int BYTES = 88;
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    PairedStats(Stats stats, Stats stats2, double d2) {
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d2;
    }

    private static double ensureInUnitRange(double d2) {
        if (d2 >= 1.0d) {
            return 1.0d;
        }
        if (d2 <= -1.0d) {
            return -1.0d;
        }
        return d2;
    }

    private static double ensurePositive(double d2) {
        if (d2 > Utils.DOUBLE_EPSILON) {
            return d2;
        }
        return Double.MIN_VALUE;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        n.o(bArr);
        n.g(bArr.length == 88, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.readFrom(order), Stats.readFrom(order), order.getDouble());
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == null || PairedStats.class != obj.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats) obj;
        return this.xStats.equals(pairedStats.xStats) && this.yStats.equals(pairedStats.yStats) && Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas);
    }

    public int hashCode() {
        return k.b(this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas));
    }

    public d leastSquaresFit() {
        boolean z = true;
        n.u(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return d.a();
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas <= Utils.DOUBLE_EPSILON) {
            if (this.yStats.sumOfSquaresOfDeltas() <= Utils.DOUBLE_EPSILON) {
                z = false;
            }
            n.u(z);
            return d.d(this.xStats.mean());
        } else if (this.yStats.sumOfSquaresOfDeltas() > Utils.DOUBLE_EPSILON) {
            return d.c(this.xStats.mean(), this.yStats.mean()).a(this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas);
        } else {
            return d.b(this.yStats.mean());
        }
    }

    public double pearsonsCorrelationCoefficient() {
        boolean z = true;
        n.u(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double sumOfSquaresOfDeltas = xStats().sumOfSquaresOfDeltas();
        double sumOfSquaresOfDeltas2 = yStats().sumOfSquaresOfDeltas();
        n.u(sumOfSquaresOfDeltas > Utils.DOUBLE_EPSILON);
        if (sumOfSquaresOfDeltas2 <= Utils.DOUBLE_EPSILON) {
            z = false;
        }
        n.u(z);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }

    public double populationCovariance() {
        n.u(count() != 0);
        return this.sumOfProductsOfDeltas / count();
    }

    public double sampleCovariance() {
        n.u(count() > 1);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(order);
        this.yStats.writeTo(order);
        order.putDouble(this.sumOfProductsOfDeltas);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            return j.b(this).d("xStats", this.xStats).d("yStats", this.yStats).a("populationCovariance", populationCovariance()).toString();
        }
        return j.b(this).d("xStats", this.xStats).d("yStats", this.yStats).toString();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}
