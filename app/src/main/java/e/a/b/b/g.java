package e.a.b.b;

import java.math.BigInteger;

/* loaded from: classes4.dex */
class g implements a {
    protected final BigInteger a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BigInteger bigInteger) {
        this.a = bigInteger;
    }

    @Override // e.a.b.b.a
    public int a() {
        return 1;
    }

    @Override // e.a.b.b.a
    public BigInteger b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        return this.a.equals(((g) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
