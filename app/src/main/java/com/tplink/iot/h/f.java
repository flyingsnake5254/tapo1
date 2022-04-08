package com.tplink.iot.h;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.recyclerview.widget.ItemTouchHelper;
import b.d.q.b.l;
import com.tplink.iot.h.f;
import com.tplink.libtpcommonstream.stream.control.common.ClientType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.p;

/* compiled from: M3U8DownloadTask.java */
/* loaded from: classes2.dex */
public class f {
    private static int a;

    /* renamed from: b  reason: collision with root package name */
    private static int f7974b;

    /* renamed from: c  reason: collision with root package name */
    private static long f7975c;

    /* renamed from: e  reason: collision with root package name */
    private com.tplink.iot.h.i.b f7977e;

    /* renamed from: f  reason: collision with root package name */
    private String f7978f;
    private String g;
    private String m;
    private Timer r;
    private ExecutorService s;
    private b.d.y.a t;

    /* renamed from: d  reason: collision with root package name */
    private final String f7976d = f.class.getSimpleName();
    private String h = "";
    private long i = 0;
    private long j = 0;
    private float k = 0.0f;
    private boolean l = false;
    private int n = 1;
    private boolean o = true;
    private int p = 1800000;
    private int q = 10000;
    private Handler u = new a();

    /* compiled from: M3U8DownloadTask.java */
    /* loaded from: classes2.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    f.this.f7977e.onError((Throwable) message.obj);
                    return;
                case 1002:
                    f.this.f7977e.a(f.this.j, f.this.i, f.a);
                    return;
                case 1003:
                    if (f.this.r != null) {
                        f.this.r.cancel();
                    }
                    f fVar = f.this;
                    int C = fVar.C(fVar.B());
                    if (C == 0) {
                        C = (int) Math.ceil(f.this.k);
                    }
                    f.this.f7977e.b(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, C);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: M3U8DownloadTask.java */
    /* loaded from: classes2.dex */
    public class b implements com.tplink.iot.h.i.c {

        /* compiled from: M3U8DownloadTask.java */
        /* loaded from: classes2.dex */
        class a extends Thread {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ com.tplink.iot.h.h.a f7979c;

            a(com.tplink.iot.h.h.a aVar) {
                this.f7979c = aVar;
            }

            private /* synthetic */ p a(String str) {
                f fVar = f.this;
                fVar.D(new FileNotFoundException(str + " doesn't exit!"));
                return null;
            }

            private /* synthetic */ p c() {
                f.this.u.sendEmptyMessage(1003);
                return null;
            }

            private /* synthetic */ p e(IOException iOException) {
                f.this.D(iOException);
                return null;
            }

            private /* synthetic */ p g() {
                f.this.l = false;
                if (!f.this.o) {
                    return null;
                }
                com.tplink.iot.h.j.a.a(new File(f.this.f7978f));
                return null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: i */
            public /* synthetic */ void j() {
                com.tplink.iot.h.j.a.a(new File(f.this.f7978f));
            }

            public /* synthetic */ p b(String str) {
                a(str);
                return null;
            }

            public /* synthetic */ p d() {
                c();
                return null;
            }

            public /* synthetic */ p f(IOException iOException) {
                e(iOException);
                return null;
            }

            public /* synthetic */ p h() {
                g();
                return null;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    f.this.F(this.f7979c);
                    if (f.this.s != null) {
                        f.this.s.shutdown();
                    }
                    while (f.this.s != null && !f.this.s.isTerminated()) {
                        Thread.sleep(100L);
                    }
                    f.this.t = new b.d.y.a();
                    if (f.this.l) {
                        String str = f.this.g + f.this.h;
                        l.d(str);
                        final String str2 = f.this.f7978f + "downloading.ts";
                        f.this.t.h(new File(str2), new File(str), 10, new kotlin.jvm.b.a() { // from class: com.tplink.iot.h.a
                            @Override // kotlin.jvm.b.a
                            public final Object invoke() {
                                f.b.a.this.b(str2);
                                return null;
                            }
                        }, new kotlin.jvm.b.a() { // from class: com.tplink.iot.h.e
                            @Override // kotlin.jvm.b.a
                            public final Object invoke() {
                                f.b.a.this.d();
                                return null;
                            }
                        }, new kotlin.jvm.b.l() { // from class: com.tplink.iot.h.d
                            @Override // kotlin.jvm.b.l
                            public final Object invoke(Object obj) {
                                f.b.a.this.f((IOException) obj);
                                return null;
                            }
                        }, new kotlin.jvm.b.a() { // from class: com.tplink.iot.h.b
                            @Override // kotlin.jvm.b.a
                            public final Object invoke() {
                                f.b.a.this.h();
                                return null;
                            }
                        });
                    }
                } catch (InterruptedException e2) {
                    f.this.D(e2);
                }
            }
        }

