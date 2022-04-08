package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.h.i;
import com.google.android.datatransport.runtime.backends.f;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: AutoValue_BackendRequest.java */
/* loaded from: classes.dex */
final class a extends f {
    private final Iterable<i> a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f1945b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_BackendRequest.java */
    /* loaded from: classes.dex */
    public static final class b extends f.a {
        private Iterable<i> a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f1946b;

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f a() {
            String str = "";
            if (this.a == null) {
                str = str + " events";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.f1946b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f.a b(Iterable<i> iterable) {
            Objects.requireNonNull(iterable, "Null events");
            this.a = iterable;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f.a c(@Nullable byte[] bArr) {
            this.f1946b = bArr;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public Iterable<i> b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    @Nullable
    public byte[] c() {
        return this.f1945b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.a.equals(fVar.b())) {
            if (Arrays.equals(this.f1945b, fVar instanceof a ? ((a) fVar).f1945b : fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1945b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.a + ", extras=" + Arrays.toString(this.f1945b) + "}";
    }

    private a(Iterable<i> iterable, @Nullable byte[] bArr) {
        this.a = iterable;
        this.f1945b = bArr;
    }
}
