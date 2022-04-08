package org.apache.commons.lang.math;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import org.apache.commons.lang.text.b;

/* loaded from: classes4.dex */
public final class IntRange extends b implements Serializable {
    private static final long serialVersionUID = 71849363892730L;
    private transient int hashCode;
    private final int max;
    private transient Integer maxObject;
    private final int min;
    private transient Integer minObject;
    private transient String toString;

    public IntRange(int i) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        this.min = i;
        this.max = i;
    }

    @Override // org.apache.commons.lang.math.b
    public boolean containsInteger(int i) {
        return i >= this.min && i <= this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsInteger(number.intValue());
    }

    @Override // org.apache.commons.lang.math.b
    public boolean containsRange(b bVar) {
        return bVar != null && containsInteger(bVar.getMinimumInteger()) && containsInteger(bVar.getMaximumInteger());
    }

    @Override // org.apache.commons.lang.math.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntRange)) {
            return false;
        }
        IntRange intRange = (IntRange) obj;
        return this.min == intRange.min && this.max == intRange.max;
    }

    @Override // org.apache.commons.lang.math.b
    public double getMaximumDouble() {
        return this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public float getMaximumFloat() {
        return this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public int getMaximumInteger() {
        return this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public long getMaximumLong() {
        return this.max;
    }

    @Override // org.apache.commons.lang.math.b
    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Integer(this.max);
        }
        return this.maxObject;
    }

    @Override // org.apache.commons.lang.math.b
    public double getMinimumDouble() {
        return this.min;
    }

    @Override // org.apache.commons.lang.math.b
    public float getMinimumFloat() {
        return this.min;
    }

    @Override // org.apache.commons.lang.math.b
    public int getMinimumInteger() {
        return this.min;
    }

    @Override // org.apache.commons.lang.math.b
    public long getMinimumLong() {
        return this.min;
    }

    @Override // org.apache.commons.lang.math.b
    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Integer(this.min);
        }
        return this.minObject;
    }

    @Override // org.apache.commons.lang.math.b
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            int hashCode = (17 * 37) + IntRange.class.hashCode();
            this.hashCode = hashCode;
            int i = (hashCode * 37) + this.min;
            this.hashCode = i;
            this.hashCode = (i * 37) + this.max;
        }
        return this.hashCode;
    }

    @Override // org.apache.commons.lang.math.b
    public boolean overlapsRange(b bVar) {
        if (bVar == null) {
            return false;
        }
        return bVar.containsInteger(this.min) || bVar.containsInteger(this.max) || containsInteger(bVar.getMinimumInteger());
    }

    public int[] toArray() {
        int i = (this.max - this.min) + 1;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.min + i2;
        }
        return iArr;
    }

    @Override // org.apache.commons.lang.math.b
    public String toString() {
        if (this.toString == null) {
            b bVar = new b(32);
            bVar.f("Range[");
            bVar.c(this.min);
            bVar.a(StringUtil.COMMA);
            bVar.c(this.max);
            bVar.a(']');
            this.toString = bVar.toString();
        }
        return this.toString;
    }

    public IntRange(Number number) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (number != null) {
            this.min = number.intValue();
            this.max = number.intValue();
            if (number instanceof Integer) {
                Integer num = (Integer) number;
                this.minObject = num;
                this.maxObject = num;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The number must not be null");
    }

    public IntRange(int i, int i2) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (i2 < i) {
            this.min = i2;
            this.max = i;
            return;
        }
        this.min = i;
        this.max = i2;
    }

    public IntRange(Number number, Number number2) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        int intValue = number.intValue();
        int intValue2 = number2.intValue();
        if (intValue2 < intValue) {
            this.min = intValue2;
            this.max = intValue;
            if (number2 instanceof Integer) {
                this.minObject = (Integer) number2;
            }
            if (number instanceof Integer) {
                this.maxObject = (Integer) number;
                return;
            }
            return;
        }
        this.min = intValue;
        this.max = intValue2;
        if (number instanceof Integer) {
            this.minObject = (Integer) number;
        }
        if (number2 instanceof Integer) {
            this.maxObject = (Integer) number2;
        }
    }
}
