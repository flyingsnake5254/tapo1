package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentSubGNoFoundBinding;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGNoFoundViewModel;
import kotlin.jvm.b.l;
import kotlin.p;

/* loaded from: classes2.dex */
public class SubGNoFoundFragment extends SubGBaseFragment<FragmentSubGNoFoundBinding, SubGNoFoundViewModel> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SubDeviceModel.values().length];
            a = iArr;
            try {
                iArr[SubDeviceModel.SWITCH_S220.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SubDeviceModel.SWITCH_S210.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SubDeviceModel.TRV_E100.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void G0() {
        int i = a.a[this.q.u().ordinal()];
        if (i == 1 || i == 2) {
            ((FragmentSubGNoFoundBinding) this.f9662c).p0.setContent(getString(R.string.switch_check_battery_end));
            ((FragmentSubGNoFoundBinding) this.f9662c).p1.setContent(getString(R.string.switch_check_battery_charged));
            ((FragmentSubGNoFoundBinding) this.f9662c).p2.setContent(getString(R.string.subg_qs_no_found_move_closer_to_hub));
            ((FragmentSubGNoFoundBinding) this.f9662c).p3.setContent(getString(R.string.subg_qs_no_found_ensure_hub_led_blink_blue));
            ((FragmentSubGNoFoundBinding) this.f9662c).H3.setContent(getString(R.string.switch_reset_and_set_up_again));
            ((FragmentSubGNoFoundBinding) this.f9662c).H3.setVisibility(0);
        } else if (i == 3) {
            ((FragmentSubGNoFoundBinding) this.f9662c).p0.setContent(getString(R.string.switch_check_battery_end));
            ((FragmentSubGNoFoundBinding) this.f9662c).p1.setContent(getString(R.string.switch_check_battery_charged));
            ((FragmentSubGNoFoundBinding) this.f9662c).p2.setContent(getString(R.string.subg_qs_no_found_move_closer_to_hub));
            ((FragmentSubGNoFoundBinding) this.f9662c).p3.setContent(getString(R.string.subg_qs_no_found_ensure_hub_led_blink_blue));
            ((FragmentSubGNoFoundBinding) this.f9662c).H3.setContent(getString(R.string.switch_reset_and_set_up_again));
            ((FragmentSubGNoFoundBinding) this.f9662c).H3.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ p J0(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setImageAssetsFolder("images/s200b/");
        lottieAnimationView.setAnimation(R.raw.reset_button_s200b);
        com.tplink.iot.f.a.a.a(lottieAnimationView, requireContext());
        return p.a;
    }

    @Override // com.tplink.iot.view.quicksetup.sub.SubGBaseFragment
    public int B0() {
        return R.layout.fragment_sub_g_no_found;
    }

    /* renamed from: H0 */
    public SubGNoFoundViewModel C0() {
        return (SubGNoFoundViewModel) ViewModelProviders.of(this).get(SubGNoFoundViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_try_again) {
            this.f9664f.e0("SubGSearchingDeviceFragment.TAG", null);
        } else if (id == R.id.img_close) {
            this.q.E0(20001);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f9664f.q0();
        d.c0(getActivity(), ((FragmentSubGNoFoundBinding) this.f9662c).y, this.q.u().value());
        ((FragmentSubGNoFoundBinding) this.f9662c).z.setText(this.q.z().c());
        G0();
        if (this.q.u() == SubDeviceModel.BUTTON_S200B) {
            ((FragmentSubGNoFoundBinding) this.f9662c).q.b(getViewLifecycleOwner(), new l() { // from class: com.tplink.iot.view.quicksetup.sub.j
                @Override // kotlin.jvm.b.l
                public final Object invoke(Object obj) {
                    return SubGNoFoundFragment.this.J0((LottieAnimationView) obj);
                }
            });
        } else {
            ((FragmentSubGNoFoundBinding) this.f9662c).q.a(getViewLifecycleOwner(), this.q.z().d());
        }
    }
}
