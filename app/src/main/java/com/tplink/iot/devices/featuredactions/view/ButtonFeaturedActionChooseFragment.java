package com.tplink.iot.devices.featuredactions.view;

import androidx.navigation.fragment.FragmentKt;
import com.tplink.iot.R;
import com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ButtonFeaturedActionFragments.kt */
/* loaded from: classes2.dex */
public final class ButtonFeaturedActionChooseFragment extends AbstractFeaturedActionChooseFragment {
    public static final a H3 = new a(null);
    private HashMap I3;

    /* compiled from: ButtonFeaturedActionFragments.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.I3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment
    public List<com.tplink.iot.g.a.a.a> U0() {
        List<com.tplink.iot.g.a.a.a> g;
        g = n.g(T0("FA_TurnOnOffSmartDevices", R.string.scene_turn_on_off_device_title), T0("FA_AdjustBrightness", R.string.scene_control_light_brightness_title), T0("FA_AdjustColorTemperature", R.string.scene_adjust_light_temperature_title), T0("FA_SetRightMood", R.string.scene_different_light_atmospheres_title), T0("FA_BuildSmartDoorbell", R.string.scene_build_smart_doorbell_title));
        return g;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    @Override // com.tplink.iot.devices.featuredactions.adapter.a
    public void q0(com.tplink.iot.g.a.a.a item) {
        j.e(item, "item");
        String a2 = item.a();
        switch (a2.hashCode()) {
            case -2046614428:
                if (a2.equals("FA_AdjustBrightness")) {
                    FragmentKt.findNavController(this).navigate(R.id.action_buttonFeaturedActionChooseFragment_to_buttonFAAdjustBrightnessFragment, V0());
                    return;
                }
                return;
            case -1791188381:
                if (a2.equals("FA_TurnOnOffSmartDevices")) {
                    FragmentKt.findNavController(this).navigate(R.id.action_buttonFeaturedActionChooseFragment_to_buttonFATurnOnOffDeviceFragment, V0());
                    return;
                }
                return;
            case 275394800:
                if (a2.equals("FA_BuildSmartDoorbell")) {
                    FragmentKt.findNavController(this).navigate(R.id.action_buttonFeaturedActionChooseFragment_to_buttonFABuildSmartDoorbellFragment, V0());
                    return;
                }
                return;
            case 394014692:
                if (a2.equals("FA_AdjustColorTemperature")) {
                    FragmentKt.findNavController(this).navigate(R.id.action_buttonFeaturedActionChooseFragment_to_buttonFAAdjustColorTemperatureFragment, V0());
                    return;
                }
                return;
            case 1978741269:
                if (a2.equals("FA_SetRightMood")) {
                    FragmentKt.findNavController(this).navigate(R.id.action_buttonFeaturedActionChooseFragment_to_buttonFADifferentLightAtmospheresFragment, V0());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
