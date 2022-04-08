package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new a();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String f3236c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f3237d;

    /* renamed from: f  reason: collision with root package name */
    public final List<VariantInfo> f3238f;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<HlsTrackMetadataEntry> {
        a() {
        }

        /* renamed from: a */
        public HlsTrackMetadataEntry createFromParcel(Parcel parcel) {
            return new HlsTrackMetadataEntry(parcel);
        }

        /* renamed from: b */
        public HlsTrackMetadataEntry[] newArray(int i) {
            return new HlsTrackMetadataEntry[i];
        }
    }

    public HlsTrackMetadataEntry(@Nullable String str, @Nullable String str2, List<VariantInfo> list) {
        this.f3236c = str;
        this.f3237d = str2;
        this.f3238f = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HlsTrackMetadataEntry.class != obj.getClass()) {
            return false;
        }
        HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
        return TextUtils.equals(this.f3236c, hlsTrackMetadataEntry.f3236c) && TextUtils.equals(this.f3237d, hlsTrackMetadataEntry.f3237d) && this.f3238f.equals(hlsTrackMetadataEntry.f3238f);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format g() {
        return com.google.android.exoplayer2.metadata.a.b(this);
    }

    public int hashCode() {
        String str = this.f3236c;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3237d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.f3238f.hashCode();
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
        String str;
        String str2 = this.f3236c;
        if (str2 != null) {
            String str3 = this.f3237d;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 5 + String.valueOf(str3).length());
            sb.append(" [");
            sb.append(str2);
            sb.append(", ");
            sb.append(str3);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "";
        }
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? "HlsTrackMetadataEntry".concat(valueOf) : new String("HlsTrackMetadataEntry");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3236c);
        parcel.writeString(this.f3237d);
        int size = this.f3238f.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable(this.f3238f.get(i2), 0);
        }
    }

    HlsTrackMetadataEntry(Parcel parcel) {
        this.f3236c = parcel.readString();
        this.f3237d = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((VariantInfo) parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.f3238f = Collections.unmodifiableList(arrayList);
    }

    /* loaded from: classes.dex */
    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public final int f3239c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3240d;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final String f3241f;
        @Nullable
        public final String q;
        @Nullable
        public final String x;
        @Nullable
        public final String y;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<VariantInfo> {
            a() {
            }

            /* renamed from: a */
            public VariantInfo createFromParcel(Parcel parcel) {
                return new VariantInfo(parcel);
            }

            /* renamed from: b */
            public VariantInfo[] newArray(int i) {
                return new VariantInfo[i];
            }
        }

        public VariantInfo(int i, int i2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.f3239c = i;
            this.f3240d = i2;
            this.f3241f = str;
            this.q = str2;
            this.x = str3;
            this.y = str4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VariantInfo.class != obj.getClass()) {
                return false;
            }
            VariantInfo variantInfo = (VariantInfo) obj;
            return this.f3239c == variantInfo.f3239c && this.f3240d == variantInfo.f3240d && TextUtils.equals(this.f3241f, variantInfo.f3241f) && TextUtils.equals(this.q, variantInfo.q) && TextUtils.equals(this.x, variantInfo.x) && TextUtils.equals(this.y, variantInfo.y);
        }

        public int hashCode() {
            int i = ((this.f3239c * 31) + this.f3240d) * 31;
            String str = this.f3241f;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.q;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.x;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.y;
            if (str4 != null) {
                i2 = str4.hashCode();
            }
            return hashCode3 + i2;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3239c);
            parcel.writeInt(this.f3240d);
            parcel.writeString(this.f3241f);
            parcel.writeString(this.q);
            parcel.writeString(this.x);
            parcel.writeString(this.y);
        }

        VariantInfo(Parcel parcel) {
            this.f3239c = parcel.readInt();
            this.f3240d = parcel.readInt();
            this.f3241f = parcel.readString();
            this.q = parcel.readString();
            this.x = parcel.readString();
            this.y = parcel.readString();
        }
    }
}
