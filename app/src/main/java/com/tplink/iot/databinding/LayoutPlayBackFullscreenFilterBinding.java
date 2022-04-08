package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

/* loaded from: classes2.dex */
public abstract class LayoutPlayBackFullscreenFilterBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CheckBox f7277c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CheckBox f7278d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7279f;
    @Bindable
    protected g q;
    @Bindable
    protected PlayBackControlViewModel x;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutPlayBackFullscreenFilterBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2, TextView textView) {
        super(obj, view, i);
        this.f7277c = checkBox;
        this.f7278d = checkBox2;
        this.f7279f = textView;
    }

    public abstract void h(@Nullable g gVar);

    public abstract void i(@Nullable PlayBackControlViewModel playBackControlViewModel);
}
