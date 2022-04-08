package com.tplink.iot.view.quicksetup.switches;

import android.os.Bundle;
import android.view.View;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentSubgSwitchHowToInstallBinding;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import java.util.HashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: SubGSwitchInstallGuideFragment.kt */
/* loaded from: classes2.dex */
public final class SubGSwitchInstallGuideFragment extends BaseBottomSheetDialog<FragmentSubgSwitchHowToInstallBinding> {
    public static final a p1 = new a(null);
    private String p2 = "";
    private HashMap p3;

    /* compiled from: SubGSwitchInstallGuideFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final SubGSwitchInstallGuideFragment a(String deviceModel) {
            j.e(deviceModel, "deviceModel");
            SubGSwitchInstallGuideFragment subGSwitchInstallGuideFragment = new SubGSwitchInstallGuideFragment();
            Bundle bundle = new Bundle();
            bundle.putString("DeviceModel", deviceModel);
            p pVar = p.a;
            subGSwitchInstallGuideFragment.setArguments(bundle);
            return subGSwitchInstallGuideFragment;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SubGSwitchInstallGuideFragment.kt */
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SubGSwitchInstallGuideFragment.this.dismiss();
        }
    }

    public static final SubGSwitchInstallGuideFragment U0(String str) {
        return p1.a(str);
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public void A0() {
        HashMap hashMap = this.p3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public int L0() {
        return R.layout.fragment_subg_switch_how_to_install;
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public BottomSheetOptions P0() {
        return new BottomSheetOptions().fullscreen(true).noDim(true).topRoundCorner(false);
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public void Q0() {
        O0().f7105c.setOnClickListener(new b());
        String str = this.p2;
        int hashCode = str.hashCode();
        if (hashCode != 2522270) {
            if (hashCode == 2522301 && str.equals("S220")) {
                O0().f7106d.setImageResource(R.mipmap.switch_install_step_7_s220);
            }
        } else if (str.equals("S210")) {
            O0().f7106d.setImageResource(R.mipmap.switch_install_step_7_s210);
        }
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("DeviceModel")) == null) {
            str = "";
        }
        this.p2 = str;
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        A0();
    }
}
