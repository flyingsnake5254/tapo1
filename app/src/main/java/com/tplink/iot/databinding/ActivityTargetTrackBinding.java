package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.targettrack.TargetTrackViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

/* loaded from: classes2.dex */
public abstract class ActivityTargetTrackBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f6723c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6724d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CheckBox f6725f;
    @NonNull
    public final NoninteractiveCheckBox q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @Bindable
    protected TargetTrackViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTargetTrackBinding(Object obj, View view, int i, RelativeLayout relativeLayout, TextView textView, CheckBox checkBox, NoninteractiveCheckBox noninteractiveCheckBox, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f6723c = relativeLayout;
        this.f6724d = textView;
        this.f6725f = checkBox;
        this.q = noninteractiveCheckBox;
        this.x = textView2;
        this.y = textView3;
    }

    public abstract void h(@Nullable TargetTrackViewModel targetTrackViewModel);
}
