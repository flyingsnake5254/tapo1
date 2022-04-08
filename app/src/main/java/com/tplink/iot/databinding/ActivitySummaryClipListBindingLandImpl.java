package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.R;
import com.tplink.iot.dailysummary.viewmodel.SummaryClipListViewModel;

/* loaded from: classes2.dex */
public class ActivitySummaryClipListBindingLandImpl extends ActivitySummaryClipListBinding {
    @Nullable
    private static final SparseIntArray H3;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3 = null;
    @NonNull
    private final ConstraintLayout I3;
    private long J3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H3 = sparseIntArray;
        sparseIntArray.put(R.id.layout_summary_clip_player, 1);
        sparseIntArray.put(R.id.player_view_summary_clip, 2);
    }

    public ActivitySummaryClipListBindingLandImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, p3, H3));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.J3 = 0L;
        }
    }

    @Override // com.tplink.iot.databinding.ActivitySummaryClipListBinding
    public void h(@Nullable SummaryClipListViewModel summaryClipListViewModel) {
        this.p2 = summaryClipListViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.J3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.J3 = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (103 != i) {
            return false;
        }
        h((SummaryClipListViewModel) obj);
        return true;
    }

    private ActivitySummaryClipListBindingLandImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, null, null, null, null, (ConstraintLayout) objArr[1], null, null, (PlayerView) objArr[2], null);
        this.J3 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.I3 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
