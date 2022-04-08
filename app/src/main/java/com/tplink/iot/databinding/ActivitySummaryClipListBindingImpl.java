package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.R;
import com.tplink.iot.dailysummary.viewmodel.SummaryClipListViewModel;

/* loaded from: classes2.dex */
public class ActivitySummaryClipListBindingImpl extends ActivitySummaryClipListBinding {
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
        sparseIntArray.put(R.id.layout_summary_clip_player_top_toolbar, 2);
        sparseIntArray.put(R.id.btn_toolbar_back, 3);
        sparseIntArray.put(R.id.layout_summary_clip_player, 4);
        sparseIntArray.put(R.id.player_view_summary_clip, 5);
        sparseIntArray.put(R.id.layout_summary_player_bottom_toolbar, 6);
        sparseIntArray.put(R.id.iv_capture, 7);
        sparseIntArray.put(R.id.iv_summary_clip_download, 8);
        sparseIntArray.put(R.id.recycle_summary_clip_list, 9);
    }

    public ActivitySummaryClipListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, p3, H3));
    }

    private boolean i(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.J3 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        Context context;
        synchronized (this) {
            j = this.J3;
            this.J3 = 0L;
        }
        SummaryClipListViewModel summaryClipListViewModel = this.p2;
        Drawable drawable = null;
        Boolean bool = null;
        int i2 = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        if (i2 != 0) {
            MutableLiveData<Boolean> u = summaryClipListViewModel != null ? summaryClipListViewModel.u() : null;
            updateLiveDataRegistration(0, u);
            if (u != null) {
                bool = u.getValue();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i2 != 0) {
                j |= safeUnbox ? 16L : 8L;
            }
            if (safeUnbox) {
                context = this.f6707f.getContext();
                i = R.drawable.summary_player_tool_sound;
            } else {
                context = this.f6707f.getContext();
                i = R.drawable.summary_player_tool_mute;
            }
            drawable = AppCompatResources.getDrawable(context, i);
        }
        if ((j & 7) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f6707f, drawable);
        }
    }

    @Override // com.tplink.iot.databinding.ActivitySummaryClipListBinding
    public void h(@Nullable SummaryClipListViewModel summaryClipListViewModel) {
        this.p2 = summaryClipListViewModel;
        synchronized (this) {
            this.J3 |= 2;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
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
            this.J3 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return i((MutableLiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (103 != i) {
            return false;
        }
        h((SummaryClipListViewModel) obj);
        return true;
    }

    private ActivitySummaryClipListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[3], (ImageView) objArr[7], (ImageView) objArr[1], (ImageView) objArr[8], (ConstraintLayout) objArr[4], (ConstraintLayout) objArr[2], (LinearLayout) objArr[6], (PlayerView) objArr[5], (RecyclerView) objArr[9]);
        this.J3 = -1L;
        this.f6707f.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.I3 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
