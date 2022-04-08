package b.d.u;

import android.media.AudioRecord;
import android.util.Log;
import androidx.annotation.NonNull;
import b.d.p.d;
import com.tplink.libmediakit.media.audioprocess.a;
import com.tplink.libmediakit.media.audioprocess.b;
import com.tplink.libtpstreamclientmanager.m;
import com.tplink.libtpstreampreconnect.bean.TalkMode;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AecDoubleTalkClient.java */
/* loaded from: classes3.dex */
public class l extends m implements AudioRecord.OnRecordPositionUpdateListener {
    private static final String v = l.class.getSimpleName();
    private b A;
    private c B;
    private long C;
    private long E;
    private com.tplink.libmediakit.media.audioprocess.b<com.tplink.libmediakit.media.audioprocess.a> x;
    private AudioRecord w = null;
    private final LinkedBlockingQueue<com.tplink.libmediakit.media.audioprocess.a> z = new LinkedBlockingQueue<>();
    private long D = 0;
    private boolean F = false;
    private int G = 0;
    private int H = 0;
    private LinkedBlockingQueue<com.tplink.libmediakit.media.audioprocess.a> y = new LinkedBlockingQueue<>();

    /* compiled from: AecDoubleTalkClient.java */
    /* loaded from: classes3.dex */
    class a implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f747c = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("pool-AecDoubleTalkClient.speakerService-" + this.f747c.incrementAndGet());
            return thread;
        }
    }

    /* compiled from: AecDoubleTalkClient.java */
    /* loaded from: classes3.dex */
    private class b implements Callable<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        private boolean f749c = true;

        /* renamed from: d  reason: collision with root package name */
        private Future<Boolean> f750d;

        public b() {
        }

        /* renamed from: a */
        public Boolean call() throws Exception {
            while (this.f749c) {
                com.tplink.libmediakit.media.audioprocess.a aVar = (com.tplink.libmediakit.media.audioprocess.a) l.this.z.take();
                if (!(aVar.f11931d == null || l.this.x == null)) {
                    l.this.x.i(aVar);
                }
            }
            return Boolean.TRUE;
        }

        public void b(Future<Boolean> future) {
            this.f750d = future;
        }

        public void c() {
            this.f749c = false;
            l.this.z.clear();
            l.this.z.offer(new com.tplink.libmediakit.media.audioprocess.a());
            Future<Boolean> future = this.f750d;
            if (future != null) {
                future.cancel(true);
                this.f750d = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AecDoubleTalkClient.java */
    /* loaded from: classes3.dex */
    public class c extends Thread {
        public c() {
            super("tp-recorder");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[l.this.i];
            Log.d(l.v, "Recording...");
            while (l.this.m.get()) {
                if (l.this.w != null && l.this.w.getState() != 0 && l.this.E > 0 && (read = l.this.w.read(bArr, 0, l.this.i)) > 0) {
                    l lVar = l.this;
                    l.this.z.offer(new com.tplink.libmediakit.media.audioprocess.a(lVar.k, lVar.E, ByteBuffer.wrap(bArr, 0, read)));
                    l lVar2 = l.this;
                    long j = ((((lVar2.i * 8) * 1000) / lVar2.f757f) / lVar2.f756e) / lVar2.a;
                    if (!lVar2.F) {
                        l.this.F = true;
                        LinkedBlockingQueue linkedBlockingQueue = l.this.y;
                        l lVar3 = l.this;
                        linkedBlockingQueue.offer(new com.tplink.libmediakit.media.audioprocess.a(lVar3.k, (lVar3.E - 60) - j, (byte[]) bArr.clone()));
                    }
                    l lVar4 = l.this;
                    n nVar = lVar4.p;
                    if (nVar != null) {
                        nVar.b(lVar4.k, lVar4.E - 60);
                    }
                    l.n(l.this, j);
                }
            }
        }
    }

    public l(final String str, String str2) {
        super(str, str2);
        com.tplink.libmediakit.media.audioprocess.b<com.tplink.libmediakit.media.audioprocess.a> bVar = new com.tplink.libmediakit.media.audioprocess.b<>();
        this.x = bVar;
        bVar.m(this.y);
        this.x.l(8000);
        this.x.n(new b.AbstractC0246b() { // from class: b.d.u.b
            @Override // com.tplink.libmediakit.media.audioprocess.b.AbstractC0246b
            public final void a(long j) {
                l.this.w(str, j);
            }
        });
        this.x.c(1);
        this.x.c(2);
        this.x.c(6);
        this.x.c(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(String str) throws Exception {
        b.d.v.b.c cVar = this.l;
        if (cVar != null) {
            cVar.onDoubleTalkCreateSuccess(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E(String str, int i, Integer num) throws Exception {
        b.d.v.b.c cVar = this.l;
        if (cVar != null) {
            cVar.onDoubleTalkSendDataFailure(str, i, new Exception("SendDataFailure"));
        }
    }

    private void F() throws Exception {
        int i = this.a;
        int i2 = (this.j * i) / 1000;
        this.g = i2;
        this.h = (((i2 * 2) * this.f756e) * this.f757f) / 8;
        if (this.h < AudioRecord.getMinBufferSize(i, this.f753b, this.f754c)) {
            int minBufferSize = AudioRecord.getMinBufferSize(this.a, this.f753b, this.f754c);
            this.h = minBufferSize;
            this.g = minBufferSize / (((this.f756e * 2) * this.f757f) / 8);
        }
        AudioRecord audioRecord = new AudioRecord(this.f755d, this.a, this.f753b, this.f754c, this.h);
        this.w = audioRecord;
        if (audioRecord.getState() == 1) {
            this.i = ((this.g * this.f756e) * this.f757f) / 8;
            this.B = new c();
            return;
        }
        throw new Exception("AudioRecord initialization failed:" + this.w.getState());
    }

    private int G() {
        AudioRecord audioRecord = this.w;
        if (!(audioRecord == null || audioRecord.getState() == 0)) {
            this.w.release();
            this.w = null;
        }
        Log.d(v, "Audio recorder stopped");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(com.tplink.libmediakit.media.audioprocess.a aVar) {
        if (!this.s.get()) {
            byte[] bArr = aVar.f11931d;
            byte[] b2 = b.d.e.c.b(bArr, bArr.length);
            if (this.u == 0) {
                this.u = (System.currentTimeMillis() / 1000) * 90000;
            }
            byte[] k = this.t.k(b2, b2.length, this.u);
            this.u += (b2.length * 90000) / 8000;
            m.V().S(this.k, k);
        }
    }

    private void J() {
        m.V().H0(this.k);
        if (!this.m.get()) {
            this.m.set(true);
            try {
                F();
            } catch (Exception e2) {
                e2.printStackTrace();
                this.l.onDoubleTalkClose(this.k);
            }
            I();
        }
    }

    static /* synthetic */ long n(l lVar, long j) {
        long j2 = lVar.E + j;
        lVar.E = j2;
        return j2;
    }

    private float t() {
        int i = this.G;
        int i2 = ((i / 2) - this.H) / (i / 5);
        int i3 = 1;
        if (i2 == 1 || i2 == -1) {
            i2 = 0;
        }
        for (int i4 = 0; i4 < ((int) Math.log10(i2)); i4++) {
            i3 *= 10;
        }
        int i5 = i2 / i3;
        if (i5 > 0) {
            return (float) (1.0d / Math.pow(2.0d, i5));
        }
        if (i5 < 0) {
            return -i5;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w(String str, long j) {
        n nVar = this.p;
        if (nVar != null) {
            nVar.a(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(String str) throws Exception {
        b.d.v.b.c cVar = this.l;
        if (cVar != null) {
            cVar.onDoubleTalkClose(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(String str, int i, Integer num) throws Exception {
        b.d.v.b.c cVar = this.l;
        if (cVar != null) {
            cVar.onDoubleTalkCreateFailure(str, i);
        }
    }

    public int I() {
        this.w.setRecordPositionUpdateListener(this);
        int i = this.a;
        int i2 = i / 100;
        this.C = (i2 * 1000) / i;
        this.w.setPositionNotificationPeriod(i2);
        AudioRecord audioRecord = this.w;
        if (!(audioRecord == null || audioRecord.getState() == 0)) {
            this.w.startRecording();
        }
        this.B.start();
        d.a(v, "Audio recorder start");
        return 0;
    }

    public int K() {
        this.m.set(false);
        AudioRecord audioRecord = this.w;
        if (!(audioRecord == null || audioRecord.getState() == 0)) {
            this.w.stop();
        }
        c cVar = this.B;
        if (cVar != null) {
            try {
                cVar.join();
            } catch (InterruptedException e2) {
                String str = v;
                Log.d(str, "" + e2);
            }
        }
        return 0;
    }

    @Override // b.d.u.m
    public void a() {
        this.o.set(false);
        K();
        G();
        this.x.o();
        this.x.k(null);
        b bVar = this.A;
        if (bVar != null) {
            bVar.c();
        }
        this.y.clear();
        this.l = null;
        m.V().u0(this.k);
        this.t.n();
    }

    @Override // b.d.u.m
    public void b(long j, byte[] bArr) {
        if (bArr != null && TalkMode.AEC.equals(this.q)) {
            this.y.offer(new com.tplink.libmediakit.media.audioprocess.a(this.k, j, bArr));
        }
    }

    @Override // b.d.u.m
    public void c() {
        if (!this.o.get()) {
            this.o.set(true);
            this.n = Executors.newFixedThreadPool(1, new a());
            m.V().P(this.k, this, this.q);
        }
    }

    @Override // b.d.u.m
    public void f(b.d.v.b.c cVar) {
        this.l = cVar;
    }

    @Override // b.d.u.m
    public void g(int i) {
        this.G = i;
    }

    @Override // b.d.u.m
    public void i(int i) {
        this.H = i;
        com.tplink.libmediakit.media.audioprocess.b<com.tplink.libmediakit.media.audioprocess.a> bVar = this.x;
        if (bVar != null) {
            bVar.j(t());
        }
    }

    @Override // b.d.u.m, b.d.v.b.c
    public void onDoubleTalkClose(String str) {
        q.f0(str).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: b.d.u.d
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                l.this.y((String) obj);
            }
        });
    }

    @Override // b.d.u.m, b.d.v.b.c
    public void onDoubleTalkCreateFailure(final String str, final int i) {
        q.f0(1).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: b.d.u.f
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                l.this.A(str, i, (Integer) obj);
            }
        });
    }

    @Override // b.d.u.m, b.d.v.b.c
    public void onDoubleTalkCreateSuccess(String str) {
        ExecutorService executorService;
        if (this.o.get() && (executorService = this.n) != null && !executorService.isShutdown()) {
            this.x.k(new b.a() { // from class: b.d.u.e
                @Override // com.tplink.libmediakit.media.audioprocess.b.a
                public final void a(com.tplink.libmediakit.media.audioprocess.d dVar) {
                    l.this.H((a) dVar);
                }
            });
            if (this.A == null) {
                b bVar = new b();
                this.A = bVar;
                bVar.b(this.n.submit(bVar));
            }
        }
        q.f0(str).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: b.d.u.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                l.this.C((String) obj);
            }
        });
        J();
    }

    @Override // b.d.u.m, b.d.v.b.c
    public void onDoubleTalkSendDataFailure(final String str, final int i, Exception exc) {
        q.f0(1).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: b.d.u.a
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                l.this.E(str, i, (Integer) obj);
            }
        });
    }

    @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
    public void onMarkerReached(AudioRecord audioRecord) {
    }

    @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
    public void onPeriodicNotification(AudioRecord audioRecord) {
        if (this.D == 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.C;
            this.D = currentTimeMillis;
            this.E = currentTimeMillis;
        }
    }
}
