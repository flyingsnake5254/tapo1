package org.bouncycastle.jcajce.provider.drbg;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.bouncycastle.crypto.prng.SP800SecureRandom;
import org.bouncycastle.crypto.prng.h;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class DRBG {
    private static final String[][] a = {new String[]{"sun.security.provider.Sun", "sun.security.provider.SecureRandom"}, new String[]{"org.apache.harmony.security.provider.crypto.CryptoProvider", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl"}, new String[]{"com.android.org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLRandom"}, new String[]{"org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLRandom"}};

    /* renamed from: b  reason: collision with root package name */
    private static final Object[] f17375b = i();

    /* loaded from: classes4.dex */
    public static class Default extends SecureRandomSpi {
        private static final SecureRandom random = DRBG.e(true);

        @Override // java.security.SecureRandomSpi
        protected byte[] engineGenerateSeed(int i) {
            return random.generateSeed(i);
        }

        @Override // java.security.SecureRandomSpi
        protected void engineNextBytes(byte[] bArr) {
            random.nextBytes(bArr);
        }

        @Override // java.security.SecureRandomSpi
        protected void engineSetSeed(byte[] bArr) {
            random.setSeed(bArr);
        }
    }

    /* loaded from: classes4.dex */
    public static class NonceAndIV extends SecureRandomSpi {
        private static final SecureRandom random = DRBG.e(false);

        @Override // java.security.SecureRandomSpi
        protected byte[] engineGenerateSeed(int i) {
            return random.generateSeed(i);
        }

        @Override // java.security.SecureRandomSpi
        protected void engineNextBytes(byte[] bArr) {
            random.nextBytes(bArr);
        }

        @Override // java.security.SecureRandomSpi
        protected void engineSetSeed(byte[] bArr) {
            random.setSeed(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a implements PrivilegedAction<Boolean> {
        a() {
        }

        /* renamed from: a */
        public Boolean run() {
            try {
                boolean z = false;
                if (SecureRandom.class.getMethod("getInstanceStrong", new Class[0]) != null) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b implements PrivilegedAction<SecureRandom> {
        b() {
        }

        /* renamed from: a */
        public SecureRandom run() {
            try {
                return (SecureRandom) SecureRandom.class.getMethod("getInstanceStrong", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
                return DRBG.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class c implements PrivilegedAction<org.bouncycastle.crypto.prng.e> {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        /* renamed from: a */
        public org.bouncycastle.crypto.prng.e run() {
            try {
                return (org.bouncycastle.crypto.prng.e) org.bouncycastle.jcajce.provider.symmetric.util.a.a(DRBG.class, this.a).newInstance();
            } catch (Exception e2) {
                throw new IllegalStateException("entropy source " + this.a + " not created: " + e2.getMessage(), e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class d extends SecureRandom {
        d() {
            super((SecureRandomSpi) DRBG.f17375b[1], (Provider) DRBG.f17375b[0]);
        }
    }

    /* loaded from: classes4.dex */
    private static class e extends Provider {
        protected e() {
            super("BCHEP", 1.0d, "Bouncy Castle Hybrid Entropy Provider");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f extends SecureRandom {

        /* renamed from: c  reason: collision with root package name */
        private final AtomicBoolean f17376c = new AtomicBoolean(false);

        /* renamed from: d  reason: collision with root package name */
        private final AtomicInteger f17377d = new AtomicInteger(0);

        /* renamed from: f  reason: collision with root package name */
        private final SecureRandom f17378f;
        private final SP800SecureRandom q;

        /* loaded from: classes4.dex */
        class a implements org.bouncycastle.crypto.prng.e {
            a() {
            }

            @Override // org.bouncycastle.crypto.prng.e
            public org.bouncycastle.crypto.prng.d get(int i) {
                return new b(i);
            }
        }

        /* loaded from: classes4.dex */
        private class b implements org.bouncycastle.crypto.prng.d {
            private final int a;

            /* renamed from: b  reason: collision with root package name */
            private final AtomicReference f17379b = new AtomicReference();

            /* renamed from: c  reason: collision with root package name */
            private final AtomicBoolean f17380c = new AtomicBoolean(false);

            /* loaded from: classes4.dex */
            private class a implements Runnable {

                /* renamed from: c  reason: collision with root package name */
                private final int f17382c;

                a(int i) {
                    this.f17382c = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.this.f17379b.set(f.this.f17378f.generateSeed(this.f17382c));
                    f.this.f17376c.set(true);
                }
            }

            b(int i) {
                this.a = (i + 7) / 8;
            }

            @Override // org.bouncycastle.crypto.prng.d
            public byte[] a() {
                byte[] bArr = (byte[]) this.f17379b.getAndSet(null);
                if (bArr == null || bArr.length != this.a) {
                    bArr = f.this.f17378f.generateSeed(this.a);
                } else {
                    this.f17380c.set(false);
                }
                if (!this.f17380c.getAndSet(true)) {
                    new Thread(new a(this.a)).start();
                }
                return bArr;
            }

            @Override // org.bouncycastle.crypto.prng.d
            public int b() {
                return this.a * 8;
            }
        }

        f() {
            super(null, new e());
            SecureRandom h = DRBG.h();
            this.f17378f = h;
            this.q = new h(new a()).c(i.e("Bouncy Castle Hybrid Entropy Source")).a(new org.bouncycastle.crypto.t.b(new org.bouncycastle.crypto.p.i()), h.generateSeed(32), false);
        }

        @Override // java.security.SecureRandom
        public byte[] generateSeed(int i) {
            byte[] bArr = new byte[i];
            if (this.f17377d.getAndIncrement() > 20 && this.f17376c.getAndSet(false)) {
                this.f17377d.set(0);
                this.q.reseed(null);
            }
            this.q.nextBytes(bArr);
            return bArr;
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void setSeed(long j) {
            SP800SecureRandom sP800SecureRandom = this.q;
            if (sP800SecureRandom != null) {
                sP800SecureRandom.setSeed(j);
            }
        }

        @Override // java.security.SecureRandom
        public void setSeed(byte[] bArr) {
            SP800SecureRandom sP800SecureRandom = this.q;
            if (sP800SecureRandom != null) {
                sP800SecureRandom.setSeed(bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class g extends SecureRandom {

        /* renamed from: c  reason: collision with root package name */
        private final InputStream f17384c;

        /* loaded from: classes4.dex */
        class a implements PrivilegedAction<InputStream> {
            final /* synthetic */ URL a;

            a(URL url) {
                this.a = url;
            }

            /* renamed from: a */
            public InputStream run() {
                try {
                    return this.a.openStream();
                } catch (IOException unused) {
                    throw new InternalError("unable to open random source");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class b implements PrivilegedAction<Integer> {
            final /* synthetic */ byte[] a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f17386b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f17387c;

            b(byte[] bArr, int i, int i2) {
                this.a = bArr;
                this.f17386b = i;
                this.f17387c = i2;
            }

            /* renamed from: a */
            public Integer run() {
                try {
                    return Integer.valueOf(g.this.f17384c.read(this.a, this.f17386b, this.f17387c));
                } catch (IOException unused) {
                    throw new InternalError("unable to read random source");
                }
            }
        }

        g(URL url) {
            super(null, new e());
            this.f17384c = (InputStream) AccessController.doPrivileged(new a(url));
        }

        private int b(byte[] bArr, int i, int i2) {
            return ((Integer) AccessController.doPrivileged(new b(bArr, i, i2))).intValue();
        }

        @Override // java.security.SecureRandom
        public byte[] generateSeed(int i) {
            byte[] bArr;
            synchronized (this) {
                bArr = new byte[i];
                int i2 = 0;
                while (i2 != i) {
                    int b2 = b(bArr, i2, i - i2);
                    if (b2 <= -1) {
                        break;
                    }
                    i2 += b2;
                }
                if (i2 != i) {
                    throw new InternalError("unable to fully read random source");
                }
            }
            return bArr;
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void setSeed(long j) {
        }

        @Override // java.security.SecureRandom
        public void setSeed(byte[] bArr) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom e(boolean z) {
        if (System.getProperty("org.bouncycastle.drbg.entropysource") != null) {
            org.bouncycastle.crypto.prng.e g2 = g();
            org.bouncycastle.crypto.prng.d dVar = g2.get(128);
            byte[] a2 = dVar.a();
            return new h(g2).c(z ? j(a2) : k(a2)).b(new org.bouncycastle.crypto.p.i(), org.bouncycastle.util.a.l(dVar.a(), dVar.a()), z);
        }
        f fVar = new f();
        byte[] generateSeed = fVar.generateSeed(16);
        return new h(fVar, true).c(z ? j(generateSeed) : k(generateSeed)).b(new org.bouncycastle.crypto.p.i(), fVar.generateSeed(32), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom f() {
        if (f17375b != null) {
            return new d();
        }
        try {
            return new g(new URL(Security.getProperty("securerandom.source")));
        } catch (Exception unused) {
            return new SecureRandom();
        }
    }

    private static org.bouncycastle.crypto.prng.e g() {
        return (org.bouncycastle.crypto.prng.e) AccessController.doPrivileged(new c(System.getProperty("org.bouncycastle.drbg.entropysource")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom h() {
        return ((Boolean) AccessController.doPrivileged(new a())).booleanValue() ? (SecureRandom) AccessController.doPrivileged(new b()) : f();
    }

    private static final Object[] i() {
        int i = 0;
        while (true) {
            String[][] strArr = a;
            if (i >= strArr.length) {
                return null;
            }
            String[] strArr2 = strArr[i];
            try {
                return new Object[]{Class.forName(strArr2[0]).newInstance(), Class.forName(strArr2[1]).newInstance()};
            } catch (Throwable unused) {
                i++;
            }
        }
    }

    private static byte[] j(byte[] bArr) {
        return org.bouncycastle.util.a.n(i.e("Default"), bArr, org.bouncycastle.util.f.n(Thread.currentThread().getId()), org.bouncycastle.util.f.n(System.currentTimeMillis()));
    }

    private static byte[] k(byte[] bArr) {
        return org.bouncycastle.util.a.n(i.e("Nonce"), bArr, org.bouncycastle.util.f.q(Thread.currentThread().getId()), org.bouncycastle.util.f.q(System.currentTimeMillis()));
    }
}
