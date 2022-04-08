package org.apache.commons.lang.enums;

import com.tplink.libtpmediastatistics.SSLClient;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.lang.d;

/* loaded from: classes4.dex */
public abstract class ValuedEnum extends Enum {
    private static final long serialVersionUID = -7129650521543789085L;
    private final int iValue;

    protected ValuedEnum(String str, int i) {
        super(str);
        this.iValue = i;
    }

    protected static Enum getEnum(Class cls, int i) {
        if (cls != null) {
            for (ValuedEnum valuedEnum : Enum.getEnumList(cls)) {
                if (valuedEnum.getValue() == i) {
                    return valuedEnum;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("The Enum Class must not be null");
    }

    private int getValueInOtherClassLoader(Object obj) {
        try {
            return ((Integer) obj.getClass().getMethod("getValue", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            throw new IllegalStateException("This should not happen");
        }
    }

    @Override // org.apache.commons.lang.enums.Enum, java.lang.Comparable
    public int compareTo(Object obj) {
        int i;
        int i2;
        if (obj == this) {
            return 0;
        }
        if (obj.getClass() == getClass()) {
            i = this.iValue;
            i2 = ((ValuedEnum) obj).iValue;
        } else if (obj.getClass().getName().equals(getClass().getName())) {
            i = this.iValue;
            i2 = getValueInOtherClassLoader(obj);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Different enum class '");
            stringBuffer.append(d.c(obj.getClass()));
            stringBuffer.append("'");
            throw new ClassCastException(stringBuffer.toString());
        }
        return i - i2;
    }

    public final int getValue() {
        return this.iValue;
    }

    @Override // org.apache.commons.lang.enums.Enum
    public String toString() {
        if (this.iToString == null) {
            String c2 = d.c(getEnumClass());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(c2);
            stringBuffer.append("[");
            stringBuffer.append(getName());
            stringBuffer.append(SSLClient.EQUALS);
            stringBuffer.append(getValue());
            stringBuffer.append("]");
            this.iToString = stringBuffer.toString();
        }
        return this.iToString;
    }
}
