package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
@UsedByNative("wrapper.cc")
@SafeParcelable.Class(creator = "FaceParcelCreator")
/* loaded from: classes.dex */
public class FaceParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FaceParcel> CREATOR = new zzd();
    @SafeParcelable.Field(id = 3)
    public final float centerX;
    @SafeParcelable.Field(id = 4)
    public final float centerY;
    @SafeParcelable.Field(id = 6)
    public final float height;
    @SafeParcelable.Field(id = 2)
    public final int id;
    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(id = 5)
    public final float width;
    @SafeParcelable.Field(id = 10)
    public final float zzcm;
    @SafeParcelable.Field(id = 11)
    public final float zzcn;
    @SafeParcelable.Field(id = 12)
    public final float zzco;
    @SafeParcelable.Field(defaultValue = "-1.0f", id = 15)
    public final float zzcp;
    @SafeParcelable.Field(defaultValue = "3.4028235E38f", id = 7)
    public final float zzdh;
    @SafeParcelable.Field(defaultValue = "3.4028235E38f", id = 8)
    public final float zzdi;
    @SafeParcelable.Field(defaultValue = "3.4028235E38f", id = 14)
    public final float zzdj;
    @SafeParcelable.Field(id = 9)
    public final LandmarkParcel[] zzdk;
    @SafeParcelable.Field(id = 13)
    public final zza[] zzdl;

    @SafeParcelable.Constructor
    public FaceParcel(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) float f2, @SafeParcelable.Param(id = 4) float f3, @SafeParcelable.Param(id = 5) float f4, @SafeParcelable.Param(id = 6) float f5, @SafeParcelable.Param(id = 7) float f6, @SafeParcelable.Param(id = 8) float f7, @SafeParcelable.Param(id = 14) float f8, @SafeParcelable.Param(id = 9) LandmarkParcel[] landmarkParcelArr, @SafeParcelable.Param(id = 10) float f9, @SafeParcelable.Param(id = 11) float f10, @SafeParcelable.Param(id = 12) float f11, @SafeParcelable.Param(id = 13) zza[] zzaVarArr, @SafeParcelable.Param(id = 15) float f12) {
        this.versionCode = i;
        this.id = i2;
        this.centerX = f2;
        this.centerY = f3;
        this.width = f4;
        this.height = f5;
        this.zzdh = f6;
        this.zzdi = f7;
        this.zzdj = f8;
        this.zzdk = landmarkParcelArr;
        this.zzcm = f9;
        this.zzcn = f10;
        this.zzco = f11;
        this.zzdl = zzaVarArr;
        this.zzcp = f12;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.id);
        SafeParcelWriter.writeFloat(parcel, 3, this.centerX);
        SafeParcelWriter.writeFloat(parcel, 4, this.centerY);
        SafeParcelWriter.writeFloat(parcel, 5, this.width);
        SafeParcelWriter.writeFloat(parcel, 6, this.height);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzdh);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzdi);
        SafeParcelWriter.writeTypedArray(parcel, 9, this.zzdk, i, false);
        SafeParcelWriter.writeFloat(parcel, 10, this.zzcm);
        SafeParcelWriter.writeFloat(parcel, 11, this.zzcn);
        SafeParcelWriter.writeFloat(parcel, 12, this.zzco);
        SafeParcelWriter.writeTypedArray(parcel, 13, this.zzdl, i, false);
        SafeParcelWriter.writeFloat(parcel, 14, this.zzdj);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzcp);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @UsedByNative("wrapper.cc")
    public FaceParcel(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) float f2, @SafeParcelable.Param(id = 4) float f3, @SafeParcelable.Param(id = 5) float f4, @SafeParcelable.Param(id = 6) float f5, @SafeParcelable.Param(id = 7) float f6, @SafeParcelable.Param(id = 8) float f7, @SafeParcelable.Param(id = 9) LandmarkParcel[] landmarkParcelArr, @SafeParcelable.Param(id = 10) float f8, @SafeParcelable.Param(id = 11) float f9, @SafeParcelable.Param(id = 12) float f10) {
        this(i, i2, f2, f3, f4, f5, f6, f7, 0.0f, landmarkParcelArr, f8, f9, f10, new zza[0], -1.0f);
    }
}
