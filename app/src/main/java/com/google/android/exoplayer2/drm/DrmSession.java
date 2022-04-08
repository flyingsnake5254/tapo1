package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public interface DrmSession {

    /* loaded from: classes.dex */
    public static class DrmSessionException extends IOException {
        public final int errorCode;

        public DrmSessionException(Throwable th, int i) {
            super(th);
            this.errorCode = i;
        }
    }

    void a(@Nullable v.a aVar);

    void b(@Nullable v.a aVar);

    UUID c();

    boolean d();

    @Nullable
    d0 e();

    @Nullable
    DrmSessionException f();

    @Nullable
    Map<String, String> g();

    int getState();
}
