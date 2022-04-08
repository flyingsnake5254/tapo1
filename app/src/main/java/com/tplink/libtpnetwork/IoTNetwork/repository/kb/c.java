package com.tplink.libtpnetwork.IoTNetwork.repository.kb;

import b.d.b.f.b;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.a;
import io.reactivex.q;

/* compiled from: IoTBaseRootRepository.java */
/* loaded from: classes3.dex */
public abstract class c<T extends TPBaseDeviceContext> {
    protected T a;

    /* renamed from: b  reason: collision with root package name */
    protected TPIoTClientManager f13334b;

    public c(T t) {
        this.a = t;
        this.f13334b = (TPIoTClientManager) b.a(t.getAccountContext(), TPIoTClientManager.class);
    }

    public T b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c();

    public abstract q<Boolean> d();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void e();

    public abstract q<Boolean> f();

    public abstract q<Boolean> g();

    public abstract q<Boolean> h();

    public abstract a i(boolean z);

    public abstract q<Boolean> j();

    public abstract a k();
}
