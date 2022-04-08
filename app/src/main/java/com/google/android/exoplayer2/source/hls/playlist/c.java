package com.google.android.exoplayer2.source.hls.playlist;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.y;

/* compiled from: DefaultHlsPlaylistParserFactory.java */
/* loaded from: classes.dex */
public final class c implements i {
    @Override // com.google.android.exoplayer2.source.hls.playlist.i
    public y.a<h> a(f fVar, @Nullable g gVar) {
        return new HlsPlaylistParser(fVar, gVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.i
    public y.a<h> b() {
        return new HlsPlaylistParser();
    }
}
