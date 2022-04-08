package com.google.android.datatransport.runtime.synchronization;

import androidx.annotation.WorkerThread;

/* compiled from: SynchronizationGuard.java */
@WorkerThread
/* loaded from: classes.dex */
public interface a {

    /* compiled from: SynchronizationGuard.java */
    /* renamed from: com.google.android.datatransport.runtime.synchronization.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0073a<T> {
        T execute();
    }

    <T> T a(AbstractC0073a<T> aVar);
}
