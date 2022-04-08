package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class FwDownloadStatus implements Serializable {
    public static final int ERROR_CODE_FW_ALL_SUCCESS = 6;
    public static final int ERROR_CODE_FW_DOWNLOAD_FAIL = 3;
    public static final int ERROR_CODE_FW_DOWNLOAD_PROGRESS = 4;
    public static final int ERROR_CODE_FW_SEND_DOWNLOAD_FAIL = 1;
    public static final int ERROR_CODE_FW_SEND_DOWNLOAD_SUCCESS = 2;
    public static final int ERROR_CODE_FW_START_INSTALL = 5;
    private int downloadProgress;
    private int errorCode;
    private int installTime;

    public FwDownloadStatus(int i) {
        this.errorCode = i;
    }

    public int getDownloadProgress() {
        return this.downloadProgress;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getInstallTime() {
        return this.installTime;
    }

    public void setDownloadProgress(int i) {
        this.downloadProgress = i;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setInstallTime(int i) {
        this.installTime = i;
    }
}
