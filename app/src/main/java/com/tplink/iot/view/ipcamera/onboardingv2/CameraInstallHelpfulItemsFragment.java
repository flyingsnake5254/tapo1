package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentCameraV2InstallHelpfulItemsBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallHelpfulItemsViewModel;

/* loaded from: classes2.dex */
public class CameraInstallHelpfulItemsFragment extends OnBoardingFragment<FragmentCameraV2InstallHelpfulItemsBinding, CameraInstallHelpfulItemsViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(View view) {
        this.q.o2(20002);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_install_helpful_items;
    }

    /* renamed from: G0 */
    public CameraInstallHelpfulItemsViewModel B0() {
        return (CameraInstallHelpfulItemsViewModel) ViewModelProviders.of(this).get(CameraInstallHelpfulItemsViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.quit) {
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
        ((FragmentCameraV2InstallHelpfulItemsBinding) this.f8809c).f6893f.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraInstallHelpfulItemsFragment.this.I0(view2);
            }
        });
    }
}
