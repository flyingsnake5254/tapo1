package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;

/* loaded from: classes2.dex */
public abstract class FragmentSwitchQuicksetupGuideBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f7108c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7109d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7110f;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @Bindable
    protected g y;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSwitchQuicksetupGuideBinding(Object obj, View view, int i, Button button, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7108c = button;
        this.f7109d = imageView;
        this.f7110f = imageView2;
        this.q = textView;
        this.x = textView2;
    }
}
