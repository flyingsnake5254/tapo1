package com.google.android.exoplayer2.text.r;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.Collections;
import java.util.List;

/* compiled from: SubripSubtitle.java */
/* loaded from: classes.dex */
final class b implements f {

    /* renamed from: c  reason: collision with root package name */
    private final c[] f3540c;

    /* renamed from: d  reason: collision with root package name */
    private final long[] f3541d;

    public b(c[] cVarArr, long[] jArr) {
        this.f3540c = cVarArr;
        this.f3541d = jArr;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int a(long j) {
        int d2 = o0.d(this.f3541d, j, false, false);
        if (d2 < this.f3541d.length) {
            return d2;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.f
    public List<c> b(long j) {
        int h = o0.h(this.f3541d, j, true, false);
        if (h != -1) {
            c[] cVarArr = this.f3540c;
            if (cVarArr[h] != c.a) {
                return Collections.singletonList(cVarArr[h]);
            }
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.f
    public long c(int i) {
        boolean z = true;
        g.a(i >= 0);
        if (i >= this.f3541d.length) {
            z = false;
        }
        g.a(z);
        return this.f3541d[i];
    }

    @Override // com.google.android.exoplayer2.text.f
    public int d() {
        return this.f3541d.length;
    }
}
