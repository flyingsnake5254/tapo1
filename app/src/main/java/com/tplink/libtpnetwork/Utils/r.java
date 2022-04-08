package com.tplink.libtpnetwork.Utils;

/* compiled from: SnowflakeIdWorker.java */
/* loaded from: classes3.dex */
public class r {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final long f14088b;

    /* renamed from: c  reason: collision with root package name */
    private final long f14089c;

    /* renamed from: d  reason: collision with root package name */
    private final long f14090d;

    /* renamed from: e  reason: collision with root package name */
    private final long f14091e;

    /* renamed from: f  reason: collision with root package name */
    private final long f14092f;
    private final long g;
    private final long h;
    private final long i;
    private final long j;
    private long k;
    private long l;
    private long m;
    private long n;

    /* compiled from: SnowflakeIdWorker.java */
    /* loaded from: classes3.dex */
    public static class b {
        private static final r a = new r(1, 1);

        public static long a() {
            return a.a();
        }
    }

    public synchronized long a() {
        long c2;
        c2 = c();
        long j = this.n;
        if (j == c2) {
            long j2 = (this.m + 1) & 4095;
            this.m = j2;
            if (j2 == 0) {
                c2 = b(j);
            }
        } else {
            this.m = 0L;
        }
        this.n = c2;
        return ((c2 - 1420041600000L) << 22) | (this.l << 17) | (this.k << 12) | this.m;
    }

    protected long b(long j) {
        long c2 = c();
        while (c2 <= j) {
            c2 = c();
        }
        return c2;
    }

    protected long c() {
        return System.currentTimeMillis();
    }

    private r(long j, long j2) {
        this.a = 1420041600000L;
        this.f14088b = 5L;
        this.f14089c = 5L;
        this.f14090d = 31L;
        this.f14091e = 31L;
        this.f14092f = 12L;
        this.g = 12L;
        this.h = 17L;
        this.i = 22L;
        this.j = 4095L;
        this.m = 0L;
        this.n = -1L;
        if (j > 31 || j < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", 31L));
        } else if (j2 > 31 || j2 < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", 31L));
        } else {
            this.k = j;
            this.l = j2;
        }
    }
}
