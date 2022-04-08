package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f2559d;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<BinaryFrame> {
        a() {
        }

        /* renamed from: a */
        public BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        /* renamed from: b */
        public BinaryFrame[] newArray(int i) {
            return new BinaryFrame[i];
        }
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f2559d = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BinaryFrame.class != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        return this.f2568c.equals(binaryFrame.f2568c) && Arrays.equals(this.f2559d, binaryFrame.f2559d);
    }

    public int hashCode() {
        return ((527 + this.f2568c.hashCode()) * 31) + Arrays.hashCode(this.f2559d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2568c);
        parcel.writeByteArray(this.f2559d);
    }

    BinaryFrame(Parcel parcel) {
        super((String) o0.i(parcel.readString()));
        this.f2559d = (byte[]) o0.i(parcel.createByteArray());
    }
}
