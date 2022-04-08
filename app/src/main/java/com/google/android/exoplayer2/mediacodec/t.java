package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.mediacodec.q;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: SynchronousMediaCodecAdapter.java */
/* loaded from: classes.dex */
public class t implements q {
    private final MediaCodec a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer[] f2535b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer[] f2536c;

    /* compiled from: SynchronousMediaCodecAdapter.java */
    /* loaded from: classes.dex */
    public static class b implements q.b {
        @Override // com.google.android.exoplayer2.mediacodec.q.b
        public q a(q.a aVar) throws IOException {
            Throwable e2;
            MediaCodec b2;
            MediaCodec mediaCodec = null;
            try {
                b2 = b(aVar);
            } catch (IOException e3) {
                e2 = e3;
            } catch (RuntimeException e4) {
                e2 = e4;
            }
            try {
                m0.a("configureCodec");
                b2.configure(aVar.f2525b, aVar.f2527d, aVar.f2528e, aVar.f2529f);
                m0.c();
                m0.a("startCodec");
                b2.start();
                m0.c();
                return new t(b2);
            } catch (IOException | RuntimeException e5) {
                e2 = e5;
                mediaCodec = b2;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e2;
            }
        }

        protected MediaCodec b(q.a aVar) throws IOException {
            g.e(aVar.a);
            String str = aVar.a.a;
            String valueOf = String.valueOf(str);
            m0.a(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            m0.c();
            return createByCodecName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(q.c cVar, MediaCodec mediaCodec, long j, long j2) {
        cVar.a(this, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void a(int i, int i2, com.google.android.exoplayer2.decoder.b bVar, long j, int i3) {
        this.a.queueSecureInputBuffer(i, i2, bVar.a(), j, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public MediaFormat b() {
        return this.a.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    @RequiresApi(23)
    public void c(final q.c cVar, Handler handler) {
        this.a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.google.android.exoplayer2.mediacodec.i
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                t.this.p(cVar, mediaCodec, j, j2);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void d(int i) {
        this.a.setVideoScalingMode(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    @Nullable
    public ByteBuffer e(int i) {
        if (o0.a >= 21) {
            return this.a.getInputBuffer(i);
        }
        return ((ByteBuffer[]) o0.i(this.f2535b))[i];
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    @RequiresApi(23)
    public void f(Surface surface) {
        this.a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void flush() {
        this.a.flush();
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void g(int i, int i2, int i3, long j, int i4) {
        this.a.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public boolean h() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    @RequiresApi(19)
    public void i(Bundle bundle) {
        this.a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    @RequiresApi(21)
    public void j(int i, long j) {
        this.a.releaseOutputBuffer(i, j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public int k() {
        return this.a.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public int l(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -3 && o0.a < 21) {
                this.f2536c = this.a.getOutputBuffers();
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void m(int i, boolean z) {
        this.a.releaseOutputBuffer(i, z);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    @Nullable
    public ByteBuffer n(int i) {
        if (o0.a >= 21) {
            return this.a.getOutputBuffer(i);
        }
        return ((ByteBuffer[]) o0.i(this.f2536c))[i];
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void release() {
        this.f2535b = null;
        this.f2536c = null;
        this.a.release();
    }

    private t(MediaCodec mediaCodec) {
        this.a = mediaCodec;
        if (o0.a < 21) {
            this.f2535b = mediaCodec.getInputBuffers();
            this.f2536c = mediaCodec.getOutputBuffers();
        }
    }
}
