package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.w;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class DefaultAudioSink implements AudioSink {
    public static boolean a = false;
    private long A;
    private long B;
    private long C;
    private long D;
    private int E;
    private boolean F;
    private boolean G;
    private long H;
    private float I;
    private AudioProcessor[] J;
    private ByteBuffer[] K;
    @Nullable
    private ByteBuffer L;
    private int M;
    @Nullable
    private ByteBuffer N;
    private byte[] O;
    private int P;
    private int Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private x W;
    private boolean X;
    private long Y;
    private boolean Z;
    private boolean a0;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final q f2022b;

    /* renamed from: c  reason: collision with root package name */
    private final b f2023c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2024d;

    /* renamed from: e  reason: collision with root package name */
    private final z f2025e;

    /* renamed from: f  reason: collision with root package name */
    private final k0 f2026f;
    private final AudioProcessor[] g;
    private final AudioProcessor[] h;
    private final ConditionVariable i;
    private final w j;
    private final ArrayDeque<e> k;
    private final boolean l;
    private final int m;
    private h n;
    private final f<AudioSink.InitializationException> o;
    private final f<AudioSink.WriteException> p;
    @Nullable
    private AudioSink.a q;
    @Nullable
    private c r;
    private c s;
    @Nullable
    private AudioTrack t;
    private p u;
    @Nullable
    private e v;
    private e w;
    private t1 x;
    @Nullable
    private ByteBuffer y;
    private int z;

    /* loaded from: classes.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        /* synthetic */ InvalidAudioTrackTimestampException(String str, a aVar) {
            this(str);
        }

        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AudioTrack f2027c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, AudioTrack audioTrack) {
            super(str);
            this.f2027c = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f2027c.flush();
                this.f2027c.release();
            } finally {
                DefaultAudioSink.this.i.open();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        long a(long j);

        AudioProcessor[] b();

        t1 c(t1 t1Var);

        long d();

        boolean e(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {
        public final Format a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2029b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2030c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2031d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2032e;

        /* renamed from: f  reason: collision with root package name */
        public final int f2033f;
        public final int g;
        public final int h;
        public final AudioProcessor[] i;

        public c(Format format, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, AudioProcessor[] audioProcessorArr) {
            this.a = format;
            this.f2029b = i;
            this.f2030c = i2;
            this.f2031d = i3;
            this.f2032e = i4;
            this.f2033f = i5;
            this.g = i6;
            this.i = audioProcessorArr;
            this.h = c(i7, z);
        }

        private int c(int i, boolean z) {
            if (i != 0) {
                return i;
            }
            int i2 = this.f2030c;
            if (i2 == 0) {
                return m(z ? 8.0f : 1.0f);
            } else if (i2 == 1) {
                return l(50000000L);
            } else {
                if (i2 == 2) {
                    return l(250000L);
                }
                throw new IllegalStateException();
            }
        }

        private AudioTrack d(boolean z, p pVar, int i) {
            int i2 = o0.a;
            if (i2 >= 29) {
                return f(z, pVar, i);
            }
            if (i2 >= 21) {
                return e(z, pVar, i);
            }
            return g(pVar, i);
        }

        @RequiresApi(21)
        private AudioTrack e(boolean z, p pVar, int i) {
            return new AudioTrack(j(pVar, z), DefaultAudioSink.J(this.f2032e, this.f2033f, this.g), this.h, 1, i);
        }

        @RequiresApi(29)
        private AudioTrack f(boolean z, p pVar, int i) {
            AudioFormat J = DefaultAudioSink.J(this.f2032e, this.f2033f, this.g);
            AudioAttributes j = j(pVar, z);
            boolean z2 = true;
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(j).setAudioFormat(J).setTransferMode(1).setBufferSizeInBytes(this.h).setSessionId(i);
            if (this.f2030c != 1) {
                z2 = false;
            }
            return sessionId.setOffloadedPlayback(z2).build();
        }

        private AudioTrack g(p pVar, int i) {
            int Y = o0.Y(pVar.f2110e);
            if (i == 0) {
                return new AudioTrack(Y, this.f2032e, this.f2033f, this.g, this.h, 1);
            }
            return new AudioTrack(Y, this.f2032e, this.f2033f, this.g, this.h, 1, i);
        }

        @RequiresApi(21)
        private static AudioAttributes j(p pVar, boolean z) {
            if (z) {
                return k();
            }
            return pVar.a();
        }

        @RequiresApi(21)
        private static AudioAttributes k() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        private int l(long j) {
            int P = DefaultAudioSink.P(this.g);
            if (this.g == 5) {
                P *= 2;
            }
            return (int) ((j * P) / 1000000);
        }

        private int m(float f2) {
            int minBufferSize = AudioTrack.getMinBufferSize(this.f2032e, this.f2033f, this.g);
            com.google.android.exoplayer2.util.g.g(minBufferSize != -2);
            int p = o0.p(minBufferSize * 4, ((int) h(250000L)) * this.f2031d, Math.max(minBufferSize, ((int) h(750000L)) * this.f2031d));
            return f2 != 1.0f ? Math.round(p * f2) : p;
        }

        public AudioTrack a(boolean z, p pVar, int i) throws AudioSink.InitializationException {
            try {
                AudioTrack d2 = d(z, pVar, i);
                int state = d2.getState();
                if (state == 1) {
                    return d2;
                }
                try {
                    d2.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.f2032e, this.f2033f, this.h, this.a, o(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e2) {
                throw new AudioSink.InitializationException(0, this.f2032e, this.f2033f, this.h, this.a, o(), e2);
            }
        }

        public boolean b(c cVar) {
            return cVar.f2030c == this.f2030c && cVar.g == this.g && cVar.f2032e == this.f2032e && cVar.f2033f == this.f2033f && cVar.f2031d == this.f2031d;
        }

        public long h(long j) {
            return (j * this.f2032e) / 1000000;
        }

        public long i(long j) {
            return (j * 1000000) / this.f2032e;
        }

        public long n(long j) {
            return (j * 1000000) / this.a.V3;
        }

        public boolean o() {
            return this.f2030c == 1;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements b {
        private final AudioProcessor[] a;

        /* renamed from: b  reason: collision with root package name */
        private final h0 f2034b;

        /* renamed from: c  reason: collision with root package name */
        private final j0 f2035c;

        public d(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new h0(), new j0());
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long a(long j) {
            return this.f2035c.f(j);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public AudioProcessor[] b() {
            return this.a;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public t1 c(t1 t1Var) {
            this.f2035c.h(t1Var.f3437c);
            this.f2035c.g(t1Var.f3438d);
            return t1Var;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long d() {
            return this.f2034b.o();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public boolean e(boolean z) {
            this.f2034b.u(z);
            return z;
        }

        public d(AudioProcessor[] audioProcessorArr, h0 h0Var, j0 j0Var) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f2034b = h0Var;
            this.f2035c = j0Var;
            audioProcessorArr2[audioProcessorArr.length] = h0Var;
            audioProcessorArr2[audioProcessorArr.length + 1] = j0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e {
        public final t1 a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f2036b;

        /* renamed from: c  reason: collision with root package name */
        public final long f2037c;

        /* renamed from: d  reason: collision with root package name */
        public final long f2038d;

        /* synthetic */ e(t1 t1Var, boolean z, long j, long j2, a aVar) {
            this(t1Var, z, j, j2);
        }

        private e(t1 t1Var, boolean z, long j, long j2) {
            this.a = t1Var;
            this.f2036b = z;
            this.f2037c = j;
            this.f2038d = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class f<T extends Exception> {
        private final long a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private T f2039b;

        /* renamed from: c  reason: collision with root package name */
        private long f2040c;

        public f(long j) {
            this.a = j;
        }

        public void a() {
            this.f2039b = null;
        }

        public void b(T t) throws Exception {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f2039b == null) {
                this.f2039b = t;
                this.f2040c = this.a + elapsedRealtime;
            }
            if (elapsedRealtime >= this.f2040c) {
                T t2 = this.f2039b;
                if (t2 != t) {
                    t2.addSuppressed(t);
                }
                T t3 = this.f2039b;
                a();
                throw t3;
            }
        }
    }

    /* loaded from: classes.dex */
    private final class g implements w.a {
        private g() {
        }

        @Override // com.google.android.exoplayer2.audio.w.a
        public void a(int i, long j) {
            if (DefaultAudioSink.this.q != null) {
                DefaultAudioSink.this.q.e(i, j, SystemClock.elapsedRealtime() - DefaultAudioSink.this.Y);
            }
        }

        @Override // com.google.android.exoplayer2.audio.w.a
        public void b(long j) {
            StringBuilder sb = new StringBuilder(61);
            sb.append("Ignoring impossibly large audio latency: ");
            sb.append(j);
            u.h("DefaultAudioSink", sb.toString());
        }

        @Override // com.google.android.exoplayer2.audio.w.a
        public void c(long j) {
            if (DefaultAudioSink.this.q != null) {
                DefaultAudioSink.this.q.c(j);
            }
        }

        @Override // com.google.android.exoplayer2.audio.w.a
        public void d(long j, long j2, long j3, long j4) {
            long S = DefaultAudioSink.this.S();
            long T = DefaultAudioSink.this.T();
            StringBuilder sb = new StringBuilder(182);
            sb.append("Spurious audio timestamp (frame position mismatch): ");
            sb.append(j);
            sb.append(", ");
            sb.append(j2);
            sb.append(", ");
            sb.append(j3);
            sb.append(", ");
            sb.append(j4);
            sb.append(", ");
            sb.append(S);
            sb.append(", ");
            sb.append(T);
            String sb2 = sb.toString();
            if (!DefaultAudioSink.a) {
                u.h("DefaultAudioSink", sb2);
                return;
            }
            throw new InvalidAudioTrackTimestampException(sb2, null);
        }

        @Override // com.google.android.exoplayer2.audio.w.a
        public void e(long j, long j2, long j3, long j4) {
            long S = DefaultAudioSink.this.S();
            long T = DefaultAudioSink.this.T();
            StringBuilder sb = new StringBuilder(180);
            sb.append("Spurious audio timestamp (system clock mismatch): ");
            sb.append(j);
            sb.append(", ");
            sb.append(j2);
            sb.append(", ");
            sb.append(j3);
            sb.append(", ");
            sb.append(j4);
            sb.append(", ");
            sb.append(S);
            sb.append(", ");
            sb.append(T);
            String sb2 = sb.toString();
            if (!DefaultAudioSink.a) {
                u.h("DefaultAudioSink", sb2);
                return;
            }
            throw new InvalidAudioTrackTimestampException(sb2, null);
        }

        /* synthetic */ g(DefaultAudioSink defaultAudioSink, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    public final class h {
        private final Handler a = new Handler();

        /* renamed from: b  reason: collision with root package name */
        private final AudioTrack.StreamEventCallback f2041b;

        /* loaded from: classes.dex */
        class a extends AudioTrack.StreamEventCallback {
            final /* synthetic */ DefaultAudioSink a;

            a(DefaultAudioSink defaultAudioSink) {
                this.a = defaultAudioSink;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i) {
                com.google.android.exoplayer2.util.g.g(audioTrack == DefaultAudioSink.this.t);
                if (DefaultAudioSink.this.q != null && DefaultAudioSink.this.T) {
                    DefaultAudioSink.this.q.g();
                }
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(@NonNull AudioTrack audioTrack) {
                com.google.android.exoplayer2.util.g.g(audioTrack == DefaultAudioSink.this.t);
                if (DefaultAudioSink.this.q != null && DefaultAudioSink.this.T) {
                    DefaultAudioSink.this.q.g();
                }
            }
        }

        public h() {
            this.f2041b = new a(DefaultAudioSink.this);
        }

        public void a(AudioTrack audioTrack) {
            final Handler handler = this.a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new Executor() { // from class: com.google.android.exoplayer2.audio.l
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handler.post(runnable);
                }
            }, this.f2041b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f2041b);
            this.a.removeCallbacksAndMessages(null);
        }
    }

    public DefaultAudioSink(@Nullable q qVar, AudioProcessor[] audioProcessorArr) {
        this(qVar, audioProcessorArr, false);
    }

    private void D(long j) {
        t1 t1Var;
        if (l0()) {
            t1Var = this.f2023c.c(K());
        } else {
            t1Var = t1.a;
        }
        boolean e2 = l0() ? this.f2023c.e(R()) : false;
        this.k.add(new e(t1Var, e2, Math.max(0L, j), this.s.i(T()), null));
        k0();
        AudioSink.a aVar = this.q;
        if (aVar != null) {
            aVar.a(e2);
        }
    }

    private long E(long j) {
        while (!this.k.isEmpty() && j >= this.k.getFirst().f2038d) {
            this.w = this.k.remove();
        }
        e eVar = this.w;
        long j2 = j - eVar.f2038d;
        if (eVar.a.equals(t1.a)) {
            return this.w.f2037c + j2;
        }
        if (this.k.isEmpty()) {
            return this.w.f2037c + this.f2023c.a(j2);
        }
        e first = this.k.getFirst();
        return first.f2037c - o0.S(first.f2038d - j, this.w.a.f3437c);
    }

    private long F(long j) {
        return j + this.s.i(this.f2023c.d());
    }

    private AudioTrack G() throws AudioSink.InitializationException {
        try {
            return ((c) com.google.android.exoplayer2.util.g.e(this.s)).a(this.X, this.u, this.V);
        } catch (AudioSink.InitializationException e2) {
            a0();
            AudioSink.a aVar = this.q;
            if (aVar != null) {
                aVar.b(e2);
            }
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean H() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.Q
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x000b
            r9.Q = r3
        L_0x0009:
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            int r4 = r9.Q
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.J
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x002f
            r4 = r5[r4]
            if (r0 == 0) goto L_0x001f
            r4.e()
        L_0x001f:
            r9.c0(r7)
            boolean r0 = r4.d()
            if (r0 != 0) goto L_0x0029
            return r3
        L_0x0029:
            int r0 = r9.Q
            int r0 = r0 + r2
            r9.Q = r0
            goto L_0x0009
        L_0x002f:
            java.nio.ByteBuffer r0 = r9.N
            if (r0 == 0) goto L_0x003b
            r9.o0(r0, r7)
            java.nio.ByteBuffer r0 = r9.N
            if (r0 == 0) goto L_0x003b
            return r3
        L_0x003b:
            r9.Q = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.H():boolean");
    }

    private void I() {
        int i = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.J;
            if (i < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                audioProcessor.flush();
                this.K[i] = audioProcessor.a();
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    public static AudioFormat J(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    private t1 K() {
        return Q().a;
    }

    private static int L(int i) {
        int i2 = o0.a;
        if (i2 <= 28) {
            if (i == 7) {
                i = 8;
            } else if (i == 3 || i == 4 || i == 5) {
                i = 6;
            }
        }
        if (i2 <= 26 && "fugu".equals(o0.f3933b) && i == 1) {
            i = 2;
        }
        return o0.D(i);
    }

    @Nullable
    private static Pair<Integer, Integer> M(Format format, @Nullable q qVar) {
        if (qVar == null) {
            return null;
        }
        int f2 = y.f((String) com.google.android.exoplayer2.util.g.e(format.H3), format.p1);
        int i = 6;
        if (!(f2 == 5 || f2 == 6 || f2 == 18 || f2 == 17 || f2 == 7 || f2 == 8 || f2 == 14)) {
            return null;
        }
        if (f2 == 18 && !qVar.f(18)) {
            f2 = 6;
        } else if (f2 == 8 && !qVar.f(8)) {
            f2 = 7;
        }
        if (!qVar.f(f2)) {
            return null;
        }
        if (f2 != 18) {
            i = format.U3;
            if (i > qVar.e()) {
                return null;
            }
        } else if (o0.a >= 29 && (i = O(18, format.V3)) == 0) {
            u.h("DefaultAudioSink", "E-AC3 JOC encoding supported but no channel count supported");
            return null;
        }
        int L = L(i);
        if (L == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(f2), Integer.valueOf(L));
    }

    private static int N(int i, ByteBuffer byteBuffer) {
        switch (i) {
            case 5:
            case 6:
            case 18:
                return n.d(byteBuffer);
            case 7:
            case 8:
                return b0.e(byteBuffer);
            case 9:
                int m = e0.m(o0.E(byteBuffer, byteBuffer.position()));
                if (m != -1) {
                    return m;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            default:
                StringBuilder sb = new StringBuilder(38);
                sb.append("Unexpected audio encoding: ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
            case 14:
                int a2 = n.a(byteBuffer);
                if (a2 == -1) {
                    return 0;
                }
                return n.h(byteBuffer, a2) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return o.c(byteBuffer);
        }
    }

    @RequiresApi(29)
    private static int O(int i, int i2) {
        AudioAttributes build = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
        for (int i3 = 8; i3 > 0; i3--) {
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(o0.D(i3)).build(), build)) {
                return i3;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int P(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
        }
    }

    private e Q() {
        e eVar = this.v;
        if (eVar != null) {
            return eVar;
        }
        if (!this.k.isEmpty()) {
            return this.k.getLast();
        }
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long S() {
        c cVar = this.s;
        if (cVar.f2030c == 0) {
            return this.A / cVar.f2029b;
        }
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long T() {
        c cVar = this.s;
        if (cVar.f2030c == 0) {
            return this.C / cVar.f2031d;
        }
        return this.D;
    }

    private void U() throws AudioSink.InitializationException {
        this.i.block();
        AudioTrack G = G();
        this.t = G;
        if (Y(G)) {
            d0(this.t);
            if (this.m != 3) {
                AudioTrack audioTrack = this.t;
                Format format = this.s.a;
                audioTrack.setOffloadDelayPadding(format.X3, format.Y3);
            }
        }
        this.V = this.t.getAudioSessionId();
        w wVar = this.j;
        AudioTrack audioTrack2 = this.t;
        c cVar = this.s;
        wVar.t(audioTrack2, cVar.f2030c == 2, cVar.g, cVar.f2031d, cVar.h);
        h0();
        int i = this.W.a;
        if (i != 0) {
            this.t.attachAuxEffect(i);
            this.t.setAuxEffectSendLevel(this.W.f2134b);
        }
        this.G = true;
    }

    private static boolean V(int i) {
        return (o0.a >= 24 && i == -6) || i == -32;
    }

    private boolean W() {
        return this.t != null;
    }

    private static boolean X() {
        return o0.a >= 30 && o0.f3935d.startsWith("Pixel");
    }

    private static boolean Y(AudioTrack audioTrack) {
        return o0.a >= 29 && audioTrack.isOffloadedPlayback();
    }

    private static boolean Z(Format format, @Nullable q qVar) {
        return M(format, qVar) != null;
    }

    private void a0() {
        if (this.s.o()) {
            this.Z = true;
        }
    }

    private void b0() {
        if (!this.S) {
            this.S = true;
            this.j.h(T());
            this.t.stop();
            this.z = 0;
        }
    }

    private void c0(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.J.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.K[i - 1];
            } else {
                byteBuffer = this.L;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.a;
                }
            }
            if (i == length) {
                o0(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.J[i];
                if (i > this.Q) {
                    audioProcessor.b(byteBuffer);
                }
                ByteBuffer a2 = audioProcessor.a();
                this.K[i] = a2;
                if (a2.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    @RequiresApi(29)
    private void d0(AudioTrack audioTrack) {
        if (this.n == null) {
            this.n = new h();
        }
        this.n.a(audioTrack);
    }

    private void e0() {
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.a0 = false;
        this.E = 0;
        this.w = new e(K(), R(), 0L, 0L, null);
        this.H = 0L;
        this.v = null;
        this.k.clear();
        this.L = null;
        this.M = 0;
        this.N = null;
        this.S = false;
        this.R = false;
        this.Q = -1;
        this.y = null;
        this.z = 0;
        this.f2026f.m();
        I();
    }

    private void f0(t1 t1Var, boolean z) {
        e Q = Q();
        if (!t1Var.equals(Q.a) || z != Q.f2036b) {
            e eVar = new e(t1Var, z, -9223372036854775807L, -9223372036854775807L, null);
            if (W()) {
                this.v = eVar;
            } else {
                this.w = eVar;
            }
        }
    }

    @RequiresApi(23)
    private void g0(t1 t1Var) {
        if (W()) {
            try {
                this.t.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(t1Var.f3437c).setPitch(t1Var.f3438d).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                u.i("DefaultAudioSink", "Failed to set playback params", e2);
            }
            t1Var = new t1(this.t.getPlaybackParams().getSpeed(), this.t.getPlaybackParams().getPitch());
            this.j.u(t1Var.f3437c);
        }
        this.x = t1Var;
    }

    private void h0() {
        if (W()) {
            if (o0.a >= 21) {
                i0(this.t, this.I);
            } else {
                j0(this.t, this.I);
            }
        }
    }

    @RequiresApi(21)
    private static void i0(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private static void j0(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void k0() {
        AudioProcessor[] audioProcessorArr = this.s.i;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.J = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.K = new ByteBuffer[size];
        I();
    }

    private boolean l0() {
        return !this.X && "audio/raw".equals(this.s.a.H3) && !m0(this.s.a.W3);
    }

    private boolean m0(int i) {
        return this.f2024d && o0.j0(i);
    }

    private boolean n0(Format format, p pVar) {
        int f2;
        int D;
        if (o0.a < 29 || this.m == 0 || (f2 = y.f((String) com.google.android.exoplayer2.util.g.e(format.H3), format.p1)) == 0 || (D = o0.D(format.U3)) == 0 || !AudioManager.isOffloadedPlaybackSupported(J(format.V3, D, f2), pVar.a())) {
            return false;
        }
        return !(format.X3 != 0 || format.Y3 != 0) || !(this.m == 1) || X();
    }

    private void o0(ByteBuffer byteBuffer, long j) throws AudioSink.WriteException {
        int i;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.N;
            boolean z = true;
            if (byteBuffer2 != null) {
                com.google.android.exoplayer2.util.g.a(byteBuffer2 == byteBuffer);
            } else {
                this.N = byteBuffer;
                if (o0.a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.O;
                    if (bArr == null || bArr.length < remaining) {
                        this.O = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.O, 0, remaining);
                    byteBuffer.position(position);
                    this.P = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (o0.a < 21) {
                int c2 = this.j.c(this.C);
                if (c2 > 0) {
                    i = this.t.write(this.O, this.P, Math.min(remaining2, c2));
                    if (i > 0) {
                        this.P += i;
                        byteBuffer.position(byteBuffer.position() + i);
                    }
                } else {
                    i = 0;
                }
            } else if (this.X) {
                com.google.android.exoplayer2.util.g.g(j != -9223372036854775807L);
                i = q0(this.t, byteBuffer, remaining2, j);
            } else {
                i = p0(this.t, byteBuffer, remaining2);
            }
            this.Y = SystemClock.elapsedRealtime();
            if (i < 0) {
                boolean V = V(i);
                if (V) {
                    a0();
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(i, this.s.a, V);
                AudioSink.a aVar = this.q;
                if (aVar != null) {
                    aVar.b(writeException);
                }
                if (!writeException.isRecoverable) {
                    this.p.b(writeException);
                    return;
                }
                throw writeException;
            }
            this.p.a();
            if (Y(this.t)) {
                long j2 = this.D;
                if (j2 > 0) {
                    this.a0 = false;
                }
                if (this.T && this.q != null && i < remaining2 && !this.a0) {
                    this.q.d(this.j.e(j2));
                }
            }
            int i2 = this.s.f2030c;
            if (i2 == 0) {
                this.C += i;
            }
            if (i == remaining2) {
                if (i2 != 0) {
                    if (byteBuffer != this.L) {
                        z = false;
                    }
                    com.google.android.exoplayer2.util.g.g(z);
                    this.D += this.E * this.M;
                }
                this.N = null;
            }
        }
    }

    @RequiresApi(21)
    private static int p0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    @RequiresApi(21)
    private int q0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (o0.a >= 26) {
            return audioTrack.write(byteBuffer, i, 1, j * 1000);
        }
        if (this.y == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.y = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.y.putInt(1431633921);
        }
        if (this.z == 0) {
            this.y.putInt(4, i);
            this.y.putLong(8, j * 1000);
            this.y.position(0);
            this.z = i;
        }
        int remaining = this.y.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.y, remaining, 1);
            if (write < 0) {
                this.z = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int p0 = p0(audioTrack, byteBuffer, i);
        if (p0 < 0) {
            this.z = 0;
            return p0;
        }
        this.z -= p0;
        return p0;
    }

    public boolean R() {
        return Q().f2036b;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(Format format) {
        return k(format) != 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean b() {
        return W() && this.j.i(T());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public t1 c() {
        if (this.l) {
            return this.x;
        }
        return K();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean d() {
        return !W() || (this.R && !b());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void e(t1 t1Var) {
        t1 t1Var2 = new t1(o0.o(t1Var.f3437c, 0.1f, 8.0f), o0.o(t1Var.f3438d, 0.1f, 8.0f));
        if (!this.l || o0.a < 23) {
            f0(t1Var2, R());
        } else {
            g0(t1Var2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void f(int i) {
        if (this.V != i) {
            this.V = i;
            this.U = i != 0;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (W()) {
            e0();
            if (this.j.j()) {
                this.t.pause();
            }
            if (Y(this.t)) {
                ((h) com.google.android.exoplayer2.util.g.e(this.n)).b(this.t);
            }
            AudioTrack audioTrack = this.t;
            this.t = null;
            if (o0.a < 21 && !this.U) {
                this.V = 0;
            }
            c cVar = this.r;
            if (cVar != null) {
                this.s = cVar;
                this.r = null;
            }
            this.j.r();
            this.i.close();
            new a("ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
        this.p.a();
        this.o.a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void g() {
        if (this.X) {
            this.X = false;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void h(p pVar) {
        if (!this.u.equals(pVar)) {
            this.u = pVar;
            if (!this.X) {
                flush();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean i(ByteBuffer byteBuffer, long j, int i) throws AudioSink.InitializationException, AudioSink.WriteException {
        ByteBuffer byteBuffer2 = this.L;
        com.google.android.exoplayer2.util.g.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.r != null) {
            if (!H()) {
                return false;
            }
            if (!this.r.b(this.s)) {
                b0();
                if (b()) {
                    return false;
                }
                flush();
            } else {
                this.s = this.r;
                this.r = null;
                if (Y(this.t) && this.m != 3) {
                    this.t.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.t;
                    Format format = this.s.a;
                    audioTrack.setOffloadDelayPadding(format.X3, format.Y3);
                    this.a0 = true;
                }
            }
            D(j);
        }
        if (!W()) {
            try {
                U();
            } catch (AudioSink.InitializationException e2) {
                if (!e2.isRecoverable) {
                    this.o.b(e2);
                    return false;
                }
                throw e2;
            }
        }
        this.o.a();
        if (this.G) {
            this.H = Math.max(0L, j);
            this.F = false;
            this.G = false;
            if (this.l && o0.a >= 23) {
                g0(this.x);
            }
            D(j);
            if (this.T) {
                play();
            }
        }
        if (!this.j.l(T())) {
            return false;
        }
        if (this.L == null) {
            com.google.android.exoplayer2.util.g.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            c cVar = this.s;
            if (cVar.f2030c != 0 && this.E == 0) {
                int N = N(cVar.g, byteBuffer);
                this.E = N;
                if (N == 0) {
                    return true;
                }
            }
            if (this.v != null) {
                if (!H()) {
                    return false;
                }
                D(j);
                this.v = null;
            }
            long n = this.H + this.s.n(S() - this.f2026f.l());
            if (!this.F && Math.abs(n - j) > 200000) {
                this.q.b(new AudioSink.UnexpectedDiscontinuityException(j, n));
                this.F = true;
            }
            if (this.F) {
                if (!H()) {
                    return false;
                }
                long j2 = j - n;
                this.H += j2;
                this.F = false;
                D(j);
                AudioSink.a aVar = this.q;
                if (!(aVar == null || j2 == 0)) {
                    aVar.f();
                }
            }
            if (this.s.f2030c == 0) {
                this.A += byteBuffer.remaining();
            } else {
                this.B += this.E * i;
            }
            this.L = byteBuffer;
            this.M = i;
        }
        c0(j);
        if (!this.L.hasRemaining()) {
            this.L = null;
            this.M = 0;
            return true;
        } else if (!this.j.k(T())) {
            return false;
        } else {
            u.h("DefaultAudioSink", "Resetting stalled audio track");
            flush();
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void j(AudioSink.a aVar) {
        this.q = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int k(Format format) {
        if (!"audio/raw".equals(format.H3)) {
            return ((this.Z || !n0(format, this.u)) && !Z(format, this.f2022b)) ? 0 : 2;
        }
        if (!o0.k0(format.W3)) {
            int i = format.W3;
            StringBuilder sb = new StringBuilder(33);
            sb.append("Invalid PCM encoding: ");
            sb.append(i);
            u.h("DefaultAudioSink", sb.toString());
            return 0;
        }
        int i2 = format.W3;
        return (i2 == 2 || (this.f2024d && i2 == 4)) ? 2 : 1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void l() {
        if (o0.a < 25) {
            flush();
            return;
        }
        this.p.a();
        this.o.a();
        if (W()) {
            e0();
            if (this.j.j()) {
                this.t.pause();
            }
            this.t.flush();
            this.j.r();
            w wVar = this.j;
            AudioTrack audioTrack = this.t;
            c cVar = this.s;
            wVar.t(audioTrack, cVar.f2030c == 2, cVar.g, cVar.f2031d, cVar.h);
            this.G = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void m(x xVar) {
        if (!this.W.equals(xVar)) {
            int i = xVar.a;
            float f2 = xVar.f2134b;
            AudioTrack audioTrack = this.t;
            if (audioTrack != null) {
                if (this.W.a != i) {
                    audioTrack.attachAuxEffect(i);
                }
                if (i != 0) {
                    this.t.setAuxEffectSendLevel(f2);
                }
            }
            this.W = xVar;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void n() throws AudioSink.WriteException {
        if (!this.R && W() && H()) {
            b0();
            this.R = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long o(boolean z) {
        if (!W() || this.G) {
            return Long.MIN_VALUE;
        }
        return F(E(Math.min(this.j.d(z), this.s.i(T()))));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void p() {
        this.F = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.T = false;
        if (W() && this.j.q()) {
            this.t.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.T = true;
        if (W()) {
            this.j.v();
            this.t.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void q(float f2) {
        if (this.I != f2) {
            this.I = f2;
            h0();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void r() {
        com.google.android.exoplayer2.util.g.g(o0.a >= 21);
        com.google.android.exoplayer2.util.g.g(this.U);
        if (!this.X) {
            this.X = true;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        for (AudioProcessor audioProcessor : this.g) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.h) {
            audioProcessor2.reset();
        }
        this.T = false;
        this.Z = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void s(Format format, int i, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessor[] audioProcessorArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        AudioProcessor[] audioProcessorArr2;
        int[] iArr2;
        if ("audio/raw".equals(format.H3)) {
            com.google.android.exoplayer2.util.g.a(o0.k0(format.W3));
            i7 = o0.W(format.W3, format.U3);
            if (m0(format.W3)) {
                audioProcessorArr2 = this.h;
            } else {
                audioProcessorArr2 = this.g;
            }
            this.f2026f.n(format.X3, format.Y3);
            if (o0.a < 21 && format.U3 == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i8 = 0; i8 < 6; i8++) {
                    iArr2[i8] = i8;
                }
            } else {
                iArr2 = iArr;
            }
            this.f2025e.l(iArr2);
            AudioProcessor.a aVar = new AudioProcessor.a(format.V3, format.U3, format.W3);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.a c2 = audioProcessor.c(aVar);
                    if (audioProcessor.isActive()) {
                        aVar = c2;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e2) {
                    throw new AudioSink.ConfigurationException(e2, format);
                }
            }
            int i9 = aVar.f2020d;
            i4 = aVar.f2018b;
            i3 = o0.D(aVar.f2019c);
            i5 = o0.W(i9, aVar.f2019c);
            audioProcessorArr = audioProcessorArr2;
            i2 = i9;
            i6 = 0;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i10 = format.V3;
            if (n0(format, this.u)) {
                int f2 = y.f((String) com.google.android.exoplayer2.util.g.e(format.H3), format.p1);
                i3 = o0.D(format.U3);
                audioProcessorArr = audioProcessorArr3;
                i2 = f2;
                i7 = -1;
                i5 = -1;
                i4 = i10;
                i6 = 1;
            } else {
                Pair<Integer, Integer> M = M(format, this.f2022b);
                if (M != null) {
                    i2 = ((Integer) M.first).intValue();
                    i3 = ((Integer) M.second).intValue();
                    audioProcessorArr = audioProcessorArr3;
                    i7 = -1;
                    i5 = -1;
                    i4 = i10;
                    i6 = 2;
                } else {
                    String valueOf = String.valueOf(format);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 37);
                    sb.append("Unable to configure passthrough for: ");
                    sb.append(valueOf);
                    throw new AudioSink.ConfigurationException(sb.toString(), format);
                }
            }
        }
        if (i2 == 0) {
            String valueOf2 = String.valueOf(format);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 48);
            sb2.append("Invalid output encoding (mode=");
            sb2.append(i6);
            sb2.append(") for: ");
            sb2.append(valueOf2);
            throw new AudioSink.ConfigurationException(sb2.toString(), format);
        } else if (i3 != 0) {
            this.Z = false;
            c cVar = new c(format, i7, i6, i5, i4, i3, i2, i, this.l, audioProcessorArr);
            if (W()) {
                this.r = cVar;
            } else {
                this.s = cVar;
            }
        } else {
            String valueOf3 = String.valueOf(format);
            StringBuilder sb3 = new StringBuilder(valueOf3.length() + 54);
            sb3.append("Invalid output channel config (mode=");
            sb3.append(i6);
            sb3.append(") for: ");
            sb3.append(valueOf3);
            throw new AudioSink.ConfigurationException(sb3.toString(), format);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void t(boolean z) {
        f0(K(), z);
    }

    public DefaultAudioSink(@Nullable q qVar, AudioProcessor[] audioProcessorArr, boolean z) {
        this(qVar, new d(audioProcessorArr), z, false, 0);
    }

    public DefaultAudioSink(@Nullable q qVar, b bVar, boolean z, boolean z2, int i) {
        this.f2022b = qVar;
        this.f2023c = (b) com.google.android.exoplayer2.util.g.e(bVar);
        int i2 = o0.a;
        this.f2024d = i2 >= 21 && z;
        this.l = i2 >= 23 && z2;
        this.m = i2 < 29 ? 0 : i;
        this.i = new ConditionVariable(true);
        this.j = new w(new g(this, null));
        z zVar = new z();
        this.f2025e = zVar;
        k0 k0Var = new k0();
        this.f2026f = k0Var;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new g0(), zVar, k0Var);
        Collections.addAll(arrayList, bVar.b());
        this.g = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.h = new AudioProcessor[]{new c0()};
        this.I = 1.0f;
        this.u = p.a;
        this.V = 0;
        this.W = new x(0, 0.0f);
        t1 t1Var = t1.a;
        this.w = new e(t1Var, false, 0L, 0L, null);
        this.x = t1Var;
        this.Q = -1;
        this.J = new AudioProcessor[0];
        this.K = new ByteBuffer[0];
        this.k = new ArrayDeque<>();
        this.o = new f<>(100L);
        this.p = new f<>(100L);
    }
}
