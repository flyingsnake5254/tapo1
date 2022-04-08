package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraRoomSelectViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2RoomSelectBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f6936c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f6937d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6938f;
    @Bindable
    protected g p0;
    @NonNull
    public final Button q;
    @NonNull
    public final Toolbar x;
    @Bindable
    protected CameraRoomSelectViewModel y;
    @Bindable
    protected CameraOnBoardingViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2RoomSelectBinding(Object obj, View view, int i, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView, Button button, Toolbar toolbar) {
        super(obj, view, i);
        this.f6936c = relativeLayout;
        this.f6937d = recyclerView;
        this.f6938f = textView;
        this.q = button;
        this.x = toolbar;
    }
}
