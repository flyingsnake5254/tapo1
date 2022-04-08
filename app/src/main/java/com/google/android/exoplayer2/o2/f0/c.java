package com.google.android.exoplayer2.o2.f0;

import com.google.android.exoplayer2.o2.b;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.p;
import com.google.android.exoplayer2.o2.s;
import java.io.IOException;
import java.util.Objects;

/* compiled from: FlacBinarySearchSeeker.java */
/* loaded from: classes.dex */
final class c extends com.google.android.exoplayer2.o2.b {

    /* compiled from: FlacBinarySearchSeeker.java */
    /* loaded from: classes.dex */
    private static final class b implements b.f {
        private final s a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2684b;

        /* renamed from: c  reason: collision with root package name */
        private final p.a f2685c;

        private long c(k kVar) throws IOException {
            while (kVar.g() < kVar.a() - 6 && !p.h(kVar, this.a, this.f2684b, this.f2685c)) {
                kVar.h(1);
            }
            if (kVar.g() < kVar.a() - 6) {
                return this.f2685c.a;
            }
            kVar.h((int) (kVar.a() - kVar.g()));
            return this.a.j;
        }

        @Override // com.google.android.exoplayer2.o2.b.f
        public b.e a(k kVar, long j) throws IOException {
            long position = kVar.getPosition();
            long c2 = c(kVar);
            long g = kVar.g();
            kVar.h(Math.max(6, this.a.f3065c));
            long c3 = c(kVar);
            long g2 = kVar.g();
            if (c2 <= j && c3 > j) {
                return b.e.e(g);
            }
            if (c3 <= j) {
                return b.e.f(c3, g2);
            }
            return b.e.d(c2, position);
        }

        @Override // com.google.android.exoplayer2.o2.b.f
        public /* synthetic */ void b() {
            com.google.android.exoplayer2.o2.c.a(this);
        }

        private b(s sVar, int i) {
            this.a = sVar;
            this.f2684b = i;
            this.f2685c = new p.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(final s sVar, int i, long j, long j2) {
        super(new b.d() { // from class: com.google.android.exoplayer2.o2.f0.b
            @Override // com.google.android.exoplayer2.o2.b.d
            public final long a(long j3) {
                return s.this.j(j3);
            }
        }, new b(sVar, i), sVar.g(), 0L, sVar.j, j, j2, sVar.e(), Math.max(6, sVar.f3065c));
        Objects.requireNonNull(sVar);
    }
}
