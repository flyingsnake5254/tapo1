package com.google.mlkit.common.sdkinternal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@16.0.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class d {
    private final Provider<? extends Executor> a;

    public d(Provider<? extends Executor> provider) {
        this.a = provider;
    }

    @KeepForSdk
    public Executor a(@Nullable Executor executor) {
        return executor != null ? executor : (Executor) this.a.get();
    }
}
