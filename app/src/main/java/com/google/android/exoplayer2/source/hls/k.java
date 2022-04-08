package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.l0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: HlsExtractorFactory.java */
/* loaded from: classes.dex */
public interface k {
    public static final k a = new g();

    n a(Uri uri, Format format, @Nullable List<Format> list, l0 l0Var, Map<String, List<String>> map, com.google.android.exoplayer2.o2.k kVar) throws IOException;
}
