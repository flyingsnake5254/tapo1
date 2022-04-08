package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import androidx.annotation.Nullable;
import com.google.gson.i;

/* loaded from: classes3.dex */
public class ThingServiceExecResult {
    @Nullable
    private i data;
    private String requestId;

    public ThingServiceExecResult(String str) {
        this.requestId = str;
    }

    @Nullable
    public i getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setData(@Nullable i iVar) {
        this.data = iVar;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public ThingServiceExecResult(String str, @Nullable i iVar) {
        this.requestId = str;
        this.data = iVar;
    }
}
