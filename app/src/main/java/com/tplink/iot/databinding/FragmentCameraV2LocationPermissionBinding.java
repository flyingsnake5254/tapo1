package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2LocationPermissionBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6906c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6907d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6908f;
    @Bindable
    protected g q;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2LocationPermissionBinding(Object obj, View view, int i, Button button, ImageView imageView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f6906c = button;
        this.f6907d = imageView;
        this.f6908f = linearLayout;
    }
}
