package com.tplink.iot.dailysummary.view.viewhodlder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;
import com.tplink.iot.databinding.ItemSummaryHomeBinding;
import kotlin.jvm.internal.j;

/* compiled from: SummaryHomeViewHolder.kt */
/* loaded from: classes2.dex */
public final class SummaryHomeViewHolder extends RecyclerView.ViewHolder {
    private ItemSummaryHomeBinding a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryHomeViewHolder(View view) {
        super(view);
        j.e(view, "view");
    }

    public final void c(b summary, DailySummaryViewModel viewModel) {
        j.e(summary, "summary");
        j.e(viewModel, "viewModel");
        ItemSummaryHomeBinding itemSummaryHomeBinding = this.a;
        if (itemSummaryHomeBinding != null) {
            itemSummaryHomeBinding.h(summary);
            itemSummaryHomeBinding.i(viewModel);
            itemSummaryHomeBinding.executePendingBindings();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SummaryHomeViewHolder(com.tplink.iot.databinding.ItemSummaryHomeBinding r3) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.j.e(r3, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "binding.root"
            kotlin.jvm.internal.j.d(r0, r1)
            r2.<init>(r0)
            r2.a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.dailysummary.view.viewhodlder.SummaryHomeViewHolder.<init>(com.tplink.iot.databinding.ItemSummaryHomeBinding):void");
    }
}
