package com.tplink.iot.view.smart.actionsetup.conditiondevice;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.databinding.FragmentDeviceTriggerContainerBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.view.smart.actionsetup.ActionDetailActivity;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.camera.CameraTriggerFragment;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.common.DeviceTriggerSingleChoiceFragment;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.dut.ThermostatTriggerFragment;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: DeviceTriggerContainerFragment.kt */
/* loaded from: classes2.dex */
public final class DeviceTriggerContainerFragment extends IoTMVVMBaseFragment<FragmentDeviceTriggerContainerBinding> implements Toolbar.OnMenuItemClickListener {
    private a H3;
    private final f I3;
    private final f J3;
    private MenuItem K3;
    private String L3 = "";
    private DeviceTriggerBaseFragment<?> M3;
    private HashMap N3;
    private ActionDetailActivity p1;
    private final f p2;
    private BaseALIoTDevice<?> p3;

    /* compiled from: DeviceTriggerContainerFragment.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* compiled from: DeviceTriggerContainerFragment.kt */
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DeviceTriggerContainerFragment.this.d();
        }
    }

    /* compiled from: DeviceTriggerContainerFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<ActionSetupViewModel> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final ActionSetupViewModel invoke() {
            ViewModel viewModel = new ViewModelProvider(DeviceTriggerContainerFragment.S0(DeviceTriggerContainerFragment.this)).get(ActionSetupViewModel.class);
            j.d(viewModel, "ViewModelProvider(mActiv…tupViewModel::class.java)");
            return (ActionSetupViewModel) viewModel;
        }
    }

    /* compiled from: DeviceTriggerContainerFragment.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements kotlin.jvm.b.a<Toolbar> {
        d() {
            super(0);
        }

        /* renamed from: a */
        public final Toolbar invoke() {
            return (Toolbar) DeviceTriggerContainerFragment.T0(DeviceTriggerContainerFragment.this).getRoot().findViewById(R.id.toolbar);
        }
    }

    /* compiled from: DeviceTriggerContainerFragment.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements kotlin.jvm.b.a<TextView> {
        e() {
            super(0);
        }

        /* renamed from: a */
        public final TextView invoke() {
            return (TextView) DeviceTriggerContainerFragment.T0(DeviceTriggerContainerFragment.this).getRoot().findViewById(R.id.toolbar_title);
        }
    }

    public DeviceTriggerContainerFragment() {
        f b2;
        f b3;
        f b4;
        b2 = i.b(new c());
        this.p2 = b2;
        b3 = i.b(new d());
        this.I3 = b3;
        b4 = i.b(new e());
        this.J3 = b4;
    }

    public static final /* synthetic */ ActionDetailActivity S0(DeviceTriggerContainerFragment deviceTriggerContainerFragment) {
        ActionDetailActivity actionDetailActivity = deviceTriggerContainerFragment.p1;
        if (actionDetailActivity == null) {
            j.t("mActivity");
        }
        return actionDetailActivity;
    }

    public static final /* synthetic */ FragmentDeviceTriggerContainerBinding T0(DeviceTriggerContainerFragment deviceTriggerContainerFragment) {
        return deviceTriggerContainerFragment.J0();
    }

    private final void U0(BaseALIoTDevice<?> baseALIoTDevice) {
        if (baseALIoTDevice.isHub() || baseALIoTDevice.isSensor() || baseALIoTDevice.isSwitch()) {
            this.M3 = DeviceTriggerSingleChoiceFragment.H3.a(K0());
        } else if (baseALIoTDevice.isCamera()) {
            this.M3 = CameraTriggerFragment.H3.a(K0());
        } else if (com.tplink.iot.g.d.a.b.k(baseALIoTDevice)) {
            this.M3 = ThermostatTriggerFragment.J3.a(K0());
        }
        DeviceTriggerBaseFragment<?> deviceTriggerBaseFragment = this.M3;
        if (deviceTriggerBaseFragment != null) {
            getChildFragmentManager().beginTransaction().add(R.id.fragment_container, deviceTriggerBaseFragment, "SubFragment").commit();
        }
    }

    private final ActionSetupViewModel W0() {
        return (ActionSetupViewModel) this.p2.getValue();
    }

    private final Toolbar X0() {
        return (Toolbar) this.I3.getValue();
    }

    private final TextView Y0() {
        return (TextView) this.J3.getValue();
    }

    private final void Z0(BaseALIoTDevice<?> baseALIoTDevice) {
        SmartTrigger triggerSetting;
        List<SmartThingTrigger> things;
        Object obj;
        DeviceTriggerBaseFragment<?> deviceTriggerBaseFragment;
        SmartInfo v = W0().v();
        if (v != null && (triggerSetting = v.getTriggerSetting()) != null && (things = triggerSetting.getThings()) != null) {
            Iterator<T> it = things.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                SmartThingTrigger it2 = (SmartThingTrigger) obj;
                j.d(it2, "it");
                if (j.a(it2.getThingName(), baseALIoTDevice.getDeviceId())) {
                    break;
                }
            }
            SmartThingTrigger smartThingTrigger = (SmartThingTrigger) obj;
            if (smartThingTrigger != null && (deviceTriggerBaseFragment = this.M3) != null) {
                deviceTriggerBaseFragment.X0(smartThingTrigger);
            }
        }
    }

    private final void a1() {
        BaseALIoTDevice<?> baseALIoTDevice = this.p3;
        if (baseALIoTDevice != null) {
            SmartThingTrigger smartThingTrigger = new SmartThingTrigger();
            smartThingTrigger.setThingName(baseALIoTDevice.getDeviceId());
            ThingInfo n = W0().n(baseALIoTDevice.getDeviceId());
            if (n != null) {
                smartThingTrigger.setNickname(n.getNickname());
                smartThingTrigger.setAvatarUrl(n.getAvatarUrl());
                smartThingTrigger.setSubThing(n.isSubThing());
                smartThingTrigger.setCategory(n.getCategory());
            }
            DeviceTriggerBaseFragment<?> deviceTriggerBaseFragment = this.M3;
            if (deviceTriggerBaseFragment != null) {
                deviceTriggerBaseFragment.T0(smartThingTrigger);
            }
            SmartInfo v = W0().v();
            j.d(v, "mActionSetupViewModel.cachedSmartInfo");
            SmartTrigger triggerSetting = v.getTriggerSetting();
            if (triggerSetting == null) {
                triggerSetting = new SmartTrigger();
            }
            List<SmartThingTrigger> things = triggerSetting.getThings();
            if (things == null) {
                things = new ArrayList<>();
            }
            boolean z = true;
            String deviceId = baseALIoTDevice.getDeviceId();
            for (SmartThingTrigger smartThingTrigger2 : things) {
                if (j.a(deviceId, smartThingTrigger2.getThingName())) {
                    smartThingTrigger2.setStateReported(smartThingTrigger.getStateReported());
                    smartThingTrigger2.setEvent(smartThingTrigger.getEvent());
                    z = false;
                }
            }
            if (z) {
                things.add(0, smartThingTrigger);
            }
            triggerSetting.setThings(things);
            triggerSetting.setManual(false);
            v.setTriggerSetting(triggerSetting);
            W0().p0(v);
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.N3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public int I0() {
        return R.layout.fragment_device_trigger_container;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void N0() {
        ActionDetailActivity actionDetailActivity = this.p1;
        if (actionDetailActivity == null) {
            j.t("mActivity");
        }
        com.tplink.iot.view.quicksetup.base.d.J(actionDetailActivity, X0());
        setHasOptionsMenu(true);
        BaseALIoTDevice<?> t = W0().t();
        this.p3 = t;
        if (t == null) {
            B0();
        } else if (t != null) {
            String deviceIdMD5 = t.getDeviceIdMD5();
            j.d(deviceIdMD5, "device.deviceIdMD5");
            Q0(deviceIdMD5);
            Toolbar X0 = X0();
            X0.inflateMenu(R.menu.menu_done);
            X0.setOnMenuItemClickListener(this);
            X0.setNavigationOnClickListener(new b());
            this.K3 = X0.getMenu().findItem(R.id.action_done);
            TextView Y0 = Y0();
            ActionDetailActivity actionDetailActivity2 = this.p1;
            if (actionDetailActivity2 == null) {
                j.t("mActivity");
            }
            String it = l.e(actionDetailActivity2, t.getDeviceType(), t.getDeviceName(), t.getDeviceModel());
            j.d(it, "it");
            this.L3 = it;
            p pVar = p.a;
            Y0.setText(it);
            U0(t);
            Z0(t);
        }
    }

    public final BaseALIoTDevice<?> V0() {
        return this.p3;
    }

    public final void b1(a aVar) {
        this.H3 = aVar;
    }

    public final void c1(boolean z) {
        MenuItem menuItem = this.K3;
        if (menuItem != null) {
            menuItem.setEnabled(z);
        }
    }

    @Override // com.tplink.iot.base.BaseFragment, com.tplink.iot.i.a
    public boolean d() {
        DeviceTriggerBaseFragment<?> deviceTriggerBaseFragment = this.M3;
        if (deviceTriggerBaseFragment != null ? deviceTriggerBaseFragment.d() : false) {
            return true;
        }
        getParentFragmentManager().popBackStackImmediate();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        j.e(context, "context");
        super.onAttach(context);
        if (!(context instanceof ActionDetailActivity)) {
            B0();
        } else {
            this.p1 = (ActionDetailActivity) context;
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != R.id.action_done || this.H3 == null) {
            return true;
        }
        a1();
        a aVar = this.H3;
        if (aVar == null) {
            return true;
        }
        aVar.a();
        return true;
    }
}
