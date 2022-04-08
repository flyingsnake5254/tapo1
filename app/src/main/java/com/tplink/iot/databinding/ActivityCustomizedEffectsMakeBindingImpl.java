package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devices.lightstrip.viewmodel.effects.CustomizedEffectsMakeViewModel;
import com.tplink.iot.devices.lightstrip.widget.DiscreteSeekBarTextView;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.MultiColorPaletteView;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.ItemSettingLayout;

/* loaded from: classes2.dex */
public class ActivityCustomizedEffectsMakeBindingImpl extends ActivityCustomizedEffectsMakeBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts I3 = null;
    @Nullable
    private static final SparseIntArray J3;
    @NonNull
    private final LinearLayout K3;
    private long L3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        J3 = sparseIntArray;
        sparseIntArray.put(R.id.rv_predefined_effects, 5);
        sparseIntArray.put(R.id.multi_color_picker, 6);
        sparseIntArray.put(R.id.dtv_colors, 7);
        sparseIntArray.put(R.id.seekBar_colors, 8);
        sparseIntArray.put(R.id.seekBar_anim_speed, 9);
        sparseIntArray.put(R.id.brightness_seek_bar, 10);
    }

    public ActivityCustomizedEffectsMakeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, I3, J3));
    }

    private boolean l(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L3 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.L3;
            this.L3 = 0L;
        }
        View.OnClickListener onClickListener = this.p3;
        CustomizedEffectsMakeViewModel customizedEffectsMakeViewModel = this.H3;
        int i = ((10 & j) > 0L ? 1 : ((10 & j) == 0L ? 0 : -1));
        String str = null;
        int i2 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
        if (i2 != 0) {
            LiveData<String> n = customizedEffectsMakeViewModel != null ? customizedEffectsMakeViewModel.n() : null;
            updateLiveDataRegistration(0, n);
            if (n != null) {
                str = n.getValue();
            }
        }
        if (i != 0) {
            this.f6531d.setOnClickListener(onClickListener);
            this.f6532f.setOnClickListener(onClickListener);
            this.x.setOnClickListener(onClickListener);
            this.p2.setOnClickListener(onClickListener);
        }
        if (i2 != 0) {
            a.f(this.x, str);
        }
    }

    @Override // com.tplink.iot.databinding.ActivityCustomizedEffectsMakeBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.p3 = onClickListener;
        synchronized (this) {
            this.L3 |= 2;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.L3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityCustomizedEffectsMakeBinding
    public void i(@Nullable CustomizedEffectsMakeViewModel customizedEffectsMakeViewModel) {
        this.H3 = customizedEffectsMakeViewModel;
        synchronized (this) {
            this.L3 |= 4;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.L3 = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((LiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (69 == i) {
            h((View.OnClickListener) obj);
        } else if (103 != i) {
            return false;
        } else {
            i((CustomizedEffectsMakeViewModel) obj);
        }
        return true;
    }

    private ActivityCustomizedEffectsMakeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (BrightnessSeekBar) objArr[10], (Button) objArr[4], (Button) objArr[3], (DiscreteSeekBarTextView) objArr[7], (ItemSettingLayout) objArr[1], (MultiColorPaletteView) objArr[6], (RecyclerView) objArr[5], (SeekBar) objArr[9], (SeekBar) objArr[8], (TextView) objArr[2]);
        this.L3 = -1L;
        this.f6531d.setTag(null);
        this.f6532f.setTag(null);
        this.x.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.K3 = linearLayout;
        linearLayout.setTag(null);
        this.p2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
