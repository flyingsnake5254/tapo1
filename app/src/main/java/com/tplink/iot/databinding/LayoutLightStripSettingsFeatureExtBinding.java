package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.viewgroup.ItemInfoLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

/* loaded from: classes2.dex */
public abstract class LayoutLightStripSettingsFeatureExtBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ItemSettingLayout f7259c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7260d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f7261f;
    @NonNull
    public final ItemInfoLayout q;
    @NonNull
    public final TPSwitchCompat x;
    @Bindable
    protected View.OnClickListener y;
    @Bindable
    protected LightStripSettingsViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutLightStripSettingsFeatureExtBinding(Object obj, View view, int i, ItemSettingLayout itemSettingLayout, TextView textView, RelativeLayout relativeLayout, ItemInfoLayout itemInfoLayout, TPSwitchCompat tPSwitchCompat) {
        super(obj, view, i);
        this.f7259c = itemSettingLayout;
        this.f7260d = textView;
        this.f7261f = relativeLayout;
        this.q = itemInfoLayout;
        this.x = tPSwitchCompat;
    }
}
