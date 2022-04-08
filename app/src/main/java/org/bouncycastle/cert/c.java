package org.bouncycastle.cert;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.h;
import org.bouncycastle.asn1.x509.m;
import org.bouncycastle.asn1.x509.y;
import org.bouncycastle.asn1.z0;
import org.bouncycastle.operator.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c {
    private static Set a = Collections.unmodifiableSet(new HashSet());

    /* renamed from: b  reason: collision with root package name */
    private static List f17056b = Collections.unmodifiableList(new ArrayList());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean[] a(n0 n0Var) {
        if (n0Var == null) {
            return null;
        }
        byte[] o = n0Var.o();
        int length = (o.length * 8) - n0Var.q();
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            zArr[i] = (o[i / 8] & (128 >>> (i % 8))) != 0;
        }
        return zArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static X509CertificateHolder b(a aVar, y yVar) {
        try {
            return new X509CertificateHolder(d(yVar, aVar.a(), c(aVar, yVar)));
        } catch (IOException unused) {
            throw new IllegalStateException("cannot produce certificate signature");
        }
    }

    private static byte[] c(a aVar, e eVar) throws IOException {
        OutputStream outputStream = aVar.getOutputStream();
        new z0(outputStream).j(eVar);
        outputStream.close();
        return aVar.b();
    }

    private static h d(y yVar, org.bouncycastle.asn1.x509.a aVar, byte[] bArr) {
        f fVar = new f();
        fVar.a(yVar);
        fVar.a(aVar);
        fVar.a(new n0(bArr));
        return h.g(new b1(fVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set e(m mVar) {
        return mVar == null ? a : Collections.unmodifiableSet(new HashSet(Arrays.asList(mVar.f())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List f(m mVar) {
        return mVar == null ? f17056b : Collections.unmodifiableList(Arrays.asList(mVar.h()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set g(m mVar) {
        return mVar == null ? a : Collections.unmodifiableSet(new HashSet(Arrays.asList(mVar.l())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(org.bouncycastle.asn1.x509.a aVar, org.bouncycastle.asn1.x509.a aVar2) {
        if (!aVar.f().equals(aVar2.f())) {
            return false;
        }
        return aVar.i() == null ? aVar2.i() == null || aVar2.i().equals(v0.f16957c) : aVar2.i() == null ? aVar.i() == null || aVar.i().equals(v0.f16957c) : aVar.i().equals(aVar2.i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q i(byte[] bArr) throws IOException {
        q i = q.i(bArr);
        if (i != null) {
            return i;
        }
        throw new IOException("no content found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Date j(org.bouncycastle.asn1.h hVar) {
        try {
            return hVar.o();
        } catch (ParseException e2) {
            throw new IllegalStateException("unable to recover date: " + e2.getMessage());
        }
    }
}
