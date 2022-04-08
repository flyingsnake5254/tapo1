package org.bouncycastle.util.io.pem;

/* loaded from: classes4.dex */
public class a {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f17520b;

    public a(String str, String str2) {
        this.a = str;
        this.f17520b = str2;
    }

    private int a(String str) {
        if (str == null) {
            return 1;
        }
        return str.hashCode();
    }

    private boolean d(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.f17520b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return aVar == this || (d(this.a, aVar.a) && d(this.f17520b, aVar.f17520b));
    }

    public int hashCode() {
        return a(this.a) + (a(this.f17520b) * 31);
    }
}
