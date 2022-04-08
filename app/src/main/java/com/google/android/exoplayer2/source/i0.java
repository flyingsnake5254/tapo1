package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.upstream.i;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: ProgressiveMediaExtractor.java */
/* loaded from: classes.dex */
public interface i0 {

    /* compiled from: ProgressiveMediaExtractor.java */
    /* loaded from: classes.dex */
    public interface a {
        i0 a();
    }

    int a(x xVar) throws IOException;

    void b();

    void c(long j, long j2);

    void d(i iVar, Uri uri, Map<String, List<String>> map, long j, long j2, l lVar) throws IOException;

    long e();

    void release();
}
