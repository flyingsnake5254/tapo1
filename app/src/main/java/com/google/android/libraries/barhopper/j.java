package com.google.android.libraries.barhopper;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.barhopper.Barcode;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes2.dex */
final class j implements Parcelable.Creator<Barcode.PersonName> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.PersonName createFromParcel(Parcel parcel) {
        return new Barcode.PersonName(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.PersonName[] newArray(int i) {
        return new Barcode.PersonName[i];
    }
}
