package com.tplink.iot.view.ipcamera.preview;

import android.os.Parcel;
import android.os.Parcelable;
import com.tplink.iot.adapter.databinding.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: CameraPreviewActivity.kt */
/* loaded from: classes2.dex */
public final class CameraPreviewInfo implements c, Parcelable {

    /* renamed from: d  reason: collision with root package name */
    private final String f9051d;

    /* renamed from: f  reason: collision with root package name */
    private final String f9052f;
    private final String p0;
    private final String q;
    private boolean x;
    private final boolean y;
    private String z;

    /* renamed from: c  reason: collision with root package name */
    public static final b f9050c = new b(null);
    public static final Parcelable.Creator<CameraPreviewInfo> CREATOR = new a();

    /* compiled from: CameraPreviewActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Parcelable.Creator<CameraPreviewInfo> {
        a() {
        }

        /* renamed from: a */
        public CameraPreviewInfo createFromParcel(Parcel source) {
            j.e(source, "source");
            return new CameraPreviewInfo(source);
        }

        /* renamed from: b */
        public CameraPreviewInfo[] newArray(int i) {
            return new CameraPreviewInfo[i];
        }
    }

    /* compiled from: CameraPreviewActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    public CameraPreviewInfo(String deviceIdMD5, String name, String info, boolean z, boolean z2, String str, String location) {
        j.e(deviceIdMD5, "deviceIdMD5");
        j.e(name, "name");
        j.e(info, "info");
        j.e(location, "location");
        this.f9051d = deviceIdMD5;
        this.f9052f = name;
        this.q = info;
        this.x = z;
        this.y = z2;
        this.z = str;
        this.p0 = location;
    }

    public static /* synthetic */ CameraPreviewInfo c(CameraPreviewInfo cameraPreviewInfo, String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cameraPreviewInfo.f9051d;
        }
        if ((i & 2) != 0) {
            str2 = cameraPreviewInfo.f9052f;
        }
        if ((i & 4) != 0) {
            str3 = cameraPreviewInfo.q;
        }
        if ((i & 8) != 0) {
            z = cameraPreviewInfo.x;
        }
        if ((i & 16) != 0) {
            z2 = cameraPreviewInfo.y;
        }
        if ((i & 32) != 0) {
            str4 = cameraPreviewInfo.z;
        }
        if ((i & 64) != 0) {
            str5 = cameraPreviewInfo.p0;
        }
        return cameraPreviewInfo.b(str, str2, str3, z, z2, str4, str5);
    }

    @Override // com.tplink.iot.adapter.databinding.c
    public Object a() {
        return c(this, null, null, null, false, false, null, null, 127, null);
    }

    public final CameraPreviewInfo b(String deviceIdMD5, String name, String info, boolean z, boolean z2, String str, String location) {
        j.e(deviceIdMD5, "deviceIdMD5");
        j.e(name, "name");
        j.e(info, "info");
        j.e(location, "location");
        return new CameraPreviewInfo(deviceIdMD5, name, info, z, z2, str, location);
    }

    public final String d() {
        return this.f9051d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPreviewInfo)) {
            return false;
        }
        CameraPreviewInfo cameraPreviewInfo = (CameraPreviewInfo) obj;
        return j.a(this.f9051d, cameraPreviewInfo.f9051d) && j.a(this.f9052f, cameraPreviewInfo.f9052f) && j.a(this.q, cameraPreviewInfo.q) && this.x == cameraPreviewInfo.x && this.y == cameraPreviewInfo.y && j.a(this.z, cameraPreviewInfo.z) && j.a(this.p0, cameraPreviewInfo.p0);
    }

    public final String f() {
        return this.q;
    }

    public final boolean h() {
        return this.y;
    }

    public int hashCode() {
        String str = this.f9051d;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f9052f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.q;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.x;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode3 + i3) * 31;
        boolean z2 = this.y;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i7 = (i6 + i2) * 31;
        String str4 = this.z;
        int hashCode4 = (i7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.p0;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public final String i() {
        return this.p0;
    }

    public final String l() {
        return this.f9052f;
    }

    public final boolean m() {
        return this.x;
    }

    public final void n(String str) {
        this.z = str;
    }

    public final void o(boolean z) {
        this.x = z;
    }

    public String toString() {
        return "CameraPreviewInfo(deviceIdMD5=" + this.f9051d + ", name=" + this.f9052f + ", info=" + this.q + ", online=" + this.x + ", initialing=" + this.y + ", imageUrl=" + this.z + ", location=" + this.p0 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i) {
        j.e(dest, "dest");
        dest.writeString(this.f9051d);
        dest.writeString(this.f9052f);
        dest.writeString(this.q);
        dest.writeInt(this.x ? 1 : 0);
        dest.writeInt(this.y ? 1 : 0);
        dest.writeString(this.z);
        dest.writeString(this.p0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CameraPreviewInfo(android.os.Parcel r11) {
        /*
            r10 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.j.e(r11, r0)
            java.lang.String r0 = r11.readString()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x000f
            r3 = r0
            goto L_0x0010
        L_0x000f:
            r3 = r1
        L_0x0010:
            java.lang.String r0 = "source.readString() ?: \"\""
            kotlin.jvm.internal.j.d(r3, r0)
            java.lang.String r2 = r11.readString()
            if (r2 == 0) goto L_0x001d
            r4 = r2
            goto L_0x001e
        L_0x001d:
            r4 = r1
        L_0x001e:
            kotlin.jvm.internal.j.d(r4, r0)
            java.lang.String r2 = r11.readString()
            if (r2 == 0) goto L_0x0029
            r5 = r2
            goto L_0x002a
        L_0x0029:
            r5 = r1
        L_0x002a:
            kotlin.jvm.internal.j.d(r5, r0)
            int r2 = r11.readInt()
            r6 = 0
            r7 = 1
            if (r7 != r2) goto L_0x0037
            r8 = 1
            goto L_0x0038
        L_0x0037:
            r8 = 0
        L_0x0038:
            int r2 = r11.readInt()
            if (r7 != r2) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r7 = 0
        L_0x0040:
            java.lang.String r9 = r11.readString()
            java.lang.String r11 = r11.readString()
            if (r11 == 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r11 = r1
        L_0x004c:
            kotlin.jvm.internal.j.d(r11, r0)
            r2 = r10
            r6 = r8
            r8 = r9
            r9 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo.<init>(android.os.Parcel):void");
    }
}
