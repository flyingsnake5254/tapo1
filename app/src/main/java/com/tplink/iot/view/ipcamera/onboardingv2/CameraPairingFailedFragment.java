package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentCameraV2PairingFailedBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.PairingFailedViewModel;

/* loaded from: classes2.dex */
public class CameraPairingFailedFragment extends OnBoardingFragment<FragmentCameraV2PairingFailedBinding, PairingFailedViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(View view) {
        this.q.o2(20001);
    }

    private void J0() {
        ((FragmentCameraV2PairingFailedBinding) this.f8809c).q.setContent(getString(c.j(this.q.D(), this.q.F()), this.q.a.get()));
        ((FragmentCameraV2PairingFailedBinding) this.f8809c).x.setContent(getString(c.l(this.q.D(), this.q.F(), this.q.k.get())));
        ((FragmentCameraV2PairingFailedBinding) this.f8809c).y.setContent(getString(c.k(this.q.D(), this.q.F())));
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_pairing_failed;
    }

    /* renamed from: G0 */
    public PairingFailedViewModel B0() {
        return (PairingFailedViewModel) ViewModelProviders.of(this).get(PairingFailedViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_bottom) {
            this.f8811f.e0("CameraSearchAfterSetupFragment.TAG", null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d.a0(getActivity(), ((FragmentCameraV2PairingFailedBinding) this.f8809c).p0, this.q.D(), this.q.B());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f8811f.q0();
        J0();
        ((FragmentCameraV2PairingFailedBinding) this.f8809c).z.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraPairingFailedFragment.this.I0(view2);
            }
        });
    }
}
