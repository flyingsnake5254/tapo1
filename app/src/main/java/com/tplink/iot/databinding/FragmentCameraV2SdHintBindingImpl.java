package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSdHintViewModel;
import com.tplink.iot.widget.PointTextView;

/* loaded from: classes2.dex */
public class FragmentCameraV2SdHintBindingImpl extends FragmentCameraV2SdHintBinding implements a.AbstractC0211a {
    @Nullable
    private static final SparseIntArray H3;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3 = null;
    @NonNull
    private final LinearLayout I3;
    @Nullable
    private final View.OnClickListener J3;
    private long K3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 2);
        sparseIntArray.put(R.id.ll_content, 3);
        sparseIntArray.put(R.id.img_device, 4);
        sparseIntArray.put(R.id.point_view1, 5);
        sparseIntArray.put(R.id.point_view3, 6);
        sparseIntArray.put(R.id.point_view2, 7);
    }

    public FragmentCameraV2SdHintBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p3, H3));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.p2;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.K3;
            this.K3 = 0L;
        }
        if ((j & 8) != 0) {
            this.f6942c.setOnClickListener(this.J3);
        }
    }

    public void h(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.p1 = cameraOnBoardingViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.K3 != 0;
        }
    }

    public void i(@Nullable g gVar) {
        this.p2 = gVar;
        synchronized (this) {
            this.K3 |= 1;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K3 = 8L;
        }
        requestRebind();
    }

    public void l(@Nullable CameraSdHintViewModel cameraSdHintViewModel) {
        this.p0 = cameraSdHintViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            i((g) obj);
        } else if (68 == i) {
            h((CameraOnBoardingViewModel) obj);
        } else if (103 != i) {
            return false;
        } else {
            l((CameraSdHintViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2SdHintBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[1], (ImageView) objArr[4], (LinearLayout) objArr[3], (PointTextView) objArr[5], (PointTextView) objArr[7], (PointTextView) objArr[6], (Toolbar) objArr[2]);
        this.K3 = -1L;
        this.f6942c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.I3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.J3 = new a(this, 1);
        invalidateAll();
    }
}
