package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbp extends zzbm implements zzbr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbp(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbr
    public final Bundle zzd(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        Parcel zzC = zzC(1, zza);
        Bundle bundle2 = (Bundle) zzbo.zzc(zzC, Bundle.CREATOR);
        zzC.recycle();
        return bundle2;
    }
}
