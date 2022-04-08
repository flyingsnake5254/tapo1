package com.tplink.iot.dailysummary.view.viewhodlder;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.databinding.ItemSummaryClipTitleBinding;
import kotlin.jvm.internal.j;

/* compiled from: SummaryClipTitleViewHolder.kt */
/* loaded from: classes2.dex */
public final class SummaryClipTitleViewHolder extends RecyclerView.ViewHolder {
    private final ItemSummaryClipTitleBinding a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f6372b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryClipTitleViewHolder(ItemSummaryClipTitleBinding bingding) {
        super(bingding.getRoot());
        j.e(bingding, "bingding");
        this.a = bingding;
        TextView textView = bingding.f7196c;
        j.d(textView, "mBinding.tvTitle");
        this.f6372b = textView;
    }

    public final void c(String title) {
        j.e(title, "title");
        this.f6372b.setText(title);
    }
}
