package com.google.android.gms.internal.vision;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzds extends zzdk<Map.Entry<K, V>> {
    private final /* synthetic */ zzdp zzmo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzds(zzdp zzdpVar) {
        this.zzmo = zzdpVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.zzmo.size;
        zzcy.zzd(i, i2);
        objArr = this.zzmo.zzmk;
        int i3 = i * 2;
        zzdp zzdpVar = this.zzmo;
        Object obj = objArr[i3];
        objArr2 = zzdpVar.zzmk;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i3 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zzmo.size;
        return i;
    }
}
