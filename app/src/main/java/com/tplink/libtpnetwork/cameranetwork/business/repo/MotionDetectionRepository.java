package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import b.d.b.f.b;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.SubscribeItemBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.Utils.u;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.business.model.g;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.util.j;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import io.reactivex.l0.a;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.e;

/* loaded from: classes3.dex */
public class MotionDetectionRepository extends c {

    /* renamed from: d  reason: collision with root package name */
    private g f14289d = new g();

    /* renamed from: e  reason: collision with root package name */
    private ALCameraDevice f14290e;

    /* renamed from: f  reason: collision with root package name */
    private TCMessagePushRepository f14291f;

    public MotionDetectionRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
        this.f14290e = tPCameraDeviceContext.getCameraDevice();
        this.f14291f = (TCMessagePushRepository) b.c(tPCameraDeviceContext.getAccountContext()).a(TCMessagePushRepository.class);
    }

    private boolean C(String str) {
        SubscribeItemBean x = x(str);
        return x != null && x.isSubscribeCameraMotion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void F(boolean z, int i, Boolean bool) throws Exception {
        g gVar = this.f14289d;
        if (gVar != null) {
            gVar.h(z);
            this.f14289d.k(i);
            Y(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void I(boolean z, int i, Boolean bool, Boolean bool2) throws Exception {
        g gVar = this.f14289d;
        if (gVar != null) {
            gVar.h(z);
            this.f14289d.k(i);
            this.f14289d.i(bool);
            Y(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void L(boolean z, int i, Boolean bool) throws Exception {
        g gVar = this.f14289d;
        if (gVar != null) {
            gVar.h(z);
            this.f14289d.k(i);
            Y(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ t O(boolean z, Boolean bool) throws Exception {
        return v(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void Q(g gVar) throws Exception {
        this.f14289d = gVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public /* synthetic */ void U(List list, Boolean bool) throws Exception {
        g gVar = this.f14289d;
        if (gVar != null) {
            gVar.j(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public /* synthetic */ t W(boolean z, ALCameraDevice aLCameraDevice) throws Exception {
        String deviceId = aLCameraDevice.getDeviceId();
        SubscribeItemBean subscribeItemBean = new SubscribeItemBean(deviceId);
        SubscribeItemBean x = x(deviceId);
        if (x != null) {
            subscribeItemBean.setDeviceSubscribeOffBit(x.getDeviceSubscribeOffBit());
        }
        if (z) {
            subscribeItemBean.addSubscribeFunc(EnumMsgSubscribeType.CAMERA_MOTION);
        } else {
            subscribeItemBean.removeSubscribeFunc(EnumMsgSubscribeType.CAMERA_MOTION);
        }
        return this.f14291f.S(deviceId, subscribeItemBean);
    }

    private void Y(boolean z) {
        if (b() != null && b().getDeviceIdMD5() != null && !u.e(b().getDeviceIdMD5()) && z) {
            u.m(b().getDeviceIdMD5(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static g Z(@NonNull MotionDetectionInfo motionDetectionInfo) {
        MotionDetectConfig config = motionDetectionInfo.getConfig();
        List<MotionDetectRegion> regions = motionDetectionInfo.getRegions();
        g gVar = new g();
        if (config != null) {
            gVar.h(OptionSwitch.isOn(config.getEnabled()));
            gVar.k(j.e(config.getDigitalSensitivity(), 0));
            gVar.i(e.a(config.getEnhanced()) ^ true ? Boolean.valueOf(OptionSwitch.isOn(config.getEnhanced())) : null);
        }
        if (regions != null) {
            ArrayList arrayList = new ArrayList(regions.size());
            for (MotionDetectRegion motionDetectRegion : regions) {
                d dVar = new d();
                dVar.g(j.e(motionDetectRegion.getX(), 0));
                dVar.h(j.e(motionDetectRegion.getY(), 0));
                dVar.f(j.e(motionDetectRegion.getWidth(), 0));
                dVar.e(j.e(motionDetectRegion.getHeight(), 0));
                arrayList.add(dVar);
            }
            gVar.j(arrayList);
        }
        return gVar;
    }

    private q<Boolean> u(final boolean z, final int i, Boolean bool) {
        return l().j(new MotionDetectConfig(i, z, bool)).i(m.g()).L0(a.c()).l0(io.reactivex.d0.b.a.a()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.m3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MotionDetectionRepository.this.L(z, i, (Boolean) obj);
            }
        }).g0(f3.f14395c);
    }

    private SubscribeItemBean x(String str) {
        return this.f14291f.E(str);
    }

    public boolean A() {
        ALCameraDevice aLCameraDevice = this.f14290e;
        return aLCameraDevice != null && aLCameraDevice.isOnline();
    }

    public boolean B() {
        ALCameraDevice aLCameraDevice = this.f14290e;
        if (aLCameraDevice != null) {
            return C(aLCameraDevice.getDeviceId());
        }
        return false;
    }

    public q<Boolean> X() {
        return l().b0().i(m.a()).L0(a.c()).g0(e3.f14384c).l0(io.reactivex.d0.b.a.a()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.o3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MotionDetectionRepository.this.Q((g) obj);
            }
        }).g0(i3.f14464c);
    }

    public q<Boolean> a0(final List<d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (d dVar : list) {
            arrayList.add(w(dVar));
        }
        return l().f(arrayList).i(m.g()).L0(a.c()).l0(io.reactivex.d0.b.a.a()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.j3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MotionDetectionRepository.this.U(list, (Boolean) obj);
            }
        }).g0(p3.f14554c);
    }

    public void b0(MotionDetectionInfo motionDetectionInfo) {
        this.f14289d = Z(motionDetectionInfo).a();
    }

    public q<Boolean> c0(final boolean z) {
        ALCameraDevice aLCameraDevice = this.f14290e;
        if (aLCameraDevice == null || !aLCameraDevice.isRemote()) {
            return q.f0(Boolean.FALSE);
        }
        return q.f0(this.f14290e).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.h3
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return MotionDetectionRepository.this.W(z, (ALCameraDevice) obj);
            }
        });
    }

    public void d0(MotionDetectConfig motionDetectConfig) {
        if (motionDetectConfig != null) {
            this.f14289d.h(OptionSwitch.isOn(motionDetectConfig.getEnabled()));
            this.f14289d.k(j.e(motionDetectConfig.getDigitalSensitivity(), 0));
            this.f14289d.i(e.a(motionDetectConfig.getEnhanced()) ^ true ? Boolean.valueOf(OptionSwitch.isOn(motionDetectConfig.getEnhanced())) : null);
        }
    }

    public q<Boolean> s(final boolean z, final int i) {
        return l().j(new MotionDetectConfig(i, z, null)).i(m.g()).L0(a.c()).l0(io.reactivex.d0.b.a.a()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.l3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MotionDetectionRepository.this.F(z, i, (Boolean) obj);
            }
        }).g0(d3.f14372c);
    }

    public q<Boolean> t(final Boolean bool) {
        final boolean e2 = this.f14289d.e();
        final int d2 = this.f14289d.d();
        return l().j(new MotionDetectConfig(d2, e2, bool)).i(m.g()).L0(a.c()).l0(io.reactivex.d0.b.a.a()).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.n3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MotionDetectionRepository.this.I(e2, d2, bool, (Boolean) obj);
            }
        }).g0(g3.f14440c);
    }

    public q<Boolean> v(final boolean z) {
        g gVar = this.f14289d;
        if (gVar == null) {
            return X().N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.k3
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return MotionDetectionRepository.this.O(z, (Boolean) obj);
                }
            });
        }
        return u(z, gVar.d(), this.f14289d.b());
    }

    public MotionDetectRegion w(d dVar) {
        return new MotionDetectRegion(dVar.c(), dVar.d(), dVar.b(), dVar.a());
    }

    public g y() {
        return this.f14289d;
    }

    public boolean z() {
        ALCameraDevice aLCameraDevice = this.f14290e;
        return (aLCameraDevice == null || aLCameraDevice.getCloudIoTDevice() == null) ? false : true;
    }
}
