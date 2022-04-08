package org.bouncycastle.crypto.w;

import java.math.BigInteger;
import org.bouncycastle.crypto.e;

/* loaded from: classes4.dex */
public class j implements e {

    /* renamed from: c  reason: collision with root package name */
    private BigInteger f17353c;

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f17354d;

    /* renamed from: f  reason: collision with root package name */
    private BigInteger f17355f;
    private m q;

    public j(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f17353c = bigInteger3;
        this.f17355f = bigInteger;
        this.f17354d = bigInteger2;
    }

    public j(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, m mVar) {
        this.f17353c = bigInteger3;
        this.f17355f = bigInteger;
        this.f17354d = bigInteger2;
        this.q = mVar;
    }

    public BigInteger a() {
        return this.f17353c;
    }

    public BigInteger b() {
        return this.f17355f;
    }

    public BigInteger c() {
        return this.f17354d;
    }

    public m d() {
        return this.q;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.b().equals(this.f17355f) && jVar.c().equals(this.f17354d) && jVar.a().equals(this.f17353c);
    }

    public int hashCode() {
        return (b().hashCode() ^ c().hashCode()) ^ a().hashCode();
    }
}
