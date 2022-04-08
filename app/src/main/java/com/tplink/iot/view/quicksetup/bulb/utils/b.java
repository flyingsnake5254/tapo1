package com.tplink.iot.view.quicksetup.bulb.utils;

import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import com.google.firebase.messaging.ServiceStarter;
import com.tplink.iot.R;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.g.b.c.c;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHubAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SoftApOnboardingUtils.java */
/* loaded from: classes2.dex */
public class b {

    /* compiled from: SoftApOnboardingUtils.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumDeviceType.values().length];
            a = iArr;
            try {
                iArr[EnumDeviceType.BULB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumDeviceType.HUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumDeviceType.PLUG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @StringRes
    public static int a(String str) {
        int i = a.a[l(str).ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? R.string.quicksetup_first_introduce_btn_bottom_content : str.startsWith("P115") ? R.string.quicksetup_led_not_blinking_pink_and_blue : R.string.quicksetup_led_not_blinking_orange_and_green : R.string.hub_qs_led_not_blink_orange_and_blue : c.i(str) ? R.string.light_strip_obd_not_orange_and_green : R.string.quicksetup_first_introduce_btn_bottom_content;
    }

    @StringRes
    public static int b(String str) {
        return a.a[l(str).ordinal()] != 2 ? R.string.common_next : R.string.onboarding_check_led_already_orange_blue;
    }

    @DrawableRes
    public static int c(String str) {
        int i = a.a[l(str).ordinal()];
        return i != 1 ? i != 2 ? R.mipmap.bulb_power_up_off : R.drawable.check_hub_status_h100 : c.i(str) ? R.drawable.check_status_light_strip : R.mipmap.bulb_power_up_off;
    }

    public static String d(String str) {
        int i = a.a[l(str).ordinal()];
        if (i != 1) {
            if (i != 2) {
                return AppContext.f6185c.getString(R.string.qs_bulb_introduce_second_content_v2);
            }
            return AppContext.f6185c.getString(R.string.onboarding_check_led_blink_orange_and_blue);
        } else if (c.j(str)) {
            return AppContext.f6185c.getString(R.string.light_strip_obd_guide_desc_l920);
        } else {
            if (c.g(str)) {
                return AppContext.f6185c.getString(R.string.light_strip_obd_guide_desc_l900);
            }
            return AppContext.f6185c.getString(R.string.qs_bulb_introduce_second_content_v2);
        }
    }

    public static String e(String str) {
        int i = a.a[l(str).ordinal()];
        if (i != 1) {
            return i != 2 ? AppContext.f6185c.getString(R.string.qs_bulb_introduce_second_content_v2) : AppContext.f6185c.getString(R.string.onboarding_reset_hub_hint_V3, new Object[]{5});
        }
        if (c.j(str)) {
            return AppContext.f6185c.getString(R.string.light_strip_obd_reset_hint_l920);
        }
        if (c.g(str)) {
            return AppContext.f6185c.getString(R.string.light_strip_obd_reset_hint_l900);
        }
        return AppContext.f6185c.getString(R.string.light_strip_obd_reset_hint_l900);
    }

    @DrawableRes
    public static int f(String str) {
        int i = a.a[l(str).ordinal()];
        return i != 1 ? i != 2 ? R.mipmap.bulb_configuration_off : R.drawable.reset_hub_h100 : c.i(str) ? R.drawable.reset_light_strip : R.drawable.reset_hub_h100;
    }

    @StringRes
    public static int g(String str) {
        return (a.a[l(str).ordinal()] == 1 && c.i(str)) ? R.string.light_strip_obd_reset_title : R.string.camera_onboarding_reset_tapo;
    }

    public static String h(String str) {
        int i = a.a[l(str).ordinal()];
        if (i != 1) {
            if (i != 2) {
                return AppContext.f6185c.getString(R.string.quicksetup_keep_phone_close_device);
            }
            return AppContext.f6185c.getString(R.string.quicksetup_keep_phone_close_device);
        } else if (c.i(str)) {
            return AppContext.f6185c.getString(R.string.light_strip_obd_keep_phone_close);
        } else {
            return AppContext.f6185c.getString(R.string.quicksetup_keep_phone_close_device);
        }
    }

    @StringRes
    public static int i(String str) {
        return (a.a[l(str).ordinal()] == 1 && c.i(str)) ? R.string.light_strip_obd_guide_title : R.string.onboarding_new_ipc_power_up_and_check_led;
    }

    @StringRes
    public static int j(String str) {
        int i = a.a[l(str).ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? R.string.smart_bulb : R.string.plug : R.string.smart_hub : c.i(str) ? R.string.smart_light_strip : R.string.smart_bulb;
    }

    public static int k(String str) {
        int i = a.a[l(str).ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? R.mipmap.bulb : com.tplink.iot.view.quicksetup.base.c.d(str) : R.mipmap.h100_animate : c.i(str) ? R.mipmap.light_strip_anim_white : R.mipmap.bulb;
    }

    public static EnumDeviceType l(String str) {
        if (TextUtils.isEmpty(str)) {
            return EnumDeviceType.UNKNOWN;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 2193577:
                if (str.equals("H100")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2316616:
                if (str.equals("L510")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2316647:
                if (str.equals("L520")) {
                    c2 = 2;
                    break;
                }
                break;
            case 2316678:
                if (str.equals("L530")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2320429:
                if (str.equals("L900")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2320491:
                if (str.equals("L920")) {
                    c2 = 5;
                    break;
                }
                break;
            case 2320522:
                if (str.equals("L930")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2431936:
                if (str.equals("P110")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2431941:
                if (str.equals("P115")) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return EnumDeviceType.HUB;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return EnumDeviceType.BULB;
            case 7:
            case '\b':
                return EnumDeviceType.PLUG;
            default:
                return EnumDeviceType.UNKNOWN;
        }
    }

    public static List<String> m(String str) {
        EnumDeviceType l = l(str);
        ArrayList arrayList = new ArrayList();
        int i = a.a[l.ordinal()];
        int i2 = 0;
        if (i != 1) {
            if (i == 2) {
                EnumHubAvatarType[] values = EnumHubAvatarType.values();
                int length = values.length;
                while (i2 < length) {
                    arrayList.add(values[i2].getName());
                    i2++;
                }
            } else if (i != 3) {
                EnumBulbAvatarType[] values2 = EnumBulbAvatarType.values();
                int length2 = values2.length;
                while (i2 < length2) {
                    arrayList.add(values2[i2].getName());
                    i2++;
                }
            } else {
                EnumIoTAvatarType[] values3 = EnumIoTAvatarType.values();
                int length3 = values3.length;
                while (i2 < length3) {
                    arrayList.add(values3[i2].getName());
                    i2++;
                }
            }
        } else if (c.i(str)) {
            EnumLightStripAvatarType[] values4 = EnumLightStripAvatarType.values();
            int length4 = values4.length;
            while (i2 < length4) {
                arrayList.add(values4[i2].getValue());
                i2++;
            }
        } else {
            EnumBulbAvatarType[] values5 = EnumBulbAvatarType.values();
            int length5 = values5.length;
            while (i2 < length5) {
                arrayList.add(values5[i2].getName());
                i2++;
            }
        }
        return arrayList;
    }

    public static int n(String str) {
        if (a.a[l(str).ordinal()] != 2) {
            return 1000;
        }
        return ServiceStarter.ERROR_UNKNOWN;
    }

    public static int[] o(String str) {
        int i = a.a[l(str).ordinal()];
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return new int[]{R.mipmap.h100_animate_led_blue};
        } else if (c.i(str)) {
            return new int[]{R.mipmap.light_strip_anim_green};
        } else {
            return null;
        }
    }

    public static int[] p(String str) {
        int i = a.a[l(str).ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new int[]{R.mipmap.h100_animate_led_orange};
            }
            if (i != 3) {
                return null;
            }
            return new int[]{com.tplink.iot.view.quicksetup.base.c.j(str), com.tplink.iot.view.quicksetup.base.c.f(str)};
        } else if (c.i(str)) {
            return new int[]{R.mipmap.light_strip_anim_green, R.mipmap.light_strip_anim_orange};
        } else {
            return null;
        }
    }

    public static int[] q(String str) {
        int i = a.a[l(str).ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new int[]{R.mipmap.h100_animate_led_orange, R.mipmap.h100_animate_led_blue};
            }
            if (i == 3 && !"P115".equals(str)) {
                return new int[]{com.tplink.iot.view.quicksetup.base.c.j(str), com.tplink.iot.view.quicksetup.base.c.f(str)};
            }
            return null;
        } else if (c.i(str)) {
            return new int[]{R.mipmap.light_strip_anim_green, R.mipmap.light_strip_anim_orange};
        }
        return null;
    }

    @LayoutRes
    public static int r(String str) {
        int i = a.a[l(str).ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? R.layout.layout_softap_no_find_tips_bulb : R.layout.layout_softap_no_find_tips_plug : R.layout.layout_softap_no_find_tips_hub : c.i(str) ? R.layout.layout_softap_no_find_tips_light_strip : R.layout.layout_softap_no_find_tips_bulb;
    }

    @LayoutRes
    public static int s(String str) {
        int i = a.a[l(str).ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? R.layout.layout_softap_pairing_failed_tips_bulb : R.layout.layout_softap_pairing_failed_tips_plug : R.layout.layout_softap_pairing_failed_tips_hub : c.i(str) ? R.layout.layout_softap_pairing_failed_tips_light_strip : R.layout.layout_softap_pairing_failed_tips_bulb;
    }

    public static EnumOnboardingType t(String str) {
        EnumDeviceType l = l(str);
        EnumOnboardingType enumOnboardingType = EnumOnboardingType.BULB_SOFT_AP;
        int i = a.a[l.ordinal()];
        if (i != 2) {
            return i != 3 ? enumOnboardingType : EnumOnboardingType.PLUG_SOFT_AP;
        }
        return EnumOnboardingType.HUB_SOFT_AP;
    }

    public static int u(String str) {
        int i = a.a[l(str).ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? R.mipmap.bulb_ssid_connect : R.mipmap.plug_ssid_connect : R.drawable.hub_ssid_connect : c.i(str) ? R.mipmap.light_strip_ssid_connect : R.mipmap.bulb_ssid_connect;
    }

    public static String v(String str) {
        int i = a.a[l(str).ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "Tapo_Bulb_XXXX" : "Tapo_Plug_XXXX" : "Tapo_Hub_XXXX" : c.i(str) ? "Tapo_Light Strip_XXXX" : "Tapo_Bulb_XXXX";
    }
}
