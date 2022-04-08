package com.tplink.libtpcommonstream.stream.control.request.channel;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.Request;

/* loaded from: classes3.dex */
public class DoAddPreviewChannelsRequest extends Request {
    @c("preview_add_channels")
    private AddPreviewChannelParams params;

    public DoAddPreviewChannelsRequest() {
        super("do");
    }

    public AddPreviewChannelParams getParams() {
        return this.params;
    }

    public void setParams(AddPreviewChannelParams addPreviewChannelParams) {
        this.params = addPreviewChannelParams;
    }
}
