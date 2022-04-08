package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LiveVideoRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;

/* loaded from: classes2.dex */
public class CameraInstallPreviewViewModel extends OnBoardingFragmentViewModel {
    CameraSettingRepository a;

    /* renamed from: b  reason: collision with root package name */
    CommonCameraRepository f10399b;

    /* renamed from: c  reason: collision with root package name */
    LiveVideoRepository f10400c;

    /* renamed from: d  reason: collision with root package name */
    String f10401d;

    /* loaded from: classes2.dex */
    class a implements j<Boolean, String> {
        a() {
        }

        /* renamed from: a */
        public String apply(@NonNull Boolean bool) throws Exception {
            return CameraInstallPreviewViewModel.this.f10400c.t();
        }
    }

    public CameraInstallPreviewViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        String deviceIdMD5 = thingContext.getDeviceIdMD5();
        this.f10401d = deviceIdMD5;
        this.a = (CameraSettingRepository) e.c(deviceIdMD5, CameraSettingRepository.class);
        this.f10400c = (LiveVideoRepository) e.c(this.f10401d, LiveVideoRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ t j(CameraComponent cameraComponent) throws Exception {
        CameraSettingRepository cameraSettingRepository = this.a;
        return cameraSettingRepository.z1(!cameraSettingRepository.x().getImageFlipEnable());
    }

    public q<String> f() {
        if (TextUtils.isEmpty(this.f10400c.t())) {
            b.d.w.c.a.c("CameraInstallPreview", "getVideoResolution---111");
            return this.f10400c.F().g0(new a());
        }
        b.d.w.c.a.c("CameraInstallPreview", "getVideoResolution---222");
        return q.f0(this.f10400c.t());
    }

    @SuppressLint({"CheckResult"})
    public q<Boolean> m() {
        if (this.a.x() == null) {
            return this.f10399b.K0().N(new j() { // from class: com.tplink.iot.viewmodel.ipcamera.onboardingv2.f
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return CameraInstallPreviewViewModel.this.j((CameraComponent) obj);
                }
            }).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(g.f10449c).C(e.f10443c);
        }
        CameraSettingRepository cameraSettingRepository = this.a;
        return cameraSettingRepository.z1(!cameraSettingRepository.x().getImageFlipEnable()).E(i.f10455c).C(h.f10452c);
    }
}
