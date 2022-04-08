package com.tplink.libtpnetwork.Utils;

import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;
import kotlin.text.o;

/* compiled from: PrintUtils.kt */
/* loaded from: classes3.dex */
public final class l {
    public static final void a(a<String> msg) {
        j.e(msg, "msg");
    }

    public static final String b(IoTLightStripDevice ioTLightStripDevice) {
        String f2;
        LightingEffectData lightingEffectData;
        StringBuilder sb = new StringBuilder();
        sb.append("\n        {\n            \"on\": ");
        String str = null;
        sb.append(ioTLightStripDevice != null ? Boolean.valueOf(ioTLightStripDevice.isDeviceOn()) : null);
        sb.append(",\n            \"hue\": ");
        sb.append(ioTLightStripDevice != null ? Integer.valueOf(ioTLightStripDevice.getHue()) : null);
        sb.append(",\n            \"saturation\": ");
        sb.append(ioTLightStripDevice != null ? Integer.valueOf(ioTLightStripDevice.getSaturation()) : null);
        sb.append(",\n            \"brightness\": ");
        sb.append(ioTLightStripDevice != null ? Integer.valueOf(ioTLightStripDevice.getBrightness()) : null);
        sb.append(",\n            \"colorTemp\": ");
        sb.append(ioTLightStripDevice != null ? Integer.valueOf(ioTLightStripDevice.getColorTemp()) : null);
        sb.append(",\n            \"lighting_effect\": ");
        if (!(ioTLightStripDevice == null || (lightingEffectData = ioTLightStripDevice.getLightingEffectData()) == null)) {
            str = c(lightingEffectData);
        }
        sb.append(str);
        sb.append("\n        }\n    ");
        f2 = o.f(sb.toString());
        return f2;
    }

    public static final String c(LightingEffectData lightingEffectData) {
        String f2;
        Integer[][] numArr;
        Integer[][] numArr2;
        StringBuilder sb = new StringBuilder();
        sb.append("\n        {\n            \"id\": ");
        String str = null;
        sb.append(lightingEffectData != null ? lightingEffectData.id : null);
        sb.append(",\n            \"type\": ");
        sb.append(lightingEffectData != null ? lightingEffectData.type : null);
        sb.append(",\n            \"name\": ");
        sb.append(lightingEffectData != null ? lightingEffectData.name : null);
        sb.append(",\n            \"custom\": ");
        sb.append(lightingEffectData != null ? lightingEffectData.custom : null);
        sb.append(",\n            \"enable\": ");
        sb.append(lightingEffectData != null ? lightingEffectData.enable : null);
        sb.append(",\n            \"brightness\": ");
        sb.append(lightingEffectData != null ? lightingEffectData.brightness : null);
        sb.append(",\n            \"bAdjusted\": ");
        sb.append(lightingEffectData != null ? lightingEffectData.bAdjusted : null);
        sb.append(",\n            \"display_colors\": ");
        sb.append((lightingEffectData == null || (numArr2 = lightingEffectData.display_colors) == null) ? null : e(numArr2));
        sb.append(",\n            \"sequence\": ");
        if (!(lightingEffectData == null || (numArr = lightingEffectData.sequence) == null)) {
            str = e(numArr);
        }
        sb.append(str);
        sb.append("\n        }\n    ");
        f2 = o.f(sb.toString());
        return f2;
    }

    public static final String d(LocalIoTBaseDevice localIoTBaseDevice) {
        String j = i.j(localIoTBaseDevice);
        j.d(j, "GsonUtils.toPrettyJson(this)");
        return j;
    }

    public static final String e(Object obj) {
        String f2 = i.f(obj);
        j.d(f2, "GsonUtils.toJson(this)");
        return f2;
    }

    public static final String f(WebResourceError webResourceError) {
        String f2;
        if (webResourceError == null) {
            return "null WebResourceError";
        }
        if (Build.VERSION.SDK_INT < 23) {
            return "Android SDK VERSION < 23";
        }
        f2 = o.f("\n            {\n                \"errorCode\": " + webResourceError.getErrorCode() + ",\n                \"description\": " + webResourceError.getDescription() + "\n            }\n        ");
        return f2;
    }

    public static final String g(WebResourceRequest webResourceRequest) {
        String f2;
        if (webResourceRequest == null) {
            return "null WebResourceRequest";
        }
        f2 = o.f("\n        {\n            \"url\": " + webResourceRequest.getUrl() + ",\n            \"method\": " + webResourceRequest.getMethod() + ",\n            \"headers\": " + e(webResourceRequest.getRequestHeaders()) + "\n        }\n    ");
        return f2;
    }

    public static final String h(Object obj) {
        String j = i.j(obj);
        j.d(j, "GsonUtils.toPrettyJson(this)");
        return j;
    }

    public static final String i(LocalIoTBaseDevice localIoTBaseDevice) {
        if (localIoTBaseDevice == null) {
            return "Null LocalIoTBaseDevice";
        }
        return localIoTBaseDevice.getClass().getSimpleName() + "{name=" + localIoTBaseDevice.getNickname() + " icon=" + localIoTBaseDevice.getAvatar() + " location=" + localIoTBaseDevice.getLocation() + '}';
    }

    public static final String j(IoTSubDevice ioTSubDevice) {
        String f2;
        if (ioTSubDevice == null) {
            return "null trv";
        }
        f2 = o.f("\n        {\n            \"device_id\": " + ioTSubDevice.getDeviceId() + "\n            \"trv_states\": " + e(ioTSubDevice.getTrvStates()) + ",\n            \"temp_offset\": " + ioTSubDevice.getTempOffset() + ",\n            \"current_temp\": " + ioTSubDevice.getCurrentTemp() + ",\n            \"max_control_temp\": " + ioTSubDevice.getMaxControlTemp() + ",\n            \"min_control_temp\": " + ioTSubDevice.getMinControlTemp() + ",\n            \"target_temp\": " + ioTSubDevice.getTargetTemp() + ",\n            \"frost_protection_on\": " + ioTSubDevice.isFrostProtectionOn() + ",\n            \"temp_unit\": " + ioTSubDevice.getTempUnit() + "\n        }\n    ");
        return f2;
    }
}
