package com.google.android.libraries.barhopper;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.barhopper.Barcode;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes2.dex */
final class h implements Parcelable.Creator<Barcode.FlightSegment> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.FlightSegment createFromParcel(Parcel parcel) {
        return new Barcode.FlightSegment(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.FlightSegment[] newArray(int i) {
        return new Barcode.FlightSegment[i];
    }
}
