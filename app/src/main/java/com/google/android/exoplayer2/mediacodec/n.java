package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayDeque;

/* compiled from: AsynchronousMediaCodecCallback.java */
@RequiresApi(23)
/* loaded from: classes.dex */
final class n extends MediaCodec.Callback {

    /* renamed from: b  reason: collision with root package name */
    private final HandlerThread f2518b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f2519c;
    @Nullable
    @GuardedBy("lock")
    private MediaFormat h;
    @Nullable
    @GuardedBy("lock")
    private MediaFormat i;
    @Nullable
    @GuardedBy("lock")
    private MediaCodec.CodecException j;
    @GuardedBy("lock")
    private long k;
    @GuardedBy("lock")
    private boolean l;
    @Nullable
    @GuardedBy("lock")
    private IllegalStateException m;
    private final Object a = new Object();
    @GuardedBy("lock")

    /* renamed from: d  reason: collision with root package name */
    private final s f2520d = new s();
    @GuardedBy("lock")

    /* renamed from: e  reason: collision with root package name */
    private final s f2521e = new s();
    @GuardedBy("lock")

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<MediaCodec.BufferInfo> f2522f = new ArrayDeque<>();
    @GuardedBy("lock")
    private final ArrayDeque<MediaFormat> g = new ArrayDeque<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(HandlerThread handlerThread) {
        this.f2518b = handlerThread;
    }

    @GuardedBy("lock")
    private void a(MediaFormat mediaFormat) {
        this.f2521e.a(-2);
        this.g.add(mediaFormat);
    }

    @GuardedBy("lock")
    private void e() {
        if (!this.g.isEmpty()) {
            this.i = this.g.getLast();
        }
        this.f2520d.b();
        this.f2521e.b();
        this.f2522f.clear();
        this.g.clear();
        this.j = null;
    }

    @GuardedBy("lock")
    private boolean h() {
        return this.k > 0 || this.l;
    }

    @GuardedBy("lock")
    private void k() {
        l();
        m();
    }

    @GuardedBy("lock")
    private void l() {
        IllegalStateException illegalStateException = this.m;
        if (illegalStateException != null) {
            this.m = null;
            throw illegalStateException;
        }
    }

    @GuardedBy("lock")
    private void m() {
        MediaCodec.CodecException codecException = this.j;
        if (codecException != null) {
            this.j = null;
            throw codecException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void i(Runnable runnable) {
        synchronized (this.a) {
            o(runnable);
        }
    }

    @GuardedBy("lock")
    private void o(Runnable runnable) {
        if (!this.l) {
            long j = this.k - 1;
            this.k = j;
            if (j <= 0) {
                if (j < 0) {
                    p(new IllegalStateException());
                    return;
                }
                e();
                try {
                    runnable.run();
                } catch (IllegalStateException e2) {
                    p(e2);
                } catch (Exception e3) {
                    p(new IllegalStateException(e3));
                }
            }
        }
    }

    private void p(IllegalStateException illegalStateException) {
        synchronized (this.a) {
            this.m = illegalStateException;
        }
    }

    public int b() {
        synchronized (this.a) {
            int i = -1;
            if (h()) {
                return -1;
            }
            k();
            if (!this.f2520d.d()) {
                i = this.f2520d.e();
            }
            return i;
        }
    }

    public int c(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.a) {
            if (h()) {
                return -1;
            }
            k();
            if (this.f2521e.d()) {
                return -1;
            }
            int e2 = this.f2521e.e();
            if (e2 >= 0) {
                g.i(this.h);
                MediaCodec.BufferInfo remove = this.f2522f.remove();
                bufferInfo.set(remove.offset, remove.size, remove.presentationTimeUs, remove.flags);
            } else if (e2 == -2) {
                this.h = this.g.remove();
            }
            return e2;
        }
    }

    public void d(final Runnable runnable) {
        synchronized (this.a) {
            this.k++;
            ((Handler) o0.i(this.f2519c)).post(new Runnable() { // from class: com.google.android.exoplayer2.mediacodec.d
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.j(runnable);
                }
            });
        }
    }

    public MediaFormat f() {
        MediaFormat mediaFormat;
        synchronized (this.a) {
            mediaFormat = this.h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public void g(MediaCodec mediaCodec) {
        g.g(this.f2519c == null);
        this.f2518b.start();
        Handler handler = new Handler(this.f2518b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f2519c = handler;
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
        synchronized (this.a) {
            this.j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i) {
        synchronized (this.a) {
            this.f2520d.a(i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i, @NonNull MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.a) {
            MediaFormat mediaFormat = this.i;
            if (mediaFormat != null) {
                a(mediaFormat);
                this.i = null;
            }
            this.f2521e.a(i);
            this.f2522f.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
        synchronized (this.a) {
            a(mediaFormat);
            this.i = null;
        }
    }

    public void q() {
        synchronized (this.a) {
            this.l = true;
            this.f2518b.quit();
            e();
        }
    }
}
