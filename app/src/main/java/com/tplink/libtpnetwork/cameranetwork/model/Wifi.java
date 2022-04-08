package com.tplink.libtpnetwork.cameranetwork.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class Wifi implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private final int auth;
    private final String bssid;
    private final Integer encryption;
    private final String password;
    private final int rssi;
    private final String ssid;

    /* compiled from: Model.kt */
    /* loaded from: classes3.dex */
    public static final class CREATOR implements Parcelable.Creator<Wifi> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(f fVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Wifi createFromParcel(Parcel parcel) {
            j.e(parcel, "parcel");
            return new Wifi(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Wifi[] newArray(int i) {
            return new Wifi[i];
        }
    }

    public Wifi(String ssid, String str, int i, Integer num, int i2, String password) {
        j.e(ssid, "ssid");
        j.e(password, "password");
        this.ssid = ssid;
        this.bssid = str;
        this.auth = i;
        this.encryption = num;
        this.rssi = i2;
        this.password = password;
    }

    public static /* synthetic */ Wifi copy$default(Wifi wifi, String str, String str2, int i, Integer num, int i2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = wifi.ssid;
        }
        if ((i3 & 2) != 0) {
            str2 = wifi.bssid;
        }
        if ((i3 & 4) != 0) {
            i = wifi.auth;
        }
        if ((i3 & 8) != 0) {
            num = wifi.encryption;
        }
        if ((i3 & 16) != 0) {
            i2 = wifi.rssi;
        }
        if ((i3 & 32) != 0) {
            str3 = wifi.password;
        }
        return wifi.copy(str, str2, i, num, i2, str3);
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.bssid;
    }

    public final int component3() {
        return this.auth;
    }

    public final Integer component4() {
        return this.encryption;
    }

    public final int component5() {
        return this.rssi;
    }

    public final String component6() {
        return this.password;
    }

    public final Wifi connectWithPassword(String password) {
        j.e(password, "password");
        return copy$default(this, null, null, 0, null, 0, password, 31, null);
    }

    public final Wifi copy(String ssid, String str, int i, Integer num, int i2, String password) {
        j.e(ssid, "ssid");
        j.e(password, "password");
        return new Wifi(ssid, str, i, num, i2, password);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Wifi)) {
            return false;
        }
        Wifi wifi = (Wifi) obj;
        return j.a(this.ssid, wifi.ssid) && j.a(this.bssid, wifi.bssid) && this.auth == wifi.auth && j.a(this.encryption, wifi.encryption) && this.rssi == wifi.rssi && j.a(this.password, wifi.password);
    }

    public final int getAuth() {
        return this.auth;
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final Integer getEncryption() {
        return this.encryption;
    }

    public final String getPassword() {
        return this.password;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public int hashCode() {
        String str = this.ssid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bssid;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.auth) * 31;
        Integer num = this.encryption;
        int hashCode3 = (((hashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.rssi) * 31;
        String str3 = this.password;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public final boolean isCommon() {
        return !isWEP() && !isWPA3();
    }

    public final boolean isWEP() {
        return this.auth == 1;
    }

    public final boolean isWPA3() {
        return this.auth == 5;
    }

    public String toString() {
        return "Wifi(ssid=" + this.ssid + ", bssid=" + this.bssid + ", auth=" + this.auth + ", encryption=" + this.encryption + ", rssi=" + this.rssi + ", password=" + this.password + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        j.e(parcel, "parcel");
        parcel.writeString(this.ssid);
        parcel.writeString(this.bssid);
        parcel.writeInt(this.auth);
        Integer num = this.encryption;
        parcel.writeInt(num != null ? num.intValue() : 3);
        parcel.writeInt(this.rssi);
        parcel.writeString(this.password);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Wifi(android.os.Parcel r10) {
        /*
            r9 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.j.e(r10, r0)
            java.lang.String r0 = r10.readString()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x000f
            r3 = r0
            goto L_0x0010
        L_0x000f:
            r3 = r1
        L_0x0010:
            java.lang.String r0 = "parcel.readString() ?: \"\""
            kotlin.jvm.internal.j.d(r3, r0)
            java.lang.String r2 = r10.readString()
            if (r2 == 0) goto L_0x001d
            r4 = r2
            goto L_0x001e
        L_0x001d:
            r4 = r1
        L_0x001e:
            int r5 = r10.readInt()
            int r2 = r10.readInt()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            int r7 = r10.readInt()
            java.lang.String r10 = r10.readString()
            if (r10 == 0) goto L_0x0036
            r8 = r10
            goto L_0x0037
        L_0x0036:
            r8 = r1
        L_0x0037:
            kotlin.jvm.internal.j.d(r8, r0)
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.cameranetwork.model.Wifi.<init>(android.os.Parcel):void");
    }
}
