package com.google.common.hash;

import com.google.common.hash.n;
import java.io.Serializable;

/* compiled from: LongAdder.java */
/* loaded from: classes2.dex */
final class k extends n implements Serializable, i {
    @Override // com.google.common.hash.i
    public long a() {
        long j = this.p0;
        n.b[] bVarArr = this.z;
        if (bVarArr != null) {
            for (n.b bVar : bVarArr) {
                if (bVar != null) {
                    j += bVar.f4694c;
                }
            }
        }
        return j;
    }

    @Override // com.google.common.hash.i
    public void add(long j) {
        int length;
        n.b bVar;
        n.b[] bVarArr = this.z;
        if (bVarArr == null) {
            long j2 = this.p0;
            if (d(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = n.f4690c.get();
        boolean z = true;
        if (!(iArr == null || bVarArr == null || (length = bVarArr.length) < 1 || (bVar = bVarArr[(length - 1) & iArr[0]]) == null)) {
            long j3 = bVar.f4694c;
            z = bVar.a(j3, j3 + j);
            if (z) {
                return;
            }
        }
        i(j, iArr, z);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return a();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) a();
    }

    @Override // com.google.common.hash.n
    final long g(long j, long j2) {
        return j + j2;
    }

    @Override // com.google.common.hash.i
    public void increment() {
        add(1L);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) a();
    }

    @Override // java.lang.Number
    public long longValue() {
        return a();
    }

    public String toString() {
        return Long.toString(a());
    }
}
