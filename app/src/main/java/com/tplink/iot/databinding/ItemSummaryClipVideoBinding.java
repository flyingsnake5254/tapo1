package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.dailysummary.model.SummaryClipItem;

/* loaded from: classes2.dex */
public abstract class ItemSummaryClipVideoBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7199c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7200d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7201f;
    @NonNull
    public final TextView q;
    @Bindable
    protected SummaryClipItem x;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemSummaryClipVideoBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView) {
        super(obj, view, i);
        this.f7199c = imageView;
        this.f7200d = imageView2;
        this.f7201f = imageView3;
        this.q = textView;
    }

    public abstract void h(@Nullable SummaryClipItem summaryClipItem);
}
