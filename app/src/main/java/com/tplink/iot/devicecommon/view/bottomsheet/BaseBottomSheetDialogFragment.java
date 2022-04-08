package com.tplink.iot.devicecommon.view.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public abstract class BaseBottomSheetDialogFragment extends BottomSheetDialogFragment {
    protected abstract int A0();

    protected abstract void B0(View view);

    public void C0() {
        dismissAllowingStateLoss();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(bundle);
        View inflate = View.inflate(getContext(), A0(), null);
        bottomSheetDialog.setContentView(inflate);
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.findViewById(R.id.design_bottom_sheet).setBackgroundColor(0);
            window.setWindowAnimations(R.style.CustomBottomSheetDialogAnimation);
        }
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        int i = getResources().getDisplayMetrics().heightPixels;
        layoutParams.height = i;
        inflate.setLayoutParams(layoutParams);
        BottomSheetBehavior<FrameLayout> behavior = bottomSheetDialog.getBehavior();
        behavior.setPeekHeight(i);
        behavior.setSkipCollapsed(true);
        behavior.setState(3);
        B0(inflate);
        return bottomSheetDialog;
    }
}
