package com.tplink.iot.view.quicksetup.bulb.utils;

import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class QuickSetupInfoBundle implements Serializable {
    private String bulbSSID;
    private QuickSetupComponentResult componentResult;
    private String deviceIdMD5;
    private String deviceModel;
    private boolean inNeedDisplayInherit;
    private boolean isFromQuickDiscovery;
    private boolean isSelectFollowInherit;
    private boolean isSetInheritAndSuccess;
    private Integer latitude;
    private Integer longitude;
    private EnumOnboardingType onBoardingType;
    private long onboardingStartTime;

    public QuickSetupInfoBundle() {
        this.onBoardingType = EnumOnboardingType.BULB_SOFT_AP;
        this.deviceModel = "";
        this.onboardingStartTime = 0L;
        this.isFromQuickDiscovery = false;
    }

    public String getBulbSSID() {
        return this.bulbSSID;
    }

    public QuickSetupComponentResult getComponentResult() {
        return this.componentResult;
    }

    public String getDeviceIdMD5() {
        return this.deviceIdMD5;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getDeviceType() {
        return b.l(this.deviceModel).getDeviceType();
    }

    public Integer getLatitude() {
        return this.latitude;
    }

    public Integer getLongitude() {
        return this.longitude;
    }

    public EnumOnboardingType getOnBoardingType() {
        return this.onBoardingType;
    }

    public long getOnboardingStartTime() {
        return this.onboardingStartTime;
    }

    public boolean inNeedDisplayInherit() {
        return this.inNeedDisplayInherit;
    }

    public boolean isFromQuickDiscovery() {
        return this.isFromQuickDiscovery;
    }

    public boolean isSelectFollowInherit() {
        return this.isSelectFollowInherit;
    }

    public boolean isSetInheritAndSuccess() {
        return this.isSetInheritAndSuccess;
    }

    public void setBulbSSID(String str) {
        this.bulbSSID = str;
    }

    public void setComponentResult(QuickSetupComponentResult quickSetupComponentResult) {
        this.componentResult = quickSetupComponentResult;
    }

    public void setDeviceIdMD5(String str) {
        this.deviceIdMD5 = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public void setFromQuickDiscovery(boolean z) {
        this.isFromQuickDiscovery = z;
    }

    public void setInheritAndSuccess(boolean z) {
        this.isSetInheritAndSuccess = z;
    }

    public void setLatitude(Integer num) {
        this.latitude = num;
    }

    public void setLongitude(Integer num) {
        this.longitude = num;
    }

    public void setNeedDisplayInherit(boolean z) {
        this.inNeedDisplayInherit = z;
    }

    public void setOnBoardingType(EnumOnboardingType enumOnboardingType) {
        this.onBoardingType = enumOnboardingType;
    }

    public void setOnboardingStartTime(long j) {
        this.onboardingStartTime = j;
    }

    public void setSelectFollowInherit(boolean z) {
        this.isSelectFollowInherit = z;
    }

    public QuickSetupInfoBundle(Integer num, Integer num2) {
        this.onBoardingType = EnumOnboardingType.BULB_SOFT_AP;
        this.deviceModel = "";
        this.onboardingStartTime = 0L;
        this.isFromQuickDiscovery = false;
        this.longitude = num;
        this.latitude = num2;
    }

    public QuickSetupInfoBundle(Integer num, Integer num2, String str, long j) {
        this.onBoardingType = EnumOnboardingType.BULB_SOFT_AP;
        this.deviceModel = "";
        this.onboardingStartTime = 0L;
        this.isFromQuickDiscovery = false;
        this.longitude = num;
        this.latitude = num2;
        this.deviceModel = str;
        this.onboardingStartTime = j;
    }
}
