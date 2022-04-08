package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.o0;
import com.google.common.base.k;
import java.util.Arrays;
import java.util.List;

/* compiled from: MediaMetadata.java */
/* loaded from: classes.dex */
public final class m1 {
    public static final m1 a = new b().F();

    /* renamed from: b  reason: collision with root package name */
    public static final v0<m1> f2384b = f0.a;
    @Nullable
    public final CharSequence A;
    @Nullable
    public final CharSequence B;
    @Nullable
    public final CharSequence C;
    @Nullable
    public final Integer D;
    @Nullable
    public final Integer E;
    @Nullable
    public final CharSequence F;
    @Nullable
    public final CharSequence G;
    @Nullable
    public final Bundle H;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f2385c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final CharSequence f2386d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final CharSequence f2387e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final CharSequence f2388f;
    @Nullable
    public final CharSequence g;
    @Nullable
    public final CharSequence h;
    @Nullable
    public final CharSequence i;
    @Nullable
    public final Uri j;
    @Nullable
    public final z1 k;
    @Nullable
    public final z1 l;
    @Nullable
    public final byte[] m;
    @Nullable
    public final Integer n;
    @Nullable
    public final Uri o;
    @Nullable
    public final Integer p;
    @Nullable
    public final Integer q;
    @Nullable
    public final Integer r;
    @Nullable
    public final Boolean s;
    @Nullable
    @Deprecated
    public final Integer t;
    @Nullable
    public final Integer u;
    @Nullable
    public final Integer v;
    @Nullable
    public final Integer w;
    @Nullable
    public final Integer x;
    @Nullable
    public final Integer y;
    @Nullable
    public final Integer z;

    /* compiled from: MediaMetadata.java */
    /* loaded from: classes.dex */
    public static final class b {
        @Nullable
        private Integer A;
        @Nullable
        private Integer B;
        @Nullable
        private CharSequence C;
        @Nullable
        private CharSequence D;
        @Nullable
        private Bundle E;
        @Nullable
        private CharSequence a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f2389b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f2390c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f2391d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f2392e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private CharSequence f2393f;
        @Nullable
        private CharSequence g;
        @Nullable
        private Uri h;
        @Nullable
        private z1 i;
        @Nullable
        private z1 j;
        @Nullable
        private byte[] k;
        @Nullable
        private Integer l;
        @Nullable
        private Uri m;
        @Nullable
        private Integer n;
        @Nullable
        private Integer o;
        @Nullable
        private Integer p;
        @Nullable
        private Boolean q;
        @Nullable
        private Integer r;
        @Nullable
        private Integer s;
        @Nullable
        private Integer t;
        @Nullable
        private Integer u;
        @Nullable
        private Integer v;
        @Nullable
        private Integer w;
        @Nullable
        private CharSequence x;
        @Nullable
        private CharSequence y;
        @Nullable
        private CharSequence z;

        public m1 F() {
            return new m1(this);
        }

        public b G(byte[] bArr, int i) {
            if (this.k == null || o0.b(Integer.valueOf(i), 3) || !o0.b(this.l, 3)) {
                this.k = (byte[]) bArr.clone();
                this.l = Integer.valueOf(i);
            }
            return this;
        }

        public b H(Metadata metadata) {
            for (int i = 0; i < metadata.d(); i++) {
                metadata.c(i).j(this);
            }
            return this;
        }

        public b I(List<Metadata> list) {
            for (int i = 0; i < list.size(); i++) {
                Metadata metadata = list.get(i);
                for (int i2 = 0; i2 < metadata.d(); i2++) {
                    metadata.c(i2).j(this);
                }
            }
            return this;
        }

        public b J(@Nullable CharSequence charSequence) {
            this.f2391d = charSequence;
            return this;
        }

        public b K(@Nullable CharSequence charSequence) {
            this.f2390c = charSequence;
            return this;
        }

        public b L(@Nullable CharSequence charSequence) {
            this.f2389b = charSequence;
            return this;
        }

        public b M(@Nullable CharSequence charSequence) {
            this.y = charSequence;
            return this;
        }

        public b N(@Nullable CharSequence charSequence) {
            this.z = charSequence;
            return this;
        }

        public b O(@Nullable CharSequence charSequence) {
            this.g = charSequence;
            return this;
        }

        public b P(@IntRange(from = 1, to = 31) @Nullable Integer num) {
            this.t = num;
            return this;
        }

        public b Q(@IntRange(from = 1, to = 12) @Nullable Integer num) {
            this.s = num;
            return this;
        }

        public b R(@Nullable Integer num) {
            this.r = num;
            return this;
        }

