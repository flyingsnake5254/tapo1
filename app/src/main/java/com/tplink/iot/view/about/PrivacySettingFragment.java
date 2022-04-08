package com.tplink.iot.view.about;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.model.about.c;
import com.tplink.iot.model.about.d;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class PrivacySettingFragment extends Fragment {
    @BindView
    TextView mJoinUserExperienceDescTv;
    @BindView
    TPSwitchCompat mJoinUserExperienceSwitch;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TPSwitchCompat.a {
        a() {
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a
        public void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                PrivacySettingFragment.this.C0(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements d0.g {
        b() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            PrivacySettingFragment.this.G0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void C0(final boolean z) {
        c.n(z).l(new g() { // from class: com.tplink.iot.view.about.f
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PrivacySettingFragment.this.J0((io.reactivex.e0.c) obj);
            }
        }).A(new io.reactivex.g0.a() { // from class: com.tplink.iot.view.about.g
            @Override // io.reactivex.g0.a
            public final void run() {
                PrivacySettingFragment.K0(z);
            }
        }, new g() { // from class: com.tplink.iot.view.about.e
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PrivacySettingFragment.this.N0(z, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        Intent intent = new Intent(getActivity(), AboutWebActivity.class);
        intent.putExtra("toolbar_title", getString(R.string.check_experience_improvement_sub_str));
        intent.putExtra("url", d.g());
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
    }

    private void H0() {
        this.mJoinUserExperienceSwitch.setChecked(c.f());
        this.mJoinUserExperienceSwitch.setOnSwitchCheckedChangeListener(new a());
        d0.e(this.mJoinUserExperienceDescTv, getString(R.string.join_user_experience_description, getString(R.string.join_user_experience_description_sub_str)), getString(R.string.join_user_experience_description_sub_str), getResources().getColor(R.color.common_iot_main_blue), new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ void J0(io.reactivex.e0.c cVar) throws Exception {
        s0.l(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void K0(boolean z) throws Exception {
        c.j(z);
        if (z) {
            c.d();
        } else {
            c.c();
        }
        s0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0(boolean z, Throwable th) throws Exception {
        this.mJoinUserExperienceSwitch.setChecked(!z);
        s0.p(getActivity(), getString(R.string.common_operation_failed));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_privacy_setting, viewGroup, false);
        ButterKnife.b(this, inflate);
        H0();
        return inflate;
    }
}
