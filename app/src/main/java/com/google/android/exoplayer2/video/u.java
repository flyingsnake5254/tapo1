package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.firebase.messaging.Constants;

/* compiled from: VideoFrameReleaseHelper.java */
/* loaded from: classes.dex */
public final class u {
    private final o a = new o();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final a f4066b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final d f4067c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4068d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Surface f4069e;

    /* renamed from: f  reason: collision with root package name */
    private float f4070f;
    private float g;
    private float h;
    private float i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoFrameReleaseHelper.java */
    /* loaded from: classes.dex */
    public interface a {

        /* compiled from: VideoFrameReleaseHelper.java */
        /* renamed from: com.google.android.exoplayer2.video.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface AbstractC0090a {
            void a(@Nullable Display display);
        }

        void a(AbstractC0090a aVar);

        void unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoFrameReleaseHelper.java */
    /* loaded from: classes.dex */
    public static final class b implements a {
        private final WindowManager a;

        private b(WindowManager windowManager) {
            this.a = windowManager;
        }

        @Nullable
        public static a b(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new b(windowManager);
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.video.u.a
        public void a(a.AbstractC0090a aVar) {
            aVar.a(this.a.getDefaultDisplay());
        }

        @Override // com.google.android.exoplayer2.video.u.a
        public void unregister() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoFrameReleaseHelper.java */
    @RequiresApi(17)
    /* loaded from: classes.dex */
    public static final class c implements a, DisplayManager.DisplayListener {
        private final DisplayManager a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private a.AbstractC0090a f4071b;

        private c(DisplayManager displayManager) {
            this.a = displayManager;
        }

        private Display b() {
            return this.a.getDisplay(0);
        }

        @Nullable
        public static a c(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
            if (displayManager != null) {
                return new c(displayManager);
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.video.u.a
        public void a(a.AbstractC0090a aVar) {
            this.f4071b = aVar;
            this.a.registerDisplayListener(this, o0.v());
            aVar.a(b());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            a.AbstractC0090a aVar = this.f4071b;
            if (aVar != null && i == 0) {
                aVar.a(b());
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }

        @Override // com.google.android.exoplayer2.video.u.a
        public void unregister() {
            this.a.unregisterDisplayListener(this);
            this.f4071b = null;
        }
    }

    /* compiled from: VideoFrameReleaseHelper.java */
    /* loaded from: classes.dex */
    private static final class d implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: c  reason: collision with root package name */
        private static final d f4072c = new d();

        /* renamed from: d  reason: collision with root package name */
        public volatile long f4073d = -9223372036854775807L;

        /* renamed from: f  reason: collision with root package name */
        private final Handler f4074f;
        private final HandlerThread q;
        private Choreographer x;
        private int y;

        private d() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.q = handlerThread;
            handlerThread.start();
            Handler u = o0.u(handlerThread.getLooper(), this);
            this.f4074f = u;
            u.sendEmptyMessage(0);
        }

        private void b() {
            int i = this.y + 1;
            this.y = i;
            if (i == 1) {
                ((Choreographer) g.e(this.x)).postFrameCallback(this);
            }
        }

        private void c() {
            this.x = Choreographer.getInstance();
        }

        public static d d() {
            return f4072c;
        }

        private void f() {
            int i = this.y - 1;
            this.y = i;
            if (i == 0) {
                ((Choreographer) g.e(this.x)).removeFrameCallback(this);
                this.f4073d = -9223372036854775807L;
            }
        }

        public void a() {
            this.f4074f.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.f4073d = j;
            ((Choreographer) g.e(this.x)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f4074f.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c();
                return true;
            } else if (i == 1) {
                b();
                return true;
            } else if (i != 2) {
                return false;
            } else {
                f();
                return true;
            }
        }
    }

    public u(@Nullable Context context) {
        a f2 = f(context);
        this.f4066b = f2;
        this.f4067c = f2 != null ? d.d() : null;
        this.j = -9223372036854775807L;
        this.k = -9223372036854775807L;
        this.f4070f = -1.0f;
        this.i = 1.0f;
    }

    private static boolean b(long j, long j2) {
        return Math.abs(j - j2) <= 20000000;
    }

    private void c() {
        Surface surface;
        if (o0.a >= 30 && (surface = this.f4069e) != null && this.h != 0.0f) {
            this.h = 0.0f;
            q(surface, 0.0f);
        }
    }

    private static long d(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j5 = j3 + j5;
            j4 = j5;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    @Nullable
    private static a f(@Nullable Context context) {
        a aVar = null;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (o0.a >= 17) {
            aVar = c.c(applicationContext);
        }
        return aVar == null ? b.b(applicationContext) : aVar;
    }

    private void p() {
        this.l = 0L;
        this.o = -1L;
        this.m = -1L;
    }

    @RequiresApi(30)
    private static void q(Surface surface, float f2) {
        try {
            surface.setFrameRate(f2, f2 == 0.0f ? 0 : 1);
        } catch (IllegalStateException e2) {
            com.google.android.exoplayer2.util.u.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(@Nullable Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            this.j = refreshRate;
            this.k = (refreshRate * 80) / 100;
            return;
        }
        com.google.android.exoplayer2.util.u.h("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        this.j = -9223372036854775807L;
        this.k = -9223372036854775807L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
        if (java.lang.Math.abs(r0 - r8.g) >= (r8.a.e() && (r8.a.d() > 5000000000L ? 1 : (r8.a.d() == 5000000000L ? 0 : -1)) >= 0 ? 0.02f : 1.0f)) goto L_0x006c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
        if (r8.a.c() >= 30) goto L_0x006c;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void s() {
        /*
            r8 = this;
            int r0 = com.google.android.exoplayer2.util.o0.a
            r1 = 30
            if (r0 < r1) goto L_0x0073
            android.view.Surface r0 = r8.f4069e
            if (r0 != 0) goto L_0x000c
            goto L_0x0073
        L_0x000c:
            com.google.android.exoplayer2.video.o r0 = r8.a
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x001b
            com.google.android.exoplayer2.video.o r0 = r8.a
            float r0 = r0.b()
            goto L_0x001d
        L_0x001b:
            float r0 = r8.f4070f
        L_0x001d:
            float r2 = r8.g
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0024
            return
        L_0x0024:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4 = 0
            r5 = 1
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x0061
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0061
            com.google.android.exoplayer2.video.o r1 = r8.a
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0049
            com.google.android.exoplayer2.video.o r1 = r8.a
            long r1 = r1.d()
            r6 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 < 0) goto L_0x0049
            r1 = 1
            goto L_0x004a
        L_0x0049:
            r1 = 0
        L_0x004a:
            if (r1 == 0) goto L_0x0050
            r1 = 1017370378(0x3ca3d70a, float:0.02)
            goto L_0x0052
        L_0x0050:
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x0052:
            float r2 = r8.g
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x005f
            goto L_0x006c
        L_0x005f:
            r5 = 0
            goto L_0x006c
        L_0x0061:
            if (r6 == 0) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            com.google.android.exoplayer2.video.o r2 = r8.a
            int r2 = r2.c()
            if (r2 < r1) goto L_0x005f
        L_0x006c:
            if (r5 == 0) goto L_0x0073
            r8.g = r0
            r8.t(r4)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.u.s():void");
    }

    private void t(boolean z) {
        Surface surface;
        if (o0.a >= 30 && (surface = this.f4069e) != null) {
            float f2 = 0.0f;
            if (this.f4068d) {
                float f3 = this.g;
                if (f3 != -1.0f) {
                    f2 = this.i * f3;
                }
            }
            if (z || this.h != f2) {
                this.h = f2;
                q(surface, f2);
            }
        }
    }

    public long a(long j) {
        long j2;
        d dVar;
        if (this.o != -1 && this.a.e()) {
            long a2 = this.p + (((float) (this.a.a() * (this.l - this.o))) / this.i);
            if (b(j, a2)) {
                j2 = a2;
                this.m = this.l;
                this.n = j2;
                dVar = this.f4067c;
                if (dVar != null || this.j == -9223372036854775807L) {
                    return j2;
                }
                long j3 = dVar.f4073d;
                return j3 == -9223372036854775807L ? j2 : d(j2, j3, this.j) - this.k;
            }
            p();
        }
        j2 = j;
        this.m = this.l;
        this.n = j2;
        dVar = this.f4067c;
        if (dVar != null) {
        }
        return j2;
    }

    public void g() {
        a aVar = this.f4066b;
        if (aVar != null) {
            aVar.unregister();
            ((d) g.e(this.f4067c)).e();
        }
    }

    public void h() {
        if (this.f4066b != null) {
            ((d) g.e(this.f4067c)).a();
            this.f4066b.a(new a.AbstractC0090a() { // from class: com.google.android.exoplayer2.video.a
                @Override // com.google.android.exoplayer2.video.u.a.AbstractC0090a
                public final void a(Display display) {
                    u.this.r(display);
                }
            });
        }
    }

    public void i(float f2) {
        this.f4070f = f2;
        this.a.g();
        s();
    }

    public void j(long j) {
        long j2 = this.m;
        if (j2 != -1) {
            this.o = j2;
            this.p = this.n;
        }
        this.l++;
        this.a.f(j * 1000);
        s();
    }

    public void k(float f2) {
        this.i = f2;
        p();
        t(false);
    }

    public void l() {
        p();
    }

    public void m() {
        this.f4068d = true;
        p();
        t(false);
    }

    public void n() {
        this.f4068d = false;
        c();
    }

    public void o(@Nullable Surface surface) {
        if (surface instanceof DummySurface) {
            surface = null;
        }
        if (this.f4069e != surface) {
            c();
            this.f4069e = surface;
            t(true);
        }
    }
}
