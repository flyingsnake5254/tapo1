package com.tplink.libtpnetwork.cameranetwork.bean;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.BaseDeviceCache;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;

/* loaded from: classes3.dex */
public class CameraDeviceCache extends BaseDeviceCache {
    @c(ImagesContract.LOCAL)
    private CameraBasicInfo cameraBasicInfo;

    public CameraDeviceCache() {
    }

    public CameraBasicInfo getCameraBasicInfo() {
        return this.cameraBasicInfo;
    }

    public void setCameraBasicInfo(CameraBasicInfo cameraBasicInfo) {
        this.cameraBasicInfo = cameraBasicInfo;
    }

    public CameraDeviceCache(ALCameraDevice aLCameraDevice) {
        TCDeviceBean cloudCameraDevice = aLCameraDevice.getCloudCameraDevice();
        if (cloudCameraDevice != null) {
            this.cloudIoTDevice = cloudCameraDevice.getDeviceInfo();
        }
        this.cameraBasicInfo = aLCameraDevice.getCameraBasicInfo();
    }
}
