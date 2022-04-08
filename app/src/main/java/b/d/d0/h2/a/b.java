package b.d.d0.h2.a;

import com.tplink.tmp.enumerate.EnumTMPTransportType;

/* compiled from: TMPBLEClientParams.java */
/* loaded from: classes3.dex */
public class b extends c {

    /* renamed from: f  reason: collision with root package name */
    private String f291f;
    private String g;
    private String h;
    private String i;
    private int j;

    public b(String str, String str2, String str3, String str4, int i) {
        this(str, str2, str3, str4, i, -1);
    }

    @Override // b.d.d0.h2.a.c
    public b.d.d0.i2.b f() {
        if (this.f291f == null || this.g == null || this.h == null || this.i == null || this.j < 20) {
            return new b.d.d0.i2.b(-1012);
        }
        return new b.d.d0.i2.b();
    }

    public String l() {
        return this.f291f;
    }

    public int m() {
        return this.j;
    }

    public String n() {
        return this.h;
    }

    public String o() {
        return this.g;
    }

    public String p() {
        return this.i;
    }

    public void q(String str) {
        this.f291f = str;
    }

    public b(String str, String str2, String str3, String str4, int i, int i2) {
        this.f291f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = i;
        k(EnumTMPTransportType.TRANSPORT_TYPE_BLE);
        h(i2);
    }
}
