package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.StoreManageViewModel;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;

/* loaded from: classes2.dex */
public abstract class DialogFormatProcessBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TPCircleProgressBar f6771c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    protected StoreManageViewModel f6772d;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogFormatProcessBinding(Object obj, View view, int i, TPCircleProgressBar tPCircleProgressBar) {
        super(obj, view, i);
        this.f6771c = tPCircleProgressBar;
    }

    public abstract void h(@Nullable StoreManageViewModel storeManageViewModel);
}
