package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentCameraV2BeforeInstallBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraBeforeInstallViewModel;

/* loaded from: classes2.dex */
public class CameraBeforeInstallFragment extends OnBoardingFragment<FragmentCameraV2BeforeInstallBinding, CameraBeforeInstallViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(View view) {
        this.q.o2(20002);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_before_install;
    }

    /* renamed from: G0 */
    public CameraBeforeInstallViewModel B0() {
        return (CameraBeforeInstallViewModel) ViewModelProviders.of(this).get(CameraBeforeInstallViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_next) {
            this.f8811f.e0("CameraInstallGuideFragment.TAG", null);
        } else if (id == R.id.quit) {
            this.f8811f.e0("CameraCompleteFragment.TAG", null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((FragmentCameraV2BeforeInstallBinding) this.f8809c).x.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraBeforeInstallFragment.this.I0(view2);
            }
        });
        if (c.v(this.q.D())) {
            ((FragmentCameraV2BeforeInstallBinding) this.f8809c).z.setVisibility(0);
        }
    }
}
