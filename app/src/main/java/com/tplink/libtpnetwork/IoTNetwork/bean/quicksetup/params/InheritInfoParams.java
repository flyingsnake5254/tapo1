package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class InheritInfoParams {
    @c("is_inherit")
    private boolean isInherit;

    public InheritInfoParams(boolean z) {
        this.isInherit = z;
    }

    public boolean isInherit() {
        return this.isInherit;
    }

    public void setInherit(boolean z) {
        this.isInherit = z;
    }
}
