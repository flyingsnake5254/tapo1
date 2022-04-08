package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;

/* loaded from: classes2.dex */
public class ThingFirmware {
    @c("file_size")
    private int fileSize;
    @c("fw_ver")
    private String fwVer;
    @c("hw_id")
    private String hwId;
    @c("need_to_upgrade")
    private boolean needToUpgrade;
    @c("oem_id")
    private String oemId;
    @c("release_date")
    private String releaseDate;
    @c("release_note")
    private String releaseNote;
    private int type;

    public int getFileSize() {
        return this.fileSize;
    }

    public String getFwVer() {
        return this.fwVer;
    }

    public String getHwId() {
        return this.hwId;
    }

    public String getOemId() {
        return this.oemId;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public String getReleaseNote() {
        return this.releaseNote;
    }

    public int getType() {
        return this.type;
    }

    public boolean isNeedToUpgrade() {
        return this.needToUpgrade;
    }

    public void setFileSize(int i) {
        this.fileSize = i;
    }

    public void setFwVer(String str) {
        this.fwVer = str;
    }

    public void setHwId(String str) {
        this.hwId = str;
    }

    public void setNeedToUpgrade(boolean z) {
        this.needToUpgrade = z;
    }

    public void setOemId(String str) {
        this.oemId = str;
    }

    public void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public void setReleaseNote(String str) {
        this.releaseNote = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
