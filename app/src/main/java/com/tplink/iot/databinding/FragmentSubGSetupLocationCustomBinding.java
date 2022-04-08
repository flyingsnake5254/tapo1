package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public abstract class FragmentSubGSetupLocationCustomBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TPRefreshableButton f7084c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DrawableEditText f7085d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final FlowTagLayout f7086f;
    @NonNull
    public final TextView p0;
    @Bindable
    protected SubGViewModel p1;
    @Bindable
    protected g p2;
    @NonNull
    public final ImageView q;
    @NonNull
    public final LinearLayout x;
    @NonNull
    public final LinearLayout y;
    @NonNull
    public final View z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSubGSetupLocationCustomBinding(Object obj, View view, int i, TPRefreshableButton tPRefreshableButton, DrawableEditText drawableEditText, FlowTagLayout flowTagLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, View view2, TextView textView) {
        super(obj, view, i);
        this.f7084c = tPRefreshableButton;
        this.f7085d = drawableEditText;
        this.f7086f = flowTagLayout;
        this.q = imageView;
        this.x = linearLayout;
        this.y = linearLayout2;
        this.z = view2;
        this.p0 = textView;
    }
}
