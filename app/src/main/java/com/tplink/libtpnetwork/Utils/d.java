package com.tplink.libtpnetwork.Utils;

import android.text.TextUtils;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.ServiceList;
import io.reactivex.q;

/* compiled from: CameraTapoCareUtils.java */
/* loaded from: classes3.dex */
public class d {
    public static boolean a(ComponentType componentType, String str) {
        ServiceList c2;
        ALCameraDevice aLCameraDevice = (ALCameraDevice) TPIoTClientManager.I1(str);
        if (aLCameraDevice == null || aLCameraDevice.getCameraComponent() == null || !aLCameraDevice.getCameraComponent().isSupportSubscriptionService() || (c2 = c(str)) == null || componentType == null) {
            return false;
        }
        return !c2.isComponentNeedSubscription(componentType);
    }

    public static q<ServiceList> b(String str) {
        ALCameraDevice aLCameraDevice = (ALCameraDevice) TPIoTClientManager.I1(str);
        if (aLCameraDevice == null || aLCameraDevice.getCameraComponent() == null || !aLCameraDevice.getCameraComponent().isSupportSubscriptionService()) {
            return q.I();
        }
        return ((CameraSettingRepository) e.c(str, CameraSettingRepository.class)).J();
    }

    public static ServiceList c(String str) {
        CameraSettingRepository cameraSettingRepository = (CameraSettingRepository) e.c(str, CameraSettingRepository.class);
        if (cameraSettingRepository.x() != null) {
            return cameraSettingRepository.x().getTapoCareNeedPayFunctionList();
        }
        return (ServiceList) i.b(o.h0().A(str), ServiceList.class);
    }

    public static boolean d(String str) {
        TPCameraDeviceContext K1;
        ALCameraDevice cameraDevice;
        boolean z = false;
        if (TextUtils.isEmpty(str) || (K1 = TPIoTClientManager.K1(str)) == null || (cameraDevice = K1.getCameraDevice()) == null) {
            return false;
        }
        String deviceId = cameraDevice.getDeviceId();
        CloudVideoRepository cloudVideoRepository = (CloudVideoRepository) b.a(a.f(), CloudVideoRepository.class);
        if (cloudVideoRepository.h0() && cloudVideoRepository.i0(deviceId)) {
            z = true;
        }
        b.d.w.c.a.d("当前设备支持TapoCare：" + z);
        return z;
    }

    public static boolean e(String str) {
        return ((CloudVideoRepository) b.a(a.f(), CloudVideoRepository.class)).l0(str);
    }
}
