package com.tplink.iot.databinding;

import android.net.wifi.ScanResult;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSSIDListViewModel;

/* loaded from: classes2.dex */
public class FragmentCameraV2SsidListBindingImpl extends FragmentCameraV2SsidListBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p0 = null;
    @Nullable
    private static final SparseIntArray p1;
    private long H3;
    @NonNull
    private final LinearLayout p2;
    @Nullable
    private final View.OnClickListener p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p1 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        sparseIntArray.put(R.id.layout_content, 4);
    }

    public FragmentCameraV2SsidListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, p0, p1));
    }

    private boolean h(ObservableList<ScanResult> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H3 |= 1;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.z;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.H3;
            this.H3 = 0L;
        }
        ObservableList<ScanResult> observableList = null;
        CameraOnBoardingViewModel cameraOnBoardingViewModel = this.y;
        int i = ((21 & j) > 0L ? 1 : ((21 & j) == 0L ? 0 : -1));
        if (i != 0) {
            if (cameraOnBoardingViewModel != null) {
                observableList = cameraOnBoardingViewModel.h;
            }
            updateRegistration(0, observableList);
        }
        if ((j & 16) != 0) {
            this.f6948c.setOnClickListener(this.p3);
        }
        if (i != 0) {
            b.G(this.f6950f, observableList);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.H3 != 0;
        }
    }

    public void i(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.y = cameraOnBoardingViewModel;
        synchronized (this) {
            this.H3 |= 4;
        }
        notifyPropertyChanged(68);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.H3 = 16L;
        }
        requestRebind();
    }

    public void l(@Nullable g gVar) {
        this.z = gVar;
        synchronized (this) {
            this.H3 |= 2;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    public void m(@Nullable CameraSSIDListViewModel cameraSSIDListViewModel) {
        this.x = cameraSSIDListViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return h((ObservableList) obj, i2);
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
            m((CameraSSIDListViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2SsidListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[2], (LinearLayout) objArr[4], (RecyclerView) objArr[1], (Toolbar) objArr[3]);
        this.H3 = -1L;
        this.f6948c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p2 = linearLayout;
        linearLayout.setTag(null);
        this.f6950f.setTag(null);
        setRootTag(view);
        this.p3 = new a(this, 1);
        invalidateAll();
    }
}
