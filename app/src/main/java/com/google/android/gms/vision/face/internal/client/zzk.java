package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzd;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
/* loaded from: classes.dex */
public final class zzk extends zzb implements zzi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzi
    public final zzh newFaceDetector(IObjectWrapper iObjectWrapper, zzf zzfVar) throws RemoteException {
        zzh zzhVar;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzd.zza(obtainAndWriteInterfaceToken, zzfVar);
        Parcel zza = zza(1, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzhVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            if (queryLocalInterface instanceof zzh) {
                zzhVar = (zzh) queryLocalInterface;
            } else {
                zzhVar = new zzj(readStrongBinder);
            }
        }
        zza.recycle();
        return zzhVar;
    }
}
