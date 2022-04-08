package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.databinding.FragmentCameraV2CannotFindWifiBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraCannotWifiViewModel;

/* loaded from: classes2.dex */
public class CameraCannotFindFragment extends OnBoardingFragment<FragmentCameraV2CannotFindWifiBinding, CameraCannotWifiViewModel> {

    /* loaded from: classes2.dex */
    class a implements d0.g {
        a() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            CameraCannotFindFragment.this.f8811f.e0("CameraManualInputPwdFragment.TAG", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(View view) {
        this.q.o2(20002);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_cannot_find_wifi;
    }

    /* renamed from: G0 */
    public CameraCannotWifiViewModel B0() {
        return (CameraCannotWifiViewModel) ViewModelProviders.of(this).get(CameraCannotWifiViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((FragmentCameraV2CannotFindWifiBinding) this.f8809c).f6857f.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraCannotFindFragment.this.I0(view2);
            }
        });
        d0.d(getActivity(), ((FragmentCameraV2CannotFindWifiBinding) this.f8809c).q, R.string.quicksetup_ap_can_not_find_wifi_name, getString(R.string.quicksetup_ap_other), new a());
    }
}
