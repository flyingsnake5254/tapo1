package com.tplink.iot.view.ipcamera.play;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.tplink.iot.R;
import java.util.HashMap;
import kotlin.jvm.internal.j;

/* compiled from: CameraUpdatingDialogFragment.kt */
/* loaded from: classes2.dex */
public final class CameraUpdatingDialogFragment extends AppCompatDialogFragment {

    /* renamed from: c  reason: collision with root package name */
    private final Handler f8868c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f8869d = new a();

    /* renamed from: f  reason: collision with root package name */
    private HashMap f8870f;

    /* compiled from: CameraUpdatingDialogFragment.kt */
    /* loaded from: classes2.dex */
    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            CameraUpdatingDialogFragment.this.dismissAllowingStateLoss();
        }
    }

    public void A0() {
        HashMap hashMap = this.f8870f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.CameraUpdatingDialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        return inflater.inflate(R.layout.dialog_camera_updating, viewGroup, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        A0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        Window window2;
        WindowManager.LayoutParams attributes;
        super.onStart();
        Dialog dialog = getDialog();
        if (!(dialog == null || (window2 = dialog.getWindow()) == null || (attributes = window2.getAttributes()) == null)) {
            attributes.dimAmount = 0.0f;
        }
        Dialog dialog2 = getDialog();
        if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
            window.addFlags(2);
        }
        this.f8868c.removeCallbacks(this.f8869d);
        this.f8868c.postDelayed(this.f8869d, 1250L);
    }
}
