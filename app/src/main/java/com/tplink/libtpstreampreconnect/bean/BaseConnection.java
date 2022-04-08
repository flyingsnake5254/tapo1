package com.tplink.libtpstreampreconnect.bean;

import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseConnection {
    protected String audioType;
    protected BitStreamType bitStreamType;
    protected int connectionType;
    protected String deviceIdMD5;
    protected DeviceModel deviceModel;
    protected String encryptType;
    protected long endTime;
    protected String ip;
    protected boolean isLocal;
    protected int mediaType;
    protected int port;
    protected int portId;
    protected long startTime;
    protected int streamType;
    protected String talkMode;
    protected String url;
    protected int relayTime = 300;
    protected long createTime = 0;
    protected List<NatStatistics> statistics = new ArrayList();

    public BaseConnection(String str, DeviceModel deviceModel) {
        this.deviceIdMD5 = str;
        this.deviceModel = deviceModel;
    }

    public abstract BaseConnection clone();

    public String getAudioType() {
        return this.audioType;
    }

    public BitStreamType getBitStreamType() {
        return this.bitStreamType;
    }

    public int getConnectionType() {
        return this.connectionType;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getDeviceIdMD5() {
        return this.deviceIdMD5;
    }

    public DeviceModel getDeviceModel() {
        return this.deviceModel;
    }

    public String getEncryptType() {
        return this.encryptType;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getIp() {
        return this.ip;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public int getPort() {
        return this.port;
    }

    public int getPortId() {
        return this.portId;
    }

    public int getRelayTime() {
        return this.relayTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public List<NatStatistics> getStatistics() {
        return this.statistics;
    }

    public int getStreamType() {
        return this.streamType;
    }

    public String getTalkMode() {
        return this.talkMode;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isLocal() {
        return this.isLocal;
    }

    public void setAudioType(String str) {
        this.audioType = str;
    }

    public void setBitStreamType(BitStreamType bitStreamType) {
        this.bitStreamType = bitStreamType;
    }

    public void setConnectionType(int i) {
        this.connectionType = i;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setDeviceIdMD5(String str) {
        this.deviceIdMD5 = str;
    }

    public void setDeviceModel(DeviceModel deviceModel) {
        this.deviceModel = deviceModel;
    }

    public void setEncryptType(String str) {
        this.encryptType = str;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setLocal(boolean z) {
        this.isLocal = z;
    }

    public void setMediaType(int i) {
        this.mediaType = i;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setPortId(int i) {
        this.portId = i;
    }

    public void setRelayTime(int i) {
        this.relayTime = i;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setStatistics(List<NatStatistics> list) {
        this.statistics = list;
    }

    public void setStreamType(int i) {
        this.streamType = i;
    }

    public void setTalkMode(String str) {
        this.talkMode = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
