package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes4.dex */
public class h implements AlgorithmParameterSpec {
    private BigInteger a;

    /* renamed from: b  reason: collision with root package name */
    private BigInteger f17409b;

    public h(BigInteger bigInteger, BigInteger bigInteger2) {
        this.a = bigInteger;
        this.f17409b = bigInteger2;
    }

    public BigInteger a() {
        return this.f17409b;
    }

    public BigInteger b() {
        return this.a;
    }
}
