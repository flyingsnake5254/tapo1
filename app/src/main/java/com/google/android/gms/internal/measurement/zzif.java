package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzif {
    public static <T> zzib<T> zza(zzib<T> zzibVar) {
        if ((zzibVar instanceof zzid) || (zzibVar instanceof zzic)) {
            return zzibVar;
        }
        if (zzibVar instanceof Serializable) {
            return new zzic(zzibVar);
        }
        return new zzid(zzibVar);
    }

    public static <T> zzib<T> zzb(@NullableDecl T t) {
        return new zzie(t);
    }
}
