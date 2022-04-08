package io.netty.handler.codec.socksx.v4;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
public class Socks4CommandType implements Comparable<Socks4CommandType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks4CommandType CONNECT = new Socks4CommandType(1, "CONNECT");
    public static final Socks4CommandType BIND = new Socks4CommandType(2, "BIND");

    public Socks4CommandType(int i) {
        this(i, "UNKNOWN");
    }

    public static Socks4CommandType valueOf(byte b2) {
        if (b2 == 1) {
            return CONNECT;
        }
        if (b2 != 2) {
            return new Socks4CommandType(b2);
        }
        return BIND;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks4CommandType) && this.byteValue == ((Socks4CommandType) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        String str2 = this.name + '(' + (this.byteValue & 255) + ')';
        this.text = str2;
        return str2;
    }

    public Socks4CommandType(int i, String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.byteValue = (byte) i;
    }

    public int compareTo(Socks4CommandType socks4CommandType) {
        return this.byteValue - socks4CommandType.byteValue;
    }
}
