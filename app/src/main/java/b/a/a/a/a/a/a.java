package b.a.a.a.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;

/* compiled from: Connectivity.java */
/* loaded from: classes.dex */
public class a {
    private NetworkInfo.State a;

    /* renamed from: b  reason: collision with root package name */
    private NetworkInfo.DetailedState f0b;

    /* renamed from: c  reason: collision with root package name */
    private int f1c;

    /* renamed from: d  reason: collision with root package name */
    private int f2d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4f;
    private boolean g;
    private String h;
    private String i;
    private String j;
    private String k;

    /* compiled from: Connectivity.java */
    /* loaded from: classes.dex */
    public static class b {
        private NetworkInfo.State a = NetworkInfo.State.DISCONNECTED;

        /* renamed from: b  reason: collision with root package name */
        private NetworkInfo.DetailedState f5b = NetworkInfo.DetailedState.IDLE;

        /* renamed from: c  reason: collision with root package name */
        private int f6c = -1;

        /* renamed from: d  reason: collision with root package name */
        private int f7d = -1;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9f = false;
        private boolean g = false;
        private String h = "NONE";
        private String i = "NONE";
        private String j = "";
        private String k = "";

        public b l(boolean z) {
            this.f8e = z;
            return this;
        }

        public a m() {
            return new a(this);
        }

        public b n(NetworkInfo.DetailedState detailedState) {
            this.f5b = detailedState;
            return this;
        }

        public b o(String str) {
            this.k = str;
            return this;
        }

        public b p(boolean z) {
            this.f9f = z;
            return this;
        }

        public b q(String str) {
            this.j = str;
            return this;
        }

        public b r(boolean z) {
            this.g = z;
            return this;
        }

        public b s(NetworkInfo.State state) {
            this.a = state;
            return this;
        }

        public b t(int i) {
            this.f7d = i;
            return this;
        }

        public b u(String str) {
            this.i = str;
            return this;
        }

        public b v(int i) {
            this.f6c = i;
            return this;
        }

        public b w(String str) {
            this.h = str;
            return this;
        }
    }

    private static b b() {
        return new b();
    }

    public static a c() {
        return b().m();
    }

    public static a d(@NonNull Context context) {
        c.a(context, "context == null");
        return e(context, g(context));
    }

    protected static a e(@NonNull Context context, ConnectivityManager connectivityManager) {
        c.a(context, "context == null");
        if (connectivityManager == null) {
            return c();
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null ? c() : f(activeNetworkInfo);
    }

    private static a f(NetworkInfo networkInfo) {
        return new b().s(networkInfo.getState()).n(networkInfo.getDetailedState()).v(networkInfo.getType()).t(networkInfo.getSubtype()).l(networkInfo.isAvailable()).p(networkInfo.isFailover()).r(networkInfo.isRoaming()).w(networkInfo.getTypeName()).u(networkInfo.getSubtypeName()).q(networkInfo.getReason()).o(networkInfo.getExtraInfo()).m();
    }

    private static ConnectivityManager g(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public boolean a() {
        return this.f3e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f1c != aVar.f1c || this.f2d != aVar.f2d || this.f3e != aVar.f3e || this.f4f != aVar.f4f || this.g != aVar.g || this.a != aVar.a || this.f0b != aVar.f0b || !this.h.equals(aVar.h)) {
            return false;
        }
        String str = this.i;
        if (str == null ? aVar.i != null : !str.equals(aVar.i)) {
            return false;
        }
        String str2 = this.j;
        if (str2 == null ? aVar.j != null : !str2.equals(aVar.j)) {
            return false;
        }
        String str3 = this.k;
        String str4 = aVar.k;
        return str3 != null ? str3.equals(str4) : str4 == null;
    }

    public NetworkInfo.State h() {
        return this.a;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        NetworkInfo.DetailedState detailedState = this.f0b;
        int i = 0;
        int hashCode2 = (((((((((((((hashCode + (detailedState != null ? detailedState.hashCode() : 0)) * 31) + this.f1c) * 31) + this.f2d) * 31) + (this.f3e ? 1 : 0)) * 31) + (this.f4f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + this.h.hashCode()) * 31;
        String str = this.i;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.j;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.k;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public int i() {
        return this.f1c;
    }

    public String toString() {
        return "Connectivity{state=" + this.a + ", detailedState=" + this.f0b + ", type=" + this.f1c + ", subType=" + this.f2d + ", available=" + this.f3e + ", failover=" + this.f4f + ", roaming=" + this.g + ", typeName='" + this.h + "', subTypeName='" + this.i + "', reason='" + this.j + "', extraInfo='" + this.k + "'}";
    }

    private a(b bVar) {
        this.a = bVar.a;
        this.f0b = bVar.f5b;
        this.f1c = bVar.f6c;
        this.f2d = bVar.f7d;
        this.f3e = bVar.f8e;
        this.f4f = bVar.f9f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
    }

    private a() {
        this(b());
    }
}
