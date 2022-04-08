package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.b;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Queue;

/* loaded from: classes3.dex */
public class AEC<T extends d> extends NativeAudioProcessor<T> {
    protected Queue<T> n;
    long o = 0;
    long p = 0;
    T q;

    public AEC(c cVar) {
        super(cVar, 1);
        this.f11944d = (cVar.a / 1000) * 10;
        g("sampleNumPerProcess:" + this.f11944d);
        this.f11945e = 0L;
    }

    private native void nativeSetFarValue(float f2, long j);

    private native void nativeStuffFarEndSignal(byte[] bArr, int i, long j);

    private void t() {
        long j = this.o;
        if (j == 0) {
            long j2 = this.f11945e;
            this.o = j2;
            b.AbstractC0246b bVar = this.k;
            if (bVar != null) {
                bVar.a(j2);
                return;
            }
            return;
        }
        int i = this.f11944d;
        long j3 = (i * 1000) / this.f11942b.a;
        this.o = j + j3;
        this.p += j3;
        byte[] bArr = new byte[i * 2];
        Arrays.fill(bArr, (byte) 0);
        nativeStuffFarEndSignal(bArr, this.f11944d, q());
    }

    @Override // com.tplink.libmediakit.media.audioprocess.f
    public void a() {
        super.a();
        this.q = null;
        Queue<T> queue = this.n;
        if (queue != null) {
            queue.clear();
        }
        this.f11945e = 0L;
        this.o = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libmediakit.media.audioprocess.f
    public boolean j() {
        T peek;
        while (this.o <= this.f11945e + 200 && (peek = this.n.peek()) != null) {
            if (this.q == null) {
                T t = (T) peek.i();
                this.q = t;
                if (t.f() == null) {
                    this.q.g(ByteBuffer.wrap(new byte[this.f11944d * 2]));
                }
                this.q.h(e(peek));
                this.q.b(d(peek));
            }
            b(this.n, this.q.f());
            if (this.q.f().remaining() == 0) {
                long j = this.q.j() + this.p;
                this.o = j;
                if (Math.abs(this.f11945e - j) <= this.f11942b.f11937b) {
                    nativeStuffFarEndSignal(this.q.f().array(), this.f11944d, q());
                }
                this.q = null;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor, com.tplink.libmediakit.media.audioprocess.f
    public int l(byte[] bArr, byte[] bArr2) {
        return super.l(bArr, bArr2);
    }

    @Override // com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor
    protected native long nativeConstruct();

    @Override // com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor, com.tplink.libmediakit.media.audioprocess.f
    protected boolean p() {
        if (this.f11945e - this.o <= this.f11942b.f11937b) {
            return false;
        }
        t();
        return true;
    }

    public void u(float f2) {
        nativeSetFarValue(f2, q());
    }

    public void v(Queue<T> queue) {
        this.n = queue;
    }

    public void w() {
    }
}
