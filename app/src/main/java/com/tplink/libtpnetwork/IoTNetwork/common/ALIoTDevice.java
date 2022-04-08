package com.tplink.libtpnetwork.IoTNetwork.common;

import androidx.annotation.Nullable;
import b.d.w.h.a;
import b.d.w.h.b;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDeviceCache;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.IoTHubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.cameranetwork.util.f;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.lang.e;

/* loaded from: classes3.dex */
public class ALIoTDevice extends BaseALIoTDevice<TDPIoTDevice> implements Serializable {
    private boolean isDataFromThing = false;
    private LocalIoTBaseDevice localIoTDevice;
    private ThingDevice thingDevice;

    public ALIoTDevice(TCDeviceBean tCDeviceBean) {
        super(tCDeviceBean);
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public int getBindCount() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice instanceof IoTSubDevice) {
            return ((IoTSubDevice) localIoTBaseDevice).getBindCount();
        }
        return 0;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public int getBrightness() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice instanceof IoTBulbDevice) {
            return ((IoTBulbDevice) localIoTBaseDevice).getBrightness();
        }
        if (localIoTBaseDevice instanceof IoTLightStripDevice) {
            return ((IoTLightStripDevice) localIoTBaseDevice).getBrightness();
        }
        return 0;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    @Nullable
    public String getCategory() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.getCategory();
        }
        return null;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public int getColorTemp() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice instanceof IoTBulbDevice) {
            return ((IoTBulbDevice) localIoTBaseDevice).getColorTemp();
        }
        if (localIoTBaseDevice instanceof IoTLightStripDevice) {
            return ((IoTLightStripDevice) localIoTBaseDevice).getColorTemp();
        }
        return 0;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDeviceFwVer() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        String str = null;
        String fwVer = localIoTBaseDevice != null ? localIoTBaseDevice.getFwVer() : null;
        TCDeviceBean tCDeviceBean = this.cloudIoTDevice;
        if (tCDeviceBean != null) {
            str = tCDeviceBean.getFwVer();
        }
        return getSuitableValue(fwVer, str, "");
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDeviceHwVer() {
        TCDeviceBean tCDeviceBean = this.cloudIoTDevice;
        String str = null;
        String deviceHwVer = tCDeviceBean != null ? tCDeviceBean.getDeviceHwVer() : null;
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            str = localIoTBaseDevice.getHwVer();
        }
        return getSuitableValue(deviceHwVer, str, "");
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDeviceIcon() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice == null || localIoTBaseDevice.getAvatar() == null) {
            return null;
        }
        return this.localIoTDevice.getAvatar();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDeviceId() {
        return getThingName();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDeviceIdMD5() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null && !b.d(localIoTBaseDevice.getDeviceId())) {
            return a.g(this.localIoTDevice.getDeviceId());
        }
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null && !b.d(thingDevice.getThingName())) {
            return a.g(this.thingDevice.getThingName());
        }
        TCDeviceBean tCDeviceBean = this.cloudIoTDevice;
        if (tCDeviceBean != null && !b.d(tCDeviceBean.getDeviceId())) {
            return a.g(this.cloudIoTDevice.getDeviceId());
        }
        T t = this.tdpIoTDevice;
        return (t == 0 || b.d(t.getDeviceIdMd5())) ? "" : this.tdpIoTDevice.getDeviceIdMd5();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDeviceLocation() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        return localIoTBaseDevice != null ? localIoTBaseDevice.getLocation() : "";
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDeviceMac() {
        TCDeviceBean tCDeviceBean = this.cloudIoTDevice;
        String str = null;
        String deviceMac = tCDeviceBean != null ? tCDeviceBean.getDeviceMac() : null;
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        String mac = localIoTBaseDevice != null ? localIoTBaseDevice.getMac() : null;
        T t = this.tdpIoTDevice;
        String mac2 = t != 0 ? t.getMac() : null;
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            str = thingDevice.getMac();
        }
        return f.a(getSuitableValue(deviceMac, mac, mac2, str, ""));
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDeviceModel() {
        TCDeviceBean tCDeviceBean = this.cloudIoTDevice;
        String str = null;
        String deviceName = tCDeviceBean != null ? tCDeviceBean.getDeviceName() : null;
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        String model = localIoTBaseDevice != null ? localIoTBaseDevice.getModel() : null;
        ThingDevice thingDevice = this.thingDevice;
        String model2 = thingDevice != null ? thingDevice.getModel() : null;
        T t = this.tdpIoTDevice;
        if (t != 0) {
            str = t.getDeviceModel();
        }
        return getSuitableValue(deviceName, model, model2, str, "");
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDeviceName() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null && !b.d(localIoTBaseDevice.getNickname())) {
            return this.localIoTDevice.getNickname();
        }
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null && !b.d(thingDevice.getNickname())) {
            return this.thingDevice.getNickname();
        }
        TCDeviceBean tCDeviceBean = this.cloudIoTDevice;
        if (tCDeviceBean == null || b.d(tCDeviceBean.getAlias())) {
            return "";
        }
        try {
            return a.a(this.cloudIoTDevice.getAlias());
        } catch (IllegalArgumentException e2) {
            b.d.w.c.a.d("Base64 decode error. Origin string: " + this.cloudIoTDevice.getAlias());
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDeviceRegion() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null && !e.a(localIoTBaseDevice.getRegion())) {
            return this.localIoTDevice.getRegion();
        }
        ThingDevice thingDevice = this.thingDevice;
        return (thingDevice == null || thingDevice.getThingInfo() == null || e.a(this.thingDevice.getThingInfo().getRegion())) ? "" : this.thingDevice.getThingInfo().getRegion();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDeviceType() {
        TCDeviceBean tCDeviceBean = this.cloudIoTDevice;
        String str = null;
        String deviceType = tCDeviceBean != null ? tCDeviceBean.getDeviceType() : null;
        ThingDevice thingDevice = this.thingDevice;
        String deviceType2 = thingDevice != null ? thingDevice.getDeviceType() : null;
        T t = this.tdpIoTDevice;
        String deviceType3 = t != 0 ? t.getDeviceType() : null;
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            str = localIoTBaseDevice.getType();
        }
        return getSuitableValue(deviceType, deviceType2, deviceType3, str, "");
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getDynamicLightEffectId() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice instanceof IoTBulbDevice) {
            return ((IoTBulbDevice) localIoTBaseDevice).getDynamicLightEffectId();
        }
        return null;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public EnumDeviceType getEnumDeviceType() {
        return EnumDeviceType.fromType(getDeviceType());
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getFamilyId() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.getFamilyId();
        }
        return null;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getGuardMode() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice instanceof IoTHubDevice) {
            return ((IoTHubDevice) localIoTBaseDevice).getGuardMode();
        }
        return null;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean getGuardOn() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice instanceof IoTHubDevice) {
            return ((IoTHubDevice) localIoTBaseDevice).isGuardOn();
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public int getHue() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice instanceof IoTBulbDevice) {
            return ((IoTBulbDevice) localIoTBaseDevice).getHue();
        }
        if (localIoTBaseDevice instanceof IoTLightStripDevice) {
            return ((IoTLightStripDevice) localIoTBaseDevice).getHue();
        }
        return 0;
    }

    public String getLang() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null && localIoTBaseDevice.getLang() != null) {
            return this.localIoTDevice.getLang();
        }
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.getLang();
        }
        return null;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public long getLatestLogTimestamp() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice instanceof IoTSubDevice) {
            return ((IoTSubDevice) localIoTBaseDevice).getLatestLogTimestamp();
        }
        return 0L;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public int getOnBoardingTime() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.getOnBoardingTime();
        }
        return 0;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getOriginalDeviceId() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (!(localIoTBaseDevice instanceof IoTSubDevice)) {
            return "";
        }
        String originalDeviceId = ((IoTSubDevice) localIoTBaseDevice).getOriginalDeviceId();
        return !e.a(originalDeviceId) ? originalDeviceId : "";
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getParentDeviceIDMD5() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null && !b.d(localIoTBaseDevice.getParentDeviceId())) {
            return a.g(this.localIoTDevice.getParentDeviceId());
        }
        ThingDevice thingDevice = this.thingDevice;
        return (thingDevice == null || e.a(thingDevice.getEdgeThingName())) ? "" : a.g(this.thingDevice.getEdgeThingName());
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getParentDeviceId() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null && !b.d(localIoTBaseDevice.getParentDeviceId())) {
            return this.localIoTDevice.getParentDeviceId();
        }
        ThingDevice thingDevice = this.thingDevice;
        return (thingDevice == null || e.a(thingDevice.getEdgeThingName())) ? "" : this.thingDevice.getEdgeThingName();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getRoomId() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.getRoomId();
        }
        return null;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public int getSaturation() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice instanceof IoTBulbDevice) {
            return ((IoTBulbDevice) localIoTBaseDevice).getSaturation();
        }
        if (localIoTBaseDevice instanceof IoTLightStripDevice) {
            return ((IoTLightStripDevice) localIoTBaseDevice).getSaturation();
        }
        return 0;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public String getSpecs() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.getSpecs();
        }
        return null;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public ThingDevice getThingDevice() {
        return this.thingDevice;
    }

    @Deprecated
    public String getThingGatewayUrl() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.getThingGatewayUrl();
        }
        return null;
    }

    public String getThingGatewayUrlV2() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.getThingGatewayUrlV2();
        }
        return null;
    }

    public String getThingModelId() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.getThingModelId();
        }
        return null;
    }

    public String getThingName() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null && !b.d(localIoTBaseDevice.getDeviceId())) {
            return this.localIoTDevice.getDeviceId();
        }
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null && !b.d(thingDevice.getThingName())) {
            return this.thingDevice.getThingName();
        }
        TCDeviceBean tCDeviceBean = this.cloudIoTDevice;
        return (tCDeviceBean == null || b.d(tCDeviceBean.getDeviceId())) ? "" : this.cloudIoTDevice.getDeviceId();
    }

    public ThingSetting getThingSetting() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.getThingSetting();
        }
        return null;
    }

    public ThingShadow getThingShadow() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.getThingShadow();
        }
        return null;
    }

    public String getThingUrl() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.getThingUrl();
        }
        return null;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isCommonDevice() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.isCommonDevice();
        }
        return true;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isDataFromThing() {
        return this.isDataFromThing;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isDeviceOn() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isDeviceOn();
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isDynamicLightEffectEnable() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice instanceof IoTBulbDevice) {
            return ((IoTBulbDevice) localIoTBaseDevice).isDynamicLightEffectEnable();
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isFirmwareSupportIoTCloud() {
        if (isBulb()) {
            return true;
        }
        T t = this.tdpIoTDevice;
        if (t != 0) {
            return t.isSupportIoTCloud();
        }
        return this.thingDevice != null;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isHasThingOrCloudDevice() {
        return (this.cloudIoTDevice == null && this.thingDevice == null) ? false : true;
    }

    public boolean isPlugP105OfJP() {
        if (!"P105".equals(getDeviceModel())) {
            return false;
        }
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if ((localIoTBaseDevice instanceof IoTPlugDevice) && "JP".equals(localIoTBaseDevice.getSpecs())) {
            return true;
        }
        TCDeviceBean tCDeviceBean = this.cloudIoTDevice;
        return (tCDeviceBean == null || tCDeviceBean.getDeviceModel() == null || !this.cloudIoTDevice.getDeviceModel().contains("JP")) ? false : true;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isSubDevice() {
        if (!e.a(getParentDeviceId())) {
            return true;
        }
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.isSubThing();
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isSupportChild() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isSupportChild();
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isSupportCloudConnect() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isSupportCloudConnect();
        }
        return false;
    }

    public boolean isSupportColorAndColorTemp() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isSupportColorAndColorTemp();
        }
        return false;
    }

    public boolean isSupportDefaultStates() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isSupportDefaultStates();
        }
        return false;
    }

    public boolean isSupportDeviceLocalTime() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isSupportComponent(EnumIoTComponent.DEVICE_LOCAL_TIME);
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isSupportDeviceShare() {
        return true;
    }

    public boolean isSupportFirmware() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isSupportFirmware();
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isSupportIoTCloud() {
        return this.thingDevice != null;
    }

    public boolean isSupportIoTCloudComponent() {
        if (this.localIoTDevice == null) {
            return false;
        }
        if (isBulb()) {
            return true;
        }
        return this.localIoTDevice.isSupportIoTCloudComponent();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isSupportIoTComponent(EnumIoTComponent enumIoTComponent) {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isSupportComponent(enumIoTComponent);
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isSupportLED() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isSupportLED();
        }
        return false;
    }

    public boolean isSupportLightEffect() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isSupportComponent(EnumIoTComponent.LIGHT_EFFECT);
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isSupportSunriseSunset() {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            return localIoTBaseDevice.isSupportSunriseSunset();
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public boolean isThingOnline() {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            return thingDevice.isThingOnline();
        }
        return false;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public void setCommonDevice(boolean z) {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            thingDevice.setCommonDevice(z);
        }
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public void setDataFromThing(boolean z) {
        this.isDataFromThing = z;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public void setDeviceOn(boolean z) {
        LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
        if (localIoTBaseDevice != null) {
            localIoTBaseDevice.setDeviceOn(z);
        }
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public void setLocalIoTDevice(Object obj) {
        if (obj instanceof LocalIoTBaseDevice) {
            this.localIoTDevice = (LocalIoTBaseDevice) obj;
        }
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public void setThingDevice(ThingDevice thingDevice) {
        if (thingDevice == null) {
            this.thingDevice = null;
            return;
        }
        ThingDevice thingDevice2 = this.thingDevice;
        this.thingDevice = thingDevice;
        if (!(thingDevice.getThingShadow() != null || thingDevice2 == null || thingDevice2.getThingShadow() == null)) {
            this.thingDevice.setThingShadow(thingDevice2.getThingShadow());
        }
        if (this.thingDevice.getThingSetting() == null && thingDevice2 != null && thingDevice2.getThingSetting() != null) {
            this.thingDevice.setThingSetting(thingDevice2.getThingSetting());
        }
    }

    public void setThingSetting(ThingSetting thingSetting) {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            thingDevice.setThingSetting(thingSetting);
        }
    }

    public void setThingShadow(ThingShadow thingShadow) {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            thingDevice.setThingShadow(thingShadow);
        }
        if (this.localIoTDevice != null && thingShadow != null && thingShadow.getState() != null) {
            this.localIoTDevice.updateDeviceShadow(thingShadow.getState().getReported());
        }
    }

    public void updateIoTDeviceStateOnline() {
        if (!this.isDataFromThing || this.thingDevice.isThingOnline()) {
            setDeviceState(EnumIoTDeviceState.ONLINE);
        } else {
            setDeviceState(EnumIoTDeviceState.OFFLINE);
        }
    }

    public void updateLocalIoTDevice(LocalIoTBaseDevice localIoTBaseDevice) {
        LocalIoTBaseDevice localIoTBaseDevice2 = this.localIoTDevice;
        this.localIoTDevice = localIoTBaseDevice;
        if (!(localIoTBaseDevice == null || localIoTBaseDevice.getComponents() != null || localIoTBaseDevice2 == null || localIoTBaseDevice2.getComponents() == null)) {
            this.localIoTDevice.setComponents(localIoTBaseDevice2.getComponents());
        }
        updateIoTDeviceStateOnline();
    }

    public void updateThingShadow(long j, Map<String, Object> map, Map<String, Object> map2) {
        ThingDevice thingDevice = this.thingDevice;
        if (thingDevice != null) {
            thingDevice.updateThingShadow(j, map, map2);
        }
        ThingShadow thingShadow = getThingShadow();
        if (this.localIoTDevice != null && thingShadow != null && j >= thingShadow.getVersion()) {
            LocalIoTBaseDevice localIoTBaseDevice = this.localIoTDevice;
            if (map2 != null) {
                map = map2;
            }
            localIoTBaseDevice.updateDeviceShadow(map);
        }
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice
    public LocalIoTBaseDevice getLocalIoTDevice() {
        return this.localIoTDevice;
    }

    public ALIoTDevice(TDPIoTDevice tDPIoTDevice) {
        super(tDPIoTDevice);
    }

    public void setLocalIoTDevice(LocalIoTBaseDevice localIoTBaseDevice) {
        this.localIoTDevice = localIoTBaseDevice;
    }

    public ALIoTDevice(LocalIoTBaseDevice localIoTBaseDevice) {
        this.localIoTDevice = localIoTBaseDevice;
    }

    public ALIoTDevice(ThingDevice thingDevice) {
        this.thingDevice = thingDevice;
    }

    public ALIoTDevice(IoTDeviceCache ioTDeviceCache) {
        if (ioTDeviceCache.getCloudIoTDevice() != null) {
            this.cloudIoTDevice = new TCDeviceBean(ioTDeviceCache.getCloudIoTDevice());
        }
        if (ioTDeviceCache.getThingDevice() != null) {
            this.thingDevice = ioTDeviceCache.getThingDevice();
        }
        this.localIoTDevice = ioTDeviceCache.getLocalIoTDevice();
        this.isBackupFromCache = true;
    }
}
