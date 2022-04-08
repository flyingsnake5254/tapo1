package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tplink.iot.view.iotcommon.DebugFwUpdateViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityDebugFwUpdateBinding extends ViewDataBinding {
    @NonNull
    public final TextInputEditText H3;
    @NonNull
    public final TextInputEditText I3;
    @NonNull
    public final LinearLayout J3;
    @NonNull
    public final LinearLayout K3;
    @NonNull
    public final LinearLayout L3;
    @NonNull
    public final ProgressBar M3;
    @NonNull
    public final Spinner N3;
    @NonNull
    public final TextInputLayout O3;
    @NonNull
    public final TextInputLayout P3;
    @NonNull
    public final TextInputLayout Q3;
    @NonNull
    public final TextInputLayout R3;
    @NonNull
    public final TextInputLayout S3;
    @NonNull
    public final TextInputLayout T3;
    @NonNull
    public final TextView U3;
    @NonNull
    public final TextView V3;
    @NonNull
    public final TextView W3;
    @NonNull
    public final TextView X3;
    @NonNull
    public final TextView Y3;
    @NonNull
    public final TextView Z3;
    @NonNull
    public final TextView a4;
    @NonNull
    public final TextView b4;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6536c;
    @NonNull
    public final TextView c4;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Button f6537d;
    @Bindable
    protected DebugFwUpdateViewModel d4;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Button f6538f;
    @NonNull
    public final TextInputEditText p0;
    @NonNull
    public final TextInputEditText p1;
    @NonNull
    public final TextInputEditText p2;
    @NonNull
    public final TextInputEditText p3;
    @NonNull
    public final Button q;
    @NonNull
    public final Button x;
    @NonNull
    public final Button y;
    @NonNull
    public final Button z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityDebugFwUpdateBinding(Object obj, View view, int i, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputEditText textInputEditText4, TextInputEditText textInputEditText5, TextInputEditText textInputEditText6, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ProgressBar progressBar, Spinner spinner, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextInputLayout textInputLayout4, TextInputLayout textInputLayout5, TextInputLayout textInputLayout6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        super(obj, view, i);
        this.f6536c = button;
        this.f6537d = button2;
        this.f6538f = button3;
        this.q = button4;
        this.x = button5;
        this.y = button6;
        this.z = button7;
        this.p0 = textInputEditText;
        this.p1 = textInputEditText2;
        this.p2 = textInputEditText3;
        this.p3 = textInputEditText4;
        this.H3 = textInputEditText5;
        this.I3 = textInputEditText6;
        this.J3 = linearLayout;
        this.K3 = linearLayout2;
        this.L3 = linearLayout3;
        this.M3 = progressBar;
        this.N3 = spinner;
        this.O3 = textInputLayout;
        this.P3 = textInputLayout2;
        this.Q3 = textInputLayout3;
        this.R3 = textInputLayout4;
        this.S3 = textInputLayout5;
        this.T3 = textInputLayout6;
        this.U3 = textView;
        this.V3 = textView2;
        this.W3 = textView3;
        this.X3 = textView4;
        this.Y3 = textView5;
        this.Z3 = textView6;
        this.a4 = textView7;
        this.b4 = textView8;
        this.c4 = textView9;
    }

    public abstract void h(@Nullable DebugFwUpdateViewModel debugFwUpdateViewModel);
}
