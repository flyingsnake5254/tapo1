package com.tplink.iot.view.ipcamera.play;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.badge.BadgeDrawable;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ViewCloudTerraceControlSensitivityPanelBinding;
import com.tplink.libtpnetwork.Utils.j;

/* loaded from: classes2.dex */
public class CloudTerraceSensitivityDialogFragment extends DialogFragment {

    /* renamed from: c  reason: collision with root package name */
    public static final String f8898c = CloudTerraceSensitivityDialogFragment.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    ViewCloudTerraceControlSensitivityPanelBinding f8900f;
    private View.OnTouchListener q;
    private a z;

    /* renamed from: d  reason: collision with root package name */
    public final MutableLiveData<Integer> f8899d = new MutableLiveData<>();
    private int x = -1;
    private int y = -1;

    /* loaded from: classes2.dex */
    public interface a {
        int c();

        void d(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void C0(View view) {
        this.f8899d.setValue(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0 */
    public /* synthetic */ void H0(View view) {
        this.f8899d.setValue(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ void J0(View view) {
        this.f8899d.setValue(100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0(SeekBar seekBar) {
        int progress = seekBar.getProgress();
        if (progress > 66 && !j.b(this.f8899d, Integer.valueOf(progress))) {
            this.f8899d.setValue(100);
        } else if (progress > 33 && !j.b(this.f8899d, Integer.valueOf(progress))) {
            this.f8899d.setValue(50);
        } else if (!j.b(this.f8899d, Integer.valueOf(progress))) {
            this.f8899d.setValue(0);
        }
    }

    public static CloudTerraceSensitivityDialogFragment N0() {
        return new CloudTerraceSensitivityDialogFragment();
    }

    public void A0(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.y = iArr[0] + i + view.getWidth();
        this.x = iArr[1] + i2;
    }

    public void O0(View.OnTouchListener onTouchListener) {
        this.q = onTouchListener;
        ViewCloudTerraceControlSensitivityPanelBinding viewCloudTerraceControlSensitivityPanelBinding = this.f8900f;
        if (viewCloudTerraceControlSensitivityPanelBinding != null) {
            viewCloudTerraceControlSensitivityPanelBinding.f7346c.setDispatchEventListener(onTouchListener);
        }
    }

    public void P0(a aVar) {
        this.z = aVar;
        this.f8899d.setValue(Integer.valueOf(aVar.c()));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewCloudTerraceControlSensitivityPanelBinding viewCloudTerraceControlSensitivityPanelBinding = (ViewCloudTerraceControlSensitivityPanelBinding) DataBindingUtil.inflate(layoutInflater, R.layout.view_cloud_terrace_control_sensitivity_panel, viewGroup, true);
        this.f8900f = viewCloudTerraceControlSensitivityPanelBinding;
        if (viewCloudTerraceControlSensitivityPanelBinding == null) {
            return null;
        }
        viewCloudTerraceControlSensitivityPanelBinding.setLifecycleOwner(this);
        this.f8900f.h(this.f8899d);
        this.f8900f.q.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloudTerraceSensitivityDialogFragment.this.C0(view);
            }
        });
        this.f8900f.x.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloudTerraceSensitivityDialogFragment.this.H0(view);
            }
        });
        this.f8900f.f7348f.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloudTerraceSensitivityDialogFragment.this.J0(view);
            }
        });
        this.f8900f.i(new SeekBarBindingAdapter.OnStopTrackingTouch() { // from class: com.tplink.iot.view.ipcamera.play.l
            @Override // androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch
            public final void onStopTrackingTouch(SeekBar seekBar) {
                CloudTerraceSensitivityDialogFragment.this.L0(seekBar);
            }
        });
        View.OnTouchListener onTouchListener = this.q;
        if (onTouchListener != null) {
            this.f8900f.f7346c.setDispatchEventListener(onTouchListener);
        }
        return this.f8900f.getRoot();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(-1));
        window.setDimAmount(0.0f);
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        WindowManager.LayoutParams attributes = window.getAttributes();
        int a2 = b.d.w.f.a.a(getActivity(), 280.0f);
        attributes.width = a2;
        attributes.height = -2;
        attributes.gravity = BadgeDrawable.TOP_START;
        attributes.x = this.y - a2;
        attributes.y = this.x;
        window.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        a aVar = this.z;
        if (aVar != null) {
            aVar.d(this.f8899d.getValue().intValue());
        }
    }
}
