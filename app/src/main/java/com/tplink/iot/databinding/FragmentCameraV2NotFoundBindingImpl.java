package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

/* loaded from: classes2.dex */
public class FragmentCameraV2NotFoundBindingImpl extends FragmentCameraV2NotFoundBinding implements a.AbstractC0211a {
    @Nullable
    private static final SparseIntArray H3;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3 = null;
    @NonNull
    private final LinearLayout I3;
    @NonNull
    private final FrameLayout J3;
    @Nullable
    private final View.OnClickListener K3;
    private long L3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H3 = sparseIntArray;
        sparseIntArray.put(R.id.camera_no_found_tips_content, 3);
        sparseIntArray.put(R.id.camera_wired_no_found_tips_content, 4);
        sparseIntArray.put(R.id.toolbar, 5);
        sparseIntArray.put(R.id.ll_content, 6);
        sparseIntArray.put(R.id.img_ble_state, 7);
        sparseIntArray.put(R.id.tv_bottom_tip, 8);
    }

    public FragmentCameraV2NotFoundBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, p3, H3));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.p1;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.L3;
            this.L3 = 0L;
        }
        if ((j & 8) != 0) {
            this.f6918c.setOnClickListener(this.K3);
        }
    }

    public void h(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.p0 = cameraOnBoardingViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.L3 != 0;
        }
    }

    public void i(@Nullable g gVar) {
        this.p1 = gVar;
        synchronized (this) {
            this.L3 |= 1;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.L3 = 8L;
        }
        requestRebind();
    }

    public void l(@Nullable View view) {
        this.p2 = view;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            i((g) obj);
            return true;
        } else if (68 == i) {
            h((CameraOnBoardingViewModel) obj);
            return true;
        } else if (1 != i) {
            return false;
        } else {
            l((View) obj);
            return true;
        }
    }

    private FragmentCameraV2NotFoundBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[2], (View) objArr[3], (View) objArr[4], (ImageView) objArr[7], (LinearLayout) objArr[6], (Toolbar) objArr[5], (TextView) objArr[8]);
        this.L3 = -1L;
        this.f6918c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.I3 = linearLayout;
        linearLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[1];
        this.J3 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        this.K3 = new a(this, 1);
        invalidateAll();
    }
}
