package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraV2InputPwdBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.InputPwdViewModel;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

/* loaded from: classes2.dex */
public class CameraInputPwdFragment extends OnBoardingFragment<FragmentCameraV2InputPwdBinding, InputPwdViewModel> {
    private TPMaterialDialogV2 x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            CameraInputPwdFragment cameraInputPwdFragment = CameraInputPwdFragment.this;
            ((InputPwdViewModel) cameraInputPwdFragment.f8810d).a.set(!cameraInputPwdFragment.q.c0(charSequence.toString(), CameraInputPwdFragment.this.q.z() == null ? 1 : CameraInputPwdFragment.this.q.z().getAuth()));
        }
    }

    private void G0() {
        if (this.q.j.get()) {
            this.f8811f.e0("CameraWiredConnectApFragment.TAG", null);
        } else {
            this.f8811f.e0("CameraConnectApFragment.TAG", null);
        }
    }

    private void I0() {
        ((FragmentCameraV2InputPwdBinding) this.f8809c).f6881f.getEditText().addTextChangedListener(new a());
        if (this.q.z() != null && this.q.z().getAuth() == 0) {
            ((InputPwdViewModel) this.f8810d).a.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        String str = (String) aVar.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals(str, getString(R.string.camera_onboarding_network_unstable))) {
            R0();
        } else {
            s0.r(getActivity(), str, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0(View view) {
        this.f8811f.e0("CameraWifiListFragment.TAG", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0(View view) {
        ((InputPwdViewModel) this.f8810d).f();
        f.y(this.q.B(), this.q.f10407e.get(), this.q.z());
        G0();
    }

    private void Q0() {
        View inflate = LayoutInflater.from(requireActivity()).inflate(R.layout.layout_name_password, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.tv_ssid)).setText(this.q.a.get());
        ((TextView) inflate.findViewById(R.id.tv_password)).setText(this.q.f10404b.get());
        TPMaterialDialogV2 a2 = new TPMaterialDialogV2.Builder(requireActivity()).setView(inflate).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_next, R.color.common_iot_main_blue, new TPMaterialDialogV2.d() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.a0
            @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
            public final void onClick(View view) {
                CameraInputPwdFragment.this.P0(view);
            }
        }).g(8, 8).create();
        this.x = a2;
        a2.show();
    }

    private void R0() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_camera_onboarding_network_unstable, (ViewGroup) null);
        if (!this.q.k.get()) {
            inflate.findViewById(R.id.tv_wpa3).setVisibility(0);
        }
        new TPMaterialDialogV2.Builder(getContext()).setTitle(R.string.camera_onboarding_network_unstable_title).setView(inflate).g(8, 8).o(R.string.common_ok, R.color.common_iot_main_blue, null).show();
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_input_pwd;
    }

    /* renamed from: H0 */
    public InputPwdViewModel B0() {
        return (InputPwdViewModel) ViewModelProviders.of(this).get(InputPwdViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            Q0();
        } else if (id == R.id.tv_select) {
            this.f8811f.e0("CameraWifiListFragment.TAG", null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        I0();
        this.q.A().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.c0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraInputPwdFragment.this.K0((a) obj);
            }
        });
        CameraOnBoardingViewModel cameraOnBoardingViewModel = this.q;
        cameraOnBoardingViewModel.f10406d.set(cameraOnBoardingViewModel.z() != null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((InputPwdViewModel) this.f8810d).g(this.q);
        ((FragmentCameraV2InputPwdBinding) this.f8809c).x.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraInputPwdFragment.this.N0(view2);
            }
        });
    }
}
