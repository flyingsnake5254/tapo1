package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;

/* loaded from: classes2.dex */
public abstract class ItemSummaryHomeBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f7205c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7206d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7207f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final TextView p1;
    @Bindable
    protected DailySummaryViewModel p2;
    @Bindable
    protected b p3;
    @NonNull
    public final CardView q;
    @NonNull
    public final Guideline x;
    @NonNull
    public final ImageView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemSummaryHomeBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, CardView cardView, Guideline guideline, ImageView imageView, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.f7205c = textView;
        this.f7206d = textView2;
        this.f7207f = textView3;
        this.q = cardView;
        this.x = guideline;
        this.y = imageView;
        this.z = textView4;
        this.p0 = textView5;
        this.p1 = textView6;
    }

    public abstract void h(@Nullable b bVar);

    public abstract void i(@Nullable DailySummaryViewModel dailySummaryViewModel);
}
