package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.q;
import com.google.android.exoplayer2.mediacodec.r;
import com.google.android.exoplayer2.mediacodec.s;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.x;
import com.google.android.exoplayer2.video.y;
import com.google.android.gms.common.Scopes;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* compiled from: MediaCodecVideoRenderer.java */
/* loaded from: classes.dex */
public class q extends MediaCodecRenderer {
    private static final int[] e5 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean f5;
    private static boolean g5;
    private int A5;
    private int B5;
    private int C5;
    private long D5;
    private long E5;
    private long F5;
    private int G5;
    private int H5;
    private int I5;
    private int J5;
    private float K5;
    @Nullable
    private z L5;
    private boolean M5;
    private int N5;
    @Nullable
    b O5;
    @Nullable
    private t P5;
    private final Context h5;
    private final u i5;
    private final y.a j5;
    private final long k5;
    private final int l5;
    private final boolean m5;
    private a n5;
    private boolean o5;
    private boolean p5;
    @Nullable
    private Surface q5;
    @Nullable
    private DummySurface r5;
    private boolean s5;
    private int t5;
    private boolean u5;
    private boolean v5;
    private boolean w5;
    private long x5;
    private long y5;
    private long z5;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: MediaCodecVideoRenderer.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4024b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4025c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.f4024b = i2;
            this.f4025c = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaCodecVideoRenderer.java */
    @RequiresApi(23)
    /* loaded from: classes.dex */
    public final class b implements q.c, Handler.Callback {

        /* renamed from: c  reason: collision with root package name */
        private final Handler f4026c;

        public b(com.google.android.exoplayer2.mediacodec.q qVar) {
            Handler w = o0.w(this);
            this.f4026c = w;
            qVar.c(this, w);
        }

        private void b(long j) {
            q qVar = q.this;
            if (this == qVar.O5) {
                if (j == Long.MAX_VALUE) {
                    qVar.O1();
                    return;
                }
                try {
                    qVar.N1(j);
                } catch (ExoPlaybackException e2) {
                    q.this.e1(e2);
                }
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.q.c
        public void a(com.google.android.exoplayer2.mediacodec.q qVar, long j, long j2) {
            if (o0.a < 30) {
                this.f4026c.sendMessageAtFrontOfQueue(Message.obtain(this.f4026c, 0, (int) (j >> 32), (int) j));
                return;
            }
            b(j);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(o0.K0(message.arg1, message.arg2));
            return true;
        }
    }

    public q(Context context, s sVar, long j, boolean z, @Nullable Handler handler, @Nullable y yVar, int i) {
        this(context, q.b.a, sVar, j, z, handler, yVar, i);
    }

    private static List<r> A1(s sVar, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> l;
        String str = format.H3;
        if (str == null) {
            return Collections.emptyList();
        }
        List<r> p = MediaCodecUtil.p(sVar.a(str, z, z2), format);
        if ("video/dolby-vision".equals(str) && (l = MediaCodecUtil.l(format)) != null) {
            int intValue = ((Integer) l.first).intValue();
            if (intValue == 16 || intValue == 256) {
                p.addAll(sVar.a("video/hevc", z, z2));
            } else if (intValue == 512) {
                p.addAll(sVar.a("video/avc", z, z2));
            }
        }
        return Collections.unmodifiableList(p);
    }

    protected static int B1(r rVar, Format format) {
        if (format.I3 == -1) {
            return x1(rVar, format.H3, format.M3, format.N3);
        }
        int size = format.J3.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += format.J3.get(i2).length;
        }
        return format.I3 + i;
    }

    private static boolean D1(long j) {
        return j < -30000;
    }

    private static boolean E1(long j) {
        return j < -500000;
    }

    private void G1() {
        if (this.A5 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.j5.d(this.A5, elapsedRealtime - this.z5);
            this.A5 = 0;
            this.z5 = elapsedRealtime;
        }
    }

    private void I1() {
        int i = this.G5;
        if (i != 0) {
            this.j5.B(this.F5, i);
            this.F5 = 0L;
            this.G5 = 0;
        }
    }

    private void J1() {
        int i = this.H5;
        if (i != -1 || this.I5 != -1) {
            z zVar = this.L5;
            if (zVar == null || zVar.f4077c != i || zVar.f4078d != this.I5 || zVar.f4079e != this.J5 || zVar.f4080f != this.K5) {
                z zVar2 = new z(this.H5, this.I5, this.J5, this.K5);
                this.L5 = zVar2;
                this.j5.D(zVar2);
            }
        }
    }

