package com.tplink.iot.view.quicksetup.sub;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentSubgLedNotBlinkingHelpBinding;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.iot.view.quicksetup.sub.common.g;
import com.tplink.iot.widget.PointTextView;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: SubGLedNotBlinkingHelpFragment.kt */
/* loaded from: classes2.dex */
public final class SubGLedNotBlinkingHelpFragment extends BaseBottomSheetDialog<FragmentSubgLedNotBlinkingHelpBinding> {
    public static final a p1 = new a(null);
    private SubDeviceModel p2 = SubDeviceModel.SENSOR_OTHER;
    private HashMap p3;

    /* compiled from: SubGLedNotBlinkingHelpFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final SubGLedNotBlinkingHelpFragment a(SubDeviceModel deviceModel) {
            j.e(deviceModel, "deviceModel");
            SubGLedNotBlinkingHelpFragment subGLedNotBlinkingHelpFragment = new SubGLedNotBlinkingHelpFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("SubDeviceModel", deviceModel);
            p pVar = p.a;
            subGLedNotBlinkingHelpFragment.setArguments(bundle);
            return subGLedNotBlinkingHelpFragment;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SubGLedNotBlinkingHelpFragment.kt */
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SubGLedNotBlinkingHelpFragment.this.dismiss();
        }
    }

    /* compiled from: SubGLedNotBlinkingHelpFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements l<LottieAnimationView, p> {
        c() {
            super(1);
        }

        public final void a(LottieAnimationView it) {
            j.e(it, "it");
            it.setImageAssetsFolder("images/s200b/");
            it.setAnimation(R.raw.reset_button_s200b);
            Context requireContext = SubGLedNotBlinkingHelpFragment.this.requireContext();
            j.d(requireContext, "requireContext()");
            com.tplink.iot.f.a.a.c(it, requireContext, false, 2, null);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ p invoke(LottieAnimationView lottieAnimationView) {
            a(lottieAnimationView);
            return p.a;
        }
    }

    private final void U0() {
        int i = r.a[this.p2.ordinal()];
        if (i == 1 || i == 2) {
            O0().y.setContent(getString(R.string.switch_check_battery_end));
            O0().z.setContent(getString(R.string.switch_check_battery_charged));
            PointTextView pointTextView = O0().p0;
            pointTextView.setVisibility(0);
            pointTextView.setContent(getString(R.string.switch_reset_and_set_up_again));
        } else if (i == 3) {
            O0().y.setContent(getString(R.string.switch_check_battery_end));
            O0().z.setContent(getString(R.string.switch_check_battery_charged));
            PointTextView pointTextView2 = O0().p0;
            pointTextView2.setVisibility(0);
            pointTextView2.setContent(getString(R.string.switch_reset_and_set_up_again));
        }
    }

    public static final SubGLedNotBlinkingHelpFragment V0(SubDeviceModel subDeviceModel) {
        return p1.a(subDeviceModel);
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
        return R.layout.fragment_subg_led_not_blinking_help;
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public BottomSheetOptions P0() {
        return new BottomSheetOptions().fullscreen(true).noDim(true).topRoundCorner(false);
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public void Q0() {
        O0().f7096c.setOnClickListener(new b());
        e a2 = g.a(this.p2);
        TextView textView = O0().x;
        j.d(textView, "mBinding.tvResetHint");
        textView.setText(a2.c());
        U0();
        if (this.p2 == SubDeviceModel.BUTTON_S200B) {
            O0().f7097d.b(this, new c());
        } else {
            O0().f7097d.a(this, a2.d());
        }
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        SubDeviceModel subDeviceModel = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("SubDeviceModel") : null;
        if (serializable instanceof SubDeviceModel) {
            subDeviceModel = serializable;
        }
        SubDeviceModel subDeviceModel2 = subDeviceModel;
        if (subDeviceModel2 == null) {
            subDeviceModel2 = SubDeviceModel.SENSOR_OTHER;
        }
        this.p2 = subDeviceModel2;
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        A0();
    }
}
