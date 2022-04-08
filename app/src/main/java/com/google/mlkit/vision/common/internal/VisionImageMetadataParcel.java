package com.google.mlkit.vision.common.internal;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
@KeepForSdk
@SafeParcelable.Class(creator = "VisionImageMetadataParcelCreator")
/* loaded from: classes2.dex */
public class VisionImageMetadataParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VisionImageMetadataParcel> CREATOR = new j();
    @KeepForSdk
    @SafeParcelable.Field(id = 1)

    /* renamed from: c  reason: collision with root package name */
    public final int f5004c;
    @KeepForSdk
    @SafeParcelable.Field(id = 2)

    /* renamed from: d  reason: collision with root package name */
    public final int f5005d;
    @SafeParcelable.Field(id = 3)

    /* renamed from: f  reason: collision with root package name */
    private final int f5006f;
    @KeepForSdk
    @SafeParcelable.Field(id = 4)
    public final long q;
    @KeepForSdk
    @SafeParcelable.Field(id = 5)
    public final int x;

    @SafeParcelable.Constructor
    public VisionImageMetadataParcel(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) long j, @SafeParcelable.Param(id = 5) int i4) {
        this.f5004c = i;
        this.f5005d = i2;
        this.f5006f = i3;
        this.q = j;
        this.x = i4;
    }

    @Nullable
    @KeepForSdk
    public Matrix a() {
        if (this.x == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-this.f5004c) / 2.0f, (-this.f5005d) / 2.0f);
        matrix.postRotate(this.x * 90);
        boolean z = this.x % 2 != 0;
        matrix.postTranslate((z ? this.f5005d : this.f5004c) / 2.0f, (z ? this.f5004c : this.f5005d) / 2.0f);
        return matrix;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f5004c);
        SafeParcelWriter.writeInt(parcel, 2, this.f5005d);
        SafeParcelWriter.writeInt(parcel, 3, this.f5006f);
        SafeParcelWriter.writeLong(parcel, 4, this.q);
        SafeParcelWriter.writeInt(parcel, 5, this.x);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
