package org.bouncycastle.asn1.x509;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tplink.iot.Utils.hls.c;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.d1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t;
import org.bouncycastle.asn1.w;
import org.bouncycastle.util.encoders.d;
import org.bouncycastle.util.i;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes4.dex */
public class d0 extends l {
    public static final m H3;
    public static final m I3;
    public static final m J3;
    public static final m K3;
    public static final m L3;
    public static final m M3;
    public static final m N3;
    public static final m O3;
    public static final m P3;
    public static final m Q3;
    public static final m R3;
    public static final m S3;
    public static final m T3;
    public static final m U3;
    public static final m V3;
    public static final m X3;
    public static final m Y3;
    public static final m Z3;
    public static final m a4;
    public static final m b4;

    /* renamed from: c  reason: collision with root package name */
    public static final m f16988c;
    public static final m c4;

    /* renamed from: d  reason: collision with root package name */
    public static final m f16989d;
    public static final m d4;
    public static final m e4;

    /* renamed from: f  reason: collision with root package name */
    public static final m f16990f;
    public static final Hashtable g4;
    public static final Hashtable h4;
    public static final Hashtable i4;
    public static final Hashtable j4;
    public static final Hashtable k4;
    public static final Hashtable l4;
    public static final m p0;
    public static final m p1;
    public static final m p2;
    public static final m p3;
    public static final m q;
    public static final m x;
    public static final m y;
    public static final m z;
    private Vector o4 = new Vector();
    private Vector p4 = new Vector();
    private Vector q4 = new Vector();
    private r r4;
    private boolean s4;
    private int t4;
    public static final m W3 = new m("2.5.4.54");
    public static boolean f4 = false;
    private static final Boolean m4 = new Boolean(true);
    private static final Boolean n4 = new Boolean(false);

