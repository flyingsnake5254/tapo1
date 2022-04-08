package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.viewmodel.ipcamera.setting.LocateSettingViewModel;
import com.tplink.iot.widget.ErrorBar;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public abstract class ActivitySetLocationBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6690c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f6691d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ErrorBar f6692f;
    @Bindable
    protected LocateSettingViewModel p0;
    @Bindable
    protected View.OnClickListener p1;
    @NonNull
    public final RecyclerView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TPRefreshableButton z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySetLocationBinding(Object obj, View view, int i, ImageView imageView, Toolbar toolbar, ErrorBar errorBar, RecyclerView recyclerView, TextView textView, TextView textView2, TPRefreshableButton tPRefreshableButton) {
        super(obj, view, i);
        this.f6690c = imageView;
        this.f6691d = toolbar;
        this.f6692f = errorBar;
        this.q = recyclerView;
        this.x = textView;
        this.y = textView2;
        this.z = tPRefreshableButton;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);
}
