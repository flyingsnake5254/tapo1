package com.google.mlkit.common.sdkinternal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.i;

/* compiled from: com.google.mlkit:common@@16.0.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public abstract class g<T, S extends i> extends l {
    @KeepForSdk
    @WorkerThread
    public abstract T h(S s) throws MlKitException;
}
