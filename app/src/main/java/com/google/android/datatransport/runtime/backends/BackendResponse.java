package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class BackendResponse {

    /* loaded from: classes.dex */
    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static BackendResponse a() {
        return new b(Status.FATAL_ERROR, -1L);
    }

    public static BackendResponse d(long j) {
        return new b(Status.OK, j);
    }

    public static BackendResponse e() {
        return new b(Status.TRANSIENT_ERROR, -1L);
    }

    public abstract long b();

    public abstract Status c();
}
