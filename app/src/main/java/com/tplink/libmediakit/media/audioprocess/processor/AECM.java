package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;
import java.nio.ByteBuffer;
import java.util.Queue;

/* loaded from: classes3.dex */
public class AECM<T extends d> extends NativeAudioProcessor<T> {
    protected Queue<T> n;
    long o;
    T p;

    public AECM(c cVar) {
        super(cVar, 0);
        this.f11944d = (cVar.a / 1000) * 10;
        g("sampleNumPerProcess:" + this.f11944d);
        this.f11945e = -10L;
    }

    private native void nativeStuffFarEndSignal(byte[] bArr, int i, long j);

    @Override // com.tplink.libmediakit.media.audioprocess.f
    public void a() {
        super.a();
        this.p = null;
        Queue<T> queue = this.n;
        if (queue != null) {
            queue.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libmediakit.media.audioprocess.f
    public boolean j() {
        T peek;
        long j = this.f11945e + 10;
        while (this.o <= this.f11942b.f11937b + j && (peek = this.n.peek()) != null) {
            if (this.p == null) {
                T t = (T) peek.i();
                this.p = t;
                if (t.f() == null) {
                    this.p.g(ByteBuffer.wrap(new byte[this.f11944d * 2]));
                }
                long e2 = e(peek);
                this.o = e2;
                this.p.h(e2);
                this.p.b(d(peek));
            }
            b(this.n, this.p.f());
            if (this.p.f().remaining() == 0) {
                if (Math.abs(j - this.o) <= this.f11942b.f11937b) {
                    nativeStuffFarEndSignal(this.p.f().array(), this.f11944d, q());
                }
                this.p = null;
            }
        }
        return true;
    }

    @Override // com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor
    protected native long nativeConstruct();

    public void t(Queue<T> queue) {
        this.n = queue;
    }
}
