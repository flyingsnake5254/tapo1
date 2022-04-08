package com.google.android.datatransport.h;

import androidx.annotation.Nullable;
import com.google.android.datatransport.h.i;
import java.util.Map;
import java.util.Objects;

/* compiled from: AutoValue_EventInternal.java */
/* loaded from: classes.dex */
final class b extends i {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f1852b;

    /* renamed from: c  reason: collision with root package name */
    private final h f1853c;

    /* renamed from: d  reason: collision with root package name */
    private final long f1854d;

    /* renamed from: e  reason: collision with root package name */
    private final long f1855e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f1856f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_EventInternal.java */
    /* renamed from: com.google.android.datatransport.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0071b extends i.a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f1857b;

        /* renamed from: c  reason: collision with root package name */
        private h f1858c;

        /* renamed from: d  reason: collision with root package name */
        private Long f1859d;

        /* renamed from: e  reason: collision with root package name */
        private Long f1860e;

        /* renamed from: f  reason: collision with root package name */
        private Map<String, String> f1861f;

        @Override // com.google.android.datatransport.h.i.a
        public i d() {
            String str = "";
            if (this.a == null) {
                str = str + " transportName";
            }
            if (this.f1858c == null) {
                str = str + " encodedPayload";
            }
            if (this.f1859d == null) {
                str = str + " eventMillis";
            }
            if (this.f1860e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f1861f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.a, this.f1857b, this.f1858c, this.f1859d.longValue(), this.f1860e.longValue(), this.f1861f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.h.i.a
        protected Map<String, String> e() {
            Map<String, String> map = this.f1861f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.datatransport.h.i.a
        public i.a f(Map<String, String> map) {
            Objects.requireNonNull(map, "Null autoMetadata");
            this.f1861f = map;
            return this;
        }

        @Override // com.google.android.datatransport.h.i.a
        public i.a g(Integer num) {
            this.f1857b = num;
            return this;
        }

        @Override // com.google.android.datatransport.h.i.a
        public i.a h(h hVar) {
            Objects.requireNonNull(hVar, "Null encodedPayload");
            this.f1858c = hVar;
            return this;
        }

        @Override // com.google.android.datatransport.h.i.a
        public i.a i(long j) {
            this.f1859d = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.h.i.a
        public i.a j(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.a = str;
            return this;
        }

        @Override // com.google.android.datatransport.h.i.a
        public i.a k(long j) {
            this.f1860e = Long.valueOf(j);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.datatransport.h.i
    public Map<String, String> c() {
        return this.f1856f;
    }

    @Override // com.google.android.datatransport.h.i
    @Nullable
    public Integer d() {
        return this.f1852b;
    }

    @Override // com.google.android.datatransport.h.i
    public h e() {
        return this.f1853c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a.equals(iVar.j()) && ((num = this.f1852b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f1853c.equals(iVar.e()) && this.f1854d == iVar.f() && this.f1855e == iVar.k() && this.f1856f.equals(iVar.c());
    }

    @Override // com.google.android.datatransport.h.i
    public long f() {
        return this.f1854d;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f1852b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j = this.f1854d;
        long j2 = this.f1855e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.f1853c.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f1856f.hashCode();
    }

    @Override // com.google.android.datatransport.h.i
    public String j() {
        return this.a;
    }

    @Override // com.google.android.datatransport.h.i
    public long k() {
        return this.f1855e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.a + ", code=" + this.f1852b + ", encodedPayload=" + this.f1853c + ", eventMillis=" + this.f1854d + ", uptimeMillis=" + this.f1855e + ", autoMetadata=" + this.f1856f + "}";
    }

    private b(String str, @Nullable Integer num, h hVar, long j, long j2, Map<String, String> map) {
        this.a = str;
        this.f1852b = num;
        this.f1853c = hVar;
        this.f1854d = j;
        this.f1855e = j2;
        this.f1856f = map;
    }
}
