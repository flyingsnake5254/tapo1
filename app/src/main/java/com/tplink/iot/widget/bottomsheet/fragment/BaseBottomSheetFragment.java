package com.tplink.iot.widget.bottomsheet.fragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
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
import java.util.HashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: BaseBottomSheetFragment.kt */
/* loaded from: classes3.dex */
public abstract class BaseBottomSheetFragment<VDB extends ViewDataBinding> extends BottomSheetDialogFragment {

    /* renamed from: c  reason: collision with root package name */
    public static final a f11644c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private VDB f11645d;

    /* renamed from: f  reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f11646f;
    private FrameLayout q;
    private BottomSheetOptions x;
    private HashMap y;

    /* compiled from: BaseBottomSheetFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final void C0(BottomSheetOptions bottomSheetOptions) {
        if (bottomSheetOptions != null) {
            setCancelable(bottomSheetOptions.getCancelable());
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f11646f;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(bottomSheetOptions.getHideable());
                bottomSheetBehavior.setSkipCollapsed(bottomSheetOptions.getSkipCollapsed());
            }
            if (bottomSheetOptions.getTopSpacedPixels() != 0) {
                O0(bottomSheetOptions.getTopSpacedPixels());
            } else if (bottomSheetOptions.getFullscreen()) {
                R0();
            }
        }
    }

    private final void H0() {
        if (this.f11646f == null && getShowsDialog()) {
            Dialog dialog = getDialog();
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = null;
            if (!(dialog instanceof BottomSheetDialog)) {
                dialog = null;
            }
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
            if (bottomSheetDialog != null) {
                bottomSheetBehavior = bottomSheetDialog.getBehavior();
            }
            this.f11646f = bottomSheetBehavior;
        }
    }

    private final void I0() {
        if (this.q == null) {
            FrameLayout frameLayout = null;
            if (getShowsDialog()) {
                Dialog dialog = getDialog();
                if (dialog != null) {
                    frameLayout = (FrameLayout) dialog.findViewById(R.id.design_bottom_sheet);
                }
            } else {
                View view = getView();
                ViewParent parent = view != null ? view.getParent() : null;
                if (parent instanceof FrameLayout) {
                    frameLayout = parent;
                }
                frameLayout = frameLayout;
            }
            this.q = frameLayout;
        }
    }

    private final void O0(int i) {
        Resources resources = getResources();
        j.d(resources, "resources");
        int i2 = resources.getDisplayMetrics().heightPixels - i;
        if (getShowsDialog()) {
            P0(i2);
        } else {
            Q0(i2);
        }
    }

    private final void P0(int i) {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout frameLayout = this.q;
        if (!(frameLayout == null || (layoutParams = frameLayout.getLayoutParams()) == null)) {
            layoutParams.height = i;
        }
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f11646f;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight(i);
            bottomSheetBehavior.setHideable(false);
        }
    }

    private final void Q0(int i) {
        ViewGroup.LayoutParams layoutParams;
        View view = getView();
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.height = i;
        }
    }

    private final void R0() {
        if (getShowsDialog()) {
            S0();
        } else {
            T0();
        }
    }

    private final void S0() {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout frameLayout = this.q;
        if (!(frameLayout == null || (layoutParams = frameLayout.getLayoutParams()) == null)) {
            layoutParams.height = -1;
        }
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f11646f;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    private final void T0() {
        ViewGroup.LayoutParams layoutParams;
        View view = getView();
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.height = -1;
        }
    }

    public void A0() {
        HashMap hashMap = this.y;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void B0(BottomSheetBehavior<FrameLayout> behavior) {
        j.e(behavior, "behavior");
    }

    public void G0(FrameLayout frameLayout) {
    }

    @LayoutRes
    public abstract int J0();

    protected final VDB K0() {
        VDB vdb = this.f11645d;
        j.c(vdb);
        return vdb;
    }

    public BottomSheetOptions L0() {
        return this.x;
    }

    public abstract void N0();

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        BottomSheetOptions L0 = L0();
        if (L0 == null) {
            return R.style.CustomBottomSheetDialog;
        }
        if (L0.getNoDim() && L0.getTopRoundCorner()) {
            return 2132017409;
        }
        if (L0.getNoDim()) {
            return 2132017408;
        }
        if (L0.getTopRoundCorner()) {
            return 2132017410;
        }
        return R.style.CustomBottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        I0();
        H0();
        C0(L0());
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f11646f;
        if (bottomSheetBehavior != null) {
            B0(bottomSheetBehavior);
        }
        G0(this.q);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.x = BottomSheetOptions.Companion.a(getArguments());
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), getTheme());
        this.f11646f = bottomSheetDialog.getBehavior();
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(inflater, "inflater");
        this.f11645d = (VDB) DataBindingUtil.inflate(inflater, J0(), viewGroup, false);
        return K0().getRoot();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f11645d = null;
        A0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        K0().setLifecycleOwner(getViewLifecycleOwner());
        N0();
    }
}
