package org.bouncycastle.asn1.t2.f;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tplink.iot.Utils.hls.c;
import io.netty.util.internal.StringUtil;
import java.util.Hashtable;
import org.bouncycastle.asn1.a1;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.t2.b;
import org.bouncycastle.asn1.t2.e;
import org.bouncycastle.asn1.u0;

/* loaded from: classes4.dex */
public class d extends a {
    public static final m A;
    public static final m B;
    public static final m C;
    public static final m D;
    public static final m E;
    public static final m F;
    public static final m G;
    public static final m H;
    public static final m I;
    public static final m J;
    public static final m K;
    public static final m L;
    public static final m M;
    public static final m N;
    public static final m O;
    public static final m P;
    public static final m Q;
    private static final Hashtable R;
    private static final Hashtable S;
    public static final e T = new d();
    public static final m a;

    /* renamed from: b  reason: collision with root package name */
    public static final m f16915b;

    /* renamed from: c  reason: collision with root package name */
    public static final m f16916c;

    /* renamed from: d  reason: collision with root package name */
    public static final m f16917d;

    /* renamed from: e  reason: collision with root package name */
    public static final m f16918e;

    /* renamed from: f  reason: collision with root package name */
    public static final m f16919f;
    public static final m g;
    public static final m h;
    public static final m i;
    public static final m j;
    public static final m k;
    public static final m l;
    public static final m m;
    public static final m n;
    public static final m o;
    public static final m p;
    public static final m q;
    public static final m r;
    public static final m s;
    public static final m t;
    public static final m u;
    public static final m v;
    public static final m w;
    public static final m x;
    public static final m y;
    public static final m z;
    protected final Hashtable V = a.h(R);
    protected final Hashtable U = a.h(S);

