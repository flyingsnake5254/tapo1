package com.tplink.iot.model.cloudvideo;

import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.PartCloudVideo;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudVideoItem {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_VIDEO = 1;
    private CloudVideo mCloudVideo;
    private String mDisplayTime;
    private boolean mHasVideo;
    private int mType;

    public CloudVideoItem(CloudVideo cloudVideo, int i) {
        this.mCloudVideo = cloudVideo;
        this.mType = i;
    }

    public CloudVideo getCloudVideo() {
        return this.mCloudVideo;
    }

    public String getDisplayTime() {
        return this.mDisplayTime;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isHasVideo() {
        return this.mHasVideo;
    }

    public void setCloudVideo(CloudVideo cloudVideo) {
        this.mCloudVideo = cloudVideo;
    }

    public void setDisplayTime(String str) {
        this.mDisplayTime = str;
    }

    public void setHasVideo() {
        CloudVideo cloudVideo = this.mCloudVideo;
        boolean z = false;
        if (cloudVideo == null) {
            this.mHasVideo = false;
            return;
        }
        List<PartCloudVideo> partCloudVideos = cloudVideo.getPartCloudVideos();
        if (partCloudVideos != null && !partCloudVideos.isEmpty()) {
            z = true;
        }
        this.mHasVideo = z;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
