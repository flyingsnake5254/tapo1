package com.google.mlkit.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzct;
import com.google.android.gms.internal.mlkit_common.zzcv;
import com.google.android.gms.internal.mlkit_common.zzcz;
import com.google.android.gms.internal.mlkit_common.zzdb;
import com.google.android.gms.internal.mlkit_common.zzdg;
import com.google.android.gms.internal.mlkit_common.zzl;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.a.b;
import com.google.mlkit.common.sdkinternal.d;
import com.google.mlkit.common.sdkinternal.j;
import com.google.mlkit.common.sdkinternal.k;
import com.google.mlkit.common.sdkinternal.m;
import com.google.mlkit.common.sdkinternal.model.a;
import java.util.List;

/* compiled from: com.google.mlkit:common@@16.0.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class CommonComponentRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return zzl.zza(zzdb.zza, m.a, zzdg.zza, zzcz.zza, zzcv.zza, zzct.zza, Component.builder(a.class).add(Dependency.required(j.class)).factory(b.a).build(), Component.builder(k.class).factory(a.a).build(), Component.builder(b.class).add(Dependency.setOf(b.a.class)).factory(d.a).build(), Component.builder(d.class).add(Dependency.requiredProvider(k.class)).factory(c.a).build(), Component.builder(com.google.mlkit.common.sdkinternal.a.class).factory(f.a).build(), Component.builder(com.google.mlkit.common.sdkinternal.b.class).add(Dependency.required(com.google.mlkit.common.sdkinternal.a.class)).add(Dependency.required(zzdb.class)).factory(e.a).build(), new Component[0]);
    }
}
