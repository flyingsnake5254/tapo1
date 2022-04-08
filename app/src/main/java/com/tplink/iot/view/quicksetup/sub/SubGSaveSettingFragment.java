package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentSubGSaveSettingBinding;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGSaveSettingViewModel;

@Deprecated
/* loaded from: classes2.dex */
public class SubGSaveSettingFragment extends SubGBaseFragment<FragmentSubGSaveSettingBinding, SubGSaveSettingViewModel> {
    private Handler x = new Handler();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> aVar) {
            Boolean a = aVar.a();
            if (a != null) {
                if (a.booleanValue()) {
                    SubGSaveSettingFragment.this.f9664f.e0("SubGCompleteFragment.TAG", null);
                    return;
                }
                SubGSaveSettingFragment.this.q.q.set(SubGSaveSettingFragment.this.q.q.get() + 1);
                SubGSaveSettingFragment.this.q.t.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
                SubGSaveSettingFragment.this.f9664f.e0("SubGSetupAvatarFragment.TAG", null);
            }
        }
    }

    private void G0() {
        ((FragmentSubGSaveSettingBinding) this.f9662c).q.f();
    }

    private void I0() {
        this.q.v.observe(this, new a());
    }

    @Override // com.tplink.iot.view.quicksetup.sub.SubGBaseFragment
    public int B0() {
        return R.layout.fragment_sub_g_save_setting;
    }

    /* renamed from: H0 */
    public SubGSaveSettingViewModel C0() {
        return (SubGSaveSettingViewModel) ViewModelProviders.of(this).get(SubGSaveSettingViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_close && isAdded()) {
            this.q.E0(20001);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.x.removeCallbacksAndMessages(null);
        G0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f9664f.q0();
        ((FragmentSubGSaveSettingBinding) this.f9662c).q.e();
        I0();
    }
}
