package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentDialogGetLostBinding;
import com.tplink.iot.view.ipcamera.base.g;

/* loaded from: classes2.dex */
public class GetLostDialogFragment extends DialogFragment implements g {

    /* renamed from: c  reason: collision with root package name */
    private String f8805c;

    /* renamed from: d  reason: collision with root package name */
    private FragmentDialogGetLostBinding f8806d;

    /* renamed from: f  reason: collision with root package name */
    private View.OnClickListener f8807f;
    private View.OnClickListener q;
    private Dialog x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnKeyListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return i == 4;
        }
    }

    private void G0() {
        if (getDialog() != null) {
            getDialog().setOnKeyListener(new a());
        }
    }

    void A0() {
        dismiss();
        startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }

    protected void B0() {
        if (getArguments() != null) {
            this.f8805c = getArguments().getString("soft_ap_wifi_SSID");
        } else {
            this.f8805c = "";
        }
    }

    protected void C0() {
        Dialog dialog = getDialog();
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.fragment_dialog_get_lost);
        this.f8806d.x.setText(this.f8805c);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.onBoarding_get_lost_goto_wifi_settings_tv) {
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            A0();
        } else if (id == R.id.onBoarding_get_lost_try_agin_tv) {
            dismiss();
            this.f8807f.onClick(view);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Dialog dialog = getDialog();
        this.x = dialog;
        if (dialog != null) {
            if (dialog.getWindow() != null) {
                this.x.getWindow().requestFeature(1);
            }
            this.x.setCanceledOnTouchOutside(false);
            this.x.setCancelable(false);
        }
        FragmentDialogGetLostBinding fragmentDialogGetLostBinding = (FragmentDialogGetLostBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_dialog_get_lost, viewGroup, false);
        this.f8806d = fragmentDialogGetLostBinding;
        fragmentDialogGetLostBinding.h(this);
        G0();
        return this.f8806d.getRoot();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        B0();
        C0();
    }
}
