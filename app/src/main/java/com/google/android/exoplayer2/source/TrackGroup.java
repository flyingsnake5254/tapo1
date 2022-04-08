package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.u;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator<TrackGroup> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final int f3157c;

    /* renamed from: d  reason: collision with root package name */
    private final Format[] f3158d;

    /* renamed from: f  reason: collision with root package name */
    private int f3159f;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<TrackGroup> {
        a() {
        }

        /* renamed from: a */
        public TrackGroup createFromParcel(Parcel parcel) {
            return new TrackGroup(parcel);
        }

        /* renamed from: b */
        public TrackGroup[] newArray(int i) {
            return new TrackGroup[i];
        }
    }

    public TrackGroup(Format... formatArr) {
        g.g(formatArr.length > 0);
        this.f3158d = formatArr;
        this.f3157c = formatArr.length;
        f();
    }

    private static void c(String str, @Nullable String str2, @Nullable String str3, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("Different ");
        sb.append(str);
        sb.append(" combined in one TrackGroup: '");
        sb.append(str2);
        sb.append("' (track 0) and '");
        sb.append(str3);
        sb.append("' (track ");
        sb.append(i);
        sb.append(")");
        u.d("TrackGroup", "", new IllegalStateException(sb.toString()));
    }

    private static String d(@Nullable String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static int e(int i) {
        return i | 16384;
    }

    private void f() {
        String d2 = d(this.f3158d[0].f2006f);
        int e2 = e(this.f3158d[0].x);
        int i = 1;
        while (true) {
            Format[] formatArr = this.f3158d;
            if (i >= formatArr.length) {
                return;
            }
            if (!d2.equals(d(formatArr[i].f2006f))) {
                Format[] formatArr2 = this.f3158d;
                c("languages", formatArr2[0].f2006f, formatArr2[i].f2006f, i);
                return;
            } else if (e2 != e(this.f3158d[i].x)) {
                c("role flags", Integer.toBinaryString(this.f3158d[0].x), Integer.toBinaryString(this.f3158d[i].x), i);
                return;
            } else {
                i++;
            }
        }
    }

    public Format a(int i) {
        return this.f3158d[i];
    }

    public int b(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.f3158d;
            if (i >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i]) {
                return i;
            }
            i++;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.f3157c == trackGroup.f3157c && Arrays.equals(this.f3158d, trackGroup.f3158d);
    }

    public int hashCode() {
        if (this.f3159f == 0) {
            this.f3159f = 527 + Arrays.hashCode(this.f3158d);
        }
        return this.f3159f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3157c);
        for (int i2 = 0; i2 < this.f3157c; i2++) {
            parcel.writeParcelable(this.f3158d[i2], 0);
        }
    }

    TrackGroup(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f3157c = readInt;
        this.f3158d = new Format[readInt];
        for (int i = 0; i < this.f3157c; i++) {
            this.f3158d[i] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }
}
