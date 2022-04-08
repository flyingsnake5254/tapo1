package kotlin.text;

import kotlin.jvm.internal.j;
import kotlin.v.d;

/* compiled from: Regex.kt */
/* loaded from: classes4.dex */
public final class g {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final d f16395b;

    public g(String value, d range) {
        j.e(value, "value");
        j.e(range, "range");
        this.a = value;
        this.f16395b = range;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return j.a(this.a, gVar.a) && j.a(this.f16395b, gVar.f16395b);
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        d dVar = this.f16395b;
        if (dVar != null) {
            i = dVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.f16395b + ")";
    }
}
