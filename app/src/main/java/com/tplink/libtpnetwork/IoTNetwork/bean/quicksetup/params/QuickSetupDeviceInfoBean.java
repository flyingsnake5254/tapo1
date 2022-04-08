package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params;

import com.google.gson.q.b;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class QuickSetupDeviceInfoBean implements Serializable {
    private String avatar;
    private String location;
    @b(Base64TypeAdapter.class)
    private String nickname;

    public QuickSetupDeviceInfoBean() {
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getLocation() {
        return this.location;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public QuickSetupDeviceInfoBean(String str, String str2) {
        this.nickname = str;
        this.avatar = str2;
    }
}
