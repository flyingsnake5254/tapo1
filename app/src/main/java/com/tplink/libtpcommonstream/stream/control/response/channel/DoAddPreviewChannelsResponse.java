package com.tplink.libtpcommonstream.stream.control.response.channel;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.response.Response;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DoAddPreviewChannelsResponse extends Response {
    @c("channels_offline")
    private List<Integer> channelsOffline = new ArrayList();
    @c("channels_invalid")
    private List<Integer> channelsInvalid = new ArrayList();
    @c("channels_lack_bandwidth")
    private List<Integer> channelsLackBandwidth = new ArrayList();
    @c("channels_too_many_request")
    private List<Integer> channelsTooManyRequest = new ArrayList();

    public List<Integer> getChannelsInvalid() {
        return this.channelsInvalid;
    }

    public List<Integer> getChannelsLackBandwidth() {
        return this.channelsLackBandwidth;
    }

    public List<Integer> getChannelsOffline() {
        return this.channelsOffline;
    }

    public List<Integer> getChannelsTooManyRequest() {
        return this.channelsTooManyRequest;
    }

    public void setChannelsInvalid(List<Integer> list) {
        this.channelsInvalid = list;
    }

    public void setChannelsLackBandwidth(List<Integer> list) {
        this.channelsLackBandwidth = list;
    }

    public void setChannelsOffline(List<Integer> list) {
        this.channelsOffline = list;
    }

    public void setChannelsTooManyRequest(List<Integer> list) {
        this.channelsTooManyRequest = list;
    }
}
