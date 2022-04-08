package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraV2SearchAfterSetupBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSearchAfterSetupViewModel;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class CameraSearchAfterSetupFragment extends OnBoardingFragment<FragmentCameraV2SearchAfterSetupBinding, CameraSearchAfterSetupViewModel> {
    private CountDownTimer x;
    private boolean y = false;
    private boolean z = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CameraSearchAfterSetupFragment.this.q.q2();
            CameraSearchAfterSetupFragment.this.f8811f.e0("CameraPairingFailedFragment.TAG", null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            CameraSearchAfterSetupFragment.this.q.v();
        }
    }

    private void H0() {
        this.x = new a(60000L, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ void J0(Boolean bool) throws Exception {
        O0();
        CountDownTimer countDownTimer = this.x;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool != null) {
            b.d.w.c.a.e("CameraSearchAfterSetupFragment.TAG", "IsFindDevice = " + bool);
            if (bool.booleanValue()) {
                this.q.z.removeObservers(this);
                f.h(this.q.B(), this.q.z());
                this.q.q2();
                if (this.q.j.get()) {
                    this.f8811f.e0("CameraSdHintFragment.TAG", null);
                } else if (this.q.a0()) {
                    this.f8811f.e0("CameraCompleteFragment.TAG", null);
                } else {
                    this.f8811f.e0("CameraSetNameFragment.TAG", null);
                }
                N0();
            }
        }
    }

    private void O0() {
        if (!this.z) {
            this.z = true;
            this.q.W1();
        }
    }

    private void P0() {
        ((FragmentCameraV2SearchAfterSetupBinding) this.f8809c).f6947f.setImageResource(c.e(this.q.D()));
    }

    private void Q0() {
        this.q.n2(10003);
        this.q.d0.clear();
        this.q.z.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.a1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraSearchAfterSetupFragment.this.L0((a) obj);
            }
        });
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_search_after_setup;
    }

    /* renamed from: G0 */
    public CameraSearchAfterSetupViewModel B0() {
        return (CameraSearchAfterSetupViewModel) ViewModelProviders.of(this).get(CameraSearchAfterSetupViewModel.class);
    }

    public void N0() {
        this.q.j();
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_close && isAdded()) {
            this.q.o2(20001);
        }
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((FragmentCameraV2SearchAfterSetupBinding) this.f8809c).q.f();
        this.q.q2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.q.O1().E(new g() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.z0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraSearchAfterSetupFragment.this.J0((Boolean) obj);
            }
        }).F0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        CountDownTimer countDownTimer = this.x;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        P0();
        this.f8811f.q0();
        ((FragmentCameraV2SearchAfterSetupBinding) this.f8809c).q.e();
        H0();
        Q0();
    }
}
