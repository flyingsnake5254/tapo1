package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class ActivityCameraCloudConnectBindingImpl extends ActivityCameraCloudConnectBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts y = null;
    @Nullable
    private static final SparseIntArray z;
    @NonNull
    private final LinearLayout p0;
    @NonNull
    private final ImageView p1;
    private long p2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z = sparseIntArray;
        sparseIntArray.put(R.id.img_back, 2);
        sparseIntArray.put(R.id.ll_content, 3);
        sparseIntArray.put(R.id.tv_error_code, 4);
        sparseIntArray.put(R.id.btn_cloud_connect, 5);
    }

    public ActivityCameraCloudConnectBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, y, z));
    }

    private boolean i(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        Context context;
        synchronized (this) {
            j = this.p2;
            this.p2 = 0L;
        }
        MutableLiveData<Boolean> mutableLiveData = this.x;
        Drawable drawable = null;
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
                context = this.p1.getContext();
                i = R.drawable.camera_cloud_connecting;
            } else {
                context = this.p1.getContext();
                i = R.drawable.camera_cloud_connect_fail;
            }
            drawable = AppCompatResources.getDrawable(context, i);
        }
        if ((j & 3) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.p1, drawable);
        }
    }

    @Override // com.tplink.iot.databinding.ActivityCameraCloudConnectBinding
    public void h(@Nullable MutableLiveData<Boolean> mutableLiveData) {
        updateLiveDataRegistration(0, mutableLiveData);
        this.x = mutableLiveData;
        synchronized (this) {
            this.p2 |= 1;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
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
            this.p2 = 2L;
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
        if (12 != i) {
            return false;
        }
        h((MutableLiveData) obj);
        return true;
    }

    private ActivityCameraCloudConnectBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TPRefreshableButton) objArr[5], (ImageView) objArr[2], (LinearLayout) objArr[3], (TextView) objArr[4]);
        this.p2 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p0 = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.p1 = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
