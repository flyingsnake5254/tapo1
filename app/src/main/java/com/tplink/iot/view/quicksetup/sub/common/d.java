package com.tplink.iot.view.quicksetup.sub.common;

import com.tplink.iot.R;

/* compiled from: SubDeviceModelUtil.java */
/* loaded from: classes2.dex */
public class d {
    public static int a(SubDeviceModel subDeviceModel) {
        return SubDeviceModel.SENSOR_T100 == subDeviceModel ? R.mipmap.ic_fw_t100 : SubDeviceModel.SENSOR_T110 == subDeviceModel ? R.mipmap.ic_fw_t110 : SubDeviceModel.SWITCH_S220 == subDeviceModel ? R.mipmap.ic_fw_s220 : SubDeviceModel.BUTTON_S200B == subDeviceModel ? R.mipmap.ic_fw_s200b : SubDeviceModel.SWITCH_S210 == subDeviceModel ? R.mipmap.ic_fw_s210 : SubDeviceModel.TRV_E100 == subDeviceModel ? R.drawable.trv_e100_animate : R.drawable.sensor_t100_animate;
    }
}
