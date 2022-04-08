package com.tplink.iot.devices.trv.view;

import android.view.View;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentTrvReplaceBatteryBinding;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import java.util.HashMap;

/* compiled from: TRVReplaceBatteryFragment.kt */
/* loaded from: classes2.dex */
public final class TRVReplaceBatteryFragment extends BaseBottomSheetDialog<FragmentTrvReplaceBatteryBinding> {
    private HashMap p1;

    /* compiled from: TRVReplaceBatteryFragment.kt */
    /* loaded from: classes2.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TRVReplaceBatteryFragment.this.dismissAllowingStateLoss();
        }
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public void A0() {
        HashMap hashMap = this.p1;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public int L0() {
        return R.layout.fragment_trv_replace_battery;
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public BottomSheetOptions P0() {
        return new BottomSheetOptions().fullscreen(true).topRoundCorner(true).skipCollapsed(true);
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public void Q0() {
        O0().f7133c.setOnClickListener(new a());
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        A0();
    }
}
