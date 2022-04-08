package com.tplink.iot.databinding;

import android.content.res.Resources;
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
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class DialogMultiLiveDragBindingImpl extends DialogMultiLiveDragBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts y = null;
    @Nullable
    private static final SparseIntArray z;
    @NonNull
    private final TextView p0;
    private long p1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z = sparseIntArray;
        sparseIntArray.put(R.id.position_trend_frame, 2);
        sparseIntArray.put(R.id.image, 3);
        sparseIntArray.put(R.id.multi_live_bin, 4);
    }

    public DialogMultiLiveDragBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, y, z));
    }

    private boolean i(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p1 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        Resources resources;
        synchronized (this) {
            j = this.p1;
            this.p1 = 0L;
        }
        MutableLiveData<Boolean> mutableLiveData = this.x;
        String str = null;
        Boolean bool = null;
        int i2 = ((j & 3) > 0L ? 1 : ((j & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (mutableLiveData != null) {
                bool = mutableLiveData.getValue();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i2 != 0) {
                j |= safeUnbox ? 8L : 4L;
            }
            if (safeUnbox) {
                resources = this.p0.getResources();
                i = R.string.multi_live_main_view_remove_hint;
            } else {
                resources = this.p0.getResources();
                i = R.string.multi_live_remove_hint;
            }
            str = resources.getString(i);
        }
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.p0, str);
        }
    }

    @Override // com.tplink.iot.databinding.DialogMultiLiveDragBinding
    public void h(@Nullable MutableLiveData<Boolean> mutableLiveData) {
        updateLiveDataRegistration(0, mutableLiveData);
        this.x = mutableLiveData;
        synchronized (this) {
            this.p1 |= 1;
        }
        notifyPropertyChanged(43);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p1 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p1 = 2L;
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
        if (43 != i) {
            return false;
        }
        h((MutableLiveData) obj);
        return true;
    }

    private DialogMultiLiveDragBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ConstraintLayout) objArr[0], (ImageView) objArr[3], (ImageView) objArr[4], (View) objArr[2]);
        this.p1 = -1L;
        this.f6792c.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.p0 = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
