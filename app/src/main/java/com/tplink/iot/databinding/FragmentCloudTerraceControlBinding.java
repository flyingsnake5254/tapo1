package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentCloudTerraceControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f6972c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6973d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6974f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final TextView p1;
    @Bindable
    protected CloudTerraceControlViewModel p2;
    @Bindable
    protected Boolean p3;
    @NonNull
    public final CameraLoadingView q;
    @NonNull
    public final ImageView x;
    @NonNull
    public final CloudTerraceControlPanel y;
    @NonNull
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCloudTerraceControlBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, CameraLoadingView cameraLoadingView, ImageView imageView3, CloudTerraceControlPanel cloudTerraceControlPanel, ImageView imageView4, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6972c = constraintLayout;
        this.f6973d = imageView;
        this.f6974f = imageView2;
        this.q = cameraLoadingView;
        this.x = imageView3;
        this.y = cloudTerraceControlPanel;
        this.z = imageView4;
        this.p0 = textView;
        this.p1 = textView2;
    }

    public abstract void h(@Nullable CloudTerraceControlViewModel cloudTerraceControlViewModel);

    public abstract void i(@Nullable Boolean bool);
}
