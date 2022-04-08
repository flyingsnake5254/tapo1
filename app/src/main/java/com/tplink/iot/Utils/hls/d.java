package com.tplink.iot.Utils.hls;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.t;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.c1;
import com.google.android.exoplayer2.mediacodec.s;
import java.util.ArrayList;

/* compiled from: ExoPlayerRendersFactory.java */
/* loaded from: classes2.dex */
public class d extends c1 {
    public d(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c1
    public void b(Context context, int i, s sVar, boolean z, AudioSink audioSink, Handler handler, t tVar, ArrayList<b2> arrayList) {
        super.b(context, i, sVar, z, audioSink, handler, tVar, arrayList);
        if (i != 0) {
            int size = arrayList.size();
            if (i == 2) {
                size = 0;
            }
            arrayList.add(size, new b(handler, tVar, new AudioProcessor[0]));
        }
    }
}
