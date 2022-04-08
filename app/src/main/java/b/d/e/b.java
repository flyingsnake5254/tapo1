package b.d.e;

import androidx.annotation.NonNull;
import b.d.p.d;
import com.tplink.libtpappcommonmedia.bean.stream.StreamMediaData;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: AudioDecoderImpl.java */
/* loaded from: classes3.dex */
public class b implements a {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f379b;

    /* renamed from: c  reason: collision with root package name */
    private b.d.g.b f380c;

    /* renamed from: d  reason: collision with root package name */
    private int f381d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f382e;

    /* renamed from: f  reason: collision with root package name */
    protected AtomicLong f383f;
    private ExecutorService g;
    private final long h = 1000;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AudioDecoderImpl.java */
    /* loaded from: classes3.dex */
    public class a implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f384c = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("pool-AudioSoftwareDecoder-" + this.f384c.incrementAndGet());
            return thread;
        }
    }

    /* compiled from: AudioDecoderImpl.java */
    /* renamed from: b.d.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class RunnableC0017b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        StreamMediaData f386c;

        public RunnableC0017b(StreamMediaData streamMediaData) {
            this.f386c = streamMediaData;
        }

        @Override // java.lang.Runnable
        public void run() {
            StreamMediaData streamMediaData;
            byte[] bArr;
            if (b.this.a && !b.this.f382e && (streamMediaData = this.f386c) != null && (bArr = streamMediaData.rawData) != null && bArr.length != 0) {
                if (!b.this.f379b) {
                    try {
                        b.this.f380c = new b.d.g.b(11, 4, b.this.f381d);
                        b.this.f380c.h();
                        b.this.f379b = true;
                    } catch (Exception unused) {
                        b.this.f379b = false;
                    }
                }
                if (b.this.f379b) {
                    long j = this.f386c.playTimeMs;
                    if (b.this.i || b.this.f383f.get() <= 0 || b.this.f383f.get() - j <= 1000) {
                        b.this.i = false;
                        b.this.f380c.d(new com.tplink.libmediakit.media.audioprocess.a(this.f386c.deviceIdMD5, System.currentTimeMillis(), bArr));
                        return;
                    }
                    d.a("AudioDecoderImpl", "video " + b.this.f383f.get() + " audio " + j + " mut " + (b.this.f383f.get() - j));
                    b.this.i = true;
                }
            }
        }
    }

    public b(int i) {
        q(i);
    }

    private void q(int i) {
        this.a = true;
        this.f379b = false;
        this.f382e = false;
        this.i = false;
        this.f383f = new AtomicLong(0L);
        if (i <= 0) {
            i = 3;
        }
        this.f381d = i;
        this.g = Executors.newSingleThreadExecutor(new a());
    }

    @Override // b.d.e.a
    public void a(StreamMediaData streamMediaData) {
        this.g.submit(new RunnableC0017b(streamMediaData));
    }

    @Override // b.d.e.a
    public void b(boolean z) {
        this.f382e = z;
    }

    @Override // b.d.e.a
    public void c() {
        b.d.g.b bVar = this.f380c;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // b.d.e.a
    public void d(float f2) {
        b.d.g.b bVar = this.f380c;
        if (bVar != null) {
            bVar.i(f2);
        }
    }

    @Override // b.d.e.a
    public void destroy() {
        this.a = false;
        b.d.g.b bVar = this.f380c;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // b.d.e.a
    public void e(long j) {
        this.f383f.set(j);
    }

    @Override // b.d.e.a
    public float f() {
        b.d.g.b bVar = this.f380c;
        if (bVar != null) {
            return bVar.b();
        }
        return 1.0f;
    }

    @Override // b.d.e.a
    public void g() {
        b.d.g.b bVar = this.f380c;
        if (bVar != null) {
            bVar.f();
        }
    }
}
