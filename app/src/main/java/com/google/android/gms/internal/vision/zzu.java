package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.Frame;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
@SafeParcelable.Class(creator = "FrameMetadataParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new zzt();
    @SafeParcelable.Field(id = 3)
    public int height;
    @SafeParcelable.Field(id = 4)
    public int id;
    @SafeParcelable.Field(id = 6)
    public int rotation;
    @SafeParcelable.Field(id = 2)
    public int width;
    @SafeParcelable.Field(id = 5)
    public long zzaz;

    public zzu() {
    }

    public static zzu zzd(Frame frame) {
        zzu zzuVar = new zzu();
        zzuVar.width = frame.getMetadata().getWidth();
        zzuVar.height = frame.getMetadata().getHeight();
        zzuVar.rotation = frame.getMetadata().getRotation();
        zzuVar.id = frame.getMetadata().getId();
        zzuVar.zzaz = frame.getMetadata().getTimestampMillis();
        return zzuVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.width);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.id);
        SafeParcelWriter.writeLong(parcel, 5, this.zzaz);
        SafeParcelWriter.writeInt(parcel, 6, this.rotation);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzu(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) long j, @SafeParcelable.Param(id = 6) int i4) {
        this.width = i;
        this.height = i2;
        this.id = i3;
        this.zzaz = j;
        this.rotation = i4;
    }
}
