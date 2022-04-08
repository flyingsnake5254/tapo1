package com.google.mlkit.vision.common.internal;

import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class h implements OnFailureListener {
    static final OnFailureListener a = new h();

    private h() {
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        MobileVisionBase.f5001c.e("MobileVisionBase", "Error preloading model resource", exc);
    }
}
