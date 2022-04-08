package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class FragmentButtonFeaturedActionsBindingImpl extends FragmentButtonFeaturedActionsBinding {
    @Nullable
    private static final SparseIntArray p0;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z = null;
    @NonNull
    private final NestedScrollView p1;
    private long p2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p0 = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 1);
        sparseIntArray.put(R.id.tv_description, 2);
        sparseIntArray.put(R.id.tv_tip, 3);
        sparseIntArray.put(R.id.iv_scene_img, 4);
        sparseIntArray.put(R.id.tv_empty, 5);
        sparseIntArray.put(R.id.recycler_view_device, 6);
    }

    public FragmentButtonFeaturedActionsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, z, p0));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.p2 = 0L;
        }
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
            this.p2 = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    private FragmentButtonFeaturedActionsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (RecyclerView) objArr[6], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[1]);
        this.p2 = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[0];
        this.p1 = nestedScrollView;
        nestedScrollView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
