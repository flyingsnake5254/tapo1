package com.tplink.iot.Utils.z0;

import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import b.d.b.f.b;
import com.tplink.iot.R;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.view.quicksetup.base.EnumCountry;
import com.tplink.iot.view.quicksetup.base.c;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;

/* compiled from: PlugUtil.java */
/* loaded from: classes2.dex */
public class q {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlugUtil.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5402b;

        static {
            int[] iArr = new int[EnumCountry.values().length];
            f5402b = iArr;
            try {
                iArr[EnumCountry.EU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5402b[EnumCountry.US.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5402b[EnumCountry.JP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5402b[EnumCountry.UK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5402b[EnumCountry.FR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[EnumIoTAvatarType.values().length];
            a = iArr2;
            try {
                iArr2[EnumIoTAvatarType.PLUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[EnumIoTAvatarType.FAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[EnumIoTAvatarType.TABLE_LAMP.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[EnumIoTAvatarType.CEILING_LAMP.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[EnumIoTAvatarType.TAPE_LIGHTS.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[EnumIoTAvatarType.WALL_LAMP.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[EnumIoTAvatarType.SOUND.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[EnumIoTAvatarType.RADIO.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[EnumIoTAvatarType.HUMIDIFIER.ordinal()] = 9;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[EnumIoTAvatarType.KETTLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[EnumIoTAvatarType.COFFEE_MAKER.ordinal()] = 11;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[EnumIoTAvatarType.JUICER.ordinal()] = 12;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[EnumIoTAvatarType.EGG_BOILER.ordinal()] = 13;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[EnumIoTAvatarType.BREAD_MAKER.ordinal()] = 14;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[EnumIoTAvatarType.HOUSE.ordinal()] = 15;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    @DrawableRes
    public static int a(EnumCountry enumCountry, String str) {
        if (enumCountry == null) {
            return R.mipmap.specs_eu;
        }
        int i = a.f5402b[enumCountry.ordinal()];
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? "P115".equals(str) ? R.mipmap.specs_p115_eu : R.mipmap.specs_eu : R.mipmap.specs_fr : R.mipmap.specs_uk : R.mipmap.specs_jp : R.mipmap.specs_us;
    }

    private static int b(int i) {
        int i2;
        if (i == 1) {
            i2 = R.mipmap.iot_plug_36;
        } else {
            i2 = i == 2 ? R.mipmap.iot_plug_48 : R.mipmap.iot_plug_70;
        }
        return a.f5402b[c.p().ordinal()] != 1 ? i2 : i == 1 ? R.mipmap.iot_plug_p115_eu_36 : i == 2 ? R.mipmap.iot_plug_p115_eu_48 : R.mipmap.iot_plug_p115_eu_70;
    }

    private static String c(BaseALIoTDevice baseALIoTDevice) {
        if (baseALIoTDevice != null && !baseALIoTDevice.isUserRoleTypeDevice()) {
            String familyId = baseALIoTDevice.getFamilyId();
            String roomId = baseALIoTDevice.getRoomId();
            if (!TextUtils.isEmpty(familyId) && !TextUtils.isEmpty(roomId)) {
                String f0 = ((FamilyManagerRepository) b.a(b.d.s.a.a.f(), FamilyManagerRepository.class)).f0(familyId, roomId);
                return TextUtils.isEmpty(f0) ? "" : f0;
            }
        }
        return "";
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return EnumDeviceNicknameType.fromType(EnumDeviceNicknameType.BEDROOM);
        }
        EnumDeviceNicknameType fromString = EnumDeviceNicknameType.fromString(str);
        if (fromString == null) {
            return b.d.w.h.a.a(str);
        }
        return EnumDeviceNicknameType.fromType(fromString);
    }

    public static String e(BaseALIoTDevice baseALIoTDevice) {
        return (baseALIoTDevice == null || baseALIoTDevice.isSupportIoTCloud()) ? c(baseALIoTDevice) : d(baseALIoTDevice.getDeviceLocation());
    }

    private static int f(EnumIoTAvatarType enumIoTAvatarType, int i) {
        int i2;
        if (i == 1) {
            i2 = R.mipmap.iot_plug_36;
        } else {
            i2 = i == 2 ? R.mipmap.iot_plug_48 : R.mipmap.iot_plug_70;
        }
        if (enumIoTAvatarType == null) {
            return i2;
        }
        switch (a.a[enumIoTAvatarType.ordinal()]) {
            case 1:
                return b(i);
            case 2:
                return i == 1 ? R.mipmap.iot_fan_36 : i == 2 ? R.mipmap.iot_fan_48 : R.mipmap.iot_fan_70;
            case 3:
                return i == 1 ? R.mipmap.iot_table_lamp_36 : i == 2 ? R.mipmap.iot_table_lamp_48 : R.mipmap.iot_table_lamp_70;
            case 4:
                return i == 1 ? R.mipmap.iot_ceiling_lamp_36 : i == 2 ? R.mipmap.iot_ceiling_lamp_48 : R.mipmap.iot_ceiling_lamp_70;
            case 5:
                return i == 1 ? R.mipmap.iot_tape_lights_36 : i == 2 ? R.mipmap.iot_tape_lights_48 : R.mipmap.iot_tape_lights_70;
            case 6:
                return i == 1 ? R.mipmap.iot_wall_lamp_36 : i == 2 ? R.mipmap.iot_wall_lamp_48 : R.mipmap.iot_wall_lamp_70;
            case 7:
                return i == 1 ? R.mipmap.iot_sound_36 : i == 2 ? R.mipmap.iot_sound_48 : R.mipmap.iot_sound_70;
            case 8:
                return i == 1 ? R.mipmap.iot_radio_36 : i == 2 ? R.mipmap.iot_radio_48 : R.mipmap.iot_radio_70;
            case 9:
                return i == 1 ? R.mipmap.iot_humidifier_36 : i == 2 ? R.mipmap.iot_humidifier_48 : R.mipmap.iot_humidifier_70;
            case 10:
                return i == 1 ? R.mipmap.iot_kettle_36 : i == 2 ? R.mipmap.iot_kettle_48 : R.mipmap.iot_kettle_70;
            case 11:
                return i == 1 ? R.mipmap.iot_coffee_maker_36 : i == 2 ? R.mipmap.iot_coffee_maker_48 : R.mipmap.iot_coffee_maker_70;
            case 12:
                return i == 1 ? R.mipmap.iot_juicer_36 : i == 2 ? R.mipmap.iot_juicer_48 : R.mipmap.iot_juicer_70;
            case 13:
                return i == 1 ? R.mipmap.iot_egg_boiler_36 : i == 2 ? R.mipmap.iot_egg_boiler_48 : R.mipmap.iot_egg_boiler_70;
            case 14:
                return i == 1 ? R.mipmap.iot_bread_maker_36 : i == 2 ? R.mipmap.iot_bread_maker_48 : R.mipmap.iot_bread_maker_70;
            case 15:
                return i == 1 ? R.mipmap.iot_house_36 : i == 2 ? R.mipmap.iot_house_48 : R.mipmap.iot_house_70;
            default:
                return i2;
        }
    }

    public static int g(EnumIoTAvatarType enumIoTAvatarType) {
        return f(enumIoTAvatarType, 1);
    }

    public static int h(EnumIoTAvatarType enumIoTAvatarType) {
        return f(enumIoTAvatarType, 2);
    }

    public static int i(EnumIoTAvatarType enumIoTAvatarType) {
        return f(enumIoTAvatarType, 3);
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("P110") || str.startsWith("P115");
    }
}
