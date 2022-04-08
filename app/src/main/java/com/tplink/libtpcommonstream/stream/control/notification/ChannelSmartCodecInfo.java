package com.tplink.libtpcommonstream.stream.control.notification;

import com.google.gson.q.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ChannelSmartCodecInfo {
    @c("channels")
    private List<Integer> channels = new ArrayList();
    @c("enabled")
    private List<String> enabled = new ArrayList();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SmartCodecInfo {
        public static final String OFF = "off";
        public static final String ON = "on";
    }

    public String getChannelSmartCodecStatus(String str) {
        int indexOf = this.channels.indexOf(str);
        if (indexOf <= 0 || indexOf >= this.enabled.size()) {
            return null;
        }
        return this.enabled.get(indexOf);
    }

    public List<Integer> getChannels() {
        return this.channels;
    }

    public List<String> getEnabled() {
        return this.enabled;
    }

    public void setChannels(List<Integer> list) {
        this.channels = list;
    }

    public void setEnabled(List<String> list) {
        this.enabled = list;
    }
}
