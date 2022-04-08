package com.tplink.libtpnetwork.cameranetwork.business.repo.firmware;

import androidx.lifecycle.Observer;
import b.d.b.f.a;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.g4.k;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.FirmwareUpdateStatus;
import com.tplink.libtpnetwork.cameranetwork.model.LatestFirmwareInfo;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import io.reactivex.e0.b;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.m0.d;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class FirmwareManager extends a {
    private g<t<List<String>>> g;
    private TPIoTClientManager h;

    /* renamed from: f  reason: collision with root package name */
    private b f14404f = new b();

    /* renamed from: d  reason: collision with root package name */
    private Map<String, u> f14402d = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private List<String> f14401c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private d<String> f14403e = d.n1();

    public FirmwareManager(com.tplink.cloud.context.b bVar) {
        super(bVar);
        g l1 = io.reactivex.m0.b.n1().l1();
        this.g = l1;
        l1.onNext(new t(new ArrayList()));
        this.h = (TPIoTClientManager) b.d.b.f.b.a(bVar, TPIoTClientManager.class);
        J();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List D(t tVar) throws Exception {
        if (tVar.a() == null) {
            return new ArrayList();
        }
        return (List) tVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ t F(List list) throws Exception {
        e(list);
        d(list);
        return q.f0(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void H(java.util.List r4) {
        /*
            r3 = this;
            java.util.List<java.lang.String> r0 = r3.f14401c
            r0.clear()
            if (r4 == 0) goto L_0x0069
            java.util.Iterator r0 = r4.iterator()
        L_0x000b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0026
            java.lang.Object r1 = r0.next()
            com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice r1 = (com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice) r1
            com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState r2 = r1.getDeviceState()
            if (r2 == 0) goto L_0x0025
            com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState r2 = com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState.LOADING
            com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState r1 = r1.getDeviceState()
            if (r2 != r1) goto L_0x000b
        L_0x0025:
            return
        L_0x0026:
            java.util.Iterator r4 = r4.iterator()
        L_0x002a:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0069
            java.lang.Object r0 = r4.next()
            com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice r0 = (com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice) r0
            com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState r1 = com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState.ONLINE
            com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState r2 = r0.getDeviceState()
            if (r1 != r2) goto L_0x0048
            java.util.List<java.lang.String> r1 = r3.f14401c
            java.lang.String r0 = r0.getDeviceIdMD5()
            r1.add(r0)
            goto L_0x002a
        L_0x0048:
            com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState r1 = com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState.OFFLINE
            com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState r2 = r0.getDeviceState()
            if (r1 != r2) goto L_0x002a
            java.util.List<java.lang.String> r1 = r3.f14401c
            java.lang.String r2 = r0.getDeviceIdMD5()
            r1.add(r2)
            java.lang.String r0 = r0.getDeviceIdMD5()
            java.lang.Class<com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository> r1 = com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository.class
            com.tplink.libtpnetwork.IoTNetwork.repository.kb.c r0 = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(r0, r1)
            com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository r0 = (com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository) r0
            r0.T()
            goto L_0x002a
        L_0x0069:
            io.reactivex.m0.g<com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.t<java.util.List<java.lang.String>>> r4 = r3.g
            com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.t r0 = new com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.t
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.List<java.lang.String> r2 = r3.f14401c
            r1.<init>(r2)
            r0.<init>(r1)
            r4.onNext(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager.H(java.util.List):void");
    }

    private void J() {
        this.h.M1().observeForever(new Observer() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FirmwareManager.this.H((List) obj);
            }
        });
    }

    private void d(List<String> list) {
        if (!(list == null || list.isEmpty())) {
            for (final String str : list) {
                BaseALIoTDevice I1 = TPIoTClientManager.I1(str);
                if (I1 == null || EnumIoTDeviceState.ONLINE == I1.getDeviceState()) {
                    final FirmwareRepository firmwareRepository = (FirmwareRepository) e.c(str, FirmwareRepository.class);
                    this.f14404f.b(((CommonCameraRepository) e.c(str, CommonCameraRepository.class)).K0().L(l.f14422c).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.h
                        @Override // io.reactivex.g0.j
                        public final Object apply(Object obj) {
                            t x;
                            CameraComponent cameraComponent = (CameraComponent) obj;
                            x = FirmwareRepository.this.x();
                            return x;
                        }
                    }).x0(new k(new int[]{60, 60})).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.n
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            FirmwareManager.this.n(str, (FirmwareUpdateStatus) obj);
                        }
                    }).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.k
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            FirmwareManager.this.j(str, (Throwable) obj);
                        }
                    }).F0());
                } else {
                    K(str, "normal", Boolean.FALSE);
                }
            }
        }
    }

    private void e(List<String> list) {
        if (!(list == null || list.isEmpty())) {
            for (final String str : list) {
                b.d.w.c.a.c("FirmwareManager", "getAllDeviceFirmwareInfo:  " + str);
                BaseALIoTDevice I1 = TPIoTClientManager.I1(str);
                if (I1 == null || EnumIoTDeviceState.ONLINE == I1.getDeviceState()) {
                    final FirmwareRepository firmwareRepository = (FirmwareRepository) e.c(str, FirmwareRepository.class);
                    this.f14404f.b(((CommonCameraRepository) e.c(str, CommonCameraRepository.class)).K0().L(c.f14409c).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.e
                        @Override // io.reactivex.g0.j
                        public final Object apply(Object obj) {
                            return FirmwareManager.this.q(firmwareRepository, str, (CameraComponent) obj);
                        }
                    }).H0(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.f
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            b.d.w.c.a.e("FirmwareManager", str + SSLClient.WHITE_SPACE + ((LatestFirmwareInfo) obj));
                        }
                    }, r.f14429c));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(String str, Throwable th) throws Exception {
        K(str, "normal", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(String str, FirmwareUpdateStatus firmwareUpdateStatus) throws Exception {
        b.d.w.c.a.e("FirmwareManager", str + SSLClient.WHITE_SPACE + firmwareUpdateStatus.getStatus() + SSLClient.WHITE_SPACE + firmwareUpdateStatus.getLastUpgradingSuccess());
        K(str, firmwareUpdateStatus.getStatus(), Boolean.valueOf(firmwareUpdateStatus.getLastUpgradingSuccess()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ t q(FirmwareRepository firmwareRepository, final String str, CameraComponent cameraComponent) throws Exception {
        return firmwareRepository.v().E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.d
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                FirmwareManager.this.C(str, (LatestFirmwareInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ t u(FirmwareRepository firmwareRepository, final String str, CameraComponent cameraComponent) throws Exception {
        return firmwareRepository.u().E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.j
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                FirmwareManager.this.A(str, (LatestFirmwareInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ u y(String str) throws Exception {
        return this.f14402d.get(str);
    }

    public void I() {
        this.g.D0(1L).Q0(1L).g0(i.f14417c).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.p
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FirmwareManager.this.F((List) obj);
            }
        }).T0(30L, TimeUnit.SECONDS).F0();
    }

    public void K(String str, String str2, Boolean bool) {
        u uVar = this.f14402d.get(str);
        if (uVar == null) {
            uVar = new u();
        }
        uVar.j("normal".equals(str2));
        uVar.k(bool.booleanValue());
        this.f14402d.put(str, uVar);
        this.f14403e.onNext(str);
    }

    /* renamed from: L */
    public void z(String str, LatestFirmwareInfo latestFirmwareInfo) {
        u uVar = this.f14402d.get(str);
        if (uVar == null) {
            uVar = new u();
        }
        uVar.i(latestFirmwareInfo.getVersion());
        uVar.g(latestFirmwareInfo.getRelease_log());
        uVar.h(latestFirmwareInfo.getType());
        this.f14402d.put(str, uVar);
        BaseALIoTDevice Z1 = this.h.Z1(str);
        if (Z1 != null) {
            this.h.T0(str, s.a(Z1, latestFirmwareInfo));
        }
    }

    public void M(String str) {
        this.f14402d.remove(str);
        f(str);
    }

    public void f(final String str) {
        final FirmwareRepository firmwareRepository = (FirmwareRepository) e.c(str, FirmwareRepository.class);
        this.f14404f.b(((CommonCameraRepository) e.c(str, CommonCameraRepository.class)).K0().L(b.f14408c).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.a
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FirmwareManager.this.u(firmwareRepository, str, (CameraComponent) obj);
            }
        }).H0(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.m
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                b.d.w.c.a.e("FirmwareManager", str + SSLClient.WHITE_SPACE + ((LatestFirmwareInfo) obj));
            }
        }, r.f14429c));
    }

    public u g(String str) {
        return this.f14402d.get(str);
    }

    public q<u> h(final String str) {
        return this.f14403e.L(new l() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.q
            @Override // io.reactivex.g0.l
            public final boolean test(Object obj) {
                boolean equals;
                equals = ((String) obj).equals(str);
                return equals;
            }
        }).g0(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.o
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FirmwareManager.this.y((String) obj);
            }
        }).l0(io.reactivex.d0.b.a.a());
    }
}
