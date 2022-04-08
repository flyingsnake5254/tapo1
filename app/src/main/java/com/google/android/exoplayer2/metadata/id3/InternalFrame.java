package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;

/* loaded from: classes.dex */
public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    public final String f2569d;

    /* renamed from: f  reason: collision with root package name */
    public final String f2570f;
    public final String q;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<InternalFrame> {
        a() {
        }

        /* renamed from: a */
        public InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }

        /* renamed from: b */
        public InternalFrame[] newArray(int i) {
            return new InternalFrame[i];
        }
    }

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.f2569d = str;
        this.f2570f = str2;
        this.q = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InternalFrame.class != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        return o0.b(this.f2570f, internalFrame.f2570f) && o0.b(this.f2569d, internalFrame.f2569d) && o0.b(this.q, internalFrame.q);
    }

    public int hashCode() {
        String str = this.f2569d;
        int i = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2570f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.q;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f2568c;
        String str2 = this.f2569d;
        String str3 = this.f2570f;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": domain=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2568c);
        parcel.writeString(this.f2569d);
        parcel.writeString(this.q);
    }

    InternalFrame(Parcel parcel) {
        super("----");
        this.f2569d = (String) o0.i(parcel.readString());
        this.f2570f = (String) o0.i(parcel.readString());
        this.q = (String) o0.i(parcel.readString());
    }
}
