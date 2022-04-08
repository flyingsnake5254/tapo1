package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import b.d.b.f.b;
import com.google.gson.i;
import com.tplink.iot.c.b.j;
import com.tplink.iot.cloud.bean.common.AsyncResult;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.bean.thing.result.ThingServiceSyncResult;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.cloud.mqtt.MqttRepository;
import com.tplink.iot.cloud.mqtt.q0;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import io.reactivex.m0.g;
import io.reactivex.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class ThingCloudASyncRepository extends AbstractIoTCloudRepository implements q0 {
    private j h;
    private com.tplink.iot.c.b.a i;
    private MqttRepository j;
    private Map<String, g<i>> k = new ConcurrentHashMap();

    /* loaded from: classes3.dex */
    class a implements io.reactivex.g0.j<ThingServiceSyncResult, i> {
        a() {
        }

        /* renamed from: a */
        public i apply(ThingServiceSyncResult thingServiceSyncResult) throws Exception {
            return thingServiceSyncResult.getOutputParams();
        }
    }

    public ThingCloudASyncRepository(com.tplink.iot.c.c.a aVar) {
        super(aVar);
        this.h = aVar.k();
        this.i = aVar.k();
        this.j = (MqttRepository) b.a(aVar, MqttRepository.class);
    }

    @Override // com.tplink.iot.cloud.mqtt.q0
    public void a(AsyncResult asyncResult) {
        b.d.w.c.a.e("Cloud Log", "Arrived=" + com.tplink.libtpnetwork.Utils.i.h(asyncResult));
        g<i> remove = this.k.remove(asyncResult.getRequestId());
        if (remove == null) {
            remove = io.reactivex.m0.b.n1();
            this.k.put(asyncResult.getRequestId(), remove);
        }
        if (asyncResult.getCode() == 0) {
            remove.onNext(asyncResult.getData());
            remove.onComplete();
            return;
        }
        remove.onError(new IoTCloudException(asyncResult.getCode(), asyncResult.getMessage(), asyncResult.getData()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.d.b.d.b.a
    public void b() {
        super.b();
        this.k.clear();
    }

    public q<i> w(String str, String str2, ThingServiceParams thingServiceParams) {
        return this.h.l(str, str2, thingServiceParams).L0(io.reactivex.l0.a.c()).g0(new a()).L0(io.reactivex.l0.a.c());
    }
}
