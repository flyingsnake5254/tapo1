package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final int f2544c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2545d;

    /* renamed from: f  reason: collision with root package name */
    public final String f2546f;
    public final byte[] p0;
    public final int q;
    public final int x;
    public final int y;
    public final int z;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<PictureFrame> {
        a() {
        }

        /* renamed from: a */
        public PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }

        /* renamed from: b */
        public PictureFrame[] newArray(int i) {
            return new PictureFrame[i];
        }
    }

    public PictureFrame(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.f2544c = i;
        this.f2545d = str;
        this.f2546f = str2;
        this.q = i2;
        this.x = i3;
        this.y = i4;
        this.z = i5;
        this.p0 = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PictureFrame.class != obj.getClass()) {
            return false;
        }
        PictureFrame pictureFrame = (PictureFrame) obj;
        return this.f2544c == pictureFrame.f2544c && this.f2545d.equals(pictureFrame.f2545d) && this.f2546f.equals(pictureFrame.f2546f) && this.q == pictureFrame.q && this.x == pictureFrame.x && this.y == pictureFrame.y && this.z == pictureFrame.z && Arrays.equals(this.p0, pictureFrame.p0);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format g() {
        return com.google.android.exoplayer2.metadata.a.b(this);
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f2544c) * 31) + this.f2545d.hashCode()) * 31) + this.f2546f.hashCode()) * 31) + this.q) * 31) + this.x) * 31) + this.y) * 31) + this.z) * 31) + Arrays.hashCode(this.p0);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void j(m1.b bVar) {
        bVar.G(this.p0, this.f2544c);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] k() {
        return com.google.android.exoplayer2.metadata.a.a(this);
    }

    public String toString() {
        String str = this.f2545d;
        String str2 = this.f2546f;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(str2).length());
        sb.append("Picture: mimeType=");
        sb.append(str);
        sb.append(", description=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2544c);
        parcel.writeString(this.f2545d);
        parcel.writeString(this.f2546f);
        parcel.writeInt(this.q);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.z);
        parcel.writeByteArray(this.p0);
    }

    PictureFrame(Parcel parcel) {
        this.f2544c = parcel.readInt();
        this.f2545d = (String) o0.i(parcel.readString());
        this.f2546f = (String) o0.i(parcel.readString());
        this.q = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readInt();
        this.z = parcel.readInt();
        this.p0 = (byte[]) o0.i(parcel.createByteArray());
    }
}
