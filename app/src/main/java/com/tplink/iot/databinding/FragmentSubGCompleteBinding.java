package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public abstract class FragmentSubGCompleteBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f7060c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7061d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f7062f;
    @Bindable
    protected SubGViewModel p0;
    @Bindable
    protected g p1;
    @NonNull
    public final TPRefreshableButton q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSubGCompleteBinding(Object obj, View view, int i, Button button, ImageView imageView, LinearLayout linearLayout, TPRefreshableButton tPRefreshableButton, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7060c = button;
        this.f7061d = imageView;
        this.f7062f = linearLayout;
        this.q = tPRefreshableButton;
        this.x = textView;
        this.y = textView2;
        this.z = textView3;
    }
}
