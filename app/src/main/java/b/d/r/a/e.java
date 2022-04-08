package b.d.r.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import androidx.annotation.NonNull;
import b.d.f.a;
import b.d.r.a.d;
import com.tplink.libtpappcommonmedia.bean.stream.MediaDataFormat;
import com.tplink.libtpappcommonmedia.bean.stream.StreamMediaData;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: MP4Encoder.java */
/* loaded from: classes3.dex */
public class e extends b.d.r.a.g.a implements a.AbstractC0018a, d.a {

    /* renamed from: d  reason: collision with root package name */
    private static final String f691d = "e";
    private MediaFormat J3;
    private MediaFormat K3;
    private f p3;
    private b.d.r.a.g.b z;
    private final MediaCodec.BufferInfo H3 = new MediaCodec.BufferInfo();
    private boolean y = true;
    private long M3 = 0;
    private boolean L3 = false;
    private ByteBuffer I3 = ByteBuffer.allocateDirect(524288);
    private final LinkedBlockingQueue<StreamMediaData> q = new LinkedBlockingQueue<>();
    private final b x = new b(15);
    private final b.d.f.a p0 = new b.d.f.a(this);
    private final d p1 = new d(this);
    private final c p2 = new c();

    /* renamed from: f  reason: collision with root package name */
    private final ExecutorService f692f = Executors.newSingleThreadExecutor(new a());

