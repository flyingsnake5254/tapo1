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
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

/* loaded from: classes2.dex */
public class DialogMemorySlideOperationBindingImpl extends DialogMemorySlideOperationBinding implements a.AbstractC0211a {
    @Nullable
    private static final SparseIntArray p0 = null;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z = null;
    @Nullable
    private final View.OnClickListener H3;
    @Nullable
    private final View.OnClickListener I3;
    private long J3;
    @NonNull
    private final LinearLayout p1;
    @Nullable
    private final View.OnClickListener p2;
    @Nullable
    private final View.OnClickListener p3;

    public DialogMemorySlideOperationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, z, p0));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.J3 |= 1;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z2 = false;
        if (i == 1) {
            g gVar = this.x;
            if (gVar != null) {
                z2 = true;
            }
            if (z2) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.x;
            if (gVar2 != null) {
                z2 = true;
            }
            if (z2) {
                gVar2.onClick(view);
            }
        } else if (i == 3) {
            g gVar3 = this.x;
            if (gVar3 != null) {
                z2 = true;
            }
            if (z2) {
                gVar3.onClick(view);
            }
        } else if (i == 4) {
            g gVar4 = this.x;
            if (gVar4 != null) {
                z2 = true;
            }
            if (z2) {
                gVar4.onClick(view);
            }
        }
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
        MemoriesViewModel memoriesViewModel = this.y;
        Drawable drawable = null;
        ObservableBoolean observableBoolean = null;
        int i2 = ((j & 11) > 0L ? 1 : ((j & 11) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (memoriesViewModel != null) {
                observableBoolean = memoriesViewModel.h;
            }
            boolean z2 = false;
            updateRegistration(0, observableBoolean);
            if (observableBoolean != null) {
                z2 = observableBoolean.get();
            }
            if (i2 != 0) {
                j |= z2 ? 32L : 16L;
            }
            if (z2) {
                context = this.f6788f.getContext();
                i = R.drawable.memory_favorite_check_white;
            } else {
                context = this.f6788f.getContext();
                i = R.drawable.memory_favorite_disable;
            }
            drawable = AppCompatResources.getDrawable(context, i);
        }
        if ((8 & j) != 0) {
            this.f6786c.setOnClickListener(this.I3);
            this.f6787d.setOnClickListener(this.p3);
            this.f6788f.setOnClickListener(this.p2);
            this.q.setOnClickListener(this.H3);
        }
        if ((j & 11) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f6788f, drawable);
        }
    }

    @Override // com.tplink.iot.databinding.DialogMemorySlideOperationBinding
    public void h(@Nullable MemoriesViewModel memoriesViewModel) {
        this.y = memoriesViewModel;
        synchronized (this) {
            this.J3 |= 2;
        }
        notifyPropertyChanged(62);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.J3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.DialogMemorySlideOperationBinding
    public void i(@Nullable g gVar) {
        this.x = gVar;
        synchronized (this) {
            this.J3 |= 4;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.J3 = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (62 == i) {
            h((MemoriesViewModel) obj);
        } else if (79 != i) {
            return false;
        } else {
            i((g) obj);
        }
        return true;
    }

    private DialogMemorySlideOperationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[4], (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[1]);
        this.J3 = -1L;
        this.f6786c.setTag(null);
        this.f6787d.setTag(null);
        this.f6788f.setTag(null);
        this.q.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p1 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.p2 = new a(this, 2);
        this.p3 = new a(this, 3);
        this.H3 = new a(this, 1);
        this.I3 = new a(this, 4);
        invalidateAll();
    }
}
