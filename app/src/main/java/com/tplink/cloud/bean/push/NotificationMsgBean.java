package com.tplink.cloud.bean.push;

import com.google.gson.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class NotificationMsgBean {
    private i attachments;
    private String content;
    private String msgId;
    private String msgType;
    private boolean readFlag;
    private long time;
    private String title;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface MsgType {
        public static final String AUDIO = "Audio";
        public static final String CRYING = "BabyCry";
        public static final String MOTION = "Motion";
        public static final String NEW_FIRMWARE = "tapoNewFirmware";
        public static final String PERSON_DETECTED = "PersonDetected";
        public static final String PERSON_ENHANCED = "PersonEnhanced";
        public static final String SHARE_LAUNCH = "tapoShareLaunch";
    }

    public i getAttachments() {
        return this.attachments;
    }

    public String getContent() {
        return this.content;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public long getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isReadFlag() {
        return this.readFlag;
    }

    public void setAttachments(i iVar) {
        this.attachments = iVar;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setMsgType(String str) {
        this.msgType = str;
    }

    public void setReadFlag(boolean z) {
        this.readFlag = z;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
