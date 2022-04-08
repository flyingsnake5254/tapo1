package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
@SafeParcelable.Class(creator = "LineBoxParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new zzag();
    @SafeParcelable.Field(id = 7)
    private final float zzdw;
    @SafeParcelable.Field(id = 8)
    public final String zzek;
    @SafeParcelable.Field(id = 2)
    public final zzao[] zzep;
    @SafeParcelable.Field(id = 3)
    public final zzab zzeq;
    @SafeParcelable.Field(id = 4)
    private final zzab zzer;
    @SafeParcelable.Field(id = 5)
    private final zzab zzes;
    @SafeParcelable.Field(id = 6)
    public final String zzet;
    @SafeParcelable.Field(id = 9)
    private final int zzeu;
    @SafeParcelable.Field(id = 10)
    public final boolean zzev;
    @SafeParcelable.Field(id = 11)
    public final int zzew;
    @SafeParcelable.Field(id = 12)
    public final int zzex;

    @SafeParcelable.Constructor
    public zzah(@SafeParcelable.Param(id = 2) zzao[] zzaoVarArr, @SafeParcelable.Param(id = 3) zzab zzabVar, @SafeParcelable.Param(id = 4) zzab zzabVar2, @SafeParcelable.Param(id = 5) zzab zzabVar3, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) float f2, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) int i, @SafeParcelable.Param(id = 10) boolean z, @SafeParcelable.Param(id = 11) int i2, @SafeParcelable.Param(id = 12) int i3) {
        this.zzep = zzaoVarArr;
        this.zzeq = zzabVar;
        this.zzer = zzabVar2;
        this.zzes = zzabVar3;
        this.zzet = str;
        this.zzdw = f2;
        this.zzek = str2;
        this.zzeu = i;
        this.zzev = z;
        this.zzew = i2;
        this.zzex = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzep, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzeq, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzer, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzes, i, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzet, false);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzdw);
        SafeParcelWriter.writeString(parcel, 8, this.zzek, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzeu);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzev);
        SafeParcelWriter.writeInt(parcel, 11, this.zzew);
        SafeParcelWriter.writeInt(parcel, 12, this.zzex);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
