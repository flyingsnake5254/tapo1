package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.common.base.k;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public final class SlowMotionData implements Metadata.Entry {
    public static final Parcelable.Creator<SlowMotionData> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final List<Segment> f2588c;

    /* loaded from: classes.dex */
    public static final class Segment implements Parcelable {

        /* renamed from: d  reason: collision with root package name */
        public final long f2590d;

        /* renamed from: f  reason: collision with root package name */
        public final long f2591f;
        public final int q;

        /* renamed from: c  reason: collision with root package name */
        public static final Comparator<Segment> f2589c = a.f2594c;
        public static final Parcelable.Creator<Segment> CREATOR = new a();

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<Segment> {
            a() {
            }

            /* renamed from: a */
            public Segment createFromParcel(Parcel parcel) {
                return new Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            /* renamed from: b */
            public Segment[] newArray(int i) {
                return new Segment[i];
            }
        }

        public Segment(long j, long j2, int i) {
            g.a(j < j2);
            this.f2590d = j;
            this.f2591f = j2;
            this.q = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Segment.class != obj.getClass()) {
                return false;
            }
            Segment segment = (Segment) obj;
            return this.f2590d == segment.f2590d && this.f2591f == segment.f2591f && this.q == segment.q;
        }

        public int hashCode() {
            return k.b(Long.valueOf(this.f2590d), Long.valueOf(this.f2591f), Integer.valueOf(this.q));
        }

        public String toString() {
            return o0.A("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f2590d), Long.valueOf(this.f2591f), Integer.valueOf(this.q));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f2590d);
            parcel.writeLong(this.f2591f);
            parcel.writeInt(this.q);
        }
    }

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<SlowMotionData> {
        a() {
        }

        /* renamed from: a */
        public SlowMotionData createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Segment.class.getClassLoader());
            return new SlowMotionData(arrayList);
        }

        /* renamed from: b */
        public SlowMotionData[] newArray(int i) {
            return new SlowMotionData[i];
        }
    }

    public SlowMotionData(List<Segment> list) {
        this.f2588c = list;
        g.a(!a(list));
    }

    private static boolean a(List<Segment> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j = list.get(0).f2591f;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).f2590d < j) {
                return true;
            }
            j = list.get(i).f2591f;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.f2588c.equals(((SlowMotionData) obj).f2588c);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format g() {
        return com.google.android.exoplayer2.metadata.a.b(this);
    }

    public int hashCode() {
        return this.f2588c.hashCode();
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
        String valueOf = String.valueOf(this.f2588c);
        StringBuilder sb = new StringBuilder(valueOf.length() + 21);
        sb.append("SlowMotion: segments=");
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f2588c);
    }
}
