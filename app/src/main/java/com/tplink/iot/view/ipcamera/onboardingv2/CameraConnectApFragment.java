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
import com.tplink.iot.Utils.y;
import com.tplink.iot.databinding.FragmentCameraV2ConnectApBinding;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraConnectApViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

/* loaded from: classes2.dex */
public class CameraConnectApFragment extends OnBoardingFragment<FragmentCameraV2ConnectApBinding, CameraConnectApViewModel> implements AutoRefreshTimer.a {
    private CountDownTimer x;
    private AutoRefreshTimer y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            f.u(CameraConnectApFragment.this.q.B(), CameraConnectApFragment.this.q.z());
            CameraConnectApFragment.this.R0();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    private void H0() {
        if (this.q.V()) {
            AutoRefreshTimer autoRefreshTimer = new AutoRefreshTimer(0L, 3000L, this);
            this.y = autoRefreshTimer;
            autoRefreshTimer.a(this);
        }
    }

    private void J0() {
        this.x = new a(60000L, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool != null) {
            if (bool.booleanValue()) {
                f.D(this.q.B());
                ((CameraConnectApViewModel) this.f8810d).g();
                return;
            }
            f.C(this.q.B());
            this.q.A().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(getString(R.string.camera_onboarding_network_unstable)));
            this.f8811f.e0("CameraInputPwdFragment.TAG", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void O0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Integer num = (Integer) aVar.a();
        if (num != null) {
            if (num.intValue() == 0) {
                f.x(this.q.B(), this.q.z());
                R0();
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
                ((CameraConnectApViewModel) this.f8810d).f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ void Q0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        AutoRefreshTimer autoRefreshTimer = this.y;
        if (autoRefreshTimer != null) {
            autoRefreshTimer.cancel();
        }
        CountDownTimer countDownTimer = this.x;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.q.d0.clear();
        this.f8811f.e0("CameraConnectToPairFragment.TAG", null);
    }

    private void S0() {
        LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> H = this.q.H();
        if (H == null || H.getValue() == null || H.getValue().c() == null || !H.getValue().c().booleanValue()) {
            this.q.l();
        } else {
            ((CameraConnectApViewModel) this.f8810d).g();
        }
    }

    private void T0() {
        ((FragmentCameraV2ConnectApBinding) this.f8809c).f6869f.setImageResource(c.e(this.q.D()));
    }

    private void U0() {
        this.q.H().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraConnectApFragment.this.L0((a) obj);
            }
        });
        ((CameraConnectApViewModel) this.f8810d).i().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraConnectApFragment.this.O0((a) obj);
            }
        });
        ((CameraConnectApViewModel) this.f8810d).h().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraConnectApFragment.this.Q0((a) obj);
            }
        });
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_connect_ap;
    }

    /* renamed from: I0 */
    public CameraConnectApViewModel B0() {
        return (CameraConnectApViewModel) ViewModelProviders.of(this).get(CameraConnectApViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.AutoRefreshTimer.a
    public void h() {
        if (this.q.V()) {
            CameraOnBoardingViewModel cameraOnBoardingViewModel = this.q;
            if (!cameraOnBoardingViewModel.Y(cameraOnBoardingViewModel.Q())) {
                y.b(this.q.Q(), null, null);
            }
        }
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
        H0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        T0();
        this.f8811f.q0();
        ((CameraConnectApViewModel) this.f8810d).s(this.q);
        ((FragmentCameraV2ConnectApBinding) this.f8809c).q.e();
        J0();
        U0();
        S0();
    }
}
