package com.tplink.iot.view.smart.actionsetup.taskdevice.hub;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.google.gson.k;
import com.tplink.iot.R;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTypeAdapter;
import com.tplink.iot.adapter.iothub.GuardModeAlarmVolumeAdapter;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.databinding.FragmentTaskHubControlBinding;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkViewHolder;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlContainerFragment;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: TaskHubControlFragment.kt */
/* loaded from: classes2.dex */
public final class TaskHubControlFragment extends DeviceControlBaseFragment<FragmentTaskHubControlBinding> implements View.OnClickListener {
    public static final a H3 = new a(null);
    private final f I3;
    private b J3;
    private HashMap K3;

    /* compiled from: TaskHubControlFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final TaskHubControlFragment a(String deviceIdMD5) {
            j.e(deviceIdMD5, "deviceIdMD5");
            TaskHubControlFragment taskHubControlFragment = new TaskHubControlFragment();
            taskHubControlFragment.P0(deviceIdMD5);
            return taskHubControlFragment;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: TaskHubControlFragment.kt */
    /* loaded from: classes2.dex */
    private final class b extends SingleCheckMarkAdapter<Pair<? extends String, ? extends Integer>> {
        final /* synthetic */ TaskHubControlFragment g;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(com.tplink.iot.view.smart.actionsetup.taskdevice.hub.TaskHubControlFragment r2, java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> r3) {
            /*
                r1 = this;
                java.lang.String r0 = "actionList"
                kotlin.jvm.internal.j.e(r3, r0)
                r1.g = r2
                android.content.Context r2 = r2.requireContext()
                java.lang.String r0 = "requireContext()"
                kotlin.jvm.internal.j.d(r2, r0)
                r0 = 0
                r1.<init>(r2, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.view.smart.actionsetup.taskdevice.hub.TaskHubControlFragment.b.<init>(com.tplink.iot.view.smart.actionsetup.taskdevice.hub.TaskHubControlFragment, java.util.List):void");
        }

        /* renamed from: A */
        public void n(SingleCheckMarkViewHolder holder, Pair<String, Integer> data, int i) {
            j.e(holder, "holder");
            j.e(data, "data");
            holder.d().setText(data.getFirst());
        }

        public final void B(int i) {
            Iterator<Pair<? extends String, ? extends Integer>> it = q().iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (((Number) it.next().getSecond()).intValue() == i) {
                    break;
                }
                i2++;
            }
            z(i2);
        }
    }

