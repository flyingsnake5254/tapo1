package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    public final String f2557d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final String f2558f;
    public final int q;
    public final byte[] x;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<ApicFrame> {
        a() {
        }

        /* renamed from: a */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        /* renamed from: b */
        public ApicFrame[] newArray(int i) {
            return new ApicFrame[i];
        }
    }

    public ApicFrame(String str, @Nullable String str2, int i, byte[] bArr) {
        super("APIC");
        this.f2557d = str;
        this.f2558f = str2;
        this.q = i;
        this.x = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.q == apicFrame.q && o0.b(this.f2557d, apicFrame.f2557d) && o0.b(this.f2558f, apicFrame.f2558f) && Arrays.equals(this.x, apicFrame.x);
    }

    public int hashCode() {
        int i = (527 + this.q) * 31;
        String str = this.f2557d;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2558f;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + Arrays.hashCode(this.x);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, com.google.android.exoplayer2.metadata.Metadata.Entry
    public void j(m1.b bVar) {
        bVar.G(this.x, this.q);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f2568c;
        String str2 = this.f2557d;
        String str3 = this.f2558f;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2557d);
        parcel.writeString(this.f2558f);
        parcel.writeInt(this.q);
        parcel.writeByteArray(this.x);
    }

    ApicFrame(Parcel parcel) {
        super("APIC");
        this.f2557d = (String) o0.i(parcel.readString());
        this.f2558f = parcel.readString();
        this.q = parcel.readInt();
        this.x = (byte[]) o0.i(parcel.createByteArray());
    }
}
