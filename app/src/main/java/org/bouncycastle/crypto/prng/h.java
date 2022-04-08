package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.prng.j.c;

/* loaded from: classes4.dex */
public class h {
    private final SecureRandom a;

    /* renamed from: b  reason: collision with root package name */
    private final e f17142b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f17143c;

    /* renamed from: d  reason: collision with root package name */
    private int f17144d;

    /* renamed from: e  reason: collision with root package name */
    private int f17145e;

    /* loaded from: classes4.dex */
    private static class a implements b {
        private final j a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f17146b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f17147c;

        /* renamed from: d  reason: collision with root package name */
        private final int f17148d;

        public a(j jVar, byte[] bArr, byte[] bArr2, int i) {
            this.a = jVar;
            this.f17146b = bArr;
            this.f17147c = bArr2;
            this.f17148d = i;
        }

        @Override // org.bouncycastle.crypto.prng.b
        public c a(d dVar) {
            return new org.bouncycastle.crypto.prng.j.a(this.a, this.f17148d, dVar, this.f17147c, this.f17146b);
        }
    }

    /* loaded from: classes4.dex */
    private static class b implements b {
        private final g a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f17149b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f17150c;

        /* renamed from: d  reason: collision with root package name */
        private final int f17151d;

        public b(g gVar, byte[] bArr, byte[] bArr2, int i) {
            this.a = gVar;
            this.f17149b = bArr;
            this.f17150c = bArr2;
            this.f17151d = i;
        }

        @Override // org.bouncycastle.crypto.prng.b
        public c a(d dVar) {
            return new org.bouncycastle.crypto.prng.j.b(this.a, this.f17151d, dVar, this.f17150c, this.f17149b);
        }
    }

    public h(SecureRandom secureRandom, boolean z) {
        this.f17144d = 256;
        this.f17145e = 256;
        this.a = secureRandom;
        this.f17142b = new a(secureRandom, z);
    }

    public h(e eVar) {
        this.f17144d = 256;
        this.f17145e = 256;
        this.a = null;
        this.f17142b = eVar;
    }

    public SP800SecureRandom a(j jVar, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.a, this.f17142b.get(this.f17145e), new a(jVar, bArr, this.f17143c, this.f17144d), z);
    }

    public SP800SecureRandom b(g gVar, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.a, this.f17142b.get(this.f17145e), new b(gVar, bArr, this.f17143c, this.f17144d), z);
    }

    public h c(byte[] bArr) {
        this.f17143c = bArr;
        return this;
    }
}
