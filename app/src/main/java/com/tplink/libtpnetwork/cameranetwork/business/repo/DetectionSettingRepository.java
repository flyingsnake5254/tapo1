package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionSetting;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import io.reactivex.g0.j;
import io.reactivex.q;

/* compiled from: DetectionSettingRepository.kt */
/* loaded from: classes3.dex */
public final class DetectionSettingRepository extends CameraSettingRepository {

    /* compiled from: DetectionSettingRepository.kt */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements j<Response<DetectionSetting>, DetectionSetting> {

        /* renamed from: c  reason: collision with root package name */
        public static final a f14239c = new a();

        a() {
        }

        /* renamed from: a */
        public final DetectionSetting apply(Response<DetectionSetting> it) {
            kotlin.jvm.internal.j.e(it, "it");
            return it.getResult();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetectionSettingRepository(TPCameraDeviceContext tpCameraDeviceContext) {
        super(tpCameraDeviceContext);
        kotlin.jvm.internal.j.e(tpCameraDeviceContext, "tpCameraDeviceContext");
    }

    public final q<DetectionSetting> L1(CameraComponent component) {
        kotlin.jvm.internal.j.e(component, "component");
        q g0 = l().J(component).L0(io.reactivex.l0.a.c()).g0(a.f14239c);
        kotlin.jvm.internal.j.d(g0, "getCameraClient().getDet…       .map { it.result }");
        return g0;
    }
}
