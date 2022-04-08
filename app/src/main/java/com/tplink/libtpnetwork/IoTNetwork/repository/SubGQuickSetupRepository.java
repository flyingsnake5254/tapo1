package com.tplink.libtpnetwork.IoTNetwork.repository;

import com.tplink.iot.cloud.bean.thing.params.SubThingAddListParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingCategoryScanParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoListParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoParams;
import com.tplink.iot.cloud.bean.thing.result.SubThingScanListResult;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.IoTSubRequest;
import com.tplink.libtpnetwork.Utils.i;
import io.reactivex.a;
import io.reactivex.e;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;

/* loaded from: classes3.dex */
public class SubGQuickSetupRepository extends AbstractThingRepository {
    public SubGQuickSetupRepository(ThingContext thingContext) {
        super(thingContext, LocalIoTBaseDevice.class, DeviceRunningInfoResult.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i5 */
    public /* synthetic */ e j5(SubThingAddListParams subThingAddListParams, Throwable th) throws Exception {
        if (F0(th)) {
            return this.f13137d.M(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName(), subThingAddListParams);
        }
        return a.m(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k5 */
    public /* synthetic */ e l5(SubThingCategoryScanParams subThingCategoryScanParams, Throwable th) throws Exception {
        if (F0(th)) {
            return this.f13137d.L(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName(), subThingCategoryScanParams);
        }
        return a.m(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m5 */
    public /* synthetic */ t n5(Throwable th) throws Exception {
        if (F0(th)) {
            return this.f13137d.c0(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName());
        }
        return q.J(th);
    }

    public a e5(final SubThingAddListParams subThingAddListParams) {
        return y0("add_child_device_list", subThingAddListParams, Boolean.class).Z().u(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.t9
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return SubGQuickSetupRepository.this.j5(subThingAddListParams, (Throwable) obj);
            }
        });
    }

    public a f5(final SubThingCategoryScanParams subThingCategoryScanParams) {
        return y0("begin_scanning_child_device", subThingCategoryScanParams, Boolean.class).Z().u(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.u9
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return SubGQuickSetupRepository.this.l5(subThingCategoryScanParams, (Throwable) obj);
            }
        });
    }

    public SubThingQuickSetupInfoParams g5(String str, String str2, String str3) {
        return new SubThingQuickSetupInfoParams(str, i.i(new IoTSubRequest("set_device_info", new DeviceInfoParams(str2, str3))));
    }

    public q<SubThingScanListResult> h5(SubThingCategoryScanParams subThingCategoryScanParams) {
        return y0("get_scan_child_device_list", subThingCategoryScanParams, SubThingScanListResult.class).o0(new j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.s9
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return SubGQuickSetupRepository.this.n5((Throwable) obj);
            }
        });
    }

    public a o5(SubThingQuickSetupInfoListParams subThingQuickSetupInfoListParams) {
        return this.f13137d.i1(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName(), subThingQuickSetupInfoListParams);
    }

    public a p5(DeviceInfoParams deviceInfoParams, String str) {
        return C4("set_device_info", deviceInfoParams, Boolean.class, str).Z();
    }

    public a q5() {
        return x0("end_scan_child_device", Boolean.class).Z();
    }
}
