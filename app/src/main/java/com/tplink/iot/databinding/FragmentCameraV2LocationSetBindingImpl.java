package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraLocationSetViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

/* loaded from: classes2.dex */
public class FragmentCameraV2LocationSetBindingImpl extends FragmentCameraV2LocationSetBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts H3 = null;
    @Nullable
    private static final SparseIntArray I3;
    @NonNull
    private final LinearLayout J3;
    @Nullable
    private final View.OnClickListener K3;
    @Nullable
    private final View.OnClickListener L3;
    private long M3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        sparseIntArray.put(R.id.location_title, 4);
        sparseIntArray.put(R.id.location_tips, 5);
        sparseIntArray.put(R.id.bottom_layout, 6);
        sparseIntArray.put(R.id.locate_show_view, 7);
        sparseIntArray.put(R.id.activity_set_location_photo, 8);
    }

    public FragmentCameraV2LocationSetBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, H3, I3));
    }

    private boolean h(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 1;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.p3;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.p3;
            if (gVar2 != null) {
                z = true;
            }
            if (z) {
                gVar2.onClick(view);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.M3;
            this.M3 = 0L;
        }
        CameraOnBoardingViewModel cameraOnBoardingViewModel = this.p2;
        String str = null;
        ObservableInt observableInt = null;
        boolean z = false;
        int i = ((j & 21) > 0L ? 1 : ((j & 21) == 0L ? 0 : -1));
        if (i != 0) {
            if (cameraOnBoardingViewModel != null) {
                observableInt = cameraOnBoardingViewModel.f10408f;
            }
            updateRegistration(0, observableInt);
            if ((observableInt != null ? observableInt.get() : 0) > 0) {
                z = true;
            }
            if (i != 0) {
                j |= z ? 64L : 32L;
            }
            str = this.z.getResources().getString(z ? R.string.common_retry : R.string.setting_next);
        }
        if ((16 & j) != 0) {
            this.f6911f.setOnClickListener(this.K3);
            this.z.setOnClickListener(this.L3);
        }
        if ((j & 21) != 0) {
            b.Q(this.f6911f, z);
            TextViewBindingAdapter.setText(this.z, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.M3 != 0;
        }
    }

    public void i(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.p2 = cameraOnBoardingViewModel;
        synchronized (this) {
            this.M3 |= 4;
        }
        notifyPropertyChanged(68);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.M3 = 16L;
        }
        requestRebind();
    }

    public void l(@Nullable g gVar) {
        this.p3 = gVar;
        synchronized (this) {
            this.M3 |= 2;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    public void m(@Nullable CameraLocationSetViewModel cameraLocationSetViewModel) {
        this.p1 = cameraLocationSetViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return h((ObservableInt) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            l((g) obj);
        } else if (68 == i) {
            i((CameraOnBoardingViewModel) obj);
        } else if (103 != i) {
            return false;
        } else {
            m((CameraLocationSetViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2LocationSetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[8], (RelativeLayout) objArr[6], (TextView) objArr[2], (RecyclerView) objArr[7], (TextView) objArr[5], (TextView) objArr[4], (Button) objArr[1], (Toolbar) objArr[3]);
        this.M3 = -1L;
        this.f6911f.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.J3 = linearLayout;
        linearLayout.setTag(null);
        this.z.setTag(null);
        setRootTag(view);
        this.K3 = new a(this, 2);
        this.L3 = new a(this, 1);
        invalidateAll();
    }
}
