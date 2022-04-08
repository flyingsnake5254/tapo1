package com.google.android.exoplayer2.o2.k0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.m;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;

/* compiled from: OggPageHeader.java */
/* loaded from: classes.dex */
final class f {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f2855b;

    /* renamed from: c  reason: collision with root package name */
    public long f2856c;

    /* renamed from: d  reason: collision with root package name */
    public long f2857d;

    /* renamed from: e  reason: collision with root package name */
    public long f2858e;

    /* renamed from: f  reason: collision with root package name */
    public long f2859f;
    public int g;
    public int h;
    public int i;
    public final int[] j = new int[255];
    private final d0 k = new d0(255);

    public boolean a(k kVar, boolean z) throws IOException {
        b();
        this.k.L(27);
        if (!m.b(kVar, this.k.d(), 0, 27, z) || this.k.F() != 1332176723) {
            return false;
        }
        int D = this.k.D();
        this.a = D;
        if (D == 0) {
            this.f2855b = this.k.D();
            this.f2856c = this.k.r();
            this.f2857d = this.k.t();
            this.f2858e = this.k.t();
            this.f2859f = this.k.t();
            int D2 = this.k.D();
            this.g = D2;
            this.h = D2 + 27;
            this.k.L(D2);
            if (!m.b(kVar, this.k.d(), 0, this.g, z)) {
                return false;
            }
            for (int i = 0; i < this.g; i++) {
                this.j[i] = this.k.D();
                this.i += this.j[i];
            }
            return true;
        } else if (z) {
            return false;
        } else {
            throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
        }
    }

    public void b() {
        this.a = 0;
        this.f2855b = 0;
        this.f2856c = 0L;
        this.f2857d = 0L;
        this.f2858e = 0L;
        this.f2859f = 0L;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    public boolean c(k kVar) throws IOException {
        return d(kVar, -1L);
    }

    public boolean d(k kVar, long j) throws IOException {
        int i;
        g.a(kVar.getPosition() == kVar.g());
        this.k.L(4);
        while (true) {
            i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
            if ((i == 0 || kVar.getPosition() + 4 < j) && m.b(kVar, this.k.d(), 0, 4, true)) {
                this.k.P(0);
                if (this.k.F() == 1332176723) {
                    kVar.e();
                    return true;
                }
                kVar.l(1);
            }
        }
        do {
            if (i != 0 && kVar.getPosition() >= j) {
                break;
            }
        } while (kVar.i(1) != -1);
        return false;
    }
}
