package com.tplink.iot.widget.camerapreview;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: DisplayViewState.kt */
/* loaded from: classes3.dex */
public final class e {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private String f11710b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11711c;

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f11712d;

    /* renamed from: e  reason: collision with root package name */
    private final Boolean f11713e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11714f;
    private final Boolean g;
    private final Boolean h;
    private final Boolean i;
    private final Boolean j;
    private final Throwable k;
    private final Boolean l;
    private final Boolean m;
    private final Boolean n;
    private final String o;

    /* compiled from: DisplayViewState.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final e a() {
            Boolean bool = Boolean.FALSE;
            return new e(null, null, null, null, null, bool, bool, bool, bool, null, Boolean.TRUE, null, null, null, 14367, null);
        }

        public final e b(Throwable errorReason) {
            j.e(errorReason, "errorReason");
            Boolean bool = Boolean.FALSE;
            Boolean bool2 = Boolean.TRUE;
            return new e(null, null, null, null, null, bool, bool, bool, bool2, errorReason, bool2, null, null, null, 14367, null);
        }

        public final e c() {
            Boolean bool = Boolean.FALSE;
            Boolean bool2 = Boolean.TRUE;
            return new e(null, null, null, null, null, null, null, bool, null, null, bool2, bool, bool2, null, 9087, null);
        }

        public final e d() {
            return new e(null, null, null, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, 15359, null);
        }

        public final e e() {
            return new e(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        }

        public final e f() {
            Boolean bool = Boolean.FALSE;
            return new e(null, null, null, null, null, bool, bool, Boolean.TRUE, bool, null, bool, null, null, null, 14367, null);
        }

        public final e g() {
            Boolean bool = Boolean.FALSE;
            return new e(null, null, null, null, null, null, null, bool, null, null, Boolean.TRUE, bool, bool, null, 9087, null);
        }

        public final e h() {
            Boolean bool = Boolean.FALSE;
            Boolean bool2 = Boolean.TRUE;
            return new e(null, null, null, null, null, bool, bool2, bool, bool, null, bool2, null, null, null, 14367, null);
        }

        public final e i() {
            Boolean bool = Boolean.TRUE;
            Boolean bool2 = Boolean.FALSE;
            return new e(null, null, null, null, null, bool, bool2, bool2, bool2, null, null, null, null, null, 14367, null);
        }

        public final e j(String name, String info, Boolean bool) {
            j.e(name, "name");
            j.e(info, "info");
            Boolean bool2 = Boolean.FALSE;
            return new e(null, name, bool, bool2, info, bool2, bool2, bool2, bool2, null, bool2, bool2, bool2, null, 8705, null);
        }

        public final e k(String name, String info, Boolean bool) {
            j.e(name, "name");
            j.e(info, "info");
            return new e(null, name, bool, Boolean.TRUE, info, null, null, null, null, null, null, null, null, null, 16353, null);
        }

        public final e l() {
            return new e(null, null, null, null, null, null, null, null, null, null, Boolean.TRUE, null, null, null, 15359, null);
        }

        public final e m(String str) {
            return new e(null, null, null, null, null, null, null, null, null, null, null, null, null, str, 8191, null);
        }

        public final e n() {
            Boolean bool = Boolean.TRUE;
            Boolean bool2 = Boolean.FALSE;
            return new e(null, null, null, bool, null, null, null, bool, null, null, bool2, bool, bool2, null, 9079, null);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public e() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public e(String str, String str2, Boolean bool, Boolean bool2, String str3, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Throwable th, Boolean bool7, Boolean bool8, Boolean bool9, String str4) {
        this.f11710b = str;
        this.f11711c = str2;
        this.f11712d = bool;
        this.f11713e = bool2;
        this.f11714f = str3;
        this.g = bool3;
        this.h = bool4;
        this.i = bool5;
        this.j = bool6;
        this.k = th;
        this.l = bool7;
        this.m = bool8;
        this.n = bool9;
        this.o = str4;
    }

    public final e A(e preState) {
        j.e(preState, "preState");
        return new e(a() == null ? preState.a() : a(), g() == null ? preState.g() : g(), h() == null ? preState.h() : h(), i() == null ? preState.i() : i(), j() == null ? preState.j() : j(), k() == null ? preState.k() : k(), l() == null ? preState.l() : l(), m() == null ? preState.m() : m(), n() == null ? preState.n() : n(), b() == null ? preState.b() : b(), c() == null ? preState.c() : c(), d() == null ? preState.d() : d(), e() == null ? preState.e() : e(), f() == null ? preState.f() : f());
    }

    public final e B(String tag) {
        j.e(tag, "tag");
        this.f11710b = tag;
        return this;
    }

    public final String a() {
        return this.f11710b;
    }

    public final Throwable b() {
        return this.k;
    }

    public final Boolean c() {
        return this.l;
    }

    public final Boolean d() {
        return this.m;
    }

    public final Boolean e() {
        return this.n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return j.a(this.f11710b, eVar.f11710b) && j.a(this.f11711c, eVar.f11711c) && j.a(this.f11712d, eVar.f11712d) && j.a(this.f11713e, eVar.f11713e) && j.a(this.f11714f, eVar.f11714f) && j.a(this.g, eVar.g) && j.a(this.h, eVar.h) && j.a(this.i, eVar.i) && j.a(this.j, eVar.j) && j.a(this.k, eVar.k) && j.a(this.l, eVar.l) && j.a(this.m, eVar.m) && j.a(this.n, eVar.n) && j.a(this.o, eVar.o);
    }

    public final String f() {
        return this.o;
    }

    public final String g() {
        return this.f11711c;
    }

    public final Boolean h() {
        return this.f11712d;
    }

    public int hashCode() {
        String str = this.f11710b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f11711c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.f11712d;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.f11713e;
        int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str3 = this.f11714f;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool3 = this.g;
        int hashCode6 = (hashCode5 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.h;
        int hashCode7 = (hashCode6 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.i;
        int hashCode8 = (hashCode7 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.j;
        int hashCode9 = (hashCode8 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Throwable th = this.k;
        int hashCode10 = (hashCode9 + (th != null ? th.hashCode() : 0)) * 31;
        Boolean bool7 = this.l;
        int hashCode11 = (hashCode10 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.m;
        int hashCode12 = (hashCode11 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Boolean bool9 = this.n;
        int hashCode13 = (hashCode12 + (bool9 != null ? bool9.hashCode() : 0)) * 31;
        String str4 = this.o;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode13 + i;
    }

    public final Boolean i() {
        return this.f11713e;
    }

    public final String j() {
        return this.f11714f;
    }

    public final Boolean k() {
        return this.g;
    }

    public final Boolean l() {
        return this.h;
    }

    public final Boolean m() {
        return this.i;
    }

    public final Boolean n() {
        return this.j;
    }

    public final String o() {
        return this.f11714f;
    }

    public final String p() {
        return this.f11711c;
    }

    public final Boolean q() {
        return this.j;
    }

    public final Throwable r() {
        return this.k;
    }

    public final Boolean s() {
        return this.l;
    }

    public final Boolean t() {
        return this.f11712d;
    }

    public String toString() {
        return "DisplayViewState(tag=" + this.f11710b + ", deviceName=" + this.f11711c + ", initialing=" + this.f11712d + ", online=" + this.f11713e + ", deviceInfo=" + this.f11714f + ", playing=" + this.g + ", pause=" + this.h + ", loading=" + this.i + ", error=" + this.j + ", errorReason=" + this.k + ", funcBtnVisible=" + this.l + ", updating=" + this.m + ", needForceUpdate=" + this.n + ", speed=" + this.o + ")";
    }

    public final Boolean u() {
        return this.i;
    }

    public final Boolean v() {
        return this.n;
    }

    public final Boolean w() {
        return this.f11713e;
    }

    public final Boolean x() {
        return this.g;
    }

    public final String y() {
        return this.o;
    }

    public final Boolean z() {
        return this.m;
    }

    public /* synthetic */ e(String str, String str2, Boolean bool, Boolean bool2, String str3, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Throwable th, Boolean bool7, Boolean bool8, Boolean bool9, String str4, int i, f fVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : bool3, (i & 64) != 0 ? null : bool4, (i & 128) != 0 ? null : bool5, (i & 256) != 0 ? null : bool6, (i & 512) != 0 ? null : th, (i & 1024) != 0 ? null : bool7, (i & 2048) != 0 ? null : bool8, (i & 4096) != 0 ? null : bool9, (i & 8192) == 0 ? str4 : null);
    }
}
