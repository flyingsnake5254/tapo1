package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;
import java.util.Objects;

/* compiled from: AutoValue_BatchedLogRequest.java */
/* loaded from: classes.dex */
final class d extends j {
    private final List<l> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(List<l> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.a = list;
    }

    @Override // com.google.android.datatransport.cct.internal.j
    @NonNull
    @Encodable.Field(name = "logRequest")
    public List<l> c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return this.a.equals(((j) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.a + "}";
    }
}
