package com.tplink.iot.g.b.c;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.tplink.iot.R;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import kotlin.jvm.internal.j;
import kotlin.text.v;
import kotlin.text.w;

/* compiled from: LightStripUtils.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    @DrawableRes
    public static final int a(String str) {
        boolean D;
        boolean D2;
        if (str == null || str.length() == 0) {
            return R.mipmap.ic_fw_l900;
        }
        D = w.D(str, "L920", false, 2, null);
        if (!D) {
            D2 = w.D(str, "L930", false, 2, null);
            if (!D2) {
                return R.mipmap.ic_fw_l900;
            }
        }
        return R.mipmap.ic_fw_l920;
    }

    public static final int b(EnumLightStripAvatarType enumLightStripAvatarType) {
        return e(enumLightStripAvatarType, 1);
    }

    public static final int c(EnumLightStripAvatarType enumLightStripAvatarType) {
        return e(enumLightStripAvatarType, 2);
    }

    public static final int d(EnumLightStripAvatarType enumLightStripAvatarType) {
        return e(enumLightStripAvatarType, 3);
    }

    private static final int e(EnumLightStripAvatarType enumLightStripAvatarType, int i) {
        int i2 = R.mipmap.iot_light_strip_48;
        int i3 = i == 1 ? R.mipmap.iot_light_strip_36 : i == 2 ? R.mipmap.iot_light_strip_48 : R.mipmap.iot_light_strip_70;
        if (enumLightStripAvatarType == null) {
            return i3;
        }
        switch (b.a[enumLightStripAvatarType.ordinal()]) {
            case 1:
                if (i == 1) {
                    i2 = R.mipmap.iot_light_strip_36;
                } else if (i != 2) {
                    i2 = R.mipmap.iot_light_strip_70;
                }
                return i2;
            case 2:
                return i == 1 ? R.mipmap.iot_aquarium_36 : i == 2 ? R.mipmap.iot_aquarium_48 : R.mipmap.iot_aquarium_70;
            case 3:
                return i == 1 ? R.mipmap.iot_behind_mirror_36 : i == 2 ? R.mipmap.iot_behind_mirror_48 : R.mipmap.iot_behind_mirror_70;
            case 4:
                return i == 1 ? R.mipmap.iot_behind_sofa_36 : i == 2 ? R.mipmap.iot_behind_sofa_48 : R.mipmap.iot_behind_sofa_70;
            case 5:
                return i == 1 ? R.mipmap.iot_behind_tv_36 : i == 2 ? R.mipmap.iot_behind_tv_48 : R.mipmap.iot_behind_tv_70;
            case 6:
                return i == 1 ? R.mipmap.iot_ceiling_cove_36 : i == 2 ? R.mipmap.iot_ceiling_cove_48 : R.mipmap.iot_ceiling_cove_70;
            case 7:
                return i == 1 ? R.mipmap.iot_stair_rail_36 : i == 2 ? R.mipmap.iot_stair_rail_48 : R.mipmap.iot_stair_rail_70;
            case 8:
                return i == 1 ? R.mipmap.iot_under_cabinet_36 : i == 2 ? R.mipmap.iot_under_cabinet_48 : R.mipmap.iot_under_cabinet_70;
            case 9:
                return i == 1 ? R.mipmap.iot_under_counter_36 : i == 2 ? R.mipmap.iot_under_counter_48 : R.mipmap.iot_under_counter_70;
            case 10:
                return i == 1 ? R.mipmap.iot_under_stair_tread_36 : i == 2 ? R.mipmap.iot_under_stair_tread_48 : R.mipmap.iot_under_stair_tread_70;
            default:
                return i3;
        }
    }

    public static final int f(DesiredStatesBean desiredStatesBean) {
        if (desiredStatesBean == null) {
            return 0;
        }
        if (!desiredStatesBean.isOn()) {
            return Color.parseColor("#D4E2EE");
        }
        if (desiredStatesBean.isAuto()) {
            return 0;
        }
        if (desiredStatesBean.getColorTemp() != 0) {
            return -1;
        }
        return new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(desiredStatesBean.getHue(), desiredStatesBean.getSaturation(), 100).f();
    }

    public static final boolean g(String str) {
        boolean A;
        if (str == null) {
            return false;
        }
        A = v.A(str, "L900", false, 2, null);
        return A;
    }

    public static final boolean h(String deviceIdMD5) {
        j.e(deviceIdMD5, "deviceIdMD5");
        BaseALIoTDevice I1 = TPIoTClientManager.I1(deviceIdMD5);
        if (I1 != null) {
            return I1.isLightStrip();
        }
        return false;
    }

    public static final boolean i(String str) {
        boolean A;
        boolean A2;
        boolean A3;
        if (str == null) {
            return false;
        }
        A = v.A(str, "L900", false, 2, null);
        if (!A) {
            A2 = v.A(str, "L920", false, 2, null);
            if (!A2) {
                A3 = v.A(str, "L930", false, 2, null);
                if (!A3) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final boolean j(String str) {
        boolean A;
        boolean A2;
        if (str == null) {
            return false;
        }
        A = v.A(str, "L920", false, 2, null);
        if (!A) {
            A2 = v.A(str, "L930", false, 2, null);
            if (!A2) {
                return false;
            }
        }
        return true;
    }

    public static final boolean k(int[] iArr, boolean z) {
        int[] n = n(iArr);
        return z && n[0] != n[1];
    }

    public static final boolean l(int[] iArr, boolean z) {
        int[] n = n(iArr);
        return z && n[0] == n[1];
    }

    @ColorInt
    public static final int m(IoTLightStripDevice ioTLightStripDevice) {
        if (ioTLightStripDevice != null && ioTLightStripDevice.getColorTemp() == 0) {
            return new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(ioTLightStripDevice.getHue(), ioTLightStripDevice.getSaturation(), ioTLightStripDevice.getBrightness()).g();
        }
        return -1;
    }

    public static final int[] n(int[] iArr) {
        int[] iArr2 = {2500, 6500};
        return iArr == null ? iArr2 : iArr.length == 1 ? new int[]{iArr[0], iArr[0]} : iArr.length >= 2 ? new int[]{iArr[0], iArr[1]} : iArr2;
    }
}
