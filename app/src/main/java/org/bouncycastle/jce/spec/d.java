package org.bouncycastle.jce.spec;

import e.a.b.a.h;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes4.dex */
public class d implements AlgorithmParameterSpec {
    private e.a.b.a.d a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f17405b;

    /* renamed from: c  reason: collision with root package name */
    private h f17406c;

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f17407d;

    /* renamed from: e  reason: collision with root package name */
    private BigInteger f17408e;

    public d(e.a.b.a.d dVar, h hVar, BigInteger bigInteger) {
        this.a = dVar;
        this.f17406c = hVar.A();
        this.f17407d = bigInteger;
        this.f17408e = BigInteger.valueOf(1L);
        this.f17405b = null;
    }

    public d(e.a.b.a.d dVar, h hVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.a = dVar;
        this.f17406c = hVar.A();
        this.f17407d = bigInteger;
        this.f17408e = bigInteger2;
        this.f17405b = bArr;
    }

    public e.a.b.a.d a() {
        return this.a;
    }

    public h b() {
        return this.f17406c;
    }

    public BigInteger c() {
        return this.f17408e;
    }

    public BigInteger d() {
        return this.f17407d;
    }

    public byte[] e() {
        return this.f17405b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return a().m(dVar.a()) && b().e(dVar.b());
    }

    public int hashCode() {
        return a().hashCode() ^ b().hashCode();
    }
}
