package com.tplink.libtpmediaother.database.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.converter.PropertyConverter;

/* compiled from: ModeSettingInfo.java */
/* loaded from: classes3.dex */
public class e {
    private int A;
    private int B;
    private List<c> C;
    private boolean D;
    private boolean E;
    private boolean F;
    private String G;
    private List<c> H;
    private a I;
    private List<b> J;
    private a K;
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12617b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12618c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12619d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12620e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12621f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private String o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    /* compiled from: ModeSettingInfo.java */
    /* loaded from: classes3.dex */
    public static class a implements PropertyConverter<a, String> {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f12622b;

        /* renamed from: c  reason: collision with root package name */
        private String f12623c;

        /* renamed from: d  reason: collision with root package name */
        private String f12624d;

        /* renamed from: e  reason: collision with root package name */
        private String f12625e;

        /* renamed from: f  reason: collision with root package name */
        private String f12626f;
        private String g;

        public a() {
        }

        /* renamed from: a */
        public String convertToDatabaseValue(a aVar) {
            return aVar == null ? "" : new Gson().u(aVar);
        }

        /* renamed from: b */
        public a convertToEntityProperty(String str) {
            if (TextUtils.isEmpty(str)) {
                return new a();
            }
            return (a) new Gson().l(str, a.class);
        }

        public String c() {
            return this.f12625e;
        }

        public String d() {
            return this.a;
        }

        public String e() {
            return this.f12626f;
        }

        public String f() {
            return this.g;
        }

        public String g() {
            return this.f12624d;
        }

        public String h() {
            return this.f12622b;
        }

        public String i() {
            return this.f12623c;
        }

        public String toString() {
            return "ArmScheduleInfo{monday='" + this.a + "', tuesday='" + this.f12622b + "', wednesday='" + this.f12623c + "', thursday='" + this.f12624d + "', friday='" + this.f12625e + "', saturday='" + this.f12626f + "', sunday='" + this.g + "'}";
        }

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.a = str;
            this.f12622b = str2;
            this.f12623c = str3;
            this.f12624d = str4;
            this.f12625e = str5;
            this.f12626f = str6;
            this.g = str7;
        }

