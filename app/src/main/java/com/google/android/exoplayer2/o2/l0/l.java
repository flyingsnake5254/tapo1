package com.google.android.exoplayer2.o2.l0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.i;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DefaultTsPayloadReaderFactory.java */
/* loaded from: classes.dex */
public final class l implements i0.c {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Format> f2950b;

    public l(int i) {
        this(i, ImmutableList.of());
    }

    private e0 c(i0.b bVar) {
        return new e0(e(bVar));
    }

    private k0 d(i0.b bVar) {
        return new k0(e(bVar));
    }

    private List<Format> e(i0.b bVar) {
        String str;
        int i;
        if (f(32)) {
            return this.f2950b;
        }
        d0 d0Var = new d0(bVar.f2934d);
        List<Format> list = this.f2950b;
        while (d0Var.a() > 0) {
            int D = d0Var.D();
            int e2 = d0Var.e() + d0Var.D();
            if (D == 134) {
                list = new ArrayList<>();
                int D2 = d0Var.D() & 31;
                for (int i2 = 0; i2 < D2; i2++) {
                    String A = d0Var.A(3);
                    int D3 = d0Var.D();
                    boolean z = true;
                    boolean z2 = (D3 & 128) != 0;
                    if (z2) {
                        i = D3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte D4 = (byte) d0Var.D();
                    d0Var.Q(1);
                    List<byte[]> list2 = null;
                    if (z2) {
                        if ((D4 & 64) == 0) {
                            z = false;
                        }
                        list2 = i.b(z);
                    }
                    list.add(new Format.b().e0(str).V(A).F(i).T(list2).E());
                }
            }
            d0Var.P(e2);
        }
        return list;
    }

    private boolean f(int i) {
        return (i & this.a) != 0;
    }

    @Override // com.google.android.exoplayer2.o2.l0.i0.c
    public SparseArray<i0> a() {
        return new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.o2.l0.i0.c
    @Nullable
    public i0 b(int i, i0.b bVar) {
        if (i == 2) {
            return new y(new p(d(bVar)));
        }
        if (i == 3 || i == 4) {
            return new y(new v(bVar.f2932b));
        }
        if (i == 21) {
            return new y(new t());
        }
        if (i != 27) {
            if (i == 36) {
                return new y(new s(c(bVar)));
            }
            if (i == 89) {
                return new y(new n(bVar.f2933c));
            }
            if (i != 138) {
                if (i == 172) {
                    return new y(new i(bVar.f2932b));
                }
                if (i == 257) {
                    return new d0(new x("application/vnd.dvb.ait"));
                }
                if (i != 129) {
                    if (i != 130) {
                        if (i != 134) {
                            if (i != 135) {
                                switch (i) {
                                    case 15:
                                        if (f(2)) {
                                            return null;
                                        }
                                        return new y(new k(false, bVar.f2932b));
                                    case 16:
                                        return new y(new q(d(bVar)));
                                    case 17:
                                        if (f(2)) {
                                            return null;
                                        }
                                        return new y(new u(bVar.f2932b));
                                    default:
                                        return null;
                                }
                            }
                        } else if (f(16)) {
                            return null;
                        } else {
                            return new d0(new x("application/x-scte35"));
                        }
                    } else if (!f(64)) {
                        return null;
                    }
                }
                return new y(new g(bVar.f2932b));
            }
            return new y(new m(bVar.f2932b));
        } else if (f(4)) {
            return null;
        } else {
            return new y(new r(c(bVar), f(1), f(8)));
        }
    }

    public l(int i, List<Format> list) {
        this.a = i;
        this.f2950b = list;
    }
}
