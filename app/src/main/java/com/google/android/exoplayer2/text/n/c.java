package com.google.android.exoplayer2.text.n;

import com.google.android.exoplayer2.text.f;
import java.util.List;

/* compiled from: DvbSubtitle.java */
/* loaded from: classes.dex */
final class c implements f {

    /* renamed from: c  reason: collision with root package name */
    private final List<com.google.android.exoplayer2.text.c> f3509c;

    public c(List<com.google.android.exoplayer2.text.c> list) {
        this.f3509c = list;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int a(long j) {
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.f
    public List<com.google.android.exoplayer2.text.c> b(long j) {
        return this.f3509c;
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