    private void K1() {
        if (this.s5) {
            this.j5.A(this.q5);
        }
    }

    private void L1() {
        z zVar = this.L5;
        if (zVar != null) {
            this.j5.D(zVar);
        }
    }

    private void M1(long j, long j2, Format format) {
        t tVar = this.P5;
        if (tVar != null) {
            tVar.a(j, j2, format, s0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        d1();
    }

    @RequiresApi(29)
    private static void R1(com.google.android.exoplayer2.mediacodec.q qVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        qVar.i(bundle);
    }

    private void S1() {
        this.y5 = this.k5 > 0 ? SystemClock.elapsedRealtime() + this.k5 : -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.exoplayer2.video.q, com.google.android.exoplayer2.u0, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.Surface] */
    private void T1(@Nullable Object obj) throws ExoPlaybackException {
        DummySurface dummySurface = obj instanceof Surface ? (Surface) obj : null;
        if (dummySurface == null) {
            DummySurface dummySurface2 = this.r5;
            if (dummySurface2 != null) {
                dummySurface = dummySurface2;
            } else {
                r p0 = p0();
                if (p0 != null && Y1(p0)) {
                    dummySurface = DummySurface.c(this.h5, p0.g);
                    this.r5 = dummySurface;
                }
            }
        }
        if (this.q5 != dummySurface) {
            this.q5 = dummySurface;
            this.i5.o(dummySurface);
            this.s5 = false;
            int state = getState();
            com.google.android.exoplayer2.mediacodec.q o0 = o0();
            if (o0 != null) {
                if (o0.a < 23 || dummySurface == null || this.o5) {
                    W0();
                    G0();
                } else {
                    U1(o0, dummySurface);
                }
            }
            if (dummySurface == null || dummySurface == this.r5) {
                r1();
                q1();
                return;
            }
            L1();
            q1();
            if (state == 2) {
                S1();
            }
        } else if (dummySurface != null && dummySurface != this.r5) {
            L1();
            K1();
        }
    }

    private boolean Y1(r rVar) {
        return o0.a >= 23 && !this.M5 && !s1(rVar.a) && (!rVar.g || DummySurface.b(this.h5));
    }

    private void q1() {
        com.google.android.exoplayer2.mediacodec.q o0;
        this.u5 = false;
        if (o0.a >= 23 && this.M5 && (o0 = o0()) != null) {
            this.O5 = new b(o0);
        }
    }

    private void r1() {
        this.L5 = null;
    }

    @RequiresApi(21)
    private static void t1(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    private static boolean u1() {
        return "NVIDIA".equals(o0.f3934c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x07cf, code lost:
        if (r0.equals("NX573J") == false) goto L_0x008c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x0831, code lost:
        if (r0.equals("AFTN") == false) goto L_0x0829;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean w1() {
        /*
            Method dump skipped, instructions count: 3046
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.q.w1():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int x1(r rVar, String str, int i, int i2) {
        char c2;
        int i3;
        if (!(i == -1 || i2 == -1)) {
            str.hashCode();
            int i4 = 4;
            switch (str.hashCode()) {
                case -1851077871:
                    if (str.equals("video/dolby-vision")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1664118616:
                    if (str.equals("video/3gpp")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1662541442:
                    if (str.equals("video/hevc")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1187890754:
                    if (str.equals("video/mp4v-es")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1331836730:
                    if (str.equals("video/avc")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1599127256:
                    if (str.equals("video/x-vnd.on2.vp8")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1599127257:
                    if (str.equals("video/x-vnd.on2.vp9")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                case 4:
                    String str2 = o0.f3935d;
                    if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(o0.f3934c) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !rVar.g)))) {
                        i3 = o0.k(i, 16) * o0.k(i2, 16) * 16 * 16;
                        i4 = 2;
                        break;
                    }
                    break;
                case 1:
                case 3:
                case 5:
                    i3 = i * i2;
                    i4 = 2;
                    break;
                case 2:
                case 6:
                    i3 = i * i2;
                    break;
                default:
                    return -1;
            }
            return (i3 * 3) / (i4 * 2);
        }
        return -1;
    }

    private static Point y1(r rVar, Format format) {
        int[] iArr;
        int i = format.N3;
        int i2 = format.M3;
        boolean z = i > i2;
        int i3 = z ? i : i2;
        if (z) {
            i = i2;
        }
        float f2 = i / i3;
        for (int i4 : e5) {
            int i5 = (int) (i4 * f2);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            if (o0.a >= 21) {
                int i6 = z ? i5 : i4;
                if (!z) {
                    i4 = i5;
                }
                Point b2 = rVar.b(i6, i4);
                if (rVar.t(b2.x, b2.y, format.O3)) {
                    return b2;
                }
            } else {
                try {
                    int k = o0.k(i4, 16) * 16;
                    int k2 = o0.k(i5, 16) * 16;
                    if (k * k2 <= MediaCodecUtil.I()) {
                        int i7 = z ? k2 : k;
                        if (!z) {
                            k = k2;
                        }
                        return new Point(i7, k);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    protected MediaFormat C1(Format format, String str, a aVar, float f2, boolean z, int i) {
        Pair<Integer, Integer> l;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.M3);
        mediaFormat.setInteger("height", format.N3);
        x.e(mediaFormat, format.J3);
        x.c(mediaFormat, "frame-rate", format.O3);
        x.d(mediaFormat, "rotation-degrees", format.P3);
        x.b(mediaFormat, format.T3);
        if ("video/dolby-vision".equals(format.H3) && (l = MediaCodecUtil.l(format)) != null) {
            x.d(mediaFormat, Scopes.PROFILE, ((Integer) l.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.a);
        mediaFormat.setInteger("max-height", aVar.f4024b);
        x.d(mediaFormat, "max-input-size", aVar.f4025c);
        if (o0.a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            t1(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    public void E() {
        r1();
        q1();
        this.s5 = false;
        this.i5.g();
        this.O5 = null;
        try {
            super.E();
        } finally {
            this.j5.c(this.a5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    public void F(boolean z, boolean z2) throws ExoPlaybackException {
        super.F(z, z2);
        boolean z3 = z().f2248b;
        g.g(!z3 || this.N5 != 0);
        if (this.M5 != z3) {
            this.M5 = z3;
            W0();
        }
        this.j5.e(this.a5);
        this.i5.h();
        this.v5 = z2;
        this.w5 = false;
    }

    protected boolean F1(long j, boolean z) throws ExoPlaybackException {
        int M = M(j);
        if (M == 0) {
            return false;
        }
        d dVar = this.a5;
        dVar.i++;
        int i = this.C5 + M;
        if (z) {
            dVar.f2165f += i;
        } else {
            a2(i);
        }
        l0();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    public void G(long j, boolean z) throws ExoPlaybackException {
        super.G(j, z);
        q1();
        this.i5.l();
        this.D5 = -9223372036854775807L;
        this.x5 = -9223372036854775807L;
        this.B5 = 0;
        if (z) {
            S1();
        } else {
            this.y5 = -9223372036854775807L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    @TargetApi(17)
    public void H() {
        try {
            super.H();
            DummySurface dummySurface = this.r5;
            if (dummySurface != null) {
                if (this.q5 == dummySurface) {
                    this.q5 = null;
                }
                dummySurface.release();
                this.r5 = null;
            }
        } catch (Throwable th) {
            if (this.r5 != null) {
                Surface surface = this.q5;
                DummySurface dummySurface2 = this.r5;
                if (surface == dummySurface2) {
                    this.q5 = null;
                }
                dummySurface2.release();
                this.r5 = null;
            }
            throw th;
        }
    }

    void H1() {
        this.w5 = true;
        if (!this.u5) {
            this.u5 = true;
            this.j5.A(this.q5);
            this.s5 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    public void I() {
        super.I();
        this.A5 = 0;
        this.z5 = SystemClock.elapsedRealtime();
        this.E5 = SystemClock.elapsedRealtime() * 1000;
        this.F5 = 0L;
        this.G5 = 0;
        this.i5.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    public void J() {
        this.y5 = -9223372036854775807L;
        G1();
        I1();
        this.i5.n();
        super.J();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void J0(Exception exc) {
        u.d("MediaCodecVideoRenderer", "Video codec error", exc);
        this.j5.C(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void K0(String str, long j, long j2) {
        this.j5.a(str, j, j2);
        this.o5 = s1(str);
        this.p5 = ((r) g.e(p0())).n();
        if (o0.a >= 23 && this.M5) {
            this.O5 = new b((com.google.android.exoplayer2.mediacodec.q) g.e(o0()));
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void L0(String str) {
        this.j5.b(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public e M0(i1 i1Var) throws ExoPlaybackException {
        e M0 = super.M0(i1Var);
        this.j5.f(i1Var.f2321b, M0);
        return M0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void N0(Format format, @Nullable MediaFormat mediaFormat) {
        int i;
        int i2;
        com.google.android.exoplayer2.mediacodec.q o0 = o0();
        if (o0 != null) {
            o0.d(this.t5);
        }
        if (this.M5) {
            this.H5 = format.M3;
            this.I5 = format.N3;
        } else {
            g.e(mediaFormat);
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            if (z) {
                i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                i = mediaFormat.getInteger("width");
            }
            this.H5 = i;
            if (z) {
                i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                i2 = mediaFormat.getInteger("height");
            }
            this.I5 = i2;
        }
        float f2 = format.Q3;
        this.K5 = f2;
        if (o0.a >= 21) {
            int i3 = format.P3;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.H5;
                this.H5 = this.I5;
                this.I5 = i4;
                this.K5 = 1.0f / f2;
            }
        } else {
            this.J5 = format.P3;
        }
        this.i5.i(format.O3);
    }

    protected void N1(long j) throws ExoPlaybackException {
        n1(j);
        J1();
        this.a5.f2164e++;
        H1();
        O0(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void O0(long j) {
        super.O0(j);
        if (!this.M5) {
            this.C5--;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected e P(r rVar, Format format, Format format2) {
        e e2 = rVar.e(format, format2);
        int i = e2.f2169e;
        int i2 = format2.M3;
        a aVar = this.n5;
        if (i2 > aVar.a || format2.N3 > aVar.f4024b) {
            i |= 256;
        }
        if (B1(rVar, format2) > this.n5.f4025c) {
            i |= 64;
        }
        return new e(rVar.a, format, format2, i != 0 ? 0 : e2.f2168d, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void P0() {
        super.P0();
        q1();
    }

    protected void P1(com.google.android.exoplayer2.mediacodec.q qVar, int i, long j) {
        J1();
        m0.a("releaseOutputBuffer");
        qVar.m(i, true);
        m0.c();
        this.E5 = SystemClock.elapsedRealtime() * 1000;
        this.a5.f2164e++;
        this.B5 = 0;
        H1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void Q0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z = this.M5;
        if (!z) {
            this.C5++;
        }
        if (o0.a < 23 && z) {
            N1(decoderInputBuffer.x);
        }
    }

    @RequiresApi(21)
    protected void Q1(com.google.android.exoplayer2.mediacodec.q qVar, int i, long j, long j2) {
        J1();
        m0.a("releaseOutputBuffer");
        qVar.j(i, j2);
        m0.c();
        this.E5 = SystemClock.elapsedRealtime() * 1000;
        this.a5.f2164e++;
        this.B5 = 0;
        H1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean S0(long j, long j2, @Nullable com.google.android.exoplayer2.mediacodec.q qVar, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        long j4;
        boolean z3;
        g.e(qVar);
        if (this.x5 == -9223372036854775807L) {
            this.x5 = j;
        }
        if (j3 != this.D5) {
            this.i5.j(j3);
            this.D5 = j3;
        }
        long w0 = w0();
        long j5 = j3 - w0;
        if (!z || z2) {
            double x0 = x0();
            boolean z4 = getState() == 2;
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            long j6 = (long) ((j3 - j) / x0);
            if (z4) {
                j6 -= elapsedRealtime - j2;
            }
            if (this.q5 != this.r5) {
                long j7 = elapsedRealtime - this.E5;
                if (this.w5 ? this.u5 : !z4 && !this.v5) {
                    j4 = j7;
                    z3 = false;
                } else {
                    j4 = j7;
                    z3 = true;
                }
                if (this.y5 == -9223372036854775807L && j >= w0 && (z3 || (z4 && X1(j6, j4)))) {
                    long nanoTime = System.nanoTime();
                    M1(j5, nanoTime, format);
                    if (o0.a >= 21) {
                        Q1(qVar, i, j5, nanoTime);
                    } else {
                        P1(qVar, i, j5);
                    }
                    b2(j6);
                    return true;
                }
                if (z4 && j != this.x5) {
                    long nanoTime2 = System.nanoTime();
                    long a2 = this.i5.a((j6 * 1000) + nanoTime2);
                    long j8 = (a2 - nanoTime2) / 1000;
                    boolean z5 = this.y5 != -9223372036854775807L;
                    if (V1(j8, j2, z2) && F1(j, z5)) {
                        return false;
                    }
                    if (W1(j8, j2, z2)) {
                        if (z5) {
                            Z1(qVar, i, j5);
                        } else {
                            v1(qVar, i, j5);
                        }
                        b2(j8);
                        return true;
                    } else if (o0.a >= 21) {
                        if (j8 < 50000) {
                            M1(j5, a2, format);
                            Q1(qVar, i, j5, a2);
                            b2(j8);
                            return true;
                        }
                    } else if (j8 < 30000) {
                        if (j8 > 11000) {
                            try {
                                Thread.sleep((j8 - 10000) / 1000);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        M1(j5, a2, format);
                        P1(qVar, i, j5);
                        b2(j8);
                        return true;
                    }
                }
                return false;
            } else if (!D1(j6)) {
                return false;
            } else {
                Z1(qVar, i, j5);
                b2(j6);
                return true;
            }
        } else {
            Z1(qVar, i, j5);
            return true;
        }
    }

    @RequiresApi(23)
    protected void U1(com.google.android.exoplayer2.mediacodec.q qVar, Surface surface) {
        qVar.f(surface);
    }

    protected boolean V1(long j, long j2, boolean z) {
        return E1(j) && !z;
    }

    protected boolean W1(long j, long j2, boolean z) {
        return D1(j) && !z;
    }

    protected boolean X1(long j, long j2) {
        return D1(j) && j2 > 100000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void Y0() {
        super.Y0();
        this.C5 = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MediaCodecDecoderException Z(Throwable th, @Nullable r rVar) {
        return new MediaCodecVideoDecoderException(th, rVar, this.q5);
    }

    protected void Z1(com.google.android.exoplayer2.mediacodec.q qVar, int i, long j) {
        m0.a("skipVideoBuffer");
        qVar.m(i, false);
        m0.c();
        this.a5.f2165f++;
    }

    protected void a2(int i) {
        d dVar = this.a5;
        dVar.g += i;
        this.A5 += i;
        int i2 = this.B5 + i;
        this.B5 = i2;
        dVar.h = Math.max(i2, dVar.h);
        int i3 = this.l5;
        if (i3 > 0 && this.A5 >= i3) {
            G1();
        }
    }

    protected void b2(long j) {
        this.a5.a(j);
        this.F5 += j;
        this.G5++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.b2
    public boolean g() {
        DummySurface dummySurface;
        if (super.g() && (this.u5 || (((dummySurface = this.r5) != null && this.q5 == dummySurface) || o0() == null || this.M5))) {
            this.y5 = -9223372036854775807L;
            return true;
        } else if (this.y5 == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.y5) {
                return true;
            }
            this.y5 = -9223372036854775807L;
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.b2, com.google.android.exoplayer2.d2
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean h1(r rVar) {
        return this.q5 != null || Y1(rVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int j1(s sVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i = 0;
        if (!com.google.android.exoplayer2.util.y.q(format.H3)) {
            return c2.a(0);
        }
        boolean z = format.K3 != null;
        List<r> A1 = A1(sVar, format, z, false);
        if (z && A1.isEmpty()) {
            A1 = A1(sVar, format, false, false);
        }
        if (A1.isEmpty()) {
            return c2.a(1);
        }
        if (!MediaCodecRenderer.k1(format)) {
            return c2.a(2);
        }
        r rVar = A1.get(0);
        boolean m = rVar.m(format);
        int i2 = rVar.o(format) ? 16 : 8;
        if (m) {
            List<r> A12 = A1(sVar, format, z, true);
            if (!A12.isEmpty()) {
                r rVar2 = A12.get(0);
                if (rVar2.m(format) && rVar2.o(format)) {
                    i = 32;
                }
            }
        }
        return c2.b(m ? 4 : 3, i2, i);
    }

    @Override // com.google.android.exoplayer2.u0, com.google.android.exoplayer2.x1.b
    public void k(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 1) {
            T1(obj);
        } else if (i == 4) {
            this.t5 = ((Integer) obj).intValue();
            com.google.android.exoplayer2.mediacodec.q o0 = o0();
            if (o0 != null) {
                o0.d(this.t5);
            }
        } else if (i == 6) {
            this.P5 = (t) obj;
        } else if (i != 102) {
            super.k(i, obj);
        } else {
            int intValue = ((Integer) obj).intValue();
            if (this.N5 != intValue) {
                this.N5 = intValue;
                if (this.M5) {
                    W0();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0, com.google.android.exoplayer2.b2
    public void q(float f2, float f3) throws ExoPlaybackException {
        super.q(f2, f3);
        this.i5.k(f2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean q0() {
        return this.M5 && o0.a < 23;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float r0(float f2, Format format, Format[] formatArr) {
        float f3 = -1.0f;
        for (Format format2 : formatArr) {
            float f4 = format2.O3;
            if (f4 != -1.0f) {
                f3 = Math.max(f3, f4);
            }
        }
        if (f3 == -1.0f) {
            return -1.0f;
        }
        return f3 * f2;
    }

    protected boolean s1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (q.class) {
            if (!f5) {
                g5 = w1();
                f5 = true;
            }
        }
        return g5;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected List<r> t0(s sVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return A1(sVar, format, z, this.M5);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(17)
    protected q.a v0(r rVar, Format format, @Nullable MediaCrypto mediaCrypto, float f2) {
        DummySurface dummySurface = this.r5;
        if (!(dummySurface == null || dummySurface.f3972f == rVar.g)) {
            dummySurface.release();
            this.r5 = null;
        }
        String str = rVar.f2531c;
        a z1 = z1(rVar, format, C());
        this.n5 = z1;
        MediaFormat C1 = C1(format, str, z1, f2, this.m5, this.M5 ? this.N5 : 0);
        if (this.q5 == null) {
            if (Y1(rVar)) {
                if (this.r5 == null) {
                    this.r5 = DummySurface.c(this.h5, rVar.g);
                }
                this.q5 = this.r5;
            } else {
                throw new IllegalStateException();
            }
        }
        return new q.a(rVar, C1, format, this.q5, mediaCrypto, 0);
    }

    protected void v1(com.google.android.exoplayer2.mediacodec.q qVar, int i, long j) {
        m0.a("dropVideoBuffer");
        qVar.m(i, false);
        m0.c();
        a2(1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    protected void y0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.p5) {
            ByteBuffer byteBuffer = (ByteBuffer) g.e(decoderInputBuffer.y);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4 && b4 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    R1(o0(), bArr);
                }
            }
        }
    }

    protected a z1(r rVar, Format format, Format[] formatArr) {
        int x1;
        int i = format.M3;
        int i2 = format.N3;
        int B1 = B1(rVar, format);
        if (formatArr.length == 1) {
            if (!(B1 == -1 || (x1 = x1(rVar, format.H3, format.M3, format.N3)) == -1)) {
                B1 = Math.min((int) (B1 * 1.5f), x1);
            }
            return new a(i, i2, B1);
        }
        int length = formatArr.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            Format format2 = formatArr[i3];
            if (format.T3 != null && format2.T3 == null) {
                format2 = format2.a().J(format.T3).E();
            }
            if (rVar.e(format, format2).f2168d != 0) {
                int i4 = format2.M3;
                z |= i4 == -1 || format2.N3 == -1;
                i = Math.max(i, i4);
                i2 = Math.max(i2, format2.N3);
                B1 = Math.max(B1, B1(rVar, format2));
            }
        }
        if (z) {
            StringBuilder sb = new StringBuilder(66);
            sb.append("Resolutions unknown. Codec max resolution: ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            u.h("MediaCodecVideoRenderer", sb.toString());
            Point y1 = y1(rVar, format);
            if (y1 != null) {
                i = Math.max(i, y1.x);
                i2 = Math.max(i2, y1.y);
                B1 = Math.max(B1, x1(rVar, format.H3, i, i2));
                StringBuilder sb2 = new StringBuilder(57);
                sb2.append("Codec max resolution adjusted to: ");
                sb2.append(i);
                sb2.append("x");
                sb2.append(i2);
                u.h("MediaCodecVideoRenderer", sb2.toString());
            }
        }
        return new a(i, i2, B1);
    }

    public q(Context context, q.b bVar, s sVar, long j, boolean z, @Nullable Handler handler, @Nullable y yVar, int i) {
        super(2, bVar, sVar, z, 30.0f);
        this.k5 = j;
        this.l5 = i;
        Context applicationContext = context.getApplicationContext();
        this.h5 = applicationContext;
        this.i5 = new u(applicationContext);
        this.j5 = new y.a(handler, yVar);
        this.m5 = u1();
        this.y5 = -9223372036854775807L;
        this.H5 = -1;
        this.I5 = -1;
        this.K5 = -1.0f;
        this.t5 = 1;
        this.N5 = 0;
        r1();
    }
}
