package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.a.a;
import java.util.UUID;

/* compiled from: com.google.mlkit:common@@16.0.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class m {
    @KeepForSdk
    public static final Component<?> a = Component.builder(m.class).add(Dependency.required(j.class)).add(Dependency.required(Context.class)).factory(a0.a).build();

    /* renamed from: b  reason: collision with root package name */
    private final Context f4957b;

    private m(@NonNull Context context) {
        this.f4957b = context;
    }

    private final SharedPreferences e() {
        return this.f4957b.getSharedPreferences("com.google.mlkit.internal", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ m f(ComponentContainer componentContainer) {
        return new m((Context) componentContainer.get(Context.class));
    }

    @KeepForSdk
    public synchronized String a() {
        String string = e().getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        e().edit().putString("ml_sdk_instance_id", uuid).apply();
        return uuid;
    }

    @KeepForSdk
    public synchronized long b(@NonNull a aVar) {
        return e().getLong(String.format("downloading_begin_time_%s", aVar.c()), 0L);
    }

    @KeepForSdk
    public synchronized long c(@NonNull a aVar) {
        return e().getLong(String.format("model_first_use_time_%s", aVar.c()), 0L);
    }

    @KeepForSdk
    public synchronized void d(@NonNull a aVar, long j) {
        e().edit().putLong(String.format("model_first_use_time_%s", aVar.c()), j).apply();
    }
}
