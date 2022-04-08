package com.google.common.hash;

import com.tplink.iot.Utils.hls.c;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: Striped64.java */
/* loaded from: classes2.dex */
abstract class n extends Number {

    /* renamed from: c  reason: collision with root package name */
    static final ThreadLocal<int[]> f4690c = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    static final Random f4691d = new Random();

    /* renamed from: f  reason: collision with root package name */
    static final int f4692f = Runtime.getRuntime().availableProcessors();
    private static final Unsafe q;
    private static final long x;
    private static final long y;
    volatile transient long p0;
    volatile transient int p1;
    @NullableDecl
    volatile transient b[] z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Striped64.java */
    /* loaded from: classes2.dex */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        /* renamed from: a */
        public Unsafe run() throws Exception {
            Field[] declaredFields;
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    /* compiled from: Striped64.java */
    /* loaded from: classes2.dex */
    static final class b {
        private static final Unsafe a;

        /* renamed from: b  reason: collision with root package name */
        private static final long f4693b;

        /* renamed from: c  reason: collision with root package name */
        volatile long f4694c;

        static {
            try {
                Unsafe h = n.h();
                a = h;
                f4693b = h.objectFieldOffset(b.class.getDeclaredField(c.n));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        b(long j) {
            this.f4694c = j;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean a(long j, long j2) {
            return a.compareAndSwapLong(this, f4693b, j, j2);
        }
    }

    static {
        try {
            Unsafe h = h();
            q = h;
            x = h.objectFieldOffset(n.class.getDeclaredField("p0"));
            y = h.objectFieldOffset(n.class.getDeclaredField("p1"));
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe h() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d(long j, long j2) {
        return q.compareAndSwapLong(this, x, j, j2);
    }

    final boolean f() {
        return q.compareAndSwapInt(this, y, 0, 1);
    }

    abstract long g(long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(long r17, @org.checkerframework.checker.nullness.compatqual.NullableDecl int[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.n.i(long, int[], boolean):void");
    }
}
