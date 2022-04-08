package com.tplink.iot.view.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.adapter.feedback.DeviceTypeListAdapter;
import com.tplink.iot.adapter.home.HomeSpaceItemDecoration;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.model.about.c;
import com.tplink.iot.model.about.d;
import com.tplink.iot.view.about.AboutWebActivity;

/* loaded from: classes2.dex */
public class DeviceTypeListFragment extends BaseFragment implements DeviceTypeListAdapter.c {
    @BindView
    RecyclerView mDeviceTypeListRecyclerView;
    @BindView
    Toolbar mToolbar;
    @BindView
    TextView mToolbarTitle;
    private DeviceTypeListAdapter q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TPMaterialDialogV2.c {

        /* renamed from: com.tplink.iot.view.feedback.DeviceTypeListFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0220a implements d0.g {
            C0220a() {
            }

            @Override // com.tplink.iot.Utils.d0.g
            public void a() {
                DeviceTypeListFragment.this.I0();
            }
        }

        /* loaded from: classes2.dex */
        class b implements View.OnClickListener {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ TPMaterialDialogV2 f8462c;

            b(TPMaterialDialogV2 tPMaterialDialogV2) {
                this.f8462c = tPMaterialDialogV2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.tplink.iot.model.about.c.j(true);
                com.tplink.iot.model.about.c.d();
                com.tplink.iot.Utils.x0.b.c(true);
                com.tplink.iot.model.about.c.n(true).y();
                TPMaterialDialogV2 tPMaterialDialogV2 = this.f8462c;
                if (tPMaterialDialogV2 != null) {
                    tPMaterialDialogV2.dismiss();
                }
            }
        }

        /* loaded from: classes2.dex */
        class c implements View.OnClickListener {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ TPMaterialDialogV2 f8464c;

            c(TPMaterialDialogV2 tPMaterialDialogV2) {
                this.f8464c = tPMaterialDialogV2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.tplink.iot.Utils.x0.b.c(false);
                TPMaterialDialogV2 tPMaterialDialogV2 = this.f8464c;
                if (tPMaterialDialogV2 != null) {
                    tPMaterialDialogV2.dismiss();
                }
            }
        }

        a() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.c
        public void a(TPMaterialDialogV2 tPMaterialDialogV2, View view) {
            TextView textView = (TextView) view.findViewById(R.id.tv_analytics_remind);
            textView.setText(R.string.join_user_experience_dialog_remind);
            DeviceTypeListFragment deviceTypeListFragment = DeviceTypeListFragment.this;
            d0.e(textView, deviceTypeListFragment.getString(R.string.join_user_experience_dialog_remind, deviceTypeListFragment.getResources().getString(R.string.check_experience_improvement_sub_str)), DeviceTypeListFragment.this.getString(R.string.check_experience_improvement_sub_str), DeviceTypeListFragment.this.getResources().getColor(R.color.common_iot_main_blue), new C0220a());
            ((TextView) view.getRootView().findViewById(R.id.tv_accept_analytics)).setOnClickListener(new b(tPMaterialDialogV2));
            ((TextView) view.findViewById(R.id.tv_not_accept_analytics)).setOnClickListener(new c(tPMaterialDialogV2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        Intent intent = new Intent(getActivity(), AboutWebActivity.class);
        intent.putExtra("toolbar_title", getString(R.string.check_experience_improvement_sub_str));
        intent.putExtra("url", d.g());
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
    }

    private void J0() {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).setSupportActionBar(this.mToolbar);
        }
        this.mToolbarTitle.setText(R.string.drawer_help);
        this.mDeviceTypeListRecyclerView.addItemDecoration(new HomeSpaceItemDecoration(getActivity()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.mDeviceTypeListRecyclerView.setLayoutManager(linearLayoutManager);
        DeviceTypeListAdapter deviceTypeListAdapter = new DeviceTypeListAdapter(getActivity());
        this.q = deviceTypeListAdapter;
        deviceTypeListAdapter.o();
        this.mDeviceTypeListRecyclerView.setAdapter(this.q);
        this.q.p(this);
    }

    private void K0() {
        new TPMaterialDialogV2.Builder(getActivity()).d(R.layout.layout_analytics_remind).f(new a()).show();
    }

    @Override // com.tplink.iot.adapter.feedback.DeviceTypeListAdapter.c
    public void O(String str, String str2, EnumFeedbackCategory enumFeedbackCategory) {
        HelpAndFeedbackActivity.m1(requireContext(), str, str2, enumFeedbackCategory);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.device_type_list_fragment, viewGroup, false);
        setHasOptionsMenu(true);
        ButterKnife.b(this, inflate);
        J0();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!c.g()) {
            c.k(true);
            if (!c.f()) {
                K0();
            }
        }
    }
}
