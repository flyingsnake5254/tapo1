package com.tplink.iot.widget.dialog;

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

/* loaded from: classes3.dex */
public class LightEffectTimeDialog extends AppCompatDialogFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private float f11806c;

    /* renamed from: d  reason: collision with root package name */
    private int f11807d = 1;

    /* renamed from: f  reason: collision with root package name */
    private a f11808f;
    private NumberPickerView q;

    /* loaded from: classes3.dex */
    public interface a {
        void j0(int i);
    }

    public static LightEffectTimeDialog A0(long j) {
        LightEffectTimeDialog lightEffectTimeDialog = new LightEffectTimeDialog();
        Bundle bundle = new Bundle();
        bundle.putLong("tag_current_time", j);
        lightEffectTimeDialog.setArguments(bundle);
        return lightEffectTimeDialog;
    }

    public void B0(a aVar) {
        this.f11808f = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NumberPickerView numberPickerView;
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            dismiss();
        } else if (id == R.id.tv_done) {
            if (!(this.f11808f == null || (numberPickerView = this.q) == null)) {
                this.f11808f.j0(numberPickerView.getValue() + 1);
            }
            dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            float f2 = (float) arguments.getLong("tag_current_time", 2L);
            this.f11806c = f2;
            if (f2 >= 1.0f && f2 <= 3.0f) {
                this.f11807d = (int) ((f2 - 1.0f) % 3.0f);
            }
        }
        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_light_effect_choose_time, (ViewGroup) null);
        dialog.setContentView(inflate);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        this.q = (NumberPickerView) inflate.findViewById(R.id.time_picker);
        inflate.findViewById(R.id.tv_cancel).setOnClickListener(this);
        inflate.findViewById(R.id.tv_done).setOnClickListener(this);
        this.q.S(h.e());
        this.q.setValue(this.f11807d);
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
