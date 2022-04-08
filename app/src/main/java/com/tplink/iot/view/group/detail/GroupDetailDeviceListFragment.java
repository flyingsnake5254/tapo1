package com.tplink.iot.view.group.detail;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.iot.R;
import com.tplink.iot.Utils.j;
import com.tplink.iot.adapter.home.HomeMainAdapter;
import com.tplink.iot.adapter.home.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.k;
import com.tplink.iot.view.home.base.HomeBaseFragment;
import com.tplink.iot.viewmodel.group.GroupDetailViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;

/* loaded from: classes2.dex */
public class GroupDetailDeviceListFragment extends HomeBaseFragment implements h {
    private GroupDetailViewModel p0;
    private HomeMainAdapter p1;
    private GroupInfo p2;
    private View x;
    private RecyclerView y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<List<GroupInfo>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(List<GroupInfo> list) {
            GroupInfo o = GroupDetailDeviceListFragment.this.p0.o(list, GroupDetailDeviceListFragment.this.z);
            if (o != null) {
                GroupDetailDeviceListFragment.this.p2 = o;
                GroupDetailDeviceListFragment.this.X1();
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupDetailDeviceListFragment.this.p1.notifyDataSetChanged();
        }
    }

    private void S1() {
        if (getArguments() != null) {
            this.z = getArguments().getString(FirebaseAnalytics.Param.GROUP_ID);
        }
    }

    private void T1() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).Y0();
        }
    }

    private void U1() {
        RecyclerView recyclerView = (RecyclerView) this.x.findViewById(R.id.recycler_view_device);
        this.y = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        HomeMainAdapter homeMainAdapter = new HomeMainAdapter(getActivity(), false);
        this.p1 = homeMainAdapter;
        homeMainAdapter.u(this);
        this.p1.setHasStableIds(true);
        this.y.setAdapter(this.p1);
    }

    public static GroupDetailDeviceListFragment V1(String str) {
        GroupDetailDeviceListFragment groupDetailDeviceListFragment = new GroupDetailDeviceListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.GROUP_ID, str);
        groupDetailDeviceListFragment.setArguments(bundle);
        return groupDetailDeviceListFragment;
    }

    private void W1() {
        this.p0.p().observe(this, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X1() {
        GroupInfo groupInfo = this.p2;
        if (groupInfo == null) {
            T1();
            return;
        }
        List<e> r = this.p0.r(groupInfo);
        if (r == null || r.isEmpty()) {
            T1();
            return;
        }
        this.p1.s(r);
        this.y.setPadding(j.a(getActivity(), 11.0f), j.a(getActivity(), 10.0f), j.a(getActivity(), 11.0f), j.a(getActivity(), 10.0f));
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void J0(List<e> list) {
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void O0() {
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public FamilyInfo P0() {
        return null;
    }

    @Override // com.tplink.iot.adapter.home.h
    public void b(int i) {
    }

    @Override // com.tplink.iot.adapter.home.h
    public void f(int i, int i2) {
    }

    @Override // com.tplink.iot.adapter.home.h
    public void i(e eVar) {
        U0((k) eVar);
    }

    @Override // com.tplink.iot.adapter.home.h
    public void j(e eVar) {
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void k1(String str) {
    }

    @Override // com.tplink.iot.adapter.home.h
    public void l(int i, e eVar, boolean z) {
        if (eVar instanceof k) {
            X0((k) eVar, z);
        }
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void l1(BaseALIoTDevice baseALIoTDevice, boolean z) {
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void o1() {
        this.f6075c.post(new b());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.x = layoutInflater.inflate(R.layout.fragment_group_detail_bulb_device_list, viewGroup, false);
        S1();
        if (TextUtils.isEmpty(this.z)) {
            return this.x;
        }
        this.p0 = (GroupDetailViewModel) ViewModelProviders.of(this).get(GroupDetailViewModel.class);
        U1();
        W1();
        return this.x;
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void p1() {
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void q1(List<e> list) {
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void r1(List<e> list) {
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void s1(boolean z, String str) {
        this.p0.D(false, str);
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void t1(String str, boolean z) {
        this.p0.F(str, z);
    }
}
