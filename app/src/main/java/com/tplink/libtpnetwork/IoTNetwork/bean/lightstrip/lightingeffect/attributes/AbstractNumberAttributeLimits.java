package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

import java.lang.Number;
import java.lang.reflect.ParameterizedType;

/* loaded from: classes3.dex */
public abstract class AbstractNumberAttributeLimits<T extends Number> {
    public static AbstractNumberAttributeLimits newInstance(String str) {
        if (str.equalsIgnoreCase(Integer.class.getSimpleName())) {
            return new IntegerAttributeLimits();
        }
        if (str.equals(Long.class.getSimpleName())) {
            return new LongAttributeLimits();
        }
        if (str.equals(Double.class.getSimpleName())) {
            return new DoubleAttributeLimits();
        }
        return null;
    }

    public abstract AbstractRange<T> getAbsolute();

    public String getNumberType() {
        return ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
    }

    public abstract AbstractRangeLimit<T> getRange();

    public boolean isSatisfied(AbstractNumberAttributeValue<T> abstractNumberAttributeValue) {
        if (abstractNumberAttributeValue == null) {
            return false;
        }
        T absolute = abstractNumberAttributeValue.getAbsolute();
        AbstractRange<T> range = abstractNumberAttributeValue.getRange();
        AbstractRange<T> absolute2 = getAbsolute();
        AbstractRangeLimit<T> range2 = getRange();
        if (absolute == null || absolute2 == null || absolute2.isInRange(absolute)) {
            return range == null || range2 == null || range2.isSatisfied(range);
        }
        return false;
    }

    public boolean isValid() {
        AbstractRange<T> absolute = getAbsolute();
        AbstractRangeLimit<T> range = getRange();
        return (absolute == null || absolute.isValid()) && (range == null || range.isValid());
    }

    public abstract void setAbsolute(AbstractRange<T> abstractRange);

    public abstract void setRange(AbstractRangeLimit<T> abstractRangeLimit);

    public AbstractNumberAttributeLimits<T> clone() {
        AbstractNumberAttributeLimits<T> newInstance = newInstance(getNumberType());
        newInstance.setAbsolute(getAbsolute().clone());
        newInstance.setRange(getRange().clone());
        return newInstance;
    }
}
