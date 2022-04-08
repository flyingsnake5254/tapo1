package com.google.mlkit.vision.barcode.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
@SafeParcelable.Class(creator = "BarcodeScannerOptionsParcelCreator")
/* loaded from: classes2.dex */
public class BarcodeScannerOptionsParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BarcodeScannerOptionsParcel> CREATOR = new e();
    @SafeParcelable.Field(id = 1)

    /* renamed from: c  reason: collision with root package name */
    public final int f4992c;

    @SafeParcelable.Constructor
    public BarcodeScannerOptionsParcel(@SafeParcelable.Param(id = 1) int i) {
        this.f4992c = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f4992c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
