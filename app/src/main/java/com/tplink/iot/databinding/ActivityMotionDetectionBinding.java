package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import com.tplink.iot.viewmodel.ipcamera.setting.MotionDetectionViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityMotionDetectionBinding extends ViewDataBinding {
    @NonNull
    public final TextView H3;
    @NonNull
    public final TextView I3;
    @NonNull
    public final FrameLayout J3;
    @NonNull
    public final ImageView K3;
    @NonNull
    public final LinearLayout L3;
    @NonNull
    public final TextView M3;
    @NonNull
    public final CheckBox N3;
    @Bindable
    protected MotionDetectionViewModel O3;
    @Bindable
    protected SeekBarBindingAdapter.OnStopTrackingTouch P3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6627c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6628d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f6629f;
    @NonNull
    public final RelativeLayout p0;
    @NonNull
    public final SeekBar p1;
    @NonNull
    public final TextView p2;
    @NonNull
    public final TextView p3;
    @NonNull
    public final LinearLayout q;
    @NonNull
    public final LinearLayout x;
    @NonNull
    public final Toolbar y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMotionDetectionBinding(Object obj, View view, int i, TextView textView, TextView textView2, ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, Toolbar toolbar, TextView textView3, RelativeLayout relativeLayout, SeekBar seekBar, TextView textView4, TextView textView5, TextView textView6, TextView textView7, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout3, TextView textView8, CheckBox checkBox) {
        super(obj, view, i);
        this.f6627c = textView;
        this.f6628d = textView2;
        this.f6629f = constraintLayout;
        this.q = linearLayout;
        this.x = linearLayout2;
        this.y = toolbar;
        this.z = textView3;
        this.p0 = relativeLayout;
        this.p1 = seekBar;
        this.p2 = textView4;
        this.p3 = textView5;
        this.H3 = textView6;
        this.I3 = textView7;
        this.J3 = frameLayout;
        this.K3 = imageView;
        this.L3 = linearLayout3;
        this.M3 = textView8;
        this.N3 = checkBox;
    }

    public abstract void h(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch onStopTrackingTouch);

    public abstract void i(@Nullable MotionDetectionViewModel motionDetectionViewModel);
}
