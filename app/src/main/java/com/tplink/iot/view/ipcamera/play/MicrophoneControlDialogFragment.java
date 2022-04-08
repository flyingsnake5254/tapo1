package com.tplink.iot.view.ipcamera.play;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import b.d.w.f.a;
import com.google.android.material.badge.BadgeDrawable;
import com.tplink.iot.R;
import com.tplink.iot.databinding.DialogMicrophoneControlBinding;

/* loaded from: classes2.dex */
public class MicrophoneControlDialogFragment extends CameraAudioDialogFragment {
    private DialogMicrophoneControlBinding I3;
    private ObservableBoolean J3 = new ObservableBoolean(true);

    public static MicrophoneControlDialogFragment S0(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isFullScreen", z);
        MicrophoneControlDialogFragment microphoneControlDialogFragment = new MicrophoneControlDialogFragment();
        microphoneControlDialogFragment.setArguments(bundle);
        return microphoneControlDialogFragment;
    }

    @Override // com.tplink.iot.view.ipcamera.play.CameraAudioDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.I3.i(this.p2);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    @SuppressLint({"ClickableViewAccessibility"})
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        DialogMicrophoneControlBinding dialogMicrophoneControlBinding = (DialogMicrophoneControlBinding) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_microphone_control, viewGroup, false);
        this.I3 = dialogMicrophoneControlBinding;
        dialogMicrophoneControlBinding.h(this.J3);
        getDialog().requestWindowFeature(1);
        R0(this.I3.f6789c);
        this.I3.f6791f.setOnTouchListener(this.H3);
        return this.I3.getRoot();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            Context context = window.getContext();
            window.setBackgroundDrawable(new ColorDrawable(Integer.MIN_VALUE));
            window.setDimAmount(0.0f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = BadgeDrawable.TOP_START;
            attributes.width = a.a(context, 240.0f);
            int a = a.a(context, 72.0f);
            attributes.height = a;
            attributes.x = this.p0 - attributes.width;
            int i = this.z;
            if (i == -1) {
                attributes.y = this.p1 - a;
            } else {
                attributes.y = i;
            }
            window.setAttributes(attributes);
        }
    }
}
