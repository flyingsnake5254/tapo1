package com.tplink.libtpcommonstream.stream.control.request.channel;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.Request;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DoRemoveChannelsRequest extends Request {
    @c("remove_channels")
    private List<Integer> removeChannels = new ArrayList();

    public DoRemoveChannelsRequest(String str) {
        super("do");
    }

    public List<Integer> getRemoveChannels() {
        return this.removeChannels;
    }

    public void setRemoveChannels(List<Integer> list) {
        this.removeChannels = list;
    }
}
