package com.tplink.iot.view.home.alldevice;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.j;
import com.tplink.iot.adapter.home.RoomDeviceListAdapter;
import com.tplink.iot.adapter.home.h;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.model.home.g;
import com.tplink.iot.model.home.k;
import com.tplink.iot.view.home.base.HomeBaseFragment;
import com.tplink.iot.viewmodel.home.HomeRoomDeviceViewModel;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class RoomDevicesFragment extends HomeBaseFragment implements h {
    private com.tplink.iot.devicecommon.feature.a H3;
    private HomeRoomDeviceViewModel I3;
    private HomeAllDevicesActivity J3;
    private PullToRefreshContainer p0;
    private RoomDeviceListAdapter p1;
    private RecyclerView p2;
    private View p3;
    private boolean x = false;
    private boolean y = false;
    private String z = null;

    /* loaded from: classes2.dex */
    class a implements PullToRefreshContainer.e {
        a() {
        }

        @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e
        public void a() {
        }

        @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e
        public void onRefresh() {
            RoomDevicesFragment.this.I3.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<List<com.tplink.iot.model.home.e>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<com.tplink.iot.model.home.e> list) {
            RoomDevicesFragment.this.p1.r(RoomDevicesFragment.this.g2(list));
            RoomDevicesFragment.this.U1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<List<com.tplink.iot.model.home.e>> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<com.tplink.iot.model.home.e> list) {
            RoomDevicesFragment.this.p0.A();
            if (!RoomDevicesFragment.this.p1.a()) {
                List<com.tplink.iot.model.home.e> g2 = RoomDevicesFragment.this.g2(list);
                RoomDevicesFragment.this.p1.r(g2);
                RoomDevicesFragment.this.U1();
                if (g2 == null || g2.isEmpty()) {
                    RoomDevicesFragment.this.p3.setVisibility(0);
                    RoomDevicesFragment.this.p2.setVisibility(8);
                    return;
                }
                RoomDevicesFragment.this.p3.setVisibility(8);
                RoomDevicesFragment.this.p2.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            RoomDevicesFragment.this.p0.A();
        }
    }

    /* loaded from: classes2.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RoomDevicesFragment.this.p1.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1() {
        if (this.p1.getItemCount() != 0) {
            if (this.p1.q()) {
                this.p2.setPadding(j.a(getActivity(), 11.0f), 0, j.a(getActivity(), 11.0f), j.a(getActivity(), 80.0f));
            } else {
                this.p2.setPadding(j.a(getActivity(), 11.0f), j.a(getActivity(), 10.0f), j.a(getActivity(), 11.0f), j.a(getActivity(), 80.0f));
            }
        }
    }

    private void Z1() {
        if (getArguments() != null) {
            this.x = getArguments().getBoolean("tag_all_devices");
            this.y = getArguments().getBoolean("tag_share_device");
            this.z = getArguments().getString("tag_room_id");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a2 */
    public /* synthetic */ void b2(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        BaseALIoTDevice<?> baseALIoTDevice;
        if (aVar != null && (baseALIoTDevice = (BaseALIoTDevice) aVar.a()) != null) {
            this.H3.b(getActivity(), baseALIoTDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RoomDevicesFragment c2() {
        return d2(true, false, null);
    }

    private static RoomDevicesFragment d2(boolean z, boolean z2, String str) {
        RoomDevicesFragment roomDevicesFragment = new RoomDevicesFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("tag_all_devices", z);
        bundle.putBoolean("tag_share_device", z2);
        bundle.putString("tag_room_id", str);
        roomDevicesFragment.setArguments(bundle);
        return roomDevicesFragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RoomDevicesFragment e2(String str) {
        return d2(false, false, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RoomDevicesFragment f2() {
        return d2(false, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.tplink.iot.model.home.e> g2(List<com.tplink.iot.model.home.e> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.x) {
            arrayList.addAll(list);
        } else if (this.y) {
            for (com.tplink.iot.model.home.e eVar : list) {
                if (eVar instanceof k) {
                    k kVar = (k) eVar;
                    if (kVar.g() != null && kVar.g().isUserRoleTypeDevice()) {
                        arrayList.add(kVar);
                    }
                }
            }
        } else if (!TextUtils.isEmpty(this.z)) {
            for (com.tplink.iot.model.home.e eVar2 : list) {
                if (eVar2 instanceof k) {
                    k kVar2 = (k) eVar2;
                    if (kVar2.g() != null && !kVar2.g().isUserRoleTypeDevice() && TextUtils.equals(kVar2.g().getRoomId(), this.z)) {
                        arrayList.add(kVar2);
                    }
                } else if (eVar2 instanceof g) {
                    g gVar = (g) eVar2;
                    if (gVar.h() != null && TextUtils.equals(gVar.h().getRoomId(), this.z)) {
                        arrayList.add(gVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private void j2() {
        this.I3.C().observe(getViewLifecycleOwner(), new b());
        this.I3.D().observe(getViewLifecycleOwner(), new c());
        this.I3.A().observe(getViewLifecycleOwner(), new d());
        this.I3.B().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.home.alldevice.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RoomDevicesFragment.this.b2((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a) obj);
            }
        });
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void J0(List<com.tplink.iot.model.home.e> list) {
        this.I3.f(list);
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void O0() {
        HomeAllDevicesActivity homeAllDevicesActivity = this.J3;
        if (homeAllDevicesActivity != null) {
            homeAllDevicesActivity.q1();
        }
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public FamilyInfo P0() {
        return this.I3.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V1() {
        List<com.tplink.iot.model.home.e> o = this.p1.o();
        if (!o.isEmpty()) {
            K0(o);
            com.tplink.iot.Utils.x0.a.b(o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W1() {
        List<com.tplink.iot.model.home.e> o = this.p1.o();
        if (!o.isEmpty()) {
            L0(o);
            com.tplink.iot.Utils.x0.a.f(o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X1() {
        List<com.tplink.iot.model.home.e> o = this.p1.o();
        if (!o.isEmpty()) {
            N0(o);
            com.tplink.iot.Utils.x0.a.i(o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y1() {
        RoomDeviceListAdapter roomDeviceListAdapter = this.p1;
        if (roomDeviceListAdapter != null) {
            roomDeviceListAdapter.c(false);
        }
        PullToRefreshContainer pullToRefreshContainer = this.p0;
        if (pullToRefreshContainer != null) {
            pullToRefreshContainer.setEnableHeader(true);
        }
    }

    @Override // com.tplink.iot.adapter.home.h
    public void b(int i) {
        HomeAllDevicesActivity homeAllDevicesActivity = this.J3;
        if (homeAllDevicesActivity != null) {
            homeAllDevicesActivity.u1(i, this.p1.p(), this.p1.o());
        }
    }

    @Override // com.tplink.iot.adapter.home.h
    public void f(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h2() {
        List<com.tplink.iot.model.home.e> o = this.p1.o();
        if (!o.isEmpty()) {
            u1(o);
            com.tplink.iot.Utils.x0.a.h(o);
        }
    }

    @Override // com.tplink.iot.adapter.home.h
    public void i(com.tplink.iot.model.home.e eVar) {
        if (eVar instanceof k) {
            U0((k) eVar);
        } else if (eVar instanceof g) {
            V0((g) eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i2() {
        List<com.tplink.iot.model.home.e> o = this.p1.o();
        if (!o.isEmpty()) {
            A1(o);
            com.tplink.iot.Utils.x0.a.g(o);
        }
    }

    @Override // com.tplink.iot.adapter.home.h
    public void j(com.tplink.iot.model.home.e eVar) {
        this.I3.u();
        HomeAllDevicesActivity homeAllDevicesActivity = this.J3;
        if (homeAllDevicesActivity != null) {
            homeAllDevicesActivity.z1();
        }
        PullToRefreshContainer pullToRefreshContainer = this.p0;
        if (pullToRefreshContainer != null) {
            pullToRefreshContainer.setEnableHeader(false);
        }
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void k1(String str) {
        com.tplink.iot.Utils.x0.a.d(str);
    }

    @Override // com.tplink.iot.adapter.home.h
    public void l(int i, com.tplink.iot.model.home.e eVar, boolean z) {
        if (eVar instanceof g) {
            Y0((g) eVar, z);
        } else if (eVar instanceof k) {
            X0((k) eVar, z);
        }
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void l1(BaseALIoTDevice baseALIoTDevice, boolean z) {
        String deviceIdMD5 = baseALIoTDevice.getDeviceIdMD5();
        if (baseALIoTDevice.isBulb()) {
            com.tplink.iot.Utils.x0.a.a(deviceIdMD5, z);
        } else if (baseALIoTDevice.isPlug()) {
            com.tplink.iot.Utils.x0.a.e(deviceIdMD5, z);
        }
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void o1() {
        this.f6075c.post(new e());
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof HomeAllDevicesActivity) {
            this.J3 = (HomeAllDevicesActivity) activity;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_room_classified, viewGroup, false);
        this.I3 = (HomeRoomDeviceViewModel) ViewModelProviders.of(this).get(HomeRoomDeviceViewModel.class);
        Z1();
        this.H3 = new com.tplink.iot.devicecommon.feature.a();
        this.p0 = (PullToRefreshContainer) inflate.findViewById(R.id.refresh_layout);
        this.p3 = inflate.findViewById(R.id.layout_empty);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        this.p2 = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        RoomDeviceListAdapter roomDeviceListAdapter = new RoomDeviceListAdapter(getActivity());
        this.p1 = roomDeviceListAdapter;
        roomDeviceListAdapter.s(this);
        this.p1.setHasStableIds(true);
        this.p2.setAdapter(this.p1);
        this.p0.setHeader(new com.tplink.iot.widget.g());
        this.p0.setEnableFooter(false);
        this.p0.setListener(new a());
        j2();
        return inflate;
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void p1() {
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void q1(List<com.tplink.iot.model.home.e> list) {
        this.I3.m(list);
        O0();
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    public void r1(List<com.tplink.iot.model.home.e> list) {
        this.I3.o(list);
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void s1(boolean z, String str) {
        this.I3.p(false, str);
    }

    @Override // com.tplink.iot.view.home.base.HomeBaseFragment
    protected void t1(String str, boolean z) {
        this.I3.s(str, z);
    }
}
