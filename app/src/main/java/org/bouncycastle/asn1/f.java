package org.bouncycastle.asn1;

import java.util.Vector;

/* loaded from: classes4.dex */
public class f {
    private final Vector a = new Vector();

    public void a(e eVar) {
        this.a.addElement(eVar);
    }

    public e b(int i) {
        return (e) this.a.elementAt(i);
    }

    public int c() {
        return this.a.size();
    }
}
