package com.tplink.iot.base;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: StaticHandler.java */
/* loaded from: classes2.dex */
public class b extends Handler {
    private WeakReference<a> a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6083b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6084c = false;

    /* compiled from: StaticHandler.java */
    /* loaded from: classes2.dex */
    public interface a {
        void handleMessage(Message message);
    }

    public b(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        if (!this.f6084c && (aVar = this.a.get()) != null) {
            aVar.handleMessage(message);
        }
    }
}
