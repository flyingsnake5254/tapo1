package com.tplink.iot.view.ipcamera.memories.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MemoriesFilterBean implements Serializable {
    private String designatedDeviceidMD5;
    private boolean hasCloudVideo;
    private boolean hasPicture;
    private boolean hasVideo;
    private List<String> onlyDeviceName = new ArrayList();
    private boolean onlyLike;
    private boolean onlyUnLick;

    public String getDesignatedDeviceidMD5() {
        return this.designatedDeviceidMD5;
    }

    public List<String> getOnlyDeviceName() {
        return this.onlyDeviceName;
    }

    public boolean isHasCloudVideo() {
        return this.hasCloudVideo;
    }

    public boolean isHasPicture() {
        return this.hasPicture;
    }

    public boolean isHasVideo() {
        return this.hasVideo;
    }

    public boolean isOnlyLike() {
        return this.onlyLike;
    }

    public boolean isOnlyUnLick() {
        return this.onlyUnLick;
    }

    public boolean isSelectAll() {
        boolean z;
        List<String> list;
        boolean z2 = this.hasVideo;
        return ((!z2 && !this.hasCloudVideo && !this.hasPicture) || (z2 && this.hasCloudVideo && this.hasPicture)) && ((!(z = this.onlyLike) && !this.onlyUnLick) || (z && this.onlyUnLick)) && (((list = this.onlyDeviceName) == null || list.size() <= 0) && this.designatedDeviceidMD5 == null);
    }

    public void selectAll() {
        this.hasVideo = false;
        this.hasCloudVideo = false;
        this.hasPicture = false;
        this.onlyLike = false;
        this.onlyUnLick = false;
        this.onlyDeviceName = new ArrayList(0);
        this.designatedDeviceidMD5 = null;
    }

    public void setDesignatedDeviceidMD5(String str) {
        this.designatedDeviceidMD5 = str;
    }

    public void setHasCloudVideo(boolean z) {
        this.hasCloudVideo = z;
    }

    public void setHasPicture(boolean z) {
        this.hasPicture = z;
    }

    public void setHasVideo(boolean z) {
        this.hasVideo = z;
    }

    public void setOnlyDeviceName(List<String> list) {
        this.onlyDeviceName = list;
    }

    public void setOnlyLike(boolean z) {
        this.onlyLike = z;
    }

    public void setOnlyUnLick(boolean z) {
        this.onlyUnLick = z;
    }

    public MemoriesFilterBean clone() {
        MemoriesFilterBean memoriesFilterBean = new MemoriesFilterBean();
        memoriesFilterBean.hasVideo = this.hasVideo;
        memoriesFilterBean.hasCloudVideo = this.hasCloudVideo;
        memoriesFilterBean.hasPicture = this.hasPicture;
        memoriesFilterBean.onlyDeviceName = this.onlyDeviceName;
        memoriesFilterBean.onlyLike = this.onlyLike;
        memoriesFilterBean.onlyUnLick = this.onlyUnLick;
        memoriesFilterBean.designatedDeviceidMD5 = this.designatedDeviceidMD5;
        return memoriesFilterBean;
    }
}
