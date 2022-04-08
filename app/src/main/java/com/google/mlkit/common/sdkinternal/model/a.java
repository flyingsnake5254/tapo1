package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.sdkinternal.j;

/* compiled from: com.google.mlkit:common@@16.0.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class a {
    private static final GmsLogger a = new GmsLogger("ModelFileHelper", "");
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    private static final String f4958b = String.format("com.google.mlkit.%s.models", "automl");
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    private static final String f4959c = String.format("com.google.mlkit.%s.models", "translate");
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    private static final String f4960d = String.format("com.google.mlkit.%s.models", "base");

    /* renamed from: e  reason: collision with root package name */
    private final j f4961e;

    public a(j jVar) {
        this.f4961e = jVar;
    }
}
