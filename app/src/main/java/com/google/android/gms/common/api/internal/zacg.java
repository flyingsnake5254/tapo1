package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zaj;

/* loaded from: classes.dex */
final class zacg implements Runnable {
    private final /* synthetic */ zaj zagr;
    private final /* synthetic */ zace zakk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zacg(zace zaceVar, zaj zajVar) {
        this.zakk = zaceVar;
        this.zagr = zajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zakk.zac(this.zagr);
    }
}
