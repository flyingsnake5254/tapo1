package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;

/* compiled from: MpegAudioUtil.java */
/* loaded from: classes.dex */
public final class e0 {
    private static final String[] a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2054b = {44100, 48000, 32000};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2055c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f2056d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f2057e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f2058f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    private static final int[] g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* compiled from: MpegAudioUtil.java */
    /* loaded from: classes.dex */
    public static final class a {
        public int a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public String f2059b;

        /* renamed from: c  reason: collision with root package name */
        public int f2060c;

        /* renamed from: d  reason: collision with root package name */
        public int f2061d;

        /* renamed from: e  reason: collision with root package name */
        public int f2062e;

        /* renamed from: f  reason: collision with root package name */
        public int f2063f;
        public int g;

        public boolean a(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            if (!e0.l(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return false;
            }
            this.a = i2;
            this.f2059b = e0.a[3 - i3];
            int i6 = e0.f2054b[i5];
            this.f2061d = i6;
            int i7 = 2;
            if (i2 == 2) {
                this.f2061d = i6 / 2;
            } else if (i2 == 0) {
                this.f2061d = i6 / 4;
            }
            int i8 = (i >>> 9) & 1;
            this.g = e0.k(i2, i3);
            if (i3 == 3) {
                int i9 = i2 == 3 ? e0.f2055c[i4 - 1] : e0.f2056d[i4 - 1];
                this.f2063f = i9;
                this.f2060c = (((i9 * 12) / this.f2061d) + i8) * 4;
            } else {
                int i10 = 144;
                if (i2 == 3) {
                    int i11 = i3 == 2 ? e0.f2057e[i4 - 1] : e0.f2058f[i4 - 1];
                    this.f2063f = i11;
                    this.f2060c = ((i11 * 144) / this.f2061d) + i8;
                } else {
                    int i12 = e0.g[i4 - 1];
                    this.f2063f = i12;
                    if (i3 == 1) {
                        i10 = 72;
                    }
                    this.f2060c = ((i10 * i12) / this.f2061d) + i8;
                }
            }
            if (((i >> 6) & 3) == 3) {
                i7 = 1;
            }
            this.f2062e = i7;
            return true;
        }
    }

    public static int j(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (!l(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = f2054b[i5];
        if (i2 == 2) {
            i7 /= 2;
        } else if (i2 == 0) {
            i7 /= 4;
        }
        int i8 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? f2055c[i4 - 1] : f2056d[i4 - 1]) * 12) / i7) + i8) * 4;
        }
        if (i2 == 3) {
            i6 = i3 == 2 ? f2057e[i4 - 1] : f2058f[i4 - 1];
        } else {
            i6 = g[i4 - 1];
        }
        int i9 = 144;
        if (i2 == 3) {
            return ((i6 * 144) / i7) + i8;
        }
        if (i3 == 1) {
            i9 = 72;
        }
        return ((i9 * i6) / i7) + i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i, int i2) {
        if (i2 == 1) {
            return i == 3 ? 1152 : 576;
        }
        if (i2 == 2) {
            return 1152;
        }
        if (i2 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(int i) {
        return (i & (-2097152)) == -2097152;
    }

    public static int m(int i) {
        int i2;
        int i3;
        if (!l(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 == 0 || i4 == 15 || i5 == 3) {
            return -1;
        }
        return k(i2, i3);
    }
}
