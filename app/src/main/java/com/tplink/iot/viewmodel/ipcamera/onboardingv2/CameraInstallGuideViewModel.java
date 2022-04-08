package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

/* loaded from: classes2.dex */
public class CameraInstallGuideViewModel extends OnBoardingFragmentViewModel {
    public final ObservableBoolean a = new ObservableBoolean(false);

    public CameraInstallGuideViewModel(@NonNull Application application) {
        super(application);
    }

    private int f(int i) {
        if (i == 1) {
            return R.mipmap.camera_install_tool;
        }
        if (i == 2) {
            return R.mipmap.camera_install_mark_hole_c110;
        }
        if (i == 3) {
            return R.mipmap.camera_install_affix_scre_c110;
        }
        if (i != 4) {
            return 0;
        }
        return R.mipmap.camera_install_place_camera_c110;
    }

    private String g(int i) {
        if (i == 1) {
            return getApplication().getString(R.string.camera_install_guide_text_c110_tool);
        }
        if (i == 2) {
            return getApplication().getString(R.string.camera_install_guide_text_c110_mounting) + "\n\n" + getApplication().getString(R.string.camera_install_guide_text_c110_drill);
        } else if (i != 3) {
            return i != 4 ? "" : getApplication().getString(R.string.camera_install_guide_text_c110_hang_on);
        } else {
            return getApplication().getString(R.string.camera_install_guide_text_c110_affix);
        }
    }

    private int h(int i) {
        if (i == 1) {
            return R.mipmap.camera_install_tool;
        }
        if (i == 2) {
            return R.mipmap.camera_install_mark_hole_c210;
        }
        if (i == 3) {
            return R.mipmap.camera_install_affix_scre_c210;
        }
        if (i != 4) {
            return 0;
        }
        return R.mipmap.camera_install_attach_camera_c210;
    }

    private String i(int i) {
        if (i == 1) {
            return getApplication().getString(R.string.camera_install_guide_text_c110_tool);
        }
        if (i == 2) {
            return getApplication().getString(R.string.camera_install_guide_text_c110_mounting) + "\n\n" + getApplication().getString(R.string.camera_install_guide_text_c110_drill);
        } else if (i != 3) {
            return i != 4 ? "" : getApplication().getString(R.string.camera_install_guide_text_c210_attach);
        } else {
            return getApplication().getString(R.string.camera_install_guide_text_c110_affix);
        }
    }

    private int j(int i) {
        if (i == 1) {
            return R.mipmap.camera_install_tool;
        }
        if (i == 2) {
            return R.mipmap.camera_install_mark_hole_c310;
        }
        if (i != 3) {
            return 0;
        }
        return R.mipmap.camera_install_affix_scre_c310;
    }

    private String k(int i) {
        if (i == 1) {
            return getApplication().getString(R.string.camera_install_guide_text_c110_tool);
        }
        if (i != 2) {
            return i != 3 ? "" : getApplication().getString(R.string.camera_install_guide_text_c110_affix);
        }
        return getApplication().getString(R.string.camera_install_guide_text_c310_mounting) + "\n\n" + getApplication().getString(R.string.camera_install_guide_text_c110_drill);
    }

    public int l(int i, DeviceModel deviceModel) {
        if (c.t(deviceModel)) {
            return f(i);
        }
        if (c.u(deviceModel)) {
            return h(i);
        }
        if (c.v(deviceModel)) {
            return j(i);
        }
        return h(i);
    }

    public String m(int i, DeviceModel deviceModel) {
        if (c.t(deviceModel)) {
            return g(i);
        }
        if (c.u(deviceModel)) {
            return i(i);
        }
        return c.v(deviceModel) ? k(i) : "";
    }
}
