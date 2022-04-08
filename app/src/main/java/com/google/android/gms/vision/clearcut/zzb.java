package com.google.android.gms.vision.clearcut;

import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public final class zzb {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private long zzcc = Long.MIN_VALUE;
    private final long zzcb = Math.round(30000.0d);

    public zzb(double d2) {
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zzcc + this.zzcb > currentTimeMillis) {
                return false;
            }
            this.zzcc = currentTimeMillis;
            return true;
        }
    }
}
