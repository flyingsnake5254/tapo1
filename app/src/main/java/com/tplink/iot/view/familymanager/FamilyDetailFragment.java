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
import com.tplink.iot.adapter.familymanager.FamilyDetailAdapter;
import com.tplink.iot.adapter.home.HomeSpaceItemDecoration;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.viewmodel.familymanager.FamilyViewModel;
import com.tplink.iot.viewmodel.familymanager.RoomViewModel;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;
import java.util.List;

/* loaded from: classes2.dex */
public class FamilyDetailFragment extends BaseFragment implements FamilyDetailAdapter.g {
    @BindView
    Button mDeleteHomeButton;
    @BindView
    RecyclerView mRoomListRecyclerView;
    @BindView
    Toolbar mToolbar;
    @BindView
    TextView mToolbarTitle;
    private boolean p0;
    private List<FamilyBean> p1;
    private boolean p2;
    private FamilyViewModel q;
    private RoomViewModel x;
    private FamilyDetailAdapter y;
    private FamilyBean z;

    /* loaded from: classes2.dex */
    class a implements TPMaterialDialogV2.d {
        a() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            s0.l(FamilyDetailFragment.this.getActivity());
            FamilyDetailFragment.this.q.k(FamilyDetailFragment.this.z.getFamilyId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<List<FamilyBean>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<FamilyBean> list) {
            s0.g();
            if (list == null || list.size() == 0) {
                s0.n(FamilyDetailFragment.this.getActivity(), R.string.common_operation_failed);
            } else if (list.size() == 1) {
                FamilyDetailFragment.this.L0();
            } else {
                FamilyDetailFragment.this.C0(FamilyListActivity.class);
                FamilyDetailFragment.this.requireActivity().finish();
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
                s0.n(FamilyDetailFragment.this.getActivity(), R.string.operation_failed_try_again);
            } else {
                FamilyDetailFragment.this.getActivity().finish();
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
            s0.g();
            if (bool == null || !bool.booleanValue()) {
                s0.n(FamilyDetailFragment.this.getActivity(), R.string.operation_failed_try_again);
            } else {
                FamilyDetailFragment.this.y.s(FamilyDataManager.INSTANCE.getCurFamily());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        FamilyDataManager familyDataManager = FamilyDataManager.INSTANCE;
        this.z = familyDataManager.getCurFamily();
        List<FamilyBean> familyList = familyDataManager.getFamilyList();
        this.p1 = familyList;
        if (this.z == null || familyList == null || familyList.size() == 0) {
            this.p2 = true;
            s0.l(getActivity());
            this.q.n();
            return;
        }
        Q0();
    }

    private void N0() {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).setSupportActionBar(this.mToolbar);
        }
        this.mRoomListRecyclerView.addItemDecoration(new HomeSpaceItemDecoration(getActivity()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.mRoomListRecyclerView.setLayoutManager(linearLayoutManager);
        FamilyDetailAdapter familyDetailAdapter = new FamilyDetailAdapter(getActivity());
        this.y = familyDetailAdapter;
        this.mRoomListRecyclerView.setAdapter(familyDetailAdapter);
        this.y.t(this);
    }

    private void O0() {
        new TPMaterialDialogV2.Builder(getActivity()).j(getString(R.string.room_num_out_of_range, 32)).o(R.string.action_got_it, R.color.common_iot_main_blue, null).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void P0() {
        this.q.o().observe(this, new b());
        this.q.l().observe(this, new c());
        this.x.n().observe(this, new d());
    }

    private void Q0() {
        if (!this.z.getDefault() || this.z.getFamilyName() == null || !this.z.getFamilyName().isEmpty()) {
            this.mToolbarTitle.setText(this.z.getFamilyName());
        } else {
            this.mToolbarTitle.setText(getResources().getString(R.string.home_default_family));
        }
        this.y.s(this.z);
        if (this.z.getDefault()) {
            this.mDeleteHomeButton.setVisibility(8);
        }
    }

    @Override // com.tplink.iot.adapter.familymanager.FamilyDetailAdapter.g
    public void E(FamilyBean familyBean) {
        C0(EditFamilyNameActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void deleteHome() {
        FamilyBean familyBean = this.z;
        if (familyBean == null) {
            s0.n(getActivity(), R.string.operation_failed_try_again);
        } else if (familyBean.getDeviceCount() == 0) {
            new TPMaterialDialogV2.Builder(getContext()).j(getResources().getString(R.string.confirm_delete)).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_delete, R.color.common_iot_main_blue, new a()).g(8, 8).setCancelable(false).c(false).create().show();
        } else {
            s0.p(getActivity(), getString(R.string.toast_delete_home));
        }
    }

    @Override // com.tplink.iot.adapter.familymanager.FamilyDetailAdapter.g
    public void e0(RoomBean roomBean) {
        s0.l(getActivity());
        this.x.l(FamilyDataManager.INSTANCE.getCurFamily().getFamilyId(), roomBean.getRoomId());
    }

    @Override // com.tplink.iot.adapter.familymanager.FamilyDetailAdapter.g
    public void k0(RoomBean roomBean) {
        FamilyDataManager.INSTANCE.updateCurRoomBean(roomBean);
        C0(RoomDetailActivity.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getArguments() != null) {
            this.p0 = getArguments().getBoolean("args_key_need_add_home");
        }
        P0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (this.p0) {
            menuInflater.inflate(R.menu.menu_add, menu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.home_detail_fragment, viewGroup, false);
        setHasOptionsMenu(true);
        ButterKnife.b(this, inflate);
        N0();
        return inflate;
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.p2) {
            FamilyDataManager.INSTANCE.clearData();
        }
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_add == menuItem.getItemId()) {
            C0(AddFamilyActivity.class);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        L0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.q = (FamilyViewModel) ViewModelProviders.of(this).get(FamilyViewModel.class);
        this.x = (RoomViewModel) ViewModelProviders.of(this).get(RoomViewModel.class);
    }

    @Override // com.tplink.iot.adapter.familymanager.FamilyDetailAdapter.g
    public void u0() {
        if (this.y.r() >= 32) {
            O0();
        } else {
            C0(AddRoomActivity.class);
        }
    }
}
