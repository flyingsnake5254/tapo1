package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.d;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.util.List;

/* compiled from: SeiReader.java */
/* loaded from: classes.dex */
public final class e0 {
    private final List<Format> a;

    /* renamed from: b  reason: collision with root package name */
    private final b0[] f2895b;

    public e0(List<Format> list) {
        this.a = list;
        this.f2895b = new b0[list.size()];
    }

    public void a(long j, d0 d0Var) {
        d.a(j, d0Var, this.f2895b);
    }

    public void b(l lVar, i0.d dVar) {
        for (int i = 0; i < this.f2895b.length; i++) {
            dVar.a();
            b0 t = lVar.t(dVar.c(), 3);
            Format format = this.a.get(i);
            String str = format.H3;
            boolean z = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String valueOf = String.valueOf(str);
            g.b(z, valueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(valueOf) : new String("Invalid closed caption mime type provided: "));
            String str2 = format.f2004c;
            if (str2 == null) {
                str2 = dVar.b();
            }
            t.d(new Format.b().S(str2).e0(str).g0(format.q).V(format.f2006f).F(format.Z3).T(format.J3).E());
            this.f2895b[i] = t;
        }
    }
}
