package com.tplink.iot.view.iothub.guardmode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.iothub.GuardModeAlarmVolumeAdapter;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import java.util.HashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: SetAlarmVolumeFragment.kt */
/* loaded from: classes2.dex */
public final class SetAlarmVolumeFragment extends BaseGuardModeSettingFragment {
    public static final a p0 = new a(null);
    private final int p1 = R.string.gm_config_alarm_volume;
    private GuardModeAlarmVolumeAdapter p2;
    private HashMap p3;

    /* compiled from: SetAlarmVolumeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SetAlarmVolumeFragment.kt */
    /* loaded from: classes2.dex */
    static final class b<T> implements Observer<GuardModeConfigBean> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(GuardModeConfigBean guardModeConfigBean) {
            SetAlarmVolumeFragment.Q0(SetAlarmVolumeFragment.this).C(guardModeConfigBean.getEnumAlarmVolume());
        }
    }

    public static final /* synthetic */ GuardModeAlarmVolumeAdapter Q0(SetAlarmVolumeFragment setAlarmVolumeFragment) {
        GuardModeAlarmVolumeAdapter guardModeAlarmVolumeAdapter = setAlarmVolumeFragment.p2;
        if (guardModeAlarmVolumeAdapter == null) {
            j.t("mAdapter");
        }
        return guardModeAlarmVolumeAdapter;
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment
    public void H0() {
        HashMap hashMap = this.p3;
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
        GuardModeAlarmVolumeAdapter guardModeAlarmVolumeAdapter = this.p2;
        if (guardModeAlarmVolumeAdapter == null) {
            j.t("mAdapter");
        }
        L0().v(guardModeAlarmVolumeAdapter.t().b());
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment
    protected void O0() {
        L0().i().observe(getViewLifecycleOwner(), new b());
    }

    public View P0(int i) {
        if (this.p3 == null) {
            this.p3 = new HashMap();
        }
        View view = (View) this.p3.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.p3.put(Integer.valueOf(i), findViewById);
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
        GuardModeAlarmVolumeAdapter guardModeAlarmVolumeAdapter = new GuardModeAlarmVolumeAdapter(K0());
        RecyclerView config_item_list = (RecyclerView) P0(com.tplink.iot.a.config_item_list);
        j.d(config_item_list, "config_item_list");
        config_item_list.setAdapter(guardModeAlarmVolumeAdapter);
        p pVar = p.a;
        this.p2 = guardModeAlarmVolumeAdapter;
    }
}