        public a(boolean z) {
            if (z) {
                this.a = "[\"0000-2400\"]";
                this.f12622b = "[\"0000-2400\"]";
                this.f12623c = "[\"0000-2400\"]";
                this.f12624d = "[\"0000-2400\"]";
                this.f12625e = "[\"0000-2400\"]";
                this.f12626f = "[\"0000-2400\"]";
                this.g = "[\"0000-2400\"]";
            }
        }
    }

    /* compiled from: ModeSettingInfo.java */
    /* loaded from: classes3.dex */
    public static class b implements PropertyConverter<List<b>, String> {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f12627b;

        /* renamed from: c  reason: collision with root package name */
        private String f12628c;

        /* renamed from: d  reason: collision with root package name */
        private String f12629d;

        /* renamed from: e  reason: collision with root package name */
        private String f12630e;

        /* renamed from: f  reason: collision with root package name */
        private String f12631f;

        public b() {
        }

        public LineCrossingDetectionRegion a() {
            return new LineCrossingDetectionRegion(this.a, this.f12627b, this.f12628c, this.f12629d, this.f12630e, this.f12631f);
        }

        /* renamed from: b */
        public String convertToDatabaseValue(List<b> list) {
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (b bVar : list) {
                sb.append(new Gson().u(bVar));
                sb.append((char) 65292);
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }

        /* renamed from: c */
        public List<b> convertToEntityProperty(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            String[] split = str.split("，");
            ArrayList arrayList = new ArrayList();
            for (String str2 : split) {
                arrayList.add(new Gson().l(str2, b.class));
            }
            return arrayList;
        }

        public String toString() {
            return "LineCrossingDetectionRegion{point1X='" + this.a + "', point1Y='" + this.f12627b + "', point2X='" + this.f12628c + "', point2Y='" + this.f12629d + "', sensitivity='" + this.f12630e + "', direction='" + this.f12631f + "'}";
        }

        public b(LineCrossingDetectionRegion lineCrossingDetectionRegion) {
            this.a = lineCrossingDetectionRegion.getPoint1X();
            this.f12627b = lineCrossingDetectionRegion.getPoint1Y();
            this.f12628c = lineCrossingDetectionRegion.getPoint2X();
            this.f12629d = lineCrossingDetectionRegion.getPoint2Y();
            this.f12631f = lineCrossingDetectionRegion.getDirection();
            this.f12630e = lineCrossingDetectionRegion.getSensitivity();
        }
    }

    /* compiled from: ModeSettingInfo.java */
    /* loaded from: classes3.dex */
    public static class c implements PropertyConverter<List<c>, String> {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f12632b;

        /* renamed from: c  reason: collision with root package name */
        private int f12633c;

        /* renamed from: d  reason: collision with root package name */
        private int f12634d;

        public c() {
        }

        /* renamed from: a */
        public String convertToDatabaseValue(List<c> list) {
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (c cVar : list) {
                sb.append(new Gson().u(cVar));
                sb.append((char) 65292);
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }

        /* renamed from: b */
        public List<c> convertToEntityProperty(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            String[] split = str.split("，");
            ArrayList arrayList = new ArrayList();
            for (String str2 : split) {
                arrayList.add(new Gson().l(str2, c.class));
            }
            return arrayList;
        }

        public int c() {
            return this.f12634d;
        }

        public int d() {
            return this.f12633c;
        }

        public int e() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            c cVar = (c) obj;
            return cVar.a == this.a && cVar.f12632b == this.f12632b && cVar.f12633c == this.f12633c && cVar.f12634d == this.f12634d;
        }

        public int f() {
            return this.f12632b;
        }

        public void g(int i) {
            this.f12634d = i;
        }

        public void h(int i) {
            this.f12633c = i;
        }

        public int hashCode() {
            return (((((this.a * 31) + this.f12632b) * 31) + this.f12633c) * 31) + this.f12634d;
        }

        public void i(int i) {
            this.a = i;
        }

        public void j(int i) {
            this.f12632b = i;
        }

        @NonNull
        public String toString() {
            return "Region(x:" + this.a + ",y:" + this.f12632b + ",w:" + this.f12633c + ",h:" + this.f12634d + ")";
        }

        public c(int i, int i2, int i3, int i4) {
            this.a = i;
            this.f12632b = i2;
            this.f12633c = i3;
            this.f12634d = i4;
        }
    }

    public e() {
        this.a = "";
        this.j = 80;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = "0";
        this.p = 0;
        this.q = 0;
        this.r = 23;
        this.s = 59;
        this.t = 127;
        this.x = 9;
        this.y = 0;
        this.z = 17;
        this.A = 0;
        this.B = 127;
        this.C = new ArrayList();
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = "low";
        this.H = new ArrayList();
        this.I = new a(true);
        this.J = new ArrayList();
        this.K = new a(true);
    }

    public static e a(String str, boolean z) {
        e eVar = new e();
        eVar.f0(str);
        eVar.i0(z);
        boolean z2 = !z;
        eVar.f12618c = z2;
        eVar.f12619d = z2;
        eVar.k = z2;
        eVar.C.add(new c(0, 0, 10000, 10000));
        eVar.u = z2;
        eVar.i = z2 ? 100 : 50;
        eVar.D = z2;
        eVar.H.add(new c(0, 0, 10000, 10000));
        eVar.E = z2;
        return eVar;
    }

    public int A() {
        return this.A;
    }

    public void A0(boolean z) {
        this.h = z;
    }

    public boolean B() {
        return this.u;
    }

    public boolean C() {
        return this.v;
    }

    public boolean D() {
        return this.w;
    }

    public int E() {
        return this.x;
    }

    public int F() {
        return this.y;
    }

    public boolean G() {
        return this.f12618c;
    }

    public List<c> H() {
        if (this.f12617b && this.C.isEmpty()) {
            this.C.add(new c(0, 0, 10000, 10000));
        }
        return this.C;
    }

    public boolean I() {
        return this.n;
    }

    public int J() {
        return this.j;
    }

    public boolean K() {
        return this.D;
    }

    public String L() {
        if (this.G == null) {
            this.G = "low";
        }
        return this.G;
    }

    public boolean M() {
        return this.h;
    }

    public boolean N() {
        return this.E;
    }

    public boolean O() {
        return this.F;
    }

    public boolean P() {
        return this.D;
    }

    public void Q(int i) {
        this.t = i;
    }

    public void R(boolean z) {
        this.k = z;
    }

    public void S(int i) {
        this.r = i;
    }

    public void T(int i) {
        this.s = i;
    }

    public void U(boolean z) {
        this.m = z;
    }

    public void V(boolean z) {
        this.l = z;
    }

    public void W(String str) {
        this.o = str;
    }

    public void X(int i) {
        this.p = i;
    }

    public void Y(int i) {
        this.q = i;
    }

    public void Z(a aVar) {
        this.I = aVar;
    }

    public void a0(boolean z) {
        this.E = z;
    }

    public int b() {
        return this.t;
    }

    public void b0(List<c> list) {
        if (list == null) {
            list = new ArrayList<>();
            list.add(new c(0, 0, 10000, 10000));
        }
        this.H = list;
    }

    public boolean c() {
        return this.k;
    }

    public void c0(boolean z) {
        this.f12621f = z;
    }

    public int d() {
        return this.r;
    }

    public void d0(int i) {
        this.i = i;
    }

    public int e() {
        return this.s;
    }

    public void e0(boolean z) {
        this.f12619d = z;
    }

    public boolean f() {
        return this.m;
    }

    public void f0(String str) {
        this.a = str;
    }

    public boolean g() {
        return this.l;
    }

    public void g0(boolean z) {
        this.g = z;
    }

    public String h() {
        return this.o;
    }

    public void h0(boolean z) {
        this.f12620e = z;
    }

    public int i() {
        return this.p;
    }

    public void i0(boolean z) {
        this.f12617b = z;
    }

    public int j() {
        return this.q;
    }

    public void j0(a aVar) {
        this.K = aVar;
    }

    public a k() {
        if (this.I == null) {
            this.I = new a(true);
        }
        return this.I;
    }

    public void k0(boolean z) {
        this.F = z;
    }

    public boolean l() {
        return this.E;
    }

    public void l0(List<b> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.J = list;
    }

    public List<c> m() {
        if (this.H == null) {
            this.H = new ArrayList();
        }
        if (this.H.isEmpty()) {
            this.H.add(new c(0, 0, 10000, 10000));
        }
        return this.H;
    }

    public void m0(int i) {
        this.B = i;
    }

    public boolean n() {
        return this.f12621f;
    }

    public void n0(int i) {
        this.z = i;
    }

    public int o() {
        return this.i;
    }

    public void o0(int i) {
        this.A = i;
    }

    public boolean p() {
        return this.f12619d;
    }

    public void p0(boolean z) {
        this.u = z;
    }

    public String q() {
        return this.a;
    }

    public void q0(boolean z) {
        this.v = z;
    }

    public boolean r() {
        return this.g;
    }

    public void r0(boolean z) {
        this.w = z;
    }

    public boolean s() {
        return this.f12620e;
    }

    public void s0(int i) {
        this.x = i;
    }

    public boolean t() {
        return this.f12617b;
    }

    public void t0(int i) {
        this.y = i;
    }

    public a u() {
        if (this.K == null) {
            this.K = new a(true);
        }
        return this.K;
    }

    public void u0(boolean z) {
        this.f12618c = z;
    }

    public boolean v() {
        return this.F;
    }

    public void v0(List<c> list) {
        if (list == null) {
            this.C = new ArrayList();
        } else {
            this.C = list;
        }
    }

    public List<b> w() {
        if (this.J == null) {
            this.J = new ArrayList();
        }
        return this.J;
    }

    public void w0(boolean z) {
        this.n = z;
    }

    public boolean x() {
        return this.f12619d;
    }

    public void x0(int i) {
        this.j = i;
    }

    public int y() {
        return this.B;
    }

    public void y0(boolean z) {
        this.D = z;
    }

    public int z() {
        return this.z;
    }

    public void z0(String str) {
        this.G = str;
    }

    public e(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, int i2, boolean z8, boolean z9, boolean z10, boolean z11, String str2, int i3, int i4, int i5, int i6, int i7, boolean z12, boolean z13, boolean z14, int i8, int i9, int i10, int i11, int i12, List<c> list, boolean z15, boolean z16, boolean z17, String str3, List<c> list2, a aVar, List<b> list3, a aVar2) {
        this.a = "";
        this.j = 80;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = "0";
        this.p = 0;
        this.q = 0;
        this.r = 23;
        this.s = 59;
        this.t = 127;
        this.x = 9;
        this.y = 0;
        this.z = 17;
        this.A = 0;
        this.B = 127;
        this.C = new ArrayList();
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = "low";
        this.H = new ArrayList();
        this.I = new a(true);
        this.J = new ArrayList();
        this.K = new a(true);
        this.a = str;
        this.f12617b = z;
        this.f12618c = z2;
        this.f12619d = z3;
        this.f12620e = z4;
        this.f12621f = z5;
        this.g = z6;
        this.h = z7;
        this.i = i;
        this.j = i2;
        this.k = z8;
        this.l = z9;
        this.m = z10;
        this.n = z11;
        this.o = str2;
        this.p = i3;
        this.q = i4;
        this.r = i5;
        this.s = i6;
        this.t = i7;
        this.u = z12;
        this.v = z13;
        this.w = z14;
        this.x = i8;
        this.y = i9;
        this.z = i10;
        this.A = i11;
        this.B = i12;
        this.C = list;
        this.D = z15;
        this.E = z16;
        this.F = z17;
        this.G = str3;
        this.H = list2;
        this.I = aVar;
        this.J = list3;
        this.K = aVar2;
    }
}
