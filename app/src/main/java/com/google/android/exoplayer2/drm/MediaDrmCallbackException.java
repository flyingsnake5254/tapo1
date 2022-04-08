package com.google.android.exoplayer2.drm;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.n;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class MediaDrmCallbackException extends IOException {
    public final long bytesLoaded;
    public final n dataSpec;
    public final Map<String, List<String>> responseHeaders;
    public final Uri uriAfterRedirects;

    public MediaDrmCallbackException(n nVar, Uri uri, Map<String, List<String>> map, long j, Throwable th) {
        super(th);
        this.dataSpec = nVar;
        this.uriAfterRedirects = uri;
        this.responseHeaders = map;
        this.bytesLoaded = j;
    }
}