    static {
        m t2 = new m("2.5.4.15").t();
        a = t2;
        m t3 = new m("2.5.4.6").t();
        f16915b = t3;
        m t4 = new m("2.5.4.3").t();
        f16916c = t4;
        m t5 = new m("0.9.2342.19200300.100.1.25").t();
        f16917d = t5;
        m t6 = new m("2.5.4.13").t();
        f16918e = t6;
        m t7 = new m("2.5.4.27").t();
        f16919f = t7;
        m t8 = new m("2.5.4.49").t();
        g = t8;
        m t9 = new m("2.5.4.46").t();
        h = t9;
        m t10 = new m("2.5.4.47").t();
        i = t10;
        m t11 = new m("2.5.4.23").t();
        j = t11;
        m t12 = new m("2.5.4.44").t();
        k = t12;
        m t13 = new m("2.5.4.42").t();
        l = t13;
        m t14 = new m("2.5.4.51").t();
        m = t14;
        m t15 = new m("2.5.4.43").t();
        n = t15;
        m t16 = new m("2.5.4.25").t();
        o = t16;
        m t17 = new m("2.5.4.7").t();
        p = t17;
        m t18 = new m("2.5.4.31").t();
        q = t18;
        m t19 = new m("2.5.4.41").t();
        r = t19;
        m t20 = new m("2.5.4.10").t();
        s = t20;
        m t21 = new m("2.5.4.11").t();
        t = t21;
        m t22 = new m("2.5.4.32").t();
        u = t22;
        m t23 = new m("2.5.4.19").t();
        v = t23;
        m t24 = new m("2.5.4.16").t();
        w = t24;
        m t25 = new m("2.5.4.17").t();
        x = t25;
        m t26 = new m("2.5.4.18").t();
        y = t26;
        m t27 = new m("2.5.4.28").t();
        z = t27;
        m t28 = new m("2.5.4.26").t();
        A = t28;
        m t29 = new m("2.5.4.33").t();
        B = t29;
        m t30 = new m("2.5.4.14").t();
        C = t30;
        m t31 = new m("2.5.4.34").t();
        D = t31;
        m t32 = new m("2.5.4.5").t();
        E = t32;
        m t33 = new m("2.5.4.4").t();
        F = t33;
        m t34 = new m("2.5.4.8").t();
        G = t34;
        m t35 = new m("2.5.4.9").t();
        H = t35;
        m t36 = new m("2.5.4.20").t();
        I = t36;
        m t37 = new m("2.5.4.22").t();
        J = t37;
        m t38 = new m("2.5.4.21").t();
        K = t38;
        m t39 = new m("2.5.4.12").t();
        L = t39;
        m t40 = new m("0.9.2342.19200300.100.1.1").t();
        M = t40;
        m t41 = new m("2.5.4.50").t();
        N = t41;
        m t42 = new m("2.5.4.35").t();
        O = t42;
        m t43 = new m("2.5.4.24").t();
        P = t43;
        m t44 = new m("2.5.4.45").t();
        Q = t44;
        Hashtable hashtable = new Hashtable();
        R = hashtable;
        Hashtable hashtable2 = new Hashtable();
        S = hashtable2;
        hashtable.put(t2, "businessCategory");
        hashtable.put(t3, c.n);
        hashtable.put(t4, "cn");
        hashtable.put(t5, "dc");
        hashtable.put(t6, "description");
        hashtable.put(t7, "destinationIndicator");
        hashtable.put(t8, "distinguishedName");
        hashtable.put(t9, "dnQualifier");
        hashtable.put(t10, "enhancedSearchGuide");
        hashtable.put(t11, "facsimileTelephoneNumber");
        hashtable.put(t12, "generationQualifier");
        hashtable.put(t13, "givenName");
        hashtable.put(t14, "houseIdentifier");
        hashtable.put(t15, "initials");
        hashtable.put(t16, "internationalISDNNumber");
        hashtable.put(t17, "l");
        hashtable.put(t18, "member");
        hashtable.put(t19, AppMeasurementSdk.ConditionalUserProperty.NAME);
        hashtable.put(t20, "o");
        hashtable.put(t21, "ou");
        hashtable.put(t22, "owner");
        hashtable.put(t23, "physicalDeliveryOfficeName");
        hashtable.put(t24, "postalAddress");
        hashtable.put(t25, "postalCode");
        hashtable.put(t26, "postOfficeBox");
        hashtable.put(t27, "preferredDeliveryMethod");
        hashtable.put(t28, "registeredAddress");
        hashtable.put(t29, "roleOccupant");
        hashtable.put(t30, "searchGuide");
        hashtable.put(t31, "seeAlso");
        hashtable.put(t32, "serialNumber");
        hashtable.put(t33, "sn");
        hashtable.put(t34, "st");
        hashtable.put(t35, "street");
        hashtable.put(t36, "telephoneNumber");
        hashtable.put(t37, "teletexTerminalIdentifier");
        hashtable.put(t38, "telexNumber");
        hashtable.put(t39, "title");
        hashtable.put(t40, "uid");
        hashtable.put(t41, "uniqueMember");
        hashtable.put(t42, "userPassword");
        hashtable.put(t43, "x121Address");
        hashtable.put(t44, "x500UniqueIdentifier");
        hashtable2.put("businesscategory", t2);
        hashtable2.put(c.n, t3);
        hashtable2.put("cn", t4);
        hashtable2.put("dc", t5);
        hashtable2.put("description", t6);
        hashtable2.put("destinationindicator", t7);
        hashtable2.put("distinguishedname", t8);
        hashtable2.put("dnqualifier", t9);
        hashtable2.put("enhancedsearchguide", t10);
        hashtable2.put("facsimiletelephonenumber", t11);
        hashtable2.put("generationqualifier", t12);
        hashtable2.put("givenname", t13);
        hashtable2.put("houseidentifier", t14);
        hashtable2.put("initials", t15);
        hashtable2.put("internationalisdnnumber", t16);
        hashtable2.put("l", t17);
        hashtable2.put("member", t18);
        hashtable2.put(AppMeasurementSdk.ConditionalUserProperty.NAME, t19);
        hashtable2.put("o", t20);
        hashtable2.put("ou", t21);
        hashtable2.put("owner", t22);
        hashtable2.put("physicaldeliveryofficename", t23);
        hashtable2.put("postaladdress", t24);
        hashtable2.put("postalcode", t25);
        hashtable2.put("postofficebox", t26);
        hashtable2.put("preferreddeliverymethod", t27);
        hashtable2.put("registeredaddress", t28);
        hashtable2.put("roleoccupant", t29);
        hashtable2.put("searchguide", t30);
        hashtable2.put("seealso", t31);
        hashtable2.put("serialnumber", t32);
        hashtable2.put("sn", t33);
        hashtable2.put("st", t34);
        hashtable2.put("street", t35);
        hashtable2.put("telephonenumber", t36);
        hashtable2.put("teletexterminalidentifier", t37);
        hashtable2.put("telexnumber", t38);
        hashtable2.put("title", t39);
        hashtable2.put("uid", t40);
        hashtable2.put("uniquemember", t41);
        hashtable2.put("userpassword", t42);
        hashtable2.put("x121address", t43);
        hashtable2.put("x500uniqueidentifier", t44);
    }

    protected d() {
    }

    @Override // org.bouncycastle.asn1.t2.e
    public b[] b(String str) {
        b[] k2 = c.k(str, this);
        int length = k2.length;
        b[] bVarArr = new b[length];
        for (int i2 = 0; i2 != k2.length; i2++) {
            bVarArr[(length - i2) - 1] = k2[i2];
        }
        return bVarArr;
    }

    @Override // org.bouncycastle.asn1.t2.e
    public m c(String str) {
        return c.g(str, this.U);
    }

    @Override // org.bouncycastle.asn1.t2.e
    public String f(org.bouncycastle.asn1.t2.c cVar) {
        StringBuffer stringBuffer = new StringBuffer();
        b[] i2 = cVar.i();
        boolean z2 = true;
        for (int length = i2.length - 1; length >= 0; length--) {
            if (z2) {
                z2 = false;
            } else {
                stringBuffer.append(StringUtil.COMMA);
            }
            c.a(stringBuffer, i2[length], this.V);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.bouncycastle.asn1.t2.f.a
    public org.bouncycastle.asn1.e i(m mVar, String str) {
        return mVar.equals(f16917d) ? new u0(str) : (mVar.equals(f16915b) || mVar.equals(E) || mVar.equals(h) || mVar.equals(I)) ? new a1(str) : super.i(mVar, str);
    }
}
