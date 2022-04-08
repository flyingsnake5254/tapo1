package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public abstract class zzdo<E> extends zzdh<E> implements Set<E> {
    @NullableDecl
    private transient zzdk<E> zzmi;

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return zzdt.zza(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzdt.zza(this);
    }

    @Override // com.google.android.gms.internal.vision.zzdh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    public zzdk<E> zzcd() {
        zzdk<E> zzdkVar = this.zzmi;
        if (zzdkVar != null) {
            return zzdkVar;
        }
        zzdk<E> zzci = zzci();
        this.zzmi = zzci;
        return zzci;
    }

    zzdk<E> zzci() {
        return zzdk.zza(toArray());
    }
}
