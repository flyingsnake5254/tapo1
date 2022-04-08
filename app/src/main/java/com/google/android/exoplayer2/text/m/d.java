package com.google.android.exoplayer2.text.m;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: Cea708Decoder.java */
/* loaded from: classes.dex */
public final class d extends e {
    private final d0 g = new d0();
    private final c0 h = new c0();
    private int i = -1;
    private final boolean j;
    private final int k;
    private final b[] l;
    private b m;
    @Nullable
    private List<com.google.android.exoplayer2.text.c> n;
    @Nullable
    private List<com.google.android.exoplayer2.text.c> o;
    @Nullable
    private c p;
    private int q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cea708Decoder.java */
    /* loaded from: classes.dex */
    public static final class a {
        private static final Comparator<a> a = a.f3450c;

        /* renamed from: b  reason: collision with root package name */
        public final com.google.android.exoplayer2.text.c f3458b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3459c;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f2, int i, int i2, float f3, int i3, float f4, boolean z, int i4, int i5) {
            c.b n = new c.b().o(charSequence).p(alignment).h(f2, i).i(i2).k(f3).l(i3).n(f4);
            if (z) {
                n.s(i4);
            }
            this.f3458b = n.a();
            this.f3459c = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cea708Decoder.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: b  reason: collision with root package name */
        public static final int f3460b;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3461c;
        private static final int[] h;
        private static final int[] k;
        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private final List<SpannableString> l = new ArrayList();
        private final SpannableStringBuilder m = new SpannableStringBuilder();
        private boolean n;
        private boolean o;
        private int p;
        private boolean q;
        private int r;
        private int s;
        private int t;
        private int u;
        private boolean v;
        private int w;
        private int x;
        private int y;
        private int z;
        public static final int a = h(2, 2, 2, 0);

        /* renamed from: d  reason: collision with root package name */
        private static final int[] f3462d = {0, 0, 0, 0, 0, 2, 0};

        /* renamed from: e  reason: collision with root package name */
        private static final int[] f3463e = {0, 0, 0, 0, 0, 0, 2};

        /* renamed from: f  reason: collision with root package name */
        private static final int[] f3464f = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] g = {false, false, false, true, true, true, false};
        private static final int[] i = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] j = {0, 0, 0, 0, 0, 3, 3};

        static {
            int h2 = h(0, 0, 0, 0);
            f3460b = h2;
            int h3 = h(0, 0, 0, 3);
            f3461c = h3;
            h = new int[]{h2, h3, h2, h2, h3, h2, h2};
            k = new int[]{h2, h2, h2, h2, h2, h3, h3};
        }

        public b() {
            l();
        }

        public static int g(int i2, int i3, int i4) {
            return h(i2, i3, i4, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int h(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                com.google.android.exoplayer2.util.g.c(r4, r0, r1)
                com.google.android.exoplayer2.util.g.c(r5, r0, r1)
                com.google.android.exoplayer2.util.g.c(r6, r0, r1)
                com.google.android.exoplayer2.util.g.c(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x0021
                if (r7 == r1) goto L_0x0021
                r3 = 2
                if (r7 == r3) goto L_0x001e
                r3 = 3
                if (r7 == r3) goto L_0x001c
                goto L_0x0021
            L_0x001c:
                r7 = 0
                goto L_0x0023
            L_0x001e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L_0x0023
            L_0x0021:
                r7 = 255(0xff, float:3.57E-43)
            L_0x0023:
                if (r4 <= r1) goto L_0x0028
                r4 = 255(0xff, float:3.57E-43)
                goto L_0x0029
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r5 <= r1) goto L_0x002e
                r5 = 255(0xff, float:3.57E-43)
                goto L_0x002f
            L_0x002e:
                r5 = 0
            L_0x002f:
                if (r6 <= r1) goto L_0x0033
                r0 = 255(0xff, float:3.57E-43)
            L_0x0033:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.m.d.b.h(int, int, int, int):int");
        }

        public void a(char c2) {
            if (c2 == '\n') {
                this.l.add(d());
                this.m.clear();
                if (this.A != -1) {
                    this.A = 0;
                }
                if (this.B != -1) {
                    this.B = 0;
                }
                if (this.C != -1) {
                    this.C = 0;
                }
                if (this.E != -1) {
                    this.E = 0;
                }
                while (true) {
                    if ((this.v && this.l.size() >= this.u) || this.l.size() >= 15) {
                        this.l.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.m.append(c2);
            }
        }

        public void b() {
            int length = this.m.length();
            if (length > 0) {
                this.m.delete(length - 1, length);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ae  */
        @androidx.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.android.exoplayer2.text.m.d.a c() {
            /*
                Method dump skipped, instructions count: 199
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.m.d.b.c():com.google.android.exoplayer2.text.m.d$a");
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.m);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.A != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.A, length, 33);
                }
                if (this.B != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.B, length, 33);
                }
                if (this.C != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.D), this.C, length, 33);
                }
                if (this.E != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.F), this.E, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.l.clear();
            this.m.clear();
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.E = -1;
            this.G = 0;
        }

        public void f(boolean z, boolean z2, boolean z3, int i2, boolean z4, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.n = true;
            this.o = z;
            this.v = z2;
            this.p = i2;
            this.q = z4;
            this.r = i3;
            this.s = i4;
            this.t = i7;
            int i10 = i5 + 1;
            if (this.u != i10) {
                this.u = i10;
                while (true) {
                    if ((!z2 || this.l.size() < this.u) && this.l.size() < 15) {
                        break;
                    }
                    this.l.remove(0);
                }
            }
            if (!(i8 == 0 || this.x == i8)) {
                this.x = i8;
                int i11 = i8 - 1;
                q(h[i11], f3461c, g[i11], 0, f3463e[i11], f3464f[i11], f3462d[i11]);
            }
            if (i9 != 0 && this.y != i9) {
                this.y = i9;
                int i12 = i9 - 1;
                m(0, 1, 1, false, false, j[i12], i[i12]);
                n(a, k[i12], f3460b);
            }
        }

        public boolean i() {
            return this.n;
        }

        public boolean j() {
            return !i() || (this.l.isEmpty() && this.m.length() == 0);
        }

        public boolean k() {
            return this.o;
        }

        public void l() {
            e();
            this.n = false;
            this.o = false;
            this.p = 4;
            this.q = false;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = 15;
            this.v = true;
            this.w = 0;
            this.x = 0;
            this.y = 0;
            int i2 = f3460b;
            this.z = i2;
            this.D = a;
            this.F = i2;
        }

        public void m(int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6) {
            if (this.A != -1) {
                if (!z) {
                    this.m.setSpan(new StyleSpan(2), this.A, this.m.length(), 33);
                    this.A = -1;
                }
            } else if (z) {
                this.A = this.m.length();
            }
            if (this.B != -1) {
                if (!z2) {
                    this.m.setSpan(new UnderlineSpan(), this.B, this.m.length(), 33);
                    this.B = -1;
                }
            } else if (z2) {
                this.B = this.m.length();
            }
        }

        public void n(int i2, int i3, int i4) {
            if (!(this.C == -1 || this.D == i2)) {
                this.m.setSpan(new ForegroundColorSpan(this.D), this.C, this.m.length(), 33);
            }
            if (i2 != a) {
                this.C = this.m.length();
                this.D = i2;
            }
            if (!(this.E == -1 || this.F == i3)) {
                this.m.setSpan(new BackgroundColorSpan(this.F), this.E, this.m.length(), 33);
            }
            if (i3 != f3460b) {
                this.E = this.m.length();
                this.F = i3;
            }
        }

        public void o(int i2, int i3) {
            if (this.G != i2) {
                a('\n');
            }
            this.G = i2;
        }

        public void p(boolean z) {
            this.o = z;
        }

        public void q(int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
            this.z = i2;
            this.w = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cea708Decoder.java */
    /* loaded from: classes.dex */
    public static final class c {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3465b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f3466c;

        /* renamed from: d  reason: collision with root package name */
        int f3467d = 0;

        public c(int i, int i2) {
            this.a = i;
            this.f3465b = i2;
            this.f3466c = new byte[(i2 * 2) - 1];
        }
    }

    public d(int i, @Nullable List<byte[]> list) {
        boolean z = true;
        this.k = i == -1 ? 1 : i;
        this.j = (list == null || !i.f(list)) ? false : z;
        this.l = new b[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.l[i2] = new b();
        }
        this.m = this.l[0];
    }

    private void A() {
        int h = b.h(this.h.h(2), this.h.h(2), this.h.h(2), this.h.h(2));
        int h2 = b.h(this.h.h(2), this.h.h(2), this.h.h(2), this.h.h(2));
        this.h.r(2);
        this.m.n(h, h2, b.g(this.h.h(2), this.h.h(2), this.h.h(2)));
    }

    private void B() {
        this.h.r(4);
        int h = this.h.h(4);
        this.h.r(2);
        this.m.o(h, this.h.h(6));
    }

    private void C() {
        int h = b.h(this.h.h(2), this.h.h(2), this.h.h(2), this.h.h(2));
        int h2 = this.h.h(2);
        int g = b.g(this.h.h(2), this.h.h(2), this.h.h(2));
        if (this.h.g()) {
            h2 |= 4;
        }
        boolean g2 = this.h.g();
        int h3 = this.h.h(2);
        int h4 = this.h.h(2);
        int h5 = this.h.h(2);
        this.h.r(8);
        this.m.q(h, g, g2, h2, h3, h4, h5);
    }

    @RequiresNonNull({"currentDtvCcPacket"})
    private void D() {
        c cVar = this.p;
        int i = cVar.f3467d;
        int i2 = cVar.f3465b;
        if (i != (i2 * 2) - 1) {
            int i3 = cVar.a;
            StringBuilder sb = new StringBuilder(115);
            sb.append("DtvCcPacket ended prematurely; size is ");
            sb.append((i2 * 2) - 1);
            sb.append(", but current index is ");
            sb.append(i);
            sb.append(" (sequence number ");
            sb.append(i3);
            sb.append(");");
            u.b("Cea708Decoder", sb.toString());
        }
        c0 c0Var = this.h;
        c cVar2 = this.p;
        c0Var.o(cVar2.f3466c, cVar2.f3467d);
        int h = this.h.h(3);
        int h2 = this.h.h(5);
        if (h == 7) {
            this.h.r(2);
            h = this.h.h(6);
            if (h < 7) {
                StringBuilder sb2 = new StringBuilder(44);
                sb2.append("Invalid extended service number: ");
                sb2.append(h);
                u.h("Cea708Decoder", sb2.toString());
            }
        }
        if (h2 == 0) {
            if (h != 0) {
                StringBuilder sb3 = new StringBuilder(59);
                sb3.append("serviceNumber is non-zero (");
                sb3.append(h);
                sb3.append(") when blockSize is 0");
                u.h("Cea708Decoder", sb3.toString());
            }
        } else if (h == this.k) {
            boolean z = false;
            while (this.h.b() > 0) {
                int h3 = this.h.h(8);
                if (h3 == 16) {
                    int h4 = this.h.h(8);
                    if (h4 <= 31) {
                        s(h4);
                    } else {
                        if (h4 <= 127) {
                            x(h4);
                        } else if (h4 <= 159) {
                            t(h4);
                        } else if (h4 <= 255) {
                            y(h4);
                        } else {
                            StringBuilder sb4 = new StringBuilder(37);
                            sb4.append("Invalid extended command: ");
                            sb4.append(h4);
                            u.h("Cea708Decoder", sb4.toString());
                        }
                        z = true;
                    }
                } else if (h3 <= 31) {
                    q(h3);
                } else {
                    if (h3 <= 127) {
                        v(h3);
                    } else if (h3 <= 159) {
                        r(h3);
                    } else if (h3 <= 255) {
                        w(h3);
                    } else {
                        StringBuilder sb5 = new StringBuilder(33);
                        sb5.append("Invalid base command: ");
                        sb5.append(h3);
                        u.h("Cea708Decoder", sb5.toString());
                    }
                    z = true;
                }
            }
            if (z) {
                this.n = p();
            }
        }
    }

    private void E() {
        for (int i = 0; i < 8; i++) {
            this.l[i].l();
        }
    }

    private void o() {
        if (this.p != null) {
            D();
            this.p = null;
        }
    }

    private List<com.google.android.exoplayer2.text.c> p() {
        a c2;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.l[i].j() && this.l[i].k() && (c2 = this.l[i].c()) != null) {
                arrayList.add(c2);
            }
        }
        Collections.sort(arrayList, a.a);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(((a) arrayList.get(i2)).f3458b);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void q(int i) {
        if (i == 0) {
            return;
        }
        if (i == 3) {
            this.n = p();
        } else if (i != 8) {
            switch (i) {
                case 12:
                    E();
                    return;
                case 13:
                    this.m.a('\n');
                    return;
                case 14:
                    return;
                default:
                    if (i >= 17 && i <= 23) {
                        StringBuilder sb = new StringBuilder(55);
                        sb.append("Currently unsupported COMMAND_EXT1 Command: ");
                        sb.append(i);
                        u.h("Cea708Decoder", sb.toString());
                        this.h.r(8);
                        return;
                    } else if (i < 24 || i > 31) {
                        StringBuilder sb2 = new StringBuilder(31);
                        sb2.append("Invalid C0 command: ");
                        sb2.append(i);
                        u.h("Cea708Decoder", sb2.toString());
                        return;
                    } else {
                        StringBuilder sb3 = new StringBuilder(54);
                        sb3.append("Currently unsupported COMMAND_P16 Command: ");
                        sb3.append(i);
                        u.h("Cea708Decoder", sb3.toString());
                        this.h.r(16);
                        return;
                    }
            }
        } else {
            this.m.b();
        }
    }

    private void r(int i) {
        b bVar;
        int i2 = 1;
        switch (i) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i3 = i - 128;
                if (this.q != i3) {
                    this.q = i3;
                    this.m = this.l[i3];
                    return;
                }
                return;
            case 136:
                while (i2 <= 8) {
                    if (this.h.g()) {
                        this.l[8 - i2].e();
                    }
                    i2++;
                }
                return;
            case 137:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.h.g()) {
                        this.l[8 - i4].p(true);
                    }
                }
                return;
            case 138:
                while (i2 <= 8) {
                    if (this.h.g()) {
                        this.l[8 - i2].p(false);
                    }
                    i2++;
                }
                return;
            case 139:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.h.g()) {
                        this.l[8 - i5].p(!bVar.k());
                    }
                }
                return;
            case 140:
                while (i2 <= 8) {
                    if (this.h.g()) {
                        this.l[8 - i2].l();
                    }
                    i2++;
                }
                return;
            case 141:
                this.h.r(8);
                return;
            case 142:
                return;
            case 143:
                E();
                return;
            case 144:
                if (!this.m.i()) {
                    this.h.r(16);
                    return;
                } else {
                    z();
                    return;
                }
            case 145:
                if (!this.m.i()) {
                    this.h.r(24);
                    return;
                } else {
                    A();
                    return;
                }
            case 146:
                if (!this.m.i()) {
                    this.h.r(16);
                    return;
                } else {
                    B();
                    return;
                }
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                StringBuilder sb = new StringBuilder(31);
                sb.append("Invalid C1 command: ");
                sb.append(i);
                u.h("Cea708Decoder", sb.toString());
                return;
            case 151:
                if (!this.m.i()) {
                    this.h.r(32);
                    return;
                } else {
                    C();
                    return;
                }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i6 = i - 152;
                u(i6);
                if (this.q != i6) {
                    this.q = i6;
                    this.m = this.l[i6];
                    return;
                }
                return;
        }
    }

    private void s(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.h.r(8);
            } else if (i <= 23) {
                this.h.r(16);
            } else if (i <= 31) {
                this.h.r(24);
            }
        }
    }

    private void t(int i) {
        if (i <= 135) {
            this.h.r(32);
        } else if (i <= 143) {
            this.h.r(40);
        } else if (i <= 159) {
            this.h.r(2);
            this.h.r(this.h.h(6) * 8);
        }
    }

    private void u(int i) {
        b bVar = this.l[i];
        this.h.r(2);
        boolean g = this.h.g();
        boolean g2 = this.h.g();
        boolean g3 = this.h.g();
        int h = this.h.h(3);
        boolean g4 = this.h.g();
        int h2 = this.h.h(7);
        int h3 = this.h.h(8);
        int h4 = this.h.h(4);
        int h5 = this.h.h(4);
        this.h.r(2);
        int h6 = this.h.h(6);
        this.h.r(2);
        bVar.f(g, g2, g3, h, g4, h2, h3, h5, h6, h4, this.h.h(3), this.h.h(3));
    }

    private void v(int i) {
        if (i == 127) {
            this.m.a((char) 9835);
        } else {
            this.m.a((char) (i & 255));
        }
    }

    private void w(int i) {
        this.m.a((char) (i & 255));
    }

    private void x(int i) {
        if (i == 32) {
            this.m.a(' ');
        } else if (i == 33) {
            this.m.a((char) 160);
        } else if (i == 37) {
            this.m.a((char) 8230);
        } else if (i == 42) {
            this.m.a((char) 352);
        } else if (i == 44) {
            this.m.a((char) 338);
        } else if (i == 63) {
            this.m.a((char) 376);
        } else if (i == 57) {
            this.m.a((char) 8482);
        } else if (i == 58) {
            this.m.a((char) 353);
        } else if (i == 60) {
            this.m.a((char) 339);
        } else if (i != 61) {
            switch (i) {
                case 48:
                    this.m.a((char) 9608);
                    return;
                case 49:
                    this.m.a((char) 8216);
                    return;
                case 50:
                    this.m.a((char) 8217);
                    return;
                case 51:
                    this.m.a((char) 8220);
                    return;
                case 52:
                    this.m.a((char) 8221);
                    return;
                case 53:
                    this.m.a((char) 8226);
                    return;
                default:
                    switch (i) {
                        case 118:
                            this.m.a((char) 8539);
                            return;
                        case 119:
                            this.m.a((char) 8540);
                            return;
                        case 120:
                            this.m.a((char) 8541);
                            return;
                        case 121:
                            this.m.a((char) 8542);
                            return;
                        case 122:
                            this.m.a((char) 9474);
                            return;
                        case 123:
                            this.m.a((char) 9488);
                            return;
                        case 124:
                            this.m.a((char) 9492);
                            return;
                        case 125:
                            this.m.a((char) 9472);
                            return;
                        case 126:
                            this.m.a((char) 9496);
                            return;
                        case 127:
                            this.m.a((char) 9484);
                            return;
                        default:
                            StringBuilder sb = new StringBuilder(33);
                            sb.append("Invalid G2 character: ");
                            sb.append(i);
                            u.h("Cea708Decoder", sb.toString());
                            return;
                    }
            }
        } else {
            this.m.a((char) 8480);
        }
    }

    private void y(int i) {
        if (i == 160) {
            this.m.a((char) 13252);
            return;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Invalid G3 character: ");
        sb.append(i);
        u.h("Cea708Decoder", sb.toString());
        this.m.a('_');
    }

    private void z() {
        this.m.m(this.h.h(4), this.h.h(2), this.h.h(2), this.h.g(), this.h.g(), this.h.h(3), this.h.h(3));
    }

    @Override // com.google.android.exoplayer2.text.m.e, com.google.android.exoplayer2.text.g
    public /* bridge */ /* synthetic */ void a(long j) {
        super.a(j);
    }

    @Override // com.google.android.exoplayer2.text.m.e
    protected f e() {
        List<com.google.android.exoplayer2.text.c> list = this.n;
        this.o = list;
        return new f((List) g.e(list));
    }

    @Override // com.google.android.exoplayer2.text.m.e
    protected void f(com.google.android.exoplayer2.text.i iVar) {
        ByteBuffer byteBuffer = (ByteBuffer) g.e(iVar.f2153f);
        this.g.N(byteBuffer.array(), byteBuffer.limit());
        while (this.g.a() >= 3) {
            int D = this.g.D() & 7;
            int i = D & 3;
            boolean z = false;
            boolean z2 = (D & 4) == 4;
            byte D2 = (byte) this.g.D();
            byte D3 = (byte) this.g.D();
            if (i == 2 || i == 3) {
                if (z2) {
                    if (i == 3) {
                        o();
                        int i2 = (D2 & 192) >> 6;
                        int i3 = this.i;
                        if (!(i3 == -1 || i2 == (i3 + 1) % 4)) {
                            E();
                            int i4 = this.i;
                            StringBuilder sb = new StringBuilder(71);
                            sb.append("Sequence number discontinuity. previous=");
                            sb.append(i4);
                            sb.append(" current=");
                            sb.append(i2);
                            u.h("Cea708Decoder", sb.toString());
                        }
                        this.i = i2;
                        int i5 = D2 & 63;
                        if (i5 == 0) {
                            i5 = 64;
                        }
                        c cVar = new c(i2, i5);
                        this.p = cVar;
                        byte[] bArr = cVar.f3466c;
                        int i6 = cVar.f3467d;
                        cVar.f3467d = i6 + 1;
                        bArr[i6] = D3;
                    } else {
                        if (i == 2) {
                            z = true;
                        }
                        g.a(z);
                        c cVar2 = this.p;
                        if (cVar2 == null) {
                            u.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = cVar2.f3466c;
                            int i7 = cVar2.f3467d;
                            int i8 = i7 + 1;
                            cVar2.f3467d = i8;
                            bArr2[i7] = D2;
                            cVar2.f3467d = i8 + 1;
                            bArr2[i8] = D3;
                        }
                    }
                    c cVar3 = this.p;
                    if (cVar3.f3467d == (cVar3.f3465b * 2) - 1) {
                        o();
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.m.e, com.google.android.exoplayer2.decoder.c
    public void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        this.q = 0;
        this.m = this.l[0];
        E();
        this.p = null;
    }

    @Override // com.google.android.exoplayer2.text.m.e
    @Nullable
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.text.i g() throws SubtitleDecoderException {
        return super.d();
    }

    @Override // com.google.android.exoplayer2.decoder.c
    public String getName() {
        return "Cea708Decoder";
    }

    @Override // com.google.android.exoplayer2.text.m.e
    @Nullable
    public /* bridge */ /* synthetic */ j h() throws SubtitleDecoderException {
        return super.b();
    }

    @Override // com.google.android.exoplayer2.text.m.e
    protected boolean k() {
        return this.n != this.o;
    }

    @Override // com.google.android.exoplayer2.text.m.e
    public /* bridge */ /* synthetic */ void l(com.google.android.exoplayer2.text.i iVar) throws SubtitleDecoderException {
        super.c(iVar);
    }

    @Override // com.google.android.exoplayer2.text.m.e, com.google.android.exoplayer2.decoder.c
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }
}
