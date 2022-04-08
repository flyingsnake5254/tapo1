package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.bouncycastle.util.a;

/* loaded from: classes4.dex */
public abstract class r extends q implements Iterable {

    /* renamed from: c  reason: collision with root package name */
    protected Vector f16878c;

    /* JADX INFO: Access modifiers changed from: protected */
    public r() {
        this.f16878c = new Vector();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r(e eVar) {
        Vector vector = new Vector();
        this.f16878c = vector;
        vector.addElement(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r(f fVar) {
        this.f16878c = new Vector();
        for (int i = 0; i != fVar.c(); i++) {
            this.f16878c.addElement(fVar.b(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r(e[] eVarArr) {
        this.f16878c = new Vector();
        for (int i = 0; i != eVarArr.length; i++) {
            this.f16878c.addElement(eVarArr[i]);
        }
    }

    public static r m(Object obj) {
        if (obj == null || (obj instanceof r)) {
            return (r) obj;
        }
        if (obj instanceof s) {
            return m(((s) obj).c());
        }
        if (obj instanceof byte[]) {
            try {
                return m(q.i((byte[]) obj));
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e2.getMessage());
            }
        } else {
            if (obj instanceof e) {
                q c2 = ((e) obj).c();
                if (c2 instanceof r) {
                    return (r) c2;
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    public static r n(x xVar, boolean z) {
        if (!z) {
            q o = xVar.o();
            if (xVar.q()) {
                return xVar instanceof i0 ? new e0(o) : new o1(o);
            }
            if (o instanceof r) {
                return (r) o;
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + xVar.getClass().getName());
        } else if (xVar.q()) {
            return m(xVar.o().c());
        } else {
            throw new IllegalArgumentException("object implicit - explicit expected.");
        }
    }

    private e o(Enumeration enumeration) {
        return (e) enumeration.nextElement();
    }

    @Override // org.bouncycastle.asn1.q
    boolean f(q qVar) {
        if (!(qVar instanceof r)) {
            return false;
        }
        r rVar = (r) qVar;
        if (size() != rVar.size()) {
            return false;
        }
        Enumeration q = q();
        Enumeration q2 = rVar.q();
        while (q.hasMoreElements()) {
            e o = o(q);
            e o2 = o(q2);
            q c2 = o.c();
            q c3 = o2.c();
            if (c2 != c3 && !c2.equals(c3)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.asn1.l
    public int hashCode() {
        Enumeration q = q();
        int size = size();
        while (q.hasMoreElements()) {
            size = (size * 17) ^ o(q).hashCode();
        }
        return size;
    }

    @Override // java.lang.Iterable
    public Iterator<e> iterator() {
        return new a.C0342a(r());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public boolean j() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public q k() {
        b1 b1Var = new b1();
        b1Var.f16878c = this.f16878c;
        return b1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.q
    public q l() {
        o1 o1Var = new o1();
        o1Var.f16878c = this.f16878c;
        return o1Var;
    }

    public e p(int i) {
        return (e) this.f16878c.elementAt(i);
    }

    public Enumeration q() {
        return this.f16878c.elements();
    }

    public e[] r() {
        e[] eVarArr = new e[size()];
        for (int i = 0; i != size(); i++) {
            eVarArr[i] = p(i);
        }
        return eVarArr;
    }

    public int size() {
        return this.f16878c.size();
    }

    public String toString() {
        return this.f16878c.toString();
    }
}
