package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class DoResumeRequest extends Request {
    @c("play")
    private String play = "null";

    public DoResumeRequest() {
        super("do");
    }

    public String getPlay() {
        return this.play;
    }

    public void setPlay(String str) {
        this.play = str;
    }
}
