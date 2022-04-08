package com.google.android.exoplayer2.o2.j0;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.o2.j0.e;
import com.google.android.exoplayer2.o2.m;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.n;
import com.google.android.exoplayer2.video.p;
import com.google.common.base.h;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: AtomParsers.java */
/* loaded from: classes.dex */
final class f {
    private static final byte[] a = o0.e0("OpusHead");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AtomParsers.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public int f2769b;

        /* renamed from: c  reason: collision with root package name */
        public int f2770c;

        /* renamed from: d  reason: collision with root package name */
        public long f2771d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f2772e;

        /* renamed from: f  reason: collision with root package name */
        private final d0 f2773f;
        private final d0 g;
        private int h;
        private int i;

        public a(d0 d0Var, d0 d0Var2, boolean z) throws ParserException {
            this.g = d0Var;
            this.f2773f = d0Var2;
            this.f2772e = z;
            d0Var2.P(12);
            this.a = d0Var2.H();
            d0Var.P(12);
            this.i = d0Var.H();
            m.a(d0Var.n() != 1 ? false : true, "first_chunk must be 1");
            this.f2769b = -1;
        }

        public boolean a() {
            long j;
            int i = this.f2769b + 1;
            this.f2769b = i;
            if (i == this.a) {
                return false;
            }
            if (this.f2772e) {
                j = this.f2773f.I();
            } else {
                j = this.f2773f.F();
            }
            this.f2771d = j;
            if (this.f2769b == this.h) {
                this.f2770c = this.g.H();
                this.g.Q(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.H() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AtomParsers.java */
    /* loaded from: classes.dex */
    public interface b {
        int a();

        int b();

        int c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AtomParsers.java */
    /* loaded from: classes.dex */
    public static final class c {
        public final p[] a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Format f2774b;

        /* renamed from: c  reason: collision with root package name */
        public int f2775c;

        /* renamed from: d  reason: collision with root package name */
        public int f2776d = 0;

        public c(int i) {
            this.a = new p[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtomParsers.java */
    /* loaded from: classes.dex */
    public static final class d implements b {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2777b;

        /* renamed from: c  reason: collision with root package name */
        private final d0 f2778c;

        public d(e.b bVar, Format format) {
            d0 d0Var = bVar.f2768b;
            this.f2778c = d0Var;
            d0Var.P(12);
            int H = d0Var.H();
            if ("audio/raw".equals(format.H3)) {
                int W = o0.W(format.W3, format.U3);
                if (H == 0 || H % W != 0) {
                    StringBuilder sb = new StringBuilder(88);
                    sb.append("Audio sample size mismatch. stsd sample size: ");
                    sb.append(W);
                    sb.append(", stsz sample size: ");
                    sb.append(H);
                    u.h("AtomParsers", sb.toString());
                    H = W;
                }
            }
            this.a = H == 0 ? -1 : H;
            this.f2777b = d0Var.H();
        }

        @Override // com.google.android.exoplayer2.o2.j0.f.b
        public int a() {
            int i = this.a;
            return i == -1 ? this.f2778c.H() : i;
        }

        @Override // com.google.android.exoplayer2.o2.j0.f.b
        public int b() {
            return this.a;
        }

        @Override // com.google.android.exoplayer2.o2.j0.f.b
        public int c() {
            return this.f2777b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtomParsers.java */
    /* loaded from: classes.dex */
    public static final class e implements b {
        private final d0 a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2779b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2780c;

        /* renamed from: d  reason: collision with root package name */
        private int f2781d;

        /* renamed from: e  reason: collision with root package name */
        private int f2782e;

        public e(e.b bVar) {
            d0 d0Var = bVar.f2768b;
            this.a = d0Var;
            d0Var.P(12);
            this.f2780c = d0Var.H() & 255;
            this.f2779b = d0Var.H();
        }

        @Override // com.google.android.exoplayer2.o2.j0.f.b
        public int a() {
            int i = this.f2780c;
            if (i == 8) {
                return this.a.D();
            }
            if (i == 16) {
                return this.a.J();
            }
            int i2 = this.f2781d;
            this.f2781d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.f2782e & 15;
            }
            int D = this.a.D();
            this.f2782e = D;
            return (D & 240) >> 4;
        }

        @Override // com.google.android.exoplayer2.o2.j0.f.b
        public int b() {
            return -1;
        }

        @Override // com.google.android.exoplayer2.o2.j0.f.b
        public int c() {
            return this.f2779b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AtomParsers.java */
    /* renamed from: com.google.android.exoplayer2.o2.j0.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0079f {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final long f2783b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2784c;

        public C0079f(int i, long j, int i2) {
            this.a = i;
            this.f2783b = j;
            this.f2784c = i2;
        }
    }

    public static Pair<Metadata, Metadata> A(e.b bVar) {
        d0 d0Var = bVar.f2768b;
        d0Var.P(8);
        Metadata metadata = null;
        Metadata metadata2 = null;
        while (d0Var.a() >= 8) {
            int e2 = d0Var.e();
            int n = d0Var.n();
            int n2 = d0Var.n();
            if (n2 == 1835365473) {
                d0Var.P(e2);
                metadata = B(d0Var, e2 + n);
            } else if (n2 == 1936553057) {
                d0Var.P(e2);
                metadata2 = t(d0Var, e2 + n);
            }
            d0Var.P(e2 + n);
        }
        return Pair.create(metadata, metadata2);
    }

    @Nullable
    private static Metadata B(d0 d0Var, int i) {
        d0Var.Q(8);
        d(d0Var);
        while (d0Var.e() < i) {
            int e2 = d0Var.e();
            int n = d0Var.n();
            if (d0Var.n() == 1768715124) {
                d0Var.P(e2);
                return k(d0Var, e2 + n);
            }
            d0Var.P(e2 + n);
        }
        return null;
    }

    private static void C(d0 d0Var, int i, int i2, int i3, int i4, int i5, @Nullable DrmInitData drmInitData, c cVar, int i6) throws ParserException {
        d0 d0Var2 = d0Var;
        int i7 = i2;
        int i8 = i3;
        DrmInitData drmInitData2 = drmInitData;
        d0Var2.P(i7 + 8 + 8);
        d0Var2.Q(16);
        int J = d0Var.J();
        int J2 = d0Var.J();
        d0Var2.Q(50);
        int e2 = d0Var.e();
        int i9 = i;
        if (i9 == 1701733238) {
            Pair<Integer, p> r = r(d0Var2, i7, i8);
            if (r != null) {
                i9 = ((Integer) r.first).intValue();
                drmInitData2 = drmInitData2 == null ? null : drmInitData2.c(((p) r.second).f2825b);
                cVar.a[i6] = (p) r.second;
            }
            d0Var2.P(e2);
        }
        String str = "video/3gpp";
        String str2 = i9 == 1831958048 ? "video/mpeg" : i9 == 1211250227 ? str : null;
        int i10 = -1;
        float f2 = 1.0f;
        String str3 = null;
        List<byte[]> list = null;
        byte[] bArr = null;
        ColorInfo colorInfo = null;
        boolean z = false;
        while (true) {
            if (e2 - i7 >= i8) {
                drmInitData2 = drmInitData2;
                break;
            }
            d0Var2.P(e2);
            int e3 = d0Var.e();
            int n = d0Var.n();
            if (n == 0) {
                drmInitData2 = drmInitData2;
                if (d0Var.e() - i7 == i8) {
                    break;
                }
            } else {
                drmInitData2 = drmInitData2;
            }
            m.a(n > 0, "childAtomSize must be positive");
            int n2 = d0Var.n();
            if (n2 == 1635148611) {
                m.a(str2 == null, null);
                d0Var2.P(e3 + 8);
                com.google.android.exoplayer2.video.m b2 = com.google.android.exoplayer2.video.m.b(d0Var);
                list = b2.a;
                cVar.f2775c = b2.f4005b;
                if (!z) {
                    f2 = b2.f4008e;
                }
                str3 = b2.f4009f;
                str2 = "video/avc";
            } else if (n2 == 1752589123) {
                m.a(str2 == null, null);
                d0Var2.P(e3 + 8);
                p a2 = p.a(d0Var);
                list = a2.a;
                cVar.f2775c = a2.f4022b;
                str3 = a2.f4023c;
                str2 = "video/hevc";
            } else {
                if (n2 == 1685480259 || n2 == 1685485123) {
                    n a3 = n.a(d0Var);
                    if (a3 != null) {
                        str3 = a3.f4011c;
                        str2 = "video/dolby-vision";
                    }
                } else if (n2 == 1987076931) {
                    m.a(str2 == null, null);
                    str2 = i9 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else if (n2 == 1635135811) {
                    m.a(str2 == null, null);
                    str2 = "video/av01";
                } else if (n2 == 1681012275) {
                    m.a(str2 == null, null);
                    str2 = str;
                } else if (n2 == 1702061171) {
                    m.a(str2 == null, null);
                    Pair<String, byte[]> h = h(d0Var2, e3);
                    str2 = (String) h.first;
                    byte[] bArr2 = (byte[]) h.second;
                    if (bArr2 != null) {
                        list = ImmutableList.of(bArr2);
                    }
                } else if (n2 == 1885434736) {
                    f2 = p(d0Var2, e3);
                    z = true;
                } else if (n2 == 1937126244) {
                    bArr = q(d0Var2, e3, n);
                } else if (n2 == 1936995172) {
                    int D = d0Var.D();
                    d0Var2.Q(3);
                    if (D == 0) {
                        int D2 = d0Var.D();
                        if (D2 == 0) {
                            i10 = 0;
                        } else if (D2 == 1) {
                            i10 = 1;
                        } else if (D2 == 2) {
                            i10 = 2;
                        } else if (D2 == 3) {
                            i10 = 3;
                        }
                    }
                } else if (n2 == 1668246642) {
                    int n3 = d0Var.n();
                    boolean z2 = n3 == 1852009592;
                    if (z2 || n3 == 1852009571) {
                        int J3 = d0Var.J();
                        int J4 = d0Var.J();
                        d0Var2.Q(2);
                        colorInfo = new ColorInfo(ColorInfo.a(J3), z2 && (d0Var.D() & 128) != 0 ? 1 : 2, ColorInfo.b(J4), null);
                    } else {
                        String valueOf = String.valueOf(e.a(n3));
                        u.h("AtomParsers", valueOf.length() != 0 ? "Unsupported color type: ".concat(valueOf) : new String("Unsupported color type: "));
                    }
                }
                e2 += n;
                d0Var2 = d0Var;
                i7 = i2;
                i8 = i3;
                str = str;
            }
            e2 += n;
            d0Var2 = d0Var;
            i7 = i2;
            i8 = i3;
            str = str;
        }
        if (str2 != null) {
            cVar.f2774b = new Format.b().R(i4).e0(str2).I(str3).j0(J).Q(J2).a0(f2).d0(i5).b0(bArr).h0(i10).T(list).L(drmInitData2).J(colorInfo).E();
        }
    }

    private static boolean a(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[o0.p(4, 0, length)] && jArr[o0.p(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private static int b(d0 d0Var, int i, int i2) throws ParserException {
        int e2 = d0Var.e();
        while (e2 - i < i2) {
            d0Var.P(e2);
            int n = d0Var.n();
            m.a(n > 0, "childAtomSize must be positive");
            if (d0Var.n() == 1702061171) {
                return e2;
            }
            e2 += n;
        }
        return -1;
    }

    private static int c(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static void d(d0 d0Var) {
        int e2 = d0Var.e();
        d0Var.Q(4);
        if (d0Var.n() != 1751411826) {
            e2 += 4;
        }
        d0Var.P(e2);
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(com.google.android.exoplayer2.util.d0 r20, int r21, int r22, int r23, int r24, java.lang.String r25, boolean r26, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData r27, com.google.android.exoplayer2.o2.j0.f.c r28, int r29) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 767
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.o2.j0.f.e(com.google.android.exoplayer2.util.d0, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.o2.j0.f$c, int):void");
    }

    @Nullable
    static Pair<Integer, p> f(d0 d0Var, int i, int i2) throws ParserException {
        int i3 = i + 8;
        boolean z = false;
        String str = null;
        Integer num = null;
        int i4 = -1;
        int i5 = 0;
        while (i3 - i < i2) {
            d0Var.P(i3);
            int n = d0Var.n();
            int n2 = d0Var.n();
            if (n2 == 1718775137) {
                num = Integer.valueOf(d0Var.n());
            } else if (n2 == 1935894637) {
                d0Var.Q(4);
                str = d0Var.A(4);
            } else if (n2 == 1935894633) {
                i4 = i3;
                i5 = n;
            }
            i3 += n;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        m.a(num != null, "frma atom is mandatory");
        m.a(i4 != -1, "schi atom is mandatory");
        p s = s(d0Var, i4, i5, str);
        if (s != null) {
            z = true;
        }
        m.a(z, "tenc atom is mandatory");
        return Pair.create(num, (p) o0.i(s));
    }

    @Nullable
    private static Pair<long[], long[]> g(e.a aVar) {
        e.b g = aVar.g(1701606260);
        if (g == null) {
            return null;
        }
        d0 d0Var = g.f2768b;
        d0Var.P(8);
        int c2 = e.c(d0Var.n());
        int H = d0Var.H();
        long[] jArr = new long[H];
        long[] jArr2 = new long[H];
        for (int i = 0; i < H; i++) {
            jArr[i] = c2 == 1 ? d0Var.I() : d0Var.F();
            jArr2[i] = c2 == 1 ? d0Var.w() : d0Var.n();
            if (d0Var.z() == 1) {
                d0Var.Q(2);
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair<String, byte[]> h(d0 d0Var, int i) {
        d0Var.P(i + 8 + 4);
        d0Var.Q(1);
        i(d0Var);
        d0Var.Q(2);
        int D = d0Var.D();
        if ((D & 128) != 0) {
            d0Var.Q(2);
        }
        if ((D & 64) != 0) {
            d0Var.Q(d0Var.J());
        }
        if ((D & 32) != 0) {
            d0Var.Q(2);
        }
        d0Var.Q(1);
        i(d0Var);
        String h = y.h(d0Var.D());
        if ("audio/mpeg".equals(h) || "audio/vnd.dts".equals(h) || "audio/vnd.dts.hd".equals(h)) {
            return Pair.create(h, null);
        }
        d0Var.Q(12);
        d0Var.Q(1);
        int i2 = i(d0Var);
        byte[] bArr = new byte[i2];
        d0Var.j(bArr, 0, i2);
        return Pair.create(h, bArr);
    }

    private static int i(d0 d0Var) {
        int D = d0Var.D();
        int i = D & 127;
        while ((D & 128) == 128) {
            D = d0Var.D();
            i = (i << 7) | (D & 127);
        }
        return i;
    }

    private static int j(d0 d0Var) {
        d0Var.P(16);
        return d0Var.n();
    }

    @Nullable
    private static Metadata k(d0 d0Var, int i) {
        d0Var.Q(8);
        ArrayList arrayList = new ArrayList();
        while (d0Var.e() < i) {
            Metadata.Entry c2 = j.c(d0Var);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Pair<Long, String> l(d0 d0Var) {
        int i = 8;
        d0Var.P(8);
        int c2 = e.c(d0Var.n());
        d0Var.Q(c2 == 0 ? 8 : 16);
        long F = d0Var.F();
        if (c2 == 0) {
            i = 4;
        }
        d0Var.Q(i);
        int J = d0Var.J();
        StringBuilder sb = new StringBuilder(3);
        sb.append((char) (((J >> 10) & 31) + 96));
        sb.append((char) (((J >> 5) & 31) + 96));
        sb.append((char) ((J & 31) + 96));
        return Pair.create(Long.valueOf(F), sb.toString());
    }

    @Nullable
    public static Metadata m(e.a aVar) {
        e.b g = aVar.g(1751411826);
        e.b g2 = aVar.g(1801812339);
        e.b g3 = aVar.g(1768715124);
        if (g == null || g2 == null || g3 == null || j(g.f2768b) != 1835299937) {
            return null;
        }
        d0 d0Var = g2.f2768b;
        d0Var.P(12);
        int n = d0Var.n();
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            int n2 = d0Var.n();
            d0Var.Q(4);
            strArr[i] = d0Var.A(n2 - 8);
        }
        d0 d0Var2 = g3.f2768b;
        d0Var2.P(8);
        ArrayList arrayList = new ArrayList();
        while (d0Var2.a() > 8) {
            int e2 = d0Var2.e();
            int n3 = d0Var2.n();
            int n4 = d0Var2.n() - 1;
            if (n4 < 0 || n4 >= n) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Skipped metadata with unknown key index: ");
                sb.append(n4);
                u.h("AtomParsers", sb.toString());
            } else {
                MdtaMetadataEntry f2 = j.f(d0Var2, e2 + n3, strArr[n4]);
                if (f2 != null) {
                    arrayList.add(f2);
                }
            }
            d0Var2.P(e2 + n3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static void n(d0 d0Var, int i, int i2, int i3, c cVar) {
        d0Var.P(i2 + 8 + 8);
        if (i == 1835365492) {
            d0Var.x();
            String x = d0Var.x();
            if (x != null) {
                cVar.f2774b = new Format.b().R(i3).e0(x).E();
            }
        }
    }

    private static long o(d0 d0Var) {
        int i = 8;
        d0Var.P(8);
        if (e.c(d0Var.n()) != 0) {
            i = 16;
        }
        d0Var.Q(i);
        return d0Var.F();
    }

    private static float p(d0 d0Var, int i) {
        d0Var.P(i + 8);
        return d0Var.H() / d0Var.H();
    }

    @Nullable
    private static byte[] q(d0 d0Var, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            d0Var.P(i3);
            int n = d0Var.n();
            if (d0Var.n() == 1886547818) {
                return Arrays.copyOfRange(d0Var.d(), i3, n + i3);
            }
            i3 += n;
        }
        return null;
    }

    @Nullable
    private static Pair<Integer, p> r(d0 d0Var, int i, int i2) throws ParserException {
        Pair<Integer, p> f2;
        int e2 = d0Var.e();
        while (e2 - i < i2) {
            d0Var.P(e2);
            int n = d0Var.n();
            m.a(n > 0, "childAtomSize must be positive");
            if (d0Var.n() == 1936289382 && (f2 = f(d0Var, e2, n)) != null) {
                return f2;
            }
            e2 += n;
        }
        return null;
    }

    @Nullable
    private static p s(d0 d0Var, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            d0Var.P(i5);
            int n = d0Var.n();
            if (d0Var.n() == 1952804451) {
                int c2 = e.c(d0Var.n());
                d0Var.Q(1);
                if (c2 == 0) {
                    d0Var.Q(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int D = d0Var.D();
                    i4 = (D & 240) >> 4;
                    i3 = D & 15;
                }
                boolean z = d0Var.D() == 1;
                int D2 = d0Var.D();
                byte[] bArr2 = new byte[16];
                d0Var.j(bArr2, 0, 16);
                if (z && D2 == 0) {
                    int D3 = d0Var.D();
                    bArr = new byte[D3];
                    d0Var.j(bArr, 0, D3);
                }
                return new p(z, str, D2, bArr2, i4, i3, bArr);
            }
            i5 += n;
        }
    }

    @Nullable
    private static Metadata t(d0 d0Var, int i) {
        d0Var.Q(12);
        while (d0Var.e() < i) {
            int e2 = d0Var.e();
            int n = d0Var.n();
            if (d0Var.n() != 1935766900) {
                d0Var.P(e2 + n);
            } else if (n < 14) {
                return null;
            } else {
                d0Var.Q(5);
                int D = d0Var.D();
                if (D != 12 && D != 13) {
                    return null;
                }
                float f2 = D == 12 ? 240.0f : 120.0f;
                d0Var.Q(1);
                return new Metadata(new SmtaMetadataEntry(f2, d0Var.D()));
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x043c A[EDGE_INSN: B:216:0x043c->B:169:0x043c ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.exoplayer2.o2.j0.r u(com.google.android.exoplayer2.o2.j0.o r37, com.google.android.exoplayer2.o2.j0.e.a r38, com.google.android.exoplayer2.o2.u r39) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 1318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.o2.j0.f.u(com.google.android.exoplayer2.o2.j0.o, com.google.android.exoplayer2.o2.j0.e$a, com.google.android.exoplayer2.o2.u):com.google.android.exoplayer2.o2.j0.r");
    }

    private static c v(d0 d0Var, int i, int i2, String str, @Nullable DrmInitData drmInitData, boolean z) throws ParserException {
        int i3;
        d0Var.P(12);
        int n = d0Var.n();
        c cVar = new c(n);
        for (int i4 = 0; i4 < n; i4++) {
            int e2 = d0Var.e();
            int n2 = d0Var.n();
            m.a(n2 > 0, "childAtomSize must be positive");
            int n3 = d0Var.n();
            if (n3 == 1635148593 || n3 == 1635148595 || n3 == 1701733238 || n3 == 1831958048 || n3 == 1836070006 || n3 == 1752589105 || n3 == 1751479857 || n3 == 1932670515 || n3 == 1211250227 || n3 == 1987063864 || n3 == 1987063865 || n3 == 1635135537 || n3 == 1685479798 || n3 == 1685479729 || n3 == 1685481573 || n3 == 1685481521) {
                i3 = e2;
                C(d0Var, n3, i3, n2, i, i2, drmInitData, cVar, i4);
            } else if (n3 == 1836069985 || n3 == 1701733217 || n3 == 1633889587 || n3 == 1700998451 || n3 == 1633889588 || n3 == 1685353315 || n3 == 1685353317 || n3 == 1685353320 || n3 == 1685353324 || n3 == 1685353336 || n3 == 1935764850 || n3 == 1935767394 || n3 == 1819304813 || n3 == 1936684916 || n3 == 1953984371 || n3 == 778924082 || n3 == 778924083 || n3 == 1835557169 || n3 == 1835560241 || n3 == 1634492771 || n3 == 1634492791 || n3 == 1970037111 || n3 == 1332770163 || n3 == 1716281667) {
                i3 = e2;
                e(d0Var, n3, e2, n2, i, str, z, drmInitData, cVar, i4);
            } else {
                if (n3 == 1414810956 || n3 == 1954034535 || n3 == 2004251764 || n3 == 1937010800 || n3 == 1664495672) {
                    w(d0Var, n3, e2, n2, i, str, cVar);
                } else if (n3 == 1835365492) {
                    n(d0Var, n3, e2, i, cVar);
                } else if (n3 == 1667329389) {
                    cVar.f2774b = new Format.b().R(i).e0("application/x-camera-motion").E();
                }
                i3 = e2;
            }
            d0Var.P(i3 + n2);
        }
        return cVar;
    }

    private static void w(d0 d0Var, int i, int i2, int i3, int i4, String str, c cVar) {
        d0Var.P(i2 + 8 + 8);
        String str2 = "application/ttml+xml";
        ImmutableList immutableList = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = (i3 - 8) - 8;
                byte[] bArr = new byte[i5];
                d0Var.j(bArr, 0, i5);
                immutableList = ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                cVar.f2776d = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        cVar.f2774b = new Format.b().R(i4).e0(str2).V(str).i0(j).T(immutableList).E();
    }

    private static C0079f x(d0 d0Var) {
        boolean z;
        int i = 8;
        d0Var.P(8);
        int c2 = e.c(d0Var.n());
        d0Var.Q(c2 == 0 ? 8 : 16);
        int n = d0Var.n();
        d0Var.Q(4);
        int e2 = d0Var.e();
        if (c2 == 0) {
            i = 4;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            } else if (d0Var.d()[e2 + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        long j = -9223372036854775807L;
        if (z) {
            d0Var.Q(i);
        } else {
            long F = c2 == 0 ? d0Var.F() : d0Var.I();
            if (F != 0) {
                j = F;
            }
        }
        d0Var.Q(16);
        int n2 = d0Var.n();
        int n3 = d0Var.n();
        d0Var.Q(4);
        int n4 = d0Var.n();
        int n5 = d0Var.n();
        if (n2 == 0 && n3 == 65536 && n4 == -65536 && n5 == 0) {
            i2 = 90;
        } else if (n2 == 0 && n3 == -65536 && n4 == 65536 && n5 == 0) {
            i2 = 270;
        } else if (n2 == -65536 && n3 == 0 && n4 == 0 && n5 == -65536) {
            i2 = 180;
        }
        return new C0079f(n, j, i2);
    }

    @Nullable
    private static o y(e.a aVar, e.b bVar, long j, @Nullable DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long j2;
        e.b bVar2;
        long[] jArr;
        long[] jArr2;
        e.a f2;
        Pair<long[], long[]> g;
        e.a aVar2 = (e.a) g.e(aVar.f(1835297121));
        int c2 = c(j(((e.b) g.e(aVar2.g(1751411826))).f2768b));
        if (c2 == -1) {
            return null;
        }
        C0079f x = x(((e.b) g.e(aVar.g(1953196132))).f2768b);
        long j3 = -9223372036854775807L;
        if (j == -9223372036854775807L) {
            bVar2 = bVar;
            j2 = x.f2783b;
        } else {
            bVar2 = bVar;
            j2 = j;
        }
        long o = o(bVar2.f2768b);
        if (j2 != -9223372036854775807L) {
            j3 = o0.C0(j2, 1000000L, o);
        }
        Pair<Long, String> l = l(((e.b) g.e(aVar2.g(1835296868))).f2768b);
        c v = v(((e.b) g.e(((e.a) g.e(((e.a) g.e(aVar2.f(1835626086))).f(1937007212))).g(1937011556))).f2768b, x.a, x.f2784c, (String) l.second, drmInitData, z2);
        if (z || (f2 = aVar.f(1701082227)) == null || (g = g(f2)) == null) {
            jArr2 = null;
            jArr = null;
        } else {
            jArr2 = (long[]) g.first;
            jArr = (long[]) g.second;
        }
        if (v.f2774b == null) {
            return null;
        }
        return new o(x.a, c2, ((Long) l.first).longValue(), o, j3, v.f2774b, v.f2776d, v.a, v.f2775c, jArr2, jArr);
    }

    public static List<r> z(e.a aVar, com.google.android.exoplayer2.o2.u uVar, long j, @Nullable DrmInitData drmInitData, boolean z, boolean z2, h<o, o> hVar) throws ParserException {
        o apply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aVar.f2767d.size(); i++) {
            e.a aVar2 = aVar.f2767d.get(i);
            if (aVar2.a == 1953653099 && (apply = hVar.apply(y(aVar2, (e.b) g.e(aVar.g(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(u(apply, (e.a) g.e(((e.a) g.e(((e.a) g.e(aVar2.f(1835297121))).f(1835626086))).f(1937007212)), uVar));
            }
        }
        return arrayList;
    }
}
