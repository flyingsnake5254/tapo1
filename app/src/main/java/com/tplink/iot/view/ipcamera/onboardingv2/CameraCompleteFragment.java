package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraV2CompleteBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraCompleteViewModel;

/* loaded from: classes2.dex */
public class CameraCompleteFragment extends OnBoardingFragment<FragmentCameraV2CompleteBinding, CameraCompleteViewModel> {
    private void G0() {
        if (!this.q.f0() || this.q.a0()) {
            this.f8811f.e0("CameraSdHintFragment.TAG", null);
        } else {
            this.f8811f.e0("CameraAutoUpdateHintFragment.TAG", null);
        }
    }

    private void I0() {
        f.a(this.q.B(), this.q.z());
    }

    private void J0() {
        f.n(this.q.B(), this.q.C(), this.q.f10405c.get(), this.q.j.get());
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_complete;
    }

    /* renamed from: H0 */
    public CameraCompleteViewModel B0() {
        return (CameraCompleteViewModel) ViewModelProviders.of(this).get(CameraCompleteViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_done) {
            G0();
        } else if (id == R.id.btn_install_guide) {
            this.f8811f.e0("CameraBeforeInstallFragment.TAG", null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f8811f.q0();
        ((FragmentCameraV2CompleteBinding) this.f8809c).f6863f.setImageResource(c.a(this.q.D()));
        if (!this.q.j.get()) {
            J0();
            I0();
        }
        ((FragmentCameraV2CompleteBinding) this.f8809c).f6862d.setVisibility(B0().f(this.q.D()));
        ((FragmentCameraV2CompleteBinding) this.f8809c).f6862d.getPaint().setFlags(8);
        this.q.p();
        this.q.r().F0();
    }
}