        public b S(@IntRange(from = 1, to = 31) @Nullable Integer num) {
            this.w = num;
            return this;
        }

        public b T(@IntRange(from = 1, to = 12) @Nullable Integer num) {
            this.v = num;
            return this;
        }

        public b U(@Nullable Integer num) {
            this.u = num;
            return this;
        }

        public b V(@Nullable CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        public b W(@Nullable Integer num) {
            this.o = num;
            return this;
        }

        public b X(@Nullable Integer num) {
            this.n = num;
            return this;
        }

        public b Y(@Nullable CharSequence charSequence) {
            this.x = charSequence;
            return this;
        }

        public b() {
        }

        private b(m1 m1Var) {
            this.a = m1Var.f2385c;
            this.f2389b = m1Var.f2386d;
            this.f2390c = m1Var.f2387e;
            this.f2391d = m1Var.f2388f;
            this.f2392e = m1Var.g;
            this.f2393f = m1Var.h;
            this.g = m1Var.i;
            this.h = m1Var.j;
            this.i = m1Var.k;
            this.j = m1Var.l;
            this.k = m1Var.m;
            this.l = m1Var.n;
            this.m = m1Var.o;
            this.n = m1Var.p;
            this.o = m1Var.q;
            this.p = m1Var.r;
            this.q = m1Var.s;
            this.r = m1Var.u;
            this.s = m1Var.v;
            this.t = m1Var.w;
            this.u = m1Var.x;
            this.v = m1Var.y;
            this.w = m1Var.z;
            this.x = m1Var.A;
            this.y = m1Var.B;
            this.z = m1Var.C;
            this.A = m1Var.D;
            this.B = m1Var.E;
            this.C = m1Var.F;
            this.D = m1Var.G;
            this.E = m1Var.H;
        }
    }

    public b a() {
        return new b();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m1.class != obj.getClass()) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return o0.b(this.f2385c, m1Var.f2385c) && o0.b(this.f2386d, m1Var.f2386d) && o0.b(this.f2387e, m1Var.f2387e) && o0.b(this.f2388f, m1Var.f2388f) && o0.b(this.g, m1Var.g) && o0.b(this.h, m1Var.h) && o0.b(this.i, m1Var.i) && o0.b(this.j, m1Var.j) && o0.b(this.k, m1Var.k) && o0.b(this.l, m1Var.l) && Arrays.equals(this.m, m1Var.m) && o0.b(this.n, m1Var.n) && o0.b(this.o, m1Var.o) && o0.b(this.p, m1Var.p) && o0.b(this.q, m1Var.q) && o0.b(this.r, m1Var.r) && o0.b(this.s, m1Var.s) && o0.b(this.u, m1Var.u) && o0.b(this.v, m1Var.v) && o0.b(this.w, m1Var.w) && o0.b(this.x, m1Var.x) && o0.b(this.y, m1Var.y) && o0.b(this.z, m1Var.z) && o0.b(this.A, m1Var.A) && o0.b(this.B, m1Var.B) && o0.b(this.C, m1Var.C) && o0.b(this.D, m1Var.D) && o0.b(this.E, m1Var.E) && o0.b(this.F, m1Var.F) && o0.b(this.G, m1Var.G);
    }

    public int hashCode() {
        return k.b(this.f2385c, this.f2386d, this.f2387e, this.f2388f, this.g, this.h, this.i, this.j, this.k, this.l, Integer.valueOf(Arrays.hashCode(this.m)), this.n, this.o, this.p, this.q, this.r, this.s, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G);
    }

    private m1(b bVar) {
        this.f2385c = bVar.a;
        this.f2386d = bVar.f2389b;
        this.f2387e = bVar.f2390c;
        this.f2388f = bVar.f2391d;
        this.g = bVar.f2392e;
        this.h = bVar.f2393f;
        this.i = bVar.g;
        this.j = bVar.h;
        this.k = bVar.i;
        this.l = bVar.j;
        this.m = bVar.k;
        this.n = bVar.l;
        this.o = bVar.m;
        this.p = bVar.n;
        this.q = bVar.o;
        this.r = bVar.p;
        this.s = bVar.q;
        this.t = bVar.r;
        this.u = bVar.r;
        this.v = bVar.s;
        this.w = bVar.t;
        this.x = bVar.u;
        this.y = bVar.v;
        this.z = bVar.w;
        this.A = bVar.x;
        this.B = bVar.y;
        this.C = bVar.z;
        this.D = bVar.A;
        this.E = bVar.B;
        this.F = bVar.C;
        this.G = bVar.D;
        this.H = bVar.E;
    }
}
