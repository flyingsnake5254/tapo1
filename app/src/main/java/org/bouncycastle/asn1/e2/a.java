package org.bouncycastle.asn1.e2;

import e.a.b.a.d;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.asn1.u2.k;
import org.bouncycastle.asn1.u2.l;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class a {
    static k a = new C0330a();

    /* renamed from: b  reason: collision with root package name */
    static k f16729b = new b();

    /* renamed from: c  reason: collision with root package name */
    static final Hashtable f16730c = new Hashtable();

    /* renamed from: d  reason: collision with root package name */
    static final Hashtable f16731d = new Hashtable();

    /* renamed from: e  reason: collision with root package name */
    static final Hashtable f16732e = new Hashtable();

    /* renamed from: org.bouncycastle.asn1.e2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0330a extends k {
        C0330a() {
        }

        @Override // org.bouncycastle.asn1.u2.k
        protected j a() {
            BigInteger e2 = a.e("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF");
            BigInteger e3 = a.e("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC");
            BigInteger e4 = a.e("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93");
            BigInteger e5 = a.e("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123");
            BigInteger valueOf = BigInteger.valueOf(1L);
            d c2 = a.c(new d.f(e2, e3, e4, e5, valueOf));
            return new j(c2, new l(c2, org.bouncycastle.util.encoders.d.a("0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0")), e5, valueOf, (byte[]) null);
        }
    }

    /* loaded from: classes4.dex */
    static class b extends k {
        b() {
        }

        @Override // org.bouncycastle.asn1.u2.k
        protected j a() {
            BigInteger e2 = a.e("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F");
            BigInteger e3 = a.e("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985");
            BigInteger e4 = a.e("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1");
            BigInteger e5 = a.e("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677");
            BigInteger valueOf = BigInteger.valueOf(1L);
            d c2 = a.c(new d.f(e2, e3, e4, e5, valueOf));
            return new j(c2, new l(c2, org.bouncycastle.util.encoders.d.a("044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2")), e5, valueOf, (byte[]) null);
        }
    }

    static {
        d("wapip192v1", b.J, f16729b);
        d("sm2p256v1", b.F, a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static d c(d dVar) {
        return dVar;
    }

    static void d(String str, m mVar, k kVar) {
        f16730c.put(i.f(str), mVar);
        f16732e.put(mVar, str);
        f16731d.put(mVar, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BigInteger e(String str) {
        return new BigInteger(1, org.bouncycastle.util.encoders.d.a(str));
    }

    public static j f(String str) {
        m i = i(str);
        if (i == null) {
            return null;
        }
        return g(i);
    }

    public static j g(m mVar) {
        k kVar = (k) f16731d.get(mVar);
        if (kVar == null) {
            return null;
        }
        return kVar.b();
    }

    public static String h(m mVar) {
        return (String) f16732e.get(mVar);
    }

    public static m i(String str) {
        return (m) f16730c.get(i.f(str));
    }
}
