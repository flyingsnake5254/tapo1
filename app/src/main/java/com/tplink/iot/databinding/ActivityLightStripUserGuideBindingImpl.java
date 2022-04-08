package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.widget.PointTextView;

/* loaded from: classes2.dex */
public class ActivityLightStripUserGuideBindingImpl extends ActivityLightStripUserGuideBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p1 = null;
    @Nullable
    private static final SparseIntArray p2;
    private long H3;
    @NonNull
    private final LinearLayout p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p2 = sparseIntArray;
        sparseIntArray.put(R.id.iv_back, 2);
        sparseIntArray.put(R.id.tv_guide1, 3);
        sparseIntArray.put(R.id.tv_guide2, 4);
        sparseIntArray.put(R.id.tv_guide3, 5);
        sparseIntArray.put(R.id.tv_guide4, 6);
        sparseIntArray.put(R.id.iv_bg, 7);
    }

    public ActivityLightStripUserGuideBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p1, p2));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.H3;
            this.H3 = 0L;
        }
        View.OnClickListener onClickListener = this.p0;
        if ((j & 3) != 0) {
            this.f6602c.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tplink.iot.databinding.ActivityLightStripUserGuideBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.p0 = onClickListener;
        synchronized (this) {
            this.H3 |= 1;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.H3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.H3 = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (69 != i) {
            return false;
        }
        h((View.OnClickListener) obj);
        return true;
    }

    private ActivityLightStripUserGuideBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[1], (ImageView) objArr[2], (ImageView) objArr[7], (PointTextView) objArr[3], (PointTextView) objArr[4], (PointTextView) objArr[5], (PointTextView) objArr[6]);
        this.H3 = -1L;
        this.f6602c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
