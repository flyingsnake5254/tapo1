package com.tplink.iot.view.ipcamera.setting.firmware;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.tplink.iot.R;
import com.tplink.iot.widget.NumberPickerView;
import com.tplink.iot.widget.h;

/* loaded from: classes2.dex */
public class AutoUpdateTimePickerDialog extends AppCompatDialogFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private float f9231c;

    /* renamed from: d  reason: collision with root package name */
    private int f9232d = 2;

    /* renamed from: f  reason: collision with root package name */
    private a f9233f;
    private NumberPickerView q;

    /* loaded from: classes2.dex */
    public interface a {
        void v(int i);
    }

    public static AutoUpdateTimePickerDialog A0(int i) {
        AutoUpdateTimePickerDialog autoUpdateTimePickerDialog = new AutoUpdateTimePickerDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("tag_current_time", i);
        autoUpdateTimePickerDialog.setArguments(bundle);
        return autoUpdateTimePickerDialog;
    }

    public void B0(a aVar) {
        this.f9233f = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NumberPickerView numberPickerView;
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            dismiss();
        } else if (id == R.id.tv_done) {
            if (!(this.f9233f == null || (numberPickerView = this.q) == null)) {
                this.f9233f.v(numberPickerView.getValue());
            }
            dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            float f2 = arguments.getInt("tag_current_time", 180);
            this.f9231c = f2;
            this.f9232d = (int) ((f2 / 60.0f) % 24.0f);
        }
        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_firmware_auto_update_time_picker, (ViewGroup) null);
        dialog.setContentView(inflate);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        this.q = (NumberPickerView) inflate.findViewById(R.id.time_picker);
        inflate.findViewById(R.id.tv_cancel).setOnClickListener(this);
        inflate.findViewById(R.id.tv_done).setOnClickListener(this);
        this.q.S(h.d());
        this.q.setValue(this.f9232d);
        Window window = dialog.getWindow();
        if (!(window == null || window.getAttributes() == null)) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        window.setGravity(80);
        window.setWindowAnimations(R.style.AnimationBottomStyle);
        return dialog;
    }
}
