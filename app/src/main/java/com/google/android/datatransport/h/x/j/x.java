package com.google.android.datatransport.h.x.j;

import com.google.android.datatransport.h.i;
import com.google.android.datatransport.h.n;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_PersistedEvent.java */
/* loaded from: classes.dex */
public final class x extends e0 {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final n f1942b;

    /* renamed from: c  reason: collision with root package name */
    private final i f1943c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(long j, n nVar, i iVar) {
        this.a = j;
        Objects.requireNonNull(nVar, "Null transportContext");
        this.f1942b = nVar;
        Objects.requireNonNull(iVar, "Null event");
        this.f1943c = iVar;
    }

    @Override // com.google.android.datatransport.h.x.j.e0
    public i b() {
        return this.f1943c;
    }

    @Override // com.google.android.datatransport.h.x.j.e0
    public long c() {
        return this.a;
    }

    @Override // com.google.android.datatransport.h.x.j.e0
    public n d() {
        return this.f1942b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return this.a == e0Var.c() && this.f1942b.equals(e0Var.d()) && this.f1943c.equals(e0Var.b());
    }

    public int hashCode() {
        long j = this.a;
        return this.f1943c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f1942b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.a + ", transportContext=" + this.f1942b + ", event=" + this.f1943c + "}";
    }
}
