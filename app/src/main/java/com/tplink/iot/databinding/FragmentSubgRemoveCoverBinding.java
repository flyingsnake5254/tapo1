package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentSubgRemoveCoverBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f7102c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7103d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7104f;
    @Bindable
    protected SubGViewModel p0;
    @Bindable
    protected g p1;
    @NonNull
    public final RelativeLayout q;
    @NonNull
    public final LinearLayout x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSubgRemoveCoverBinding(Object obj, View view, int i, Button button, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7102c = button;
        this.f7103d = imageView;
        this.f7104f = imageView2;
        this.q = relativeLayout;
        this.x = linearLayout;
        this.y = textView;
        this.z = textView2;
    }
}
