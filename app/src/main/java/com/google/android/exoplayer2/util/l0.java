package com.google.android.exoplayer2.util;

import androidx.annotation.GuardedBy;

/* compiled from: TimestampAdjuster.java */
/* loaded from: classes.dex */
public final class l0 {
    @GuardedBy("this")
    private long a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private long f3927b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private long f3928c;

    /* renamed from: d  reason: collision with root package name */
    private final ThreadLocal<Long> f3929d = new ThreadLocal<>();

    public l0(long j) {
        g(j);
    }

    public static long f(long j) {
        return (j * 1000000) / 90000;
    }

    public static long i(long j) {
        return (j * 90000) / 1000000;
    }

    public static long j(long j) {
        return i(j) % 8589934592L;
    }

    public synchronized long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f3927b == -9223372036854775807L) {
            long j2 = this.a;
            if (j2 == 9223372036854775806L) {
                j2 = ((Long) g.e(this.f3929d.get())).longValue();
            }
            this.f3927b = j2 - j;
            notifyAll();
        }
        this.f3928c = j;
        return j + this.f3927b;
    }

    public synchronized long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.f3928c;
        if (j2 != -9223372036854775807L) {
            long i = i(j2);
            long j3 = (4294967296L + i) / 8589934592L;
            long j4 = ((j3 - 1) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (Math.abs(j4 - i) < Math.abs(j - i)) {
                j = j4;
            }
        }
        return a(f(j));
    }

    public synchronized long c() {
        long j;
        j = this.a;
        if (j == Long.MAX_VALUE || j == 9223372036854775806L) {
            j = -9223372036854775807L;
        }
        return j;
    }

    public synchronized long d() {
        long j;
        long j2 = this.f3928c;
        if (j2 != -9223372036854775807L) {
            j = j2 + this.f3927b;
        } else {
            j = c();
        }
        return j;
    }

    public synchronized long e() {
        return this.f3927b;
    }

    public synchronized void g(long j) {
        this.a = j;
        this.f3927b = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f3928c = -9223372036854775807L;
    }

    public synchronized void h(boolean z, long j) throws InterruptedException {
        g.g(this.a == 9223372036854775806L);
        if (this.f3927b == -9223372036854775807L) {
            if (z) {
                this.f3929d.set(Long.valueOf(j));
            } else {
                while (this.f3927b == -9223372036854775807L) {
                    wait();
                }
            }
        }
    }
}
