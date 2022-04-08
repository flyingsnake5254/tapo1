package com.google.android.exoplayer2.text.o;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import java.util.List;

/* compiled from: PgsSubtitle.java */
/* loaded from: classes.dex */
final class b implements f {

    /* renamed from: c  reason: collision with root package name */
    private final List<c> f3515c;

    public b(List<c> list) {
        this.f3515c = list;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int a(long j) {
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.f
    public List<c> b(long j) {
        return this.f3515c;
    }

    @Override // com.google.android.exoplayer2.text.f
    public long c(int i) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int d() {
        return 1;
    }
}
