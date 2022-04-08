package b.d.j.a;

import b.d.p.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PtsCalculator.java */
/* loaded from: classes3.dex */
public class b {
    Map<String, c> a;

    /* renamed from: b  reason: collision with root package name */
    Map<String, c> f516b;

    /* compiled from: PtsCalculator.java */
    /* renamed from: b.d.j.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0021b {
        private static final b a = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PtsCalculator.java */
    /* loaded from: classes3.dex */
    public static class c {
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f517b;

        /* renamed from: c  reason: collision with root package name */
        public long f518c;

        /* renamed from: d  reason: collision with root package name */
        public long f519d;

        /* renamed from: e  reason: collision with root package name */
        public long f520e;

        private c() {
            this.a = 0L;
            this.f517b = 0L;
            this.f518c = 0L;
            this.f519d = 0L;
            this.f520e = 0L;
        }

        public void a() {
            this.a = 0L;
            this.f517b = 0L;
            this.f518c = 0L;
            this.f519d = 0L;
            this.f520e = 0L;
        }
    }

    public static b a() {
        return C0021b.a;
    }

    private c b(String str, int i) {
        String str2 = "" + str + "_type_" + i;
        c cVar = this.f516b.get(str2);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f516b.put(str2, cVar2);
        return cVar2;
    }

    private c d(String str, int i) {
        String str2 = "" + str + "_type_" + i;
        c cVar = this.a.get(str2);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.a.put(str2, cVar2);
        return cVar2;
    }

    public long c(String str, int i) {
        return b(str, i).f518c;
    }

    public long e(String str, int i) {
        return d(str, i).f518c;
    }

    public void f(String str, int i) {
        String str2 = "" + str + "_type_" + i;
        c cVar = this.a.get(str2);
        if (cVar == null) {
            cVar = new c();
        }
        cVar.a();
        this.a.put(str2, cVar);
        c cVar2 = this.f516b.get(str2);
        if (cVar2 == null) {
            cVar2 = new c();
        }
        cVar2.a();
        this.f516b.put(str2, cVar2);
    }

    public long g(String str, int i, com.tplink.libtpdemux.tsdemux.common.a aVar, int i2) {
        long j;
        long e2 = i2 / ((aVar.e() * 2) / 1000);
        c b2 = b(str, i);
        long f2 = aVar.f() * 1000;
        if (f2 != b2.f519d) {
            b2.f520e = 0L;
        }
        long j2 = b2.a;
        if (j2 == 0 && b2.f517b == 0) {
            b2.a = aVar.d();
            b2.f517b = aVar.d();
            j = 0;
        } else {
            b2.f517b = j2;
            long d2 = aVar.d();
            b2.a = d2;
            j = ((d2 - b2.f517b) * 1000) / 90000;
        }
        if (Math.abs(j) > 1000 || j < 0) {
            long j3 = b2.a;
            if (j3 >= 90000 || Math.abs(j3 - b2.f517b) < 1073741824) {
                b2.f517b = b2.a;
                j = 0;
            } else {
                b2.f517b = 0L;
                long d3 = aVar.d();
                b2.a = d3;
                j = ((d3 - b2.f517b) * 1000) / 90000;
            }
        }
        if (j <= 0 || j >= e2) {
            e2 = j;
        }
        long j4 = b2.f520e + e2;
        b2.f520e = j4;
        b2.f518c = j4 + f2;
        if (f2 != b2.f519d) {
            b2.f519d = f2;
        }
        this.f516b.put(str, b2);
        return e2;
    }

    public long h(String str, int i, com.tplink.libtpdemux.tsdemux.common.c cVar) {
        long j;
        c d2 = d(str, i);
        long c2 = cVar.c() * 1000;
        long j2 = 0;
        if (c2 != d2.f519d) {
            d2.f520e = 0L;
        }
        long j3 = d2.a;
        if (j3 == 0 && d2.f517b == 0) {
            d2.a = cVar.b();
            d2.f517b = cVar.b();
            j = 0;
        } else {
            d2.f517b = j3;
            long b2 = cVar.b();
            d2.a = b2;
            j = ((b2 - d2.f517b) * 1000) / 90000;
        }
        if (Math.abs(j) > 1000 || j < 0) {
            long j4 = d2.a;
            if (j4 >= 90000 || Math.abs(j4 - d2.f517b) < 1073741824) {
                d.a("PtsCalculator", "video pts index error pts " + d2.a + " last " + d2.f517b);
                d2.f517b = d2.a;
            } else {
                d2.f517b = 0L;
                long b3 = cVar.b();
                d2.a = b3;
                j2 = ((b3 - d2.f517b) * 1000) / 90000;
            }
        } else {
            j2 = j;
        }
        long j5 = d2.f520e + j2;
        d2.f520e = j5;
        d2.f518c = j5 + c2;
        if (c2 != d2.f519d) {
            d2.f519d = c2;
        }
        this.a.put(str, d2);
        return j2;
    }

    private b() {
        this.a = new HashMap();
        this.f516b = new HashMap();
    }
}
