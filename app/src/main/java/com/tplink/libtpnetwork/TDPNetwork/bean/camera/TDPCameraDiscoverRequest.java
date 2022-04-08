package com.tplink.libtpnetwork.TDPNetwork.bean.camera;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class TDPCameraDiscoverRequest {
    @c("params")
    private Param param;

    /* loaded from: classes3.dex */
    public static class Param {
        @c("rsa_key")
        private String rsaKey;

        Param(String str) {
            this.rsaKey = str;
        }
    }

    public TDPCameraDiscoverRequest(String str) {
        this.param = new Param(str);
    }
}
