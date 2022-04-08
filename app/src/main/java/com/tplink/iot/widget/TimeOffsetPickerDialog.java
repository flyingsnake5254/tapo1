package com.tplink.iot.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.tplink.iot.R;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes3.dex */
public class TimeOffsetPickerDialog extends AppCompatDialogFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private InnerTimeOffsetPicker f11604c;

    /* renamed from: d  reason: collision with root package name */
    private a f11605d;

    /* loaded from: classes3.dex */
    public interface a {
        void F0(TimeOffsetPickerDialog timeOffsetPickerDialog, int i);
    }

    public static TimeOffsetPickerDialog A0(int i, boolean z) {
        TimeOffsetPickerDialog timeOffsetPickerDialog = new TimeOffsetPickerDialog();
        Bundle bundle = new Bundle();
        bundle.putInt(RtspHeaders.Values.TIME, i);
        bundle.putBoolean("isAnHourPicker", z);
        timeOffsetPickerDialog.setArguments(bundle);
        return timeOffsetPickerDialog;
    }

    public void B0(a aVar) {
        this.f11605d = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            dismiss();
        } else if (id == R.id.tv_done) {
            a aVar = this.f11605d;
            if (aVar != null) {
                aVar.F0(this, this.f11604c.getTimeOffset());
            }
            dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int i;
        boolean z;
        if (getArguments() != null) {
            i = getArguments().getInt(RtspHeaders.Values.TIME);
            z = getArguments().getBoolean("isAnHourPicker");
        } else {
            i = 0;
            z = false;
        }
        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_common_time_offset_picker, (ViewGroup) null);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        inflate.findViewById(R.id.tv_cancel).setOnClickListener(this);
        inflate.findViewById(R.id.tv_done).setOnClickListener(this);
        InnerTimeOffsetPicker innerTimeOffsetPicker = (InnerTimeOffsetPicker) inflate.findViewById(R.id.time_offset_picker);
        this.f11604c = innerTimeOffsetPicker;
        innerTimeOffsetPicker.a(i, z);
        Window window = dialog.getWindow();
        if (!(window == null || window.getAttributes() == null)) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        window.setGravity(80);
        window.setWindowAnimations(R.style.BottomDialog);
        return dialog;
    }
}
