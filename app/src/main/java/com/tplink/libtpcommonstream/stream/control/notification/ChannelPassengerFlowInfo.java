package com.tplink.libtpcommonstream.stream.control.notification;

import android.util.Pair;
import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ChannelPassengerFlowInfo {
    @c("channels")
    private List<Integer> channels = new ArrayList();
    @c("in")
    private List<String> passengerIn = new ArrayList();
    @c("out")
    private List<String> passengerOut = new ArrayList();
    @c("timestamp")
    private List<String> timestamp = new ArrayList();

    public Pair<String, String> getChannelPassengerInInfo(String str) {
        int indexOf = this.channels.indexOf(str);
        if (indexOf <= 0 || indexOf >= this.passengerIn.size() || indexOf >= this.timestamp.size()) {
            return null;
        }
        return new Pair<>(this.passengerIn.get(indexOf), this.timestamp.get(indexOf));
    }

    public Pair<String, String> getChannelPassengerOutInfo(String str) {
        int indexOf = this.channels.indexOf(str);
        if (indexOf <= 0 || indexOf >= this.passengerOut.size() || indexOf >= this.timestamp.size()) {
            return null;
        }
        return new Pair<>(this.passengerOut.get(indexOf), this.timestamp.get(indexOf));
    }

    public List<Integer> getChannels() {
        return this.channels;
    }

    public List<String> getPassengerIn() {
        return this.passengerIn;
    }

    public List<String> getPassengerOut() {
        return this.passengerOut;
    }

    public List<String> getTimestamp() {
        return this.timestamp;
    }

    public void setChannels(List<Integer> list) {
        this.channels = list;
    }

    public void setPassengerIn(List<String> list) {
        this.passengerIn = list;
    }

    public void setPassengerOut(List<String> list) {
        this.passengerOut = list;
    }

    public void setTimestamp(List<String> list) {
        this.timestamp = list;
    }
}
