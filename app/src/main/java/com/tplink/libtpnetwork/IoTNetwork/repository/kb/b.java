package com.tplink.libtpnetwork.IoTNetwork.repository.kb;

import android.text.TextUtils;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.x;
import io.reactivex.a;
import io.reactivex.q;

/* compiled from: IoTBaseRepository.java */
/* loaded from: classes3.dex */
public class b extends c<ThingContext> {

    /* renamed from: c  reason: collision with root package name */
    protected x f13333c;

    public b(ThingContext thingContext) {
        super(thingContext);
        if (thingContext.getIoTDevice() == null || !thingContext.getIoTDevice().isSubDevice() || TextUtils.isEmpty(thingContext.getIoTDevice().getParentDeviceIDMD5())) {
            this.f13333c = this.f13334b.Y1(thingContext.getDeviceIdMD5());
        } else {
            this.f13333c = this.f13334b.Y1(thingContext.getIoTDevice().getParentDeviceIDMD5());
        }
        if (this.f13333c == null) {
            this.f13333c = new x();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public void c() {
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public q<Boolean> d() {
        return q.f0(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public void e() {
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public q<Boolean> f() {
        return q.f0(Boolean.FALSE);
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public q<Boolean> g() {
        return q.f0(Boolean.FALSE);
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public a i(boolean z) {
        return a.e();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public q<Boolean> j() {
        return q.f0(Boolean.FALSE);
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public a k() {
        return a.e();
    }
}
