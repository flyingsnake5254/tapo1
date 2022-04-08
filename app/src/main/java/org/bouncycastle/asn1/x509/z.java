package org.bouncycastle.asn1.x509;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.bouncycastle.asn1.d;
import org.bouncycastle.asn1.h;
import org.bouncycastle.asn1.h1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.s0;
import org.bouncycastle.asn1.y;

/* loaded from: classes4.dex */
public class z extends l implements d {

    /* renamed from: c  reason: collision with root package name */
    q f17048c;

    public z(Date date) {
        SimpleDateFormat simpleDateFormat;
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        new SimpleDateFormat("yyyyMMddHHmmss").setTimeZone(simpleTimeZone);
        String str = simpleDateFormat.format(date) + "Z";
        int parseInt = Integer.parseInt(str.substring(0, 4));
        this.f17048c = (parseInt < 1950 || parseInt > 2049) ? new s0(str) : new h1(str.substring(2));
    }

    public z(q qVar) {
        if ((qVar instanceof y) || (qVar instanceof h)) {
            this.f17048c = qVar;
            return;
        }
        throw new IllegalArgumentException("unknown object passed to Time");
    }

    public static z g(Object obj) {
        if (obj == null || (obj instanceof z)) {
            return (z) obj;
        }
        if (obj instanceof y) {
            return new z((y) obj);
        }
        if (obj instanceof h) {
            return new z((h) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    @Override // org.bouncycastle.asn1.l, org.bouncycastle.asn1.e
    public q c() {
        return this.f17048c;
    }

    public Date f() {
        try {
            q qVar = this.f17048c;
            return qVar instanceof y ? ((y) qVar).m() : ((h) qVar).o();
        } catch (ParseException e2) {
            throw new IllegalStateException("invalid date string: " + e2.getMessage());
        }
    }

    public String h() {
        q qVar = this.f17048c;
        return qVar instanceof y ? ((y) qVar).n() : ((h) qVar).q();
    }

    public String toString() {
        return h();
    }
}
