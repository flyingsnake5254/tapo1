package com.google.mlkit.common.a;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes2.dex */
public class b {
    private final Map<Class<? extends a>, Provider<?>> a = new HashMap();

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static class a {
        private final Class<? extends a> a;

        /* renamed from: b  reason: collision with root package name */
        private final Provider<?> f4939b;

        final Class<? extends a> a() {
            return this.a;
        }

        final Provider<?> b() {
            return this.f4939b;
        }
    }

    @KeepForSdk
    public b(Set<a> set) {
        for (a aVar : set) {
            this.a.put(aVar.a(), aVar.b());
        }
    }
}
