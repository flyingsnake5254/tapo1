package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;

/* loaded from: classes3.dex */
public class EQ<T extends d> extends NativeAudioProcessor<T> {
    public EQ(c cVar) {
        super(cVar, 4);
        if (cVar.a == 8000) {
            this.f11944d = 80;
        } else {
            this.f11944d = 160;
        }
    }

    @Override // com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor
    protected native long nativeConstruct();
}
