package com.google.android.exoplayer2.text.t;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import java.util.Collections;
import java.util.List;

/* compiled from: Tx3gSubtitle.java */
/* loaded from: classes.dex */
final class b implements f {

    /* renamed from: c  reason: collision with root package name */
    public static final b f3569c = new b();

    /* renamed from: d  reason: collision with root package name */
    private final List<c> f3570d;

    public b(c cVar) {
        this.f3570d = Collections.singletonList(cVar);
    }

    @Override // com.google.android.exoplayer2.text.f
    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.text.f
    public List<c> b(long j) {
        return j >= 0 ? this.f3570d : Collections.emptyList();
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

    private b() {
        this.f3570d = Collections.emptyList();
    }
}
