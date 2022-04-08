package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.b;
import com.google.android.exoplayer2.o2.s;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.common.base.e;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: FlacMetadataReader.java */
/* loaded from: classes.dex */
public final class q {

    /* compiled from: FlacMetadataReader.java */
    /* loaded from: classes.dex */
    public static final class a {
        @Nullable
        public s a;

        public a(@Nullable s sVar) {
            this.a = sVar;
        }
    }

    public static boolean a(k kVar) throws IOException {
        d0 d0Var = new d0(4);
        kVar.n(d0Var.d(), 0, 4);
        return d0Var.F() == 1716281667;
    }

    public static int b(k kVar) throws IOException {
        kVar.e();
        d0 d0Var = new d0(2);
        kVar.n(d0Var.d(), 0, 2);
        int J = d0Var.J();
        if ((J >> 2) == 16382) {
            kVar.e();
            return J;
        }
        kVar.e();
        throw ParserException.createForMalformedContainer("First frame does not start with sync code.", null);
    }

    @Nullable
    public static Metadata c(k kVar, boolean z) throws IOException {
        Metadata a2 = new v().a(kVar, z ? null : b.a);
        if (a2 == null || a2.d() == 0) {
            return null;
        }
        return a2;
    }

    @Nullable
    public static Metadata d(k kVar, boolean z) throws IOException {
        kVar.e();
        long g = kVar.g();
        Metadata c2 = c(kVar, z);
        kVar.l((int) (kVar.g() - g));
        return c2;
    }

    public static boolean e(k kVar, a aVar) throws IOException {
        kVar.e();
        c0 c0Var = new c0(new byte[4]);
        kVar.n(c0Var.a, 0, 4);
        boolean g = c0Var.g();
        int h = c0Var.h(7);
        int h2 = c0Var.h(24) + 4;
        if (h == 0) {
            aVar.a = i(kVar);
        } else {
            s sVar = aVar.a;
            if (sVar == null) {
                throw new IllegalArgumentException();
            } else if (h == 3) {
                aVar.a = sVar.c(g(kVar, h2));
            } else if (h == 4) {
                aVar.a = sVar.d(k(kVar, h2));
            } else if (h == 6) {
                aVar.a = sVar.b(Collections.singletonList(f(kVar, h2)));
            } else {
                kVar.l(h2);
            }
        }
        return g;
    }

    private static PictureFrame f(k kVar, int i) throws IOException {
        d0 d0Var = new d0(i);
        kVar.readFully(d0Var.d(), 0, i);
        d0Var.Q(4);
        int n = d0Var.n();
        String B = d0Var.B(d0Var.n(), e.a);
        String A = d0Var.A(d0Var.n());
        int n2 = d0Var.n();
        int n3 = d0Var.n();
        int n4 = d0Var.n();
        int n5 = d0Var.n();
        int n6 = d0Var.n();
        byte[] bArr = new byte[n6];
        d0Var.j(bArr, 0, n6);
        return new PictureFrame(n, B, A, n2, n3, n4, n5, bArr);
    }

    private static s.a g(k kVar, int i) throws IOException {
        d0 d0Var = new d0(i);
        kVar.readFully(d0Var.d(), 0, i);
        return h(d0Var);
    }

    public static s.a h(d0 d0Var) {
        d0Var.Q(1);
        int G = d0Var.G();
        long e2 = d0Var.e() + G;
        int i = G / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long w = d0Var.w();
            if (w == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = w;
            jArr2[i2] = d0Var.w();
            d0Var.Q(2);
            i2++;
        }
        d0Var.Q((int) (e2 - d0Var.e()));
        return new s.a(jArr, jArr2);
    }

    private static s i(k kVar) throws IOException {
        byte[] bArr = new byte[38];
        kVar.readFully(bArr, 0, 38);
        return new s(bArr, 4);
    }

    public static void j(k kVar) throws IOException {
        d0 d0Var = new d0(4);
        kVar.readFully(d0Var.d(), 0, 4);
        if (d0Var.F() != 1716281667) {
            throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", null);
        }
    }

    private static List<String> k(k kVar, int i) throws IOException {
        d0 d0Var = new d0(i);
        kVar.readFully(d0Var.d(), 0, i);
        d0Var.Q(4);
        return Arrays.asList(d0.i(d0Var, false, false).f2657b);
    }
}
