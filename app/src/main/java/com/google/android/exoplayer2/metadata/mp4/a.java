package com.google.android.exoplayer2.metadata.mp4;

import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.common.collect.c0;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ a f2594c = new a();

    private /* synthetic */ a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int j;
        j = c0.k().e(r1.f2590d, r2.f2590d).e(r1.f2591f, r2.f2591f).d(((SlowMotionData.Segment) obj).q, ((SlowMotionData.Segment) obj2).q).j();
        return j;
    }
}
