package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.v0;
import java.util.Arrays;

/* compiled from: AdPlaybackState.java */
/* loaded from: classes.dex */
public final class g {
    public static final g a = new g(null, new a[0], 0, -9223372036854775807L, 0);

    /* renamed from: b  reason: collision with root package name */
    private static final a f3186b = new a(0).g(0);

    /* renamed from: c  reason: collision with root package name */
    public static final v0<g> f3187c = b.a;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Object f3188d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3189e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3190f;
    public final long g;
    public final int h;
    private final a[] i;

    /* compiled from: AdPlaybackState.java */
    /* loaded from: classes.dex */
    public static final class a {
        public static final v0<a> a = a.a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3191b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3192c;

        /* renamed from: d  reason: collision with root package name */
        public final Uri[] f3193d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f3194e;

        /* renamed from: f  reason: collision with root package name */
        public final long[] f3195f;
        public final long g;
        public final boolean h;

        public a(long j) {
            this(j, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        @CheckResult
        private static long[] a(long[] jArr, int i) {
            int length = jArr.length;
            int max = Math.max(i, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, -9223372036854775807L);
            return copyOf;
        }

        @CheckResult
        private static int[] b(int[] iArr, int i) {
            int length = iArr.length;
            int max = Math.max(i, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        public int c() {
            return d(-1);
        }

        public int d(int i) {
            int i2 = i + 1;
            while (true) {
                int[] iArr = this.f3194e;
                if (i2 >= iArr.length || this.h || iArr[i2] == 0 || iArr[i2] == 1) {
                    break;
                }
                i2++;
            }
            return i2;
        }

        public boolean e() {
            if (this.f3192c == -1) {
                return true;
            }
            for (int i = 0; i < this.f3192c; i++) {
                int[] iArr = this.f3194e;
                if (iArr[i] == 0 || iArr[i] == 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3191b == aVar.f3191b && this.f3192c == aVar.f3192c && Arrays.equals(this.f3193d, aVar.f3193d) && Arrays.equals(this.f3194e, aVar.f3194e) && Arrays.equals(this.f3195f, aVar.f3195f) && this.g == aVar.g && this.h == aVar.h;
        }

        public boolean f() {
            return this.f3192c == -1 || c() < this.f3192c;
        }

        @CheckResult
        public a g(int i) {
            int[] b2 = b(this.f3194e, i);
            long[] a2 = a(this.f3195f, i);
            return new a(this.f3191b, i, b2, (Uri[]) Arrays.copyOf(this.f3193d, i), a2, this.g, this.h);
        }

        @CheckResult
        public a h(long[] jArr) {
            int length = jArr.length;
            Uri[] uriArr = this.f3193d;
            if (length < uriArr.length) {
                jArr = a(jArr, uriArr.length);
            } else if (this.f3192c != -1 && jArr.length > uriArr.length) {
                jArr = Arrays.copyOf(jArr, uriArr.length);
            }
            return new a(this.f3191b, this.f3192c, this.f3194e, this.f3193d, jArr, this.g, this.h);
        }

        public int hashCode() {
            long j = this.f3191b;
            long j2 = this.g;
            return (((((((((((this.f3192c * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Arrays.hashCode(this.f3193d)) * 31) + Arrays.hashCode(this.f3194e)) * 31) + Arrays.hashCode(this.f3195f)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.h ? 1 : 0);
        }

        private a(long j, int i, int[] iArr, Uri[] uriArr, long[] jArr, long j2, boolean z) {
            com.google.android.exoplayer2.util.g.a(iArr.length == uriArr.length);
            this.f3191b = j;
            this.f3192c = i;
            this.f3194e = iArr;
            this.f3193d = uriArr;
            this.f3195f = jArr;
            this.g = j2;
            this.h = z;
        }
    }

    private g(@Nullable Object obj, a[] aVarArr, long j, long j2, int i) {
        this.f3188d = obj;
        this.f3190f = j;
        this.g = j2;
        this.f3189e = aVarArr.length + i;
        this.i = aVarArr;
        this.h = i;
    }

    private boolean d(long j, long j2, int i) {
        if (j == Long.MIN_VALUE) {
            return false;
        }
        long j3 = a(i).f3191b;
        return j3 == Long.MIN_VALUE ? j2 == -9223372036854775807L || j < j2 : j < j3;
    }

    public a a(int i) {
        int i2 = this.h;
        if (i < i2) {
            return f3186b;
        }
        return this.i[i - i2];
    }

    public int b(long j, long j2) {
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        if (j2 != -9223372036854775807L && j >= j2) {
            return -1;
        }
        int i = this.h;
        while (i < this.f3189e && ((a(i).f3191b != Long.MIN_VALUE && a(i).f3191b <= j) || !a(i).f())) {
            i++;
        }
        if (i < this.f3189e) {
            return i;
        }
        return -1;
    }

    public int c(long j, long j2) {
        int i = this.f3189e - 1;
        while (i >= 0 && d(j, j2, i)) {
            i--;
        }
        if (i < 0 || !a(i).e()) {
            return -1;
        }
        return i;
    }

    @CheckResult
    public g e(long[][] jArr) {
        com.google.android.exoplayer2.util.g.g(this.h == 0);
        a[] aVarArr = this.i;
        a[] aVarArr2 = (a[]) o0.w0(aVarArr, aVarArr.length);
        for (int i = 0; i < this.f3189e; i++) {
            aVarArr2[i] = aVarArr2[i].h(jArr[i]);
        }
        return new g(this.f3188d, aVarArr2, this.f3190f, this.g, this.h);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return o0.b(this.f3188d, gVar.f3188d) && this.f3189e == gVar.f3189e && this.f3190f == gVar.f3190f && this.g == gVar.g && this.h == gVar.h && Arrays.equals(this.i, gVar.i);
    }

    public int hashCode() {
        int i = this.f3189e * 31;
        Object obj = this.f3188d;
        return ((((((((i + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f3190f)) * 31) + ((int) this.g)) * 31) + this.h) * 31) + Arrays.hashCode(this.i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.f3188d);
        sb.append(", adResumePositionUs=");
        sb.append(this.f3190f);
        sb.append(", adGroups=[");
        for (int i = 0; i < this.i.length; i++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.i[i].f3191b);
            sb.append(", ads=[");
            for (int i2 = 0; i2 < this.i[i].f3194e.length; i2++) {
                sb.append("ad(state=");
                int i3 = this.i[i].f3194e[i2];
                if (i3 == 0) {
                    sb.append('_');
                } else if (i3 == 1) {
                    sb.append('R');
                } else if (i3 == 2) {
                    sb.append('S');
                } else if (i3 == 3) {
                    sb.append('P');
                } else if (i3 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.i[i].f3195f[i2]);
                sb.append(')');
                if (i2 < this.i[i].f3194e.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i < this.i.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
