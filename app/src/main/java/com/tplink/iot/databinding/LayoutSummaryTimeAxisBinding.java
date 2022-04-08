package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisHorizontalScrollView;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisScaleView;

/* loaded from: classes2.dex */
public abstract class LayoutSummaryTimeAxisBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final SummaryTimeAxisScaleView f7292c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final SummaryTimeAxisHorizontalScrollView f7293d;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutSummaryTimeAxisBinding(Object obj, View view, int i, SummaryTimeAxisScaleView summaryTimeAxisScaleView, SummaryTimeAxisHorizontalScrollView summaryTimeAxisHorizontalScrollView) {
        super(obj, view, i);
        this.f7292c = summaryTimeAxisScaleView;
        this.f7293d = summaryTimeAxisHorizontalScrollView;
    }
}
