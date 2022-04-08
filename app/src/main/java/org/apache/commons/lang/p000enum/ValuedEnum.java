package org.apache.commons.lang.p000enum;

import com.tplink.libtpmediastatistics.SSLClient;
import org.apache.commons.lang.d;

/* renamed from: org.apache.commons.lang.enum.ValuedEnum  reason: invalid package */
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

    @Override // org.apache.commons.lang.p000enum.Enum, java.lang.Comparable
    public int compareTo(Object obj) {
        return this.iValue - ((ValuedEnum) obj).iValue;
    }

    public final int getValue() {
        return this.iValue;
    }

    @Override // org.apache.commons.lang.p000enum.Enum
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
