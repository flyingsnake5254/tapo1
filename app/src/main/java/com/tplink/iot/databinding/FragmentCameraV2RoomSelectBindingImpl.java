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
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraRoomSelectViewModel;

/* loaded from: classes2.dex */
public class FragmentCameraV2RoomSelectBindingImpl extends FragmentCameraV2RoomSelectBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p1 = null;
    @Nullable
    private static final SparseIntArray p2;
    @Nullable
    private final View.OnClickListener H3;
    private long I3;
    @NonNull
    private final LinearLayout p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p2 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 2);
        sparseIntArray.put(R.id.location_title, 3);
        sparseIntArray.put(R.id.bottom_layout, 4);
        sparseIntArray.put(R.id.device_place_list, 5);
    }

    public FragmentCameraV2RoomSelectBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, p1, p2));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.p0;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.I3;
            this.I3 = 0L;
        }
        if ((j & 8) != 0) {
            this.q.setOnClickListener(this.H3);
        }
    }

    public void h(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.z = cameraOnBoardingViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.I3 != 0;
        }
    }

    public void i(@Nullable g gVar) {
        this.p0 = gVar;
        synchronized (this) {
            this.I3 |= 1;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.I3 = 8L;
        }
        requestRebind();
    }

    public void l(@Nullable CameraRoomSelectViewModel cameraRoomSelectViewModel) {
        this.y = cameraRoomSelectViewModel;
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
            l((CameraRoomSelectViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2RoomSelectBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[4], (RecyclerView) objArr[5], (TextView) objArr[3], (Button) objArr[1], (Toolbar) objArr[2]);
        this.I3 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p3 = linearLayout;
        linearLayout.setTag(null);
        this.q.setTag(null);
        setRootTag(view);
        this.H3 = new a(this, 1);
        invalidateAll();
    }
}
