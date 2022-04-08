package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.a;
import java.math.BigInteger;

/* compiled from: JsonPrimitive.java */
/* loaded from: classes2.dex */
public final class m extends i {
    private final Object a;

    public m(Boolean bool) {
        this.a = a.b(bool);
    }

    private static boolean o(m mVar) {
        Object obj = mVar.a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // com.google.gson.i
    public int a() {
        return p() ? m().intValue() : Integer.parseInt(e());
    }

    @Override // com.google.gson.i
    public String e() {
        if (p()) {
            return m().toString();
        }
        if (n()) {
            return ((Boolean) this.a).toString();
        }
        return (String) this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (this.a == null) {
            return mVar.a == null;
        }
        if (o(this) && o(mVar)) {
            return m().longValue() == mVar.m().longValue();
        }
        Object obj2 = this.a;
        if (!(obj2 instanceof Number) || !(mVar.a instanceof Number)) {
            return obj2.equals(mVar.a);
        }
        double doubleValue = m().doubleValue();
        double doubleValue2 = mVar.m().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (o(this)) {
            doubleToLongBits = m().longValue();
        } else {
            Object obj = this.a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(m().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean j() {
        if (n()) {
            return ((Boolean) this.a).booleanValue();
        }
        return Boolean.parseBoolean(e());
    }

    public double k() {
        return p() ? m().doubleValue() : Double.parseDouble(e());
    }

    public long l() {
        return p() ? m().longValue() : Long.parseLong(e());
    }

    public Number m() {
        Object obj = this.a;
        return obj instanceof String ? new LazilyParsedNumber((String) this.a) : (Number) obj;
    }

    public boolean n() {
        return this.a instanceof Boolean;
    }

    public boolean p() {
        return this.a instanceof Number;
    }

    public boolean q() {
        return this.a instanceof String;
    }

    public m(Number number) {
        this.a = a.b(number);
    }

    public m(String str) {
        this.a = a.b(str);
    }
}
