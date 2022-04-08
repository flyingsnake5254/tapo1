package com.tplink.libtpcommonstream.stream.control.request.channel;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.Request;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DoAddPlaybackChannelsRequest extends Request {
    @c("playback_add_channels")
    private List<Integer> playbackAddChannels = new ArrayList();

    public DoAddPlaybackChannelsRequest() {
        super("do");
    }

    public List<Integer> getPlaybackAddChannels() {
        return this.playbackAddChannels;
    }

    public void setPlaybackAddChannels(List<Integer> list) {
        this.playbackAddChannels = list;
    }
}
