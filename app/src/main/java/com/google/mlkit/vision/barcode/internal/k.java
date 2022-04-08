package com.google.mlkit.vision.barcode.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_barcode.zzb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzd;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes2.dex */
public final class k extends zzb implements a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.barcode.internal.IBarcodeScanner");
    }

    @Override // com.google.mlkit.vision.barcode.internal.a
    public final IObjectWrapper a(IObjectWrapper iObjectWrapper, VisionImageMetadataParcel visionImageMetadataParcel) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, iObjectWrapper);
        zzd.zza(zza, visionImageMetadataParcel);
        Parcel zza2 = zza(2, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza2.readStrongBinder());
        zza2.recycle();
        return asInterface;
    }

    @Override // com.google.mlkit.vision.barcode.internal.a
    public final void a_() throws RemoteException {
        zzb(1, zza());
    }

    @Override // com.google.mlkit.vision.barcode.internal.a
    public final void zzb() throws RemoteException {
        zzb(3, zza());
    }
}
