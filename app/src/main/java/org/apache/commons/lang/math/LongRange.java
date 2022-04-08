package org.apache.commons.lang.math;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import org.apache.commons.lang.text.b;

/* loaded from: classes4.dex */
public final class LongRange extends b implements Serializable {
    private static final long serialVersionUID = 71849363892720L;
    private transient int hashCode;
    private final long max;
    private transient Long maxObject;
    private final long min;
    private transient Long minObject;
    private transient String toString;

    public LongRange(long j) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        this.min = j;
        this.max = j;
    }

    @Override // org.apache.commons.lang.math.b
    public boolean containsLong(long j) {
        return j >= this.min && j <= this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsLong(number.longValue());
    }

    @Override // org.apache.commons.lang.math.b
    public boolean containsRange(b bVar) {
        return bVar != null && containsLong(bVar.getMinimumLong()) && containsLong(bVar.getMaximumLong());
    }

    @Override // org.apache.commons.lang.math.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LongRange)) {
            return false;
        }
        LongRange longRange = (LongRange) obj;
        return this.min == longRange.min && this.max == longRange.max;
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
        return this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Long(this.max);
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
        return this.min;
    }

    @Override // org.apache.commons.lang.math.b
    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Long(this.min);
        }
        return this.minObject;
    }

    @Override // org.apache.commons.lang.math.b
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            int hashCode = (17 * 37) + LongRange.class.hashCode();
            this.hashCode = hashCode;
            long j = this.min;
            int i = (hashCode * 37) + ((int) (j ^ (j >> 32)));
            this.hashCode = i;
            long j2 = this.max;
            this.hashCode = (i * 37) + ((int) (j2 ^ (j2 >> 32)));
        }
        return this.hashCode;
    }

    @Override // org.apache.commons.lang.math.b
    public boolean overlapsRange(b bVar) {
        if (bVar == null) {
            return false;
        }
        return bVar.containsLong(this.min) || bVar.containsLong(this.max) || containsLong(bVar.getMinimumLong());
    }

    public long[] toArray() {
        int i = (int) ((this.max - this.min) + 1);
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = this.min + i2;
        }
        return jArr;
    }

    @Override // org.apache.commons.lang.math.b
    public String toString() {
        if (this.toString == null) {
            b bVar = new b(32);
            bVar.f("Range[");
            bVar.d(this.min);
            bVar.a(StringUtil.COMMA);
            bVar.d(this.max);
            bVar.a(']');
            this.toString = bVar.toString();
        }
        return this.toString;
    }

    public LongRange(Number number) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (number != null) {
            this.min = number.longValue();
            this.max = number.longValue();
            if (number instanceof Long) {
                Long l = (Long) number;
                this.minObject = l;
                this.maxObject = l;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The number must not be null");
    }

    public LongRange(long j, long j2) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (j2 < j) {
            this.min = j2;
            this.max = j;
            return;
        }
        this.min = j;
        this.max = j2;
    }

    public LongRange(Number number, Number number2) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        long longValue = number.longValue();
        long longValue2 = number2.longValue();
        if (longValue2 < longValue) {
            this.min = longValue2;
            this.max = longValue;
            if (number2 instanceof Long) {
                this.minObject = (Long) number2;
            }
            if (number instanceof Long) {
                this.maxObject = (Long) number;
                return;
            }
            return;
        }
        this.min = longValue;
        this.max = longValue2;
        if (number instanceof Long) {
            this.minObject = (Long) number;
        }
        if (number2 instanceof Long) {
            this.maxObject = (Long) number2;
        }
    }
}
