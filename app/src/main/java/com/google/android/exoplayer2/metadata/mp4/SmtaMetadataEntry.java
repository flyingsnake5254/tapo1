package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.primitives.c;

/* loaded from: classes.dex */
public final class SmtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<SmtaMetadataEntry> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final float f2592c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2593d;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<SmtaMetadataEntry> {
        a() {
        }

        /* renamed from: a */
        public SmtaMetadataEntry createFromParcel(Parcel parcel) {
            return new SmtaMetadataEntry(parcel, (a) null);
        }

        /* renamed from: b */
        public SmtaMetadataEntry[] newArray(int i) {
            return new SmtaMetadataEntry[i];
        }
    }

    /* synthetic */ SmtaMetadataEntry(Parcel parcel, a aVar) {
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
        if (obj == null || SmtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
        return this.f2592c == smtaMetadataEntry.f2592c && this.f2593d == smtaMetadataEntry.f2593d;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format g() {
        return com.google.android.exoplayer2.metadata.a.b(this);
    }

    public int hashCode() {
        return ((527 + c.a(this.f2592c)) * 31) + this.f2593d;
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
        float f2 = this.f2592c;
        int i = this.f2593d;
        StringBuilder sb = new StringBuilder(73);
        sb.append("smta: captureFrameRate=");
        sb.append(f2);
        sb.append(", svcTemporalLayerCount=");
        sb.append(i);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f2592c);
        parcel.writeInt(this.f2593d);
    }

    public SmtaMetadataEntry(float f2, int i) {
        this.f2592c = f2;
        this.f2593d = i;
    }

    private SmtaMetadataEntry(Parcel parcel) {
        this.f2592c = parcel.readFloat();
        this.f2593d = parcel.readInt();
    }
}
