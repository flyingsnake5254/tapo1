package com.google.android.datatransport.h;

import com.google.android.datatransport.d;
import com.google.android.datatransport.h.m;
import java.util.Objects;

/* compiled from: AutoValue_SendRequest.java */
/* loaded from: classes.dex */
final class c extends m {
    private final n a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1862b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.datatransport.c<?> f1863c;

    /* renamed from: d  reason: collision with root package name */
    private final d<?, byte[]> f1864d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.datatransport.b f1865e;

    /* compiled from: AutoValue_SendRequest.java */
    /* loaded from: classes.dex */
    static final class b extends m.a {
        private n a;

        /* renamed from: b  reason: collision with root package name */
        private String f1866b;

        /* renamed from: c  reason: collision with root package name */
        private com.google.android.datatransport.c<?> f1867c;

        /* renamed from: d  reason: collision with root package name */
        private d<?, byte[]> f1868d;

        /* renamed from: e  reason: collision with root package name */
        private com.google.android.datatransport.b f1869e;

        @Override // com.google.android.datatransport.h.m.a
        public m a() {
            String str = "";
            if (this.a == null) {
                str = str + " transportContext";
            }
            if (this.f1866b == null) {
                str = str + " transportName";
            }
            if (this.f1867c == null) {
                str = str + " event";
            }
            if (this.f1868d == null) {
                str = str + " transformer";
            }
            if (this.f1869e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.a, this.f1866b, this.f1867c, this.f1868d, this.f1869e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.h.m.a
        m.a b(com.google.android.datatransport.b bVar) {
            Objects.requireNonNull(bVar, "Null encoding");
            this.f1869e = bVar;
            return this;
        }

        @Override // com.google.android.datatransport.h.m.a
        m.a c(com.google.android.datatransport.c<?> cVar) {
            Objects.requireNonNull(cVar, "Null event");
            this.f1867c = cVar;
            return this;
        }

        @Override // com.google.android.datatransport.h.m.a
        m.a d(d<?, byte[]> dVar) {
            Objects.requireNonNull(dVar, "Null transformer");
            this.f1868d = dVar;
            return this;
        }

        @Override // com.google.android.datatransport.h.m.a
        public m.a e(n nVar) {
            Objects.requireNonNull(nVar, "Null transportContext");
            this.a = nVar;
            return this;
        }

        @Override // com.google.android.datatransport.h.m.a
        public m.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f1866b = str;
            return this;
        }
    }

    @Override // com.google.android.datatransport.h.m
    public com.google.android.datatransport.b b() {
        return this.f1865e;
    }

    @Override // com.google.android.datatransport.h.m
    com.google.android.datatransport.c<?> c() {
        return this.f1863c;
    }

    @Override // com.google.android.datatransport.h.m
    d<?, byte[]> e() {
        return this.f1864d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.a.equals(mVar.f()) && this.f1862b.equals(mVar.g()) && this.f1863c.equals(mVar.c()) && this.f1864d.equals(mVar.e()) && this.f1865e.equals(mVar.b());
    }

    @Override // com.google.android.datatransport.h.m
    public n f() {
        return this.a;
    }

    @Override // com.google.android.datatransport.h.m
    public String g() {
        return this.f1862b;
    }

    public int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1862b.hashCode()) * 1000003) ^ this.f1863c.hashCode()) * 1000003) ^ this.f1864d.hashCode()) * 1000003) ^ this.f1865e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.a + ", transportName=" + this.f1862b + ", event=" + this.f1863c + ", transformer=" + this.f1864d + ", encoding=" + this.f1865e + "}";
    }

    private c(n nVar, String str, com.google.android.datatransport.c<?> cVar, d<?, byte[]> dVar, com.google.android.datatransport.b bVar) {
        this.a = nVar;
        this.f1862b = str;
        this.f1863c = cVar;
        this.f1864d = dVar;
        this.f1865e = bVar;
    }
}
