package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;

/* loaded from: classes2.dex */
public abstract class LayoutDailySummarySettingsBinding extends ViewDataBinding {
    @NonNull
    public final View H3;
    @NonNull
    public final Guideline I3;
    @NonNull
    public final Guideline J3;
    @NonNull
    public final ConstraintLayout K3;
    @NonNull
    public final ConstraintLayout L3;
    @NonNull
    public final SwitchCompat M3;
    @NonNull
    public final SwitchCompat N3;
    @NonNull
    public final TextView O3;
    @NonNull
    public final TextView P3;
    @NonNull
    public final TextView Q3;
    @NonNull
    public final TextView R3;
    @NonNull
    public final TextView S3;
    @NonNull
    public final TextView T3;
    @NonNull
    public final TextView U3;
    @NonNull
    public final TextView V3;
    @NonNull
    public final TextView W3;
    @Bindable
    protected DailySummaryViewModel X3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f7226c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7227d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f7228f;
    @NonNull
    public final View p0;
    @NonNull
    public final View p1;
    @NonNull
    public final View p2;
    @NonNull
    public final View p3;
    @NonNull
    public final View q;
    @NonNull
    public final View x;
    @NonNull
    public final View y;
    @NonNull
    public final View z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutDailySummarySettingsBinding(Object obj, View view, int i, TextView textView, ImageView imageView, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9, View view10, View view11, Guideline guideline, Guideline guideline2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, SwitchCompat switchCompat, SwitchCompat switchCompat2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        super(obj, view, i);
        this.f7226c = textView;
        this.f7227d = imageView;
        this.f7228f = view2;
        this.q = view3;
        this.x = view4;
        this.y = view5;
        this.z = view6;
        this.p0 = view7;
        this.p1 = view8;
        this.p2 = view9;
        this.p3 = view10;
        this.H3 = view11;
        this.I3 = guideline;
        this.J3 = guideline2;
        this.K3 = constraintLayout;
        this.L3 = constraintLayout2;
        this.M3 = switchCompat;
        this.N3 = switchCompat2;
        this.O3 = textView2;
        this.P3 = textView3;
        this.Q3 = textView4;
        this.R3 = textView5;
        this.S3 = textView6;
        this.T3 = textView7;
        this.U3 = textView8;
        this.V3 = textView9;
        this.W3 = textView10;
    }

    public abstract void h(@Nullable DailySummaryViewModel dailySummaryViewModel);
}
