package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class EventMessage implements Metadata.Entry {

    /* renamed from: f  reason: collision with root package name */
    public final String f2542f;
    private int p0;
    public final String q;
    public final long x;
    public final long y;
    public final byte[] z;

    /* renamed from: c  reason: collision with root package name */
    private static final Format f2540c = new Format.b().e0("application/id3").E();

    /* renamed from: d  reason: collision with root package name */
    private static final Format f2541d = new Format.b().e0("application/x-scte35").E();
    public static final Parcelable.Creator<EventMessage> CREATOR = new a();

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<EventMessage> {
        a() {
        }

        /* renamed from: a */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        /* renamed from: b */
        public EventMessage[] newArray(int i) {
            return new EventMessage[i];
        }
    }

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.f2542f = str;
        this.q = str2;
        this.x = j;
        this.y = j2;
        this.z = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return this.x == eventMessage.x && this.y == eventMessage.y && o0.b(this.f2542f, eventMessage.f2542f) && o0.b(this.q, eventMessage.q) && Arrays.equals(this.z, eventMessage.z);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @Nullable
    public Format g() {
        String str = this.f2542f;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals("urn:scte:scte35:2014:bin")) {
                    c2 = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals("https://aomedia.org/emsg/ID3")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals("https://developer.apple.com/streaming/emsg-id3")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return f2541d;
            case 1:
            case 2:
                return f2540c;
            default:
                return null;
        }
    }

    public int hashCode() {
        if (this.p0 == 0) {
            String str = this.f2542f;
            int i = 0;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.q;
            if (str2 != null) {
                i = str2.hashCode();
            }
            long j = this.x;
            long j2 = this.y;
            this.p0 = ((((((hashCode + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.z);
        }
        return this.p0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void j(m1.b bVar) {
        com.google.android.exoplayer2.metadata.a.c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @Nullable
    public byte[] k() {
        if (g() != null) {
            return this.z;
        }
        return null;
    }

    public String toString() {
        String str = this.f2542f;
        long j = this.y;
        long j2 = this.x;
        String str2 = this.q;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 79 + String.valueOf(str2).length());
        sb.append("EMSG: scheme=");
        sb.append(str);
        sb.append(", id=");
        sb.append(j);
        sb.append(", durationMs=");
        sb.append(j2);
        sb.append(", value=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2542f);
        parcel.writeString(this.q);
        parcel.writeLong(this.x);
        parcel.writeLong(this.y);
        parcel.writeByteArray(this.z);
    }

    EventMessage(Parcel parcel) {
        this.f2542f = (String) o0.i(parcel.readString());
        this.q = (String) o0.i(parcel.readString());
        this.x = parcel.readLong();
        this.y = parcel.readLong();
        this.z = (byte[]) o0.i(parcel.createByteArray());
    }
}