    static {
        m mVar = new m("2.5.4.6");
        f16988c = mVar;
        m mVar2 = new m("2.5.4.10");
        f16989d = mVar2;
        m mVar3 = new m("2.5.4.11");
        f16990f = mVar3;
        m mVar4 = new m("2.5.4.12");
        q = mVar4;
        m mVar5 = new m("2.5.4.3");
        x = mVar5;
        m mVar6 = new m("2.5.4.5");
        y = mVar6;
        m mVar7 = new m("2.5.4.9");
        z = mVar7;
        p0 = mVar6;
        m mVar8 = new m("2.5.4.7");
        p1 = mVar8;
        m mVar9 = new m("2.5.4.8");
        p2 = mVar9;
        m mVar10 = new m("2.5.4.4");
        p3 = mVar10;
        m mVar11 = new m("2.5.4.42");
        H3 = mVar11;
        m mVar12 = new m("2.5.4.43");
        I3 = mVar12;
        m mVar13 = new m("2.5.4.44");
        J3 = mVar13;
        m mVar14 = new m("2.5.4.45");
        K3 = mVar14;
        m mVar15 = new m("2.5.4.15");
        L3 = mVar15;
        m mVar16 = new m("2.5.4.17");
        M3 = mVar16;
        m mVar17 = new m("2.5.4.46");
        N3 = mVar17;
        m mVar18 = new m("2.5.4.65");
        O3 = mVar18;
        m mVar19 = new m("1.3.6.1.5.5.7.9.1");
        P3 = mVar19;
        m mVar20 = new m("1.3.6.1.5.5.7.9.2");
        Q3 = mVar20;
        m mVar21 = new m("1.3.6.1.5.5.7.9.3");
        R3 = mVar21;
        m mVar22 = new m("1.3.6.1.5.5.7.9.4");
        S3 = mVar22;
        m mVar23 = new m("1.3.6.1.5.5.7.9.5");
        T3 = mVar23;
        m mVar24 = new m("1.3.36.8.3.14");
        U3 = mVar24;
        m mVar25 = new m("2.5.4.16");
        V3 = mVar25;
        m mVar26 = e0.g;
        X3 = mVar26;
        m mVar27 = e0.h;
        Y3 = mVar27;
        m mVar28 = g.y0;
        Z3 = mVar28;
        m mVar29 = g.z0;
        a4 = mVar29;
        m mVar30 = g.F0;
        b4 = mVar30;
        c4 = mVar28;
        m mVar31 = new m("0.9.2342.19200300.100.1.25");
        d4 = mVar31;
        m mVar32 = new m("0.9.2342.19200300.100.1.1");
        e4 = mVar32;
        Hashtable hashtable = new Hashtable();
        g4 = hashtable;
        Hashtable hashtable2 = new Hashtable();
        h4 = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        i4 = hashtable3;
        Hashtable hashtable4 = new Hashtable();
        j4 = hashtable4;
        k4 = hashtable;
        l4 = hashtable4;
        hashtable.put(mVar, "C");
        hashtable.put(mVar2, "O");
        hashtable.put(mVar4, ExifInterface.GPS_DIRECTION_TRUE);
        hashtable.put(mVar3, "OU");
        hashtable.put(mVar5, "CN");
        hashtable.put(mVar8, "L");
        hashtable.put(mVar9, "ST");
        hashtable.put(mVar6, "SERIALNUMBER");
        hashtable.put(mVar28, ExifInterface.LONGITUDE_EAST);
        hashtable.put(mVar31, "DC");
        hashtable.put(mVar32, "UID");
        hashtable.put(mVar7, "STREET");
        hashtable.put(mVar10, "SURNAME");
        hashtable.put(mVar11, "GIVENNAME");
        hashtable.put(mVar12, "INITIALS");
        hashtable.put(mVar13, "GENERATION");
        hashtable.put(mVar30, "unstructuredAddress");
        hashtable.put(mVar29, "unstructuredName");
        hashtable.put(mVar14, "UniqueIdentifier");
        hashtable.put(mVar17, "DN");
        hashtable.put(mVar18, "Pseudonym");
        hashtable.put(mVar25, "PostalAddress");
        hashtable.put(mVar24, "NameAtBirth");
        hashtable.put(mVar22, "CountryOfCitizenship");
        hashtable.put(mVar23, "CountryOfResidence");
        hashtable.put(mVar21, "Gender");
        hashtable.put(mVar20, "PlaceOfBirth");
        hashtable.put(mVar19, "DateOfBirth");
        hashtable.put(mVar16, "PostalCode");
        hashtable.put(mVar15, "BusinessCategory");
        hashtable.put(mVar26, "TelephoneNumber");
        hashtable.put(mVar27, "Name");
        hashtable2.put(mVar, "C");
        hashtable2.put(mVar2, "O");
        hashtable2.put(mVar3, "OU");
        hashtable2.put(mVar5, "CN");
        hashtable2.put(mVar8, "L");
        hashtable2.put(mVar9, "ST");
        hashtable2.put(mVar7, "STREET");
        hashtable2.put(mVar31, "DC");
        hashtable2.put(mVar32, "UID");
        hashtable3.put(mVar, "C");
        hashtable3.put(mVar2, "O");
        hashtable3.put(mVar3, "OU");
        hashtable3.put(mVar5, "CN");
        hashtable3.put(mVar8, "L");
        hashtable3.put(mVar9, "ST");
        hashtable3.put(mVar7, "STREET");
        hashtable4.put(c.n, mVar);
        hashtable4.put("o", mVar2);
        hashtable4.put("t", mVar4);
        hashtable4.put("ou", mVar3);
        hashtable4.put("cn", mVar5);
        hashtable4.put("l", mVar8);
        hashtable4.put("st", mVar9);
        hashtable4.put("sn", mVar6);
        hashtable4.put("serialnumber", mVar6);
        hashtable4.put("street", mVar7);
        hashtable4.put("emailaddress", mVar28);
        hashtable4.put("dc", mVar31);
        hashtable4.put("e", mVar28);
        hashtable4.put("uid", mVar32);
        hashtable4.put("surname", mVar10);
        hashtable4.put("givenname", mVar11);
        hashtable4.put("initials", mVar12);
        hashtable4.put("generation", mVar13);
        hashtable4.put("unstructuredaddress", mVar30);
        hashtable4.put("unstructuredname", mVar29);
        hashtable4.put("uniqueidentifier", mVar14);
        hashtable4.put("dn", mVar17);
        hashtable4.put("pseudonym", mVar18);
        hashtable4.put("postaladdress", mVar25);
        hashtable4.put("nameofbirth", mVar24);
        hashtable4.put("countryofcitizenship", mVar22);
        hashtable4.put("countryofresidence", mVar23);
        hashtable4.put("gender", mVar21);
        hashtable4.put("placeofbirth", mVar20);
        hashtable4.put("dateofbirth", mVar19);
        hashtable4.put("postalcode", mVar16);
        hashtable4.put("businesscategory", mVar15);
        hashtable4.put("telephonenumber", mVar26);
        hashtable4.put(AppMeasurementSdk.ConditionalUserProperty.NAME, mVar27);
    }

