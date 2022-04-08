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
import com.tplink.iot.R;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.view.smart.actionsetup.ConditionAddFragment;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.DeviceChooseViewModel;
import com.tplink.iot.widget.ItemSmartSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.b.l;

/* loaded from: classes2.dex */
public class TaskAddFragment extends BaseFragment {
    private ActionSetupViewModel p0;
    private DeviceChooseViewModel p1;
    private f p2;
    private ItemSmartSettingLayout q;
    private ItemSmartSettingLayout x;
    private ItemSmartSettingLayout y;
    private ActionDetailActivity z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<List<BaseALIoTDevice>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<BaseALIoTDevice> list) {
            TaskAddFragment.this.O0(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TaskAddFragment.this.B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TaskAddFragment.this.p2 != null) {
                TaskAddFragment.this.p2.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TaskAddFragment.this.p2 != null) {
                TaskAddFragment.this.p2.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TaskAddFragment.this.p2 != null) {
                TaskAddFragment.this.p2.c();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();

        void b();

        void c();
    }

    private boolean J0(@Nullable List<BaseALIoTDevice> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.tplink.iot.view.smart.b.e());
            arrayList.add(new com.tplink.iot.view.smart.b.b(new l() { // from class: com.tplink.iot.view.smart.actionsetup.x
                @Override // kotlin.jvm.b.l
                public final Object invoke(Object obj) {
                    return TaskAddFragment.this.N0((BaseALIoTDevice) obj);
                }
            }));
            arrayList.add(new com.tplink.iot.view.smart.b.c());
            arrayList.add(new com.tplink.iot.view.smart.b.a());
            for (BaseALIoTDevice<?> baseALIoTDevice : list) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((com.tplink.iot.view.smart.b.d) it.next()).a(baseALIoTDevice)) {
                            z = false;
                            continue;
                            break;
                        }
                    } else {
                        z = true;
                        continue;
                        break;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private void K0(View view) {
        ((TextView) view.findViewById(R.id.toolbar_title)).setText(R.string.smart_action_add_tasks);
        ((Toolbar) view.findViewById(R.id.toolbar)).setNavigationOnClickListener(new b());
        this.q = (ItemSmartSettingLayout) view.findViewById(R.id.rl_run_shortcut);
        this.x = (ItemSmartSettingLayout) view.findViewById(R.id.rl_enable_automation);
        this.y = (ItemSmartSettingLayout) view.findViewById(R.id.rl_control_devices);
        com.bumptech.glide.c.x(this.z).s("file:///android_asset/smart_icons/SmartOneClickBlueBackground.png").u0(new ConditionAddFragment.g(this.q));
        com.bumptech.glide.c.x(this.z).s("file:///android_asset/smart_icons/SmartAutoBlueBackground.png").u0(new ConditionAddFragment.g(this.x));
        com.bumptech.glide.c.x(this.z).s("file:///android_asset/smart_icons/SmartDeviceTriggerBlueBackground.png").u0(new ConditionAddFragment.g(this.y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ ThingModel N0(BaseALIoTDevice baseALIoTDevice) {
        return this.p1.i(baseALIoTDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(@Nullable List<BaseALIoTDevice> list) {
        this.q.setVisibility(this.p0.N() ? 8 : 0);
        e eVar = null;
        if (!this.p0.N()) {
            this.q.setItemEnable(this.p0.J());
            this.q.setItemInfo(this.p0.J() ? null : getString(R.string.smart_action_add_tasks_no_shortcuts));
            this.q.setOnClickListener((this.p0.N() || !this.p0.J()) ? null : new c());
        }
        this.x.setItemEnable(this.p0.I());
        this.x.setItemInfo(this.p0.I() ? null : getString(R.string.smart_action_add_tasks_no_automations));
        this.x.setOnClickListener(!this.p0.I() ? null : new d());
        boolean J0 = J0(list);
        this.y.setItemEnable(J0);
        this.y.setItemInfo(J0 ? null : getString(R.string.smart_action_add_tasks_no_devices));
        ItemSmartSettingLayout itemSmartSettingLayout = this.y;
        if (J0) {
            eVar = new e();
        }
        itemSmartSettingLayout.setOnClickListener(eVar);
    }

    private void Q0() {
        this.p0.r().observe(getViewLifecycleOwner(), new a());
    }

    public void P0(f fVar) {
        this.p2 = fVar;
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
        View inflate = layoutInflater.inflate(R.layout.fragment_smart_add_tasks, viewGroup, false);
        ActionDetailActivity actionDetailActivity = (ActionDetailActivity) getActivity();
        this.z = actionDetailActivity;
        if (actionDetailActivity == null) {
            B0();
        }
        this.p0 = (ActionSetupViewModel) ViewModelProviders.of(this.z).get(ActionSetupViewModel.class);
        this.p1 = (DeviceChooseViewModel) ViewModelProviders.of(this.z).get(DeviceChooseViewModel.class);
        com.tplink.iot.view.quicksetup.base.d.J(this.z, inflate.findViewById(R.id.toolbar));
        setHasOptionsMenu(true);
        K0(inflate);
        Q0();
        return inflate;
    }
}
