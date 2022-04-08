package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzax extends ContentObserver {
    private final /* synthetic */ zzav zzfy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzax(zzav zzavVar, Handler handler) {
        super(null);
        this.zzfy = zzavVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zzfy.zzw();
    }
}
