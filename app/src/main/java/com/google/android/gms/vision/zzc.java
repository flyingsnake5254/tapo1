package com.google.android.gms.vision;

import android.util.SparseIntArray;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzc {
    private static final Object lock = new Object();
    @GuardedBy("lock")
    private static int zzba;
    @GuardedBy("lock")
    private final SparseIntArray zzbb = new SparseIntArray();
    @GuardedBy("lock")
    private final SparseIntArray zzbc = new SparseIntArray();

    public final int zzb(int i) {
        synchronized (lock) {
            int i2 = this.zzbb.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            int i3 = zzba;
            zzba = i3 + 1;
            this.zzbb.append(i, i3);
            this.zzbc.append(i3, i);
            return i3;
        }
    }

    public final int zzc(int i) {
        int i2;
        synchronized (lock) {
            i2 = this.zzbc.get(i);
        }
        return i2;
    }
}
