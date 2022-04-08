package com.tplink.libtpcommonstream.stream.control.notification;

import android.util.Pair;
import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ChannelPreviewParams {
    @c("channels")
    private List<Integer> channels = new ArrayList();
    @c("resolutions")
    private List<String> resolutions = new ArrayList();
    @c("audio")
    private List<String> audio = new ArrayList();

    public List<String> getAudio() {
        return this.audio;
    }

    public Pair<String, String> getChannelPreviewParams(String str) {
        int indexOf = this.channels.indexOf(str);
        if (indexOf <= 0 || indexOf >= this.resolutions.size() || indexOf >= this.audio.size()) {
            return null;
        }
        return new Pair<>(this.resolutions.get(indexOf), this.audio.get(indexOf));
    }

    public List<Integer> getChannels() {
        return this.channels;
    }

    public List<String> getResolutions() {
        return this.resolutions;
    }

    public void setAudio(List<String> list) {
        this.audio = list;
    }

    public void setChannels(List<Integer> list) {
        this.channels = list;
    }

    public void setResolutions(List<String> list) {
        this.resolutions = list;
    }
}
