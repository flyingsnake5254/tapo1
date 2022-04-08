package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public abstract class t extends q implements Iterable {

    /* renamed from: c  reason: collision with root package name */
    private Vector f16899c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16900d;

    /* JADX INFO: Access modifiers changed from: protected */
    public t() {
        this.f16899c = new Vector();
        this.f16900d = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t(e eVar) {
        Vector vector = new Vector();
        this.f16899c = vector;
        this.f16900d = false;
        vector.addElement(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t(f fVar, boolean z) {
        this.f16899c = new Vector();
        this.f16900d = false;
        for (int i = 0; i != fVar.c(); i++) {
            this.f16899c.addElement(fVar.b(i));
        }
        if (z) {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t(e[] eVarArr, boolean z) {
        this.f16899c = new Vector();
        this.f16900d = false;
        for (int i = 0; i != eVarArr.length; i++) {
            this.f16899c.addElement(eVarArr[i]);
        }
        if (z) {
            t();
        }
    }

    private byte[] m(e eVar) {
        try {
            return eVar.c().e("DER");
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public static t n(Object obj) {
        if (obj == null || (obj instanceof t)) {
            return (t) obj;
        }
        if (obj instanceof u) {
            return n(((u) obj).c());
        }
        if (obj instanceof byte[]) {
            try {
                return n(q.i((byte[]) obj));
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct set from byte[]: " + e2.getMessage());
            }
        } else {
            if (obj instanceof e) {
                q c2 = ((e) obj).c();
                if (c2 instanceof t) {
                    return (t) c2;
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    public static t o(x xVar, boolean z) {
        if (!z) {
            q o = xVar.o();
            if (xVar.q()) {
                return xVar instanceof i0 ? new g0(o) : new p1(o);
            }
            if (o instanceof t) {
                return (t) o;
            }
            if (o instanceof r) {
                r rVar = (r) o;
                return xVar instanceof i0 ? new g0(rVar.r()) : new p1(rVar.r());
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + xVar.getClass().getName());
        } else if (xVar.q()) {
            return (t) xVar.o();
        } else {
            throw new IllegalArgumentException("object implicit - explicit expected.");
        }
    }

    private e p(Enumeration enumeration) {
        e eVar = (e) enumeration.nextElement();
        return eVar == null ? v0.f16957c : eVar;
    }

    private boolean s(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i != min; i++) {
            if (bArr[i] != bArr2[i]) {
                return (bArr[i] & 255) < (bArr2[i] & 255);
            }
        }
        return min == bArr.length;
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (!(qVar instanceof t)) {
            return false;
        }
        t tVar = (t) qVar;
        if (size() != tVar.size()) {
            return false;
        }
        Enumeration r = r();
        Enumeration r2 = tVar.r();
        while (r.hasMoreElements()) {
            e p = p(r);
            e p2 = p(r2);
            q c2 = p.c();
            q c3 = p2.c();
            if (c2 != c3 && !c2.equals(c3)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        Enumeration r = r();
        int size = size();
        while (r.hasMoreElements()) {
            size = (size * 17) ^ p(r).hashCode();
        }
        return size;
    }

    @Override // java.lang.Iterable
    public Iterator<e> iterator() {
        return new a.C0342a(u());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public q k() {
        if (this.f16900d) {
            d1 d1Var = new d1();
            d1Var.f16899c = this.f16899c;
            return d1Var;
        }
        Vector vector = new Vector();
        for (int i = 0; i != this.f16899c.size(); i++) {
            vector.addElement(this.f16899c.elementAt(i));
        }
        d1 d1Var2 = new d1();
        d1Var2.f16899c = vector;
        d1Var2.t();
        return d1Var2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public q l() {
        p1 p1Var = new p1();
        p1Var.f16899c = this.f16899c;
        return p1Var;
    }

    public e q(int i) {
        return (e) this.f16899c.elementAt(i);
    }

    public Enumeration r() {
        return this.f16899c.elements();
    }

    public int size() {
        return this.f16899c.size();
    }

    protected void t() {
        if (!this.f16900d) {
            this.f16900d = true;
            if (this.f16899c.size() > 1) {
                int size = this.f16899c.size() - 1;
                boolean z = true;
                while (z) {
                    int i = 0;
                    byte[] m = m((e) this.f16899c.elementAt(0));
                    z = false;
                    int i2 = 0;
                    while (i2 != size) {
                        int i3 = i2 + 1;
                        byte[] m2 = m((e) this.f16899c.elementAt(i3));
                        if (s(m, m2)) {
                            m = m2;
                        } else {
                            Object elementAt = this.f16899c.elementAt(i2);
                            Vector vector = this.f16899c;
                            vector.setElementAt(vector.elementAt(i3), i2);
                            this.f16899c.setElementAt(elementAt, i3);
                            i = i2;
                            z = true;
                        }
                        i2 = i3;
                    }
                    size = i;
                }
            }
        }
    }

    public String toString() {
        return this.f16899c.toString();
    }

    public e[] u() {
        e[] eVarArr = new e[size()];
        for (int i = 0; i != size(); i++) {
            eVarArr[i] = q(i);
        }
        return eVarArr;
    }
}
