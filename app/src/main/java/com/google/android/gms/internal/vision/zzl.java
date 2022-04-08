package com.google.android.gms.internal.vision;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
/* loaded from: classes.dex */
public interface zzl extends IInterface {
    Barcode[] zza(IObjectWrapper iObjectWrapper, zzu zzuVar) throws RemoteException;

    Barcode[] zzb(IObjectWrapper iObjectWrapper, zzu zzuVar) throws RemoteException;

    void zzn() throws RemoteException;
}