    /* compiled from: MP4Encoder.java */
    /* loaded from: classes3.dex */
    class a implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f693c = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("pool-MP4Encoder.encoderService-" + this.f693c.incrementAndGet());
            return thread;
        }
    }

    /* compiled from: MP4Encoder.java */
    /* loaded from: classes3.dex */
    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            if (!e.this.p0.d()) {
                e.this.p0.g(8000, 32000, 1);
            }
            StreamMediaData streamMediaData = null;
            if (!e.this.p0.d()) {
                if (e.this.z != null) {
                    e.this.z.c(-1, null, null);
                }
                e.this.h();
                return;
            }
            e.this.x.a();
            if (e.this.z != null) {
                e.this.z.recordProgress(0L);
            }
            long g = b.d.d.f.a.g();
            if (g < 0) {
                if (e.this.z != null) {
                    e.this.z.c(-3200002, null, null);
                }
                e.this.h();
                return;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = b.d.d.f.a.c() + File.separator + valueOf + ".mp4";
            e.this.p3 = new f(str);
            e.this.M3 = 0L;
            e.this.L3 = false;
            boolean z = false;
            while (true) {
                if (!((b.d.r.a.g.a) e.this).f699c.get()) {
                    i = 0;
                    break;
                }
                try {
                    streamMediaData = (StreamMediaData) e.this.q.take();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (streamMediaData != null) {
                    byte[] bArr = streamMediaData.rawData;
                    long j = streamMediaData.ptsUs;
                    if (!(bArr == null || bArr.length == 0)) {
                        MediaDataFormat mediaDataFormat = streamMediaData.format;
                        boolean z2 = streamMediaData.isKeyFrame;
                        if (!z && z2) {
                            z = true;
                        }
                        if (z) {
                            if (MediaDataFormat.VIDEO_MP2T == mediaDataFormat) {
                                if (z2 && !e.this.p2.g()) {
                                    e.this.p2.b(bArr);
                                }
                                if (e.this.p2.g() && e.this.J3 == null) {
                                    e eVar = e.this;
                                    eVar.J3 = eVar.p2.f();
                                }
                                e.this.E();
                                e.this.p1.a(bArr, j);
                                long j2 = streamMediaData.duration;
                                if (j2 > 500) {
                                    streamMediaData.duration = 70L;
                                } else if (j2 < 0) {
                                    streamMediaData.duration = 0L;
                                }
                            } else if (MediaDataFormat.AUDIO_MP2T == mediaDataFormat) {
                                try {
                                    e.this.p0.a(bArr, j);
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    Log.e(e.f691d, "e " + e3.toString());
                                }
                            }
                            g -= bArr.length;
                            e.this.D(false);
                            if (g < 0) {
                                ((b.d.r.a.g.a) e.this).f699c.set(false);
                                i = -3200003;
                                break;
                            }
                        } else {
                            continue;
                            streamMediaData = null;
                        }
                    }
                }
                streamMediaData = null;
            }
            e.this.D(true);
            if (e.this.p3 != null) {
                e.this.p3.d();
                e.this.L3 = false;
            } else {
                i = -1;
            }
            e.this.p0.h();
            if (i == -3200003) {
                if (e.this.z != null) {
                    e.this.z.c(i, valueOf, str);
                }
            } else if (i != 0) {
                b.d.d.f.a.d(str);
                if (e.this.z != null) {
                    e.this.z.c(-1, null, null);
                }
            } else if (e.this.z != null) {
                e.this.z.a(valueOf, str);
            }
        }

        /* synthetic */ b(e eVar, a aVar) {
            this();
        }
    }

    public e() {
        this.f699c.set(false);
    }

    private void A(byte[] bArr, long j) {
        StreamMediaData streamMediaData = new StreamMediaData();
        streamMediaData.format = MediaDataFormat.VIDEO_MP2T;
        streamMediaData.offset = 0;
        streamMediaData.size = bArr.length;
        if ((bArr[4] & 31) == 5) {
            streamMediaData.flags = 1;
        } else if ((bArr[4] & 31) == 7 || (bArr[4] & 31) == 8) {
            streamMediaData.flags = 2;
        } else {
            streamMediaData.flags = 0;
        }
        streamMediaData.rawData = bArr;
        streamMediaData.ptsUs = j;
        this.x.c(streamMediaData);
    }

    private boolean B(StreamMediaData streamMediaData) {
        if (streamMediaData == null || streamMediaData.rawData == null) {
            return false;
        }
        if (MediaDataFormat.VIDEO_MP2T != streamMediaData.format || !streamMediaData.isKeyFrame) {
            return true;
        }
        if (!this.p2.g()) {
            this.p2.b(streamMediaData.rawData);
        }
        if (!this.p2.g() || this.J3 != null) {
            return true;
        }
        this.J3 = this.p2.f();
        return true;
    }

    private void C(StreamMediaData streamMediaData) {
        if (this.y && streamMediaData != null && streamMediaData.rawData != null && B(streamMediaData)) {
            if (!this.f699c.get() && streamMediaData.isKeyFrame) {
                this.q.clear();
            }
            this.q.offer(streamMediaData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z) {
        byte[] bArr;
        do {
            StreamMediaData g = this.x.g();
            if (g == null || (bArr = g.rawData) == null) {
                z = false;
                continue;
            } else {
                MediaCodec.BufferInfo bufferInfo = this.H3;
                bufferInfo.size = g.size;
                bufferInfo.flags = g.flags;
                bufferInfo.offset = g.offset;
                bufferInfo.presentationTimeUs = g.ptsUs;
                ByteBuffer byteBuffer = this.I3;
                if (byteBuffer == null || bArr.length > byteBuffer.capacity()) {
                    this.I3 = ByteBuffer.allocateDirect(g.rawData.length);
                }
                this.I3.clear();
                this.I3.put(g.rawData);
                if (g.format == MediaDataFormat.VIDEO_MP2T) {
                    G(this.H3, this.I3, g.ptsUs);
                    continue;
                } else {
                    F(this.H3, this.I3, g.ptsUs);
                    continue;
                }
            }
        } while (z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        MediaFormat mediaFormat;
        if (!this.L3 && (mediaFormat = this.J3) != null && this.K3 != null) {
            this.p3.b(mediaFormat);
            this.p3.a(this.K3);
            this.p3.c();
            this.L3 = true;
        }
    }

    private void F(MediaCodec.BufferInfo bufferInfo, ByteBuffer byteBuffer, long j) {
        f fVar = this.p3;
        if (fVar != null && this.L3) {
            if (this.M3 <= 0) {
                this.M3 = j;
            }
            long j2 = j - this.M3;
            bufferInfo.presentationTimeUs = j2;
            if (j2 >= 0) {
                fVar.e(byteBuffer, bufferInfo);
            }
        }
    }

    private void G(MediaCodec.BufferInfo bufferInfo, ByteBuffer byteBuffer, long j) {
        if (this.p3 != null && this.L3) {
            if (this.M3 <= 0) {
                this.M3 = j;
            }
            long j2 = j - this.M3;
            bufferInfo.presentationTimeUs = j2;
            if (j2 >= 0) {
                b.d.r.a.g.b bVar = this.z;
                if (bVar != null) {
                    bVar.recordProgress(j2 / 1000);
                }
                this.p3.g(byteBuffer, bufferInfo);
            }
        }
    }

    private void z(MediaCodec.BufferInfo bufferInfo, ByteBuffer byteBuffer, long j) {
        if ((bufferInfo.flags & 2) == 0) {
            StreamMediaData streamMediaData = new StreamMediaData();
            streamMediaData.format = MediaDataFormat.AUDIO_MP2T;
            streamMediaData.offset = 0;
            int i = bufferInfo.size;
            streamMediaData.size = i;
            streamMediaData.flags = bufferInfo.flags;
            byte[] bArr = new byte[i];
            streamMediaData.rawData = bArr;
            byteBuffer.get(bArr);
            streamMediaData.ptsUs = j;
            this.x.c(streamMediaData);
        }
    }

    @Override // b.d.f.a.AbstractC0018a
    public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j) {
        E();
        z(bufferInfo, byteBuffer, j);
    }

    @Override // b.d.f.a.AbstractC0018a
    public void b(MediaFormat mediaFormat) {
        if (this.K3 == null) {
            this.K3 = mediaFormat;
        }
        E();
    }

    @Override // b.d.r.a.d.a
    public void c(byte[] bArr, long j) {
        E();
        A(bArr, j);
    }

    @Override // b.d.r.a.g.a
    public void d() {
        this.y = false;
        this.q.clear();
        this.x.a();
        this.I3 = null;
    }

    @Override // b.d.r.a.g.a
    public void e(StreamMediaData streamMediaData) {
        C(streamMediaData);
    }

    @Override // b.d.r.a.g.a
    public void f(b.d.r.a.g.b bVar) {
        this.z = bVar;
    }

    @Override // b.d.r.a.g.a
    public void g() {
        this.f699c.set(true);
        this.f692f.submit(new b(this, null));
    }

    @Override // b.d.r.a.g.a
    public void h() {
        this.f699c.set(false);
        this.q.offer(new StreamMediaData());
        this.p2.c();
    }
}
