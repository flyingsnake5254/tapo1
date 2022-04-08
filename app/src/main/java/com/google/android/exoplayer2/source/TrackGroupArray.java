package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class TrackGroupArray implements Parcelable {

    /* renamed from: d  reason: collision with root package name */
    public final int f3161d;

    /* renamed from: f  reason: collision with root package name */
    private final TrackGroup[] f3162f;
    private int q;

    /* renamed from: c  reason: collision with root package name */
    public static final TrackGroupArray f3160c = new TrackGroupArray(new TrackGroup[0]);
    public static final Parcelable.Creator<TrackGroupArray> CREATOR = new a();

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<TrackGroupArray> {
        a() {
        }

        /* renamed from: a */
        public TrackGroupArray createFromParcel(Parcel parcel) {
            return new TrackGroupArray(parcel);
        }

        /* renamed from: b */
        public TrackGroupArray[] newArray(int i) {
            return new TrackGroupArray[i];
        }
    }

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f3162f = trackGroupArr;
        this.f3161d = trackGroupArr.length;
    }

    public TrackGroup a(int i) {
        return this.f3162f[i];
    }

    public int b(TrackGroup trackGroup) {
        for (int i = 0; i < this.f3161d; i++) {
            if (this.f3162f[i] == trackGroup) {
                return i;
            }
        }
        return -1;
    }

    public boolean c() {
        return this.f3161d == 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.f3161d == trackGroupArray.f3161d && Arrays.equals(this.f3162f, trackGroupArray.f3162f);
    }

    public int hashCode() {
        if (this.q == 0) {
            this.q = Arrays.hashCode(this.f3162f);
        }
        return this.q;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3161d);
        for (int i2 = 0; i2 < this.f3161d; i2++) {
            parcel.writeParcelable(this.f3162f[i2], 0);
        }
    }

    TrackGroupArray(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f3161d = readInt;
        this.f3162f = new TrackGroup[readInt];
        for (int i = 0; i < this.f3161d; i++) {
            this.f3162f[i] = (TrackGroup) parcel.readParcelable(TrackGroup.class.getClassLoader());
        }
    }
}
