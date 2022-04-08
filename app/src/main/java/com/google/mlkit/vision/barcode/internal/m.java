package com.google.mlkit.vision.barcode.internal;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes2.dex */
public interface m extends IInterface {
    a newBarcodeScanner(BarcodeScannerOptionsParcel barcodeScannerOptionsParcel) throws RemoteException;
}
