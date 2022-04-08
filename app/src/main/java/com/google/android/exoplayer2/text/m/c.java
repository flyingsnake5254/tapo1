package com.google.android.exoplayer2.text.m;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Cea608Decoder.java */
/* loaded from: classes.dex */
public final class c extends e {
    private static final int[] g = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] h = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] i = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] j = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] k = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] l = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] m = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] n = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    private boolean A;
    private byte B;
    private byte C;
    private boolean E;
    private long F;
    private final int p;
    private final int q;
    private final int r;
    private final long s;
    @Nullable
    private List<com.google.android.exoplayer2.text.c> v;
    @Nullable
    private List<com.google.android.exoplayer2.text.c> w;
    private int x;
    private int y;
    private boolean z;
    private final d0 o = new d0();
    private final ArrayList<a> t = new ArrayList<>();
    private a u = new a(0, 4);
    private int D = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cea608Decoder.java */
    /* loaded from: classes.dex */
    public static final class a {
        private final List<C0084a> a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<SpannableString> f3451b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final StringBuilder f3452c = new StringBuilder();

        /* renamed from: d  reason: collision with root package name */
        private int f3453d;

        /* renamed from: e  reason: collision with root package name */
        private int f3454e;

        /* renamed from: f  reason: collision with root package name */
        private int f3455f;
        private int g;
        private int h;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Cea608Decoder.java */
        /* renamed from: com.google.android.exoplayer2.text.m.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0084a {
            public final int a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f3456b;

            /* renamed from: c  reason: collision with root package name */
            public int f3457c;

            public C0084a(int i, boolean z, int i2) {
                this.a = i;
                this.f3456b = z;
                this.f3457c = i2;
            }
        }

        public a(int i, int i2) {
            j(i);
            this.h = i2;
        }

        private SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f3452c);
            int length = spannableStringBuilder.length();
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            boolean z = false;
            while (i < this.a.size()) {
                C0084a aVar = this.a.get(i);
                boolean z2 = aVar.f3456b;
                int i7 = aVar.a;
                if (i7 != 8) {
                    z = i7 == 7;
                    if (i7 != 7) {
                        i6 = c.i[i7];
                    }
                }
                int i8 = aVar.f3457c;
                i++;
                if (i8 != (i < this.a.size() ? this.a.get(i).f3457c : length)) {
                    if (i2 != -1 && !z2) {
                        q(spannableStringBuilder, i2, i8);
                        i2 = -1;
                    } else if (i2 == -1 && z2) {
                        i2 = i8;
                    }
                    if (i3 != -1 && !z) {
                        o(spannableStringBuilder, i3, i8);
                        i3 = -1;
                    } else if (i3 == -1 && z) {
                        i3 = i8;
                    }
                    if (i6 != i5) {
                        n(spannableStringBuilder, i4, i8, i5);
                        i5 = i6;
                        i4 = i8;
                    }
                }
            }
            if (!(i2 == -1 || i2 == length)) {
                q(spannableStringBuilder, i2, length);
            }
            if (!(i3 == -1 || i3 == length)) {
                o(spannableStringBuilder, i3, length);
            }
            if (i4 != length) {
                n(spannableStringBuilder, i4, length, i5);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void n(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            if (i3 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
            }
        }

        private static void o(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
        }

        private static void q(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }

        public void e(char c2) {
            if (this.f3452c.length() < 32) {
                this.f3452c.append(c2);
            }
        }

        public void f() {
            int length = this.f3452c.length();
            if (length > 0) {
                this.f3452c.delete(length - 1, length);
                for (int size = this.a.size() - 1; size >= 0; size--) {
                    C0084a aVar = this.a.get(size);
                    int i = aVar.f3457c;
                    if (i == length) {
                        aVar.f3457c = i - 1;
                    } else {
                        return;
                    }
                }
            }
        }

        @Nullable
        public com.google.android.exoplayer2.text.c g(int i) {
            float f2;
            int i2 = this.f3454e + this.f3455f;
            int i3 = 32 - i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.f3451b.size(); i4++) {
                spannableStringBuilder.append(o0.M0(this.f3451b.get(i4), i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(o0.M0(h(), i3));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i3 - spannableStringBuilder.length();
            int i5 = i2 - length;
            if (i == Integer.MIN_VALUE) {
                if (this.g != 2 || (Math.abs(i5) >= 3 && length >= 0)) {
                    i = (this.g != 2 || i5 <= 0) ? 0 : 2;
                } else {
                    i = 1;
                }
            }
            if (i != 1) {
                if (i == 2) {
                    i2 = 32 - length;
                }
                f2 = ((i2 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f2 = 0.5f;
            }
            int i6 = this.f3453d;
            if (i6 > 7) {
                i6 = (i6 - 15) - 2;
            } else if (this.g == 1) {
                i6 -= this.h - 1;
            }
            return new c.b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i6, 1).k(f2).l(i).a();
        }

        public boolean i() {
            return this.a.isEmpty() && this.f3451b.isEmpty() && this.f3452c.length() == 0;
        }

        public void j(int i) {
            this.g = i;
            this.a.clear();
            this.f3451b.clear();
            this.f3452c.setLength(0);
            this.f3453d = 15;
            this.f3454e = 0;
            this.f3455f = 0;
        }

        public void k() {
            this.f3451b.add(h());
            this.f3452c.setLength(0);
            this.a.clear();
            int min = Math.min(this.h, this.f3453d);
            while (this.f3451b.size() >= min) {
                this.f3451b.remove(0);
            }
        }

        public void l(int i) {
            this.g = i;
        }

        public void m(int i) {
            this.h = i;
        }

        public void p(int i, boolean z) {
            this.a.add(new C0084a(i, z, this.f3452c.length()));
        }
    }

    public c(String str, int i2, long j2) {
        this.s = j2 > 0 ? j2 * 1000 : -9223372036854775807L;
        this.p = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i2 == 1) {
            this.r = 0;
            this.q = 0;
        } else if (i2 == 2) {
            this.r = 1;
            this.q = 0;
        } else if (i2 == 3) {
            this.r = 0;
            this.q = 1;
        } else if (i2 != 4) {
            u.h("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.r = 0;
            this.q = 0;
        } else {
            this.r = 1;
            this.q = 1;
        }
        M(0);
        L();
        this.E = true;
        this.F = -9223372036854775807L;
    }

    private static boolean A(byte b2, byte b3) {
        return (b2 & 246) == 18 && (b3 & 224) == 32;
    }

    private static boolean B(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static boolean C(byte b2, byte b3) {
        return (b2 & 246) == 20 && (b3 & 240) == 32;
    }

    private static boolean D(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    private static boolean E(byte b2) {
        return (b2 & 240) == 16;
    }

    private boolean F(boolean z, byte b2, byte b3) {
        if (!z || !E(b2)) {
            this.A = false;
        } else if (this.A && this.B == b2 && this.C == b3) {
            this.A = false;
            return true;
        } else {
            this.A = true;
            this.B = b2;
            this.C = b3;
        }
        return false;
    }

    private static boolean G(byte b2) {
        return (b2 & 247) == 20;
    }

    private static boolean H(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 48;
    }

    private static boolean I(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    private static boolean J(byte b2) {
        return 1 <= b2 && b2 <= 15;
    }

    private void K(byte b2, byte b3) {
        if (J(b2)) {
            this.E = false;
        } else if (G(b2)) {
            if (!(b3 == 32 || b3 == 47)) {
                switch (b3) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b3) {
                            case 41:
                                break;
                            case 42:
                            case 43:
                                this.E = false;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.E = true;
        }
    }

    private void L() {
        this.u.j(this.x);
        this.t.clear();
        this.t.add(this.u);
    }

    private void M(int i2) {
        int i3 = this.x;
        if (i3 != i2) {
            this.x = i2;
            if (i2 == 3) {
                for (int i4 = 0; i4 < this.t.size(); i4++) {
                    this.t.get(i4).l(i2);
                }
                return;
            }
            L();
            if (i3 == 3 || i2 == 1 || i2 == 0) {
                this.v = Collections.emptyList();
            }
        }
    }

    private void N(int i2) {
        this.y = i2;
        this.u.m(i2);
    }

    private boolean O() {
        return (this.s == -9223372036854775807L || this.F == -9223372036854775807L || j() - this.F < this.s) ? false : true;
    }

    private boolean P(byte b2) {
        if (z(b2)) {
            this.D = q(b2);
        }
        return this.D == this.r;
    }

    private static char p(byte b2) {
        return (char) j[(b2 & Byte.MAX_VALUE) - 32];
    }

    private static int q(byte b2) {
        return (b2 >> 3) & 1;
    }

    private List<com.google.android.exoplayer2.text.c> r() {
        int size = this.t.size();
        ArrayList arrayList = new ArrayList(size);
        int i2 = 2;
        for (int i3 = 0; i3 < size; i3++) {
            com.google.android.exoplayer2.text.c g2 = this.t.get(i3).g(Integer.MIN_VALUE);
            arrayList.add(g2);
            if (g2 != null) {
                i2 = Math.min(i2, g2.k);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            com.google.android.exoplayer2.text.c cVar = (com.google.android.exoplayer2.text.c) arrayList.get(i4);
            if (cVar != null) {
                if (cVar.k != i2) {
                    cVar = (com.google.android.exoplayer2.text.c) g.e(this.t.get(i4).g(i2));
                }
                arrayList2.add(cVar);
            }
        }
        return arrayList2;
    }

    private static char s(byte b2) {
        return (char) l[b2 & 31];
    }

    private static char t(byte b2) {
        return (char) m[b2 & 31];
    }

    private static char u(byte b2, byte b3) {
        if ((b2 & 1) == 0) {
            return s(b3);
        }
        return t(b3);
    }

    private static char v(byte b2) {
        return (char) k[b2 & BinaryMemcacheOpcodes.PREPEND];
    }

    private void w(byte b2) {
        this.u.e(' ');
        this.u.p((b2 >> 1) & 7, (b2 & 1) == 1);
    }

    private void x(byte b2) {
        if (b2 == 32) {
            M(2);
        } else if (b2 != 41) {
            switch (b2) {
                case 37:
                    M(1);
                    N(2);
                    return;
                case 38:
                    M(1);
                    N(3);
                    return;
                case 39:
                    M(1);
                    N(4);
                    return;
                default:
                    int i2 = this.x;
                    if (i2 != 0) {
                        if (b2 != 33) {
                            switch (b2) {
                                case 44:
                                    this.v = Collections.emptyList();
                                    int i3 = this.x;
                                    if (i3 == 1 || i3 == 3) {
                                        L();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i2 == 1 && !this.u.i()) {
                                        this.u.k();
                                        return;
                                    }
                                    return;
                                case 46:
                                    L();
                                    return;
                                case 47:
                                    this.v = r();
                                    L();
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            this.u.f();
                            return;
                        }
                    } else {
                        return;
                    }
            }
        } else {
            M(3);
        }
    }

    private void y(byte b2, byte b3) {
        int i2 = g[b2 & 7];
        boolean z = false;
        if ((b3 & 32) != 0) {
            i2++;
        }
        if (i2 != this.u.f3453d) {
            if (this.x != 1 && !this.u.i()) {
                a aVar = new a(this.x, this.y);
                this.u = aVar;
                this.t.add(aVar);
            }
            this.u.f3453d = i2;
        }
        boolean z2 = (b3 & BinaryMemcacheOpcodes.STAT) == 16;
        if ((b3 & 1) == 1) {
            z = true;
        }
        int i3 = (b3 >> 1) & 7;
        this.u.p(z2 ? 8 : i3, z);
        if (z2) {
            this.u.f3454e = h[i3];
        }
    }

    private static boolean z(byte b2) {
        return (b2 & 224) == 0;
    }

    @Override // com.google.android.exoplayer2.text.m.e, com.google.android.exoplayer2.text.g
    public /* bridge */ /* synthetic */ void a(long j2) {
        super.a(j2);
    }

    @Override // com.google.android.exoplayer2.text.m.e
    protected f e() {
        List<com.google.android.exoplayer2.text.c> list = this.v;
        this.w = list;
        return new f((List) g.e(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0018 A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.text.m.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void f(com.google.android.exoplayer2.text.i r10) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.m.c.f(com.google.android.exoplayer2.text.i):void");
    }

    @Override // com.google.android.exoplayer2.text.m.e, com.google.android.exoplayer2.decoder.c
    public void flush() {
        super.flush();
        this.v = null;
        this.w = null;
        M(0);
        N(4);
        L();
        this.z = false;
        this.A = false;
        this.B = (byte) 0;
        this.C = (byte) 0;
        this.D = 0;
        this.E = true;
        this.F = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.text.m.e
    @Nullable
    public /* bridge */ /* synthetic */ i g() throws SubtitleDecoderException {
        return super.d();
    }

    @Override // com.google.android.exoplayer2.decoder.c
    public String getName() {
        return "Cea608Decoder";
    }

    @Override // com.google.android.exoplayer2.text.m.e
    @Nullable
    /* renamed from: h */
    public j b() throws SubtitleDecoderException {
        j i2;
        j h2 = super.b();
        if (h2 != null) {
            return h2;
        }
        if (!O() || (i2 = i()) == null) {
            return null;
        }
        this.v = Collections.emptyList();
        this.F = -9223372036854775807L;
        i2.o(j(), e(), Long.MAX_VALUE);
        return i2;
    }

    @Override // com.google.android.exoplayer2.text.m.e
    protected boolean k() {
        return this.v != this.w;
    }

    @Override // com.google.android.exoplayer2.text.m.e
    public /* bridge */ /* synthetic */ void l(i iVar) throws SubtitleDecoderException {
        super.c(iVar);
    }

    @Override // com.google.android.exoplayer2.text.m.e, com.google.android.exoplayer2.decoder.c
    public void release() {
    }
}
