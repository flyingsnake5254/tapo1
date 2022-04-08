package com.google.mlkit.vision.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class e {
    private final Map<Class<?>, Provider<?>> a = new HashMap();

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static class a {
        private final Class<?> a;

        /* renamed from: b  reason: collision with root package name */
        private final Provider<?> f5010b;

        final Class<?> a() {
            return this.a;
        }

        final Provider<?> b() {
            return this.f5010b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Set<a> set) {
        for (a aVar : set) {
            this.a.put(aVar.a(), aVar.b());
        }
    }
}
