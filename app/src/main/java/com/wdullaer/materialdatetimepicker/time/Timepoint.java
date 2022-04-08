package com.wdullaer.materialdatetimepicker.time;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public class Timepoint implements Parcelable, Comparable<Timepoint> {
    public static final Parcelable.Creator<Timepoint> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private int f15324c;

    /* renamed from: d  reason: collision with root package name */
    private int f15325d;

    /* renamed from: f  reason: collision with root package name */
    private int f15326f;

    /* loaded from: classes3.dex */
    public enum TYPE {
        HOUR,
        MINUTE,
        SECOND
    }

    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<Timepoint> {
        a() {
        }

        /* renamed from: a */
        public Timepoint createFromParcel(Parcel parcel) {
            return new Timepoint(parcel);
        }

        /* renamed from: b */
        public Timepoint[] newArray(int i) {
            return new Timepoint[i];
        }
    }

    public Timepoint(Timepoint timepoint) {
        this(timepoint.f15324c, timepoint.f15325d, timepoint.f15326f);
    }

    /* renamed from: a */
    public int compareTo(@NonNull Timepoint timepoint) {
        return hashCode() - timepoint.hashCode();
    }

    @IntRange(from = 0, to = 23)
    public int b() {
        return this.f15324c;
    }

    @IntRange(from = 0, to = 59)
    public int c() {
        return this.f15325d;
    }

    @IntRange(from = 0, to = 59)
    public int d() {
        return this.f15326f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f15324c < 12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && hashCode() == ((Timepoint) obj).hashCode();
    }

    public boolean f() {
        return !e();
    }

    public void h() {
        int i = this.f15324c;
        if (i >= 12) {
            this.f15324c = i % 12;
        }
    }

    public int hashCode() {
        return l();
    }

    public void i() {
        int i = this.f15324c;
        if (i < 12) {
            this.f15324c = (i + 12) % 24;
        }
    }

    public int l() {
        return (this.f15324c * 3600) + (this.f15325d * 60) + this.f15326f;
    }

    public String toString() {
        return "" + this.f15324c + "h " + this.f15325d + "m " + this.f15326f + "s";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15324c);
        parcel.writeInt(this.f15325d);
        parcel.writeInt(this.f15326f);
    }

    public Timepoint(@IntRange(from = 0, to = 23) int i, @IntRange(from = 0, to = 59) int i2, @IntRange(from = 0, to = 59) int i3) {
        this.f15324c = i % 24;
        this.f15325d = i2 % 60;
        this.f15326f = i3 % 60;
    }

    public Timepoint(Parcel parcel) {
        this.f15324c = parcel.readInt();
        this.f15325d = parcel.readInt();
        this.f15326f = parcel.readInt();
    }
}
