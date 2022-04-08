package com.tplink.cloud.bean.webservice.params;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class ServiceStatusInfo {
    private boolean isOpen;
    private String serviceName;
    private String uploadType;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ServiceName {
        public static final String USER_EXPERIENCE_IMPROVE = "userExperienceImprove";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface UploadType {
        public static final String AUTOMATIC = "automatic";
        public static final String MANUAL = "manual";
    }

    public ServiceStatusInfo() {
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String getUploadType() {
        return this.uploadType;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void setUploadType(String str) {
        this.uploadType = str;
    }

    public ServiceStatusInfo(String str, String str2, boolean z) {
        this.serviceName = str;
        this.uploadType = str2;
        this.isOpen = z;
    }
}
