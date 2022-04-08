package com.google.mlkit.vision.barcode.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes2.dex */
public final class e implements Parcelable.Creator<BarcodeScannerOptionsParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BarcodeScannerOptionsParcel createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 1) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new BarcodeScannerOptionsParcel(i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BarcodeScannerOptionsParcel[] newArray(int i) {
        return new BarcodeScannerOptionsParcel[i];
    }
}
