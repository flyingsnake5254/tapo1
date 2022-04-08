package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.R;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class ActivitySoftApCommonGuideBindingImpl extends ActivitySoftApCommonGuideBinding {
    @Nullable
    private static final SparseIntArray H3;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3 = null;
    @NonNull
    private final LinearLayout I3;
    private long J3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H3 = sparseIntArray;
        sparseIntArray.put(R.id.tv_guide_title, 3);
        sparseIntArray.put(R.id.tv_guide_desc, 4);
        sparseIntArray.put(R.id.tv_guide_tips, 5);
        sparseIntArray.put(R.id.fl_led_container, 6);
        sparseIntArray.put(R.id.image_check_led, 7);
        sparseIntArray.put(R.id.lottie_animation_view, 8);
        sparseIntArray.put(R.id.tv_bottom_tip, 9);
    }

    public ActivitySoftApCommonGuideBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, p3, H3));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.J3;
            this.J3 = 0L;
        }
        View.OnClickListener onClickListener = this.p2;
        if ((j & 3) != 0) {
            this.f6693c.setOnClickListener(onClickListener);
            this.q.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tplink.iot.databinding.ActivitySoftApCommonGuideBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.p2 = onClickListener;
        synchronized (this) {
            this.J3 |= 1;
        }
        notifyPropertyChanged(55);
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
        if (55 != i) {
            return false;
        }
        h((View.OnClickListener) obj);
        return true;
    }

    private ActivitySoftApCommonGuideBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TPRefreshableButton) objArr[2], (FrameLayout) objArr[6], (ImageView) objArr[7], (ImageView) objArr[1], (LottieAnimationView) objArr[8], (TextView) objArr[9], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[3]);
        this.J3 = -1L;
        this.f6693c.setTag(null);
        this.q.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.I3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
