package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private final SchemeData[] f2202c;

    /* renamed from: d  reason: collision with root package name */
    private int f2203d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final String f2204f;
    public final int q;

    /* loaded from: classes.dex */
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        private int f2205c;

        /* renamed from: d  reason: collision with root package name */
        public final UUID f2206d;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final String f2207f;
        public final String q;
        @Nullable
        public final byte[] x;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<SchemeData> {
            a() {
            }

            /* renamed from: a */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            /* renamed from: b */
            public SchemeData[] newArray(int i) {
                return new SchemeData[i];
            }
        }

        public SchemeData(UUID uuid, String str, @Nullable byte[] bArr) {
            this(uuid, null, str, bArr);
        }

        public SchemeData a(@Nullable byte[] bArr) {
            return new SchemeData(this.f2206d, this.f2207f, this.q, bArr);
        }

        public boolean b() {
            return this.x != null;
        }

        public boolean c(UUID uuid) {
            return w0.a.equals(this.f2206d) || uuid.equals(this.f2206d);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return o0.b(this.f2207f, schemeData.f2207f) && o0.b(this.q, schemeData.q) && o0.b(this.f2206d, schemeData.f2206d) && Arrays.equals(this.x, schemeData.x);
        }

        public int hashCode() {
            if (this.f2205c == 0) {
                int hashCode = this.f2206d.hashCode() * 31;
                String str = this.f2207f;
                this.f2205c = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.q.hashCode()) * 31) + Arrays.hashCode(this.x);
            }
            return this.f2205c;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f2206d.getMostSignificantBits());
            parcel.writeLong(this.f2206d.getLeastSignificantBits());
            parcel.writeString(this.f2207f);
            parcel.writeString(this.q);
            parcel.writeByteArray(this.x);
        }

        public SchemeData(UUID uuid, @Nullable String str, String str2, @Nullable byte[] bArr) {
            this.f2206d = (UUID) g.e(uuid);
            this.f2207f = str;
            this.q = (String) g.e(str2);
            this.x = bArr;
        }

        SchemeData(Parcel parcel) {
            this.f2206d = new UUID(parcel.readLong(), parcel.readLong());
            this.f2207f = parcel.readString();
            this.q = (String) o0.i(parcel.readString());
            this.x = parcel.createByteArray();
        }
    }

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<DrmInitData> {
        a() {
        }

        /* renamed from: a */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        /* renamed from: b */
        public DrmInitData[] newArray(int i) {
            return new DrmInitData[i];
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(null, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    private static boolean b(ArrayList<SchemeData> arrayList, int i, UUID uuid) {
        for (int i2 = 0; i2 < i; i2++) {
            if (arrayList.get(i2).f2206d.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static DrmInitData d(@Nullable DrmInitData drmInitData, @Nullable DrmInitData drmInitData2) {
        String str;
        SchemeData[] schemeDataArr;
        SchemeData[] schemeDataArr2;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.f2204f;
            for (SchemeData schemeData : drmInitData.f2202c) {
                if (schemeData.b()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.f2204f;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.f2202c) {
                if (schemeData2.b() && !b(arrayList, size, schemeData2.f2206d)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, arrayList);
    }

    /* renamed from: a */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = w0.a;
        if (uuid.equals(schemeData.f2206d)) {
            return uuid.equals(schemeData2.f2206d) ? 0 : 1;
        }
        return schemeData.f2206d.compareTo(schemeData2.f2206d);
    }

    public DrmInitData c(@Nullable String str) {
        return o0.b(this.f2204f, str) ? this : new DrmInitData(str, false, this.f2202c);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SchemeData e(int i) {
        return this.f2202c[i];
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        return o0.b(this.f2204f, drmInitData.f2204f) && Arrays.equals(this.f2202c, drmInitData.f2202c);
    }

    public DrmInitData f(DrmInitData drmInitData) {
        String str;
        String str2 = this.f2204f;
        g.g(str2 == null || (str = drmInitData.f2204f) == null || TextUtils.equals(str2, str));
        String str3 = this.f2204f;
        if (str3 == null) {
            str3 = drmInitData.f2204f;
        }
        return new DrmInitData(str3, (SchemeData[]) o0.v0(this.f2202c, drmInitData.f2202c));
    }

    public int hashCode() {
        if (this.f2203d == 0) {
            String str = this.f2204f;
            this.f2203d = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f2202c);
        }
        return this.f2203d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2204f);
        parcel.writeTypedArray(this.f2202c, 0);
    }

    public DrmInitData(@Nullable String str, List<SchemeData> list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }

    public DrmInitData(@Nullable String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    private DrmInitData(@Nullable String str, boolean z, SchemeData... schemeDataArr) {
        this.f2204f = str;
        schemeDataArr = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.f2202c = schemeDataArr;
        this.q = schemeDataArr.length;
        Arrays.sort(schemeDataArr, this);
    }

    DrmInitData(Parcel parcel) {
        this.f2204f = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) o0.i((SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR));
        this.f2202c = schemeDataArr;
        this.q = schemeDataArr.length;
    }
}
