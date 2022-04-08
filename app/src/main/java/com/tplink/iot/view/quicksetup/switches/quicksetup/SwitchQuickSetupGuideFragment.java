package com.tplink.iot.view.quicksetup.switches.quicksetup;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.databinding.FragmentSwitchQuicksetupGuideBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: SwitchQuickSetupGuideFragment.kt */
/* loaded from: classes2.dex */
public final class SwitchQuickSetupGuideFragment extends SwitchQuickSetupBaseFragment<FragmentSwitchQuicksetupGuideBinding> {
    public static final a p3 = new a(null);
    private HashMap H3;

    /* compiled from: SwitchQuickSetupGuideFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final void Q0() {
        if (L0() == SwitchButton.FIRST) {
            O0().E0(20001);
        } else {
            O0().E0(20002);
        }
    }

    @DrawableRes
    private final int R0() {
        int i = a.a[L0().ordinal()];
        if (i == 1) {
            return R.mipmap.iot_switch_left_button;
        }
        if (i == 2) {
            return R.mipmap.iot_switch_right_button;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void S0() {
        z1 N0 = N0();
        if (N0 != null) {
            N0.e0("SwitchQuickSetupNameFragment", SwitchQuickSetupBaseFragment.q.a(L0()));
        }
    }

    @Override // com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment
    public void H0() {
        HashMap hashMap = this.H3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment
    public int J0() {
        return R.layout.fragment_switch_quicksetup_guide;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        P0().U(O0().r());
        P0().O(O0().t());
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View v) {
        j.e(v, "v");
        int id = v.getId();
        if (id == R.id.btn_bottom) {
            S0();
        } else if (id == R.id.img_close) {
            Q0();
        }
    }

    @Override // com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        if (L0() == SwitchButton.FIRST) {
            z1 N0 = N0();
            if (N0 != null) {
                N0.q0();
            }
        } else {
            K0().f7109d.setImageResource(R.mipmap.back);
            ImageView imageView = K0().f7109d;
            j.d(imageView, "mBinding.imgClose");
            i.l(imageView);
            TextView textView = K0().x;
            j.d(textView, "mBinding.tvTitle");
            i.k(textView);
            K0().q.setText(R.string.switch_qs_guide_desc_right_v2);
        }
        K0().f7110f.setImageResource(R0());
    }
}
