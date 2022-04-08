package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.dailysummary.viewmodel.SummaryHistoryViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

/* loaded from: classes2.dex */
public abstract class ActivitySummaryHistoryBinding extends ViewDataBinding {
    @NonNull
    public final TextView H3;
    @NonNull
    public final TextView I3;
    @Bindable
    protected SummaryHistoryViewModel J3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CardView f6708c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6709d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6710f;
    @NonNull
    public final TPSmartRefreshLayout p0;
    @NonNull
    public final ConstraintLayout p1;
    @NonNull
    public final TextView p2;
    @NonNull
    public final ConstraintLayout p3;
    @NonNull
    public final ImageView q;
    @NonNull
    public final ImageView x;
    @NonNull
    public final ImageView y;
    @NonNull
    public final RecyclerView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySummaryHistoryBinding(Object obj, View view, int i, CardView cardView, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RecyclerView recyclerView, TPSmartRefreshLayout tPSmartRefreshLayout, ConstraintLayout constraintLayout, TextView textView2, ConstraintLayout constraintLayout2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f6708c = cardView;
        this.f6709d = textView;
        this.f6710f = imageView;
        this.q = imageView2;
        this.x = imageView3;
        this.y = imageView4;
        this.z = recyclerView;
        this.p0 = tPSmartRefreshLayout;
        this.p1 = constraintLayout;
        this.p2 = textView2;
        this.p3 = constraintLayout2;
        this.H3 = textView3;
        this.I3 = textView4;
    }

    public abstract void h(@Nullable SummaryHistoryViewModel summaryHistoryViewModel);
}
