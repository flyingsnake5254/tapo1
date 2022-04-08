package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzia<T> extends zzhz<T> {
    private final T zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzia(T t) {
        this.zza = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzia) {
            return this.zza.equals(((zzia) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    public final T zzb() {
        return this.zza;
    }
}
