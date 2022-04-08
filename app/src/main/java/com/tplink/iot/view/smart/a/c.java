package com.tplink.iot.view.smart.a;

import com.tplink.iot.R;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.g.d.a.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import java.util.Arrays;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

/* compiled from: SmartThingActionTextUtils.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final c a = new c();

    /* compiled from: SmartThingActionTextUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private boolean a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f9717b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9718c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9719d;

        public final boolean a() {
            return this.f9718c;
        }

        public final boolean b() {
            return this.f9719d;
        }

        public final boolean c() {
            return this.f9717b;
        }

        public final boolean d() {
            return this.a;
        }

        public final a e(boolean z) {
            this.f9718c = z;
            return this;
        }

        public final a f(boolean z) {
            this.f9719d = z;
            return this;
        }

        public final a g(boolean z) {
            this.f9717b = z;
            return this;
        }

        public final a h(boolean z) {
            this.a = z;
            return this;
        }
    }

    private c() {
    }

    private static final String a(int i) {
        String string = AppContext.f6185c.getString(i);
        j.d(string, "AppContext.instance.getString(resId)");
        return string;
    }

    private static final String b(int i, Object... objArr) {
        String string = AppContext.f6185c.getString(i, Arrays.copyOf(objArr, objArr.length));
        j.d(string, "AppContext.instance.getString(resId, *formatArgs)");
        return string;
    }

    public static final String c(SmartThingAction smartThingAction, BaseALIoTDevice<?> baseALIoTDevice, a options) {
        j.e(options, "options");
        if (!options.d() || !(smartThingAction == null || baseALIoTDevice == null || !baseALIoTDevice.isOnline())) {
            ThingServiceParams thingServiceParams = null;
            Map<String, Object> stateDesired = smartThingAction != null ? smartThingAction.getStateDesired() : null;
            if (smartThingAction != null) {
                thingServiceParams = smartThingAction.getService();
            }
            if (stateDesired != null) {
                return e(stateDesired, options);
            }
            return thingServiceParams != null ? d(thingServiceParams, options) : "";
        }
        String string = AppContext.f6185c.getString(R.string.tip_device_offline);
        j.d(string, "AppContext.instance.getS…tring.tip_device_offline)");
        return string;
    }

    private static final String d(ThingServiceParams thingServiceParams, a aVar) {
        String serviceId = thingServiceParams.getServiceId();
        if (serviceId != null) {
            switch (serviceId.hashCode()) {
                case -1377087850:
                    if (serviceId.equals(ThingModelDefine.Service.SERVICE_DECREASE_COLOR_TEMP)) {
                        return a(R.string.smart_action_decrease_color_temp);
                    }
                    break;
                case -728556493:
                    if (serviceId.equals(ThingModelDefine.Service.SERVICE_INCREASE_BRIGHTNESS)) {
                        return a(R.string.smart_action_increase_brightness);
                    }
                    break;
                case -725558176:
                    if (serviceId.equals(ThingModelDefine.Service.SERVICE_RANDOM_COLOR)) {
                        return a(R.string.smart_action_random_color);
                    }
                    break;
                case 3500592:
                    if (serviceId.equals(ThingModelDefine.Service.SERVICE_RING)) {
                        return a(R.string.smart_action_trigger_an_alarm);
                    }
                    break;
                case 666952591:
                    if (serviceId.equals(ThingModelDefine.Service.SERVICE_DECREASE_BRIGHTNESS)) {
                        return a(R.string.smart_action_decrease_brightness);
                    }
                    break;
                case 754435698:
                    if (serviceId.equals(ThingModelDefine.Service.SERVICE_INCREASE_COLOR_TEMP)) {
                        return a(R.string.smart_action_increase_color_temp);
                    }
                    break;
                case 1702616436:
                    if (serviceId.equals(ThingModelDefine.Service.SERVICE_REVERSE_STATUS)) {
                        return a(R.string.smart_action_device_turn_on_off);
                    }
                    break;
            }
        }
        return "";
    }

    private static final String e(Map<String, ? extends Object> map, a aVar) {
        Object obj = map.get("on");
        String str = null;
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        Object obj2 = map.get(ThingModelDefine.Property.PROPERTY_AUTO);
        if (!(obj2 instanceof Boolean)) {
            obj2 = null;
        }
        Boolean bool2 = (Boolean) obj2;
        boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        String a2 = a(R.string.smart_action_device_turn_off);
        if (booleanValue && booleanValue2) {
            a2 = a(R.string.smart_enable_auto_mode);
        } else if (booleanValue) {
            a2 = a(R.string.smart_action_device_turn_on);
        }
        Object obj3 = map.get("brightness");
        if (aVar.c() && booleanValue && !booleanValue2 && obj3 != null) {
            if (aVar.b()) {
                a2 = a2 + " | " + b(R.string.smart_action_device_brightness_task, obj3);
            } else {
                a2 = a2 + ", " + b(R.string.smart_action_device_brightness, obj3);
            }
        }
        String str2 = "";
        if (map.containsKey(ThingModelDefine.Property.PROPERTY_GUARD_ON)) {
            Object obj4 = map.get(ThingModelDefine.Property.PROPERTY_GUARD_ON);
            if (!(obj4 instanceof Boolean)) {
                obj4 = null;
            }
            Boolean bool3 = (Boolean) obj4;
            if (bool3 != null ? bool3.booleanValue() : false) {
                EnumGuardMode.a aVar2 = EnumGuardMode.Companion;
                Object obj5 = map.get("guard_mode");
                if (!(obj5 instanceof String)) {
                    obj5 = null;
                }
                String str3 = (String) obj5;
                if (str3 == null) {
                    str3 = str2;
                }
                int i = d.a[aVar2.a(str3).ordinal()];
                if (i == 1) {
                    a2 = a(R.string.smart_action_turn_on_home_mode);
                } else if (i == 2) {
                    a2 = a(R.string.smart_action_turn_on_away_mode);
                } else if (i == 3) {
                    a2 = a(R.string.smart_action_turn_on_sleep_mode);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                a2 = a(R.string.guard_mode_disarmed);
            }
        }
        if (map.get(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT) != null) {
            a2 = a2 + " | " + a(R.string.smart_action_set_effect);
        }
        if (map.containsKey(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON)) {
            Object obj6 = map.get(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON);
            if (!(obj6 instanceof Boolean)) {
                obj6 = null;
            }
            Boolean bool4 = (Boolean) obj6;
            if (bool4 != null ? bool4.booleanValue() : false) {
                a2 = a(R.string.common_off);
            } else {
                Object obj7 = map.get(ThingModelDefine.Property.PROPERTY_TARGET_TEMP);
                if (!(obj7 instanceof Number)) {
                    obj7 = null;
                }
                Number number = (Number) obj7;
                if (number != null) {
                    int intValue = number.intValue();
                    Object obj8 = map.get(ThingModelDefine.Property.PROPERTY_TEMP_UNIT);
                    if (!(obj8 instanceof String)) {
                        obj8 = null;
                    }
                    String str4 = (String) obj8;
                    if (str4 != null) {
                        a2 = b(R.string.smart_action_set_temperature_to_temp, b.e(intValue, str4));
                    }
                }
                return str2;
            }
        }
        if (!map.containsKey(ThingModelDefine.Property.PROPERTY_CAMERA_LENS_MASK)) {
            return a2;
        }
        Object obj9 = map.get(ThingModelDefine.Property.PROPERTY_CAMERA_LENS_MASK);
        if (obj9 instanceof String) {
            str = obj9;
        }
        String str5 = str;
        if (str5 != null) {
            int hashCode = str5.hashCode();
            if (hashCode != 3551) {
                if (hashCode == 109935 && str5.equals("off")) {
                    str2 = a(R.string.smart_camera_disable_privacy);
                }
            } else if (str5.equals("on")) {
                str2 = a(R.string.smart_camera_enable_privacy);
            }
        }
        return str2;
    }
}
