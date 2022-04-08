package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.param.GetVodParams;

/* loaded from: classes3.dex */
public class GetPlaybackRequest extends Request {
    @c("playback")
    private GetVodParams playback;

    public GetPlaybackRequest() {
        super("get");
    }

    public GetVodParams getPlayback() {
        return this.playback;
    }

    public void setPlayback(GetVodParams getVodParams) {
        this.playback = getVodParams;
    }
}
