package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_BackendResponse.java */
/* loaded from: classes.dex */
public final class b extends BackendResponse {
    private final BackendResponse.Status a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1947b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BackendResponse.Status status, long j) {
        Objects.requireNonNull(status, "Null status");
        this.a = status;
        this.f1947b = j;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long b() {
        return this.f1947b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        return this.a.equals(backendResponse.c()) && this.f1947b == backendResponse.b();
    }

    public int hashCode() {
        long j = this.f1947b;
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.a + ", nextRequestWaitMillis=" + this.f1947b + "}";
    }
}
