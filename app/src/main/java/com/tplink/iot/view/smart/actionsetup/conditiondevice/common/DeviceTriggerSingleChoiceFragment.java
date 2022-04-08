package com.tplink.iot.view.smart.actionsetup.conditiondevice.common;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tplink.iot.R;
import com.tplink.iot.adapter.smart.DeviceTriggerSingleChoiceAdapter;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTriggerState;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTriggerStateValue;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.cloud.enumerate.StateOperator;
import com.tplink.iot.cloud.enumerate.StateValueDataType;
import com.tplink.iot.databinding.FragmentDeviceTriggerSingleChoiceBinding;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerBaseFragment;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerContainerFragment;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DoubleClickInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumRotateDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: DeviceTriggerSingleChoiceFragment.kt */
/* loaded from: classes2.dex */
public final class DeviceTriggerSingleChoiceFragment extends DeviceTriggerBaseFragment<FragmentDeviceTriggerSingleChoiceBinding> {
    public static final a H3 = new a(null);
    private DeviceTriggerSingleChoiceAdapter I3;
    private HashMap J3;

    /* compiled from: DeviceTriggerSingleChoiceFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final DeviceTriggerSingleChoiceFragment a(String deviceIdMD5) {
            j.e(deviceIdMD5, "deviceIdMD5");
            DeviceTriggerSingleChoiceFragment deviceTriggerSingleChoiceFragment = new DeviceTriggerSingleChoiceFragment();
            deviceTriggerSingleChoiceFragment.P0(deviceIdMD5);
            return deviceTriggerSingleChoiceFragment;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final void Y0(List<com.tplink.iot.model.smart.a> list, String str, String str2, Object obj, boolean z, String str3) {
        if (U0().n(str)) {
            list.add(new com.tplink.iot.model.smart.a(str, str2, obj, z, str3));
        }
    }

    static /* synthetic */ void Z0(DeviceTriggerSingleChoiceFragment deviceTriggerSingleChoiceFragment, List list, String str, String str2, Object obj, boolean z, String str3, int i, Object obj2) {
        deviceTriggerSingleChoiceFragment.Y0(list, str, str2, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? true : z, (i & 32) != 0 ? null : str3);
    }

    private final SmartThingTriggerState a1(boolean z) {
        SmartThingTriggerState smartThingTriggerState = new SmartThingTriggerState();
        smartThingTriggerState.setValue(new SmartThingTriggerStateValue("0"));
        smartThingTriggerState.setDataType(StateValueDataType.INT);
        smartThingTriggerState.setKey(ThingModelDefine.Event.UPLOAD_PARAMS_ROTATE_DEG);
        smartThingTriggerState.setOp(z ? StateOperator.GT : StateOperator.LT);
        return smartThingTriggerState;
    }

    private final List<com.tplink.iot.model.smart.a> b1() {
        ArrayList arrayList = new ArrayList();
        String string = getString(R.string.smart_trigger_alarm_triggered);
        j.d(string, "getString(R.string.smart_trigger_alarm_triggered)");
        Z0(this, arrayList, "alarm", string, null, false, null, 56, null);
        String string2 = getString(R.string.smart_trigger_motion_detected);
        j.d(string2, "getString(R.string.smart_trigger_motion_detected)");
        Z0(this, arrayList, "motion", string2, null, false, null, 56, null);
        String string3 = getString(R.string.smart_trigger_open);
        j.d(string3, "getString(R.string.smart_trigger_open)");
        Z0(this, arrayList, "open", string3, null, false, null, 56, null);
        String string4 = getString(R.string.smart_trigger_close);
        j.d(string4, "getString(R.string.smart_trigger_close)");
        Z0(this, arrayList, "close", string4, null, false, null, 56, null);
        String string5 = getString(R.string.smart_trigger_keep_open_one_minute_v2);
        j.d(string5, "getString(R.string.smart…_keep_open_one_minute_v2)");
        Z0(this, arrayList, "keepOpen", string5, null, false, null, 56, null);
        String string6 = getString(R.string.smart_trigger_single_tap);
        j.d(string6, "getString(R.string.smart_trigger_single_tap)");
        Z0(this, arrayList, "singleClick", string6, null, false, null, 56, null);
        boolean c1 = c1();
        String string7 = getString(R.string.smart_trigger_double_tap);
        j.d(string7, "getString(R.string.smart_trigger_double_tap)");
        Z0(this, arrayList, "doubleClick", string7, null, c1, !c1 ? getString(R.string.smart_action_double_click_disabled) : null, 8, null);
        String string8 = getString(R.string.smart_trigger_rotate_clockwise);
        j.d(string8, "getString(R.string.smart_trigger_rotate_clockwise)");
        Z0(this, arrayList, "rotation", string8, EnumRotateDirection.CLOCKWISE, false, null, 48, null);
        String string9 = getString(R.string.smart_trigger_rotate_anticlockwise);
        j.d(string9, "getString(R.string.smart…ger_rotate_anticlockwise)");
        Z0(this, arrayList, "rotation", string9, EnumRotateDirection.ANTICLOCKWISE, false, null, 48, null);
        return arrayList;
    }

