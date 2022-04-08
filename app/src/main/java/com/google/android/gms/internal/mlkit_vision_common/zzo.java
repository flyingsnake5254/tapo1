package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final class zzo extends WeakReference<Throwable> {
    private final int zza;

    public zzo(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zza = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzo.class) {
            if (this == obj) {
                return true;
            }
            zzo zzoVar = (zzo) obj;
            if (this.zza == zzoVar.zza && get() == zzoVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }
}
