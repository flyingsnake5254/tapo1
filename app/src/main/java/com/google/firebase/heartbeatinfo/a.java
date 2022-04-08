package com.google.firebase.heartbeatinfo;

import java.util.concurrent.ThreadFactory;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ a f4802c = new a();

    private /* synthetic */ a() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return DefaultHeartBeatInfo.lambda$static$0(runnable);
    }
}
