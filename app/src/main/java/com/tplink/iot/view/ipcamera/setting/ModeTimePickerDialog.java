package com.tplink.iot.view.ipcamera.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.tplink.iot.R;
import com.tplink.iot.widget.CustomTimePicker;

/* loaded from: classes2.dex */
public class ModeTimePickerDialog extends DialogFragment {

    /* renamed from: c  reason: collision with root package name */
    String f9113c;

    /* renamed from: d  reason: collision with root package name */
    int f9114d;

    /* renamed from: f  reason: collision with root package name */
    int f9115f;
    boolean q;
    @BindView
    TextView startOrEndTv;
    @BindView
    CustomTimePicker timePicker;
    private Unbinder x;
    a y;

    /* loaded from: classes2.dex */
    public interface a {
        void n(int i, int i2, boolean z);
    }

    protected View A0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_time_picker, viewGroup);
    }

    protected void B0() {
    }

    protected void C0() {
        this.startOrEndTv.setText(this.f9113c);
        this.timePicker.setCurrentHour(this.f9114d);
        this.timePicker.setCurrentMinute(this.f9115f);
    }

    @OnClick
    public void onCancelClick() {
        dismiss();
    }

    @OnClick
    public void onConfirmClick() {
        dismiss();
        a aVar = this.y;
        if (aVar != null) {
            aVar.n(this.timePicker.getCurrentHour(), this.timePicker.getCurrentMinute(), this.q);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        return A0(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.x.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.x = ButterKnife.b(this, view);
        B0();
        C0();
    }
}
