package com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RoomBean {
    private String mAvatarUrl;
    private int mDeviceCount;
    private List<DeviceBean> mDeviceList = new ArrayList();
    private String mRoomId;
    private String mRoomName;

    public String getAvatarUrl() {
        return this.mAvatarUrl;
    }

    public int getDeviceCount() {
        List<DeviceBean> list = this.mDeviceList;
        if (list != null) {
            this.mDeviceCount = list.size();
        }
        return this.mDeviceCount;
    }

    public List<DeviceBean> getDeviceList() {
        return this.mDeviceList;
    }

    public String getRoomId() {
        return this.mRoomId;
    }

    public String getRoomName() {
        return this.mRoomName;
    }

    public void setAvatarUrl(String str) {
        this.mAvatarUrl = str;
    }

    public void setDeviceList(List<DeviceBean> list) {
        this.mDeviceList = list;
    }

    public void setRoomId(String str) {
        this.mRoomId = str;
    }

    public void setRoomName(String str) {
        this.mRoomName = str;
    }
}