        b() {
        }

        @Override // com.tplink.iot.h.i.c
        public void c(com.tplink.iot.h.h.a aVar) {
            new a(aVar).start();
        }

        @Override // com.tplink.iot.h.i.a
        public void onError(Throwable th) {
            f.this.D(th);
        }

        @Override // com.tplink.iot.h.i.a
        public void onStart() {
            f.this.f7977e.onStart();
            f.this.l = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: M3U8DownloadTask.java */
    /* loaded from: classes2.dex */
    public class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            f.this.u.sendEmptyMessage(1002);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: M3U8DownloadTask.java */
    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f7982c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.tplink.iot.h.h.a f7983d;

        d(File file, com.tplink.iot.h.h.a aVar) {
            this.f7982c = file;
            this.f7983d = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
            if (r3 == null) goto L_0x00d3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a6, code lost:
            r3.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00bd, code lost:
            if (r3 == null) goto L_0x00d3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00d0, code lost:
            if (r3 == null) goto L_0x00d3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00d3, code lost:
            com.tplink.iot.h.f.p();
            r0 = com.tplink.iot.h.f.f7975c = r0.length();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00dd, code lost:
            return;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r2v16, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v9 */
        /* JADX WARN: Unknown variable types count: 2 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 237
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.h.f.d.run():void");
        }
    }

    public f(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(b.d.q.b.p.b.h());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("cloudvideo");
        sb.append(str2);
        sb.append("m3u8TempDownload");
        sb.append(str2);
        this.f7978f = sb.toString();
        this.g = b.d.q.b.p.b.h() + str2 + "cloudvideo" + str2 + ClientType.DOWNLOAD + str2;
        this.m = "0";
        this.m = str;
    }

    private void A(String str, String str2) {
        g.d().e(str, str2, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Throwable th) {
        if (!"Task running".equals(th.getMessage())) {
            G();
        }
        if (!"thread interrupted".equals(th.getMessage())) {
            Message obtainMessage = this.u.obtainMessage();
            obtainMessage.obj = th;
            obtainMessage.what = 1001;
            this.u.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(com.tplink.iot.h.h.a aVar) {
        if (aVar == null) {
            D(new Throwable("M3U8 is invalid"));
            return;
        }
        File file = new File(this.f7978f);
        if (!file.exists()) {
            file.mkdirs();
        } else {
            com.tplink.iot.h.j.a.b(file);
        }
        f7974b = aVar.c().size();
        for (com.tplink.iot.h.h.b bVar : aVar.c()) {
            if (bVar != null) {
                this.j += bVar.b();
                this.k += bVar.c();
            }
        }
        ExecutorService executorService = this.s;
        if (executorService != null && executorService.isTerminated()) {
            this.s.shutdownNow();
            this.s = null;
        }
        this.s = Executors.newFixedThreadPool(this.n);
        aVar.b();
        Timer timer = new Timer();
        this.r = timer;
        timer.schedule(new c(), 0L, 1000L);
        this.s.execute(new d(file, aVar));
    }

    private void G() {
        Timer timer = this.r;
        if (timer != null) {
            timer.cancel();
            this.r = null;
        }
        this.l = false;
        ExecutorService executorService = this.s;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }

    static /* synthetic */ String f(f fVar) {
        return fVar.f7976d;
    }

    static /* synthetic */ boolean g(f fVar) {
        return fVar.o;
    }

    static /* synthetic */ Handler h(f fVar) {
        return fVar.u;
    }

    static /* synthetic */ int p() {
        int i = a;
        a = i + 1;
        return i;
    }

    static /* synthetic */ boolean x(f fVar, boolean z) {
        fVar.l = z;
        return z;
    }

    public String B() {
        String str = this.h;
        if (str == null || str.isEmpty()) {
            return "";
        }
        return this.g + this.h;
    }

    public int C(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (extractMetadata != null && !"0".equals(extractMetadata)) {
                return Math.round(Float.parseFloat(extractMetadata) / 1000.0f);
            }
            return 0;
        } catch (Throwable th) {
            b.d.w.c.a.e(this.f7976d, Log.getStackTraceString(th));
            return 0;
        }
    }

    public boolean E() {
        return this.l;
    }

    public void y() {
        if (this.l) {
            D(new Throwable("Download task cancelled by user"));
        }
    }

    public void z(String str, String str2, String str3, com.tplink.iot.h.i.b bVar) {
        if (str == null || str.isEmpty()) {
            D(new Throwable("uuid invalid"));
            return;
        }
        this.h = str;
        this.f7977e = bVar;
        if (!E()) {
            A(str2, str3);
        } else {
            D(new Throwable("Task running"));
        }
    }
}
