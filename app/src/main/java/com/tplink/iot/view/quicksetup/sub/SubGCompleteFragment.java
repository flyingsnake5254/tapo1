package com.tplink.iot.view.quicksetup.sub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentSubGCompleteBinding;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.switches.SubGSwitchInstallGuideFragment;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGCompleteViewModel;

/* loaded from: classes2.dex */
public class SubGCompleteFragment extends SubGBaseFragment<FragmentSubGCompleteBinding, SubGCompleteViewModel> {
    private void H0() {
        FragmentActivity activity;
        if (isAdded() && (activity = getActivity()) != null) {
            Intent intent = new Intent(activity, MainActivity.class);
            intent.addFlags(67108864);
            startActivity(intent);
            activity.overridePendingTransition(R.anim.translate_between_interface_bottom_in, R.anim.translate_between_interface_bottom_out);
        }
    }

    private void I0() {
        SubGSwitchInstallGuideFragment.U0(this.q.u().value()).show(getChildFragmentManager(), (String) null);
    }

    private void J0() {
        if (this.q.u() == SubDeviceModel.SWITCH_S220 || this.q.u() == SubDeviceModel.SWITCH_S210) {
            ((FragmentSubGCompleteBinding) this.f9662c).f7060c.setVisibility(0);
        }
    }

    @Override // com.tplink.iot.view.quicksetup.sub.SubGBaseFragment
    public int B0() {
        return R.layout.fragment_sub_g_complete;
    }

    /* renamed from: G0 */
    public SubGCompleteViewModel C0() {
        return (SubGCompleteViewModel) ViewModelProviders.of(this).get(SubGCompleteViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_install_switch) {
            I0();
        } else if (id == R.id.quicksetup_done) {
            H0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((FragmentSubGCompleteBinding) this.f9662c).f7061d.setImageResource(this.q.z().o());
        this.f9664f.q0();
        J0();
    }
}
