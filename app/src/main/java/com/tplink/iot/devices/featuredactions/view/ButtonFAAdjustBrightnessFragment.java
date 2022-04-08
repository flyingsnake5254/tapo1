package com.tplink.iot.devices.featuredactions.view;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment;
import com.tplink.iot.devices.featuredactions.viewmodel.ButtonFeaturedActionViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.j;

/* compiled from: ButtonFeaturedActionFragments.kt */
/* loaded from: classes2.dex */
public final class ButtonFAAdjustBrightnessFragment extends AbstractFeaturedActionFragment<ButtonFeaturedActionViewModel> {
    private HashMap K3;

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.K3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public boolean W0(BaseALIoTDevice<?> device) {
        j.e(device, "device");
        ThingModel x = b1().x(device);
        return x != null && device.isSupportIoTCloud() && u1(x, ThingModelDefine.Service.SERVICE_INCREASE_BRIGHTNESS) && u1(x, ThingModelDefine.Service.SERVICE_DECREASE_BRIGHTNESS);
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public String a1() {
        String string = getString(R.string.scene_control_light_brightness_desc);
        j.d(string, "getString(R.string.scene…ol_light_brightness_desc)");
        return string;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public int c1() {
        return R.mipmap.scene_control_light_brightness;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public List<EnumIoTCategory> d1() {
        List<EnumIoTCategory> g;
        g = n.g(EnumIoTCategory.LIGHT, EnumIoTCategory.LIGHT_STRIP);
        return g;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public String f1() {
        String string = getString(R.string.scene_control_light_brightness_title);
        j.d(string, "getString(R.string.scene…l_light_brightness_title)");
        return string;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public SmartInfo[] n1(List<? extends BaseALIoTDevice<?>> selectedDevices) {
        j.e(selectedDevices, "selectedDevices");
        return b1().J(f1(), selectedDevices);
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    /* renamed from: w1 */
    public ButtonFeaturedActionViewModel g1() {
        ViewModel viewModel = new ViewModelProvider(requireActivity(), new IoTViewModelFactory(requireActivity(), K0())).get(ButtonFeaturedActionViewModel.class);
        j.d(viewModel, "ViewModelProvider(requir…).get<VM>(VM::class.java)");
        return (ButtonFeaturedActionViewModel) ((AndroidViewModel) viewModel);
    }
}
