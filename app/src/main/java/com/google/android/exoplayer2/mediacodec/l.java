package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.mediacodec.l;
import com.google.android.exoplayer2.mediacodec.q;
import com.google.android.exoplayer2.util.m0;
import com.google.common.base.t;
import com.tplink.cloud.bean.push.NotificationMsgBean;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsynchronousMediaCodecAdapter.java */
@RequiresApi(23)
/* loaded from: classes.dex */
public final class l implements q {
    private final MediaCodec a;

    /* renamed from: b  reason: collision with root package name */
    private final n f2499b;

    /* renamed from: c  reason: collision with root package name */
    private final m f2500c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2501d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2502e;

    /* renamed from: f  reason: collision with root package name */
    private int f2503f;

    /* compiled from: AsynchronousMediaCodecAdapter.java */
    /* loaded from: classes.dex */
    public static final class b implements q.b {

        /* renamed from: b  reason: collision with root package name */
        private final t<HandlerThread> f2504b;

        /* renamed from: c  reason: collision with root package name */
        private final t<HandlerThread> f2505c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f2506d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f2507e;

        public b(final int i, boolean z, boolean z2) {
            this(new t() { // from class: com.google.android.exoplayer2.mediacodec.a
                @Override // com.google.common.base.t
                public final Object get() {
                    return l.b.c(i);
                }
            }, new t() { // from class: com.google.android.exoplayer2.mediacodec.b
                @Override // com.google.common.base.t
                public final Object get() {
                    return l.b.d(i);
                }
            }, z, z2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ HandlerThread c(int i) {
            return new HandlerThread(l.r(i));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ HandlerThread d(int i) {
            return new HandlerThread(l.s(i));
        }

        /* renamed from: b */
        public l a(q.a aVar) throws IOException {
            Exception e2;
            MediaCodec mediaCodec;
            String str = aVar.a.a;
            l lVar = null;
            try {
                String valueOf = String.valueOf(str);
                m0.a(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                mediaCodec = MediaCodec.createByCodecName(str);
                try {
                    l lVar2 = new l(mediaCodec, this.f2504b.get(), this.f2505c.get(), this.f2506d, this.f2507e);
                    try {
                        m0.c();
                        lVar2.u(aVar.f2525b, aVar.f2527d, aVar.f2528e, aVar.f2529f);
                        return lVar2;
                    } catch (Exception e3) {
                        e2 = e3;
                        lVar = lVar2;
                        if (lVar != null) {
                            lVar.release();
                        } else if (mediaCodec != null) {
                            mediaCodec.release();
                        }
                        throw e2;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                }
            } catch (Exception e5) {
                e2 = e5;
                mediaCodec = null;
            }
        }

        @VisibleForTesting
        b(t<HandlerThread> tVar, t<HandlerThread> tVar2, boolean z, boolean z2) {
            this.f2504b = tVar;
            this.f2505c = tVar2;
            this.f2506d = z;
            this.f2507e = z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String r(int i) {
        return t(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(int i) {
        return t(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String t(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append(NotificationMsgBean.MsgType.AUDIO);
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i) {
        this.f2499b.g(this.a);
        m0.a("configureCodec");
        this.a.configure(mediaFormat, surface, mediaCrypto, i);
        m0.c();
        this.f2500c.s();
        m0.a("startCodec");
        this.a.start();
        m0.c();
        this.f2503f = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w(q.c cVar, MediaCodec mediaCodec, long j, long j2) {
        cVar.a(this, j, j2);
    }

    private void x() {
        if (this.f2501d) {
            try {
                this.f2500c.t();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void a(int i, int i2, com.google.android.exoplayer2.decoder.b bVar, long j, int i3) {
        this.f2500c.o(i, i2, bVar, j, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public MediaFormat b() {
        return this.f2499b.f();
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void c(final q.c cVar, Handler handler) {
        x();
        this.a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.google.android.exoplayer2.mediacodec.c
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                l.this.w(cVar, mediaCodec, j, j2);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void d(int i) {
        x();
        this.a.setVideoScalingMode(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    @Nullable
    public ByteBuffer e(int i) {
        return this.a.getInputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void f(Surface surface) {
        x();
        this.a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void flush() {
        this.f2500c.i();
        this.a.flush();
        n nVar = this.f2499b;
        final MediaCodec mediaCodec = this.a;
        Objects.requireNonNull(mediaCodec);
        nVar.d(new Runnable() { // from class: com.google.android.exoplayer2.mediacodec.j
            @Override // java.lang.Runnable
            public final void run() {
                mediaCodec.start();
            }
        });
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void g(int i, int i2, int i3, long j, int i4) {
        this.f2500c.n(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public boolean h() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void i(Bundle bundle) {
        x();
        this.a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void j(int i, long j) {
        this.a.releaseOutputBuffer(i, j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public int k() {
        return this.f2499b.b();
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public int l(MediaCodec.BufferInfo bufferInfo) {
        return this.f2499b.c(bufferInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void m(int i, boolean z) {
        this.a.releaseOutputBuffer(i, z);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    @Nullable
    public ByteBuffer n(int i) {
        return this.a.getOutputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void release() {
        try {
            if (this.f2503f == 1) {
                this.f2500c.r();
                this.f2499b.q();
            }
            this.f2503f = 2;
        } finally {
            if (!this.f2502e) {
                this.a.release();
                this.f2502e = true;
            }
        }
    }

    private l(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z, boolean z2) {
        this.a = mediaCodec;
        this.f2499b = new n(handlerThread);
        this.f2500c = new m(mediaCodec, handlerThread2, z);
        this.f2501d = z2;
        this.f2503f = 0;
    }
}
