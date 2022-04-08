package com.tplink.libtpcommonstream.stream.control.notification;

import androidx.core.app.NotificationCompat;
import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ChannelMotorStatus {
    @c("channels")
    private List<Integer> channels = new ArrayList();
    @c(NotificationCompat.CATEGORY_STATUS)
    private List<String> status = new ArrayList();
    @c("direction")
    private List<String> direction = new ArrayList();

    public String getChannelMotorDirection(String str) {
        int indexOf = this.channels.indexOf(str);
        if (indexOf <= 0 || indexOf >= this.direction.size()) {
            return null;
        }
        return this.direction.get(indexOf);
    }

    public String getChannelMotorStatus(String str) {
        int indexOf = this.channels.indexOf(str);
        if (indexOf <= 0 || indexOf >= this.status.size()) {
            return null;
        }
        return this.status.get(indexOf);
    }

    public List<Integer> getChannels() {
        return this.channels;
    }

    public List<String> getDirection() {
        return this.direction;
    }

    public List<String> getStatus() {
        return this.status;
    }

    public void setChannels(List<Integer> list) {
        this.channels = list;
    }

    public void setDirection(List<String> list) {
        this.direction = list;
    }

    public void setStatus(List<String> list) {
        this.status = list;
    }
}
