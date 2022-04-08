package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.viewmodel.ipcamera.setting.FirmwareUpdateViewModel;

/* loaded from: classes2.dex */
public class FragmentFirmwareUpdateNewIpcBindingImpl extends FragmentFirmwareUpdateNewIpcBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts H3 = null;
    @Nullable
    private static final SparseIntArray I3;
    @NonNull
    private final LinearLayout J3;
    @NonNull
    private final TextView K3;
    @NonNull
    private final TextView L3;
    @NonNull
    private final TextView M3;
    @NonNull
    private final View N3;
    @NonNull
    private final FrameLayout O3;
    private long P3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I3 = sparseIntArray;
        sparseIntArray.put(R.id.fw_update_title, 11);
        sparseIntArray.put(R.id.fw_update_tips, 12);
        sparseIntArray.put(R.id.auto_reboot_title, 13);
        sparseIntArray.put(R.id.icon_arrow, 14);
    }

    public FragmentFirmwareUpdateNewIpcBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, H3, I3));
    }

    private boolean l(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 1;
        }
        return true;
    }

    private boolean m(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 64;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 8;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 4;
        }
        return true;
    }

    private boolean p(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 16;
        }
        return true;
    }

    private boolean q(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 32;
        }
        return true;
    }

    private boolean r(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.FragmentFirmwareUpdateNewIpcBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.FragmentFirmwareUpdateNewIpcBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.p3 = onClickListener;
        synchronized (this) {
            this.P3 |= 128;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.P3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.FragmentFirmwareUpdateNewIpcBinding
    public void i(@Nullable FirmwareUpdateViewModel firmwareUpdateViewModel) {
        this.p2 = firmwareUpdateViewModel;
        synchronized (this) {
            this.P3 |= 256;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.P3 = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return l((ObservableField) obj, i2);
            case 1:
                return r((ObservableField) obj, i2);
            case 2:
                return o((ObservableBoolean) obj, i2);
            case 3:
                return n((ObservableBoolean) obj, i2);
            case 4:
                return p((ObservableField) obj, i2);
            case 5:
                return q((ObservableField) obj, i2);
            case 6:
                return m((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 == i) {
            h((View.OnClickListener) obj);
        } else if (105 != i) {
            return false;
        } else {
            i((FirmwareUpdateViewModel) obj);
        }
        return true;
    }

    private FragmentFirmwareUpdateNewIpcBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (TextView) objArr[13], (TextView) objArr[8], (Button) objArr[10], (TextView) objArr[2], (TextView) objArr[12], (TextView) objArr[11], (ImageView) objArr[14], (ImageView) objArr[1], (RelativeLayout) objArr[7]);
        this.P3 = -1L;
        this.f7009d.setTag(null);
        this.f7010f.setTag(null);
        this.q.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.J3 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.K3 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.L3 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.M3 = textView3;
        textView3.setTag(null);
        View view2 = (View) objArr[6];
        this.N3 = view2;
        view2.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[9];
        this.O3 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
