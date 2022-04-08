package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;

/* loaded from: classes2.dex */
public class ThingComponent {
    private String id;
    @c("ver_code")
    private int verCode;

    public String getId() {
        return this.id;
    }

    public int getVerCode() {
        return this.verCode;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setVerCode(int i) {
        this.verCode = i;
    }
}
