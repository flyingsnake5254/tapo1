package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.ItemSettingLayout;

/* loaded from: classes2.dex */
public abstract class LayoutTrvOneSelectSettingsBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ItemSettingLayout f7313c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7314d;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutTrvOneSelectSettingsBinding(Object obj, View view, int i, ItemSettingLayout itemSettingLayout, TextView textView) {
        super(obj, view, i);
        this.f7313c = itemSettingLayout;
        this.f7314d = textView;
    }
}
