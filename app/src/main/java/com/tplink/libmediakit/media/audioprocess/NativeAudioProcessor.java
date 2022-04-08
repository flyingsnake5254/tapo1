package com.tplink.libmediakit.media.audioprocess;

import com.tplink.libmediakit.media.audioprocess.d;

/* loaded from: classes3.dex */
public abstract class NativeAudioProcessor<T extends d> extends f<T> {
    protected final String l = getClass().getSimpleName();
    private long m = r();

    static {
        System.loadLibrary("audio_proc");
    }

    public NativeAudioProcessor(c cVar, int i) {
        super(cVar, i);
    }

    private long r() {
        long nativeConstruct = nativeConstruct();
        nativeInit(nativeConstruct, this.f11942b.a);
        return nativeConstruct;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libmediakit.media.audioprocess.f
    public int l(byte[] bArr, byte[] bArr2) {
        return nativeProcess(bArr, this.f11944d, bArr2, q());
    }

    protected abstract long nativeConstruct();

    protected native void nativeDestroy(long j);

    protected native void nativeInit(long j, int i);

    protected native int nativeProcess(byte[] bArr, int i, byte[] bArr2, long j);

    protected native void nativeStop(long j);

    @Override // com.tplink.libmediakit.media.audioprocess.f
    protected boolean p() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long q() {
        return this.m;
    }

    public void s() {
        nativeStop(this.m);
        nativeDestroy(this.m);
        this.m = 0L;
    }
}
