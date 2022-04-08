package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    public final String f2560d;

    /* renamed from: f  reason: collision with root package name */
    public final int f2561f;
    public final int q;
    public final long x;
    public final long y;
    private final Id3Frame[] z;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<ChapterFrame> {
        a() {
        }

        /* renamed from: a */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        /* renamed from: b */
        public ChapterFrame[] newArray(int i) {
            return new ChapterFrame[i];
        }
    }

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f2560d = str;
        this.f2561f = i;
        this.q = i2;
        this.x = j;
        this.y = j2;
        this.z = id3FrameArr;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        return this.f2561f == chapterFrame.f2561f && this.q == chapterFrame.q && this.x == chapterFrame.x && this.y == chapterFrame.y && o0.b(this.f2560d, chapterFrame.f2560d) && Arrays.equals(this.z, chapterFrame.z);
    }

    public int hashCode() {
        int i = (((((((527 + this.f2561f) * 31) + this.q) * 31) + ((int) this.x)) * 31) + ((int) this.y)) * 31;
        String str = this.f2560d;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2560d);
        parcel.writeInt(this.f2561f);
        parcel.writeInt(this.q);
        parcel.writeLong(this.x);
        parcel.writeLong(this.y);
        parcel.writeInt(this.z.length);
        for (Id3Frame id3Frame : this.z) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f2560d = (String) o0.i(parcel.readString());
        this.f2561f = parcel.readInt();
        this.q = parcel.readInt();
        this.x = parcel.readLong();
        this.y = parcel.readLong();
        int readInt = parcel.readInt();
        this.z = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.z[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
