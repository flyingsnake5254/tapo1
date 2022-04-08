package com.tplink.iot.c.c;

import androidx.annotation.NonNull;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.iot.cloud.bean.common.IoTWebServiceIdParams;
import java.lang.reflect.InvocationTargetException;

/* compiled from: IoTAccountContext.java */
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: f  reason: collision with root package name */
    private com.tplink.iot.c.a f6088f;
    private boolean g;
    private IoTWebServiceIdParams h;

    public a(TCAccountBean tCAccountBean, com.tplink.cloud.context.a aVar, String str, IoTWebServiceIdParams ioTWebServiceIdParams) {
        super(tCAccountBean, aVar);
        this.h = ioTWebServiceIdParams;
        this.f6088f = new com.tplink.iot.c.a(str, new b(str, ioTWebServiceIdParams, tCAccountBean.getToken(), aVar));
    }

    @Override // com.tplink.cloud.context.b
    public void b() {
        this.f6088f.Q1();
        super.b();
    }

    @Override // com.tplink.cloud.context.b, b.d.b.d.b.b.c, b.d.b.d.b.b.C0014b, b.d.b.d.b.b.a
    @NonNull
    public <T extends b.d.b.d.b.a> T create(@NonNull Class<T> cls) {
        Throwable e2;
        try {
            return cls.getConstructor(a.class).newInstance(this);
        } catch (IllegalAccessException e3) {
            e2 = e3;
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (InstantiationException e4) {
            e2 = e4;
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException unused) {
            return (T) super.create(cls);
        } catch (InvocationTargetException e5) {
            e2 = e5;
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        }
    }

    @Override // com.tplink.cloud.context.b
    public void g(TCAccountBean tCAccountBean) {
        String token = c() != null ? c().getToken() : null;
        super.g(tCAccountBean);
        if (tCAccountBean != null) {
            this.g = token != null && !token.equals(tCAccountBean.getToken());
            this.f6088f.T1(tCAccountBean.getToken());
        }
    }

    public String h() {
        return e().b();
    }

    public String i() {
        return this.f6088f.S1().d();
    }

    public String j() {
        return this.f6088f.S1().e();
    }

    public com.tplink.iot.c.a k() {
        return this.f6088f;
    }

    public IoTWebServiceIdParams l() {
        return this.h;
    }

    public String m() {
        return e().q();
    }

    public boolean n() {
        return this.g;
    }

    public void o(String str) {
        this.f6088f.S1().m(str);
    }

    public void p(boolean z) {
        this.g = z;
    }
}
