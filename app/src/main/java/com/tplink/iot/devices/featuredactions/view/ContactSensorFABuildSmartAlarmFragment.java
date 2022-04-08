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
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.internal.j;

/* compiled from: ContactSensorFeaturedActionFragments.kt */
/* loaded from: classes2.dex */
public final class ContactSensorFABuildSmartAlarmFragment extends AbstractFeaturedActionFragment<ContactSensorFeaturedActionViewModel> {
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
        if (x == null) {
            return false;
        }
        b1().M(device);
        return device.isSupportIoTCloud() && u1(x, ThingModelDefine.Service.SERVICE_RING);
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public String a1() {
        String string = getString(R.string.scene_build_smart_alarm_contact_sensor_desc);
        j.d(string, "getString(R.string.scene…larm_contact_sensor_desc)");
        return string;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public int c1() {
        return R.mipmap.scene_build_smart_alarm_t110;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public List<EnumIoTCategory> d1() {
        List<EnumIoTCategory> b2;
        b2 = m.b(EnumIoTCategory.HUB);
        return b2;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public String f1() {
        String string = getString(R.string.scene_build_smart_alarm_title);
        j.d(string, "getString(R.string.scene_build_smart_alarm_title)");
        return string;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment
    public SmartInfo[] n1(List<? extends BaseALIoTDevice<?>> selectedDevices) {
        j.e(selectedDevices, "selectedDevices");
        return new SmartInfo[]{b1().J(f1(), selectedDevices)};
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
