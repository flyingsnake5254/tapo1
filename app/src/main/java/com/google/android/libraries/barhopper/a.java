package com.google.android.libraries.barhopper;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.barhopper.Barcode;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes2.dex */
final class a implements Parcelable.Creator<Barcode.Address> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.Address createFromParcel(Parcel parcel) {
        return new Barcode.Address(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.Address[] newArray(int i) {
        return new Barcode.Address[i];
    }
}
