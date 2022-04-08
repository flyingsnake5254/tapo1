package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;

/* loaded from: classes3.dex */
public class AGC<T extends d> extends NativeAudioProcessor<T> {
    public AGC(c cVar) {
        super(cVar, 5);
        if (cVar.a == 8000) {
            this.f11944d = 80;
        } else {
            this.f11944d = 160;
        }
        if (cVar.f11939d != null) {
            throw null;
        }
    }

    @Override // com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor
    protected native long nativeConstruct();
}
