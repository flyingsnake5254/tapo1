package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;

/* loaded from: classes2.dex */
public abstract class ActivityWhiteLampConfigBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final SeekBar f6768c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6769d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6770f;
    @NonNull
    public final LinearLayout p0;
    @NonNull
    public final RelativeLayout p1;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final CameraLoadingView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityWhiteLampConfigBinding(Object obj, View view, int i, SeekBar seekBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, CameraLoadingView cameraLoadingView, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f6768c = seekBar;
        this.f6769d = textView;
        this.f6770f = textView2;
        this.q = textView3;
        this.x = textView4;
        this.y = textView5;
        this.z = cameraLoadingView;
        this.p0 = linearLayout;
        this.p1 = relativeLayout;
    }
}
