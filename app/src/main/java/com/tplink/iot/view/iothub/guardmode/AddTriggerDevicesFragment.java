package com.tplink.iot.view.iothub.guardmode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.iothub.AddTriggerDeviceAdapter;
import com.tplink.iot.viewmodel.iothub.guardmode.GuardModeConfigViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: AddTriggerDevicesFragment.kt */
/* loaded from: classes2.dex */
public final class AddTriggerDevicesFragment extends BaseGuardModeSettingFragment {
    public static final a p0 = new a(null);
    private List<? extends BaseALIoTDevice<?>> H3;
    private HashMap I3;
    private final int p1 = R.string.gm_config_trigger_devices;
    private AddTriggerDeviceAdapter p2;
    private GuardModeConfigBean p3;

    /* compiled from: AddTriggerDevicesFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: AddTriggerDevicesFragment.kt */
    /* loaded from: classes2.dex */
    static final class b<T> implements Observer<GuardModeConfigBean> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(GuardModeConfigBean guardModeConfigBean) {
            AddTriggerDevicesFragment.this.p3 = guardModeConfigBean;
            AddTriggerDevicesFragment.this.T0();
        }
    }

    /* compiled from: AddTriggerDevicesFragment.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements Observer<List<? extends BaseALIoTDevice<?>>> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(List<? extends BaseALIoTDevice<?>> list) {
            AddTriggerDevicesFragment.this.H3 = list;
            AddTriggerDevicesFragment.this.T0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0() {
        List<? extends BaseALIoTDevice<?>> list;
        GuardModeConfigBean guardModeConfigBean = this.p3;
        if (!(guardModeConfigBean == null || (list = this.H3) == null)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (guardModeConfigBean.getDeviceIdList().contains(((BaseALIoTDevice) obj).getDeviceId())) {
                    arrayList.add(obj);
                }
            }
            AddTriggerDeviceAdapter addTriggerDeviceAdapter = this.p2;
            if (addTriggerDeviceAdapter == null) {
                j.t("mAdapter");
            }
            addTriggerDeviceAdapter.t(list, arrayList);
        }
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment
    public void H0() {
        HashMap hashMap = this.I3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment
    protected int J0() {
        return this.p1;
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment
    protected void N0() {
        GuardModeConfigViewModel L0 = L0();
        AddTriggerDeviceAdapter addTriggerDeviceAdapter = this.p2;
        if (addTriggerDeviceAdapter == null) {
            j.t("mAdapter");
        }
        L0.x(addTriggerDeviceAdapter.q());
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment
    protected void O0() {
        L0().i().observe(getViewLifecycleOwner(), new b());
        L0().h().observe(getViewLifecycleOwner(), new c());
    }

    public View P0(int i) {
        if (this.I3 == null) {
            this.I3 = new HashMap();
        }
        View view = (View) this.I3.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.I3.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_guard_mode_recyclerview_list, viewGroup, false);
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        AddTriggerDeviceAdapter addTriggerDeviceAdapter = new AddTriggerDeviceAdapter(K0());
        RecyclerView config_item_list = (RecyclerView) P0(com.tplink.iot.a.config_item_list);
        j.d(config_item_list, "config_item_list");
        config_item_list.setAdapter(addTriggerDeviceAdapter);
        p pVar = p.a;
        this.p2 = addTriggerDeviceAdapter;
    }
}
