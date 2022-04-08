package com.google.android.exoplayer2;

import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.util.t;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements t.a {
    public static final /* synthetic */ t a = new t();

    private /* synthetic */ t() {
    }

    @Override // com.google.android.exoplayer2.util.t.a
    public final void invoke(Object obj) {
        ((u1.c) obj).P(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(1), 1003));
    }
}
