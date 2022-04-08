package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import java.nio.ByteBuffer;

/* compiled from: Ac4Util.java */
/* loaded from: classes.dex */
public final class o {
    private static final int[] a = {PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT, PlaybackException.ERROR_CODE_IO_UNSPECIFIED, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* compiled from: Ac4Util.java */
    /* loaded from: classes.dex */
    public static final class b {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2103b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2104c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2105d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2106e;

        private b(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.f2104c = i2;
            this.f2103b = i3;
            this.f2105d = i4;
            this.f2106e = i5;
        }
    }

    public static void a(int i, d0 d0Var) {
        d0Var.L(7);
        byte[] d2 = d0Var.d();
        d2[0] = -84;
        d2[1] = 64;
        d2[2] = -1;
        d2[3] = -1;
        d2[4] = (byte) ((i >> 16) & 255);
        d2[5] = (byte) ((i >> 8) & 255);
        d2[6] = (byte) (i & 255);
    }

    public static Format b(d0 d0Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        d0Var.Q(1);
        return new Format.b().S(str).e0("audio/ac4").H(2).f0(((d0Var.D() & 32) >> 5) == 1 ? 48000 : 44100).L(drmInitData).V(str2).E();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return d(new c0(bArr)).f2106e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0086, code lost:
        if (r10 != 11) goto L_0x0093;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008b, code lost:
        if (r10 != 11) goto L_0x0093;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
        if (r10 != 8) goto L_0x0093;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.exoplayer2.audio.o.b d(com.google.android.exoplayer2.util.c0 r10) {
        /*
            r0 = 16
            int r1 = r10.h(r0)
            int r0 = r10.h(r0)
            r2 = 4
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r3) goto L_0x0018
            r0 = 24
            int r0 = r10.h(r0)
            r3 = 7
            goto L_0x0019
        L_0x0018:
            r3 = 4
        L_0x0019:
            int r0 = r0 + r3
            r3 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r3) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r7 = r0
            r0 = 2
            int r1 = r10.h(r0)
            r3 = 3
            if (r1 != r3) goto L_0x002f
            int r4 = f(r10, r0)
            int r1 = r1 + r4
        L_0x002f:
            r4 = r1
            r1 = 10
            int r1 = r10.h(r1)
            boolean r5 = r10.g()
            if (r5 == 0) goto L_0x0045
            int r5 = r10.h(r3)
            if (r5 <= 0) goto L_0x0045
            r10.r(r0)
        L_0x0045:
            boolean r5 = r10.g()
            r6 = 48000(0xbb80, float:6.7262E-41)
            r8 = 44100(0xac44, float:6.1797E-41)
            if (r5 == 0) goto L_0x0055
            r9 = 48000(0xbb80, float:6.7262E-41)
            goto L_0x0058
        L_0x0055:
            r9 = 44100(0xac44, float:6.1797E-41)
        L_0x0058:
            int r10 = r10.h(r2)
            r5 = 0
            if (r9 != r8) goto L_0x0069
            r8 = 13
            if (r10 != r8) goto L_0x0069
            int[] r0 = com.google.android.exoplayer2.audio.o.a
            r10 = r0[r10]
            r8 = r10
            goto L_0x0099
        L_0x0069:
            if (r9 != r6) goto L_0x0098
            int[] r6 = com.google.android.exoplayer2.audio.o.a
            int r8 = r6.length
            if (r10 >= r8) goto L_0x0098
            r5 = r6[r10]
            int r1 = r1 % 5
            r6 = 8
            r8 = 1
            if (r1 == r8) goto L_0x008e
            r8 = 11
            if (r1 == r0) goto L_0x0089
            if (r1 == r3) goto L_0x008e
            if (r1 == r2) goto L_0x0082
            goto L_0x0093
        L_0x0082:
            if (r10 == r3) goto L_0x0095
            if (r10 == r6) goto L_0x0095
            if (r10 != r8) goto L_0x0093
            goto L_0x0095
        L_0x0089:
            if (r10 == r6) goto L_0x0095
            if (r10 != r8) goto L_0x0093
            goto L_0x0095
        L_0x008e:
            if (r10 == r3) goto L_0x0095
            if (r10 != r6) goto L_0x0093
            goto L_0x0095
        L_0x0093:
            r8 = r5
            goto L_0x0099
        L_0x0095:
            int r5 = r5 + 1
            goto L_0x0093
        L_0x0098:
            r8 = 0
        L_0x0099:
            com.google.android.exoplayer2.audio.o$b r10 = new com.google.android.exoplayer2.audio.o$b
            r5 = 2
            r0 = 0
            r3 = r10
            r6 = r9
            r9 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.o.d(com.google.android.exoplayer2.util.c0):com.google.android.exoplayer2.audio.o$b");
    }

    public static int e(byte[] bArr, int i) {
        int i2 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i3 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i3 == 65535) {
            i3 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i2 = 4;
        }
        if (i == 44097) {
            i2 += 2;
        }
        return i3 + i2;
    }

    private static int f(c0 c0Var, int i) {
        int i2 = 0;
        while (true) {
            int h = i2 + c0Var.h(i);
            if (!c0Var.g()) {
                return h;
            }
            i2 = (h + 1) << i;
        }
    }
}
