package com.tplink.iot.devices.featuredactions.view;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment;
import com.tplink.iot.devices.featuredactions.viewmodel.ContactSensorFeaturedActionViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.j;

/* compiled from: ContactSensorFeaturedActionFragments.kt */
/* loaded from: classes2.dex */
public final class ContactSensorFALightWayWhenArrivingHomeFragment extends AbstractFeaturedActionFragment<ContactSensorFeaturedActionViewModel> {
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
        return x != null && device.isSupportIoTCloud() && t1(x, "on");
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public String a1() {
        String string = getString(R.string.scene_light_way_when_arriving_home_desc);
        j.d(string, "getString(R.string.scene…_when_arriving_home_desc)");
        return string;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public int c1() {
        return R.mipmap.scene_light_way_when_arriving_home;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public List<EnumIoTCategory> d1() {
        List<EnumIoTCategory> g;
        g = n.g(EnumIoTCategory.LIGHT, EnumIoTCategory.LIGHT_STRIP, EnumIoTCategory.PLUG, EnumIoTCategory.SUBG_PLUGSWITCH_SWITCH);
        return g;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public String f1() {
        String string = getString(R.string.scene_light_way_when_arriving_home_title);
        j.d(string, "getString(R.string.scene…when_arriving_home_title)");
        return string;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public SmartInfo[] n1(List<? extends BaseALIoTDevice<?>> selectedDevices) {
        j.e(selectedDevices, "selectedDevices");
        return new SmartInfo[]{b1().K(f1(), selectedDevices)};
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    /* renamed from: w1 */
    public ContactSensorFeaturedActionViewModel g1() {
        ViewModel viewModel = new ViewModelProvider(requireActivity(), new IoTViewModelFactory(requireActivity(), K0())).get(ContactSensorFeaturedActionViewModel.class);
        j.d(viewModel, "ViewModelProvider(requir…).get<VM>(VM::class.java)");
        return (ContactSensorFeaturedActionViewModel) ((AndroidViewModel) viewModel);
    }
}
