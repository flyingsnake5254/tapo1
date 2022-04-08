package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    public final int f2571d;

    /* renamed from: f  reason: collision with root package name */
    public final int f2572f;
    public final int q;
    public final int[] x;
    public final int[] y;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<MlltFrame> {
        a() {
        }

        /* renamed from: a */
        public MlltFrame createFromParcel(Parcel parcel) {
            return new MlltFrame(parcel);
        }

        /* renamed from: b */
        public MlltFrame[] newArray(int i) {
            return new MlltFrame[i];
        }
    }

    public MlltFrame(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f2571d = i;
        this.f2572f = i2;
        this.q = i3;
        this.x = iArr;
        this.y = iArr2;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MlltFrame.class != obj.getClass()) {
            return false;
        }
        MlltFrame mlltFrame = (MlltFrame) obj;
        return this.f2571d == mlltFrame.f2571d && this.f2572f == mlltFrame.f2572f && this.q == mlltFrame.q && Arrays.equals(this.x, mlltFrame.x) && Arrays.equals(this.y, mlltFrame.y);
    }

    public int hashCode() {
        return ((((((((527 + this.f2571d) * 31) + this.f2572f) * 31) + this.q) * 31) + Arrays.hashCode(this.x)) * 31) + Arrays.hashCode(this.y);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2571d);
        parcel.writeInt(this.f2572f);
        parcel.writeInt(this.q);
        parcel.writeIntArray(this.x);
        parcel.writeIntArray(this.y);
    }

    MlltFrame(Parcel parcel) {
        super("MLLT");
        this.f2571d = parcel.readInt();
        this.f2572f = parcel.readInt();
        this.q = parcel.readInt();
        this.x = (int[]) o0.i(parcel.createIntArray());
        this.y = (int[]) o0.i(parcel.createIntArray());
    }
}
