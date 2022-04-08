package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraRoomCustomViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2RoomCustomBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f6933c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DrawableEditText f6934d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final FlowTagLayout f6935f;
    @Bindable
    protected CameraOnBoardingViewModel p0;
    @Bindable
    protected g p1;
    @NonNull
    public final Button q;
    @NonNull
    public final Toolbar x;
    @NonNull
    public final TextView y;
    @Bindable
    protected CameraRoomCustomViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2RoomCustomBinding(Object obj, View view, int i, RelativeLayout relativeLayout, DrawableEditText drawableEditText, FlowTagLayout flowTagLayout, Button button, Toolbar toolbar, TextView textView) {
        super(obj, view, i);
        this.f6933c = relativeLayout;
        this.f6934d = drawableEditText;
        this.f6935f = flowTagLayout;
        this.q = button;
        this.x = toolbar;
        this.y = textView;
    }
}
