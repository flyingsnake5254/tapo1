package org.bouncycastle.crypto.w;

import java.math.BigInteger;
import org.bouncycastle.crypto.e;

/* loaded from: classes4.dex */
public class u implements e {

    /* renamed from: c  reason: collision with root package name */
    private BigInteger f17364c;

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f17365d;

    /* renamed from: f  reason: collision with root package name */
    private int f17366f;

    public u(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public u(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f17364c = bigInteger2;
        this.f17365d = bigInteger;
        this.f17366f = i;
    }

    public BigInteger a() {
        return this.f17364c;
    }

    public int b() {
        return this.f17366f;
    }

    public BigInteger c() {
        return this.f17365d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return uVar.c().equals(this.f17365d) && uVar.a().equals(this.f17364c) && uVar.b() == this.f17366f;
    }

    public int hashCode() {
        return (c().hashCode() ^ a().hashCode()) + this.f17366f;
    }
}
