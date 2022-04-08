package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import org.bouncycastle.pqc.crypto.xmss.g;
import org.bouncycastle.util.d;

/* loaded from: classes4.dex */
public class BDSStateMap implements Serializable {
    private final Map<Integer, BDS> bdsState = new TreeMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDSStateMap() {
    }

    BDSStateMap(BDSStateMap bDSStateMap, m mVar, long j, byte[] bArr, byte[] bArr2) {
        for (Integer num : bDSStateMap.bdsState.keySet()) {
            this.bdsState.put(num, bDSStateMap.bdsState.get(num));
        }
        updateState(mVar, j, bArr, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDSStateMap(m mVar, long j, byte[] bArr, byte[] bArr2) {
        for (long j2 = 0; j2 < j; j2++) {
            updateState(mVar, j2, bArr, bArr2);
        }
    }

    private void updateState(m mVar, long j, byte[] bArr, byte[] bArr2) {
        r g = mVar.g();
        int d2 = g.d();
        long j2 = u.j(j, d2);
        int i = u.i(j, d2);
        g gVar = (g) new g.b().h(j2).p(i).l();
        int i2 = (1 << d2) - 1;
        if (i < i2) {
            if (get(0) == null || i == 0) {
                put(0, new BDS(g, bArr, bArr2, gVar));
            }
            update(0, bArr, bArr2, gVar);
        }
        for (int i3 = 1; i3 < mVar.d(); i3++) {
            int i4 = u.i(j2, d2);
            j2 = u.j(j2, d2);
            g gVar2 = (g) new g.b().g(i3).h(j2).p(i4).l();
            if (i4 < i2 && u.m(j, d2, i3)) {
                if (get(i3) == null) {
                    put(i3, new BDS(mVar.g(), bArr, bArr2, gVar2));
                }
                update(i3, bArr, bArr2, gVar2);
            }
        }
    }

    public BDS get(int i) {
        return this.bdsState.get(d.b(i));
    }

    public boolean isEmpty() {
        return this.bdsState.isEmpty();
    }

    public void put(int i, BDS bds) {
        this.bdsState.put(d.b(i), bds);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setXMSS(r rVar) {
        for (Integer num : this.bdsState.keySet()) {
            BDS bds = this.bdsState.get(num);
            bds.setXMSS(rVar);
            bds.validate();
        }
    }

    public BDS update(int i, byte[] bArr, byte[] bArr2, g gVar) {
        return this.bdsState.put(d.b(i), this.bdsState.get(d.b(i)).getNextState(bArr, bArr2, gVar));
    }
}
