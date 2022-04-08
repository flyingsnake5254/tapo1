package com.tplink.iot.widget.bottomsheet.dialog;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.R;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: BaseBottomSheetDialog.kt */
/* loaded from: classes3.dex */
public abstract class BaseBottomSheetDialog<VDB extends ViewDataBinding> extends BottomSheetDialogFragment {

    /* renamed from: c  reason: collision with root package name */
    public static final a f11641c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    protected VDB f11642d;

    /* renamed from: f  reason: collision with root package name */
    protected BottomSheetBehavior<FrameLayout> f11643f;
    private HashMap p0;
    private FrameLayout q;
    private boolean x;
    private BottomSheetOptions y = new BottomSheetOptions();
    private final List<Runnable> z = new ArrayList();

    /* compiled from: BaseBottomSheetDialog.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final void H0(BottomSheetDialog bottomSheetDialog, BottomSheetOptions bottomSheetOptions) {
        if (bottomSheetOptions != null) {
            setCancelable(bottomSheetOptions.getCancelable());
            BottomSheetBehavior<FrameLayout> behavior = bottomSheetDialog.getBehavior();
            behavior.setHideable(bottomSheetOptions.getHideable());
            behavior.setSkipCollapsed(bottomSheetOptions.getSkipCollapsed());
            if (bottomSheetOptions.getTopSpacedPixels() != 0) {
                R0(bottomSheetDialog, bottomSheetOptions.getTopSpacedPixels());
            } else if (bottomSheetOptions.getFullscreen()) {
                T0(bottomSheetDialog);
            }
        }
    }

    private final void R0(BottomSheetDialog bottomSheetDialog, int i) {
        ViewGroup.LayoutParams layoutParams;
        Resources resources = getResources();
        j.d(resources, "resources");
        int i2 = resources.getDisplayMetrics().heightPixels - i;
        FrameLayout K0 = K0(bottomSheetDialog);
        if (!(K0 == null || (layoutParams = K0.getLayoutParams()) == null)) {
            layoutParams.height = i2;
        }
        BottomSheetBehavior<FrameLayout> behavior = bottomSheetDialog.getBehavior();
        behavior.setPeekHeight(i2);
        behavior.setHideable(false);
    }

    private final void S0() {
        this.x = true;
        if (true ^ this.z.isEmpty()) {
            for (Runnable runnable : this.z) {
                runnable.run();
            }
        }
        this.z.clear();
    }

    private final void T0(BottomSheetDialog bottomSheetDialog) {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout K0 = K0(bottomSheetDialog);
        if (!(K0 == null || (layoutParams = K0.getLayoutParams()) == null)) {
            layoutParams.height = -1;
        }
        bottomSheetDialog.getBehavior().setState(3);
    }

    public void A0() {
        HashMap hashMap = this.p0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void G0(BottomSheetBehavior<FrameLayout> behavior) {
        j.e(behavior, "behavior");
    }

    public void I0(BottomSheetDialog dialog) {
        j.e(dialog, "dialog");
    }

    public void J0(FrameLayout frameLayout) {
    }

    protected final FrameLayout K0(BottomSheetDialog dialog) {
        j.e(dialog, "dialog");
        return (FrameLayout) dialog.findViewById(R.id.design_bottom_sheet);
    }

    @LayoutRes
    public abstract int L0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final BottomSheetBehavior<FrameLayout> N0() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f11643f;
        if (bottomSheetBehavior == null) {
            j.t("mBehavior");
        }
        return bottomSheetBehavior;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final VDB O0() {
        VDB vdb = this.f11642d;
        if (vdb == null) {
            j.t("mBinding");
        }
        return vdb;
    }

    public BottomSheetOptions P0() {
        return this.y;
    }

    public abstract void Q0();

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        BottomSheetOptions P0 = P0();
        if (P0 == null) {
            return R.style.CustomBottomSheetDialog;
        }
        if (P0.getNoDim() && P0.getTopRoundCorner()) {
            return 2132017409;
        }
        if (P0.getNoDim()) {
            return 2132017408;
        }
        if (P0.getTopRoundCorner()) {
            return 2132017410;
        }
        return R.style.CustomBottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.y = BottomSheetOptions.Companion.a(getArguments());
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        VDB vdb = (VDB) DataBindingUtil.inflate(LayoutInflater.from(requireContext()), L0(), null, false);
        j.d(vdb, "DataBindingUtil.inflate(…tLayoutId(), null, false)");
        this.f11642d = vdb;
        Q0();
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), getTheme());
        VDB vdb2 = this.f11642d;
        if (vdb2 == null) {
            j.t("mBinding");
        }
        bottomSheetDialog.setContentView(vdb2.getRoot());
        BottomSheetBehavior<FrameLayout> behavior = bottomSheetDialog.getBehavior();
        j.d(behavior, "behavior");
        this.f11643f = behavior;
        this.q = K0(bottomSheetDialog);
        H0(bottomSheetDialog, P0());
        I0(bottomSheetDialog);
        J0(this.q);
        BottomSheetBehavior<FrameLayout> behavior2 = bottomSheetDialog.getBehavior();
        j.d(behavior2, "behavior");
        G0(behavior2);
        S0();
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        A0();
    }
}
