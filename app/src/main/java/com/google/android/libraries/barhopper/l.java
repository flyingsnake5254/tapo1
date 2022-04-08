package com.google.android.libraries.barhopper;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.barhopper.Barcode;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes2.dex */
final class l implements Parcelable.Creator<Barcode.Sms> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.Sms createFromParcel(Parcel parcel) {
        return new Barcode.Sms(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.Sms[] newArray(int i) {
        return new Barcode.Sms[i];
    }
}
