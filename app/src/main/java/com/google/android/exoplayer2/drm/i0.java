package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.e0;
import java.util.UUID;

/* compiled from: MediaDrmCallback.java */
/* loaded from: classes.dex */
public interface i0 {
    byte[] a(UUID uuid, e0.d dVar) throws MediaDrmCallbackException;

    byte[] b(UUID uuid, e0.a aVar) throws MediaDrmCallbackException;
}
