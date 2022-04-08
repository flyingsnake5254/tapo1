package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class DoPauseRequest extends Request {
    @c("pause")
    private String pause = "null";

    public DoPauseRequest() {
        super("do");
    }

    public String getPause() {
        return this.pause;
    }

    public void setPause(String str) {
        this.pause = str;
    }
}
