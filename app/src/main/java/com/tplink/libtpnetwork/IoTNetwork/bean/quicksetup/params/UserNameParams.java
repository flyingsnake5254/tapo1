package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params;

import com.google.gson.q.b;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;

/* loaded from: classes3.dex */
public class UserNameParams {
    @b(Base64TypeAdapter.class)
    private String username;

    public UserNameParams(String str) {
        this.username = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
