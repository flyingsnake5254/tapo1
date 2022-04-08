package com.tplink.libtpmux.tsmux;

import com.tplink.libtpmux.tsmux.f.b;
import com.tplink.libtpmux.tsmux.f.c;
import com.tplink.libtpmux.tsmux.f.d;
import com.tplink.libtpmux.tsmux.f.f;
import com.tplink.libtpmux.tsmux.f.g;
import com.tplink.libtpmux.tsmux.f.h;
import com.tplink.libtpmux.tsmux.f.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: MPEGTSMuxer.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    private final a f12682d;

    /* renamed from: e  reason: collision with root package name */
    private int f12683e;

    /* renamed from: f  reason: collision with root package name */
    private int f12684f;
    private final byte[] a = new byte[188];

    /* renamed from: b  reason: collision with root package name */
    private int f12680b = 0;

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer f12681c = ByteBuffer.allocateDirect(512000);
    private final List<com.tplink.libtpmux.tsmux.f.e> g = new ArrayList();
    private final List<h> h = new ArrayList();
    private boolean i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MPEGTSMuxer.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MimeType.values().length];
            a = iArr;
            try {
                iArr[MimeType.MUXTS_CODEC_HEVC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MimeType.MUXTS_CODEC_AVC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MimeType.MUXTS_CODEC_AAC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MimeType.MUXTS_CODEC_PCMA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public e() {
        a aVar = new a();
        this.f12682d = aVar;
        aVar.e(0);
        aVar.d(0);
        aVar.g(0);
        aVar.f(new c());
    }

    private byte c(byte b2, int i, int i2) {
        return (byte) ((b2 << i) | i2);
    }

    private int d(int i, int i2, int i3) {
        return (i << i2) | i3;
    }

    private long e(long j, int i, int i2) {
        return (j << i) | i2;
    }

    private byte[] f(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private byte[] g(long j) {
        return new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)};
    }

    private int h(int i) {
        return (i + 1) & 15;
    }

    private int i(byte[] bArr, int i, int i2) {
        int i3 = -1;
        for (int i4 = i; i4 < i + i2; i4++) {
            int i5 = i3 << 8;
            i3 = d.a[((i3 >> 24) ^ bArr[i4]) & 255] ^ i5;
        }
        return i3;
    }

    private int j(int i) {
        if (this.f12680b + i > 188) {
            return -4;
        }
        byte[] bArr = new byte[i];
        Arrays.fill(bArr, (byte) -1);
        System.arraycopy(bArr, 0, this.a, this.f12680b, i);
        this.f12680b += i;
        return 0;
    }

    private void q(int i) {
        System.arraycopy(f(i(this.a, i, this.f12680b - i)), 0, this.a, this.f12680b, 4);
        this.f12680b += 4;
    }

    private void r() {
        if (this.f12680b == 188) {
            this.f12681c.put(this.a);
            this.f12680b = 0;
        }
    }

    private void s(int i, boolean z, c cVar) {
        long j;
        com.tplink.libtpmux.tsmux.f.a aVar = new com.tplink.libtpmux.tsmux.f.a();
        aVar.l(i);
        aVar.m(0);
        aVar.n(0);
        if (z) {
            aVar.q(255);
            aVar.r(0);
            aVar.p(cVar);
        } else {
            aVar.q(0);
            aVar.r(0);
        }
        if (1 == i) {
            aVar.r(0);
        }
        aVar.o(0);
        aVar.s(0);
        aVar.t(0);
        aVar.k(0);
        byte c2 = c((byte) 0, 0, aVar.b());
        byte[] bArr = this.a;
        int i2 = this.f12680b;
        bArr[i2] = c2;
        this.f12680b = i2 + 1;
        if (aVar.b() != 0) {
            byte c3 = c(c(c(c(c(c(c(c((byte) 0, 0, aVar.c()), 1, aVar.h()), 1, aVar.d()), 1, aVar.g()), 1, aVar.e()), 1, aVar.i()), 1, aVar.j()), 1, aVar.a());
            byte[] bArr2 = this.a;
            int i3 = this.f12680b;
            bArr2[i3] = c3;
            this.f12680b = i3 + 1;
            if (z) {
                byte[] bArr3 = this.a;
                int i4 = this.f12680b;
                bArr3[i4] = (byte) (((aVar.f().a() >> 25) & 255) | j);
                this.f12680b = i4 + 1;
                System.arraycopy(f((d((int) (0 + (aVar.f().a() & 33554431)), 6, aVar.f().c()) << 1) | (aVar.f().b() & 256)), 0, this.a, this.f12680b, 4);
                this.f12680b += 4;
                byte[] bArr4 = this.a;
                int i5 = this.f12680b;
                bArr4[i5] = (byte) (aVar.f().b() | 0);
                this.f12680b = i5 + 1;
                return;
            }
            j(aVar.b() - 1);
        }
    }

    private void u(int i, int i2, int i3, int i4) {
        b bVar = new b();
        bVar.m(71);
        bVar.n(0);
        bVar.l(i2);
        bVar.o(0);
        bVar.k(i);
        bVar.p(0);
        bVar.i(i3);
        bVar.j(i4);
        System.arraycopy(f(d(d(d(d(d(d(d(d(0, 0, bVar.e()), 1, bVar.f()), 1, bVar.d()), 1, bVar.g()), 13, bVar.c()), 2, bVar.h()), 2, bVar.a()), 4, bVar.b())), 0, this.a, this.f12680b, 4);
        this.f12680b = 4;
        if (1 == i2 && 1 == i3) {
            this.a[4] = 0;
            this.f12680b = 4 + 1;
        }
    }

    private void v(List<com.tplink.libtpmux.tsmux.f.e> list, boolean z) {
        int i;
        int i2;
        if (!(list == null || list.isEmpty())) {
            d dVar = new d();
            dVar.u(0);
            dVar.t(255);
            dVar.x(0);
            dVar.p(255);
            if (z) {
                i = 9;
                i2 = 5;
            } else {
                i = 8;
                i2 = 4;
            }
            dVar.r(i + (list.size() * 4));
            dVar.v(1);
            dVar.q(255);
            dVar.w(0);
            dVar.m(255);
            dVar.s(0);
            dVar.n(0);
            dVar.o(list);
            dVar.l(1);
            System.arraycopy(g(e(e(e(e(e(e(e(e(e(e(e(0L, 0, dVar.h()), 1, dVar.g()), 1, dVar.k()), 2, dVar.c()), 12, dVar.e()), 16, dVar.i()), 2, dVar.d()), 5, dVar.j()), 1, dVar.a()), 8, dVar.f()), 8, dVar.b())), 0, this.a, this.f12680b, 8);
            this.f12680b += 8;
            for (com.tplink.libtpmux.tsmux.f.e eVar : list) {
                System.arraycopy(f(d(d(d(0, 0, eVar.b()), 3, eVar.c()), 13, eVar.a())), 0, this.a, this.f12680b, 4);
                this.f12680b += 4;
            }
            q(i2);
            j(188 - this.f12680b);
            r();
        }
    }

    private void w(int i, int i2, int i3, int i4, i iVar) {
        f fVar = new f();
        fVar.z(1);
        fVar.H(i2);
        fVar.D(i);
        fVar.x(2);
        fVar.F(0);
        fVar.E(0);
        fVar.u(0);
        fVar.s(0);
        fVar.y(0);
        fVar.G(i3);
        fVar.w(0);
        fVar.v(0);
        fVar.t(0);
        fVar.r(0);
        fVar.A(0);
        fVar.B(0);
        fVar.C(i4);
        System.arraycopy(g(e(e(e(e(e(e(e(e(e(e(e(e(e(e(e(e(0L, 0, fVar.i()), 8, fVar.q()), 16, fVar.m()), 2, fVar.g()), 2, fVar.o()), 1, fVar.n()), 1, fVar.d()), 1, fVar.b()), 1, fVar.h()), 2, fVar.p()), 1, fVar.f()), 1, fVar.e()), 1, fVar.c()), 1, fVar.a()), 1, fVar.j()), 1, fVar.k())), 0, this.a, this.f12680b, 8);
        this.f12680b += 8;
        byte[] bArr = this.a;
        int i5 = this.f12680b;
        bArr[i5] = (byte) (fVar.l() | 0);
        this.f12680b = i5 + 1;
        if (2 == fVar.p() && 5 == fVar.l()) {
            byte c2 = c(c(c((byte) 0, 0, iVar.a()), 3, iVar.b()), 1, iVar.e());
            byte[] bArr2 = this.a;
            int i6 = this.f12680b;
            bArr2[i6] = c2;
            this.f12680b = i6 + 1;
            System.arraycopy(f(d(d(d(d(0, 0, iVar.c()), 1, iVar.f()), 15, iVar.d()), 1, iVar.g())), 0, this.a, this.f12680b, 4);
            this.f12680b += 4;
        }
        if (3 == fVar.p() && 10 == fVar.l()) {
            iVar.h(3);
            byte c3 = c(c(c((byte) 0, 0, iVar.a()), 3, iVar.b()), 1, iVar.e());
            byte[] bArr3 = this.a;
            int i7 = this.f12680b;
            bArr3[i7] = c3;
            this.f12680b = i7 + 1;
            System.arraycopy(f(d(d(d(d(0, 0, iVar.c()), 1, iVar.f()), 15, iVar.d()), 1, iVar.g())), 0, this.a, this.f12680b, 4);
            this.f12680b += 4;
        }
        if (224 == i2 && 27 == this.f12682d.c().c().get(this.f12684f).d()) {
            byte[] bArr4 = this.a;
            int i8 = this.f12680b;
            bArr4[i8] = 0;
            int i9 = i8 + 1;
            this.f12680b = i9;
            bArr4[i9] = 0;
            int i10 = i9 + 1;
            this.f12680b = i10;
            bArr4[i10] = 0;
            int i11 = i10 + 1;
            this.f12680b = i11;
            bArr4[i11] = 1;
            int i12 = i11 + 1;
            this.f12680b = i12;
            bArr4[i12] = 9;
            int i13 = i12 + 1;
            this.f12680b = i13;
            bArr4[i13] = -16;
            this.f12680b = i13 + 1;
        }
    }

    private void x(List<h> list, int i, boolean z) {
        int i2;
        int i3;
        if (!(list == null || list.isEmpty())) {
            g gVar = new g();
            gVar.D(2);
            gVar.C(1);
            gVar.F(0);
            gVar.w(255);
            if (z) {
                i2 = 13;
                i3 = 5;
            } else {
                i2 = 12;
                i3 = 4;
            }
            gVar.A(i2 + (list.size() * 5));
            gVar.v(i);
            gVar.x(255);
            gVar.E(0);
            gVar.q(255);
            gVar.B(0);
            gVar.r(0);
            gVar.y(255);
            gVar.s(256);
            gVar.z(255);
            gVar.u(0);
            gVar.t(list);
            gVar.p(1);
            System.arraycopy(g(e(e(e(e(e(e(e(e(e(e(e(0L, 0, gVar.m()), 1, gVar.l()), 1, gVar.o()), 2, gVar.f()), 12, gVar.j()), 16, gVar.e()), 2, gVar.g()), 5, gVar.n()), 1, gVar.a()), 8, gVar.k()), 8, gVar.b())), 0, this.a, this.f12680b, 8);
            this.f12680b += 8;
            System.arraycopy(f(d(d(d(d(0, 0, gVar.h()), 13, gVar.c()), 4, gVar.i()), 12, gVar.d())), 0, this.a, this.f12680b, 4);
            this.f12680b += 4;
            for (h hVar : list) {
                byte c2 = c((byte) 0, 0, hVar.e());
                byte[] bArr = this.a;
                int i4 = this.f12680b;
                bArr[i4] = c2;
                this.f12680b = i4 + 1;
                System.arraycopy(f(d(d(d(d(0, 0, hVar.c()), 13, hVar.b()), 4, hVar.d()), 12, hVar.a())), 0, this.a, this.f12680b, 4);
                this.f12680b += 4;
            }
            q(i3);
            j(188 - this.f12680b);
            r();
        }
    }

    public void a(int i, int i2) {
        this.f12682d.c().g(i);
        this.f12682d.c().f(0);
        this.f12682d.c().h(0);
        this.f12682d.c().i(i2);
    }

    public void b(int i, MimeType mimeType) {
        b bVar = new b();
        bVar.g(i);
        bVar.f(0);
        int i2 = a.a[mimeType.ordinal()];
        if (i2 == 1) {
            bVar.h(224);
            bVar.e(18);
            bVar.i(36);
            this.f12684f = this.f12682d.c().c().size();
        } else if (i2 == 2) {
            bVar.h(224);
            bVar.e(18);
            bVar.i(27);
            this.f12684f = this.f12682d.c().c().size();
        } else if (i2 == 3) {
            bVar.h(192);
            bVar.e(17);
            bVar.i(15);
            this.f12683e = this.f12682d.c().c().size();
        } else if (i2 == 4) {
            bVar.h(192);
            bVar.e(17);
            bVar.i(144);
            this.f12683e = this.f12682d.c().c().size();
        }
        this.f12682d.c().h(this.f12682d.c().d() + 1);
        this.f12682d.c().c().add(bVar);
    }

    public byte[] k(byte[] bArr, int i, long j) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length > i) {
            bArr = Arrays.copyOf(bArr, i);
        }
        o();
        a(66, 1);
        MimeType mimeType = MimeType.MUXTS_CODEC_PCMA;
        b(68, mimeType);
        m();
        t(bArr, j, mimeType);
        return l();
    }

    public byte[] l() {
        this.f12681c.flip();
        int remaining = this.f12681c.remaining();
        if (remaining <= 0) {
            return null;
        }
        byte[] bArr = new byte[remaining];
        this.f12681c.get(bArr);
        return bArr;
    }

    public void m() {
        com.tplink.libtpmux.tsmux.f.e eVar = new com.tplink.libtpmux.tsmux.f.e();
        eVar.e(this.f12682d.c().e());
        eVar.d(this.f12682d.c().b());
        eVar.f(255);
        this.g.add(eVar);
        for (int i = 0; i < this.f12682d.c().d(); i++) {
            h hVar = new h();
            b bVar = this.f12682d.c().c().get(i);
            hVar.g(bVar.b());
            hVar.j(bVar.d());
            hVar.f(6);
            hVar.h(255);
            hVar.i(255);
            this.h.add(hVar);
        }
    }

    public void n() {
        this.f12681c = null;
    }

    public void o() {
        this.f12680b = 0;
        this.f12681c.clear();
        this.f12682d.e(0);
        this.f12682d.d(0);
        this.f12682d.g(0);
        this.f12682d.f(new c());
        this.g.clear();
        this.h.clear();
    }

    public void p(boolean z) {
        this.i = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void t(byte[] r21, long r22, com.tplink.libtpmux.tsmux.MimeType r24) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpmux.tsmux.e.t(byte[], long, com.tplink.libtpmux.tsmux.MimeType):void");
    }
}
