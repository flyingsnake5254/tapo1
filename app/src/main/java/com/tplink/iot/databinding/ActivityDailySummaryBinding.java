package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

/* loaded from: classes2.dex */
public abstract class ActivityDailySummaryBinding extends ViewDataBinding {
    @NonNull
    public final ImageView H3;
    @NonNull
    public final ConstraintLayout I3;
    @NonNull
    public final RecyclerView J3;
    @NonNull
    public final TPSmartRefreshLayout K3;
    @NonNull
    public final ConstraintLayout L3;
    @NonNull
    public final TextView M3;
    @NonNull
    public final TextView N3;
    @NonNull
    public final TextView O3;
    @NonNull
    public final TextView P3;
    @NonNull
    public final TextView Q3;
    @Bindable
    protected DailySummaryViewModel R3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6533c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6534d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6535f;
    @NonNull
    public final Guideline p0;
    @NonNull
    public final LayoutDailySummarySettingsBinding p1;
    @NonNull
    public final ImageView p2;
    @NonNull
    public final ImageView p3;
    @NonNull
    public final ImageView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final ImageView y;
    @NonNull
    public final CardView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityDailySummaryBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, TextView textView3, ImageView imageView3, CardView cardView, Guideline guideline, LayoutDailySummarySettingsBinding layoutDailySummarySettingsBinding, ImageView imageView4, ImageView imageView5, ImageView imageView6, ConstraintLayout constraintLayout, RecyclerView recyclerView, TPSmartRefreshLayout tPSmartRefreshLayout, ConstraintLayout constraintLayout2, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        super(obj, view, i);
        this.f6533c = textView;
        this.f6534d = textView2;
        this.f6535f = imageView;
        this.q = imageView2;
        this.x = textView3;
        this.y = imageView3;
        this.z = cardView;
        this.p0 = guideline;
        this.p1 = layoutDailySummarySettingsBinding;
        this.p2 = imageView4;
        this.p3 = imageView5;
        this.H3 = imageView6;
        this.I3 = constraintLayout;
        this.J3 = recyclerView;
        this.K3 = tPSmartRefreshLayout;
        this.L3 = constraintLayout2;
        this.M3 = textView4;
        this.N3 = textView5;
        this.O3 = textView6;
        this.P3 = textView7;
        this.Q3 = textView8;
    }

    public abstract void h(@Nullable DailySummaryViewModel dailySummaryViewModel);
}
