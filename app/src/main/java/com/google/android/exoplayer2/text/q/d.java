package com.google.android.exoplayer2.text.q;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.Collections;
import java.util.List;

/* compiled from: SsaSubtitle.java */
/* loaded from: classes.dex */
final class d implements f {

    /* renamed from: c  reason: collision with root package name */
    private final List<List<c>> f3538c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Long> f3539d;

    public d(List<List<c>> list, List<Long> list2) {
        this.f3538c = list;
        this.f3539d = list2;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int a(long j) {
        int c2 = o0.c(this.f3539d, Long.valueOf(j), false, false);
        if (c2 < this.f3539d.size()) {
            return c2;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.f
    public List<c> b(long j) {
        int f2 = o0.f(this.f3539d, Long.valueOf(j), true, false);
        if (f2 == -1) {
            return Collections.emptyList();
        }
        return this.f3538c.get(f2);
    }

    @Override // com.google.android.exoplayer2.text.f
    public long c(int i) {
        boolean z = true;
        g.a(i >= 0);
        if (i >= this.f3539d.size()) {
            z = false;
        }
        g.a(z);
        return this.f3539d.get(i).longValue();
    }

    @Override // com.google.android.exoplayer2.text.f
    public int d() {
        return this.f3539d.size();
    }
}
