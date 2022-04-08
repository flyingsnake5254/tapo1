package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzdd<T> implements zzcz<T>, Serializable {
    @NullableDecl
    private final T zzlx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdd(@NullableDecl T t) {
        this.zzlx = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdd) {
            return zzct.equal(this.zzlx, ((zzdd) obj).zzlx);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzcz
    public final T get() {
        return this.zzlx;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzlx});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzlx);
        StringBuilder sb = new StringBuilder(valueOf.length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
