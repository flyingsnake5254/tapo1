package com.tplink.iot.view.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.databinding.FragmentCameraV2InstallGuideBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallGuideViewModel;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

/* loaded from: classes2.dex */
public class CameraInstallGuideFragment extends OnBoardingFragment<FragmentCameraV2InstallGuideBinding, CameraInstallGuideViewModel> {
    @SuppressLint({"SetTextI18n"})
    private void H0(DeviceModel deviceModel) {
        int i = 1;
        if (c.t(deviceModel) || c.u(deviceModel)) {
            while (i < 5) {
                View inflate = View.inflate(getContext(), R.layout.fragment_camera_v2_install_guide_item_layout, null);
                ((TextView) inflate.findViewById(R.id.install_guide_page_no)).setText("" + i);
                ((TextView) inflate.findViewById(R.id.tv_content)).setText(((CameraInstallGuideViewModel) this.f8810d).m(i, deviceModel));
                ((ImageView) inflate.findViewById(R.id.iv_content)).setImageResource(((CameraInstallGuideViewModel) this.f8810d).l(i, deviceModel));
                ((FragmentCameraV2InstallGuideBinding) this.f8809c).f6883d.addView(inflate);
                i++;
            }
        } else if (c.v(deviceModel)) {
            while (i < 4) {
                View inflate2 = View.inflate(getContext(), R.layout.fragment_camera_v2_install_guide_item_layout, null);
                ((TextView) inflate2.findViewById(R.id.install_guide_page_no)).setText("" + i);
                ((TextView) inflate2.findViewById(R.id.tv_content)).setText(((CameraInstallGuideViewModel) this.f8810d).m(i, deviceModel));
                ((ImageView) inflate2.findViewById(R.id.iv_content)).setImageResource(((CameraInstallGuideViewModel) this.f8810d).l(i, deviceModel));
                ((FragmentCameraV2InstallGuideBinding) this.f8809c).f6883d.addView(inflate2);
                i++;
            }
            View inflate3 = View.inflate(getContext(), R.layout.fragment_camera_v2_install_guide_waterproof_layout, null);
            TextView textView = (TextView) inflate3.findViewById(R.id.camera_install_watch_video);
            textView.getPaint().setFlags(8);
            textView.setOnClickListener(this);
            ((FragmentCameraV2InstallGuideBinding) this.f8809c).f6883d.addView(inflate3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ void J0(View view) {
        this.q.o2(20002);
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_v2_install_guide;
    }

    /* renamed from: G0 */
    public CameraInstallGuideViewModel B0() {
        return (CameraInstallGuideViewModel) ViewModelProviders.of(this).get(CameraInstallGuideViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.camera_install_watch_video) {
            t0.f(getActivity(), "saLrhG94Fmg");
        } else if (id == R.id.quit) {
            this.f8811f.e0("CameraCompleteFragment.TAG", null);
        } else if (id == R.id.view_camera_preview) {
            this.f8811f.e0("CameraInstallPreviewFragment.TAG", null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((FragmentCameraV2InstallGuideBinding) this.f8809c).q.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraInstallGuideFragment.this.J0(view2);
            }
        });
        H0(this.q.D());
        if (c.u(this.q.D())) {
            ((FragmentCameraV2InstallGuideBinding) this.f8809c).f6882c.setVisibility(0);
            ((FragmentCameraV2InstallGuideBinding) this.f8809c).f6882c.setText(R.string.camera_install_c210_pre_note);
        }
    }
}
