package com.google.android.datatransport.h;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.h.n;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: AutoValue_TransportContext.java */
/* loaded from: classes.dex */
final class d extends n {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f1870b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f1871c;

    /* compiled from: AutoValue_TransportContext.java */
    /* loaded from: classes.dex */
    static final class b extends n.a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f1872b;

        /* renamed from: c  reason: collision with root package name */
        private Priority f1873c;

        @Override // com.google.android.datatransport.h.n.a
        public n a() {
            String str = "";
            if (this.a == null) {
                str = str + " backendName";
            }
            if (this.f1873c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.a, this.f1872b, this.f1873c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.h.n.a
        public n.a b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.a = str;
            return this;
        }

        @Override // com.google.android.datatransport.h.n.a
        public n.a c(@Nullable byte[] bArr) {
            this.f1872b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.h.n.a
        public n.a d(Priority priority) {
            Objects.requireNonNull(priority, "Null priority");
            this.f1873c = priority;
            return this;
        }
    }

    @Override // com.google.android.datatransport.h.n
    public String b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.h.n
    @Nullable
    public byte[] c() {
        return this.f1870b;
    }

    @Override // com.google.android.datatransport.h.n
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Priority d() {
        return this.f1871c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.a.equals(nVar.b())) {
            if (Arrays.equals(this.f1870b, nVar instanceof d ? ((d) nVar).f1870b : nVar.c()) && this.f1871c.equals(nVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1870b)) * 1000003) ^ this.f1871c.hashCode();
    }

    private d(String str, @Nullable byte[] bArr, Priority priority) {
        this.a = str;
        this.f1870b = bArr;
        this.f1871c = priority;
    }
}
