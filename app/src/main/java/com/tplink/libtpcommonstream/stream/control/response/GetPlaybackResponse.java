package com.tplink.libtpcommonstream.stream.control.response;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class GetPlaybackResponse extends Response {
    @c("session_id")
    private String sessionId;
    @c("speed")
    private String speed;

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSpeed() {
        return this.speed;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSpeed(String str) {
        this.speed = str;
    }
}
