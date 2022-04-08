package com.tplink.iot.view.ipcamera.onboardingv2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.Utils.y;
import com.tplink.iot.databinding.FragmentCameraV2CheckStatusBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.quicksetup.base.wifi.d;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CheckStatusViewModel;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpwifi.b;

/* loaded from: classes2.dex */
public class CameraCheckStatusFragment extends OnBoardingFragment<FragmentCameraV2CheckStatusBinding, CheckStatusViewModel> {
    private BroadcastReceiver x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                    CameraCheckStatusFragment.this.Q0();
                }
            } catch (Exception e2) {
                b.d.w.c.a.e("OnBoardingActivity", "Exception: " + e2.toString());
            }
        }
    }

    private void I0() {
        ((FragmentCameraV2CheckStatusBinding) this.f8809c).f6858c.setImageResource(c.c(this.q.D()));
        Drawable drawable = ((FragmentCameraV2CheckStatusBinding) this.f8809c).f6858c.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    private void J0() {
        this.x = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        if (getActivity() != null) {
            getActivity().registerReceiver(this.x, intentFilter);
        }
    }

    private void K0() {
        if (DeviceModel.CAMERA_C310.equals(this.q.D()) || DeviceModel.CAMERA_TC65.equals(this.q.D())) {
            ((FragmentCameraV2CheckStatusBinding) this.f8809c).p0.setText(R.string.camera_onboarding_check_status_unplug_router_note);
        } else {
            ((FragmentCameraV2CheckStatusBinding) this.f8809c).p0.setText(R.string.quicksetup_keep_phone_close_device);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0() {
        this.f8811f.e0("CameraResetFragment.TAG", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0(View view) {
        this.q.o2(20002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        if (((FragmentCameraV2CheckStatusBinding) this.f8809c).q.b()) {
            ((FragmentCameraV2CheckStatusBinding) this.f8809c).q.h();
            this.q.h.clear();
            this.q.h.addAll(((CheckStatusViewModel) this.f8810d).f(b.k().m().getScanResults()));
            if (((CheckStatusViewModel) this.f8810d).a.get() <= 0) {
                this.f8811f.e0("CameraInstructionFragment.TAG", null);
            } else if (((CheckStatusViewModel) this.f8810d).a.get() == 1) {
                CameraOnBoardingViewModel cameraOnBoardingViewModel = this.q;
                cameraOnBoardingViewModel.m2(cameraOnBoardingViewModel.h.get(0).SSID);
                y.a(this.q.Q(), null, null);
                this.f8811f.e0("CameraConnectingFragment.TAG", null);
            } else {
                this.f8811f.e0("CameraSSIDListFragment.TAG", null);
            }
        }
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_check_status;
    }

    /* renamed from: H0 */
    public CheckStatusViewModel B0() {
        return (CheckStatusViewModel) ViewModelProviders.of(this).get(CheckStatusViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.quicksetup_introduce_commmon_next) {
            boolean c2 = o.h0().c("has_refused_location_permission", false);
            if (d.a(getActivity())) {
                this.q.i2(true);
                f.j();
                b.k().s();
                return;
            }
            f.i();
            if (c2) {
                this.q.i2(false);
                this.f8811f.e0("CameraInstructionFragment.TAG", null);
                return;
            }
            ((FragmentCameraV2CheckStatusBinding) this.f8809c).q.h();
            this.f8811f.e0("CameraLocationPermissionFragment.TAG", null);
        }
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        J0();
        return onCreateView;
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (getActivity() != null && this.x != null) {
            getActivity().unregisterReceiver(this.x);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        I0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Drawable drawable = ((FragmentCameraV2CheckStatusBinding) this.f8809c).f6858c.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        d0.h(((FragmentCameraV2CheckStatusBinding) this.f8809c).z, getString(R.string.onboarding_new_ipc_check_led_blinking), ContextCompat.getColor(requireActivity(), R.color.common_iot_purple), new d0.g() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.e
            @Override // com.tplink.iot.Utils.d0.g
            public final void a() {
                CameraCheckStatusFragment.this.N0();
            }
        });
        ((FragmentCameraV2CheckStatusBinding) this.f8809c).y.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraCheckStatusFragment.this.P0(view2);
            }
        });
        this.q.S1();
        K0();
    }
}
