package com.tplink.libtpcommonstream.stream.control.request.channel;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AddPreviewChannelParams {
    @c("channels")
    private List<Integer> channels = new ArrayList();
    @c("resolutions")
    private List<String> resolutions = new ArrayList();

    public List<Integer> getChannels() {
        return this.channels;
    }

    public List<String> getResolutions() {
        return this.resolutions;
    }

    public void setChannels(List<Integer> list) {
        this.channels = list;
    }

    public void setResolutions(List<String> list) {
        this.resolutions = list;
    }
}
