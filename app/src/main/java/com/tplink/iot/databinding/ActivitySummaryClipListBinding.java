package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.dailysummary.viewmodel.SummaryClipListViewModel;

/* loaded from: classes2.dex */
public abstract class ActivitySummaryClipListBinding extends ViewDataBinding {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6705c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6706d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6707f;
    @NonNull
    public final PlayerView p0;
    @Nullable
    public final RecyclerView p1;
    @Bindable
    protected SummaryClipListViewModel p2;
    @Nullable
    public final ImageView q;
    @NonNull
    public final ConstraintLayout x;
    @Nullable
    public final ConstraintLayout y;
    @Nullable
    public final LinearLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySummaryClipListBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout, PlayerView playerView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f6705c = imageView;
        this.f6706d = imageView2;
        this.f6707f = imageView3;
        this.q = imageView4;
        this.x = constraintLayout;
        this.y = constraintLayout2;
        this.z = linearLayout;
        this.p0 = playerView;
        this.p1 = recyclerView;
    }

    public abstract void h(@Nullable SummaryClipListViewModel summaryClipListViewModel);
}
