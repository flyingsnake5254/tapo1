package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.switches.viewmodel.SwitchDetailViewModel;
import com.tplink.iot.widget.DiffuseViewV2;

/* loaded from: classes2.dex */
public abstract class LayoutSwitchDetailContentExtBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DiffuseViewV2 f7298c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7299d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f7300f;
    @Bindable
    protected View.OnClickListener p0;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @Bindable
    protected SwitchDetailViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutSwitchDetailContentExtBinding(Object obj, View view, int i, DiffuseViewV2 diffuseViewV2, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7298c = diffuseViewV2;
        this.f7299d = imageView;
        this.f7300f = linearLayout;
        this.q = textView;
        this.x = textView2;
        this.y = textView3;
    }
}
