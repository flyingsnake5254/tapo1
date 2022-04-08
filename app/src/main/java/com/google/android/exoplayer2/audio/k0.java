package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;

/* compiled from: TrimmingAudioProcessor.java */
/* loaded from: classes.dex */
final class k0 extends y {
    private int i;
    private int j;
    private boolean k;
    private int l;
    private byte[] m = o0.f3937f;
    private int n;
    private long o;

    @Override // com.google.android.exoplayer2.audio.y, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer a() {
        int i;
        if (super.d() && (i = this.n) > 0) {
            k(i).put(this.m, 0, this.n).flip();
            this.n = 0;
        }
        return super.a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (i != 0) {
            int min = Math.min(i, this.l);
            this.o += min / this.f2135b.f2021e;
            this.l -= min;
            byteBuffer.position(position + min);
            if (this.l <= 0) {
                int i2 = i - min;
                int length = (this.n + i2) - this.m.length;
                ByteBuffer k = k(length);
                int p = o0.p(length, 0, this.n);
                k.put(this.m, 0, p);
                int p2 = o0.p(length - p, 0, i2);
                byteBuffer.limit(byteBuffer.position() + p2);
                k.put(byteBuffer);
                byteBuffer.limit(limit);
                int i3 = i2 - p2;
                int i4 = this.n - p;
                this.n = i4;
                byte[] bArr = this.m;
                System.arraycopy(bArr, p, bArr, 0, i4);
                byteBuffer.get(this.m, this.n, i3);
                this.n += i3;
                k.flip();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.y, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean d() {
        return super.d() && this.n == 0;
    }

    @Override // com.google.android.exoplayer2.audio.y
    public AudioProcessor.a g(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f2020d == 2) {
            this.k = true;
            return (this.i == 0 && this.j == 0) ? AudioProcessor.a.a : aVar;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.y
    protected void h() {
        if (this.k) {
            this.k = false;
            int i = this.j;
            int i2 = this.f2135b.f2021e;
            this.m = new byte[i * i2];
            this.l = this.i * i2;
        }
        this.n = 0;
    }

    @Override // com.google.android.exoplayer2.audio.y
    protected void i() {
        int i;
        if (this.k) {
            if (this.n > 0) {
                this.o += i / this.f2135b.f2021e;
            }
            this.n = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.y
    protected void j() {
        this.m = o0.f3937f;
    }

    public long l() {
        return this.o;
    }

    public void m() {
        this.o = 0L;
    }

    public void n(int i, int i2) {
        this.i = i;
        this.j = i2;
    }
}
