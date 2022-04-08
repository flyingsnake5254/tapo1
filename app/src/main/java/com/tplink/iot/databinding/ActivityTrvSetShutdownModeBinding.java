package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

/* loaded from: classes2.dex */
public abstract class ActivityTrvSetShutdownModeBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TPRadioButton f6744c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TPRadioButton f6745d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RadioGroup f6746f;
    @NonNull
    public final RelativeLayout q;
    @NonNull
    public final TPSwitchCompat x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTrvSetShutdownModeBinding(Object obj, View view, int i, TPRadioButton tPRadioButton, TPRadioButton tPRadioButton2, RadioGroup radioGroup, RelativeLayout relativeLayout, TPSwitchCompat tPSwitchCompat, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6744c = tPRadioButton;
        this.f6745d = tPRadioButton2;
        this.f6746f = radioGroup;
        this.q = relativeLayout;
        this.x = tPSwitchCompat;
        this.y = textView;
        this.z = textView2;
    }
}
