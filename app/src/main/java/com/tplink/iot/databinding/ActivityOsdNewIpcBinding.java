package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.OsdViewModel;
import com.tplink.iot.widget.ErrorBar;

/* loaded from: classes2.dex */
public abstract class ActivityOsdNewIpcBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener H3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f6636c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CameraLoadingView f6637d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ErrorBar f6638f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final Toolbar p1;
    @NonNull
    public final TextView p2;
    @Bindable
    protected OsdViewModel p3;
    @NonNull
    public final TextView q;
    @NonNull
    public final CheckBox x;
    @NonNull
    public final CheckBox y;
    @NonNull
    public final CheckBox z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityOsdNewIpcBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, CameraLoadingView cameraLoadingView, ErrorBar errorBar, TextView textView, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, TextView textView2, Toolbar toolbar, TextView textView3) {
        super(obj, view, i);
        this.f6636c = constraintLayout;
        this.f6637d = cameraLoadingView;
        this.f6638f = errorBar;
        this.q = textView;
        this.x = checkBox;
        this.y = checkBox2;
        this.z = checkBox3;
        this.p0 = textView2;
        this.p1 = toolbar;
        this.p2 = textView3;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable OsdViewModel osdViewModel);
}
