package com.tplink.iot.Utils.z0;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import com.tplink.iot.R;
import com.tplink.iot.devices.lightstrip.view.LightStripDetailActivity;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.view.bulb.BulbDetailActivity;
import com.tplink.iot.view.colorbulb.ColorBulbDetailActivity;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;

/* compiled from: BulbUtils.java */
/* loaded from: classes2.dex */
public class g {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BulbUtils.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumBulbAvatarType.values().length];
            a = iArr;
            try {
                iArr[EnumBulbAvatarType.BULB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumBulbAvatarType.TABLE_LAMP_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumBulbAvatarType.TABLE_LAMP_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumBulbAvatarType.TABLE_LAMP_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumBulbAvatarType.TABLE_LAMP_4.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumBulbAvatarType.TABLE_LAMP_5.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[EnumBulbAvatarType.FLOOR_LAMP_1.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[EnumBulbAvatarType.FLOOR_LAMP_2.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[EnumBulbAvatarType.FLOOR_LAMP_3.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[EnumBulbAvatarType.HANG_LAMP_1.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[EnumBulbAvatarType.HANG_LAMP_2.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[EnumBulbAvatarType.HANG_LAMP_3.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @DrawableRes
    public static int a(String str) {
        return TextUtils.isEmpty(str) ? R.mipmap.ic_fw_bulb_l510e : str.contains("L520") ? R.mipmap.ic_fw_l520 : str.contains("L530") ? R.mipmap.ic_fw_bulb_l530e : R.mipmap.ic_fw_bulb_l510e;
    }

    private static int b(EnumBulbAvatarType enumBulbAvatarType, int i) {
        int i2 = R.mipmap.iot_bulb_48;
        int i3 = i == 1 ? R.mipmap.iot_bulb_36 : i == 2 ? R.mipmap.iot_bulb_48 : R.mipmap.iot_bulb_70;
        if (enumBulbAvatarType == null) {
            return i3;
        }
        switch (a.a[enumBulbAvatarType.ordinal()]) {
            case 1:
                if (i == 1) {
                    i2 = R.mipmap.iot_bulb_36;
                } else if (i != 2) {
                    i2 = R.mipmap.iot_bulb_70;
                }
                return i2;
            case 2:
                return i == 1 ? R.mipmap.iot_table_lamp_1_36 : i == 2 ? R.mipmap.iot_table_lamp_1_48 : R.mipmap.iot_table_lamp_1_70;
            case 3:
                return i == 1 ? R.mipmap.iot_table_lamp_2_36 : i == 2 ? R.mipmap.iot_table_lamp_2_48 : R.mipmap.iot_table_lamp_2_70;
            case 4:
                return i == 1 ? R.mipmap.iot_table_lamp_3_36 : i == 2 ? R.mipmap.iot_table_lamp_3_48 : R.mipmap.iot_table_lamp_3_70;
            case 5:
                return i == 1 ? R.mipmap.iot_table_lamp_4_36 : i == 2 ? R.mipmap.iot_table_lamp_4_48 : R.mipmap.iot_table_lamp_4_70;
            case 6:
                return i == 1 ? R.mipmap.iot_table_lamp_5_36 : i == 2 ? R.mipmap.iot_table_lamp_5_48 : R.mipmap.iot_table_lamp_5_70;
            case 7:
                return i == 1 ? R.mipmap.iot_floor_lamp_1_36 : i == 2 ? R.mipmap.iot_floor_lamp_1_48 : R.mipmap.iot_floor_lamp_1_70;
            case 8:
                return i == 1 ? R.mipmap.iot_floor_lamp_2_36 : i == 2 ? R.mipmap.iot_floor_lamp_2_48 : R.mipmap.iot_floor_lamp_2_70;
            case 9:
                return i == 1 ? R.mipmap.iot_floor_lamp_3_36 : i == 2 ? R.mipmap.iot_floor_lamp_3_48 : R.mipmap.iot_floor_lamp_3_70;
            case 10:
                return i == 1 ? R.mipmap.iot_hang_lamp_1_36 : i == 2 ? R.mipmap.iot_hang_lamp_1_48 : R.mipmap.iot_hang_lamp_1_70;
            case 11:
                return i == 1 ? R.mipmap.iot_hang_lamp_2_36 : i == 2 ? R.mipmap.iot_hang_lamp_2_48 : R.mipmap.iot_hang_lamp_2_70;
            case 12:
                return i == 1 ? R.mipmap.iot_hang_lamp_3_36 : i == 2 ? R.mipmap.iot_hang_lamp_3_48 : R.mipmap.iot_hang_lamp_3_70;
            default:
                return i3;
        }
    }

    public static int c(EnumBulbAvatarType enumBulbAvatarType) {
        return b(enumBulbAvatarType, 1);
    }

    public static int d(EnumBulbAvatarType enumBulbAvatarType) {
        return b(enumBulbAvatarType, 2);
    }

    public static int e(EnumBulbAvatarType enumBulbAvatarType) {
        return b(enumBulbAvatarType, 3);
    }

    public static int f(boolean z) {
        if (z) {
            return 0;
        }
        return Color.parseColor("#D4E2EE");
    }

    public static int g() {
        return -1275077491;
    }

    public static void h(Context context, String str) {
        if (c.h(str)) {
            LightStripDetailActivity.x2(context, str);
        } else if (com.tplink.iot.Utils.w0.a.e(str)) {
            ColorBulbDetailActivity.Z1(context, str);
        } else {
            BulbDetailActivity.D1(context, str);
        }
    }
}
