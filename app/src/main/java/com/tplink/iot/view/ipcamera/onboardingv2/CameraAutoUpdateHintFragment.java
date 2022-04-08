package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentCameraAutoUpdateHintBinding;
import com.tplink.iot.view.ipcamera.setting.firmware.AutoUpdateTimePickerDialog;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraAutoUpdateHintViewModel;
import com.tplink.iot.widget.h;

/* loaded from: classes2.dex */
public class CameraAutoUpdateHintFragment extends OnBoardingFragment<FragmentCameraAutoUpdateHintBinding, CameraAutoUpdateHintViewModel> {
    private AutoUpdateTimePickerDialog x;
    private int y = 180;
    private String[] z = h.d();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(int i) {
        this.y = i * 60;
        ((FragmentCameraAutoUpdateHintBinding) this.f8809c).f6837c.setText(this.z[i]);
    }

    private void J0() {
        AutoUpdateTimePickerDialog autoUpdateTimePickerDialog = this.x;
        if (autoUpdateTimePickerDialog == null || !autoUpdateTimePickerDialog.isVisible()) {
            AutoUpdateTimePickerDialog A0 = AutoUpdateTimePickerDialog.A0(this.y);
            this.x = A0;
            A0.B0(new AutoUpdateTimePickerDialog.a() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.a
                @Override // com.tplink.iot.view.ipcamera.setting.firmware.AutoUpdateTimePickerDialog.a
                public final void v(int i) {
                    CameraAutoUpdateHintFragment.this.I0(i);
                }
            });
            this.x.show(getParentFragmentManager(), (String) null);
        }
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_auto_update_hint;
    }

    /* renamed from: G0 */
    public CameraAutoUpdateHintViewModel B0() {
        return (CameraAutoUpdateHintViewModel) ViewModelProviders.of(this).get(CameraAutoUpdateHintViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.auto_update_time) {
            J0();
        } else if (id == R.id.btn_got_it) {
            this.q.a2(this.y);
            this.f8811f.e0("CameraSdHintFragment.TAG", null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f8811f.q0();
    }
}
