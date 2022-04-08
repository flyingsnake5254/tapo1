package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.primitives.e;

/* loaded from: classes.dex */
public final class MotionPhotoMetadata implements Metadata.Entry {
    public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final long f2585c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2586d;

    /* renamed from: f  reason: collision with root package name */
    public final long f2587f;
    public final long q;
    public final long x;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<MotionPhotoMetadata> {
        a() {
        }

        /* renamed from: a */
        public MotionPhotoMetadata createFromParcel(Parcel parcel) {
            return new MotionPhotoMetadata(parcel, null);
        }

        /* renamed from: b */
        public MotionPhotoMetadata[] newArray(int i) {
            return new MotionPhotoMetadata[i];
        }
    }

    /* synthetic */ MotionPhotoMetadata(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MotionPhotoMetadata.class != obj.getClass()) {
            return false;
        }
        MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
        return this.f2585c == motionPhotoMetadata.f2585c && this.f2586d == motionPhotoMetadata.f2586d && this.f2587f == motionPhotoMetadata.f2587f && this.q == motionPhotoMetadata.q && this.x == motionPhotoMetadata.x;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format g() {
        return com.google.android.exoplayer2.metadata.a.b(this);
    }

    public int hashCode() {
        return ((((((((527 + e.e(this.f2585c)) * 31) + e.e(this.f2586d)) * 31) + e.e(this.f2587f)) * 31) + e.e(this.q)) * 31) + e.e(this.x);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void j(m1.b bVar) {
        com.google.android.exoplayer2.metadata.a.c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] k() {
        return com.google.android.exoplayer2.metadata.a.a(this);
    }

    public String toString() {
        long j = this.f2585c;
        long j2 = this.f2586d;
        long j3 = this.f2587f;
        long j4 = this.q;
        long j5 = this.x;
        StringBuilder sb = new StringBuilder(218);
        sb.append("Motion photo metadata: photoStartPosition=");
        sb.append(j);
        sb.append(", photoSize=");
        sb.append(j2);
        sb.append(", photoPresentationTimestampUs=");
        sb.append(j3);
        sb.append(", videoStartPosition=");
        sb.append(j4);
        sb.append(", videoSize=");
        sb.append(j5);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f2585c);
        parcel.writeLong(this.f2586d);
        parcel.writeLong(this.f2587f);
        parcel.writeLong(this.q);
        parcel.writeLong(this.x);
    }

    public MotionPhotoMetadata(long j, long j2, long j3, long j4, long j5) {
        this.f2585c = j;
        this.f2586d = j2;
        this.f2587f = j3;
        this.q = j4;
        this.x = j5;
    }

    private MotionPhotoMetadata(Parcel parcel) {
        this.f2585c = parcel.readLong();
        this.f2586d = parcel.readLong();
        this.f2587f = parcel.readLong();
        this.q = parcel.readLong();
        this.x = parcel.readLong();
    }
}
