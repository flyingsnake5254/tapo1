package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class x extends q implements e, s1 {

    /* renamed from: c  reason: collision with root package name */
    int f16963c;

    /* renamed from: d  reason: collision with root package name */
    boolean f16964d = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f16965f;
    e q;

    public x(boolean z, int i, e eVar) {
        this.f16965f = true;
        this.q = null;
        if (eVar instanceof d) {
            this.f16965f = true;
        } else {
            this.f16965f = z;
        }
        this.f16963c = i;
        if (!this.f16965f) {
            boolean z2 = eVar.c() instanceof t;
        }
        this.q = eVar;
    }

    public static x m(Object obj) {
        if (obj == null || (obj instanceof x)) {
            return (x) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return m(q.i((byte[]) obj));
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e2.getMessage());
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    public static x n(x xVar, boolean z) {
        if (z) {
            return (x) xVar.o();
        }
        throw new IllegalArgumentException("implicitly tagged tagged object");
    }

    @Override // org.bouncycastle.asn1.s1
    public q b() {
        return c();
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (!(qVar instanceof x)) {
            return false;
        }
        x xVar = (x) qVar;
        if (this.f16963c != xVar.f16963c || this.f16964d != xVar.f16964d || this.f16965f != xVar.f16965f) {
            return false;
        }
        e eVar = this.q;
        return eVar == null ? xVar.q == null : eVar.c().equals(xVar.q.c());
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        int i = this.f16963c;
        e eVar = this.q;
        return eVar != null ? i ^ eVar.hashCode() : i;
    }

    public boolean isEmpty() {
        return this.f16964d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public q k() {
        return new g1(this.f16965f, this.f16963c, this.q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public q l() {
        return new q1(this.f16965f, this.f16963c, this.q);
    }

    public q o() {
        e eVar = this.q;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public int p() {
        return this.f16963c;
    }

    public boolean q() {
        return this.f16965f;
    }

    public String toString() {
        return "[" + this.f16963c + "]" + this.q;
    }
}
