package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.smart.SmartDeviceTaskAdapter;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.view.smart.b.b;
import com.tplink.iot.view.smart.b.c;
import com.tplink.iot.view.smart.b.d;
import com.tplink.iot.view.smart.b.e;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.DeviceChooseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.b.l;

/* loaded from: classes2.dex */
public class TaskDeviceChooseFragment extends BaseFragment implements SmartDeviceTaskAdapter.b {
    private ActionDetailActivity p0;
    private a p1;
    private View q;
    private ActionSetupViewModel x;
    private SmartDeviceTaskAdapter y;
    private DeviceChooseViewModel z;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    private List<BaseALIoTDevice> H0(List<BaseALIoTDevice> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new e());
            arrayList2.add(new b(new l() { // from class: com.tplink.iot.view.smart.actionsetup.b0
                @Override // kotlin.jvm.b.l
                public final Object invoke(Object obj) {
                    return TaskDeviceChooseFragment.this.K0((BaseALIoTDevice) obj);
                }
            }));
            arrayList2.add(new c());
            arrayList2.add(new com.tplink.iot.view.smart.b.a());
            for (BaseALIoTDevice<?> baseALIoTDevice : list) {
                boolean z = true;
                Iterator it = arrayList2.iterator();
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
        ((TextView) this.q.findViewById(R.id.toolbar_title)).setText(R.string.smart_action_add_tasks_control_devices_choose);
        ((Toolbar) this.q.findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.smart.actionsetup.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDeviceChooseFragment.this.N0(view);
            }
        });
        SmartDeviceTaskAdapter smartDeviceTaskAdapter = new SmartDeviceTaskAdapter(this.p0, this.z);
        this.y = smartDeviceTaskAdapter;
        smartDeviceTaskAdapter.q(this);
        RecyclerView recyclerView = (RecyclerView) this.q.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.p0));
        recyclerView.setAdapter(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ ThingModel K0(BaseALIoTDevice baseALIoTDevice) {
        return this.z.i(baseALIoTDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0(View view) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0(List list) {
        this.y.p(H0(list));
    }

    private void R0() {
        this.x.r().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.smart.actionsetup.a0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TaskDeviceChooseFragment.this.P0((List) obj);
            }
        });
    }

    public void Q0(a aVar) {
        this.p1 = aVar;
    }

    @Override // com.tplink.iot.adapter.smart.SmartDeviceTaskAdapter.b
    public void Y(ThingInfo thingInfo) {
        String thingName = thingInfo != null ? thingInfo.getThingName() : null;
        ActionSetupViewModel actionSetupViewModel = this.x;
        actionSetupViewModel.f0(actionSetupViewModel.l(thingName));
        a aVar = this.p1;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tplink.iot.base.BaseFragment, com.tplink.iot.i.a
    public boolean d() {
        if (getFragmentManager() == null) {
            return true;
        }
        getFragmentManager().popBackStackImmediate();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = layoutInflater.inflate(R.layout.fragment_smart_task_item_add_list, viewGroup, false);
        ActionDetailActivity actionDetailActivity = (ActionDetailActivity) getActivity();
        this.p0 = actionDetailActivity;
        if (actionDetailActivity == null) {
            B0();
        }
        com.tplink.iot.view.quicksetup.base.d.J(this.p0, this.q.findViewById(R.id.toolbar));
        setHasOptionsMenu(true);
        this.x = (ActionSetupViewModel) ViewModelProviders.of(this.p0).get(ActionSetupViewModel.class);
        this.z = (DeviceChooseViewModel) ViewModelProviders.of(this.p0).get(DeviceChooseViewModel.class);
        I0();
        R0();
        return this.q;
    }
}
