package com.tplink.iot.view.ipcamera.play.functionintroduce;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.R;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.tapocare.BillingActivity;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

/* loaded from: classes2.dex */
public class CameraIntroduceItemViewModel extends AndroidViewModel {
    public CameraIntroduceItemViewModel(@NonNull Application application) {
        super(application);
    }

    public int f(String str, DeviceModel deviceModel) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1936095366:
                if (str.equals("Person Detection")) {
                    c2 = 0;
                    break;
                }
                break;
            case -978993028:
                if (str.equals("Full Color Sight At Night")) {
                    c2 = 1;
                    break;
                }
                break;
            case -590254602:
                if (str.equals("Activity Zones")) {
                    c2 = 2;
                    break;
                }
                break;
            case -424404370:
                if (str.equals("Look Around")) {
                    c2 = 3;
                    break;
                }
                break;
            case -422763131:
                if (str.equals("Tapo Care")) {
                    c2 = 4;
                    break;
                }
                break;
            case -413987853:
                if (str.equals("Realtime Call")) {
                    c2 = 5;
                    break;
                }
                break;
            case -292972771:
                if (str.equals("Event Alerts")) {
                    c2 = 6;
                    break;
                }
                break;
            case 713308156:
                if (str.equals("Smart Night Vision Mode")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1342629676:
                if (str.equals("Intruders Beware")) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return R.mipmap.introduce_person_detection;
            case 1:
                return R.mipmap.introduce_full_color_sight_at_night;
            case 2:
                return (!c.t(deviceModel) && !c.u(deviceModel) && c.v(deviceModel)) ? R.mipmap.introduce_activity_zones_c310 : R.mipmap.introduce_activity_zones;
            case 3:
                if (!c.t(deviceModel) && c.u(deviceModel)) {
                }
                return R.mipmap.introduce_look_around_c210;
            case 4:
                return R.mipmap.introduce_tapo_care;
            case 5:
                if (c.t(deviceModel)) {
                    return R.mipmap.introduce_realtime_call_c110;
                }
                if (c.u(deviceModel)) {
                }
                return R.mipmap.introduce_realtime_call_c210;
            case 6:
                return R.mipmap.introduce_event_alerts;
            case 7:
                return R.mipmap.introduce_smart_night_vision_mode;
            case '\b':
                return R.mipmap.introduce_intruders_beware;
            default:
                return 0;
        }
    }

    public String g(String str) {
        return getApplication().getString(R.string.wss_function_learn_more);
    }

    public String h(String str, DeviceModel deviceModel) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1936095366:
                if (str.equals("Person Detection")) {
                    c2 = 0;
                    break;
                }
                break;
            case -978993028:
                if (str.equals("Full Color Sight At Night")) {
                    c2 = 1;
                    break;
                }
                break;
            case -590254602:
                if (str.equals("Activity Zones")) {
                    c2 = 2;
                    break;
                }
                break;
            case -424404370:
                if (str.equals("Look Around")) {
                    c2 = 3;
                    break;
                }
                break;
            case -422763131:
                if (str.equals("Tapo Care")) {
                    c2 = 4;
                    break;
                }
                break;
            case -413987853:
                if (str.equals("Realtime Call")) {
                    c2 = 5;
                    break;
                }
                break;
            case -292972771:
                if (str.equals("Event Alerts")) {
                    c2 = 6;
                    break;
                }
                break;
            case 713308156:
                if (str.equals("Smart Night Vision Mode")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1342629676:
                if (str.equals("Intruders Beware")) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return getApplication().getString(R.string.camera_introduce_person_detection_V2);
            case 1:
                return getApplication().getString(R.string.camera_introduce_full_color_sight_at_night);
            case 2:
                return getApplication().getString(R.string.camera_introduce_activity_zones);
            case 3:
                return getApplication().getString(R.string.camera_introduce_look_around_v2);
            case 4:
                return getApplication().getString(R.string.tapo_care_cloud_storage_services_content_new, new Object[]{"30"});
            case 5:
                return getApplication().getString(R.string.camera_introduce_realtime_call);
            case 6:
                return getApplication().getString(R.string.camera_introduce_event_alerts);
            case 7:
                return getApplication().getString(R.string.camera_introduce_smart_night_vision_mode);
            case '\b':
                return getApplication().getString(R.string.camera_introduce_intruders_beware);
            default:
                return "";
        }
    }

    public String i(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1936095366:
                if (str.equals("Person Detection")) {
                    c2 = 0;
                    break;
                }
                break;
            case -978993028:
                if (str.equals("Full Color Sight At Night")) {
                    c2 = 1;
                    break;
                }
                break;
            case -590254602:
                if (str.equals("Activity Zones")) {
                    c2 = 2;
                    break;
                }
                break;
            case -424404370:
                if (str.equals("Look Around")) {
                    c2 = 3;
                    break;
                }
                break;
            case -422763131:
                if (str.equals("Tapo Care")) {
                    c2 = 4;
                    break;
                }
                break;
            case -413987853:
                if (str.equals("Realtime Call")) {
                    c2 = 5;
                    break;
                }
                break;
            case -292972771:
                if (str.equals("Event Alerts")) {
                    c2 = 6;
                    break;
                }
                break;
            case 713308156:
                if (str.equals("Smart Night Vision Mode")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1342629676:
                if (str.equals("Intruders Beware")) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return getApplication().getString(R.string.camera_introduce_person_detection_title);
            case 1:
                return getApplication().getString(R.string.camera_introduce_full_color_sight_at_night_title);
            case 2:
                return getApplication().getString(R.string.setting_set_areas);
            case 3:
                return getApplication().getString(R.string.camera_introduce_look_around_title);
            case 4:
                return getApplication().getString(R.string.camera_introduce_tapo_care_title);
            case 5:
                return getApplication().getString(R.string.camera_introduce_realtime_call_title);
            case 6:
                return getApplication().getString(R.string.camera_introduce_event_alerts_title);
            case 7:
                return getApplication().getString(R.string.camera_introduce_smart_night_vision_mode_title);
            case '\b':
                return getApplication().getString(R.string.camera_introduce_intruders_beware_title);
            default:
                return "";
        }
    }

    public void j(Activity activity) {
        BillingActivity.f1(activity, e.x());
    }

    public boolean k(String str) {
        return "Tapo Care".equals(str);
    }
}
