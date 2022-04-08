package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.t;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.q;
import com.google.android.exoplayer2.mediacodec.r;
import com.google.android.exoplayer2.mediacodec.s;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.w;
import com.google.android.exoplayer2.util.x;
import com.google.android.exoplayer2.util.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: MediaCodecAudioRenderer.java */
/* loaded from: classes.dex */
public class d0 extends MediaCodecRenderer implements w {
    private final Context e5;
    private final t.a f5;
    private final AudioSink g5;
    private int h5;
    private boolean i5;
    @Nullable
    private Format j5;
    private long k5;
    private boolean l5;
    private boolean m5;
    private boolean n5;
    private boolean o5;
    @Nullable
    private b2.a p5;

    /* compiled from: MediaCodecAudioRenderer.java */
    /* loaded from: classes.dex */
    private final class b implements AudioSink.a {
        private b() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void a(boolean z) {
            d0.this.f5.C(z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void b(Exception exc) {
            u.d("MediaCodecAudioRenderer", "Audio sink error", exc);
            d0.this.f5.b(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void c(long j) {
            d0.this.f5.B(j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void d(long j) {
            if (d0.this.p5 != null) {
                d0.this.p5.b(j);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void e(int i, long j, long j2) {
            d0.this.f5.D(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void f() {
            d0.this.v1();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void g() {
            if (d0.this.p5 != null) {
                d0.this.p5.a();
            }
        }
    }

    public d0(Context context, s sVar, boolean z, @Nullable Handler handler, @Nullable t tVar, AudioSink audioSink) {
        this(context, q.b.a, sVar, z, handler, tVar, audioSink);
    }

    private static boolean q1(String str) {
        if (o0.a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(o0.f3934c)) {
            String str2 = o0.f3933b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean r1() {
        if (o0.a == 23) {
            String str = o0.f3935d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int s1(r rVar, Format format) {
        int i;
        if (!"OMX.google.raw.decoder".equals(rVar.a) || (i = o0.a) >= 24 || (i == 23 && o0.n0(this.e5))) {
            return format.I3;
        }
        return -1;
    }

    private void w1() {
        long o = this.g5.o(d());
        if (o != Long.MIN_VALUE) {
            if (!this.m5) {
                o = Math.max(this.k5, o);
            }
            this.k5 = o;
            this.m5 = false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    protected void E() {
        this.n5 = true;
        try {
            this.g5.flush();
            try {
                super.E();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.E();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    protected void F(boolean z, boolean z2) throws ExoPlaybackException {
        super.F(z, z2);
        this.f5.f(this.a5);
        if (z().f2248b) {
            this.g5.r();
        } else {
            this.g5.g();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    protected void G(long j, boolean z) throws ExoPlaybackException {
        super.G(j, z);
        if (this.o5) {
            this.g5.l();
        } else {
            this.g5.flush();
        }
        this.k5 = j;
        this.l5 = true;
        this.m5 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    protected void H() {
        try {
            super.H();
        } finally {
            if (this.n5) {
                this.n5 = false;
                this.g5.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    protected void I() {
        super.I();
        this.g5.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.u0
    protected void J() {
        w1();
        this.g5.pause();
        super.J();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void J0(Exception exc) {
        u.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.f5.a(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void K0(String str, long j, long j2) {
        this.f5.c(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void L0(String str) {
        this.f5.d(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    protected e M0(i1 i1Var) throws ExoPlaybackException {
        e M0 = super.M0(i1Var);
        this.f5.g(i1Var.f2321b, M0);
        return M0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void N0(Format format, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int i;
        int i2;
        Format format2 = this.j5;
        int[] iArr = null;
        if (format2 != null) {
            format = format2;
        } else if (o0() != null) {
            if ("audio/raw".equals(format.H3)) {
                i = format.W3;
            } else if (o0.a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i = o0.U(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i = "audio/raw".equals(format.H3) ? format.W3 : 2;
            }
            Format E = new Format.b().e0("audio/raw").Y(i).M(format.X3).N(format.Y3).H(mediaFormat.getInteger("channel-count")).f0(mediaFormat.getInteger("sample-rate")).E();
            if (this.i5 && E.U3 == 6 && (i2 = format.U3) < 6) {
                iArr = new int[i2];
                for (int i3 = 0; i3 < format.U3; i3++) {
                    iArr[i3] = i3;
                }
            }
            format = E;
        }
        try {
            this.g5.s(format, 0, iArr);
        } catch (AudioSink.ConfigurationException e2) {
            throw x(e2, e2.format, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected e P(r rVar, Format format, Format format2) {
        e e2 = rVar.e(format, format2);
        int i = e2.f2169e;
        if (s1(rVar, format2) > this.h5) {
            i |= 64;
        }
        return new e(rVar.a, format, format2, i != 0 ? 0 : e2.f2168d, i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void P0() {
        super.P0();
        this.g5.p();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void Q0(DecoderInputBuffer decoderInputBuffer) {
        if (this.l5 && !decoderInputBuffer.j()) {
            if (Math.abs(decoderInputBuffer.x - this.k5) > 500000) {
                this.k5 = decoderInputBuffer.x;
            }
            this.l5 = false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean S0(long j, long j2, @Nullable q qVar, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        g.e(byteBuffer);
        if (this.j5 != null && (i2 & 2) != 0) {
            ((q) g.e(qVar)).m(i, false);
            return true;
        } else if (z) {
            if (qVar != null) {
                qVar.m(i, false);
            }
            this.a5.f2165f += i3;
            this.g5.p();
            return true;
        } else {
            try {
                if (!this.g5.i(byteBuffer, j3, i3)) {
                    return false;
                }
                if (qVar != null) {
                    qVar.m(i, false);
                }
                this.a5.f2164e += i3;
                return true;
            } catch (AudioSink.InitializationException e2) {
                throw y(e2, e2.format, e2.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
            } catch (AudioSink.WriteException e3) {
                throw y(e3, format, e3.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void X0() throws ExoPlaybackException {
        try {
            this.g5.n();
        } catch (AudioSink.WriteException e2) {
            throw y(e2, e2.format, e2.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
        }
    }

    @Override // com.google.android.exoplayer2.util.w
    public t1 c() {
        return this.g5.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.b2
    public boolean d() {
        return super.d() && this.g5.d();
    }

    @Override // com.google.android.exoplayer2.util.w
    public void e(t1 t1Var) {
        this.g5.e(t1Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.b2
    public boolean g() {
        return this.g5.b() || super.g();
    }

    @Override // com.google.android.exoplayer2.b2, com.google.android.exoplayer2.d2
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean i1(Format format) {
        return this.g5.a(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int j1(s sVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        if (!y.o(format.H3)) {
            return c2.a(0);
        }
        int i = o0.a >= 21 ? 32 : 0;
        boolean z = format.a4 != null;
        boolean k1 = MediaCodecRenderer.k1(format);
        int i2 = 8;
        int i3 = 4;
        if (k1 && this.g5.a(format) && (!z || MediaCodecUtil.q() != null)) {
            return c2.b(4, 8, i);
        }
        if ("audio/raw".equals(format.H3) && !this.g5.a(format)) {
            return c2.a(1);
        }
        if (!this.g5.a(o0.V(2, format.U3, format.V3))) {
            return c2.a(1);
        }
        List<r> t0 = t0(sVar, format, false);
        if (t0.isEmpty()) {
            return c2.a(1);
        }
        if (!k1) {
            return c2.a(2);
        }
        r rVar = t0.get(0);
        boolean m = rVar.m(format);
        if (m && rVar.o(format)) {
            i2 = 16;
        }
        if (!m) {
            i3 = 3;
        }
        return c2.b(i3, i2, i);
    }

    @Override // com.google.android.exoplayer2.u0, com.google.android.exoplayer2.x1.b
    public void k(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.g5.q(((Float) obj).floatValue());
        } else if (i == 3) {
            this.g5.h((p) obj);
        } else if (i != 5) {
            switch (i) {
                case 101:
                    this.g5.t(((Boolean) obj).booleanValue());
                    return;
                case 102:
                    this.g5.f(((Integer) obj).intValue());
                    return;
                case 103:
                    this.p5 = (b2.a) obj;
                    return;
                default:
                    super.k(i, obj);
                    return;
            }
        } else {
            this.g5.m((x) obj);
        }
    }

    @Override // com.google.android.exoplayer2.util.w
    public long p() {
        if (getState() == 2) {
            w1();
        }
        return this.k5;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float r0(float f2, Format format, Format[] formatArr) {
        int i = -1;
        for (Format format2 : formatArr) {
            int i2 = format2.V3;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return f2 * i;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected List<r> t0(s sVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        r q;
        String str = format.H3;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.g5.a(format) && (q = MediaCodecUtil.q()) != null) {
            return Collections.singletonList(q);
        }
        List<r> p = MediaCodecUtil.p(sVar.a(str, z, false), format);
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList = new ArrayList(p);
            arrayList.addAll(sVar.a("audio/eac3", z, false));
            p = arrayList;
        }
        return Collections.unmodifiableList(p);
    }

    protected int t1(r rVar, Format format, Format[] formatArr) {
        int s1 = s1(rVar, format);
        if (formatArr.length == 1) {
            return s1;
        }
        for (Format format2 : formatArr) {
            if (rVar.e(format, format2).f2168d != 0) {
                s1 = Math.max(s1, s1(rVar, format2));
            }
        }
        return s1;
    }

    @SuppressLint({"InlinedApi"})
    protected MediaFormat u1(Format format, String str, int i, float f2) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.U3);
        mediaFormat.setInteger("sample-rate", format.V3);
        x.e(mediaFormat, format.J3);
        x.d(mediaFormat, "max-input-size", i);
        int i2 = o0.a;
        if (i2 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f && !r1()) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        if (i2 <= 28 && "audio/ac4".equals(format.H3)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i2 >= 24 && this.g5.k(o0.V(4, format.U3, format.V3)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected q.a v0(r rVar, Format format, @Nullable MediaCrypto mediaCrypto, float f2) {
        this.h5 = t1(rVar, format, C());
        this.i5 = q1(rVar.a);
        MediaFormat u1 = u1(format, rVar.f2531c, this.h5, f2);
        this.j5 = "audio/raw".equals(rVar.f2530b) && !"audio/raw".equals(format.H3) ? format : null;
        return new q.a(rVar, u1, format, null, mediaCrypto, 0);
    }

    @CallSuper
    protected void v1() {
        this.m5 = true;
    }

    @Override // com.google.android.exoplayer2.u0, com.google.android.exoplayer2.b2
    @Nullable
    public w w() {
        return this;
    }

    public d0(Context context, q.b bVar, s sVar, boolean z, @Nullable Handler handler, @Nullable t tVar, AudioSink audioSink) {
        super(1, bVar, sVar, z, 44100.0f);
        this.e5 = context.getApplicationContext();
        this.g5 = audioSink;
        this.f5 = new t.a(handler, tVar);
        audioSink.j(new b());
    }
}
