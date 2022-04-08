package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.t1;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface AudioSink {

    /* loaded from: classes.dex */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final Format format;
        public final boolean isRecoverable;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public InitializationException(int r4, int r5, int r6, int r7, com.google.android.exoplayer2.Format r8, boolean r9, @androidx.annotation.Nullable java.lang.Exception r10) {
            /*
                r3 = this;
                if (r9 == 0) goto L_0x0005
                java.lang.String r0 = " (recoverable)"
                goto L_0x0007
            L_0x0005:
                java.lang.String r0 = ""
            L_0x0007:
                int r1 = r0.length()
                int r1 = r1 + 80
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                java.lang.String r1 = "AudioTrack init failed "
                r2.append(r1)
                r2.append(r4)
                java.lang.String r1 = " "
                r2.append(r1)
                java.lang.String r1 = "Config("
                r2.append(r1)
                r2.append(r5)
                java.lang.String r5 = ", "
                r2.append(r5)
                r2.append(r6)
                r2.append(r5)
                r2.append(r7)
                java.lang.String r5 = ")"
                r2.append(r5)
                r2.append(r0)
                java.lang.String r5 = r2.toString()
                r3.<init>(r5, r10)
                r3.audioTrackState = r4
                r3.isRecoverable = r9
                r3.format = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioSink.InitializationException.<init>(int, int, int, int, com.google.android.exoplayer2.Format, boolean, java.lang.Exception):void");
        }
    }

    /* loaded from: classes.dex */
    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public UnexpectedDiscontinuityException(long r3, long r5) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 103(0x67, float:1.44E-43)
                r0.<init>(r1)
                java.lang.String r1 = "Unexpected audio track timestamp discontinuity: expected "
                r0.append(r1)
                r0.append(r5)
                java.lang.String r1 = ", got "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                r2.actualPresentationTimeUs = r3
                r2.expectedPresentationTimeUs = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioSink.UnexpectedDiscontinuityException.<init>(long, long):void");
        }
    }

    /* loaded from: classes.dex */
    public static final class WriteException extends Exception {
        public final int errorCode;
        public final Format format;
        public final boolean isRecoverable;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public WriteException(int r3, com.google.android.exoplayer2.Format r4, boolean r5) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 36
                r0.<init>(r1)
                java.lang.String r1 = "AudioTrack write failed: "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                r2.isRecoverable = r5
                r2.errorCode = r3
                r2.format = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioSink.WriteException.<init>(int, com.google.android.exoplayer2.Format, boolean):void");
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z);

        void b(Exception exc);

        void c(long j);

        void d(long j);

        void e(int i, long j, long j2);

        void f();

        void g();
    }

    boolean a(Format format);

    boolean b();

    t1 c();

    boolean d();

    void e(t1 t1Var);

    void f(int i);

    void flush();

    void g();

    void h(p pVar);

    boolean i(ByteBuffer byteBuffer, long j, int i) throws InitializationException, WriteException;

    void j(a aVar);

    int k(Format format);

    void l();

    void m(x xVar);

    void n() throws WriteException;

    long o(boolean z);

    void p();

    void pause();

    void play();

    void q(float f2);

    void r();

    void reset();

    void s(Format format, int i, @Nullable int[] iArr) throws ConfigurationException;

    void t(boolean z);

    /* loaded from: classes.dex */
    public static final class ConfigurationException extends Exception {
        public final Format format;

        public ConfigurationException(Throwable th, Format format) {
            super(th);
            this.format = format;
        }

        public ConfigurationException(String str, Format format) {
            super(str);
            this.format = format;
        }
    }
}
