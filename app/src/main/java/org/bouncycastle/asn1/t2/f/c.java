package org.bouncycastle.asn1.t2.f;

import com.tplink.libtpmediastatistics.SSLClient;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.j1;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.t2.a;
import org.bouncycastle.asn1.t2.b;
import org.bouncycastle.asn1.t2.e;
import org.bouncycastle.asn1.w;
import org.bouncycastle.util.encoders.d;
import org.bouncycastle.util.i;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes4.dex */
public class c {
    public static void a(StringBuffer stringBuffer, b bVar, Hashtable hashtable) {
        if (bVar.i()) {
            a[] h = bVar.h();
            boolean z = true;
            for (int i = 0; i != h.length; i++) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append('+');
                }
                b(stringBuffer, h[i], hashtable);
            }
        } else if (bVar.f() != null) {
            b(stringBuffer, bVar.f(), hashtable);
        }
    }

    public static void b(StringBuffer stringBuffer, a aVar, Hashtable hashtable) {
        String str = (String) hashtable.get(aVar.g());
        if (str == null) {
            str = aVar.g().q();
        }
        stringBuffer.append(str);
        stringBuffer.append('=');
        stringBuffer.append(q(aVar.h()));
    }

    private static boolean c(a aVar, a aVar2) {
        if (aVar == aVar2) {
            return true;
        }
        return aVar != null && aVar2 != null && aVar.g().equals(aVar2.g()) && e(q(aVar.h())).equals(e(q(aVar2.h())));
    }

    private static String d(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return new String(cArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r0 >= (r6.length() - 1)) goto L_0x006d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e(java.lang.String r6) {
        /*
            java.lang.String r6 = org.bouncycastle.util.i.f(r6)
            int r0 = r6.length()
            r1 = 0
            if (r0 <= 0) goto L_0x0025
            char r0 = r6.charAt(r1)
            r2 = 35
            if (r0 != r2) goto L_0x0025
            org.bouncycastle.asn1.q r0 = h(r6)
            boolean r2 = r0 instanceof org.bouncycastle.asn1.w
            if (r2 == 0) goto L_0x0025
            org.bouncycastle.asn1.w r0 = (org.bouncycastle.asn1.w) r0
            java.lang.String r6 = r0.getString()
            java.lang.String r6 = org.bouncycastle.util.i.f(r6)
        L_0x0025:
            int r0 = r6.length()
            r2 = 1
            if (r0 <= r2) goto L_0x006d
        L_0x002c:
            int r0 = r1 + 1
            int r3 = r6.length()
            r4 = 32
            r5 = 92
            if (r0 >= r3) goto L_0x0047
            char r3 = r6.charAt(r1)
            if (r3 != r5) goto L_0x0047
            char r0 = r6.charAt(r0)
            if (r0 != r4) goto L_0x0047
            int r1 = r1 + 2
            goto L_0x002c
        L_0x0047:
            int r0 = r6.length()
            int r0 = r0 - r2
        L_0x004c:
            int r3 = r0 + (-1)
            if (r3 <= 0) goto L_0x005f
            char r3 = r6.charAt(r3)
            if (r3 != r5) goto L_0x005f
            char r3 = r6.charAt(r0)
            if (r3 != r4) goto L_0x005f
            int r0 = r0 + (-2)
            goto L_0x004c
        L_0x005f:
            if (r1 > 0) goto L_0x0068
            int r3 = r6.length()
            int r3 = r3 - r2
            if (r0 >= r3) goto L_0x006d
        L_0x0068:
            int r0 = r0 + r2
            java.lang.String r6 = r6.substring(r1, r0)
        L_0x006d:
            java.lang.String r6 = l(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.asn1.t2.f.c.e(java.lang.String):java.lang.String");
    }

    private static int f(char c2) {
        if ('0' <= c2 && c2 <= '9') {
            return c2 - '0';
        }
        return (('a' > c2 || c2 > 'f') ? c2 - 'A' : c2 - 'a') + 10;
    }

    public static m g(String str, Hashtable hashtable) {
        if (i.j(str).startsWith("OID.")) {
            return new m(str.substring(4));
        }
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return new m(str);
        }
        m mVar = (m) hashtable.get(i.f(str));
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalArgumentException("Unknown object id - " + str + " - passed to distinguished name");
    }

    private static q h(String str) {
        try {
            return q.i(d.a(str.substring(1)));
        } catch (IOException e2) {
            throw new IllegalStateException("unknown encoding in name: " + e2);
        }
    }

    private static boolean i(char c2) {
        return ('0' <= c2 && c2 <= '9') || ('a' <= c2 && c2 <= 'f') || ('A' <= c2 && c2 <= 'F');
    }

    public static boolean j(b bVar, b bVar2) {
        if (bVar.i()) {
            if (!bVar2.i()) {
                return false;
            }
            a[] h = bVar.h();
            a[] h2 = bVar2.h();
            if (h.length != h2.length) {
                return false;
            }
            for (int i = 0; i != h.length; i++) {
                if (!c(h[i], h2[i])) {
                    return false;
                }
            }
            return true;
        } else if (!bVar2.i()) {
            return c(bVar.f(), bVar2.f());
        } else {
            return false;
        }
    }

    public static b[] k(String str, e eVar) {
        e eVar2 = new e(str);
        org.bouncycastle.asn1.t2.d dVar = new org.bouncycastle.asn1.t2.d(eVar);
        while (eVar2.a()) {
            String b2 = eVar2.b();
            if (b2.indexOf(43) > 0) {
                e eVar3 = new e(b2, '+');
                e eVar4 = new e(eVar3.b(), '=');
                String b3 = eVar4.b();
                if (eVar4.a()) {
                    String b4 = eVar4.b();
                    m c2 = eVar.c(b3.trim());
                    if (eVar3.a()) {
                        Vector vector = new Vector();
                        Vector vector2 = new Vector();
                        while (true) {
                            vector.addElement(c2);
                            vector2.addElement(o(b4));
                            if (!eVar3.a()) {
                                dVar.a(m(vector), n(vector2));
                                break;
                            }
                            e eVar5 = new e(eVar3.b(), '=');
                            String b5 = eVar5.b();
                            if (eVar5.a()) {
                                b4 = eVar5.b();
                                c2 = eVar.c(b5.trim());
                            } else {
                                throw new IllegalArgumentException("badly formatted directory string");
                            }
                        }
                    } else {
                        dVar.d(c2, o(b4));
                    }
                } else {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
            } else {
                e eVar6 = new e(b2, '=');
                String b6 = eVar6.b();
                if (eVar6.a()) {
                    dVar.d(eVar.c(b6.trim()), o(eVar6.b()));
                } else {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
            }
        }
        return dVar.f().i();
    }

    public static String l(String str) {
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

    private static m[] m(Vector vector) {
        int size = vector.size();
        m[] mVarArr = new m[size];
        for (int i = 0; i != size; i++) {
            mVarArr[i] = (m) vector.elementAt(i);
        }
        return mVarArr;
    }

    private static String[] n(Vector vector) {
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i = 0; i != size; i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    private static String o(String str) {
        int i;
        if (str.length() == 0 || (str.indexOf(92) < 0 && str.indexOf(34) < 0)) {
            return str.trim();
        }
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(str.length());
        if (charArray[0] == '\\' && charArray[1] == '#') {
            i = 2;
            stringBuffer.append("\\#");
        } else {
            i = 0;
        }
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        char c2 = 0;
        while (i != charArray.length) {
            char c3 = charArray[i];
            if (c3 != ' ') {
                z3 = true;
            }
            if (c3 != '\"') {
                if (c3 == '\\' && !z && !z2) {
                    i2 = stringBuffer.length();
                    z = true;
                } else if (c3 != ' ' || z || z3) {
                    if (z && i(c3)) {
                        if (c2 != 0) {
                            stringBuffer.append((char) ((f(c2) * 16) + f(c3)));
                            z = false;
                            c2 = 0;
                        } else {
                            c2 = c3;
                        }
                    }
                }
                i++;
            } else if (!z) {
                z2 = !z2;
                z = false;
                i++;
            }
            stringBuffer.append(c3);
            z = false;
            i++;
        }
        if (stringBuffer.length() > 0) {
            while (stringBuffer.charAt(stringBuffer.length() - 1) == ' ' && i2 != stringBuffer.length() - 1) {
                stringBuffer.setLength(stringBuffer.length() - 1);
            }
        }
        return stringBuffer.toString();
    }

    public static org.bouncycastle.asn1.e p(String str, int i) throws IOException {
        int length = (str.length() - i) / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 != length; i2++) {
            int i3 = (i2 * 2) + i;
            char charAt = str.charAt(i3);
            bArr[i2] = (byte) (f(str.charAt(i3 + 1)) | (f(charAt) << 4));
        }
        return q.i(bArr);
    }

    public static String q(org.bouncycastle.asn1.e eVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!(eVar instanceof w) || (eVar instanceof j1)) {
            try {
                stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD + d(d.b(eVar.c().e("DER"))));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        } else {
            String string = ((w) eVar).getString();
            if (string.length() > 0 && string.charAt(0) == '#') {
                string = SSLClient.ESCAPE + string;
            }
            stringBuffer.append(string);
        }
        int length = stringBuffer.length();
        int i = 2;
        if (!(stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#')) {
            i = 0;
        }
        while (i != length) {
            if (stringBuffer.charAt(i) == ',' || stringBuffer.charAt(i) == '\"' || stringBuffer.charAt(i) == '\\' || stringBuffer.charAt(i) == '+' || stringBuffer.charAt(i) == '=' || stringBuffer.charAt(i) == '<' || stringBuffer.charAt(i) == '>' || stringBuffer.charAt(i) == ';') {
                stringBuffer.insert(i, SSLClient.ESCAPE);
                i++;
                length++;
            }
            i++;
        }
        if (stringBuffer.length() > 0) {
            for (int i2 = 0; stringBuffer.length() > i2 && stringBuffer.charAt(i2) == ' '; i2 += 2) {
                stringBuffer.insert(i2, SSLClient.ESCAPE);
            }
        }
        for (int length2 = stringBuffer.length() - 1; length2 >= 0 && stringBuffer.charAt(length2) == ' '; length2--) {
            stringBuffer.insert(length2, '\\');
        }
        return stringBuffer.toString();
    }
}
