package org.bouncycastle.pqc.jcajce.provider.mceliece;

import org.bouncycastle.asn1.m2.b;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.crypto.g;

/* loaded from: classes4.dex */
class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(String str) {
        if (str.equals("SHA-1")) {
            return new a(b.i, v0.f16957c);
        }
        if (str.equals("SHA-224")) {
            return new a(org.bouncycastle.asn1.j2.b.f16783f, v0.f16957c);
        }
        if (str.equals("SHA-256")) {
            return new a(org.bouncycastle.asn1.j2.b.f16780c, v0.f16957c);
        }
        if (str.equals("SHA-384")) {
            return new a(org.bouncycastle.asn1.j2.b.f16781d, v0.f16957c);
        }
        if (str.equals("SHA-512")) {
            return new a(org.bouncycastle.asn1.j2.b.f16782e, v0.f16957c);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g b(a aVar) {
        if (aVar.f().equals(b.i)) {
            return org.bouncycastle.crypto.util.a.a();
        }
        if (aVar.f().equals(org.bouncycastle.asn1.j2.b.f16783f)) {
            return org.bouncycastle.crypto.util.a.b();
        }
        if (aVar.f().equals(org.bouncycastle.asn1.j2.b.f16780c)) {
            return org.bouncycastle.crypto.util.a.c();
        }
        if (aVar.f().equals(org.bouncycastle.asn1.j2.b.f16781d)) {
            return org.bouncycastle.crypto.util.a.d();
        }
        if (aVar.f().equals(org.bouncycastle.asn1.j2.b.f16782e)) {
            return org.bouncycastle.crypto.util.a.e();
        }
        throw new IllegalArgumentException("unrecognised OID in digest algorithm identifier: " + aVar.f());
    }
}
