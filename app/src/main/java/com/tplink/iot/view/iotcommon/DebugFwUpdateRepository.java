package com.tplink.iot.view.iotcommon;

import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.DeviceServerInfoTestParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.FwDownloadStatus;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import io.reactivex.g0.e;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.concurrent.TimeUnit;

/* compiled from: DebugFwUpdateActivity.kt */
/* loaded from: classes2.dex */
public final class DebugFwUpdateRepository extends AbstractThingRepository {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements e {
        final /* synthetic */ FwDownloadStatus a;

        a(FwDownloadStatus fwDownloadStatus) {
            this.a = fwDownloadStatus;
        }

        @Override // io.reactivex.g0.e
        public final boolean a() {
            return this.a.getErrorCode() == 3 || this.a.getErrorCode() == 5 || this.a.getErrorCode() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T, R> implements j<FirmwareDownloadState, FwDownloadStatus> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FwDownloadStatus f8584c;

        b(FwDownloadStatus fwDownloadStatus) {
            this.f8584c = fwDownloadStatus;
        }

        /* renamed from: a */
        public final FwDownloadStatus apply(FirmwareDownloadState it) {
            kotlin.jvm.internal.j.e(it, "it");
            int status = it.getStatus();
            if (status == -1002 || status == -1001) {
                this.f8584c.setErrorCode(3);
            } else if (status == 1 || status == 2) {
                this.f8584c.setErrorCode(4);
                this.f8584c.setDownloadProgress(it.getDownloadProgress());
            } else if (status != 3) {
                this.f8584c.setErrorCode(0);
            } else {
                this.f8584c.setErrorCode(5);
                this.f8584c.setDownloadProgress(100);
                this.f8584c.setInstallTime(it.getUpgradeTime() + it.getRebootTime());
            }
            return this.f8584c;
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class c<T, R> implements j<Long, t<? extends FwDownloadStatus>> {
        c() {
        }

        /* renamed from: a */
        public final t<? extends FwDownloadStatus> apply(Long it) {
            kotlin.jvm.internal.j.e(it, "it");
            return DebugFwUpdateRepository.this.f5();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugFwUpdateRepository(ThingContext thingContext) {
        super(thingContext, LocalIoTBaseDevice.class, DeviceRunningInfoResult.class);
        kotlin.jvm.internal.j.e(thingContext, "thingContext");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final q<FwDownloadStatus> f5() {
        FwDownloadStatus fwDownloadStatus = new FwDownloadStatus(2);
        q g0 = u1().o(1L, TimeUnit.SECONDS).s0(new a(fwDownloadStatus)).g0(new b(fwDownloadStatus));
        kotlin.jvm.internal.j.d(g0, "firmwareDownloadState.de…p downloadState\n        }");
        return g0;
    }

    public final ThingModel g5() {
        ThingCloudRepository thingCloudRepository = this.f13137d;
        T mThingContext = this.a;
        kotlin.jvm.internal.j.d(mThingContext, "mThingContext");
        return thingCloudRepository.m0(((ThingContext) mThingContext).getThingModelId());
    }

    public final io.reactivex.a h5(String url) {
        kotlin.jvm.internal.j.e(url, "url");
        io.reactivex.a Z = y0("fw_download", new f(url), Boolean.class).Z();
        kotlin.jvm.internal.j.d(Z, "postRequest(IoTNetworkDe…        .ignoreElements()");
        return Z;
    }

    public final io.reactivex.a i5(String serverType) {
        kotlin.jvm.internal.j.e(serverType, "serverType");
        io.reactivex.a Z = y0("set_server_info", new DeviceServerInfoTestParams(serverType), Boolean.class).Z();
        kotlin.jvm.internal.j.d(Z, "postRequest(IoTNetworkDe…        .ignoreElements()");
        return Z;
    }

    public final io.reactivex.a j5(String name, String psd, String keyType) {
        kotlin.jvm.internal.j.e(name, "name");
        kotlin.jvm.internal.j.e(psd, "psd");
        kotlin.jvm.internal.j.e(keyType, "keyType");
        io.reactivex.a Z = y0("set_wireless_info", new WirelessInfoParams(name, psd, keyType), Boolean.class).Z();
        kotlin.jvm.internal.j.d(Z, "postRequest(IoTNetworkDe…        .ignoreElements()");
        return Z;
    }

    public final q<FwDownloadStatus> k5() {
        q N = q.W0(2L, TimeUnit.SECONDS).N(new c());
        kotlin.jvm.internal.j.d(N, "Observable.timer(2, Time…{ getFwDownloadStatus() }");
        return N;
    }
}
