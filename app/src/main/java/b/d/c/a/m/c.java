package b.d.c.a.m;

import b.d.c.c.d;

/* compiled from: UserEngagementTimer.java */
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private static d f155b;

    private c(long j, long j2) {
        super(j, j2);
    }

    public static d f() {
        if (f155b == null) {
            synchronized (c.class) {
                if (f155b == null) {
                    f155b = new c(600000L, 1000L);
                }
            }
        }
        return f155b;
    }
}
