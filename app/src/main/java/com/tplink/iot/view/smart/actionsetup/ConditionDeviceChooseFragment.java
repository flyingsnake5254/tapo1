package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.smart.SmartDeviceTriggerAdapter;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.view.smart.b.d;
import com.tplink.iot.view.smart.b.e;
import com.tplink.iot.view.smart.b.f;
import com.tplink.iot.view.smart.b.g;
import com.tplink.iot.view.smart.b.h;
import com.tplink.iot.view.smart.b.i;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.DeviceChooseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.b.l;

/* loaded from: classes2.dex */
public class ConditionDeviceChooseFragment extends BaseFragment implements SmartDeviceTriggerAdapter.b {
    private SmartDeviceTriggerAdapter p0;
    private a p1;
    private View q;
    private ActionDetailActivity x;
    private ActionSetupViewModel y;
    private DeviceChooseViewModel z;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    private List<BaseALIoTDevice> H0(List<BaseALIoTDevice> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            SmartAction actionSetting = this.y.v().getActionSetting();
            final ArrayList arrayList2 = new ArrayList();
            if (!(actionSetting == null || actionSetting.getThings() == null)) {
                arrayList2.addAll(actionSetting.getThings());
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(new e());
            arrayList3.add(new g(new l() { // from class: com.tplink.iot.view.smart.actionsetup.q
                @Override // kotlin.jvm.b.l
                public final Object invoke(Object obj) {
                    return ConditionDeviceChooseFragment.this.L0((BaseALIoTDevice) obj);
                }
            }));
            arrayList3.add(new h());
            arrayList3.add(new i(new kotlin.jvm.b.a() { // from class: com.tplink.iot.view.smart.actionsetup.p
                @Override // kotlin.jvm.b.a
                public final Object invoke() {
                    List list2 = arrayList2;
                    ConditionDeviceChooseFragment.N0(list2);
                    return list2;
                }
            }));
            arrayList3.add(new f());
            for (BaseALIoTDevice<?> baseALIoTDevice : list) {
                boolean z = true;
                Iterator it = arrayList3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((d) it.next()).a(baseALIoTDevice)) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    arrayList.add(baseALIoTDevice);
                }
            }
        }
        return arrayList;
    }

    private void I0() {
        this.y.r().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.smart.actionsetup.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ConditionDeviceChooseFragment.this.P0((List) obj);
            }
        });
    }

    private void J0() {
        ((TextView) this.q.findViewById(R.id.toolbar_title)).setText(R.string.smart_action_add_tasks_control_devices_choose);
        ((Toolbar) this.q.findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.smart.actionsetup.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConditionDeviceChooseFragment.this.R0(view);
            }
        });
        SmartDeviceTriggerAdapter smartDeviceTriggerAdapter = new SmartDeviceTriggerAdapter(this.x);
        this.p0 = smartDeviceTriggerAdapter;
        smartDeviceTriggerAdapter.q(this);
        RecyclerView recyclerView = (RecyclerView) this.q.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.x));
        recyclerView.setAdapter(this.p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ ThingModel L0(BaseALIoTDevice baseALIoTDevice) {
        return this.z.i(baseALIoTDevice);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List N0(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0(List list) {
        this.p0.p(H0(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void R0(View view) {
        d();
    }

    public void S0(a aVar) {
        this.p1 = aVar;
    }

    @Override // com.tplink.iot.base.BaseFragment, com.tplink.iot.i.a
    public boolean d() {
        if (getFragmentManager() == null) {
            return true;
        }
        getFragmentManager().popBackStackImmediate();
        return true;
    }

    @Override // com.tplink.iot.adapter.smart.SmartDeviceTriggerAdapter.b
    public void l0(ThingInfo thingInfo) {
        String thingName = thingInfo != null ? thingInfo.getThingName() : null;
        ActionSetupViewModel actionSetupViewModel = this.y;
        actionSetupViewModel.f0(actionSetupViewModel.l(thingName));
        a aVar = this.p1;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q = layoutInflater.inflate(R.layout.fragment_smart_task_item_add_list, viewGroup, false);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ActionDetailActivity)) {
            B0();
        }
        ActionDetailActivity actionDetailActivity = (ActionDetailActivity) activity;
        this.x = actionDetailActivity;
        com.tplink.iot.view.quicksetup.base.d.J(actionDetailActivity, this.q.findViewById(R.id.toolbar));
        setHasOptionsMenu(true);
        this.y = (ActionSetupViewModel) ViewModelProviders.of(this.x).get(ActionSetupViewModel.class);
        this.z = (DeviceChooseViewModel) ViewModelProviders.of(this.x).get(DeviceChooseViewModel.class);
        J0();
        I0();
        return this.q;
    }
}
