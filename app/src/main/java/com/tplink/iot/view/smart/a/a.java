package com.tplink.iot.view.smart.a;

import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.List;
import kotlin.collections.n;

/* compiled from: SmartDefine.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final List<EnumDeviceType> a;

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f9713b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<EnumDeviceType> f9714c;

    /* renamed from: d  reason: collision with root package name */
    public static final List<String> f9715d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f9716e = new a();

    static {
        List<EnumDeviceType> g;
        List<String> g2;
        List<EnumDeviceType> g3;
        List<String> g4;
        EnumDeviceType enumDeviceType = EnumDeviceType.HUB;
        EnumDeviceType enumDeviceType2 = EnumDeviceType.SWITCH;
        EnumDeviceType enumDeviceType3 = EnumDeviceType.ENERGY;
        EnumDeviceType enumDeviceType4 = EnumDeviceType.CAMERA;
        g = n.g(enumDeviceType, EnumDeviceType.SENSOR, enumDeviceType2, enumDeviceType3, enumDeviceType4);
        a = g;
        EnumIoTCategory enumIoTCategory = EnumIoTCategory.HUB;
        EnumIoTCategory enumIoTCategory2 = EnumIoTCategory.CAMERA;
        EnumIoTCategory enumIoTCategory3 = EnumIoTCategory.SUBG_PLUGSWITCH_SWITCH;
        EnumIoTCategory enumIoTCategory4 = EnumIoTCategory.SUBG_TRV;
        g2 = n.g(enumIoTCategory.value(), enumIoTCategory2.value(), EnumIoTCategory.SUBG_TRIGGER_MOTION_SENSOR.value(), EnumIoTCategory.SUBG_TRIGGER_CONTACT_SENSOR.value(), EnumIoTCategory.SUBG_TRIGGER_BUTTON.value(), enumIoTCategory3.value(), enumIoTCategory4.value());
        f9713b = g2;
        g3 = n.g(EnumDeviceType.PLUG, EnumDeviceType.BULB, enumDeviceType, enumDeviceType2, enumDeviceType3, enumDeviceType4);
        f9714c = g3;
        g4 = n.g(EnumIoTCategory.PLUG.value(), EnumIoTCategory.LIGHT.value(), EnumIoTCategory.LIGHT_STRIP.value(), enumIoTCategory.value(), enumIoTCategory3.value(), enumIoTCategory4.value(), enumIoTCategory2.value());
        f9715d = g4;
    }

    private a() {
    }
}
