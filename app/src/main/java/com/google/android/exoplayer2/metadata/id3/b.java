package com.google.android.exoplayer2.metadata.id3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.g;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.common.base.c;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: Id3Decoder.java */
/* loaded from: classes.dex */
public final class b extends g {
    public static final a a = a.a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final a f2579b;

    /* compiled from: Id3Decoder.java */
    /* loaded from: classes.dex */
    public interface a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Id3Decoder.java */
    /* renamed from: com.google.android.exoplayer2.metadata.id3.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0076b {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2580b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2581c;

        public C0076b(int i, boolean z, int i2) {
            this.a = i;
            this.f2580b = z;
            this.f2581c = i2;
        }
    }

    public b() {
        this(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        if ((r10 & 1) != 0) goto L_0x008b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:
        if ((r10 & 128) != 0) goto L_0x008b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean A(com.google.android.exoplayer2.util.d0 r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.e()
        L_0x0008:
            int r3 = r18.a()     // Catch: all -> 0x00af
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00ab
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r18.n()     // Catch: all -> 0x00af
            long r8 = r18.F()     // Catch: all -> 0x00af
            int r10 = r18.J()     // Catch: all -> 0x00af
            goto L_0x002c
        L_0x0022:
            int r7 = r18.G()     // Catch: all -> 0x00af
            int r8 = r18.G()     // Catch: all -> 0x00af
            long r8 = (long) r8
            r10 = 0
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x003a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003a
            if (r10 != 0) goto L_0x003a
            r1.P(r2)
            return r4
        L_0x003a:
            r7 = 4
            if (r0 != r7) goto L_0x006b
            if (r21 != 0) goto L_0x006b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x004b
            r1.P(r2)
            return r6
        L_0x004b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x006b:
            if (r0 != r7) goto L_0x007b
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0073
            r3 = 1
            goto L_0x0074
        L_0x0073:
            r3 = 0
        L_0x0074:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0079:
            r4 = 0
            goto L_0x008b
        L_0x007b:
            if (r0 != r3) goto L_0x0089
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0083
            r3 = 1
            goto L_0x0084
        L_0x0083:
            r3 = 0
        L_0x0084:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0089:
            r3 = 0
            goto L_0x0079
        L_0x008b:
            if (r4 == 0) goto L_0x008f
            int r3 = r3 + 4
        L_0x008f:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0098
            r1.P(r2)
            return r6
        L_0x0098:
            int r3 = r18.a()     // Catch: all -> 0x00af
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a5
            r1.P(r2)
            return r6
        L_0x00a5:
            int r3 = (int) r8
            r1.Q(r3)     // Catch: all -> 0x00af
            goto L_0x0008
        L_0x00ab:
            r1.P(r2)
            return r4
        L_0x00af:
            r0 = move-exception
            r1.P(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.b.A(com.google.android.exoplayer2.util.d0, int, int, boolean):boolean");
    }

    private static byte[] c(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return o0.f3937f;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    private static ApicFrame e(d0 d0Var, int i, int i2) throws UnsupportedEncodingException {
        int i3;
        String str;
        int D = d0Var.D();
        String u = u(D);
        int i4 = i - 1;
        byte[] bArr = new byte[i4];
        d0Var.j(bArr, 0, i4);
        if (i2 == 2) {
            String valueOf = String.valueOf(c.e(new String(bArr, 0, 3, "ISO-8859-1")));
            str = valueOf.length() != 0 ? "image/".concat(valueOf) : new String("image/");
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            i3 = 2;
        } else {
            i3 = x(bArr, 0);
            str = c.e(new String(bArr, 0, i3, "ISO-8859-1"));
            if (str.indexOf(47) == -1) {
                if (str.length() != 0) {
                    str = "image/".concat(str);
                } else {
                    str = new String("image/");
                }
            }
        }
        int i5 = i3 + 2;
        int w = w(bArr, i5, D);
        return new ApicFrame(str, new String(bArr, i5, w - i5, u), bArr[i3 + 1] & 255, c(bArr, w + t(D), i4));
    }

    private static BinaryFrame f(d0 d0Var, int i, String str) {
        byte[] bArr = new byte[i];
        d0Var.j(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static ChapterFrame g(d0 d0Var, int i, int i2, boolean z, int i3, @Nullable a aVar) throws UnsupportedEncodingException {
        int e2 = d0Var.e();
        int x = x(d0Var.d(), e2);
        String str = new String(d0Var.d(), e2, x - e2, "ISO-8859-1");
        d0Var.P(x + 1);
        int n = d0Var.n();
        int n2 = d0Var.n();
        long F = d0Var.F();
        long j = F == 4294967295L ? -1L : F;
        long F2 = d0Var.F();
        long j2 = F2 == 4294967295L ? -1L : F2;
        ArrayList arrayList = new ArrayList();
        int i4 = e2 + i;
        while (d0Var.e() < i4) {
            Id3Frame j3 = j(i2, d0Var, z, i3, aVar);
            if (j3 != null) {
                arrayList.add(j3);
            }
        }
        return new ChapterFrame(str, n, n2, j, j2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static ChapterTocFrame h(d0 d0Var, int i, int i2, boolean z, int i3, @Nullable a aVar) throws UnsupportedEncodingException {
        int e2 = d0Var.e();
        int x = x(d0Var.d(), e2);
        String str = new String(d0Var.d(), e2, x - e2, "ISO-8859-1");
        d0Var.P(x + 1);
        int D = d0Var.D();
        boolean z2 = (D & 2) != 0;
        boolean z3 = (D & 1) != 0;
        int D2 = d0Var.D();
        String[] strArr = new String[D2];
        for (int i4 = 0; i4 < D2; i4++) {
            int e3 = d0Var.e();
            int x2 = x(d0Var.d(), e3);
            strArr[i4] = new String(d0Var.d(), e3, x2 - e3, "ISO-8859-1");
            d0Var.P(x2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = e2 + i;
        while (d0Var.e() < i5) {
            Id3Frame j = j(i2, d0Var, z, i3, aVar);
            if (j != null) {
                arrayList.add(j);
            }
        }
        return new ChapterTocFrame(str, z2, z3, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    private static CommentFrame i(d0 d0Var, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int D = d0Var.D();
        String u = u(D);
        byte[] bArr = new byte[3];
        d0Var.j(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        d0Var.j(bArr2, 0, i2);
        int w = w(bArr2, 0, D);
        String str2 = new String(bArr2, 0, w, u);
        int t = w + t(D);
        return new CommentFrame(str, str2, o(bArr2, t, w(bArr2, t, D), u));
    }

    /* JADX WARN: Code restructure failed: missing block: B:130:0x0190, code lost:
        if (r13 == 67) goto L_0x0192;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame j(int r19, com.google.android.exoplayer2.util.d0 r20, boolean r21, int r22, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.id3.b.a r23) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.b.j(int, com.google.android.exoplayer2.util.d0, boolean, int, com.google.android.exoplayer2.metadata.id3.b$a):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static GeobFrame k(d0 d0Var, int i) throws UnsupportedEncodingException {
        int D = d0Var.D();
        String u = u(D);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        d0Var.j(bArr, 0, i2);
        int x = x(bArr, 0);
        String str = new String(bArr, 0, x, "ISO-8859-1");
        int i3 = x + 1;
        int w = w(bArr, i3, D);
        String o = o(bArr, i3, w, u);
        int t = w + t(D);
        int w2 = w(bArr, t, D);
        return new GeobFrame(str, o, o(bArr, t, w2, u), c(bArr, w2 + t(D), i2));
    }

    @Nullable
    private static C0076b l(d0 d0Var) {
        if (d0Var.a() < 10) {
            u.h("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int G = d0Var.G();
        boolean z = false;
        if (G != 4801587) {
            String valueOf = String.valueOf(String.format("%06X", Integer.valueOf(G)));
            u.h("Id3Decoder", valueOf.length() != 0 ? "Unexpected first three bytes of ID3 tag header: 0x".concat(valueOf) : new String("Unexpected first three bytes of ID3 tag header: 0x"));
            return null;
        }
        int D = d0Var.D();
        d0Var.Q(1);
        int D2 = d0Var.D();
        int C = d0Var.C();
        if (D == 2) {
            if ((D2 & 64) != 0) {
                u.h("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (D == 3) {
            if ((D2 & 64) != 0) {
                int n = d0Var.n();
                d0Var.Q(n);
                C -= n + 4;
            }
        } else if (D == 4) {
            if ((D2 & 64) != 0) {
                int C2 = d0Var.C();
                d0Var.Q(C2 - 4);
                C -= C2;
            }
            if ((D2 & 16) != 0) {
                C -= 10;
            }
        } else {
            StringBuilder sb = new StringBuilder(57);
            sb.append("Skipped ID3 tag with unsupported majorVersion=");
            sb.append(D);
            u.h("Id3Decoder", sb.toString());
            return null;
        }
        if (D < 4 && (D2 & 128) != 0) {
            z = true;
        }
        return new C0076b(D, z, C);
    }

    private static MlltFrame m(d0 d0Var, int i) {
        int J = d0Var.J();
        int G = d0Var.G();
        int G2 = d0Var.G();
        int D = d0Var.D();
        int D2 = d0Var.D();
        c0 c0Var = new c0();
        c0Var.m(d0Var);
        int i2 = ((i - 10) * 8) / (D + D2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int h = c0Var.h(D);
            int h2 = c0Var.h(D2);
            iArr[i3] = h;
            iArr2[i3] = h2;
        }
        return new MlltFrame(J, G, G2, iArr, iArr2);
    }

    private static PrivFrame n(d0 d0Var, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        d0Var.j(bArr, 0, i);
        int x = x(bArr, 0);
        return new PrivFrame(new String(bArr, 0, x, "ISO-8859-1"), c(bArr, x + 1, i));
    }

    private static String o(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    @Nullable
    private static TextInformationFrame p(d0 d0Var, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int D = d0Var.D();
        String u = u(D);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        d0Var.j(bArr, 0, i2);
        return new TextInformationFrame(str, null, new String(bArr, 0, w(bArr, 0, D), u));
    }

    @Nullable
    private static TextInformationFrame q(d0 d0Var, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int D = d0Var.D();
        String u = u(D);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        d0Var.j(bArr, 0, i2);
        int w = w(bArr, 0, D);
        String str = new String(bArr, 0, w, u);
        int t = w + t(D);
        return new TextInformationFrame("TXXX", str, o(bArr, t, w(bArr, t, D), u));
    }

    private static UrlLinkFrame r(d0 d0Var, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        d0Var.j(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, x(bArr, 0), "ISO-8859-1"));
    }

    @Nullable
    private static UrlLinkFrame s(d0 d0Var, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int D = d0Var.D();
        String u = u(D);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        d0Var.j(bArr, 0, i2);
        int w = w(bArr, 0, D);
        String str = new String(bArr, 0, w, u);
        int t = w + t(D);
        return new UrlLinkFrame("WXXX", str, o(bArr, t, x(bArr, t), "ISO-8859-1"));
    }

    private static int t(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static String u(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    private static String v(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static int w(byte[] bArr, int i, int i2) {
        int x = x(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return x;
        }
        while (x < bArr.length - 1) {
            if (x % 2 == 0 && bArr[x + 1] == 0) {
                return x;
            }
            x = x(bArr, x + 1);
        }
        return bArr.length;
    }

    private static int x(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean y(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    private static int z(d0 d0Var, int i) {
        byte[] d2 = d0Var.d();
        int e2 = d0Var.e();
        int i2 = e2;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= e2 + i) {
                return i;
            }
            if ((d2[i2] & 255) == 255 && d2[i3] == 0) {
                System.arraycopy(d2, i2 + 2, d2, i3, (i - (i2 - e2)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    @Override // com.google.android.exoplayer2.metadata.g
    @Nullable
    protected Metadata b(d dVar, ByteBuffer byteBuffer) {
        return d(byteBuffer.array(), byteBuffer.limit());
    }

    @Nullable
    public Metadata d(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        d0 d0Var = new d0(bArr, i);
        C0076b l = l(d0Var);
        if (l == null) {
            return null;
        }
        int e2 = d0Var.e();
        int i2 = l.a == 2 ? 6 : 10;
        int i3 = l.f2581c;
        if (l.f2580b) {
            i3 = z(d0Var, l.f2581c);
        }
        d0Var.O(e2 + i3);
        boolean z = false;
        if (!A(d0Var, l.a, i2, false)) {
            if (l.a != 4 || !A(d0Var, 4, i2, true)) {
                int i4 = l.a;
                StringBuilder sb = new StringBuilder(56);
                sb.append("Failed to validate ID3 tag with majorVersion=");
                sb.append(i4);
                u.h("Id3Decoder", sb.toString());
                return null;
            }
            z = true;
        }
        while (d0Var.a() >= i2) {
            Id3Frame j = j(l.a, d0Var, z, i2, this.f2579b);
            if (j != null) {
                arrayList.add(j);
            }
        }
        return new Metadata(arrayList);
    }

    public b(@Nullable a aVar) {
        this.f2579b = aVar;
    }
}
