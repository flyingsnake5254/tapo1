package org.apache.commons.lang.math;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import org.apache.commons.lang.text.b;

/* loaded from: classes4.dex */
public final class DoubleRange extends b implements Serializable {
    private static final long serialVersionUID = 71849363892740L;
    private transient int hashCode;
    private final double max;
    private transient Double maxObject;
    private final double min;
    private transient Double minObject;
    private transient String toString;

    public DoubleRange(double d2) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (!Double.isNaN(d2)) {
            this.min = d2;
            this.max = d2;
            return;
        }
        throw new IllegalArgumentException("The number must not be NaN");
    }

    @Override // org.apache.commons.lang.math.b
    public boolean containsDouble(double d2) {
        return d2 >= this.min && d2 <= this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsDouble(number.doubleValue());
    }

    @Override // org.apache.commons.lang.math.b
    public boolean containsRange(b bVar) {
        return bVar != null && containsDouble(bVar.getMinimumDouble()) && containsDouble(bVar.getMaximumDouble());
    }

    @Override // org.apache.commons.lang.math.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DoubleRange)) {
            return false;
        }
        DoubleRange doubleRange = (DoubleRange) obj;
        return Double.doubleToLongBits(this.min) == Double.doubleToLongBits(doubleRange.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(doubleRange.max);
    }

    @Override // org.apache.commons.lang.math.b
    public double getMaximumDouble() {
        return this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public float getMaximumFloat() {
        return (float) this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public int getMaximumInteger() {
        return (int) this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public long getMaximumLong() {
        return (long) this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Double(this.max);
        }
        return this.maxObject;
    }

    @Override // org.apache.commons.lang.math.b
    public double getMinimumDouble() {
        return this.min;
    }

    @Override // org.apache.commons.lang.math.b
    public float getMinimumFloat() {
        return (float) this.min;
    }

    @Override // org.apache.commons.lang.math.b
    public int getMinimumInteger() {
        return (int) this.min;
    }

    @Override // org.apache.commons.lang.math.b
    public long getMinimumLong() {
        return (long) this.min;
    }

    @Override // org.apache.commons.lang.math.b
    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Double(this.min);
        }
        return this.minObject;
    }

    @Override // org.apache.commons.lang.math.b
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = (17 * 37) + DoubleRange.class.hashCode();
            long doubleToLongBits = Double.doubleToLongBits(this.min);
            this.hashCode = (this.hashCode * 37) + ((int) (doubleToLongBits ^ (doubleToLongBits >> 32)));
            long doubleToLongBits2 = Double.doubleToLongBits(this.max);
            this.hashCode = (this.hashCode * 37) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >> 32)));
        }
        return this.hashCode;
    }

    @Override // org.apache.commons.lang.math.b
    public boolean overlapsRange(b bVar) {
        if (bVar == null) {
            return false;
        }
        return bVar.containsDouble(this.min) || bVar.containsDouble(this.max) || containsDouble(bVar.getMinimumDouble());
    }

    @Override // org.apache.commons.lang.math.b
    public String toString() {
        if (this.toString == null) {
            b bVar = new b(32);
            bVar.f("Range[");
            bVar.b(this.min);
            bVar.a(StringUtil.COMMA);
            bVar.b(this.max);
            bVar.a(']');
            this.toString = bVar.toString();
        }
        return this.toString;
    }

    public DoubleRange(Number number) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (number != null) {
            double doubleValue = number.doubleValue();
            this.min = doubleValue;
            double doubleValue2 = number.doubleValue();
            this.max = doubleValue2;
            if (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2)) {
                throw new IllegalArgumentException("The number must not be NaN");
            } else if (number instanceof Double) {
                Double d2 = (Double) number;
                this.minObject = d2;
                this.maxObject = d2;
            }
        } else {
            throw new IllegalArgumentException("The number must not be null");
        }
    }

    public DoubleRange(double d2, double d3) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (Double.isNaN(d2) || Double.isNaN(d3)) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        } else if (d3 < d2) {
            this.min = d3;
            this.max = d2;
        } else {
            this.min = d2;
            this.max = d3;
        }
    }

    public DoubleRange(Number number, Number number2) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        double doubleValue = number.doubleValue();
        double doubleValue2 = number2.doubleValue();
        if (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2)) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        } else if (doubleValue2 < doubleValue) {
            this.min = doubleValue2;
            this.max = doubleValue;
            if (number2 instanceof Double) {
                this.minObject = (Double) number2;
            }
            if (number instanceof Double) {
                this.maxObject = (Double) number;
            }
        } else {
            this.min = doubleValue;
            this.max = doubleValue2;
            if (number instanceof Double) {
                this.minObject = (Double) number;
            }
            if (number2 instanceof Double) {
                this.maxObject = (Double) number2;
            }
        }
    }
}
