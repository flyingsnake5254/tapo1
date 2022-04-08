package com.tplink.libtpcommonstream.stream.control.notification;

import com.google.gson.q.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class ChannelLensMaskInfo {
    @c("channels")
    private int channels;
    @c("enabled")
    private String enabled;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LensMaskStatus {
        public static final String OFF = "off";
        public static final String ON = "on";
    }

    public int getChannels() {
        return this.channels;
    }

    public String getEnabled() {
        return this.enabled;
    }

    public void setChannels(int i) {
        this.channels = i;
    }

    public void setEnabled(String str) {
        this.enabled = str;
    }
}
