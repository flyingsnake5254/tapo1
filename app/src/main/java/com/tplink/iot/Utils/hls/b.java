package com.tplink.iot.Utils.hls;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.a0;
import com.google.android.exoplayer2.audio.t;
import com.google.android.exoplayer2.drm.d0;

/* compiled from: ExoPlayerAudioRender.java */
/* loaded from: classes2.dex */
public class b extends a0<c> {
    c d4;

    public b(@Nullable Handler handler, @Nullable t tVar, AudioSink audioSink) {
        super(handler, tVar, audioSink);
    }

    @Override // com.google.android.exoplayer2.audio.a0
    protected int c0(Format format) {
        return "audio/mpeg".equals(format.H3) ? 4 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e0 */
    public c P(Format format, d0 d0Var) throws Mp3DecoderException {
        c cVar = new c(c.n);
        this.d4 = cVar;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f0 */
    public Format T(c cVar) {
        return new Format.b().e0("audio/raw").H(cVar.x()).f0(cVar.z()).Y(cVar.y()).E();
    }

    @Override // com.google.android.exoplayer2.b2, com.google.android.exoplayer2.d2
    public String getName() {
        return "ExoPlayerAudioRender";
    }

    @Override // com.google.android.exoplayer2.u0, com.google.android.exoplayer2.d2
    public int s() throws ExoPlaybackException {
        return 0;
    }

    public b(@Nullable Handler handler, @Nullable t tVar, AudioProcessor... audioProcessorArr) {
        this(handler, tVar, new DefaultAudioSink(null, audioProcessorArr));
    }
}
