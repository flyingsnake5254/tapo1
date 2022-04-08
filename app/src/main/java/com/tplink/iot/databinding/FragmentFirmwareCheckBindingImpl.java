package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.viewmodel.ipcamera.setting.FirmwareCheckViewModel;

/* loaded from: classes2.dex */
public class FragmentFirmwareCheckBindingImpl extends FragmentFirmwareCheckBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p2 = null;
    @Nullable
    private static final SparseIntArray p3;
    @NonNull
    private final FrameLayout H3;
    @NonNull
    private final TextView I3;
    @NonNull
    private final TextView J3;
    @NonNull
    private final View K3;
    @NonNull
    private final FrameLayout L3;
    private long M3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 8);
        sparseIntArray.put(R.id.iv_check_update, 9);
        sparseIntArray.put(R.id.auto_reboot_title, 10);
        sparseIntArray.put(R.id.icon_arrow, 11);
    }

    public FragmentFirmwareCheckBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, p2, p3));
    }

    private boolean l(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 2;
        }
        return true;
    }

    private boolean m(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 1;
        }
        return true;
    }

    private boolean n(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 4;
        }
        return true;
    }

    private boolean o(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 8;
        }
        return true;
    }

    private boolean p(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 16;
        }
        return true;
    }

    private boolean q(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 32;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0101  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.FragmentFirmwareCheckBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.FragmentFirmwareCheckBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.p0 = onClickListener;
        synchronized (this) {
            this.M3 |= 64;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.M3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.FragmentFirmwareCheckBinding
    public void i(@Nullable FirmwareCheckViewModel firmwareCheckViewModel) {
        this.p1 = firmwareCheckViewModel;
        synchronized (this) {
            this.M3 |= 128;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.M3 = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((ObservableField) obj, i2);
        }
        if (i == 1) {
            return l((ObservableField) obj, i2);
        }
        if (i == 2) {
            return n((ObservableInt) obj, i2);
        }
        if (i == 3) {
            return o((ObservableField) obj, i2);
        }
        if (i == 4) {
            return p((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return q((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 == i) {
            h((View.OnClickListener) obj);
        } else if (105 != i) {
            return false;
        } else {
            i((FirmwareCheckViewModel) obj);
        }
        return true;
    }

    private FragmentFirmwareCheckBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (TextView) objArr[10], (TextView) objArr[5], (Button) objArr[7], (ImageView) objArr[11], (RelativeLayout) objArr[4], (ImageView) objArr[9], (Toolbar) objArr[8]);
        this.M3 = -1L;
        this.f7006d.setTag(null);
        this.f7007f.setTag(null);
        this.x.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.H3 = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.I3 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.J3 = textView2;
        textView2.setTag(null);
        View view2 = (View) objArr[3];
        this.K3 = view2;
        view2.setTag(null);
        FrameLayout frameLayout2 = (FrameLayout) objArr[6];
        this.L3 = frameLayout2;
        frameLayout2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
