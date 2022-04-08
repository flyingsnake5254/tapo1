package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.v.g;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.w;

/* compiled from: Tasks.kt */
/* loaded from: classes4.dex */
public final class k {
    public static final long a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f16549b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f16550c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f16551d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f16552e;

    /* renamed from: f  reason: collision with root package name */
    public static final long f16553f;
    public static l g = f.a;

    static {
        long e2;
        int d2;
        int d3;
        int b2;
        int d4;
        int f2;
        int d5;
        long e3;
        e2 = w.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        a = e2;
        d2 = w.d("kotlinx.coroutines.scheduler.offload.threshold", 96, 0, 128, 4, null);
        f16549b = d2;
        d3 = w.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        f16550c = d3;
        b2 = g.b(u.a(), 2);
        d4 = w.d("kotlinx.coroutines.scheduler.core.pool.size", b2, 1, 0, 8, null);
        f16551d = d4;
        f2 = g.f(u.a() * 128, d4, 2097150);
        d5 = w.d("kotlinx.coroutines.scheduler.max.pool.size", f2, 0, 2097150, 4, null);
        f16552e = d5;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e3 = w.e("kotlinx.coroutines.scheduler.keep.alive.sec", 5L, 0L, 0L, 12, null);
        f16553f = timeUnit.toNanos(e3);
    }
}
