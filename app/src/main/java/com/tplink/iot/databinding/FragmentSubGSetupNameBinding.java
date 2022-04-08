package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public abstract class FragmentSubGSetupNameBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f7090c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DrawableEditText f7091d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7092f;
    @Bindable
    protected g p0;
    @NonNull
    public final RelativeLayout q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @Bindable
    protected SubGViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSubGSetupNameBinding(Object obj, View view, int i, Button button, DrawableEditText drawableEditText, ImageView imageView, RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7090c = button;
        this.f7091d = drawableEditText;
        this.f7092f = imageView;
        this.q = relativeLayout;
        this.x = textView;
        this.y = textView2;
    }
}
