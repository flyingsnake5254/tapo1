package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.u;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* compiled from: AacUtil.java */
/* loaded from: classes.dex */
public final class m {
    private static final int[] a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2090b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* compiled from: AacUtil.java */
    /* loaded from: classes.dex */
    public static final class b {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2091b;

        /* renamed from: c  reason: collision with root package name */
        public final String f2092c;

        private b(int i, int i2, String str) {
            this.a = i;
            this.f2091b = i2;
            this.f2092c = str;
        }
    }

    public static byte[] a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    private static int b(c0 c0Var) {
        int h = c0Var.h(5);
        return h == 31 ? c0Var.h(6) + 32 : h;
    }

    public static int c(int i) {
        if (i == 2) {
            return 10;
        }
        if (i == 5) {
            return 11;
        }
        if (i == 29) {
            return 12;
        }
        if (i != 42) {
            return i != 22 ? i != 23 ? 0 : 15 : Pow2.MAX_POW2;
        }
        return 16;
    }

    private static int d(c0 c0Var) throws ParserException {
        int h = c0Var.h(4);
        if (h == 15) {
            return c0Var.h(24);
        }
        if (h < 13) {
            return a[h];
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b e(c0 c0Var, boolean z) throws ParserException {
        int b2 = b(c0Var);
        int d2 = d(c0Var);
        int h = c0Var.h(4);
        StringBuilder sb = new StringBuilder(19);
        sb.append("mp4a.40.");
        sb.append(b2);
        String sb2 = sb.toString();
        if (b2 == 5 || b2 == 29) {
            d2 = d(c0Var);
            b2 = b(c0Var);
            if (b2 == 22) {
                h = c0Var.h(4);
            }
        }
        if (z) {
            if (!(b2 == 1 || b2 == 2 || b2 == 3 || b2 == 4 || b2 == 6 || b2 == 7 || b2 == 17)) {
                switch (b2) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        StringBuilder sb3 = new StringBuilder(42);
                        sb3.append("Unsupported audio object type: ");
                        sb3.append(b2);
                        throw ParserException.createForUnsupportedContainerFeature(sb3.toString());
                }
            }
            g(c0Var, b2, h);
            switch (b2) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int h2 = c0Var.h(2);
                    if (h2 == 2 || h2 == 3) {
                        StringBuilder sb4 = new StringBuilder(33);
                        sb4.append("Unsupported epConfig: ");
                        sb4.append(h2);
                        throw ParserException.createForUnsupportedContainerFeature(sb4.toString());
                    }
            }
        }
        int i = f2090b[h];
        if (i != -1) {
            return new b(d2, i, sb2);
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b f(byte[] bArr) throws ParserException {
        return e(new c0(bArr), false);
    }

    private static void g(c0 c0Var, int i, int i2) {
        if (c0Var.g()) {
            u.h("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (c0Var.g()) {
            c0Var.r(14);
        }
        boolean g = c0Var.g();
        if (i2 != 0) {
            if (i == 6 || i == 20) {
                c0Var.r(3);
            }
            if (g) {
                if (i == 22) {
                    c0Var.r(16);
                }
                if (i == 17 || i == 19 || i == 20 || i == 23) {
                    c0Var.r(3);
                }
                c0Var.r(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }
}
