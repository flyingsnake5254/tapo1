package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public abstract class FragmentSubGSetupLocationSelectBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TPRefreshableButton f7087c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f7088d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7089f;
    @Bindable
    protected SubGViewModel p0;
    @Bindable
    protected g p1;
    @NonNull
    public final LinearLayout q;
    @NonNull
    public final View x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSubGSetupLocationSelectBinding(Object obj, View view, int i, TPRefreshableButton tPRefreshableButton, RecyclerView recyclerView, ImageView imageView, LinearLayout linearLayout, View view2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7087c = tPRefreshableButton;
        this.f7088d = recyclerView;
        this.f7089f = imageView;
        this.q = linearLayout;
        this.x = view2;
        this.y = textView;
        this.z = textView2;
    }
}
