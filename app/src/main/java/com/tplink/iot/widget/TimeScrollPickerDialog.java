package com.tplink.iot.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.tplink.iot.R;
import com.tplink.iot.widget.InnerTimePicker;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes3.dex */
public class TimeScrollPickerDialog extends AppCompatDialogFragment implements View.OnClickListener, InnerTimePicker.a {

    /* renamed from: c  reason: collision with root package name */
    private InnerTimePicker f11606c;

    /* renamed from: d  reason: collision with root package name */
    private a f11607d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f11608f;
    private boolean q = false;
    private int x;
    private boolean y;
    private int z;

    /* loaded from: classes3.dex */
    public interface a {
        void z0(TimeScrollPickerDialog timeScrollPickerDialog, int i);
    }

    public static TimeScrollPickerDialog A0(int i, boolean z, boolean z2, int i2) {
        TimeScrollPickerDialog timeScrollPickerDialog = new TimeScrollPickerDialog();
        Bundle bundle = new Bundle();
        bundle.putInt(RtspHeaders.Values.TIME, i);
        bundle.putBoolean("is_next_day_mode", z);
        bundle.putBoolean("is_start_time", z2);
        bundle.putInt("start_or_end_time", i2);
        timeScrollPickerDialog.setArguments(bundle);
        return timeScrollPickerDialog;
    }

    private void C0(int i) {
        if (!this.q) {
            return;
        }
        if (!this.y || this.z <= i) {
            this.f11608f.setVisibility(8);
        } else {
            this.f11608f.setVisibility(0);
        }
    }

    public void B0(a aVar) {
        this.f11607d = aVar;
    }

    @Override // com.tplink.iot.widget.InnerTimePicker.a
    public void m() {
        int minutesOfDay = this.f11606c.getMinutesOfDay();
        if (this.z == minutesOfDay) {
            this.f11606c.c(minutesOfDay + 1);
        }
        C0(this.f11606c.getMinutesOfDay());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            dismiss();
        } else if (id == R.id.tv_done) {
            if (this.f11607d != null) {
                int minutesOfDay = this.f11606c.getMinutesOfDay();
                if (this.q && minutesOfDay == this.z && (minutesOfDay = minutesOfDay + 1) == 1440) {
                    minutesOfDay = 0;
                }
                this.f11607d.z0(this, minutesOfDay);
            }
            dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (getArguments() != null) {
            this.x = getArguments().getInt(RtspHeaders.Values.TIME);
            boolean z = getArguments().getBoolean("is_next_day_mode", false);
            this.q = z;
            if (z) {
                this.y = getArguments().getBoolean("is_start_time");
                this.z = getArguments().getInt("start_or_end_time");
            }
        }
        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.common_dialog_time_picker, (ViewGroup) null);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        inflate.findViewById(R.id.tv_cancel).setOnClickListener(this);
        inflate.findViewById(R.id.tv_done).setOnClickListener(this);
        this.f11606c = (InnerTimePicker) inflate.findViewById(R.id.inner_time_picker);
        this.f11608f = (TextView) inflate.findViewById(R.id.tv_next_day);
        this.f11606c.setOnTimePickerChangeListener(this);
        this.f11606c.setMinuteOfDay(this.x);
        C0(this.x);
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
