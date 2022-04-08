package com.google.android.exoplayer2.audio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: SonicAudioProcessor.java */
/* loaded from: classes.dex */
public final class j0 implements AudioProcessor {

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.a f2085e;

    /* renamed from: f  reason: collision with root package name */
    private AudioProcessor.a f2086f;
    private AudioProcessor.a g;
    private AudioProcessor.a h;
    private boolean i;
    @Nullable
    private i0 j;
    private ByteBuffer k;
    private ShortBuffer l;
    private ByteBuffer m;
    private long n;
    private long o;
    private boolean p;

    /* renamed from: c  reason: collision with root package name */
    private float f2083c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f2084d = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    private int f2082b = -1;

    public j0() {
        AudioProcessor.a aVar = AudioProcessor.a.a;
        this.f2085e = aVar;
        this.f2086f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer a() {
        int k;
        i0 i0Var = this.j;
        if (i0Var != null && (k = i0Var.k()) > 0) {
            if (this.k.capacity() < k) {
                ByteBuffer order = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
                this.k = order;
                this.l = order.asShortBuffer();
            } else {
                this.k.clear();
                this.l.clear();
            }
            i0Var.j(this.l);
            this.o += k;
            this.k.limit(k);
            this.m = this.k;
        }
        ByteBuffer byteBuffer = this.m;
        this.m = AudioProcessor.a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void b(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.n += remaining;
            ((i0) g.e(this.j)).t(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.a c(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f2020d == 2) {
            int i = this.f2082b;
            if (i == -1) {
                i = aVar.f2018b;
            }
            this.f2085e = aVar;
            AudioProcessor.a aVar2 = new AudioProcessor.a(i, aVar.f2019c, 2);
            this.f2086f = aVar2;
            this.i = true;
            return aVar2;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean d() {
        i0 i0Var;
        return this.p && ((i0Var = this.j) == null || i0Var.k() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e() {
        i0 i0Var = this.j;
        if (i0Var != null) {
            i0Var.s();
        }
        this.p = true;
    }

    public long f(long j) {
        if (this.o < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return (long) (this.f2083c * j);
        }
        long l = this.n - ((i0) g.e(this.j)).l();
        int i = this.h.f2018b;
        int i2 = this.g.f2018b;
        if (i == i2) {
            return o0.C0(j, l, this.o);
        }
        return o0.C0(j, l * i, this.o * i2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.a aVar = this.f2085e;
            this.g = aVar;
            AudioProcessor.a aVar2 = this.f2086f;
            this.h = aVar2;
            if (this.i) {
                this.j = new i0(aVar.f2018b, aVar.f2019c, this.f2083c, this.f2084d, aVar2.f2018b);
            } else {
                i0 i0Var = this.j;
                if (i0Var != null) {
                    i0Var.i();
                }
            }
        }
        this.m = AudioProcessor.a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    public void g(float f2) {
        if (this.f2084d != f2) {
            this.f2084d = f2;
            this.i = true;
        }
    }

    public void h(float f2) {
        if (this.f2083c != f2) {
            this.f2083c = f2;
            this.i = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f2086f.f2018b != -1 && (Math.abs(this.f2083c - 1.0f) >= 1.0E-4f || Math.abs(this.f2084d - 1.0f) >= 1.0E-4f || this.f2086f.f2018b != this.f2085e.f2018b);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.f2083c = 1.0f;
        this.f2084d = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.a;
        this.f2085e = aVar;
        this.f2086f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.f2082b = -1;
        this.i = false;
        this.j = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }
}
