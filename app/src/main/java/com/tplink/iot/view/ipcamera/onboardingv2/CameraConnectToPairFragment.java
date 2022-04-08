package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraV2ConnectToPairBinding;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraConnectToPairViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.UniversalDialog;

/* loaded from: classes2.dex */
public class CameraConnectToPairFragment extends OnBoardingFragment<FragmentCameraV2ConnectToPairBinding, CameraConnectToPairViewModel> implements AutoRefreshTimer.a {
    private AutoRefreshTimer x;

    /* loaded from: classes2.dex */
    class a implements d0.g {
        a() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            CameraConnectToPairFragment.this.Q0();
        }
    }

    private void H0() {
        if (this.q.V()) {
            AutoRefreshTimer autoRefreshTimer = new AutoRefreshTimer(0L, 2000L, this);
            this.x = autoRefreshTimer;
            autoRefreshTimer.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0() {
        this.f8811f.e0("CameraSearchAfterSetupFragment.TAG", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0() {
        this.f8811f.e0("CameraSearchAfterSetupFragment.TAG", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0() {
        f.J(this.q.B());
        requireActivity().runOnUiThread(new Runnable() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.m
            @Override // java.lang.Runnable
            public final void run() {
                CameraConnectToPairFragment.this.K0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        if (!this.q.V()) {
            f.t(this.q.B());
            this.f8811f.e0("CameraSearchAfterSetupFragment.TAG", null);
        }
        CameraOnBoardingViewModel cameraOnBoardingViewModel = this.q;
        if (!cameraOnBoardingViewModel.Y(cameraOnBoardingViewModel.a.get())) {
            R0(this.q.a.get());
        }
    }

    private void R0(String str) {
        if (isAdded()) {
            UniversalDialog l = new UniversalDialog.a().q(getString(R.string.camera_onboarding_confirm_ssid, str)).u(getString(R.string.common_continue)).s(getString(R.string.action_cancel)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.o
                @Override // com.tplink.iot.widget.UniversalDialog.c
                public final void a() {
                    CameraConnectToPairFragment.this.P0();
                }
            }).l();
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            beginTransaction.add(l, "");
            beginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_connect_to_pair;
    }

    /* renamed from: I0 */
    public CameraConnectToPairViewModel B0() {
        return (CameraConnectToPairViewModel) ViewModelProviders.of(this).get(CameraConnectToPairViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.AutoRefreshTimer.a
    public void h() {
        if (this.q.V()) {
            CameraOnBoardingViewModel cameraOnBoardingViewModel = this.q;
            if (cameraOnBoardingViewModel.Y(cameraOnBoardingViewModel.a.get())) {
                requireActivity().runOnUiThread(new Runnable() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraConnectToPairFragment.this.N0();
                    }
                });
            }
        }
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_back && isAdded()) {
            this.q.o2(20001);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        H0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        String str = this.q.a.get();
        TextView textView = ((FragmentCameraV2ConnectToPairBinding) this.f8809c).x;
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        textView.setText(getString(R.string.quicksetup_settings_and_connect, objArr));
        d0.h(((FragmentCameraV2ConnectToPairBinding) this.f8809c).q, getString(R.string.quicksetup_already_connected), ContextCompat.getColor(requireContext(), R.color.common_iot_purple), new a());
    }
}
