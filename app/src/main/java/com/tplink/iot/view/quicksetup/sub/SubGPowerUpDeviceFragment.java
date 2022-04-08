package com.tplink.iot.view.quicksetup.sub;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentSubgPowerUpDeviceBinding;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGGuideFirstViewModel;

/* loaded from: classes2.dex */
public class SubGPowerUpDeviceFragment extends SubGBaseFragment<FragmentSubgPowerUpDeviceBinding, SubGGuideFirstViewModel> {
    private void H0() {
        ((FragmentSubgPowerUpDeviceBinding) this.f9662c).f7101f.setImageResource(this.q.z().e());
        Drawable drawable = ((FragmentSubgPowerUpDeviceBinding) this.f9662c).f7101f.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    private void I0() {
        ((FragmentSubgPowerUpDeviceBinding) this.f9662c).y.setText(this.q.z().n());
    }

    @Override // com.tplink.iot.view.quicksetup.sub.SubGBaseFragment
    public int B0() {
        return R.layout.fragment_subg_power_up_device;
    }

    /* renamed from: G0 */
    public SubGGuideFirstViewModel C0() {
        return (SubGGuideFirstViewModel) ViewModelProviders.of(this).get(SubGGuideFirstViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_next) {
            this.f9664f.e0("SubGCheckStatusFragment.TAG", null);
        } else if (id == R.id.img_back) {
            this.q.E0(20002);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        H0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Drawable drawable = ((FragmentSubgPowerUpDeviceBinding) this.f9662c).f7101f.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        I0();
    }
}
