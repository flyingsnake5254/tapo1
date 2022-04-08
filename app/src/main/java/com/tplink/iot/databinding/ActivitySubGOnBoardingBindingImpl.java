package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

/* loaded from: classes2.dex */
public class ActivitySubGOnBoardingBindingImpl extends ActivitySubGOnBoardingBinding {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f6704f = null;
    @Nullable
    private static final SparseIntArray q;
    @NonNull
    private final RelativeLayout x;
    private long y;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.content, 1);
    }

    public ActivitySubGOnBoardingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f6704f, q));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.y = 0L;
        }
    }

    @Override // com.tplink.iot.databinding.ActivitySubGOnBoardingBinding
    public void h(@Nullable SubGViewModel subGViewModel) {
        this.f6703d = subGViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.y != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.y = 2L;
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
        h((SubGViewModel) obj);
        return true;
    }

    private ActivitySubGOnBoardingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[1]);
        this.y = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.x = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
