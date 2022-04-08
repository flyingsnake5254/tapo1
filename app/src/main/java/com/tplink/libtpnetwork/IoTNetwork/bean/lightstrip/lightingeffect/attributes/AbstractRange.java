package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

import java.lang.Number;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public abstract class AbstractRange<T extends Number> {
    public static AbstractRange newInstance(String str) {
        if (str.equalsIgnoreCase(Integer.class.getSimpleName())) {
            return new IntegerRange();
        }
        if (str.equals(Long.class.getSimpleName())) {
            return new LongRange();
        }
        if (str.equals(Double.class.getSimpleName())) {
            return new DoubleRange();
        }
        return null;
    }

    public abstract T getFrom();

    public String getNumberType() {
        return ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
    }

    public abstract T getTo();

    public boolean isInRange(T t) {
        if (t == null) {
            return false;
        }
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(t));
        return bigDecimal.compareTo(new BigDecimal(String.valueOf(getFrom()))) >= 0 && bigDecimal.compareTo(new BigDecimal(String.valueOf(getTo()))) <= 0;
    }

    public boolean isValid() {
        return new BigDecimal(String.valueOf(getFrom())).compareTo(new BigDecimal(String.valueOf(getTo()))) <= 0;
    }

    public abstract void setFrom(T t);

    public abstract void setTo(T t);

    public AbstractRange<T> clone() {
        AbstractRange<T> newInstance = newInstance(getNumberType());
        newInstance.setFrom(getFrom());
        newInstance.setTo(getTo());
        return newInstance;
    }
}
