package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.dailysummary.model.SummaryClipItem;

/* loaded from: classes2.dex */
public class ItemSummaryClipVideoBindingImpl extends ItemSummaryClipVideoBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts y = null;
    @Nullable
    private static final SparseIntArray z;
    @NonNull
    private final ConstraintLayout p0;
    @NonNull
    private final View p1;
    private long p2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z = sparseIntArray;
        sparseIntArray.put(R.id.iv_no_video, 5);
    }

    public ItemSummaryClipVideoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, y, z));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.p2;
            this.p2 = 0L;
        }
        boolean z2 = false;
        SummaryClipItem summaryClipItem = this.x;
        String str = null;
        int i = ((j & 3) > 0L ? 1 : ((j & 3) == 0L ? 0 : -1));
        if (!(i == 0 || summaryClipItem == null)) {
            z2 = summaryClipItem.getChoosed();
            str = summaryClipItem.getDurationString();
        }
        if (i != 0) {
            a.h(this.f7200d, z2);
            com.tplink.iot.dailysummary.view.adapter.a.a(this.f7201f, summaryClipItem);
            a.h(this.p1, z2);
            TextViewBindingAdapter.setText(this.q, str);
        }
    }

    @Override // com.tplink.iot.databinding.ItemSummaryClipVideoBinding
    public void h(@Nullable SummaryClipItem summaryClipItem) {
        this.x = summaryClipItem;
        synchronized (this) {
            this.p2 |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p2 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p2 = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (10 != i) {
            return false;
        }
        h((SummaryClipItem) obj);
        return true;
    }

    private ItemSummaryClipVideoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (ImageView) objArr[3], (ImageView) objArr[1], (TextView) objArr[4]);
        this.p2 = -1L;
        this.f7200d.setTag(null);
        this.f7201f.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.p0 = constraintLayout;
        constraintLayout.setTag(null);
        View view2 = (View) objArr[2];
        this.p1 = view2;
        view2.setTag(null);
        this.q.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
