package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;

/* loaded from: classes3.dex */
public class NS<T extends d> extends NativeAudioProcessor<T> {
    private boolean n;

    public NS(c cVar) {
        super(cVar, 2);
        this.f11944d = (cVar.a / 1000) * 10;
        g("sampleNumPerProcess:" + this.f11944d);
        nativeSetAecStatus(this.n, q());
    }

    private native void nativeNotifyMotorStatus(boolean z, long j);

    private native void nativeSetAecStatus(boolean z, long j);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libmediakit.media.audioprocess.f
    public boolean j() {
        boolean z = false;
        if (this.f11942b.a(0) || this.f11942b.a(1)) {
            z = true;
        }
        if (this.n != z) {
            this.n = z;
            nativeSetAecStatus(z, q());
        }
        return super.j();
    }

    @Override // com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor
    protected native long nativeConstruct();

    public void t(boolean z) {
        nativeNotifyMotorStatus(z, q());
    }
}
