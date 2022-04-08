package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class ItemCameraSsidLayoutBindingImpl extends ItemCameraSsidLayoutBinding {
    @Nullable
    private static final SparseIntArray p0;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z = null;
    private a p1;
    private long p2;

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        private View.OnClickListener f7162c;

        public a a(View.OnClickListener onClickListener) {
            this.f7162c = onClickListener;
            if (onClickListener == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f7162c.onClick(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p0 = sparseIntArray;
        sparseIntArray.put(R.id.img_type, 2);
        sparseIntArray.put(R.id.img_signal, 3);
    }

    public ItemCameraSsidLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, z, p0));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.p2;
            this.p2 = 0L;
        }
        a aVar = null;
        View.OnClickListener onClickListener = this.y;
        String str = this.x;
        int i = ((5 & j) > 0L ? 1 : ((5 & j) == 0L ? 0 : -1));
        if (!(i == 0 || onClickListener == null)) {
            a aVar2 = this.p1;
            if (aVar2 == null) {
                aVar2 = new a();
                this.p1 = aVar2;
            }
            aVar = aVar2.a(onClickListener);
        }
        if ((j & 6) != 0) {
            TextViewBindingAdapter.setText(this.f7161f, str);
        }
        if (i != 0) {
            this.q.setOnClickListener(aVar);
        }
    }

    @Override // com.tplink.iot.databinding.ItemCameraSsidLayoutBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.y = onClickListener;
        synchronized (this) {
            this.p2 |= 1;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p2 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ItemCameraSsidLayoutBinding
    public void i(@Nullable String str) {
        this.x = str;
        synchronized (this) {
            this.p2 |= 2;
        }
        notifyPropertyChanged(92);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p2 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (55 == i) {
            h((View.OnClickListener) obj);
        } else if (92 != i) {
            return false;
        } else {
            i((String) obj);
        }
        return true;
    }

    private ItemCameraSsidLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (ImageView) objArr[2], (TextView) objArr[1], (RelativeLayout) objArr[0]);
        this.p2 = -1L;
        this.f7161f.setTag(null);
        this.q.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
