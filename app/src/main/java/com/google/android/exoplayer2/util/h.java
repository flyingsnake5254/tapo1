package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* compiled from: Clock.java */
/* loaded from: classes.dex */
public interface h {
    public static final h a = new i0();

    long a();

    r b(Looper looper, @Nullable Handler.Callback callback);

    void c();

    long elapsedRealtime();
}