    private final boolean c1() {
        if (U0().h() != EnumDeviceType.SWITCH) {
            return true;
        }
        SwitchRepository switchRepository = (SwitchRepository) e.d(K0(), SwitchRepository.class);
        StringBuilder sb = new StringBuilder();
        sb.append("isDoubleClickEventEnabled: ");
        DoubleClickInfoBean value = switchRepository.n4().getValue();
        sb.append(value != null ? Boolean.valueOf(value.getEnable()) : null);
        b.d.w.c.a.n("Smart", sb.toString());
        DoubleClickInfoBean value2 = switchRepository.n4().getValue();
        if (value2 != null) {
            return value2.getEnable();
        }
        return true;
    }

    @Override // com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerBaseFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.J3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public int I0() {
        return R.layout.fragment_device_trigger_single_choice;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void N0() {
        RecyclerView recyclerView = ((FragmentDeviceTriggerSingleChoiceBinding) J0()).f6999c;
        j.d(recyclerView, "mBinding.rvDeviceTrigger");
        Context requireContext = requireContext();
        j.d(requireContext, "requireContext()");
        DeviceTriggerSingleChoiceAdapter deviceTriggerSingleChoiceAdapter = new DeviceTriggerSingleChoiceAdapter(requireContext, b1());
        this.I3 = deviceTriggerSingleChoiceAdapter;
        DeviceTriggerContainerFragment V0 = V0();
        if (V0 != null) {
            V0.c1(deviceTriggerSingleChoiceAdapter.getItemCount() > 0);
        }
        p pVar = p.a;
        recyclerView.setAdapter(deviceTriggerSingleChoiceAdapter);
        RecyclerView recyclerView2 = ((FragmentDeviceTriggerSingleChoiceBinding) J0()).f6999c;
        j.d(recyclerView2, "mBinding.rvDeviceTrigger");
        RecyclerView.ItemAnimator itemAnimator = recyclerView2.getItemAnimator();
        if (!(itemAnimator instanceof SimpleItemAnimator)) {
            itemAnimator = null;
        }
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
    }

    @Override // com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerBaseFragment
    public void T0(SmartThingTrigger thingTrigger) {
        com.tplink.iot.model.smart.a u;
        List<SmartThingTriggerState> b2;
        j.e(thingTrigger, "thingTrigger");
        DeviceTriggerSingleChoiceAdapter deviceTriggerSingleChoiceAdapter = this.I3;
        if (deviceTriggerSingleChoiceAdapter != null && (u = deviceTriggerSingleChoiceAdapter.u()) != null) {
            ThingEventParams thingEventParams = new ThingEventParams();
            thingEventParams.setName(u.d());
            String d2 = u.d();
            if (d2.hashCode() == -40300674 && d2.equals("rotation")) {
                b2 = m.b(a1(u.a() != EnumRotateDirection.ANTICLOCKWISE));
                thingEventParams.setParamList(b2);
            }
            thingTrigger.setEvent(thingEventParams);
        }
    }

    @Override // com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerBaseFragment
    protected void W0(SmartThingTrigger smartThingTrigger) {
        if (smartThingTrigger != null && smartThingTrigger.getEvent() != null) {
            ThingEventParams event = smartThingTrigger.getEvent();
            j.d(event, "thingTrigger.event");
            String name = event.getName();
            EnumRotateDirection a2 = (name != null && name.hashCode() == -40300674 && name.equals("rotation")) ? com.tplink.iot.view.smart.a.f.a(smartThingTrigger) : null;
            DeviceTriggerSingleChoiceAdapter deviceTriggerSingleChoiceAdapter = this.I3;
            if (deviceTriggerSingleChoiceAdapter != null) {
                ThingEventParams event2 = smartThingTrigger.getEvent();
                j.d(event2, "thingTrigger.event");
                String name2 = event2.getName();
                j.d(name2, "thingTrigger.event.name");
                deviceTriggerSingleChoiceAdapter.B(name2, a2);
            }
        }
    }

    @Override // com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerBaseFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }
}
