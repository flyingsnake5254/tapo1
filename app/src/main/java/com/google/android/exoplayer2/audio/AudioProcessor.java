package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public interface AudioProcessor {
    public static final ByteBuffer a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* loaded from: classes.dex */
    public static final class UnhandledAudioFormatException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public UnhandledAudioFormatException(com.google.android.exoplayer2.audio.AudioProcessor.a r3) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                int r0 = r0 + 18
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                java.lang.String r0 = "Unhandled format: "
                r1.append(r0)
                r1.append(r3)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException.<init>(com.google.android.exoplayer2.audio.AudioProcessor$a):void");
        }
    }

    /* loaded from: classes.dex */
    public static final class a {
        public static final a a = new a(-1, -1, -1);

        /* renamed from: b  reason: collision with root package name */
        public final int f2018b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2019c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2020d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2021e;

        public a(int i, int i2, int i3) {
            this.f2018b = i;
            this.f2019c = i2;
            this.f2020d = i3;
            this.f2021e = o0.k0(i3) ? o0.W(i3, i2) : -1;
        }

        public String toString() {
            int i = this.f2018b;
            int i2 = this.f2019c;
            int i3 = this.f2020d;
            StringBuilder sb = new StringBuilder(83);
            sb.append("AudioFormat[sampleRate=");
            sb.append(i);
            sb.append(", channelCount=");
            sb.append(i2);
            sb.append(", encoding=");
            sb.append(i3);
            sb.append(']');
            return sb.toString();
        }
    }

    ByteBuffer a();

    void b(ByteBuffer byteBuffer);

    a c(a aVar) throws UnhandledAudioFormatException;

    boolean d();

    void e();

    void flush();

    boolean isActive();

    void reset();
}
