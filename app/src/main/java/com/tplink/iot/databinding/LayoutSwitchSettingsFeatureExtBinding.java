package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.switches.viewmodel.SwitchSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;

/* loaded from: classes2.dex */
public abstract class LayoutSwitchSettingsFeatureExtBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ItemSettingLayout f7301c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ItemSettingLayout f7302d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ItemSettingLayout f7303f;
    @Bindable
    protected View.OnClickListener q;
    @Bindable
    protected SwitchSettingsViewModel x;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutSwitchSettingsFeatureExtBinding(Object obj, View view, int i, ItemSettingLayout itemSettingLayout, ItemSettingLayout itemSettingLayout2, ItemSettingLayout itemSettingLayout3) {
        super(obj, view, i);
        this.f7301c = itemSettingLayout;
        this.f7302d = itemSettingLayout2;
        this.f7303f = itemSettingLayout3;
    }
}
