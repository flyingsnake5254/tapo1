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
import com.tplink.iot.devicecommon.widget.VariousImageViewLayout;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentSubgEnablePairingModeBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f7093c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7094d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final VariousImageViewLayout f7095f;
    @NonNull
    public final TextView p0;
    @Bindable
    protected SubGViewModel p1;
    @Bindable
    protected g p2;
    @NonNull
    public final RelativeLayout q;
    @NonNull
    public final LinearLayout x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSubgEnablePairingModeBinding(Object obj, View view, int i, Button button, ImageView imageView, VariousImageViewLayout variousImageViewLayout, RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7093c = button;
        this.f7094d = imageView;
        this.f7095f = variousImageViewLayout;
        this.q = relativeLayout;
        this.x = linearLayout;
        this.y = textView;
        this.z = textView2;
        this.p0 = textView3;
    }
}
