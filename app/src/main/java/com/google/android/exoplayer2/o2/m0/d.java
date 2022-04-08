package com.google.android.exoplayer2.o2.m0;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.io.IOException;

/* compiled from: WavHeaderReader.java */
/* loaded from: classes.dex */
final class d {

    /* compiled from: WavHeaderReader.java */
    /* loaded from: classes.dex */
    private static final class a {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3058b;

        private a(int i, long j) {
            this.a = i;
            this.f3058b = j;
        }

        public static a a(k kVar, d0 d0Var) throws IOException {
            kVar.n(d0Var.d(), 0, 8);
            d0Var.P(0);
            return new a(d0Var.n(), d0Var.t());
        }
    }

    @Nullable
    public static c a(k kVar) throws IOException {
        byte[] bArr;
        g.e(kVar);
        d0 d0Var = new d0(16);
        if (a.a(kVar, d0Var).a != 1380533830) {
            return null;
        }
        kVar.n(d0Var.d(), 0, 4);
        d0Var.P(0);
        int n = d0Var.n();
        if (n != 1463899717) {
            StringBuilder sb = new StringBuilder(36);
            sb.append("Unsupported RIFF format: ");
            sb.append(n);
            u.c("WavHeaderReader", sb.toString());
            return null;
        }
        a a2 = a.a(kVar, d0Var);
        while (a2.a != 1718449184) {
            kVar.h((int) a2.f3058b);
            a2 = a.a(kVar, d0Var);
        }
        g.g(a2.f3058b >= 16);
        kVar.n(d0Var.d(), 0, 16);
        d0Var.P(0);
        int v = d0Var.v();
        int v2 = d0Var.v();
        int u = d0Var.u();
        int u2 = d0Var.u();
        int v3 = d0Var.v();
        int v4 = d0Var.v();
        int i = ((int) a2.f3058b) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            kVar.n(bArr2, 0, i);
            bArr = bArr2;
        } else {
            bArr = o0.f3937f;
        }
        return new c(v, v2, u, u2, v3, v4, bArr);
    }

    public static Pair<Long, Long> b(k kVar) throws IOException {
        g.e(kVar);
        kVar.e();
        d0 d0Var = new d0(8);
        a a2 = a.a(kVar, d0Var);
        while (true) {
            int i = a2.a;
            if (i != 1684108385) {
                if (!(i == 1380533830 || i == 1718449184)) {
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("Ignoring unknown WAV chunk: ");
                    sb.append(i);
                    u.h("WavHeaderReader", sb.toString());
                }
                long j = a2.f3058b + 8;
                int i2 = a2.a;
                if (i2 == 1380533830) {
                    j = 12;
                }
                if (j <= 2147483647L) {
                    kVar.l((int) j);
                    a2 = a.a(kVar, d0Var);
                } else {
                    StringBuilder sb2 = new StringBuilder(51);
                    sb2.append("Chunk is too large (~2GB+) to skip; id: ");
                    sb2.append(i2);
                    throw ParserException.createForUnsupportedContainerFeature(sb2.toString());
                }
            } else {
                kVar.l(8);
                long position = kVar.getPosition();
                long j2 = a2.f3058b + position;
                long a3 = kVar.a();
                if (a3 != -1 && j2 > a3) {
                    StringBuilder sb3 = new StringBuilder(69);
                    sb3.append("Data exceeds input length: ");
                    sb3.append(j2);
                    sb3.append(", ");
                    sb3.append(a3);
                    u.h("WavHeaderReader", sb3.toString());
                    j2 = a3;
                }
                return Pair.create(Long.valueOf(position), Long.valueOf(j2));
            }
        }
    }
}