    protected d0() {
    }

    public d0(r rVar) {
        Vector vector;
        this.r4 = rVar;
        Enumeration q2 = rVar.q();
        while (q2.hasMoreElements()) {
            t n = t.n(((e) q2.nextElement()).c());
            int i = 0;
            while (i < n.size()) {
                r m = r.m(n.q(i).c());
                if (m.size() == 2) {
                    this.o4.addElement(m.r(m.p(0)));
                    e p = m.p(1);
                    if (!(p instanceof w) || (p instanceof j1)) {
                        try {
                            this.p4.addElement(MqttTopic.MULTI_LEVEL_WILDCARD + g(d.b(p.c().e("DER"))));
                        } catch (IOException unused) {
                            throw new IllegalArgumentException("cannot encode value");
                        }
                    } else {
                        String string = ((w) p).getString();
                        if (string.length() <= 0 || string.charAt(0) != '#') {
                            vector = this.p4;
                        } else {
                            vector = this.p4;
                            string = SSLClient.ESCAPE + string;
                        }
                        vector.addElement(string);
                    }
                    this.q4.addElement(i != 0 ? m4 : n4);
                    i++;
                } else {
                    throw new IllegalArgumentException("badly sized pair");
                }
            }
        }
    }

    private void f(StringBuffer stringBuffer, Hashtable hashtable, m mVar, String str) {
        String str2 = (String) hashtable.get(mVar);
        if (str2 == null) {
            str2 = mVar.q();
        }
        stringBuffer.append(str2);
        stringBuffer.append('=');
        int length = stringBuffer.length();
        stringBuffer.append(str);
        int length2 = stringBuffer.length();
        if (str.length() >= 2 && str.charAt(0) == '\\' && str.charAt(1) == '#') {
            length += 2;
        }
        while (length < length2 && stringBuffer.charAt(length) == ' ') {
            stringBuffer.insert(length, SSLClient.ESCAPE);
            length += 2;
            length2++;
        }
        while (true) {
            length2--;
            if (length2 <= length || stringBuffer.charAt(length2) != ' ') {
                break;
            }
            stringBuffer.insert(length2, '\\');
        }
        while (length <= length2) {
            char charAt = stringBuffer.charAt(length);
            if (!(charAt == '\"' || charAt == '\\' || charAt == '+' || charAt == ',')) {
                switch (charAt) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        length++;
                        continue;
                }
            }
            stringBuffer.insert(length, SSLClient.ESCAPE);
            length += 2;
            length2++;
        }
    }

    private String g(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return new String(cArr);
    }

    private String h(String str) {
        String f2 = i.f(str.trim());
        if (f2.length() <= 0 || f2.charAt(0) != '#') {
            return f2;
        }
        q i = i(f2);
        return i instanceof w ? i.f(((w) i).getString().trim()) : f2;
    }

    private q i(String str) {
        try {
            return q.i(d.a(str.substring(1)));
        } catch (IOException e2) {
            throw new IllegalStateException("unknown encoding in name: " + e2);
        }
    }

    private boolean j(String str, String str2) {
        String h = h(str);
        String h2 = h(str2);
        return h.equals(h2) || l(h).equals(l(h2));
    }

    public static d0 k(Object obj) {
        return (obj == null || (obj instanceof d0)) ? (d0) obj : obj instanceof org.bouncycastle.asn1.t2.c ? new d0(r.m(((org.bouncycastle.asn1.t2.c) obj).c())) : new d0(r.m(obj));
    }

    private String l(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            stringBuffer.append(charAt);
            int i = 1;
            while (i < str.length()) {
                char charAt2 = str.charAt(i);
                if (charAt != ' ' || charAt2 != ' ') {
                    stringBuffer.append(charAt2);
                }
                i++;
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        if (this.r4 == null) {
            f fVar = new f();
            f fVar2 = new f();
            if (this.o4.size() == 0) {
                fVar.a(new d1(fVar2));
                this.r4 = new b1(fVar);
            } else {
                new f().a((m) this.o4.elementAt(0));
                String str = (String) this.p4.elementAt(0);
                throw null;
            }
        }
        return this.r4;
    }

    @Override // org.bouncycastle.asn1.l
    public boolean equals(Object obj) {
        int i;
        int i2;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d0) && !(obj instanceof r)) {
            return false;
        }
        if (c().equals(((e) obj).c())) {
            return true;
        }
        try {
            d0 k = k(obj);
            int size = this.o4.size();
            if (size != k.o4.size()) {
                return false;
            }
            boolean[] zArr = new boolean[size];
            int i3 = -1;
            if (this.o4.elementAt(0).equals(k.o4.elementAt(0))) {
                i3 = size;
                i2 = 0;
                i = 1;
            } else {
                i2 = size - 1;
                i = -1;
            }
            while (i2 != i3) {
                m mVar = (m) this.o4.elementAt(i2);
                String str = (String) this.p4.elementAt(i2);
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        z2 = false;
                        break;
                    } else if (!zArr[i5] && mVar.equals((m) k.o4.elementAt(i5)) && j(str, (String) k.p4.elementAt(i5))) {
                        zArr[i5] = true;
                        z2 = true;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (!z2) {
                    return false;
                }
                i2 += i;
            }
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        if (this.s4) {
            return this.t4;
        }
        this.s4 = true;
        for (int i = 0; i != this.o4.size(); i++) {
            String l = l(h((String) this.p4.elementAt(i)));
            int hashCode = this.t4 ^ this.o4.elementAt(i).hashCode();
            this.t4 = hashCode;
            this.t4 = l.hashCode() ^ hashCode;
        }
        return this.t4;
    }

    public String m(boolean z2, Hashtable hashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();
        StringBuffer stringBuffer2 = null;
        for (int i = 0; i < this.o4.size(); i++) {
            if (((Boolean) this.q4.elementAt(i)).booleanValue()) {
                stringBuffer2.append('+');
                f(stringBuffer2, hashtable, (m) this.o4.elementAt(i), (String) this.p4.elementAt(i));
            } else {
                stringBuffer2 = new StringBuffer();
                f(stringBuffer2, hashtable, (m) this.o4.elementAt(i), (String) this.p4.elementAt(i));
                vector.addElement(stringBuffer2);
            }
        }
        boolean z3 = true;
        if (z2) {
            for (int size = vector.size() - 1; size >= 0; size--) {
                if (z3) {
                    z3 = false;
                } else {
                    stringBuffer.append(StringUtil.COMMA);
                }
                stringBuffer.append(vector.elementAt(size).toString());
            }
        } else {
            for (int i2 = 0; i2 < vector.size(); i2++) {
                if (z3) {
                    z3 = false;
                } else {
                    stringBuffer.append(StringUtil.COMMA);
                }
                stringBuffer.append(vector.elementAt(i2).toString());
            }
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return m(f4, g4);
    }
}
