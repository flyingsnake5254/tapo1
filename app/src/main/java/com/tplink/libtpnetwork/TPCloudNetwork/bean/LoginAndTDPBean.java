package com.tplink.libtpnetwork.TPCloudNetwork.bean;

import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes3.dex */
public class LoginAndTDPBean implements Serializable {
    private Boolean loginResult;
    private Map<String, ? extends TDPIoTDevice> tDPIoTDeviceMap;

    public LoginAndTDPBean(Boolean bool, Map<String, ? extends TDPIoTDevice> map) {
        this.loginResult = bool;
        this.tDPIoTDeviceMap = map;
    }

    public Boolean getLoginResult() {
        return this.loginResult;
    }

    public Map<String, ? extends TDPIoTDevice> getTDPIoTDeviceMap() {
        return this.tDPIoTDeviceMap;
    }

    public void setLoginResult(Boolean bool) {
        this.loginResult = bool;
    }

    public void setTDPIoTDeviceMap(Map<String, TDPIoTDevice> map) {
        this.tDPIoTDeviceMap = map;
    }
}
