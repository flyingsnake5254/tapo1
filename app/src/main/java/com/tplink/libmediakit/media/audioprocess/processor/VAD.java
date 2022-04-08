package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;

/* loaded from: classes3.dex */
public class VAD<T extends d> extends NativeAudioProcessor<T> {
    public VAD(c cVar) {
        super(cVar, 0);
        this.f11944d = (cVar.a / 1000) * 30;
        g("sampleNumPerProcess:" + this.f11944d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libmediakit.media.audioprocess.f
    public void i(int i, T t, T t2) {
        super.i(i, t, t2);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        t2.a(z);
        byte[] array = t.f().array();
        System.arraycopy(array, 0, t2.f().array(), 0, array.length);
        h("voiceDet", "Voice:" + i);
    }

    @Override // com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor
    protected native long nativeConstruct();
}
