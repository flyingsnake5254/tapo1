package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.PointTextView;
import com.tplink.iot.widget.viewgroup.ToastTipBarView;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public abstract class ActivityTrvSetProgressCalibrationBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TPRefreshableButton f6738c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ToastTipBarView f6739d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f6740f;
    @NonNull
    public final PointTextView q;
    @NonNull
    public final PointTextView x;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTrvSetProgressCalibrationBinding(Object obj, View view, int i, TPRefreshableButton tPRefreshableButton, ToastTipBarView toastTipBarView, View view2, PointTextView pointTextView, PointTextView pointTextView2) {
        super(obj, view, i);
        this.f6738c = tPRefreshableButton;
        this.f6739d = toastTipBarView;
        this.f6740f = view2;
        this.q = pointTextView;
        this.x = pointTextView2;
    }
}
