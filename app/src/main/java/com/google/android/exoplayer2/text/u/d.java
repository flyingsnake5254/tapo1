package com.google.android.exoplayer2.text.u;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import java.util.Collections;
import java.util.List;

/* compiled from: Mp4WebvttSubtitle.java */
/* loaded from: classes.dex */
final class d implements f {

    /* renamed from: c  reason: collision with root package name */
    private final List<c> f3573c;

    public d(List<c> list) {
        this.f3573c = Collections.unmodifiableList(list);
    }

    @Override // com.google.android.exoplayer2.text.f
    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.text.f
    public List<c> b(long j) {
        return j >= 0 ? this.f3573c : Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.f
    public long c(int i) {
        g.a(i == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int d() {
        return 1;
    }
}
