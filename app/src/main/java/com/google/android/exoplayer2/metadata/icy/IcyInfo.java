package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.g;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f2552c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f2553d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final String f2554f;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<IcyInfo> {
        a() {
        }

        /* renamed from: a */
        public IcyInfo createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }

        /* renamed from: b */
        public IcyInfo[] newArray(int i) {
            return new IcyInfo[i];
        }
    }

    public IcyInfo(byte[] bArr, @Nullable String str, @Nullable String str2) {
        this.f2552c = bArr;
        this.f2553d = str;
        this.f2554f = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f2552c, ((IcyInfo) obj).f2552c);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format g() {
        return com.google.android.exoplayer2.metadata.a.b(this);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f2552c);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void j(m1.b bVar) {
        String str = this.f2553d;
        if (str != null) {
            bVar.V(str);
        }
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] k() {
        return com.google.android.exoplayer2.metadata.a.a(this);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f2553d, this.f2554f, Integer.valueOf(this.f2552c.length));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.f2552c);
        parcel.writeString(this.f2553d);
        parcel.writeString(this.f2554f);
    }

    IcyInfo(Parcel parcel) {
        this.f2552c = (byte[]) g.e(parcel.createByteArray());
        this.f2553d = parcel.readString();
        this.f2554f = parcel.readString();
    }
}
