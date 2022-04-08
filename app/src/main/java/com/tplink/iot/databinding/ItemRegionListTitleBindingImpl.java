package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.viewmodel.login.a;

/* loaded from: classes2.dex */
public class ItemRegionListTitleBindingImpl extends ItemRegionListTitleBinding {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f7194d = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f7195f = null;
    @NonNull
    private final LinearLayout q;
    @NonNull
    private final TextView x;
    private long y;

    public ItemRegionListTitleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f7194d, f7195f));
    }

    private boolean i(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.y |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.y;
            this.y = 0L;
        }
        a aVar = this.f7193c;
        String str = null;
        int i = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        if (i != 0) {
            ObservableField<String> observableField = aVar != null ? aVar.a : null;
            updateRegistration(0, observableField);
            if (observableField != null) {
                str = observableField.get();
            }
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.x, str);
        }
    }

    @Override // com.tplink.iot.databinding.ItemRegionListTitleBinding
    public void h(@Nullable a aVar) {
        this.f7193c = aVar;
        synchronized (this) {
            this.y |= 2;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
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
            this.y = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return i((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (105 != i) {
            return false;
        }
        h((a) obj);
        return true;
    }

    private ItemRegionListTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.y = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.q = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.x = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
