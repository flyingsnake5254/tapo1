package org.bouncycastle.crypto.tls;

import io.netty.handler.codec.dns.DnsRecord;
import java.io.IOException;
import org.bouncycastle.util.i;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

/* loaded from: classes4.dex */
public final class x {
    public static final x a = new x(768, "SSL 3.0");

    /* renamed from: b  reason: collision with root package name */
    public static final x f17283b = new x(769, "TLS 1.0");

    /* renamed from: c  reason: collision with root package name */
    public static final x f17284c = new x(770, "TLS 1.1");

    /* renamed from: d  reason: collision with root package name */
    public static final x f17285d = new x(771, "TLS 1.2");

    /* renamed from: e  reason: collision with root package name */
    public static final x f17286e = new x(65279, "DTLS 1.0");

    /* renamed from: f  reason: collision with root package name */
    public static final x f17287f = new x(65277, "DTLS 1.2");
    private int g;
    private String h;

    private x(int i, String str) {
        this.g = i & 65535;
        this.h = str;
    }

    public static x b(int i, int i2) throws IOException {
        String str;
        if (i != 3) {
            if (i == 254) {
                switch (i2) {
                    case 253:
                        return f17287f;
                    case DnsRecord.CLASS_NONE /* 254 */:
                        throw new TlsFatalAlert((short) 47);
                    case 255:
                        return f17286e;
                    default:
                        str = "DTLS";
                        break;
                }
            } else {
                throw new TlsFatalAlert((short) 47);
            }
        } else if (i2 == 0) {
            return a;
        } else {
            if (i2 == 1) {
                return f17283b;
            }
            if (i2 == 2) {
                return f17284c;
            }
            if (i2 == 3) {
                return f17285d;
            }
            str = SSLSocketFactoryFactory.DEFAULT_PROTOCOL;
        }
        return f(i, i2, str);
    }

    private static x f(int i, int i2, String str) throws IOException {
        m1.k(i);
        m1.k(i2);
        int i3 = (i << 8) | i2;
        String j = i.j(Integer.toHexString(65536 | i3).substring(1));
        return new x(i3, str + " 0x" + j);
    }

    public boolean a(x xVar) {
        return xVar != null && this.g == xVar.g;
    }

    public x c() {
        return !g() ? this : this == f17286e ? f17284c : f17285d;
    }

    public int d() {
        return this.g >> 8;
    }

    public int e() {
        return this.g & 255;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof x) && a((x) obj));
    }

    public boolean g() {
        return d() == 254;
    }

    public boolean h(x xVar) {
        if (d() != xVar.d()) {
            return false;
        }
        int e2 = xVar.e() - e();
        if (g()) {
            if (e2 > 0) {
                return false;
            }
        } else if (e2 < 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.g;
    }

    public boolean i() {
        return this == a;
    }

    public String toString() {
        return this.h;
    }
}
