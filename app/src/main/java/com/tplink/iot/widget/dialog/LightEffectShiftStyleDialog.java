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
import com.tplink.iot.core.AppContext;
import com.tplink.iot.widget.NumberPickerView;

/* loaded from: classes3.dex */
public class LightEffectShiftStyleDialog extends AppCompatDialogFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f11803c = {AppContext.f6185c.getString(R.string.scene_shift_type_direct), AppContext.f6185c.getString(R.string.scene_shift_type_breath)};

    /* renamed from: d  reason: collision with root package name */
    private int f11804d = 1;

    /* renamed from: f  reason: collision with root package name */
    private a f11805f;
    private NumberPickerView q;

    /* loaded from: classes3.dex */
    public interface a {
        void u0(int i);
    }

    public static LightEffectShiftStyleDialog A0(int i) {
        LightEffectShiftStyleDialog lightEffectShiftStyleDialog = new LightEffectShiftStyleDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("tag_current_type", i);
        lightEffectShiftStyleDialog.setArguments(bundle);
        return lightEffectShiftStyleDialog;
    }

    public void B0(a aVar) {
        this.f11805f = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NumberPickerView numberPickerView;
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            dismiss();
        } else if (id == R.id.tv_done) {
            a aVar = this.f11805f;
            if (!(aVar == null || (numberPickerView = this.q) == null)) {
                aVar.u0(numberPickerView.getValue());
            }
            dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt("tag_current_type", 0);
            this.f11804d = i;
            this.f11804d = i % 2;
        }
        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_light_effect_choose_shift_style, (ViewGroup) null);
        dialog.setContentView(inflate);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        this.q = (NumberPickerView) inflate.findViewById(R.id.time_picker);
        inflate.findViewById(R.id.tv_cancel).setOnClickListener(this);
        inflate.findViewById(R.id.tv_done).setOnClickListener(this);
        this.q.S(f11803c);
        this.q.setValue(this.f11804d);
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
