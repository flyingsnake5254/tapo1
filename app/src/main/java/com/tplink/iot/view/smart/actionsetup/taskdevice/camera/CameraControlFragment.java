package com.tplink.iot.view.smart.actionsetup.taskdevice.camera;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tplink.iot.R;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.databinding.FragmentCameraControlBinding;
import com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: CameraControlFragment.kt */
/* loaded from: classes2.dex */
public final class CameraControlFragment extends DeviceControlBaseFragment<FragmentCameraControlBinding> {
    public static final a H3 = new a(null);
    private HashMap I3;

    /* compiled from: CameraControlFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final CameraControlFragment a(String deviceIdMD5) {
            j.e(deviceIdMD5, "deviceIdMD5");
            CameraControlFragment cameraControlFragment = new CameraControlFragment();
            cameraControlFragment.P0(deviceIdMD5);
            return cameraControlFragment;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final void Y0(int i) {
        ((FragmentCameraControlBinding) J0()).f6848f.check(i);
    }

    private final void Z0() {
        boolean l = U0().l(ThingModelDefine.Property.PROPERTY_CAMERA_LENS_MASK);
        RadioButton radioButton = ((FragmentCameraControlBinding) J0()).f6847d;
        j.d(radioButton, "mBinding.rbEnablePrivacy");
        int i = 0;
        radioButton.setVisibility(l ? 0 : 8);
        RadioButton radioButton2 = ((FragmentCameraControlBinding) J0()).f6846c;
        j.d(radioButton2, "mBinding.rbDisablePrivacy");
        if (!l) {
            i = 8;
        }
        radioButton2.setVisibility(i);
    }

    @Override // com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.I3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public int I0() {
        return R.layout.fragment_camera_control;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void N0() {
        RadioButton radioButton = ((FragmentCameraControlBinding) J0()).f6847d;
        j.d(radioButton, "mBinding.rbEnablePrivacy");
        radioButton.setChecked(true);
        Z0();
    }

    @Override // com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment
    public void T0(SmartThingAction thingAction) {
        j.e(thingAction, "thingAction");
        HashMap hashMap = new HashMap();
        RadioGroup radioGroup = ((FragmentCameraControlBinding) J0()).f6848f;
        j.d(radioGroup, "mBinding.rgCameraAction");
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rb_disable_privacy /* 2131363755 */:
                hashMap.put(ThingModelDefine.Property.PROPERTY_CAMERA_LENS_MASK, "off");
                break;
            case R.id.rb_enable_privacy /* 2131363756 */:
                hashMap.put(ThingModelDefine.Property.PROPERTY_CAMERA_LENS_MASK, "on");
                break;
        }
        thingAction.setStateDesired(hashMap);
    }

    @Override // com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment
    protected void W0(SmartThingAction smartThingAction) {
        Map<String, Object> stateDesired;
        if (smartThingAction != null && (stateDesired = smartThingAction.getStateDesired()) != null) {
            Object obj = stateDesired.get(ThingModelDefine.Property.PROPERTY_CAMERA_LENS_MASK);
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str = (String) obj;
            if (str != null && str.hashCode() == 3551 && str.equals("on")) {
                Y0(R.id.rb_enable_privacy);
            } else {
                Y0(R.id.rb_disable_privacy);
            }
        }
    }

    @Override // com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }
}
