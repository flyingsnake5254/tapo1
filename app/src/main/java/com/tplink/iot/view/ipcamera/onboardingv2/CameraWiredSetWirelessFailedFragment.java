package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.databinding.FragmentCameraWiredSetWirelessFailedBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWiredSetWirelessFailedViewModel;

/* loaded from: classes2.dex */
public class CameraWiredSetWirelessFailedFragment extends OnBoardingFragment<FragmentCameraWiredSetWirelessFailedBinding, CameraWiredSetWirelessFailedViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(View view) {
        this.q.o2(20001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0() {
        this.f8811f.e0("CameraSdHintFragment.TAG", null);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_wired_set_wireless_failed;
    }

    /* renamed from: G0 */
    public CameraWiredSetWirelessFailedViewModel B0() {
        return (CameraWiredSetWirelessFailedViewModel) ViewModelProviders.of(this).get(CameraWiredSetWirelessFailedViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_bottom) {
            this.f8811f.e0("CameraWiredConnectApFragment.TAG", null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f8811f.q0();
        ((FragmentCameraWiredSetWirelessFailedBinding) this.f8809c).y.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraWiredSetWirelessFailedFragment.this.I0(view2);
            }
        });
        d0.h(((FragmentCameraWiredSetWirelessFailedBinding) this.f8809c).z, getString(R.string.camera_onboarding_wired_skip_wireless), ContextCompat.getColor(requireContext(), R.color.common_iot_purple), new d0.g() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.v1
            @Override // com.tplink.iot.Utils.d0.g
            public final void a() {
                CameraWiredSetWirelessFailedFragment.this.K0();
            }
        });
    }
}
