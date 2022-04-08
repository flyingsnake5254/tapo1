package com.google.android.datatransport;

import androidx.annotation.Nullable;
import java.util.Objects;

/* compiled from: AutoValue_Event.java */
/* loaded from: classes.dex */
final class a<T> extends c<T> {
    private final Integer a;

    /* renamed from: b  reason: collision with root package name */
    private final T f1782b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f1783c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@Nullable Integer num, T t, Priority priority) {
        this.a = num;
        Objects.requireNonNull(t, "Null payload");
        this.f1782b = t;
        Objects.requireNonNull(priority, "Null priority");
        this.f1783c = priority;
    }

    @Override // com.google.android.datatransport.c
    @Nullable
    public Integer a() {
        return this.a;
    }

    @Override // com.google.android.datatransport.c
    public T b() {
        return this.f1782b;
    }

    @Override // com.google.android.datatransport.c
    public Priority c() {
        return this.f1783c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Integer num = this.a;
        if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
            if (this.f1782b.equals(cVar.b()) && this.f1783c.equals(cVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f1782b.hashCode()) * 1000003) ^ this.f1783c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.a + ", payload=" + this.f1782b + ", priority=" + this.f1783c + "}";
    }
}
