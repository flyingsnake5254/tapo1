package com.tplink.iot.view.familymanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.familymanager.RoomDetailAdapter;
import com.tplink.iot.adapter.home.HomeSpaceItemDecoration;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.viewmodel.familymanager.RoomViewModel;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;
import java.util.Collections;

/* loaded from: classes2.dex */
public class RoomDetailFragment extends BaseFragment implements RoomDetailAdapter.f {
    @BindView
    Button mDeleteRoomButton;
    @BindView
    RecyclerView mRoomDeviceListRecyclerView;
    @BindView
    Toolbar mToolbar;
    @BindView
    TextView mToolbarTitle;
    private RoomDetailAdapter q;
    private RoomViewModel x;

    /* loaded from: classes2.dex */
    class a implements TPMaterialDialogV2.d {
        a() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            s0.l(RoomDetailFragment.this.getActivity());
            RoomViewModel roomViewModel = RoomDetailFragment.this.x;
            FamilyDataManager familyDataManager = FamilyDataManager.INSTANCE;
            roomViewModel.l(familyDataManager.getCurFamily().getFamilyId(), familyDataManager.getCurRoombean().getRoomId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            s0.g();
            if (bool == null || !bool.booleanValue()) {
                s0.n(RoomDetailFragment.this.getActivity(), R.string.operation_failed_try_again);
            } else {
                RoomDetailFragment.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            s0.g();
            if (bool == null || !bool.booleanValue()) {
                s0.n(RoomDetailFragment.this.getActivity(), R.string.operation_failed_try_again);
            } else {
                RoomDetailFragment.this.L0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(Boolean bool) {
            s0.g();
            if (bool == null || !bool.booleanValue()) {
                s0.n(RoomDetailFragment.this.getActivity(), R.string.operation_failed_try_again);
            } else {
                RoomDetailFragment.this.L0();
            }
        }
    }

    private void J0() {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).setSupportActionBar(this.mToolbar);
        }
        this.mToolbarTitle.setText(getString(R.string.room_settings));
        this.mRoomDeviceListRecyclerView.addItemDecoration(new HomeSpaceItemDecoration(getActivity()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.mRoomDeviceListRecyclerView.setLayoutManager(linearLayoutManager);
        RoomDetailAdapter roomDetailAdapter = new RoomDetailAdapter(getActivity());
        this.q = roomDetailAdapter;
        this.mRoomDeviceListRecyclerView.setAdapter(roomDetailAdapter);
        this.q.y(this);
    }

    private void K0() {
        this.x.n().observe(this, new b());
        this.x.s().observe(this, new c());
        this.x.u().observe(this, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        RoomBean curRoombean = FamilyDataManager.INSTANCE.getCurRoombean();
        if (curRoombean != null) {
            this.q.x(curRoombean.getRoomName(), curRoombean.getDeviceList(), this.x.r(curRoombean.getRoomId()));
        }
    }

    @Override // com.tplink.iot.adapter.familymanager.RoomDetailAdapter.f
    public void W() {
        C0(AddDeviceActivity.class);
    }

    @Override // com.tplink.iot.adapter.familymanager.RoomDetailAdapter.f
    public void c0(GroupInfo groupInfo) {
        s0.l(getActivity());
        this.x.B(groupInfo.getId(), "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void deleteRoom() {
        new TPMaterialDialogV2.Builder(getContext()).j(getResources().getString(R.string.confirm_delete_room)).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_delete, R.color.common_iot_main_blue, new a()).g(8, 8).setCancelable(false).c(false).create().show();
    }

    @Override // com.tplink.iot.adapter.familymanager.RoomDetailAdapter.f
    public void o0(DeviceBean deviceBean) {
        s0.l(getActivity());
        this.x.y(FamilyDataManager.INSTANCE.getCurFamily().getFamilyId(), "", Collections.singletonList(deviceBean));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.x = (RoomViewModel) ViewModelProviders.of(this).get(RoomViewModel.class);
        K0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_done, menu);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.room_detail_fragment, viewGroup, false);
        setHasOptionsMenu(true);
        ButterKnife.b(this, inflate);
        J0();
        return inflate;
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_done == menuItem.getItemId()) {
            C0(FamilyDetailActivity.class);
            getActivity().finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        L0();
    }

    @Override // com.tplink.iot.adapter.familymanager.RoomDetailAdapter.f
    public void r0() {
        C0(EditRoomNameActivity.class);
    }
}
