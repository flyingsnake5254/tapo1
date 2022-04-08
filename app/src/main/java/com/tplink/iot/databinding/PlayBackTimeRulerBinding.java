package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

/* loaded from: classes2.dex */
public abstract class PlayBackTimeRulerBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7340c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7341d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TimeAxisLayout f7342f;
    @Bindable
    protected PlayBackControlViewModel q;
    @Bindable
    protected g x;
    @Bindable
    protected TimeAxisLayout.b y;

    /* JADX INFO: Access modifiers changed from: protected */
    public PlayBackTimeRulerBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TimeAxisLayout timeAxisLayout) {
        super(obj, view, i);
        this.f7340c = imageView;
        this.f7341d = textView;
        this.f7342f = timeAxisLayout;
    }

    public abstract void h(@Nullable g gVar);

    public abstract void i(@Nullable TimeAxisLayout.b bVar);

    public abstract void l(@Nullable PlayBackControlViewModel playBackControlViewModel);
}
