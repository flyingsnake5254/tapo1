package com.tplink.iot.view.ipcamera.onboardingv2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraV2WifiListBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.CameraWifiListAdapter;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWifiListViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;

/* loaded from: classes2.dex */
public class CameraWifiListFragment extends OnBoardingFragment<FragmentCameraV2WifiListBinding, CameraWifiListViewModel> {
    private CameraWifiListAdapter x;

    /* loaded from: classes2.dex */
    class a implements d0.g {
        a() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            f.A(CameraWifiListFragment.this.q.B());
            CameraWifiListFragment.this.f8811f.e0("CameraCannotFindFragment.TAG", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends LinearLayoutManager {
        b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void G0() {
        if (this.q.j.get()) {
            this.f8811f.e0("CameraWiredConnectApFragment.TAG", null);
        } else {
            this.f8811f.e0("CameraConnectApFragment.TAG", null);
        }
    }

    private void I0() {
        this.x = new CameraWifiListAdapter(new CameraWifiListAdapter.a() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.h1
            @Override // com.tplink.iot.view.ipcamera.onboardingv2.CameraWifiListAdapter.a
            public final void a(Wifi wifi) {
                CameraWifiListFragment.this.L0(wifi);
            }
        });
        ((FragmentCameraV2WifiListBinding) this.f8809c).q.setLayoutManager(new b(getActivity()));
        ((FragmentCameraV2WifiListBinding) this.f8809c).q.setAdapter(this.x);
    }

    private void J0() {
        ((FragmentCameraV2WifiListBinding) this.f8809c).p1.setText(this.q.j.get() ? R.string.camera_onboarding_wired_choose_wifi_tips_v2 : R.string.quicksetup_list_choose_network_tip_v2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0(Wifi wifi) {
        if (wifi == null) {
            this.f8811f.e0("CameraManualInputPwdFragment.TAG", null);
        } else if (wifi.getAuth() == 0) {
            R0(wifi);
            f.I(this.q.B(), wifi);
        } else {
            this.q.c2(wifi);
            this.q.s(wifi);
            this.f8811f.e0("CameraInputPwdFragment.TAG", null);
            f.I(this.q.B(), wifi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void O0(View view) {
        this.q.o2(20001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ void Q0(Wifi wifi) {
        this.q.a.set(wifi.getSsid());
        this.q.f10404b.set("");
        this.q.c2(wifi);
        G0();
    }

    private void R0(final Wifi wifi) {
        if (isAdded()) {
            new UniversalDialog.a().q(getString(R.string.quicksetup_ap_password_key_none)).u(getString(R.string.common_continue)).s(getString(R.string.action_cancel)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.g1
                @Override // com.tplink.iot.widget.UniversalDialog.c
                public final void a() {
                    CameraWifiListFragment.this.Q0(wifi);
                }
            }).l().show(getChildFragmentManager(), "");
        }
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_wifi_list;
    }

    /* renamed from: H0 */
    public CameraWifiListViewModel B0() {
        return (CameraWifiListViewModel) ViewModelProviders.of(this).get(CameraWifiListViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_bottom) {
            if (id == R.id.btn_other) {
                this.f8811f.e0("CameraManualInputPwdFragment.TAG", null);
                return;
            } else if (id != R.id.tv_rescan_wifi) {
                return;
            }
        }
        if (this.q.j.get()) {
            Bundle bundle = new Bundle();
            bundle.putString("rescan_op", "rescan");
            this.f8811f.e0("CameraWiredCompleteFragment.TAG", bundle);
            return;
        }
        this.f8811f.e0("CameraRescanWifiFragment.TAG", null);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        I0();
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f8811f.q0();
        ((FragmentCameraV2WifiListBinding) this.f8809c).x.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraWifiListFragment.this.O0(view2);
            }
        });
        d0.h(((FragmentCameraV2WifiListBinding) this.f8809c).z, getString(R.string.quicksetup_ap_can_not_find_wifi), ContextCompat.getColor(requireContext(), R.color.common_iot_purple), new a());
        J0();
    }
}
