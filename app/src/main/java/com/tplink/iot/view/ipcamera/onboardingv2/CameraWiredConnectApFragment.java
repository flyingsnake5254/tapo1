package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraWiredConnectApBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWiredConnectApViewModel;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

/* loaded from: classes2.dex */
public class CameraWiredConnectApFragment extends OnBoardingFragment<FragmentCameraWiredConnectApBinding, CameraWiredConnectApViewModel> {
    private CountDownTimer x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CameraWiredConnectApFragment.this.f8811f.e0("CameraWiredSetWirelessFailedFragment.TAG", null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    private void H0() {
        this.x = new a(60000L, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ void J0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool != null) {
            if (bool.booleanValue()) {
                f.D(this.q.B());
                ((CameraWiredConnectApViewModel) this.f8810d).g();
                return;
            }
            f.C(this.q.B());
            this.q.A().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(getString(R.string.camera_onboarding_network_unstable)));
            this.f8811f.e0("CameraInputPwdFragment.TAG", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Integer num = (Integer) aVar.a();
        if (num != null) {
            if (num.intValue() == 0) {
                f.x(this.q.B(), this.q.z());
                P0();
            } else if (num.intValue() < 0) {
                CountDownTimer countDownTimer = this.x;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                int intValue = num.intValue();
                int i = R.string.camera_onboarding_network_unstable;
                if (intValue == -3) {
                    i = R.string.camera_onboarding_not_get_ip;
                    f.w(this.q.B(), this.q.z());
                } else if (intValue == -2) {
                    i = R.string.onboarding_new_ipc_check_password;
                    f.z(this.q.B(), this.q.z());
                } else if (intValue == -1) {
                    f.v(this.q.B(), this.q.z());
                }
                this.q.A().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(getString(i)));
                this.f8811f.e0("CameraInputPwdFragment.TAG", null);
            } else {
                ((CameraWiredConnectApViewModel) this.f8810d).f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void O0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool != null) {
            if (bool.booleanValue()) {
                this.x.start();
                return;
            }
            this.q.A().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(getString(R.string.camera_onboarding_network_unstable)));
            this.f8811f.e0("CameraInputPwdFragment.TAG", null);
        }
    }

    private void P0() {
        CountDownTimer countDownTimer = this.x;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.q.d0.clear();
        this.f8811f.e0("CameraCompleteFragment.TAG", null);
    }

    private void Q0() {
        LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> H = this.q.H();
        if (H == null || H.getValue() == null || H.getValue().c() == null || !H.getValue().c().booleanValue()) {
            this.q.l();
        } else {
            ((CameraWiredConnectApViewModel) this.f8810d).g();
        }
    }

    private void R0() {
        ((FragmentCameraWiredConnectApBinding) this.f8809c).f6962f.setImageResource(c.e(this.q.D()));
    }

    private void S0() {
        this.q.H().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.k1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraWiredConnectApFragment.this.J0((a) obj);
            }
        });
        ((CameraWiredConnectApViewModel) this.f8810d).i().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.l1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraWiredConnectApFragment.this.L0((a) obj);
            }
        });
        ((CameraWiredConnectApViewModel) this.f8810d).h().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.j1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraWiredConnectApFragment.this.O0((a) obj);
            }
        });
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_wired_connect_ap;
    }

    /* renamed from: G0 */
    public CameraWiredConnectApViewModel B0() {
        return (CameraWiredConnectApViewModel) ViewModelProviders.of(this).get(CameraWiredConnectApViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_close && isAdded()) {
            this.q.o2(20001);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        R0();
        this.f8811f.q0();
        ((CameraWiredConnectApViewModel) this.f8810d).s(this.q);
        ((FragmentCameraWiredConnectApBinding) this.f8809c).q.e();
        H0();
        S0();
        Q0();
    }
}
