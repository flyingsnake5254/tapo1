package com.tplink.iot.model.home;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

/* compiled from: LocalDeviceBean.java */
/* loaded from: classes2.dex */
public class k extends e {

    /* renamed from: b  reason: collision with root package name */
    private BaseALIoTDevice f8159b;

    /* renamed from: c  reason: collision with root package name */
    private HomeCacheBean f8160c;

    public k(HomeCacheBean homeCacheBean) {
        z(homeCacheBean);
    }

    private void o() {
        if (this.f8160c == null) {
            this.f8160c = new HomeCacheBean();
        }
    }

    public void A(String str) {
        o();
        this.f8160c.setDeviceIdMD5(str);
    }

    public void B(boolean z) {
        o();
        this.f8160c.setNewDevice(z);
    }

    public void C(int i) {
        o();
        this.f8160c.setSortValue(i);
    }

    @Override // com.tplink.iot.model.home.e
    @NonNull
    public String d() {
        String h = h();
        return h == null ? "" : h;
    }

    @Override // com.tplink.iot.model.home.e
    public String e() {
        HomeCacheBean homeCacheBean;
        BaseALIoTDevice baseALIoTDevice = this.f8159b;
        String deviceIdMD5 = baseALIoTDevice != null ? baseALIoTDevice.getDeviceIdMD5() : null;
        if (TextUtils.isEmpty(deviceIdMD5) && (homeCacheBean = this.f8160c) != null) {
            deviceIdMD5 = homeCacheBean.getDeviceIdMD5();
        }
        return deviceIdMD5 == null ? "" : deviceIdMD5;
    }

    @Override // com.tplink.iot.model.home.e
    @NonNull
    public String f() {
        return l.c(AppContext.f6185c, this.f8159b);
    }

    public BaseALIoTDevice g() {
        return this.f8159b;
    }

    public String h() {
        BaseALIoTDevice baseALIoTDevice = this.f8159b;
        if (baseALIoTDevice != null) {
            return baseALIoTDevice.getDeviceId();
        }
        return null;
    }

    public String i() {
        BaseALIoTDevice baseALIoTDevice = this.f8159b;
        if (baseALIoTDevice != null) {
            return baseALIoTDevice.getFamilyId();
        }
        return null;
    }

    public long j() {
        o();
        return this.f8160c.getFirstDiscoverTime();
    }

    public HomeCacheBean k() {
        return this.f8160c;
    }

    public String l() {
        o();
        return this.f8160c.getDeviceIdMD5();
    }

    public int m() {
        BaseALIoTDevice baseALIoTDevice = this.f8159b;
        if (baseALIoTDevice != null) {
            return baseALIoTDevice.getOnBoardingTime();
        }
        return 0;
    }

    public int n() {
        o();
        return this.f8160c.getSortValue();
    }

    public boolean p() {
        BaseALIoTDevice baseALIoTDevice = this.f8159b;
        if (baseALIoTDevice != null) {
            return baseALIoTDevice.isCamera();
        }
        return false;
    }

    public boolean q() {
        BaseALIoTDevice baseALIoTDevice = this.f8159b;
        if (baseALIoTDevice != null) {
            return baseALIoTDevice.isCommonDevice();
        }
        return true;
    }

    public boolean r() {
        BaseALIoTDevice baseALIoTDevice = this.f8159b;
        if (baseALIoTDevice != null) {
            return baseALIoTDevice.isFirmwareSupportIoTCloud();
        }
        return false;
    }

    public boolean s() {
        BaseALIoTDevice baseALIoTDevice = this.f8159b;
        if (baseALIoTDevice != null) {
            return baseALIoTDevice.isHub();
        }
        return false;
    }

    public boolean t() {
        o();
        return this.f8160c.isNewDevice() && o0.j(System.currentTimeMillis()) - j() < 259200000;
    }

    public String toString() {
        return "LocalDeviceBean{alIoTDevice=" + this.f8159b + ", homeCacheBean=" + this.f8160c + '}';
    }

    public boolean u() {
        BaseALIoTDevice baseALIoTDevice = this.f8159b;
        if (baseALIoTDevice != null) {
            return baseALIoTDevice.isSupportIoTCloud();
        }
        return false;
    }

    public boolean v() {
        BaseALIoTDevice baseALIoTDevice = this.f8159b;
        return baseALIoTDevice == null || !baseALIoTDevice.isSupportDeviceShare();
    }

    public boolean w() {
        BaseALIoTDevice baseALIoTDevice = this.f8159b;
        return baseALIoTDevice != null && baseALIoTDevice.isUserRoleTypeDevice();
    }

    public void x(BaseALIoTDevice baseALIoTDevice) {
        this.f8159b = baseALIoTDevice;
    }

    public void y(long j) {
        o();
        this.f8160c.setFirstDiscoverTime(o0.j(j));
    }

    public void z(HomeCacheBean homeCacheBean) {
        this.f8160c = homeCacheBean;
    }

    public k(BaseALIoTDevice baseALIoTDevice) {
        B(true);
        y(System.currentTimeMillis());
        A(baseALIoTDevice.getDeviceIdMD5());
        x(baseALIoTDevice);
    }
}
