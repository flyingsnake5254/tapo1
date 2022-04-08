package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.databinding.FragmentSubgEnablePairingModeBinding;
import com.tplink.iot.f.a.a;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGCheckStatusViewModel;
import kotlin.jvm.b.l;
import kotlin.p;

/* loaded from: classes2.dex */
public class SubGEnablePairingModeFragment extends SubGBaseFragment<FragmentSubgEnablePairingModeBinding, SubGCheckStatusViewModel> {
    private void H0() {
        if (this.q.u() == SubDeviceModel.BUTTON_S200B) {
            ((FragmentSubgEnablePairingModeBinding) this.f9662c).f7095f.b(getViewLifecycleOwner(), new l() { // from class: com.tplink.iot.view.quicksetup.sub.b
                @Override // kotlin.jvm.b.l
                public final Object invoke(Object obj) {
                    return SubGEnablePairingModeFragment.this.J0((LottieAnimationView) obj);
                }
            });
        } else {
            ((FragmentSubgEnablePairingModeBinding) this.f9662c).f7095f.a(getViewLifecycleOwner(), this.q.z().l());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ p J0(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setImageAssetsFolder("images/s200b/");
        lottieAnimationView.setAnimation(R.raw.reset_button_s200b);
        a.a(lottieAnimationView, requireContext());
        return p.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0() {
        SubGLedNotBlinkingHelpFragment.V0(this.q.u()).show(getChildFragmentManager(), (String) null);
    }

    @Override // com.tplink.iot.view.quicksetup.sub.SubGBaseFragment
    public int B0() {
        return R.layout.fragment_subg_enable_pairing_mode;
    }

    /* renamed from: G0 */
    public SubGCheckStatusViewModel C0() {
        return (SubGCheckStatusViewModel) ViewModelProviders.of(this).get(SubGCheckStatusViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_next) {
            this.f9664f.e0("SubGSearchingDeviceFragment.TAG", null);
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        d0.h((TextView) view.findViewById(R.id.tv_bottom_tip), getString(R.string.subg_qs_led_is_not_blinking), ContextCompat.getColor(requireContext(), R.color.common_iot_purple), new d0.g() { // from class: com.tplink.iot.view.quicksetup.sub.c
            @Override // com.tplink.iot.Utils.d0.g
            public final void a() {
                SubGEnablePairingModeFragment.this.L0();
            }
        });
        ((FragmentSubgEnablePairingModeBinding) this.f9662c).z.setText(this.q.z().m());
    }
}
