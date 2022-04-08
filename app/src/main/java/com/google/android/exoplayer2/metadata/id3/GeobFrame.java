package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    public final String f2566d;

    /* renamed from: f  reason: collision with root package name */
    public final String f2567f;
    public final String q;
    public final byte[] x;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<GeobFrame> {
        a() {
        }

        /* renamed from: a */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        /* renamed from: b */
        public GeobFrame[] newArray(int i) {
            return new GeobFrame[i];
        }
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f2566d = str;
        this.f2567f = str2;
        this.q = str3;
        this.x = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        return o0.b(this.f2566d, geobFrame.f2566d) && o0.b(this.f2567f, geobFrame.f2567f) && o0.b(this.q, geobFrame.q) && Arrays.equals(this.x, geobFrame.x);
    }

    public int hashCode() {
        String str = this.f2566d;
        int i = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2567f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.q;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode2 + i) * 31) + Arrays.hashCode(this.x);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f2568c;
        String str2 = this.f2566d;
        String str3 = this.f2567f;
        String str4 = this.q;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", filename=");
        sb.append(str3);
        sb.append(", description=");
        sb.append(str4);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2566d);
        parcel.writeString(this.f2567f);
        parcel.writeString(this.q);
        parcel.writeByteArray(this.x);
    }

    GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f2566d = (String) o0.i(parcel.readString());
        this.f2567f = (String) o0.i(parcel.readString());
        this.q = (String) o0.i(parcel.readString());
        this.x = (byte[]) o0.i(parcel.createByteArray());
    }
}
