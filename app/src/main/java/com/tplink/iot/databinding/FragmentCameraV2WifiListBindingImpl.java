package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWifiListViewModel;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;

/* loaded from: classes2.dex */
public class FragmentCameraV2WifiListBindingImpl extends FragmentCameraV2WifiListBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts J3 = null;
    @Nullable
    private static final SparseIntArray K3;
    @NonNull
    private final RelativeLayout L3;
    @NonNull
    private final RelativeLayout M3;
    @NonNull
    private final RelativeLayout N3;
    @Nullable
    private final View.OnClickListener O3;
    @Nullable
    private final View.OnClickListener P3;
    @Nullable
    private final View.OnClickListener Q3;
    @Nullable
    private final View.OnClickListener R3;
    @Nullable
    private final View.OnClickListener S3;
    private long T3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 9);
        sparseIntArray.put(R.id.tv_title, 10);
        sparseIntArray.put(R.id.tv_tip, 11);
        sparseIntArray.put(R.id.ll_content, 12);
    }

    public FragmentCameraV2WifiListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, J3, K3));
    }

    private boolean h(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 1;
        }
        return true;
    }

    private boolean i(ObservableList<Wifi> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 2;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.I3;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.I3;
            if (gVar2 != null) {
                z = true;
            }
            if (z) {
                gVar2.onClick(view);
            }
        } else if (i == 3) {
            g gVar3 = this.I3;
            if (gVar3 != null) {
                z = true;
            }
            if (z) {
                gVar3.onClick(view);
            }
        } else if (i == 4) {
            g gVar4 = this.I3;
            if (gVar4 != null) {
                z = true;
            }
            if (z) {
                gVar4.onClick(view);
            }
        } else if (i == 5) {
            g gVar5 = this.I3;
            if (gVar5 != null) {
                z = true;
            }
            if (z) {
                gVar5.onClick(view);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        ObservableList observableList;
        long j2;
        long j3;
        synchronized (this) {
            j = this.T3;
            this.T3 = 0L;
        }
        CameraOnBoardingViewModel cameraOnBoardingViewModel = this.H3;
        ObservableList observableList2 = null;
        ObservableBoolean observableBoolean = null;
        int i = 0;
        if ((j & 43) != 0) {
            if (cameraOnBoardingViewModel != null) {
                observableBoolean = cameraOnBoardingViewModel.k;
                observableList = cameraOnBoardingViewModel.i;
            } else {
                observableList = null;
            }
            updateRegistration(0, observableBoolean);
            boolean z2 = true;
            updateRegistration(1, observableList);
            z = observableBoolean != null ? observableBoolean.get() : false;
            int i2 = ((j & 42) > 0L ? 1 : ((j & 42) == 0L ? 0 : -1));
            if (i2 != 0) {
                if ((observableList != null ? observableList.size() : 0) != 0) {
                    z2 = false;
                }
                if (i2 != 0) {
                    if (z2) {
                        j3 = j | 128;
                        j2 = 512;
                    } else {
                        j3 = j | 64;
                        j2 = 256;
                    }
                    j = j3 | j2;
                }
                i = z2 ? 8 : 0;
                if (!z2) {
                    i = 8;
                }
                observableList2 = observableList;
            } else {
                observableList2 = observableList;
                i = 0;
            }
        } else {
            i = 0;
            z = false;
        }
        if ((32 & j) != 0) {
            this.f6954c.setOnClickListener(this.O3);
            this.f6955d.setOnClickListener(this.R3);
            this.y.setOnClickListener(this.Q3);
            this.z.setOnClickListener(this.S3);
            this.p0.setOnClickListener(this.P3);
        }
        if ((42 & j) != 0) {
            this.M3.setVisibility(i);
            this.N3.setVisibility(i);
        }
        if ((j & 43) != 0) {
            b.r(this.q, observableList2, z);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.T3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.T3 = 32L;
        }
        requestRebind();
    }

    public void l(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.H3 = cameraOnBoardingViewModel;
        synchronized (this) {
            this.T3 |= 8;
        }
        notifyPropertyChanged(68);
        super.requestRebind();
    }

    public void m(@Nullable g gVar) {
        this.I3 = gVar;
        synchronized (this) {
            this.T3 |= 4;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    public void n(@Nullable CameraWifiListViewModel cameraWifiListViewModel) {
        this.p3 = cameraWifiListViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return h((ObservableBoolean) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return i((ObservableList) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            m((g) obj);
        } else if (68 == i) {
            l((CameraOnBoardingViewModel) obj);
        } else if (103 != i) {
            return false;
        } else {
            n((CameraWifiListViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2WifiListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (Button) objArr[6], (Button) objArr[7], (LinearLayout) objArr[12], (RecyclerView) objArr[4], (Toolbar) objArr[9], (TextView) objArr[8], (TextView) objArr[3], (TextView) objArr[1], (TextView) objArr[11], (TextView) objArr[10]);
        this.T3 = -1L;
        this.f6954c.setTag(null);
        this.f6955d.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.L3 = relativeLayout;
        relativeLayout.setTag(null);
        RelativeLayout relativeLayout2 = (RelativeLayout) objArr[2];
        this.M3 = relativeLayout2;
        relativeLayout2.setTag(null);
        RelativeLayout relativeLayout3 = (RelativeLayout) objArr[5];
        this.N3 = relativeLayout3;
        relativeLayout3.setTag(null);
        this.q.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        setRootTag(view);
        this.O3 = new a(this, 3);
        this.P3 = new a(this, 1);
        this.Q3 = new a(this, 5);
        this.R3 = new a(this, 4);
        this.S3 = new a(this, 2);
        invalidateAll();
    }
}
