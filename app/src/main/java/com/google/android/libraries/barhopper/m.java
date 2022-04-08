package com.google.android.libraries.barhopper;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.barhopper.Barcode;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes2.dex */
final class m implements Parcelable.Creator<Barcode.UrlBookmark> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.UrlBookmark createFromParcel(Parcel parcel) {
        return new Barcode.UrlBookmark(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.UrlBookmark[] newArray(int i) {
        return new Barcode.UrlBookmark[i];
    }
}
