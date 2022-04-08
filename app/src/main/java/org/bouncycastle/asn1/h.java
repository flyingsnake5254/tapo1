package org.bouncycastle.asn1;

import com.tplink.libtpmediastatistics.SSLClient;
import java.io.IOException;
import java.text.ParseException;
import java.util.TimeZone;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes4.dex */
public class h extends q {

    /* renamed from: c  reason: collision with root package name */
    protected byte[] f16757c;

    public h(String str) {
        this.f16757c = i.e(str);
        try {
            o();
        } catch (ParseException e2) {
            throw new IllegalArgumentException("invalid date string: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(byte[] bArr) {
        this.f16757c = bArr;
    }

    private String m() {
        String str;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str = "-";
        } else {
            str = MqttTopic.SINGLE_LEVEL_WILDCARD;
        }
        int i = rawOffset / 3600000;
        int i2 = (rawOffset - (((i * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime() && timeZone.inDaylightTime(o())) {
                i += str.equals(MqttTopic.SINGLE_LEVEL_WILDCARD) ? 1 : -1;
            }
        } catch (ParseException unused) {
        }
        return "GMT" + str + n(i) + SSLClient.COLON + n(i2);
    }

    private String n(int i) {
        if (i >= 10) {
            return Integer.toString(i);
        }
        return "0" + i;
    }

    public static h p(Object obj) {
        if (obj == null || (obj instanceof h)) {
            return (h) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (h) q.i((byte[]) obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    private boolean u(int i) {
        byte[] bArr = this.f16757c;
        return bArr.length > i && bArr[i] >= 48 && bArr[i] <= 57;
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (!(qVar instanceof h)) {
            return false;
        }
        return a.c(this.f16757c, ((h) qVar).f16757c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.g(24, this.f16757c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public int h() {
        int length = this.f16757c.length;
        return y1.a(length) + 1 + length;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        return a.w(this.f16757c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public q k() {
        return new s0(this.f16757c);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Date o() throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.asn1.h.o():java.util.Date");
    }

    public String q() {
        int length;
        String b2 = i.b(this.f16757c);
        if (b2.charAt(b2.length() - 1) == 'Z') {
            return b2.substring(0, b2.length() - 1) + "GMT+00:00";
        }
        int length2 = b2.length() - 5;
        char charAt = b2.charAt(length2);
        if (charAt == '-' || charAt == '+') {
            StringBuilder sb = new StringBuilder();
            sb.append(b2.substring(0, length2));
            sb.append("GMT");
            int i = length2 + 3;
            sb.append(b2.substring(length2, i));
            sb.append(SSLClient.COLON);
            sb.append(b2.substring(i));
            return sb.toString();
        }
        char charAt2 = b2.charAt(b2.length() - 3);
        if (charAt2 == '-' || charAt2 == '+') {
            return b2.substring(0, length) + "GMT" + b2.substring(length) + ":00";
        }
        return b2 + m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f16757c;
            if (i == bArr.length) {
                return false;
            }
            if (bArr[i] == 46 && i == 14) {
                return true;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s() {
        return u(10) && u(11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t() {
        return u(12) && u(13);
    }
}
