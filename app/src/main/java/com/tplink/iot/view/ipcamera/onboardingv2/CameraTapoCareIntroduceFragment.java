package com.tplink.iot.view.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.databinding.FragmentCameraV2IntroduceTapoCareBinding;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraTapoCareIntroduceViewModel;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class CameraTapoCareIntroduceFragment extends OnBoardingFragment<FragmentCameraV2IntroduceTapoCareBinding, CameraTapoCareIntroduceViewModel> {

    /* loaded from: classes2.dex */
    class a implements g<DeviceCloudProduct> {
        a() {
        }

        /* renamed from: a */
        public void accept(DeviceCloudProduct deviceCloudProduct) throws Exception {
            CameraTapoCareIntroduceFragment cameraTapoCareIntroduceFragment = CameraTapoCareIntroduceFragment.this;
            ((FragmentCameraV2IntroduceTapoCareBinding) cameraTapoCareIntroduceFragment.f8809c).q.setVisibility(cameraTapoCareIntroduceFragment.q.S());
            CameraTapoCareIntroduceFragment cameraTapoCareIntroduceFragment2 = CameraTapoCareIntroduceFragment.this;
            ((FragmentCameraV2IntroduceTapoCareBinding) cameraTapoCareIntroduceFragment2.f8809c).f6901d.setVisibility(cameraTapoCareIntroduceFragment2.q.S());
            CameraTapoCareIntroduceFragment cameraTapoCareIntroduceFragment3 = CameraTapoCareIntroduceFragment.this;
            Button button = ((FragmentCameraV2IntroduceTapoCareBinding) cameraTapoCareIntroduceFragment3.f8809c).f6900c;
            int i = 8;
            if (cameraTapoCareIntroduceFragment3.q.S() == 8) {
                i = 0;
            }
            button.setVisibility(i);
        }
    }

    private void G0() {
        if (getActivity() != null) {
            startActivity(new Intent(getActivity(), MainActivity.class));
        }
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_introduce_tapo_care;
    }

    /* renamed from: H0 */
    public CameraTapoCareIntroduceViewModel B0() {
        return (CameraTapoCareIntroduceViewModel) ViewModelProviders.of(this).get(CameraTapoCareIntroduceViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_done /* 2131362055 */:
            case R.id.btn_exit /* 2131362058 */:
                G0();
                return;
            case R.id.btn_install_learn_more /* 2131362072 */:
                ((CameraTapoCareIntroduceViewModel) this.f8810d).f(getActivity());
                return;
            case R.id.btn_install_start_trial /* 2131362073 */:
                ((CameraTapoCareIntroduceViewModel) this.f8810d).g(getActivity(), this.q.B().getDeviceId());
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"CheckResult"})
    public void onResume() {
        super.onResume();
        this.q.r().G0(new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f8811f.q0();
        ((FragmentCameraV2IntroduceTapoCareBinding) this.f8809c).f6902f.setOnClickListener(this);
        ((FragmentCameraV2IntroduceTapoCareBinding) this.f8809c).f6902f.getPaint().setFlags(8);
        ((FragmentCameraV2IntroduceTapoCareBinding) this.f8809c).q.setOnClickListener(this);
        int i = 0;
        ((FragmentCameraV2IntroduceTapoCareBinding) this.f8809c).q.setText(String.format(getActivity().getString(R.string.tapo_care_cloud_stroage_trial_bt_V2), "30"));
        ((FragmentCameraV2IntroduceTapoCareBinding) this.f8809c).q.getPaint().setFlags(8);
        ((FragmentCameraV2IntroduceTapoCareBinding) this.f8809c).q.setVisibility(this.q.S());
        ((FragmentCameraV2IntroduceTapoCareBinding) this.f8809c).f6901d.setVisibility(this.q.S());
        Button button = ((FragmentCameraV2IntroduceTapoCareBinding) this.f8809c).f6900c;
        if (this.q.S() != 8) {
            i = 8;
        }
        button.setVisibility(i);
        ((FragmentCameraV2IntroduceTapoCareBinding) this.f8809c).f6901d.setOnClickListener(this);
        ((FragmentCameraV2IntroduceTapoCareBinding) this.f8809c).f6901d.getPaint().setFlags(8);
    }
}