    /* compiled from: TaskHubControlFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements q<Pair<? extends String, ? extends Integer>, Integer, Boolean, p> {
        c() {
            super(3);
        }

        public final void a(Pair<String, Integer> data, int i, boolean z) {
            j.e(data, "data");
            LinearLayout linearLayout = TaskHubControlFragment.Y0(TaskHubControlFragment.this).p0;
            j.d(linearLayout, "mBinding.llAlarmConfig");
            int i2 = 0;
            if (!(data.getSecond().intValue() == 4)) {
                i2 = 8;
            }
            linearLayout.setVisibility(i2);
        }

        @Override // kotlin.jvm.b.q
        public /* bridge */ /* synthetic */ p invoke(Pair<? extends String, ? extends Integer> pair, Integer num, Boolean bool) {
            a(pair, num.intValue(), bool.booleanValue());
            return p.a;
        }
    }

    /* compiled from: TaskHubControlFragment.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements kotlin.jvm.b.a<TaskHubControlViewModel> {
        d() {
            super(0);
        }

        /* renamed from: a */
        public final TaskHubControlViewModel invoke() {
            TaskHubControlFragment taskHubControlFragment = TaskHubControlFragment.this;
            ViewModel viewModel = new ViewModelProvider(taskHubControlFragment, new IoTViewModelFactory(taskHubControlFragment, taskHubControlFragment.K0())).get(TaskHubControlViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (TaskHubControlViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* compiled from: TaskHubControlFragment.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements Observer<GuardModeConfigBean> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(GuardModeConfigBean guardModeConfigBean) {
            if (guardModeConfigBean != null) {
                TaskHubControlFragment.this.g1(guardModeConfigBean);
            }
        }
    }

    public TaskHubControlFragment() {
        f b2;
        b2 = i.b(new d());
        this.I3 = b2;
    }

    public static final /* synthetic */ FragmentTaskHubControlBinding Y0(TaskHubControlFragment taskHubControlFragment) {
        return (FragmentTaskHubControlBinding) taskHubControlFragment.J0();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0074 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> b1() {
        /*
            r7 = this;
            com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlContainerFragment r0 = r7.V0()
            r1 = 0
            if (r0 == 0) goto L_0x0012
            com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice r0 = r0.W0()
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r0.getDeviceId()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0076
            com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlContainerFragment r4 = r7.V0()
            if (r4 == 0) goto L_0x0076
            com.tplink.iot.viewmodel.smart.ActionSetupViewModel r4 = r4.V0()
            if (r4 == 0) goto L_0x0076
            com.tplink.iot.cloud.bean.smart.common.SmartInfo r4 = r4.v()
            if (r4 == 0) goto L_0x0076
            com.tplink.iot.cloud.bean.smart.common.SmartTrigger r4 = r4.getTriggerSetting()
            if (r4 == 0) goto L_0x0076
            java.util.List r4 = r4.getThings()
            if (r4 == 0) goto L_0x0076
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x003c
            goto L_0x0076
        L_0x003c:
            java.util.Iterator r4 = r4.iterator()
        L_0x0040:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0076
            java.lang.Object r5 = r4.next()
            com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger r5 = (com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger) r5
            java.lang.String r6 = "it"
            kotlin.jvm.internal.j.d(r5, r6)
            java.lang.String r6 = r5.getThingName()
            boolean r6 = kotlin.jvm.internal.j.a(r6, r0)
            if (r6 == 0) goto L_0x0071
            com.tplink.iot.cloud.bean.thing.params.ThingEventParams r5 = r5.getEvent()
            if (r5 == 0) goto L_0x0066
            java.lang.String r5 = r5.getName()
            goto L_0x0067
        L_0x0066:
            r5 = r1
        L_0x0067:
            java.lang.String r6 = "alarm"
            boolean r5 = kotlin.jvm.internal.j.a(r5, r6)
            if (r5 == 0) goto L_0x0071
            r5 = 1
            goto L_0x0072
        L_0x0071:
            r5 = 0
        L_0x0072:
            if (r5 == 0) goto L_0x0040
            r0 = 1
            goto L_0x0077
        L_0x0076:
            r0 = 0
        L_0x0077:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel r4 = r7.d1()
            boolean r4 = r4.o()
            if (r4 == 0) goto L_0x00b4
            com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel r4 = r7.d1()
            boolean r4 = r4.p()
            if (r4 == 0) goto L_0x00b4
            r4 = 2131954019(0x7f130963, float:1.9544525E38)
            java.lang.String r4 = r7.getString(r4)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            kotlin.Pair r3 = kotlin.n.a(r4, r3)
            r1.add(r3)
            r3 = 2131954015(0x7f13095f, float:1.9544517E38)
            java.lang.String r3 = r7.getString(r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            kotlin.Pair r2 = kotlin.n.a(r3, r2)
            r1.add(r2)
        L_0x00b4:
            com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel r2 = r7.d1()
            boolean r2 = r2.p()
            if (r2 == 0) goto L_0x00d1
            r2 = 2131952795(0x7f13049b, float:1.9542043E38)
            java.lang.String r2 = r7.getString(r2)
            r3 = 3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            kotlin.Pair r2 = kotlin.n.a(r2, r3)
            r1.add(r2)
        L_0x00d1:
            if (r0 != 0) goto L_0x00f0
            com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel r0 = r7.d1()
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x00f0
            r0 = 2131954009(0x7f130959, float:1.9544505E38)
            java.lang.String r0 = r7.getString(r0)
            r2 = 4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            kotlin.Pair r0 = kotlin.n.a(r0, r2)
            r1.add(r0)
        L_0x00f0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.view.smart.actionsetup.taskdevice.hub.TaskHubControlFragment.b1():java.util.List");
    }

    private final String c1(GuardModeAlarmTimeBean guardModeAlarmTimeBean) {
        int i = b.a[guardModeAlarmTimeBean.getEnumType().ordinal()];
        if (i == 1) {
            String string = getResources().getString(R.string.gm_alarm_time_always);
            j.d(string, "resources.getString(R.string.gm_alarm_time_always)");
            return string;
        } else if (i == 2) {
            GuardModeAlarmTimeAdapter.b bVar = GuardModeAlarmTimeAdapter.k;
            Context requireContext = requireContext();
            j.d(requireContext, "requireContext()");
            return bVar.c(requireContext, guardModeAlarmTimeBean.getTime());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final TaskHubControlViewModel d1() {
        return (TaskHubControlViewModel) this.I3.getValue();
    }

    private final void e1(IoTMVVMBaseFragment<?> ioTMVVMBaseFragment) {
        ioTMVVMBaseFragment.P0(K0());
        getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.push_in_from_right, R.anim.push_out_to_left, R.anim.push_in_from_left, R.anim.push_out_to_right).replace(R.id.fragment_container, ioTMVVMBaseFragment).addToBackStack(null).commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(GuardModeConfigBean guardModeConfigBean) {
        TextView textView = ((FragmentTaskHubControlBinding) J0()).p3;
        j.d(textView, "mBinding.tvAlarmType");
        textView.setText(GuardModeAlarmTypeAdapter.g.a(guardModeConfigBean.getAlarmType()));
        ((FragmentTaskHubControlBinding) J0()).H3.setText(GuardModeAlarmVolumeAdapter.h.a(guardModeConfigBean.getEnumAlarmVolume()));
        TextView textView2 = ((FragmentTaskHubControlBinding) J0()).p2;
        j.d(textView2, "mBinding.tvAlarmTime");
        textView2.setText(c1(guardModeConfigBean.getAlarmTime()));
    }

    @Override // com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.K3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public int I0() {
        return R.layout.fragment_task_hub_control;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void N0() {
        List<Pair<String, Integer>> b1 = b1();
        RecyclerView recyclerView = ((FragmentTaskHubControlBinding) J0()).p1;
        j.d(recyclerView, "mBinding.rvDeviceAction");
        b bVar = new b(this, b1);
        bVar.y(new c());
        p pVar = p.a;
        this.J3 = bVar;
        recyclerView.setAdapter(bVar);
        RecyclerView recyclerView2 = ((FragmentTaskHubControlBinding) J0()).p1;
        j.d(recyclerView2, "mBinding.rvDeviceAction");
        RecyclerView.ItemAnimator itemAnimator = recyclerView2.getItemAnimator();
        if (!(itemAnimator instanceof SimpleItemAnimator)) {
            itemAnimator = null;
        }
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        ((FragmentTaskHubControlBinding) J0()).x.setOnClickListener(this);
        ((FragmentTaskHubControlBinding) J0()).y.setOnClickListener(this);
        ((FragmentTaskHubControlBinding) J0()).q.setOnClickListener(this);
        d1().m();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void R0() {
        d1().i().observe(getViewLifecycleOwner(), new e());
    }

    @Override // com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment
    public void T0(SmartThingAction thingAction) {
        Pair<? extends String, ? extends Integer> t;
        j.e(thingAction, "thingAction");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        thingAction.setStateDesired(linkedHashMap);
        b bVar = this.J3;
        Integer num = (bVar == null || (t = bVar.t()) == null) ? null : (Integer) t.getSecond();
        if (num != null && num.intValue() == 0) {
            linkedHashMap.put("guard_mode", EnumGuardMode.HOME.getValue());
            linkedHashMap.put(ThingModelDefine.Property.PROPERTY_GUARD_ON, Boolean.TRUE);
        } else if (num != null && num.intValue() == 1) {
            linkedHashMap.put("guard_mode", EnumGuardMode.AWAY.getValue());
            linkedHashMap.put(ThingModelDefine.Property.PROPERTY_GUARD_ON, Boolean.TRUE);
        } else if (num != null && num.intValue() == 2) {
            linkedHashMap.put("guard_mode", EnumGuardMode.SLEEP.getValue());
            linkedHashMap.put(ThingModelDefine.Property.PROPERTY_GUARD_ON, Boolean.TRUE);
        } else if (num != null && num.intValue() == 3) {
            linkedHashMap.put(ThingModelDefine.Property.PROPERTY_GUARD_ON, Boolean.FALSE);
        } else if (num != null && num.intValue() == 4) {
            thingAction.setStateDesired(null);
            thingAction.setService(new ThingServiceParams(ThingModelDefine.Service.SERVICE_RING, d1().h()));
        }
    }

    @Override // com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment
    protected void W0(SmartThingAction smartThingAction) {
        k c2;
        b bVar;
        if (smartThingAction != null) {
            Object obj = null;
            if (smartThingAction.getStateDesired() != null) {
                Map<String, Object> stateDesired = smartThingAction.getStateDesired();
                j.d(stateDesired, "thingAction.stateDesired");
                Object obj2 = stateDesired.get(ThingModelDefine.Property.PROPERTY_GUARD_ON);
                if (obj2 instanceof Boolean) {
                    obj = obj2;
                }
                if (j.a((Boolean) obj, Boolean.TRUE)) {
                    Object obj3 = stateDesired.get("guard_mode");
                    if (j.a(obj3, EnumGuardMode.HOME.getValue())) {
                        b bVar2 = this.J3;
                        if (bVar2 != null) {
                            bVar2.B(0);
                        }
                    } else if (j.a(obj3, EnumGuardMode.AWAY.getValue())) {
                        b bVar3 = this.J3;
                        if (bVar3 != null) {
                            bVar3.B(1);
                        }
                    } else if (j.a(obj3, EnumGuardMode.SLEEP.getValue()) && (bVar = this.J3) != null) {
                        bVar.B(2);
                    }
                } else {
                    b bVar4 = this.J3;
                    if (bVar4 != null) {
                        bVar4.B(3);
                    }
                }
            } else if (smartThingAction.getService() != null) {
                ThingServiceParams service = smartThingAction.getService();
                j.d(service, "thingAction.service");
                if (j.a(ThingModelDefine.Service.SERVICE_RING, service.getServiceId())) {
                    b bVar5 = this.J3;
                    if (bVar5 != null) {
                        bVar5.B(4);
                    }
                    try {
                        ThingServiceParams service2 = smartThingAction.getService();
                        j.d(service2, "thingAction.service");
                        com.google.gson.i inputParams = service2.getInputParams();
                        if (inputParams != null && (c2 = inputParams.c()) != null) {
                            com.google.gson.i n = c2.c().n("type");
                            j.d(n, "config.asJsonObject.get(INPUT_PARAM_TYPE)");
                            String alarmType = n.e();
                            TaskHubControlViewModel d1 = d1();
                            j.d(alarmType, "alarmType");
                            d1.v(alarmType);
                            com.google.gson.i n2 = c2.c().n(ThingModelDefine.Service.INPUT_PARAM_VOLUME);
                            j.d(n2, "config.asJsonObject.get(INPUT_PARAM_VOLUME)");
                            String e2 = n2.e();
                            EnumGuardModeAlarmVolume[] values = EnumGuardModeAlarmVolume.values();
                            int length = values.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    break;
                                }
                                EnumGuardModeAlarmVolume enumGuardModeAlarmVolume = values[i];
                                if (j.a(enumGuardModeAlarmVolume.getValue(), e2)) {
                                    obj = enumGuardModeAlarmVolume;
                                    break;
                                }
                                i++;
                            }
                            if (obj == null) {
                                obj = EnumGuardModeAlarmVolume.HIGH;
                            }
                            d1().w(obj);
                            com.google.gson.i n3 = c2.c().n(ThingModelDefine.Service.INPUT_PARAM_DURATION);
                            j.d(n3, "config.asJsonObject.get(INPUT_PARAM_DURATION)");
                            int a2 = n3.a();
                            if (a2 == 0) {
                                d1().u(EnumGuardModeAlarmTimeType.ALWAYS, 0);
                            } else {
                                d1().u(EnumGuardModeAlarmTimeType.CUSTOM_TIME, a2);
                            }
                        }
                    } catch (Exception unused) {
                        b.d.w.c.a.e("Smart", "Hub SmartAction Service JsonObject error");
                    }
                }
            }
        }
    }

    @Override // com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment, com.tplink.iot.base.BaseFragment, com.tplink.iot.i.a
    public boolean d() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        j.d(childFragmentManager, "childFragmentManager");
        if (childFragmentManager.getBackStackEntryCount() == 0) {
            return false;
        }
        getChildFragmentManager().popBackStackImmediate();
        DeviceControlContainerFragment V0 = V0();
        if (V0 != null) {
            V0.g1();
        }
        DeviceControlContainerFragment V02 = V0();
        if (V02 != null) {
            V02.e1(true);
        }
        return true;
    }

    public final void f1(@StringRes int i) {
        DeviceControlContainerFragment V0 = V0();
        if (V0 != null) {
            V0.e1(false);
        }
        DeviceControlContainerFragment V02 = V0();
        if (V02 != null) {
            V02.f1(getString(i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.config_alarm_type) {
            e1(new TaskHubAlarmTypeFragment());
        } else if (valueOf != null && valueOf.intValue() == R.id.config_alarm_volume) {
            e1(new TaskHubAlarmVolumeFragment());
        } else if (valueOf != null && valueOf.intValue() == R.id.config_alarm_time) {
            e1(new TaskHubAlarmTimeFragment());
        }
    }

    @Override // com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }
}
