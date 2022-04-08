package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentCameraV2IdentifyBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraIdentifyViewModel;

/* loaded from: classes2.dex */
public class CameraIdentifyFragment extends OnBoardingFragment<FragmentCameraV2IdentifyBinding, CameraIdentifyViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(View view) {
        this.q.o2(20002);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_identify;
    }

    /* renamed from: G0 */
    public CameraIdentifyViewModel B0() {
        return (CameraIdentifyViewModel) ViewModelProviders.of(this).get(CameraIdentifyViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((FragmentCameraV2IdentifyBinding) this.f8809c).f6876c.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraIdentifyFragment.this.I0(view2);
            }
        });
    }
}
